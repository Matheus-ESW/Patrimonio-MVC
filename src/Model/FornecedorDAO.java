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
public class FornecedorDAO {

    private static FornecedorDAO instance;

    private FornecedorDAO() {
        MySQLDAO.getConnection();
    }

    public static FornecedorDAO getInstance() {
        if (instance == null) {
            instance = new FornecedorDAO();
        }
        return instance;
    }

    public long create(FornecedorBEAN fornecedor) {
        String query = "INSERT INTO fornecedor (razaoSocial, statusFornecedor) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, fornecedor.getRazaoSocial(), fornecedor.getStatusFornecedor());
    }

    public void update(FornecedorBEAN fornecedor) {
        String query = "UPDATE fornecedor SET razaoSocial=?, statusFornecedor=? WHERE idFornecedor=?";
        MySQLDAO.executeQuery(query, fornecedor.getRazaoSocial(), fornecedor.getStatusFornecedor(), fornecedor.getIdFornecedor());

    }

    public void ativarFornecedor(FornecedorBEAN fornecedor) {
        MySQLDAO.executeQuery("UPDATE fornecedor SET statusFornecedor = 1 WHERE idFornecedor = ?", fornecedor.getIdFornecedor());
    }
    
    public void inativarFornecedor(FornecedorBEAN fornecedor) {
        MySQLDAO.executeQuery("UPDATE fornecedor SET statusFornecedor = 0 WHERE idFornecedor = ?", fornecedor.getIdFornecedor());
    }
    
    public ArrayList<FornecedorBEAN> buscaTodosFornecedores() {
        return listaFornecedores("SELECT * FROM fornecedor ORDER BY idFornecedor");
    }

    public ArrayList<FornecedorBEAN> listaFornecedores(String query) {
        
        ArrayList<FornecedorBEAN> lista = new ArrayList<FornecedorBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        
        try {
            while (rs.next()) {
                lista.add(new FornecedorBEAN(rs.getInt("idFornecedor"), rs.getString("razaoSocial"), rs.getString("statusFornecedor")));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public FornecedorBEAN buscarFornecedor(int id) {
        
        FornecedorBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM fornecedor WHERE idFornecedor=?", id);
        
        try {
            if (rs.next()) {
                result = new FornecedorBEAN(rs.getInt("idFornecedor"), rs.getString("razaoSocial"), rs.getString("statusFornecedor"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int buscarID(FornecedorBEAN fornecedor) {
        
        int result = 0;
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet(
                "SELECT * FROM fornecedor WHERE razaoSocial=? AND statusFornecedor=?", fornecedor.getRazaoSocial(), fornecedor.getStatusFornecedor());
        try {
            if (rs.next()) {
                result = rs.getInt("idFornecedor");
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
        rs = MySQLDAO.getResultSet("SELECT * FROM fornecedor WHERE idFornecedor=?", id);
        
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
    
    public ArrayList<FornecedorBEAN> listaFornecedorNome(FornecedorBEAN fornecedor){
        
        ArrayList<FornecedorBEAN> lista = new ArrayList<FornecedorBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM fornecedor WHERE razaoSocial LIKE '%" + fornecedor.getRazaoSocial() + "%'");
        try {
            while (rs.next()) {
                lista.add(new FornecedorBEAN(rs.getInt("idFornecedor"), 
                                            rs.getString("razaoSocial"), 
                                            rs.getString("statusFornecedor")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public FornecedorBEAN fornecedorDaCombo(FornecedorBEAN fornecedor){
        
        FornecedorBEAN lista = new FornecedorBEAN();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM fornecedor WHERE razaoSocial LIKE '%" + fornecedor.getRazaoSocial() + "%'");
        try {
            while (rs.next()) {
                lista = (new FornecedorBEAN(rs.getInt("idFornecedor"), 
                                            rs.getString("razaoSocial"), 
                                            rs.getString("statusFornecedor")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public FornecedorBEAN fornecedorPeloNome(String fornecedor){
        
        FornecedorBEAN lista = new FornecedorBEAN();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM fornecedor WHERE razaoSocial LIKE '%" + fornecedor + "%'");
        try {
            while (rs.next()) {
                lista = (new FornecedorBEAN(rs.getInt("idFornecedor"), 
                                            rs.getString("razaoSocial"), 
                                            rs.getString("statusFornecedor")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<FornecedorBEAN> listaFornecedoresInativos(){
        
        ArrayList<FornecedorBEAN> lista = new ArrayList<FornecedorBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM fornecedor WHERE statusFornecedor = 0");
        try {
            while (rs.next()) {
                lista.add(new FornecedorBEAN(rs.getInt("idFornecedor"), 
                                            rs.getString("razaoSocial"), 
                                            rs.getString("statusFornecedor")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
