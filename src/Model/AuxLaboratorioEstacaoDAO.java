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
public class AuxLaboratorioEstacaoDAO {
    
    private static AuxLaboratorioEstacaoDAO instance;

    public AuxLaboratorioEstacaoDAO() {
        MySQLDAO.getConnection();
    }

    public static AuxLaboratorioEstacaoDAO getInstance() {
        if (instance == null) {
            instance = new AuxLaboratorioEstacaoDAO();
        }
        return instance;
    }

    public long create(AuxLaboratorioEstacaoBEAN aux) {
        String query = "INSERT INTO laboratorio_has_estacao_trabalho(laboratorio_IdLaboratorio, estacao_trabalho_idEstacaoTrabalho) "
                + " VALUES (?,?)";
        return MySQLDAO.executeQuery(query, aux.getLaboratorio_IdLaboratorio(), aux.getEstacao_trabalho_idEstacaoTrabalho());

    }

    public void update(AuxLaboratorioEstacaoBEAN aux) {
        String query = "UPDATE laboratorio_has_estacao_trabalho SET laboratorio_IdLaboratorio=?, estacao_trabalho_idEstacaoTrabalho=? ";
        MySQLDAO.executeQuery(query, aux.getLaboratorio_IdLaboratorio(), aux.getEstacao_trabalho_idEstacaoTrabalho());
    }

    public void delete(int id) {
        MySQLDAO.executeQuery("DELETE FROM laboratorio_has_estacao_trabalho WHERE laboratorio_IdLaboratorio = ?", id);
        //MySQLDAO.executeQuery("UPDATE aluno SET status_aluno = " + DESATIVADO + " "
          //      + "WHERE codigo_aluno = ?", aluno.getCodigo_aluno());
    }

    public ArrayList<AuxLaboratorioEstacaoBEAN> findAllAux(int id) {
        return listaAux("SELECT * FROM laboratorio_has_estacao_trabalho WHERE laboratorio_IdLaboratorio =" + id);//
    }

    public ArrayList<AuxLaboratorioEstacaoBEAN> listaAux(String query) {
        ArrayList<AuxLaboratorioEstacaoBEAN> lista = new ArrayList<AuxLaboratorioEstacaoBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new AuxLaboratorioEstacaoBEAN(rs.getInt("laboratorio_IdLaboratorio"),
                        rs.getInt("estacao_trabalho_idEstacaoTrabalho")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
