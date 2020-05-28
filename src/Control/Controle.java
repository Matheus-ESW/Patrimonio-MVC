/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Model.AuxLaboratorioEstacaoBEAN;
import Model.AuxLaboratorioEstacaoDAO;
import Model.EquipamentoBEAN;
import Model.EquipamentoDAO;
import Model.EstacaoTrabalhoBEAN;
import Model.EstacaoTrabalhoDAO;
import Model.FornecedorBEAN;
import Model.FornecedorDAO;
import Model.LaboratorioBEAN;
import Model.LaboratorioDAO;
import Model.LocalizacaoBEAN;
import Model.LocalizacaoDAO;
import java.util.ArrayList;

/**
 *
 * @author Matheus Ramos
 */
public class Controle {

    
    // CONTROLE FORNECEDOR
    public void addFornecedor(FornecedorBEAN fornecedor) {
        FornecedorDAO.getInstance().create(fornecedor);
    }

    public void updateFornecedor(FornecedorBEAN fornecedor) {
        FornecedorDAO.getInstance().update(fornecedor);
    }

    public void ativarFornecedor(FornecedorBEAN fornecedor) {
        FornecedorDAO.getInstance().ativarFornecedor(fornecedor);
    }
    
    public void inativaFornecedor(FornecedorBEAN fornecedor) {
        FornecedorDAO.getInstance().inativarFornecedor(fornecedor);
    }

    public FornecedorBEAN findFornecedor(int id) {
        return FornecedorDAO.getInstance().buscarFornecedor(id);
    }

    public int findIdFornecedor(FornecedorBEAN fornecedor) {
        return FornecedorDAO.getInstance().buscarID(fornecedor);
    }

    public Boolean isExist(int id) {
        return FornecedorDAO.getInstance().isExist(id);
    }

    public ArrayList<FornecedorBEAN> listaFornecedores() {
        return FornecedorDAO.getInstance().buscaTodosFornecedores();
    }
    
    public ArrayList<FornecedorBEAN> listaFornecedoresPorNome(FornecedorBEAN fornecedor) {
        return FornecedorDAO.getInstance().listaFornecedorNome(fornecedor);
    }
    
    public FornecedorBEAN fornecedorDaCombo(FornecedorBEAN fornecedor){
        return FornecedorDAO.getInstance().fornecedorDaCombo(fornecedor);
    }
    
    public FornecedorBEAN fornecedorPeloNome(String fornecedor){
        return FornecedorDAO.getInstance().fornecedorPeloNome(fornecedor);
    }
    
    public ArrayList<FornecedorBEAN> listaFornecedoresInativos() {
        return FornecedorDAO.getInstance().listaFornecedoresInativos();
    }
    
    
   
    // CONTROLE LOCALIZAÇAO
   public void addLocalizacao(LocalizacaoBEAN localizacao) {
        LocalizacaoDAO.getInstance().create(localizacao);
    }

    public void updateLocalizacao(LocalizacaoBEAN localizacao) {
        LocalizacaoDAO.getInstance().update(localizacao);
    }

    public void ativarLocalizacao(LocalizacaoBEAN localizacao) {
        LocalizacaoDAO.getInstance().ativarLocalizacao(localizacao);
    }
    
    public void inativarLocalizacao(LocalizacaoBEAN localizacao) {
        LocalizacaoDAO.getInstance().inativarLocalizacao(localizacao);
    }

    public LocalizacaoBEAN findLocalizacao(int id) {
        return LocalizacaoDAO.getInstance().buscarLocalizacao(id);
    }

    public int findIdLocalizacao(LocalizacaoBEAN localizacao) {
        return LocalizacaoDAO.getInstance().buscarID(localizacao);
    }

    public Boolean isExistLocal(int id) {
        return LocalizacaoDAO.getInstance().isExist(id);
    }

    public ArrayList<LocalizacaoBEAN> listaLocalizacoes() {
        return LocalizacaoDAO.getInstance().buscaTodasLocalizacoes();
    }
    
    public ArrayList<LocalizacaoBEAN> listaLocalizacoesPorNome(LocalizacaoBEAN localizacao) {
        return LocalizacaoDAO.getInstance().listaLocalizacaoNome(localizacao);
    }
    
    public ArrayList<LocalizacaoBEAN> listaLocalizacoesInativas() {
        return LocalizacaoDAO.getInstance().listaLocalizacaoesInativas();
    }
    
    public LocalizacaoBEAN localizacaoDaCombo(LocalizacaoBEAN local){
        return LocalizacaoDAO.getInstance().localizacaoDaCombo(local);
    }
    
        
    
    
   // CONTROLE EQUIPAMENTO
   public void addEquipamento(EquipamentoBEAN equipamento) {
        EquipamentoDAO.getInstance().create(equipamento);
    }

    public void updateEquipamento(EquipamentoBEAN equipamento) {
        EquipamentoDAO.getInstance().update(equipamento);
    }

    public void ativarEquipamento(EquipamentoBEAN equipamento) {
        EquipamentoDAO.getInstance().ativarEquipamento(equipamento);
    }
    
    public void inativarEquipamento(EquipamentoBEAN equipamento) {
        EquipamentoDAO.getInstance().inativarEquipamento(equipamento);
    }

