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
public class FornecedorBEAN {

    private int idFornecedor;
    private String razaoSocial;
    private String statusFornecedor;

    public FornecedorBEAN() {}

    public FornecedorBEAN(int idFornecedor, String razaoSocial, String statusFornecedor) {
        this.idFornecedor = idFornecedor;
        this.razaoSocial = razaoSocial;
        this.statusFornecedor = statusFornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getStatusFornecedor() {
        return statusFornecedor;
    }

    public void setStatusFornecedor(String statusFornecedor) {
        this.statusFornecedor = statusFornecedor;
    }
}
