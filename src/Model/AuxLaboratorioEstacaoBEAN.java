/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Matheus Ramos
 */
public class AuxLaboratorioEstacaoBEAN {

    private int laboratorio_IdLaboratorio;
    private int estacao_trabalho_idEstacaoTrabalho;

    public AuxLaboratorioEstacaoBEAN(int laboratorio_IdLaboratorio, int estacao_trabalho_idEstacaoTrabalho) {
        this.laboratorio_IdLaboratorio = laboratorio_IdLaboratorio;
        this.estacao_trabalho_idEstacaoTrabalho = estacao_trabalho_idEstacaoTrabalho;
    }
    
    public int getLaboratorio_IdLaboratorio() {
        return laboratorio_IdLaboratorio;
    }

    public void setLaboratorio_IdLaboratorio(int laboratorio_IdLaboratorio) {
        this.laboratorio_IdLaboratorio = laboratorio_IdLaboratorio;
    }

    public int getEstacao_trabalho_idEstacaoTrabalho() {
        return estacao_trabalho_idEstacaoTrabalho;
    }

    public void setEstacao_trabalho_idEstacaoTrabalho(int estacao_trabalho_idEstacaoTrabalho) {
        this.estacao_trabalho_idEstacaoTrabalho = estacao_trabalho_idEstacaoTrabalho;
    }
}
