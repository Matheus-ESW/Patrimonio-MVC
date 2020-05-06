/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Model.FornecedorBEAN;
import Model.FornecedorDAO;
import java.util.ArrayList;

/**
 *
 * @author Matheus Ramos
 */
public class Controle {

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
}
