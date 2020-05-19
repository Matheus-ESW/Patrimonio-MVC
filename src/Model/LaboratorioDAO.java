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
public class LaboratorioDAO {

    private static LaboratorioDAO instance;

    private LaboratorioDAO() {
        MySQLDAO.getConnection();
    }

    public static LaboratorioDAO getInstance() {
        if (instance == null) {
            instance = new LaboratorioDAO();
        }
        return instance;
    }

    public long create(LaboratorioBEAN laboratorio) {
        String query = "INSERT INTO laboratorio (descricaoLaboratorio, numeroEquipamento, statusLaboratorio, localizacao_idLocalizacao)"
                + " VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, laboratorio.getDescricaoLaboratorio(), laboratorio.getNumeroEquipamento(),
                laboratorio.getStatusLaboratorio(), laboratorio.getLocalizacao_idLocalizacao());
    }

    public void update(LaboratorioBEAN laboratorio) {
        String query = "UPDATE laboratorio SET descricaoLaboratorio=?, numeroEquipamento=?, statusLaboratorio=?, localizacao_idLocalizacao=?"
                + "WHERE idLaboratorio=?";
        MySQLDAO.executeQuery(query, laboratorio.getDescricaoLaboratorio(), laboratorio.getNumeroEquipamento(),
                laboratorio.getStatusLaboratorio(), laboratorio.getLocalizacao_idLocalizacao());

    }

    public void ativarLaboratorio(LaboratorioBEAN laboratorio) {
        MySQLDAO.executeQuery("UPDATE laboratorio SET statusLaboratorio = 1 WHERE idLaboratorio = ?", laboratorio.getIdLaboratorio());
    }
    
    public void inativarLaboratorio(LaboratorioBEAN laboratorio) {
        MySQLDAO.executeQuery("UPDATE laboratorio SET statusLaboratorio = 0 WHERE idLaboratorio = ?", laboratorio.getIdLaboratorio());
    }

    public ArrayList<LaboratorioBEAN> buscaTodosLaboratorios() {
        return listaLaboratorios("SELECT * FROM laboratorio ORDER BY idLaboratorio");
    }

    public ArrayList<LaboratorioBEAN> listaLaboratorios(String query) {
        
        ArrayList<LaboratorioBEAN> lista = new ArrayList<LaboratorioBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        
        try {
            while (rs.next()) {
                lista.add(new LaboratorioBEAN(rs.getInt("idLaboratorio"), rs.getString("descricaoLaboratorio"),
                    rs.getInt("numeroEquipamento"), rs.getString("statusLaboratorio"), rs.getInt("localizacao_idLocalizacao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public LaboratorioBEAN buscaLaboratorio(int id) {
        
        LaboratorioBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM laboratorio WHERE idLaboratorio=?", id);
        
        try {
            if (rs.next()) {
                result = new LaboratorioBEAN(rs.getInt("idLaboratorio"), rs.getString("descricaoLaboratorio"), rs.getInt("numeroEquipamento"), rs.getString("statusLaboratorio"), rs.getInt("localizacao_idLocalizacao"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int buscaID(LaboratorioBEAN laboratorio) {
        
        int result = 0;
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet(
                "SELECT * FROM laboratorio WHERE descricaoLaboratorio=? AND numeroEquipamento=? AND statusLaboratorio =?"
                        + " AND localizacao_idLocalizacao=?", laboratorio.getDescricaoLaboratorio(), laboratorio.getNumeroEquipamento(),
                        laboratorio.getStatusLaboratorio(), laboratorio.getLocalizacao_idLocalizacao());
        try {
            if (rs.next()) {
                result = rs.getInt("idLaboratorio");
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
        rs = MySQLDAO.getResultSet("SELECT * FROM laboratorio WHERE idLaboratorio= ?", id);
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
    
    public ArrayList<LaboratorioBEAN> listaLaboratoriosInativos(){
        
        ArrayList<LaboratorioBEAN> lista = new ArrayList<LaboratorioBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM laboratorio WHERE statusLaboratorio = 0");
        try {
            while (rs.next()) {
                lista.add(new LaboratorioBEAN(rs.getInt("idLaboratorio"), 
                                            rs.getString("descricaoLaboratorio"), 
                                            rs.getInt("numeroEquipamento"),
                                            rs.getString("statusLaboratorio"),
                                            rs.getInt("localizacao_idLocalizacao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<LaboratorioBEAN> listaLaboratorioNome(LaboratorioBEAN laboratorio){
        
        ArrayList<LaboratorioBEAN> lista = new ArrayList<LaboratorioBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM laboratorio WHERE descricaoLaboratorio LIKE '%" + laboratorio.getDescricaoLaboratorio() + "%'");
        try {
            while (rs.next()) {
                lista.add(new LaboratorioBEAN(rs.getInt("idLaboratorio"), 
                                            rs.getString("descricaoLaboratorio"), 
                                            rs.getInt("numeroEquipamento"),
                                            rs.getString("statusLaboratorio"),
                                            rs.getInt("localizacao_idLocalizacao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
