/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Controle;
import Model.EquipamentoBEAN;
import Model.FornecedorBEAN;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mathe
 */
public class EquipamentoView extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel modelo;
    Controle controle = new Controle();
    int idAlteraEquipamento;

    /**
     * Creates new form EquipamentoView
     */
    public EquipamentoView() {
        initComponents();
        listarFornecedores();
        this.setTitle("Equipamentos");
        this.atualizaTabela();
        this.setLocationRelativeTo(null);
    }

    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String str = (String) value;

            if ("Inativo".equals(str)) {
                c.setForeground(Color.RED);
            } else {
                c.setForeground(Color.BLACK);
            }
            return c;
        }
    };

    private void atualizaTabela() {
        this.modelo = (javax.swing.table.DefaultTableModel) jTableEquipamentos.getModel();

        List<EquipamentoBEAN> listaEquipamentos = controle.listaEquipamentos();
        preencherTabela(listaEquipamentos);
    }

    private void preencherTabela(List<EquipamentoBEAN> listaEquipamentos) {

        jTableEquipamentos.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableEquipamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableEquipamentos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTableEquipamentos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTableEquipamentos.getColumnModel().getColumn(4).setCellRenderer(renderer);
        //tabela.getColumnModel().getColumn(3).setPreferredWidth(500);

        modelo.setNumRows(0);

        String isAtivo = "*";
        FornecedorBEAN forn = new FornecedorBEAN();

        try {
            for (EquipamentoBEAN equipamento : listaEquipamentos) {

                if (equipamento.getStatusEquipamento().equals("1")) {
                    if (equipamento.getStatusEquipamento().equals("0")) {
                        isAtivo = "Inativo";
                    } else {
                        isAtivo = "Ativo";
                    }

                    forn = controle.findFornecedor(equipamento.getFornecedor_idFornecedor());

                    modelo.addRow(new Object[]{equipamento.getIdEquipamento(), equipamento.getDescricaoEquipamento(),
                        equipamento.getTipoEquipamento(), forn.getRazaoSocial(), isAtivo});
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }

    private void atualizaTabelaInativos() {
        this.modelo = (javax.swing.table.DefaultTableModel) jTableEquipamentos.getModel();

        List<EquipamentoBEAN> listaEquipamentos = controle.listaEquipamentos();
        preencherTabela(listaEquipamentos);
    }

    private void preencherTabelaInativos(List<EquipamentoBEAN> listaEquipamentos) {

        jTableEquipamentos.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableEquipamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableEquipamentos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTableEquipamentos.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTableEquipamentos.getColumnModel().getColumn(4).setCellRenderer(renderer);
        //tabela.getColumnModel().getColumn(3).setPreferredWidth(500);

        modelo.setNumRows(0);

        String isAtivo = "*";
        FornecedorBEAN forn = new FornecedorBEAN();

        try {
            for (EquipamentoBEAN equipamento : listaEquipamentos) {

                if (equipamento.getStatusEquipamento().equals("0")) {
                    isAtivo = "Inativo";
                } else {
                    isAtivo = "Ativo";
                }

                forn = controle.findFornecedor(equipamento.getFornecedor_idFornecedor());

                modelo.addRow(new Object[]{equipamento.getIdEquipamento(), equipamento.getDescricaoEquipamento(),
                    equipamento.getTipoEquipamento(), forn.getRazaoSocial(), isAtivo});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricaoEquipamento = new javax.swing.JTextField();
        jCheckBoxInativo = new javax.swing.JCheckBox();
        jComboBoxTipo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEquipamentos = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldBusca = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<String>();
        jCheckBoxMostrarInativos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descriçao Equipamento");

        jCheckBoxInativo.setText("Inativo");
        jCheckBoxInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxInativoActionPerformed(evt);
            }
        });

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPU", "Monitor", "Mouse/Teclado" }));

        jTableEquipamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descriçao", "Tipo", "Fornecedor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEquipamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEquipamentos);
        if (jTableEquipamentos.getColumnModel().getColumnCount() > 0) {
            jTableEquipamentos.getColumnModel().getColumn(0).setResizable(false);
            jTableEquipamentos.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableEquipamentos.getColumnModel().getColumn(1).setResizable(false);
            jTableEquipamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableEquipamentos.getColumnModel().getColumn(2).setResizable(false);
            jTableEquipamentos.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableEquipamentos.getColumnModel().getColumn(3).setResizable(false);
            jTableEquipamentos.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableEquipamentos.getColumnModel().getColumn(4).setResizable(false);
            jTableEquipamentos.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Limpar");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo: ");

        jLabel3.setText("Fornecedor: ");

        jCheckBoxMostrarInativos.setText("Mostrar Inativos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldDescricaoEquipamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxInativo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxMostrarInativos))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldBusca)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricaoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxInativo))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxMostrarInativos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listarFornecedores() {

        for (FornecedorBEAN fornecedor : controle.listaFornecedores()) {
            if (!fornecedor.getStatusFornecedor().equals("0")) {
                jComboBoxFornecedor.addItem(fornecedor.getRazaoSocial());
            }
        }
    }

    private void limparCampos() {
        jTextFieldDescricaoEquipamento.setText("");
        jCheckBoxInativo.setSelected(false);
        jCheckBoxMostrarInativos.setSelected(false);
        jComboBoxTipo.setSelectedIndex(0);
        jComboBoxFornecedor.setSelectedIndex(0);
        jTextFieldBusca.setText("");
        atualizaTabela();
    }

    private void jCheckBoxInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxInativoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        String isAtivo = "*";

        if (jTextFieldDescricaoEquipamento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de descriçao do equipamento vazio");
            jTextFieldDescricaoEquipamento.requestFocus();
        } else if (jCheckBoxInativo.isSelected()) {
            isAtivo = "0";
        } else if (!jCheckBoxInativo.isSelected()) {
            isAtivo = "1";
        }

        FornecedorBEAN fornecedor = new FornecedorBEAN();
        fornecedor.setRazaoSocial(jComboBoxFornecedor.getSelectedItem().toString());
        fornecedor = controle.fornecedorDaCombo(fornecedor);

        EquipamentoBEAN equipamento = new EquipamentoBEAN(0, jComboBoxTipo.getSelectedItem().toString(),
                jTextFieldDescricaoEquipamento.getText(), isAtivo, fornecedor.getIdFornecedor());

        //System.out.println("Tipo: " + equipamento.getTipoEquipamento() + " Descriçao: " + equipamento.getDescricaoEquipamento() + " Status: "
        //        + " Fornecedor: " + equipamento.getFornecedor_idFornecedor());
        controle.addEquipamento(equipamento);
        JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso!");
        limparCampos();
        atualizaTabela();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        new MenuView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:

        String isAtivo = "*";

        if (jCheckBoxInativo.isSelected()) {
            isAtivo = "0";
        } else if (!jCheckBoxInativo.isSelected()) {
            isAtivo = "1";
        }

        FornecedorBEAN fornecedor = new FornecedorBEAN();
        fornecedor.setRazaoSocial(jComboBoxFornecedor.getSelectedItem().toString());
        fornecedor = controle.fornecedorDaCombo(fornecedor);

        if (controle.isExist(idAlteraEquipamento)) {

            EquipamentoBEAN equipamento = new EquipamentoBEAN(idAlteraEquipamento, jComboBoxTipo.getSelectedItem().toString(),
                    jTextFieldDescricaoEquipamento.getText(), isAtivo, fornecedor.getIdFornecedor());
            controle.updateEquipamento(equipamento);
            JOptionPane.showMessageDialog(null, "Equipamento alterado com sucesso!");
            limparCampos();
            atualizaTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o equipamento!");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTableEquipamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEquipamentosMouseClicked
        // TODO add your handling code here:

        int linhaEditora = jTableEquipamentos.getSelectedRow();
        idAlteraEquipamento = Integer.parseInt(jTableEquipamentos.getValueAt(linhaEditora, 0).toString());
        this.jTextFieldDescricaoEquipamento.setText(jTableEquipamentos.getValueAt(linhaEditora, 1).toString());

        if (jTableEquipamentos.getValueAt(linhaEditora, 2).toString().equals("CPU")) {
            jComboBoxTipo.setSelectedIndex(0);
        } else if (jTableEquipamentos.getValueAt(linhaEditora, 2).toString().equals("Monitor")) {
            jComboBoxTipo.setSelectedIndex(1);
        } else if (jTableEquipamentos.getValueAt(linhaEditora, 2).toString().equals("Mouse/Teclado")) {
            jComboBoxTipo.setSelectedIndex(2);
        }

        String forn = jTableEquipamentos.getValueAt(linhaEditora, 3).toString();

        jComboBoxFornecedor.setSelectedItem(forn);

        String isAtivos = "*";

        if (jTableEquipamentos.getValueAt(linhaEditora, 4).toString().equals("Inativo")) {
            jCheckBoxInativo.setSelected(true);
        } else {
            jCheckBoxInativo.setSelected(false);
        }
    }//GEN-LAST:event_jTableEquipamentosMouseClicked

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:

        EquipamentoBEAN equipamento = new EquipamentoBEAN();
        equipamento.setDescricaoEquipamento(jTextFieldBusca.getText());

        if (jCheckBoxMostrarInativos.isSelected()) {
            ArrayList<EquipamentoBEAN> listaEquipamentosInativos = controle.listaEquipamentosInativos();

            if (!listaEquipamentosInativos.isEmpty()) {
                preencherTabelaInativos(listaEquipamentosInativos);
            } else {
                JOptionPane.showMessageDialog(null, "Equipamento nao encontrada!");
            }
        } else {
            if (jTextFieldBusca.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio!");
            } else {
                ArrayList<EquipamentoBEAN> listaEquipamento = controle.listaEquipamentosPorNome(equipamento);

                if (!listaEquipamento.isEmpty()) {
                    preencherTabela(listaEquipamento);
                } else {
                    JOptionPane.showMessageDialog(null, "Equipamento nao encontrada!");
                }
            }
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EquipamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipamentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxInativo;
    private javax.swing.JCheckBox jCheckBoxMostrarInativos;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEquipamentos;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldDescricaoEquipamento;
    // End of variables declaration//GEN-END:variables

}
