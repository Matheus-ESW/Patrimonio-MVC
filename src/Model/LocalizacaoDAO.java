/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Matheus Ramos
 */
public class LocalizacaoDAO {
    
    private static LocalizacaoDAO instance;

    private LocalizacaoDAO() {
        MySQLDAO.getConnection();
    }

    public static LocalizacaoDAO getInstance() {
        if (instance == null) {
            instance = new LocalizacaoDAO();
        }
        return instance;
    }

    public long create(LocalizacaoBEAN localizacao) {
        String query = "INSERT INTO localizacao (descricaoLocalizacao, statusLocalizacao) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, localizacao.getDescricaoLocalizacao(), localizacao.getStatusLocalizacao());
    }

    public void update(LocalizacaoBEAN localizacao) {
        String query = "UPDATE localizacao SET descricaoLocalizacao=?, statusLocalizacao=? WHERE idLocalizacao=?";
        MySQLDAO.executeQuery(query, localizacao.getDescricaoLocalizacao(), localizacao.getStatusLocalizacao(),
            localizacao.getIdLocalizacao());

    }

    public void ativarLocalizacao(LocalizacaoBEAN localizacao) {
        MySQLDAO.executeQuery("UPDATE localizacao SET statusLocalizacao = 1 WHERE idLocalizacao = ?", localizacao.getIdLocalizacao());
    }
    
    public void inativarLocalizacao(LocalizacaoBEAN localizacao) {
        MySQLDAO.executeQuery("UPDATE localizacao SET statusLocalizacao = 0 WHERE idLocalizacao = ?", localizacao.getIdLocalizacao());
    }
    
    public ArrayList<LocalizacaoBEAN> buscaTodasLocalizacoes() {
        return listaLocalizacoes("SELECT * FROM localizacao ORDER BY idLocalizacao");
    }

    public ArrayList<LocalizacaoBEAN> listaLocalizacoes(String query) {
        
        ArrayList<LocalizacaoBEAN> lista = new ArrayList<LocalizacaoBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        
        try {
            while (rs.next()) {
                lista.add(new LocalizacaoBEAN(rs.getInt("idLocalizacao"), rs.getString("descricaoLocalizacao"),
                    rs.getString("statusLocalizacao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public LocalizacaoBEAN buscarLocalizacao(int id) {
        
        LocalizacaoBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM localizacao WHERE idLocalizacao=?", id);
        
        try {
            if (rs.next()) {
                result = new LocalizacaoBEAN(rs.getInt("idLocalizacao"), rs.getString("descricaoLocalizacao"),
                    rs.getString("statusLocalizacao"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int buscarID(LocalizacaoBEAN localizacao) {
        
        int result = 0;
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet(
                "SELECT * FROM localizacao WHERE descricaoLocalizacao=? AND statusLocalizacao=?", localizacao.getDescricaoLocalizacao(),
                localizacao.getStatusLocalizacao());
        try {
            if (rs.next()) {
                result = rs.getInt("idLocalizacao");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int id) {
        
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM localizacao WHERE idLocalizacao=?", id);
        
        try {
            if (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<LocalizacaoBEAN> listaLocalizacaoNome(LocalizacaoBEAN localizacao){
        
        ArrayList<LocalizacaoBEAN> lista = new ArrayList<LocalizacaoBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM localizacao WHERE descricaoLocalizacao LIKE '%" + localizacao.getDescricaoLocalizacao()+ "%'");
        try {
            while (rs.next()) {
                lista.add(new LocalizacaoBEAN(rs.getInt("idLocalizacao"), 
                                            rs.getString("descricaoLocalizacao"), 
                                            rs.getString("statusLocalizacao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<LocalizacaoBEAN> listaLocalizacaoesInativas(){
        
        ArrayList<LocalizacaoBEAN> lista = new ArrayList<LocalizacaoBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM localizacao WHERE statusLocalizacao = 0");
        try {
            while (rs.next()) {
                lista.add(new LocalizacaoBEAN(rs.getInt("idLocalizacao"), 
                                            rs.getString("descricaoLocalizacao"), 
                                            rs.getString("statusLocalizacao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }
}
