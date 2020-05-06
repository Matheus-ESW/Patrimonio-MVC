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
public class LaboratorioBEAN {

    private int idLaboratorio;
    private String descricaoLaboratorio;
    private int numeroEquipamento;
    private String statusLaboratorio;
    private int localizacao_idLocalizacao;

    public LaboratorioBEAN() {}

    public LaboratorioBEAN(int idLaboratorio, String descricaoLaboratorio, int numeroEquipamento, String statusLaboratorio, int localizacao_idLocalizacao) {
        this.idLaboratorio = idLaboratorio;
        this.descricaoLaboratorio = descricaoLaboratorio;
        this.numeroEquipamento = numeroEquipamento;
        this.statusLaboratorio = statusLaboratorio;
        this.localizacao_idLocalizacao = localizacao_idLocalizacao;
    }
    
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getDescricaoLaboratorio() {
        return descricaoLaboratorio;
    }

    public void setDescricaoLaboratorio(String descricaoLaboratorio) {
        this.descricaoLaboratorio = descricaoLaboratorio;
    }

    public int getNumeroEquipamento() {
        return numeroEquipamento;
    }

    public void setNumeroEquipamento(int numeroEquipamento) {
        this.numeroEquipamento = numeroEquipamento;
    }

    public String getStatusLaboratorio() {
        return statusLaboratorio;
    }

    public void setStatusLaboratorio(String statusLaboratorio) {
        this.statusLaboratorio = statusLaboratorio;
    }

    public int getLocalizacao_idLocalizacao() {
        return localizacao_idLocalizacao;
    }

    public void setLocalizacao_idLocalizacao(int localizacao_idLocalizacao) {
        this.localizacao_idLocalizacao = localizacao_idLocalizacao;
    } 
}
