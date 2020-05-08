/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Model.EquipamentoBEAN;
import Model.EquipamentoDAO;
import Model.FornecedorBEAN;
import Model.FornecedorDAO;
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
}
