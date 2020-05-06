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
public class EstacaoTrabalhoBEAN {

    private int idEstacaoTrabalho;
    private String descricaoEstacaoTrabalho;
    private int monitor_idEquipamento;
    private int cpu_idEquipamento;
    private int mouseTeclado_idEquipamento;

    public EstacaoTrabalhoBEAN() {}

    public EstacaoTrabalhoBEAN(int idEstacaoTrabalho, String descricaoEstacaoTrabalho, int monitor_idEquipamento, int cpu_idEquipamento, int mouseTeclado_idEquipamento) {
        this.idEstacaoTrabalho = idEstacaoTrabalho;
        this.descricaoEstacaoTrabalho = descricaoEstacaoTrabalho;
        this.monitor_idEquipamento = monitor_idEquipamento;
        this.cpu_idEquipamento = cpu_idEquipamento;
        this.mouseTeclado_idEquipamento = mouseTeclado_idEquipamento;
    }

    public int getIdEstacaoTrabalho() {
        return idEstacaoTrabalho;
    }

    public void setIdEstacaoTrabalho(int idEstacaoTrabalho) {
        this.idEstacaoTrabalho = idEstacaoTrabalho;
    }

    public String getDescricaoEstacaoTrabalho() {
        return descricaoEstacaoTrabalho;
    }

    public void setDescricaoEstacaoTrabalho(String descricaoEstacaoTrabalho) {
        this.descricaoEstacaoTrabalho = descricaoEstacaoTrabalho;
    }

    public int getMonitor_idEquipamento() {
        return monitor_idEquipamento;
    }

    public void setMonitor_idEquipamento(int monitor_idEquipamento) {
        this.monitor_idEquipamento = monitor_idEquipamento;
    }

    public int getCpu_idEquipamento() {
        return cpu_idEquipamento;
    }

    public void setCpu_idEquipamento(int cpu_idEquipamento) {
        this.cpu_idEquipamento = cpu_idEquipamento;
    }

    public int getMouseTeclado_idEquipamento() {
        return mouseTeclado_idEquipamento;
    }

    public void setMouseTeclado_idEquipamento(int mouseTeclado_idEquipamento) {
        this.mouseTeclado_idEquipamento = mouseTeclado_idEquipamento;
    }
}
