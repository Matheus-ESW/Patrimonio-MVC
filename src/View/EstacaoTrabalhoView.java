/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Controle;
import Model.EquipamentoBEAN;
import Model.EstacaoTrabalhoBEAN;
import Model.FornecedorBEAN;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class EstacaoTrabalhoView extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel modeloEquipamento;
    javax.swing.table.DefaultTableModel modeloEquipamentoEstacao;
    javax.swing.table.DefaultTableModel modeloEstacaoTrabalho;
    Controle controle = new Controle();
    int idAlteraEstacaoTrabalho;
    int cont;
    int contMonitor, contCPU, contTeclado;
    String equipCPU, equipMonitor, equipMouse;

    /**
     * Creates new form EstacaoTrabalhoView
     */
    public EstacaoTrabalhoView() {
        initComponents();
        this.setTitle("Estaçoes de Trabalho");
        this.atualizaTabela();
        this.atualizaTabelaEstacoesTrabalho();
        this.setLocationRelativeTo(null);
        cont = 0;
        contMonitor = 0;
        contCPU = 0;
        contTeclado = 0;
    }

    private void atualizaTabela() {
        this.modeloEquipamento = (javax.swing.table.DefaultTableModel) jTableEquipamentosDisponiveis.getModel();

        List<EquipamentoBEAN> listaEquipamentos = controle.listaEquipamentos();
        preencherTabela(listaEquipamentos);
    }

    private void preencherTabela(List<EquipamentoBEAN> listaEquipamentos) {

        jTableEquipamentosDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableEquipamentosDisponiveis.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableEquipamentosDisponiveis.getColumnModel().getColumn(2).setPreferredWidth(30);

        modeloEquipamento.setNumRows(0);
        List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho = controle.listaEstacaoTrabalho();

        try {
            for (EquipamentoBEAN equipamento : listaEquipamentos) {

                FornecedorBEAN forn = controle.findFornecedor(equipamento.getFornecedor_idFornecedor());

                if (equipamento.getStatusEquipamento().equals("1")) {// SE STATUS = 1 ATIVO
                    modeloEquipamento.addRow(new Object[]{equipamento.getDescricaoEquipamento(), equipamento.getTipoEquipamento(),
                                forn.getRazaoSocial()});
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }

    private void atualizaTabelaEstacoesTrabalho() {
        this.modeloEstacaoTrabalho = (javax.swing.table.DefaultTableModel) jTableEstacoesTrabalho.getModel();

        List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho = controle.listaEstacaoTrabalho();
        preencherTabelaEstacoesTrabalho(listaEstacoesTrabalho);
    }

    private void preencherTabelaEstacoesTrabalho(List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho) {

        jTableEstacoesTrabalho.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableEstacoesTrabalho.getColumnModel().getColumn(1).setPreferredWidth(500);

        modeloEstacaoTrabalho.setNumRows(0);

        try {
            for (EstacaoTrabalhoBEAN estacao : listaEstacoesTrabalho) {

                modeloEstacaoTrabalho.addRow(new Object[]{estacao.getIdEstacaoTrabalho(), estacao.getDescricaoEstacaoTrabalho()});
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
        jTextFieldDescricaoEstacaoTrabalho = new javax.swing.JTextField();
        jCheckBoxInativo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEquipamentosDisponiveis = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipamentosEstacao = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAdicionarEquipamento = new javax.swing.JButton();
        jButtonRemoverEquipamento = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEstacoesTrabalho = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldBusca = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descriçao Estaçao de Trabalho");

        jCheckBoxInativo.setText("Inativo");

        jTableEquipamentosDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descriçao", "Tipo", "Fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        jTableEquipamentosDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEquipamentosDisponiveisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEquipamentosDisponiveis);
        if (jTableEquipamentosDisponiveis.getColumnModel().getColumnCount() > 0) {
            jTableEquipamentosDisponiveis.getColumnModel().getColumn(0).setResizable(false);
            jTableEquipamentosDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableEquipamentosDisponiveis.getColumnModel().getColumn(1).setResizable(false);
            jTableEquipamentosDisponiveis.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTableEquipamentosDisponiveis.getColumnModel().getColumn(2).setResizable(false);
            jTableEquipamentosDisponiveis.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jTableEquipamentosEstacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descriçao", "Tipo", "Fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(jTableEquipamentosEstacao);
        if (jTableEquipamentosEstacao.getColumnModel().getColumnCount() > 0) {
            jTableEquipamentosEstacao.getColumnModel().getColumn(0).setResizable(false);
            jTableEquipamentosEstacao.getColumnModel().getColumn(1).setResizable(false);
            jTableEquipamentosEstacao.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("Equipamentos Disponiveis");

        jLabel3.setText("Equipamentos da Estaçao");

        jButtonAdicionarEquipamento.setText(">>");
        jButtonAdicionarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarEquipamentoActionPerformed(evt);
            }
        });

        jButtonRemoverEquipamento.setText("<<");
        jButtonRemoverEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverEquipamentoActionPerformed(evt);
            }
        });

        jTableEstacoesTrabalho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descriçao Estaçao de Trabalho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEstacoesTrabalho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEstacoesTrabalhoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableEstacoesTrabalho);
        if (jTableEstacoesTrabalho.getColumnModel().getColumnCount() > 0) {
            jTableEstacoesTrabalho.getColumnModel().getColumn(0).setResizable(false);
            jTableEstacoesTrabalho.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableEstacoesTrabalho.getColumnModel().getColumn(1).setResizable(false);
            jTableEstacoesTrabalho.getColumnModel().getColumn(1).setPreferredWidth(500);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionarEquipamento)
                                    .addComponent(jButtonRemoverEquipamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldDescricaoEstacaoTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBoxInativo)))
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDescricaoEstacaoTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxInativo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonAdicionarEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonRemoverEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:

        EstacaoTrabalhoBEAN estacao = new EstacaoTrabalhoBEAN();
        estacao.setDescricaoEstacaoTrabalho(jTextFieldBusca.getText());

        if (jTextFieldBusca.getText().length() == 0) {
            System.out.println(" " + jTextFieldBusca.getText().toString());
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio!");
        } else {
            ArrayList<EstacaoTrabalhoBEAN> listaEstacaoTrabalho = controle.listaEstacaoTrabalhoPorNome(estacao);

            if (!listaEstacaoTrabalho.isEmpty()) {
                preencherTabelaEstacoesTrabalho(listaEstacaoTrabalho);
            } else {
                JOptionPane.showMessageDialog(null, "Estaçao de trabalho nao encontrada!");
            }
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        new MenuView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTableEquipamentosDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEquipamentosDisponiveisMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableEquipamentosDisponiveisMouseClicked

    private void jButtonAdicionarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarEquipamentoActionPerformed
        // TODO add your handling code here:

        this.modeloEquipamentoEstacao = (javax.swing.table.DefaultTableModel) jTableEquipamentosEstacao.getModel();

        int linhaEditora = jTableEquipamentosDisponiveis.getSelectedRow();
        jButtonRemoverEquipamento.setEnabled(true);
        
        if (cont <= 0) {
            modeloEquipamentoEstacao.setNumRows(0);
        }

        jTableEquipamentosEstacao.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableEquipamentosEstacao.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableEquipamentosEstacao.getColumnModel().getColumn(2).setPreferredWidth(30);

        try {
            if (jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 1).toString().equals("Monitor")) {
                if (contMonitor < 1) {

                    modeloEquipamentoEstacao.addRow(new Object[]{jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 0).toString(),
                        jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 1).toString(),
                        jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 2).toString()});

                    equipMonitor = jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 0).toString();
                    ((DefaultTableModel) jTableEquipamentosDisponiveis.getModel()).removeRow(jTableEquipamentosDisponiveis.getSelectedRow());
                    contMonitor++;
                } else {
                    JOptionPane.showMessageDialog(null, "Nao e possivel inserir mais de um monitor na mesma estaçao!");
                }
            } else if (jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 1).toString().equals("CPU")) {
                if (contCPU < 1) {

                    modeloEquipamentoEstacao.addRow(new Object[]{jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 0).toString(),
                        jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 1).toString(),
                        jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 2).toString()});

                    equipCPU = jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 0).toString();
                    ((DefaultTableModel) jTableEquipamentosDisponiveis.getModel()).removeRow(jTableEquipamentosDisponiveis.getSelectedRow());
                    contCPU++;
                } else {
                    JOptionPane.showMessageDialog(null, "Nao e possivel inserir mais de um CPU na mesma estaçao!");
                }
            } else if (jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 1).toString().equals("Mouse/Teclado")) {
                if (contTeclado < 1) {

                    modeloEquipamentoEstacao.addRow(new Object[]{jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 0).toString(),
                        jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 1).toString(),
                        jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 2).toString()});

                    equipMouse = jTableEquipamentosDisponiveis.getValueAt(linhaEditora, 0).toString();
                    ((DefaultTableModel) jTableEquipamentosDisponiveis.getModel()).removeRow(jTableEquipamentosDisponiveis.getSelectedRow());
                    contTeclado++;
                } else {
                    JOptionPane.showMessageDialog(null, "Nao e possivel inserir mais de um mouse/teclado na mesma estaçao!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

        cont++;
    }//GEN-LAST:event_jButtonAdicionarEquipamentoActionPerformed

    private void jButtonRemoverEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverEquipamentoActionPerformed
        // TODO add your handling code here:

        int linhaEditora = jTableEquipamentosEstacao.getSelectedRow();

        String descAux = jTableEquipamentosEstacao.getValueAt(linhaEditora, 0).toString();
        EquipamentoBEAN equipamento = controle.equipamentoPeloNome(descAux);

//        for (int i = 0; i < cont; i++) {
//            if (IDsEquipamentos[i] == equipamento.getIdEquipamento()) {
//                IDsEquipamentos[i] = 0;
//            }
//        }
        try {
            if (jTableEquipamentosEstacao.getValueAt(linhaEditora, 1).toString().equals("CPU")) {

                modeloEquipamento.addRow(new Object[]{modeloEquipamentoEstacao.getValueAt(linhaEditora, 0).toString(),
                    modeloEquipamentoEstacao.getValueAt(linhaEditora, 1).toString(),
                    modeloEquipamentoEstacao.getValueAt(linhaEditora, 2).toString()});

                ((DefaultTableModel) jTableEquipamentosEstacao.getModel()).removeRow(jTableEquipamentosEstacao.getSelectedRow());
                contCPU--;
                equipCPU = null;
            } else if (jTableEquipamentosEstacao.getValueAt(linhaEditora, 1).toString().equals("Monitor")) {

                modeloEquipamento.addRow(new Object[]{modeloEquipamentoEstacao.getValueAt(linhaEditora, 0).toString(),
                    modeloEquipamentoEstacao.getValueAt(linhaEditora, 1).toString(),
                    modeloEquipamentoEstacao.getValueAt(linhaEditora, 2).toString()});

                ((DefaultTableModel) jTableEquipamentosEstacao.getModel()).removeRow(jTableEquipamentosEstacao.getSelectedRow());
                contMonitor--;
                equipMonitor = null;
            } else if (jTableEquipamentosEstacao.getValueAt(linhaEditora, 1).toString().equals("Mouse/Teclado")) {

                modeloEquipamento.addRow(new Object[]{modeloEquipamentoEstacao.getValueAt(linhaEditora, 0).toString(),
                    modeloEquipamentoEstacao.getValueAt(linhaEditora, 1).toString(),
                    modeloEquipamentoEstacao.getValueAt(linhaEditora, 2).toString()});

                ((DefaultTableModel) jTableEquipamentosEstacao.getModel()).removeRow(jTableEquipamentosEstacao.getSelectedRow());
                contTeclado--;
                equipMouse = null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }//GEN-LAST:event_jButtonRemoverEquipamentoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        String isAtivo = "*";

        if (jTextFieldDescricaoEstacaoTrabalho.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de descriçao da estaçao de trabalho vazio");
            jTextFieldDescricaoEstacaoTrabalho.requestFocus();
        } else if (jCheckBoxInativo.isSelected()) {
            isAtivo = "0";
        } else if (!jCheckBoxInativo.isSelected()) {
            isAtivo = "1";
        }

        EquipamentoBEAN cpu, monitor, mouse = new EquipamentoBEAN();
        cpu = controle.equipamentoPeloNome(equipCPU);
        monitor = controle.equipamentoPeloNome(equipMonitor);
        mouse = controle.equipamentoPeloNome(equipMouse);

        controle.addEstacaoTrabalho(new EstacaoTrabalhoBEAN(0, jTextFieldDescricaoEstacaoTrabalho.getText().toString(),
                monitor.getIdEquipamento(), cpu.getIdEquipamento(), mouse.getIdEquipamento()));

        JOptionPane.showMessageDialog(null, "Estaçao de trabalho cadastrada com sucesso!");
        zerarContadorApagarNomeEquipamentos();
        limparCampos();
        atualizaTabela();
        atualizaTabelaEstacoesTrabalho();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        
        String isAtivo = "*";

        if (jTextFieldDescricaoEstacaoTrabalho.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de descriçao da estaçao de trabalho vazio");
            jTextFieldDescricaoEstacaoTrabalho.requestFocus();
        } else if (jCheckBoxInativo.isSelected()) {
            isAtivo = "0";
        } else if (!jCheckBoxInativo.isSelected()) {
            isAtivo = "1";
        }
        
        EquipamentoBEAN cpu, monitor, mouse = new EquipamentoBEAN();
        cpu = controle.equipamentoPeloNome(equipCPU);
        monitor = controle.equipamentoPeloNome(equipMonitor);
        mouse = controle.equipamentoPeloNome(equipMouse);

        controle.updateEstacaoTrabalho(new EstacaoTrabalhoBEAN(idAlteraEstacaoTrabalho, jTextFieldDescricaoEstacaoTrabalho.getText().toString(),
                monitor.getIdEquipamento(), cpu.getIdEquipamento(), mouse.getIdEquipamento()));

        JOptionPane.showMessageDialog(null, "Estaçao de trabalho atualizada com sucesso!");
        zerarContadorApagarNomeEquipamentos();
        limparCampos();
        atualizaTabela();
        atualizaTabelaEstacoesTrabalho();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTableEstacoesTrabalhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEstacoesTrabalhoMouseClicked
        // TODO add your handling code here:
        jButtonRemoverEquipamento.setEnabled(false);
        this.modeloEquipamentoEstacao = (javax.swing.table.DefaultTableModel) jTableEquipamentosEstacao.getModel();
        
        modeloEquipamentoEstacao.setNumRows(0);

        int linhaEditora = jTableEstacoesTrabalho.getSelectedRow();
        idAlteraEstacaoTrabalho = Integer.parseInt(jTableEstacoesTrabalho.getValueAt(linhaEditora, 0).toString());
        this.jTextFieldDescricaoEstacaoTrabalho.setText(jTableEstacoesTrabalho.getValueAt(linhaEditora, 1).toString());

        EstacaoTrabalhoBEAN estacaoEscolhida = controle.findEstacaoTrabalho(idAlteraEstacaoTrabalho);

        EquipamentoBEAN cpu, monitor, mouse = new EquipamentoBEAN();
        FornecedorBEAN fornCPU, fornMonitor, fornMouse = new FornecedorBEAN();
        cpu = controle.findEquipamento(estacaoEscolhida.getCpu_idEquipamento());
        fornCPU = controle.findFornecedor(cpu.getFornecedor_idFornecedor());
        monitor = controle.findEquipamento(estacaoEscolhida.getMonitor_idEquipamento());
        fornMonitor = controle.findFornecedor(monitor.getFornecedor_idFornecedor());
        mouse = controle.findEquipamento(estacaoEscolhida.getMouseTeclado_idEquipamento());
        fornMouse = controle.findFornecedor(mouse.getFornecedor_idFornecedor());

        modeloEquipamentoEstacao.addRow(new Object[]{cpu.getDescricaoEquipamento(), cpu.getTipoEquipamento(), fornCPU.getRazaoSocial()});
        modeloEquipamentoEstacao.addRow(new Object[]{monitor.getDescricaoEquipamento(), monitor.getTipoEquipamento(), fornMonitor.getRazaoSocial()});
        modeloEquipamentoEstacao.addRow(new Object[]{mouse.getDescricaoEquipamento(), mouse.getTipoEquipamento(), fornMouse.getRazaoSocial()});
    }//GEN-LAST:event_jTableEstacoesTrabalhoMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void zerarContadorApagarNomeEquipamentos() {
        contCPU = 0;
        equipCPU = "";

        contMonitor = 0;
        equipMonitor = "";

        contTeclado = 0;
        equipMouse = "";
    }

    private void limparCampos() {
        jTextFieldDescricaoEstacaoTrabalho.setText("");
        jCheckBoxInativo.setSelected(false);
        jTextFieldBusca.setText("");
        modeloEquipamentoEstacao.setNumRows(0);
    }

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
            java.util.logging.Logger.getLogger(EstacaoTrabalhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstacaoTrabalhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstacaoTrabalhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstacaoTrabalhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstacaoTrabalhoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarEquipamento;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemoverEquipamento;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxInativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEquipamentosDisponiveis;
    private javax.swing.JTable jTableEquipamentosEstacao;
    private javax.swing.JTable jTableEstacoesTrabalho;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldDescricaoEstacaoTrabalho;
    // End of variables declaration//GEN-END:variables

}
