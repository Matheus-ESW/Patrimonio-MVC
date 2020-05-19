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

    public long create(int maximo, int aluno) {
        String query = "INSERT INTO laboratorio_has_estacao_trabalho(estacao_trabalho_idEstacaoTrabalho, laboratorio_IdLaboratorio)"
                + " VALUES (?,?)";
        return MySQLDAO.executeQuery(query, aluno, maximo);

    }

    public void update(AuxLaboratorioEstacaoBEAN aux) {
        String query = "UPDATE laboratorio_has_estacao_trabalho SET estacao_trabalho_idEstacaoTrabalho=?, laboratorio_IdLaboratorio=? ";
                //+ "WHERE codigo_aluno = ?";
        MySQLDAO.executeQuery(query, aux.getEstacao_trabalho_idEstacaoTrabalho(), aux.getLaboratorio_IdLaboratorio());
    }

    public void delete(AuxLaboratorioEstacaoBEAN aux) {
        //MySQLDAO.executeQuery("DELETE FROM professor WHERE codigo_professor = ?", prof.getCodigo_professor());
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
                lista.add(new AuxLaboratorioEstacaoBEAN(rs.getInt("laboratorio_IdLaboratorio"),//fk_codigo_aluno, fk_codigo_turma
                        rs.getInt("estacao_trabalho_idEstacaoTrabalho")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
