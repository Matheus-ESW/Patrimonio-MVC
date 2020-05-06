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
public class LocalizacaoBEAN {

    private int idLocalizacao;
    private String descricaoLocalizacao;
    private String statusLocalizacao;

    public LocalizacaoBEAN() {}

    public LocalizacaoBEAN(int idLocalizacao, String descricaoLocalizacao, String statusLocalizacao) {
        this.idLocalizacao = idLocalizacao;
        this.descricaoLocalizacao = descricaoLocalizacao;
        this.statusLocalizacao = statusLocalizacao;
    }

    public int getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(int idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public String getDescricaoLocalizacao() {
        return descricaoLocalizacao;
    }

    public void setDescricaoLocalizacao(String descricaoLocalizacao) {
        this.descricaoLocalizacao = descricaoLocalizacao;
    }

    public String getStatusLocalizacao() {
        return statusLocalizacao;
    }

    public void setStatusLocalizacao(String statusLocalizacao) {
        this.statusLocalizacao = statusLocalizacao;
    }
}
