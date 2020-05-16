/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Controle;
import java.awt.Color;
import java.awt.Component;
import Model.LocalizacaoBEAN;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mathe
 */
public class LocalizacaoView extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel modelo;
    Controle controle = new Controle();
    int idAlteraLocalizacao;

    /**
     * Creates new form LocalizacaoView
     */
    public LocalizacaoView() {
        initComponents();
        this.setTitle("Localizaçoes");
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
        this.modelo = (javax.swing.table.DefaultTableModel) jTableLocalizacoes.getModel();

        List<LocalizacaoBEAN> listaLocalizacoes = controle.listaLocalizacoes();
        preencherTabela(listaLocalizacoes);
    }

    private void preencherTabela(List<LocalizacaoBEAN> listaLocalizacoes) {

        jTableLocalizacoes.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTableLocalizacoes.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableLocalizacoes.getColumnModel().getColumn(2).setCellRenderer(renderer);
        //tabela.getColumnModel().getColumn(3).setPreferredWidth(500);

        modelo.setNumRows(0);

        String isAtivo = "*";

        try {
            for (LocalizacaoBEAN localizacao : listaLocalizacoes) {

                if (localizacao.getStatusLocalizacao().equals("1")) {
                    if (localizacao.getStatusLocalizacao().equals("0")) {
                        isAtivo = "Inativo";
                    } else {
                        isAtivo = "Ativo";
                    }

                    modelo.addRow(new Object[]{localizacao.getIdLocalizacao(), localizacao.getDescricaoLocalizacao(), isAtivo});
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }

    private void atualizaTabelaInativos() {
        this.modelo = (javax.swing.table.DefaultTableModel) jTableLocalizacoes.getModel();

        List<LocalizacaoBEAN> listaLocalizacoes = controle.listaLocalizacoes();
        preencherTabelaInativos(listaLocalizacoes);
    }

    private void preencherTabelaInativos(List<LocalizacaoBEAN> listaLocalizacoes) {

        jTableLocalizacoes.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTableLocalizacoes.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableLocalizacoes.getColumnModel().getColumn(2).setCellRenderer(renderer);
        //tabela.getColumnModel().getColumn(3).setPreferredWidth(500);

        modelo.setNumRows(0);

        String isAtivo = "*";

        try {
            for (LocalizacaoBEAN localizacao : listaLocalizacoes) {

                if (localizacao.getStatusLocalizacao().equals("0")) {
                    isAtivo = "Inativo";
                } else {
                    isAtivo = "Ativo";
                }

                modelo.addRow(new Object[]{localizacao.getIdLocalizacao(), localizacao.getDescricaoLocalizacao(), isAtivo});

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

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricaoLocalizacao = new javax.swing.JTextField();
        jCheckBoxInativo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLocalizacoes = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldBusca = new javax.swing.JTextField();
        jButtonConsultar = new javax.swing.JButton();
        jCheckBoxMostrarInativos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descriçao Localizaçao");

        jCheckBoxInativo.setText("Inativo");
        jCheckBoxInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxInativoActionPerformed(evt);
            }
        });

        jTableLocalizacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descriçao Localizaçao", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLocalizacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLocalizacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLocalizacoes);
        if (jTableLocalizacoes.getColumnModel().getColumnCount() > 0) {
            jTableLocalizacoes.getColumnModel().getColumn(0).setResizable(false);
            jTableLocalizacoes.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTableLocalizacoes.getColumnModel().getColumn(1).setResizable(false);
            jTableLocalizacoes.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTableLocalizacoes.getColumnModel().getColumn(2).setResizable(false);
            jTableLocalizacoes.getColumnModel().getColumn(2).setPreferredWidth(100);
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

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jCheckBoxMostrarInativos.setText("Mostrar Inativos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
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
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldDescricaoLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxInativo)
                            .addComponent(jCheckBoxMostrarInativos))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricaoLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxInativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxMostrarInativos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxInativoActionPerformed

    private void limparCampos() {
        jTextFieldDescricaoLocalizacao.setText("");
        jCheckBoxInativo.setSelected(false);
        jTextFieldBusca.setText("");
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        String isAtivo = "*";

        if (jTextFieldDescricaoLocalizacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de descriçao da localizaçao vazio");
            jTextFieldDescricaoLocalizacao.requestFocus();
        } else if (jCheckBoxInativo.isSelected()) {
            isAtivo = "0";
        } else if (!jCheckBoxInativo.isSelected()) {
            isAtivo = "1";
        }

        LocalizacaoBEAN local = new LocalizacaoBEAN(0, jTextFieldDescricaoLocalizacao.getText().toString(), isAtivo);
        controle.addLocalizacao(local);
        JOptionPane.showMessageDialog(null, "Localizaçao cadastrada com sucesso!");
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

        if (controle.isExistLocal(idAlteraLocalizacao)) {

            LocalizacaoBEAN local = new LocalizacaoBEAN(idAlteraLocalizacao, jTextFieldDescricaoLocalizacao.getText().toString(), isAtivo);
            controle.updateLocalizacao(local);
            JOptionPane.showMessageDialog(null, "Localizaçao alterada com sucesso!");
            limparCampos();
            atualizaTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a localizaçao!");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTableLocalizacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLocalizacoesMouseClicked
        // TODO add your handling code here:

        int linhaEditora = jTableLocalizacoes.getSelectedRow();
        idAlteraLocalizacao = Integer.parseInt(jTableLocalizacoes.getValueAt(linhaEditora, 0).toString());
        this.jTextFieldDescricaoLocalizacao.setText(jTableLocalizacoes.getValueAt(linhaEditora, 1).toString());

        String isAtivos = "*";

        if (jTableLocalizacoes.getValueAt(linhaEditora, 2).toString().equals("Inativo")) {
            jCheckBoxInativo.setSelected(true);
        } else {
            jCheckBoxInativo.setSelected(false);
        }
    }//GEN-LAST:event_jTableLocalizacoesMouseClicked

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        // TODO add your handling code here:

        LocalizacaoBEAN local = new LocalizacaoBEAN();
        local.setDescricaoLocalizacao(jTextFieldBusca.getText());

        if (jCheckBoxMostrarInativos.isSelected()) {
            ArrayList<LocalizacaoBEAN> listaLocalizacoesInativas = controle.listaLocalizacoesInativas();
            
            if (!listaLocalizacoesInativas.isEmpty()) {
                preencherTabelaInativos(listaLocalizacoesInativas);
            } else {
                JOptionPane.showMessageDialog(null, "Localizaçao nao encontrada!");
            }
        } else {

            if (jTextFieldBusca.getText().length() == 0) {
                System.out.println(" " + jTextFieldBusca.getText().toString());
                JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio!");
            } else {

                ArrayList<LocalizacaoBEAN> listaLocalizacao = controle.listaLocalizacoesPorNome(local);

                if (!listaLocalizacao.isEmpty()) {
                    preencherTabela(listaLocalizacao);
                } else {
                    JOptionPane.showMessageDialog(null, "Localizaçao nao encontrada!");
                }
            }
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(LocalizacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocalizacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocalizacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocalizacaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocalizacaoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxInativo;
    private javax.swing.JCheckBox jCheckBoxMostrarInativos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLocalizacoes;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldDescricaoLocalizacao;
    // End of variables declaration//GEN-END:variables

}
