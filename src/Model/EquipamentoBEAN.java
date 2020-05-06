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
public class EquipamentoBEAN {

    private int idEquipamento;
    private String tipoEquipamento;
    private String descricaoEquipamento;
    private String statusEquipamento;
    private int fornecedor_idFornecedor;

    public EquipamentoBEAN() {}

    public EquipamentoBEAN(int idEquipamento, String tipoEquipamento, String descricaoEquipamento, String statusEquipamento, int fornecedor_idFornecedor) {
        this.idEquipamento = idEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.descricaoEquipamento = descricaoEquipamento;
        this.statusEquipamento = statusEquipamento;
        this.fornecedor_idFornecedor = fornecedor_idFornecedor;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }

    public void setDescricaoEquipamento(String descricaoEquipamento) {
        this.descricaoEquipamento = descricaoEquipamento;
    }

    public String getStatusEquipamento() {
        return statusEquipamento;
    }

    public void setStatusEquipamento(String statusEquipamento) {
        this.statusEquipamento = statusEquipamento;
    }

    public int getFornecedor_idFornecedor() {
        return fornecedor_idFornecedor;
    }

    public void setFornecedor_idFornecedor(int fornecedor_idFornecedor) {
        this.fornecedor_idFornecedor = fornecedor_idFornecedor;
    }
}
