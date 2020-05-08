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
public class EquipamentoDAO {

    private static EquipamentoDAO instance;

    private EquipamentoDAO() {
        MySQLDAO.getConnection();
    }

    public static EquipamentoDAO getInstance() {
        if (instance == null) {
            instance = new EquipamentoDAO();
        }
        return instance;
    }

    public long create(EquipamentoBEAN equipamento) {
        String query = "INSERT INTO equipamento (tipoEquipamento, descricaoEquipamento, statusEquipamento, fornecedor_idFornecedor)"
                + " VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, equipamento.getTipoEquipamento(), equipamento.getDescricaoEquipamento(),
                equipamento.getStatusEquipamento(), equipamento.getFornecedor_idFornecedor());
    }

    public void update(EquipamentoBEAN equipamento) {
        String query = "UPDATE equipamento SET tipoEquipamento=?, descricaoEquipamento=?, statusEquipamento=?, fornecedor_idFornecedor=?"
                + " WHERE idEquipamento=?";
        MySQLDAO.executeQuery(query, equipamento.getTipoEquipamento(), equipamento.getDescricaoEquipamento(),
                equipamento.getStatusEquipamento(), equipamento.getFornecedor_idFornecedor(), equipamento.getIdEquipamento());

    }

    public void ativarEquipamento(EquipamentoBEAN equipamento) {
        MySQLDAO.executeQuery("UPDATE equipamento SET statusEquipamento = 1 WHERE idEquipamento = ?", equipamento.getIdEquipamento());
    }
    
    public void inativarEquipamento(EquipamentoBEAN equipamento) {
        MySQLDAO.executeQuery("UPDATE equipamento SET statusEquipamento = 0 WHERE idEquipamento = ?", equipamento.getIdEquipamento());
    }

    public ArrayList<EquipamentoBEAN> buscaTodosEquipamentos() {
        return listaEquipamentos("SELECT * FROM equipamento ORDER BY idEquipamento");
    }

    public ArrayList<EquipamentoBEAN> listaEquipamentos(String query) {
        
        ArrayList<EquipamentoBEAN> lista = new ArrayList<EquipamentoBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        
        try {
            while (rs.next()) {
                lista.add(new EquipamentoBEAN(rs.getInt("idEquipamento"), rs.getString("tipoEquipamento"),
                    rs.getString("descricaoEquipamento"), rs.getString("statusEquipamento"), rs.getInt("fornecedor_idFornecedor")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public EquipamentoBEAN buscarEquipamento(int id) {
        
        EquipamentoBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM equipamento WHERE idEquipamento=?", id);
        
        try {
            if (rs.next()) {
                result = new EquipamentoBEAN(rs.getInt("idEquipamento"), rs.getString("tipoEquipamento"),
                    rs.getString("descricaoEquipamento"), rs.getString("statusEquipamento"), rs.getInt("fornecedor_idFornecedor"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int buscarID(EquipamentoBEAN equipamento) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(
                "SELECT * FROM equipamento WHERE tipoEquipamento=? AND descricaoEquipamento=? AND statusEquipamento =?"
                        + " AND fornecedor_idFornecedor=?", equipamento.getTipoEquipamento(), equipamento.getDescricaoEquipamento(),
                        equipamento.getStatusEquipamento(), equipamento.getFornecedor_idFornecedor());
        try {
            if (rs.next()) {
                result = rs.getInt("idEquipamento");
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
        rs = MySQLDAO.getResultSet("SELECT * FROM equipamento WHERE idEquipamento= ?", id);
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
    
    public ArrayList<EquipamentoBEAN> listaEquipamentoNome(EquipamentoBEAN equipamento){
        
        ArrayList<EquipamentoBEAN> lista = new ArrayList<EquipamentoBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM equipamento WHERE descricaoEquipamento LIKE '%" + equipamento.getDescricaoEquipamento()+ "%'");
        try {
            while (rs.next()) {
                lista.add(new EquipamentoBEAN(rs.getInt("idEquipamento"), 
                                            rs.getString("tipoEquipamento"), 
                                            rs.getString("descricaoEquipamento"),
                                            rs.getString("statusEquipamento"),
                                            rs.getInt("fornecedor_idFornecedor")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