    public EquipamentoBEAN findEquipamento(int id) {
        return EquipamentoDAO.getInstance().buscarEquipamento(id);
    }

    public int findIdEquipamento(EquipamentoBEAN equipamento) {
        return EquipamentoDAO.getInstance().buscarID(equipamento);
    }

    public Boolean isExistEquipamento(int id) {
        return EquipamentoDAO.getInstance().isExist(id);
    }

    public ArrayList<EquipamentoBEAN> listaEquipamentos() {
        return EquipamentoDAO.getInstance().buscaTodosEquipamentos();
    }
    
    public ArrayList<EquipamentoBEAN> listaEquipamentosPorNome(EquipamentoBEAN equipamento) {
        return EquipamentoDAO.getInstance().listaEquipamentoNome(equipamento);
    }
    
    public EquipamentoBEAN equipamentoPeloNome(String equipamento){
        return EquipamentoDAO.getInstance().equipamentoPeloNome(equipamento);
    }
    
    public ArrayList<EquipamentoBEAN> listaEquipamentosInativos() {
        return EquipamentoDAO.getInstance().listaEquipamentosInativos();
    }
    
    
    
    
    // CONTROLE ESTAÇOES DE TRABALHO
    public void addEstacaoTrabalho(EstacaoTrabalhoBEAN estacaoTrabalho) {
        EstacaoTrabalhoDAO.getInstance().create(estacaoTrabalho);
    }

    public void updateEstacaoTrabalho(EstacaoTrabalhoBEAN estacaoTrabalho) {
        EstacaoTrabalhoDAO.getInstance().update(estacaoTrabalho);
    }
    
    /*
    public void ativarEstacaoTrabalho(EstacaoTrabalhoBEAN estacaoTrabalho) {
        EstacaoTrabalhoDAO.getInstance().ativarEquipamento(estacaoTrabalho);
    }
    
    public void inativarEstacaoTrabalho(EstacaoTrabalhoBEAN estacaoTrabalho) {
        EstacaoTrabalhoDAO.getInstance().inativarEquipamento(estacaoTrabalho);
    }*/

    public EstacaoTrabalhoBEAN findEstacaoTrabalho(int id) {
        return EstacaoTrabalhoDAO.getInstance().buscaEstacaoTrabalho(id);
    }

    public int findIdEstacaoTrabalho(EstacaoTrabalhoBEAN estacaoTrabalho) {
        return EstacaoTrabalhoDAO.getInstance().buscaID(estacaoTrabalho);
    }

    public Boolean isExistEstacaoTrabalho(int id) {
        return EstacaoTrabalhoDAO.getInstance().isExist(id);
    }

    public ArrayList<EstacaoTrabalhoBEAN> listaEstacaoTrabalho() {
        return EstacaoTrabalhoDAO.getInstance().buscaTodosEstacaoTrabalho();
    }
    
    public ArrayList<EstacaoTrabalhoBEAN> listaEstacaoTrabalhoPorNome(EstacaoTrabalhoBEAN estacaoTrabalho) {
        return EstacaoTrabalhoDAO.getInstance().listaEstacaoTrabalhoNome(estacaoTrabalho);
    }
    
    public EstacaoTrabalhoBEAN sstacaoTrabalhoPeloNome(String estacaoTrabalho){
        return EstacaoTrabalhoDAO.getInstance().EstacaoTrabalhoPeloNome(estacaoTrabalho);
    }
    
    
    
    
    // CONTROLE LABORATORIOS
    public long addLaboratorio(LaboratorioBEAN laboratorio) {
        return LaboratorioDAO.getInstance().create(laboratorio);
    }
    
    public void updateLoboratorio(LaboratorioBEAN laboratorio){
        LaboratorioDAO.getInstance().update(laboratorio);
    }
    
    public ArrayList<LaboratorioBEAN> buscaTodosLaboratorios() {
        return LaboratorioDAO.getInstance().buscaTodosLaboratorios();
    }
    
    public ArrayList<LaboratorioBEAN> listaLaboratoriosInativos() {
        return LaboratorioDAO.getInstance().listaLaboratoriosInativos();
    }
    
    public ArrayList<LaboratorioBEAN> listaLaboratorioPorNome(LaboratorioBEAN laboratorio) {
        return LaboratorioDAO.getInstance().listaLaboratorioNome(laboratorio);
    }
    
    //CONTROLE AUXILIAR ESTAÇOES POR LABORATORIO
    public void addAuxiliarLabEstacao(AuxLaboratorioEstacaoBEAN aux){
        AuxLaboratorioEstacaoDAO.getInstance().create(aux);
    }
    
    public void updateAuxiliarEstacao(AuxLaboratorioEstacaoBEAN aux){
        AuxLaboratorioEstacaoDAO.getInstance().update(aux);
    }
    
    public ArrayList<AuxLaboratorioEstacaoBEAN> buscaTodosAuxiliares(int id) {
        return AuxLaboratorioEstacaoDAO.getInstance().findAllAux(id);
    }
    
    public void deleteAuxiliarEstacao(int id){
        AuxLaboratorioEstacaoDAO.getInstance().delete(id);
    }
}
