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
public class EstacaoTrabalhoDAO {

    private static EstacaoTrabalhoDAO instance;

    private EstacaoTrabalhoDAO() {
        MySQLDAO.getConnection();
    }

    public static EstacaoTrabalhoDAO getInstance() {
        
        if (instance == null) {
            instance = new EstacaoTrabalhoDAO();
        }
        return instance;
    }

    public long create(EstacaoTrabalhoBEAN estacaoTrabalho) {
        String query = "INSERT INTO estacao_trabalho (descricaoEstacaoTrabalho, monitor_idEquipamento, cpu_idEquipamento,"
                + " mouseTeclado_idEquipamento) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, estacaoTrabalho.getDescricaoEstacaoTrabalho(), estacaoTrabalho.getMonitor_idEquipamento(),
                estacaoTrabalho.getCpu_idEquipamento(), estacaoTrabalho.getMouseTeclado_idEquipamento());
    }

    public void update(EstacaoTrabalhoBEAN estacaoTrabalho) {
        String query = "UPDATE estacao_trabalho SET descricaoEstacaoTrabalho=?, monitor_idEquipamento=?, cpu_idEquipamento=?, mouseTeclado_idEquipamento=?"
                + " WHERE idEstacaoTrabalho=?";
        MySQLDAO.executeQuery(query, estacaoTrabalho.getDescricaoEstacaoTrabalho(), estacaoTrabalho.getMonitor_idEquipamento(), 
                estacaoTrabalho.getCpu_idEquipamento(), estacaoTrabalho.getMouseTeclado_idEquipamento(), estacaoTrabalho.getIdEstacaoTrabalho());

    }

    /*
    public void ativarEstacaoTrabalho(EstacaoTrabalhoBEAN estacaoTrabalho) {
        MySQLDAO.executeQuery("UPDATE estacao_trabalho SET statusLaboratorio = 1 WHERE idLaboratorio = ?", laboratorio.getIdLaboratorio());
    }
    
    public void inativarEstacaoTrabalho(EstacaoTrabalhoBEAN estacaoTrabalho) {
        MySQLDAO.executeQuery("UPDATE laboratorio SET statusLaboratorio = 0 WHERE idLaboratorio = ?", laboratorio.getIdLaboratorio());
    }*/

    public ArrayList<EstacaoTrabalhoBEAN> buscaTodosEstacaoTrabalho() {
        return listaEstacaoTrabalho("SELECT * FROM estacao_trabalho ORDER BY idEstacaoTrabalho");
    }

    public ArrayList<EstacaoTrabalhoBEAN> listaEstacaoTrabalho(String query) {
        
        ArrayList<EstacaoTrabalhoBEAN> lista = new ArrayList<EstacaoTrabalhoBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        
        try {
            while (rs.next()) {
                lista.add(new EstacaoTrabalhoBEAN(rs.getInt("idEstacaoTrabalho"), rs.getString("descricaoEstacaoTrabalho"),
                    rs.getInt("monitor_idEquipamento"), rs.getInt("cpu_idEquipamento"), rs.getInt("mouseTeclado_idEquipamento")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public EstacaoTrabalhoBEAN buscaEstacaoTrabalho(int id) {
        
        EstacaoTrabalhoBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM estacao_trabalho WHERE idEstacaoTrabalho=?", id);
        
        try {
            if (rs.next()) {
                result = new EstacaoTrabalhoBEAN(rs.getInt("idEstacaoTrabalho"), rs.getString("descricaoEstacaoTrabalho"),
                    rs.getInt("monitor_idEquipamento"), rs.getInt("cpu_idEquipamento"), rs.getInt("mouseTeclado_idEquipamento"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int buscaID(EstacaoTrabalhoBEAN estacaoTrabalho) {
        
        int result = 0;
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet(
                "SELECT * FROM estacao_trabalho WHERE descricaoEstacaoTrabalho=? AND monitor_idEquipamento=? AND cpu_idEquipamento =? AND"
                        + " mouseTeclado_idEquipamento =?", estacaoTrabalho.getDescricaoEstacaoTrabalho(),
                        estacaoTrabalho.getMonitor_idEquipamento(), estacaoTrabalho.getCpu_idEquipamento(),
                        estacaoTrabalho.getMouseTeclado_idEquipamento());
        try {
            if (rs.next()) {
                result = rs.getInt("idEstacaoTrabalho");
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
        rs = MySQLDAO.getResultSet("SELECT * FROM estacao_trabalho WHERE idEstacaoTrabalho= ?", id);
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
    
    public ArrayList<EstacaoTrabalhoBEAN> listaEstacaoTrabalhoNome(EstacaoTrabalhoBEAN estacaoTrabalho){
        
        ArrayList<EstacaoTrabalhoBEAN> lista = new ArrayList<EstacaoTrabalhoBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM estacao_trabalho WHERE descricaoEstacaoTrabalho LIKE '%" + estacaoTrabalho.getDescricaoEstacaoTrabalho() + "%'");
        try {
            while (rs.next()) {
                lista.add(new EstacaoTrabalhoBEAN(rs.getInt("idEstacaoTrabalho"), 
                                            rs.getString("descricaoEstacaoTrabalho"), 
                                            rs.getInt("monitor_idEquipamento"),
                                            rs.getInt("cpu_idEquipamento"),
                                            rs.getInt("mouseTeclado_idEquipamento")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public EstacaoTrabalhoBEAN EstacaoTrabalhoPeloNome(String estacaoTrabalho){
        
        EstacaoTrabalhoBEAN lista = new EstacaoTrabalhoBEAN();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM estacao_trabalho WHERE descricaoEstacaoTrabalho LIKE '%" + estacaoTrabalho + "%'");
        try {
            while (rs.next()) {
                new EstacaoTrabalhoBEAN(rs.getInt("idEstacaoTrabalho"), 
                                            rs.getString("descricaoEstacaoTrabalho"), 
                                            rs.getInt("monitor_idEquipamento"),
                                            rs.getInt("cpu_idEquipamento"),
                                            rs.getInt("mouseTeclado_idEquipamento"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
