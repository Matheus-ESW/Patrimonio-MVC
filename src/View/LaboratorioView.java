/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Controle;
import Model.AuxLaboratorioEstacaoBEAN;
import Model.EstacaoTrabalhoBEAN;
import Model.LaboratorioBEAN;
import Model.LocalizacaoBEAN;
import Model.MySQLDAO;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class LaboratorioView extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel modeloEstacoesDisponiveis;
    javax.swing.table.DefaultTableModel modeloEstacoesLaboratorio;
    javax.swing.table.DefaultTableModel modeloLaboratorios;
    Controle controle = new Controle();
    ArrayList<AuxLaboratorioEstacaoBEAN> listaLaboratoriosEstacao = new ArrayList<>();
    int idAlteraLaboratorio;
    int contEstacoes = 0;
    long ultimoLabInserido;

    /**
     * Creates new form LaboratorioView
     */
    public LaboratorioView() {
        initComponents();
        listarLocalizacoes();
        this.setTitle("Laboratorios");
        this.atualizaTabelaEstacoesDisponiveis();
        this.atualizaTabelaLaboratorios();
        this.setLocationRelativeTo(null);
    }

    private void atualizaTabelaEstacoesDisponiveis() {
        this.modeloEstacoesDisponiveis = (javax.swing.table.DefaultTableModel) jTableEstacoesDisponiveis.getModel();

        List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho = controle.listaEstacaoTrabalho();
        preencherTabelaEstacoesDisponiveis(listaEstacoesTrabalho);
    }

    private void preencherTabelaEstacoesDisponiveis(List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho) {

        jTableEstacoesDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableEstacoesDisponiveis.getColumnModel().getColumn(1).setPreferredWidth(200);

        modeloEstacoesDisponiveis.setNumRows(0);
        //List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho = controle.listaEstacaoTrabalho();

        try {
            for (EstacaoTrabalhoBEAN estacaoTrabalho : listaEstacoesTrabalho) {

                modeloEstacoesDisponiveis.addRow(new Object[]{estacaoTrabalho.getIdEstacaoTrabalho(), estacaoTrabalho.getDescricaoEstacaoTrabalho()});

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }

    private void atualizaTabelaLaboratorios() {
        this.modeloLaboratorios = (javax.swing.table.DefaultTableModel) jTableLaboratorios.getModel();

        List<LaboratorioBEAN> listaLaboratorios = controle.buscaTodosLaboratorios();
        preencherTabelaLaboratorios(listaLaboratorios);
    }

    private void preencherTabelaLaboratorios(List<LaboratorioBEAN> listaLaboratorios) {

        String isAtivo = "*";

        jTableLaboratorios.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableLaboratorios.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableLaboratorios.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableLaboratorios.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTableLaboratorios.getColumnModel().getColumn(4).setPreferredWidth(200);

        modeloLaboratorios.setNumRows(0);
        //List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho = controle.listaEstacaoTrabalho();
        LocalizacaoBEAN local = new LocalizacaoBEAN();

        try {
            for (LaboratorioBEAN laboratorio : listaLaboratorios) {

                if (laboratorio.getStatusLaboratorio().equals("1")) {
                    if (laboratorio.getStatusLaboratorio().equals("0")) {
                        isAtivo = "Inativo";
                    } else {
                        isAtivo = "Ativo";
                    }

                    local = controle.findLocalizacao(laboratorio.getLocalizacao_idLocalizacao());

                    modeloLaboratorios.addRow(new Object[]{laboratorio.getIdLaboratorio(), laboratorio.getDescricaoLaboratorio(),
                        laboratorio.getNumeroEquipamento(), isAtivo, local.getDescricaoLocalizacao()});
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
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

    private void atualizaTabelaLaboratoriosInativos() {
        this.modeloLaboratorios = (javax.swing.table.DefaultTableModel) jTableLaboratorios.getModel();

        List<LaboratorioBEAN> listaLaboratorios = controle.buscaTodosLaboratorios();
        preencherTabelaLaboratorios(listaLaboratorios);
    }

    private void preencherTabelaLaboratoriosInativos(List<LaboratorioBEAN> listaLaboratorios) {

        String isAtivo = "*";

        jTableLaboratorios.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableLaboratorios.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableLaboratorios.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableLaboratorios.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTableLaboratorios.getColumnModel().getColumn(4).setPreferredWidth(200);

        modeloLaboratorios.setNumRows(0);
        //List<EstacaoTrabalhoBEAN> listaEstacoesTrabalho = controle.listaEstacaoTrabalho();
        LocalizacaoBEAN local = new LocalizacaoBEAN();

        try {
            for (LaboratorioBEAN laboratorio : listaLaboratorios) {

                if (laboratorio.getStatusLaboratorio().equals("0")) {
                    isAtivo = "Inativo";
                } else {
                    isAtivo = "Ativo";
                }

                local = controle.findLocalizacao(laboratorio.getLocalizacao_idLocalizacao());

                modeloLaboratorios.addRow(new Object[]{laboratorio.getIdLaboratorio(), laboratorio.getDescricaoLaboratorio(),
                    laboratorio.getNumeroEquipamento(), isAtivo, local.getDescricaoLocalizacao()});
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
        jTextFieldDescricaoLaboratorio = new javax.swing.JTextField();
        jCheckBoxInativo = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxLocalizacao = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLaboratorios = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldBusca = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jTextFieldNumeroEstacoesTrabalho = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEstacoesLaboratorio = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEstacoesDisponiveis = new javax.swing.JTable();
        jCheckBoxMostrarInativos = new javax.swing.JCheckBox();
        jButtonAdicionarEstacao = new javax.swing.JButton();
        jButtonRemoverEstacao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descriçao Laboratorio");

        jCheckBoxInativo.setText("Inativo");
        jCheckBoxInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxInativoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nº Desktop:");

        jLabel3.setText("Localizaçao:");

        jTableLaboratorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descriçao", "Nº Equipamentos", "Status", "Localizaçao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Long.class
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
        jTableLaboratorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLaboratoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLaboratorios);
        if (jTableLaboratorios.getColumnModel().getColumnCount() > 0) {
            jTableLaboratorios.getColumnModel().getColumn(0).setResizable(false);
            jTableLaboratorios.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableLaboratorios.getColumnModel().getColumn(1).setResizable(false);
            jTableLaboratorios.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableLaboratorios.getColumnModel().getColumn(2).setResizable(false);
            jTableLaboratorios.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableLaboratorios.getColumnModel().getColumn(3).setResizable(false);
            jTableLaboratorios.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableLaboratorios.getColumnModel().getColumn(4).setResizable(false);
            jTableLaboratorios.getColumnModel().getColumn(4).setPreferredWidth(200);
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

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
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

        jTableEstacoesLaboratorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descriçao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableEstacoesLaboratorio);
        if (jTableEstacoesLaboratorio.getColumnModel().getColumnCount() > 0) {
            jTableEstacoesLaboratorio.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableEstacoesLaboratorio.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jTableEstacoesDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descriçao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
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
        jScrollPane3.setViewportView(jTableEstacoesDisponiveis);
        if (jTableEstacoesDisponiveis.getColumnModel().getColumnCount() > 0) {
            jTableEstacoesDisponiveis.getColumnModel().getColumn(0).setResizable(false);
            jTableEstacoesDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableEstacoesDisponiveis.getColumnModel().getColumn(1).setResizable(false);
            jTableEstacoesDisponiveis.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jCheckBoxMostrarInativos.setText("Mostrar Inativos");

        jButtonAdicionarEstacao.setText(">>");
        jButtonAdicionarEstacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarEstacaoActionPerformed(evt);
            }
        });

        jButtonRemoverEstacao.setText("<<");
        jButtonRemoverEstacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverEstacaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Estaçoes Disponives");

        jLabel5.setText("Estaçoes do Laboratorio");

        jLabel6.setText("Laboratorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(231, 231, 231)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionarEstacao)
                                    .addComponent(jButtonRemoverEstacao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldNumeroEstacoesTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxLocalizacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCheckBoxMostrarInativos))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jTextFieldDescricaoLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBoxInativo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldBusca)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricaoLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxInativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNumeroEstacoesTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxMostrarInativos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonAdicionarEstacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverEstacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        new MenuView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void listarLocalizacoes() {

        for (LocalizacaoBEAN localizacao : controle.listaLocalizacoes()) {
            if (localizacao.getStatusLocalizacao().equals("1")) {
                jComboBoxLocalizacao.addItem(localizacao.getDescricaoLocalizacao());
            }
        }
    }

    private void jButtonAdicionarEstacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarEstacaoActionPerformed
        // TODO add your handling code here:

        this.modeloEstacoesLaboratorio = (javax.swing.table.DefaultTableModel) jTableEstacoesLaboratorio.getModel();

        if (contEstacoes <= 0) {
            modeloEstacoesLaboratorio.setNumRows(0);
        }

        int linhaEditora = jTableEstacoesDisponiveis.getSelectedRow();
        jButtonRemoverEstacao.setEnabled(true);

        jTableEstacoesLaboratorio.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableEstacoesLaboratorio.getColumnModel().getColumn(1).setPreferredWidth(200);

        if (jTextFieldNumeroEstacoesTrabalho.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de estaçoes do laboratorio");
            jTextFieldNumeroEstacoesTrabalho.requestFocus();
        } else {
            if (contEstacoes < Integer.parseInt(jTextFieldNumeroEstacoesTrabalho.getText())) {

                listaLaboratoriosEstacao.add(new AuxLaboratorioEstacaoBEAN(ultimoLabInserido,
                        Integer.parseInt(jTableEstacoesDisponiveis.getValueAt(linhaEditora, 0).toString())));

                modeloEstacoesLaboratorio.addRow(new Object[]{jTableEstacoesDisponiveis.getValueAt(linhaEditora, 0).toString(),
                    jTableEstacoesDisponiveis.getValueAt(linhaEditora, 1).toString()});

                ((DefaultTableModel) jTableEstacoesDisponiveis.getModel()).removeRow(jTableEstacoesDisponiveis.getSelectedRow());
                contEstacoes++;
            } else {
                JOptionPane.showMessageDialog(null, "Numero maximo de estaçoes do laboratorio alcançado");
            }
        }
    }//GEN-LAST:event_jButtonAdicionarEstacaoActionPerformed

    private void jButtonRemoverEstacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverEstacaoActionPerformed
        // TODO add your handling code here:

        this.modeloEstacoesLaboratorio = (javax.swing.table.DefaultTableModel) jTableEstacoesLaboratorio.getModel();

        int linhaEditora = jTableEstacoesLaboratorio.getSelectedRow();
        jButtonRemoverEstacao.setEnabled(true);

        jTableEstacoesLaboratorio.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableEstacoesLaboratorio.getColumnModel().getColumn(1).setPreferredWidth(200);

        modeloEstacoesDisponiveis.addRow(new Object[]{jTableEstacoesLaboratorio.getValueAt(linhaEditora, 0).toString(),
            jTableEstacoesLaboratorio.getValueAt(linhaEditora, 1).toString()});

        ((DefaultTableModel) jTableEstacoesLaboratorio.getModel()).removeRow(jTableEstacoesLaboratorio.getSelectedRow());
        contEstacoes--;
    }//GEN-LAST:event_jButtonRemoverEstacaoActionPerformed

    private void jCheckBoxInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxInativoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        String isAtivo = "*";

        if (jTextFieldDescricaoLaboratorio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de descriçao do laboratorio vazio");
            jTextFieldDescricaoLaboratorio.requestFocus();
        } else if (jTextFieldNumeroEstacoesTrabalho.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de numero de equipamento do laboratorio vazio");
            jTextFieldNumeroEstacoesTrabalho.requestFocus();
        } else if (jCheckBoxInativo.isSelected()) {
            isAtivo = "0";
        } else if (!jCheckBoxInativo.isSelected()) {
            isAtivo = "1";
        }

        LocalizacaoBEAN local = new LocalizacaoBEAN();
        local.setDescricaoLocalizacao(jComboBoxLocalizacao.getSelectedItem().toString());
        local = controle.localizacaoDaCombo(local);

        ultimoLabInserido = controle.addLaboratorio(new LaboratorioBEAN(0, jTextFieldDescricaoLaboratorio.getText(),
                Integer.parseInt(jTextFieldNumeroEstacoesTrabalho.getText()), isAtivo, local.getIdLocalizacao()));

        for (int i = 0; i < listaLaboratoriosEstacao.size(); i++) {
            controle.addAuxiliarLabEstacao(new AuxLaboratorioEstacaoBEAN(ultimoLabInserido,
                    listaLaboratoriosEstacao.get(i).getEstacao_trabalho_idEstacaoTrabalho()));
        }

        JOptionPane.showMessageDialog(null, "Laboratorio cadastrado com sucesso!");
        limparCampos();
        atualizaTabelaLaboratorios();
        atualizaTabelaEstacoesDisponiveis();
        modeloEstacoesLaboratorio.setNumRows(0);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:

        LaboratorioBEAN laboratorio = new LaboratorioBEAN();
        laboratorio.setDescricaoLaboratorio(jTextFieldBusca.getText());

        if (jCheckBoxMostrarInativos.isSelected()) {
            ArrayList<LaboratorioBEAN> listaLaboratoriosInativos = controle.listaLaboratoriosInativos();

            if (!listaLaboratoriosInativos.isEmpty()) {
                preencherTabelaLaboratoriosInativos(listaLaboratoriosInativos);
            } else {
                JOptionPane.showMessageDialog(null, "Laboratorio nao encontrado!");
            }
        } else {
            if (jTextFieldBusca.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio!");
            } else {
                ArrayList<LaboratorioBEAN> listaLaboratorio = controle.listaLaboratorioPorNome(laboratorio);

                if (!listaLaboratorio.isEmpty()) {
                    preencherTabelaLaboratorios(listaLaboratorio);
                } else {
                    JOptionPane.showMessageDialog(null, "Laboratorio nao encontrada!");
                }
            }
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jTableLaboratoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLaboratoriosMouseClicked
        // TODO add your handling code here:
        jButtonRemoverEstacao.setEnabled(false);
        this.modeloEstacoesLaboratorio = (javax.swing.table.DefaultTableModel) jTableEstacoesLaboratorio.getModel();

        modeloEstacoesLaboratorio.setNumRows(0);

        int linhaEditora = jTableLaboratorios.getSelectedRow();

        idAlteraLaboratorio = Integer.parseInt(jTableLaboratorios.getValueAt(linhaEditora, 0).toString());
        this.jTextFieldDescricaoLaboratorio.setText(jTableLaboratorios.getValueAt(linhaEditora, 1).toString());
        this.jTextFieldNumeroEstacoesTrabalho.setText(jTableLaboratorios.getValueAt(linhaEditora, 2).toString());

        if (jTableLaboratorios.getValueAt(linhaEditora, 3).toString().equals("Inativo")) {
            jCheckBoxInativo.setSelected(true);
        } else {
            jCheckBoxInativo.setSelected(false);
        }

        String local = jTableLaboratorios.getValueAt(linhaEditora, 4).toString();
        jComboBoxLocalizacao.setSelectedItem(local);

        ArrayList<AuxLaboratorioEstacaoBEAN> listaEstacoesAux = new ArrayList<>();
        listaEstacoesAux = controle.buscaTodosAuxiliares(idAlteraLaboratorio);

        for (int i = 0; i < listaEstacoesAux.size(); i++) {
            EstacaoTrabalhoBEAN estacao = controle.findEstacaoTrabalho(listaEstacoesAux.get(i).getEstacao_trabalho_idEstacaoTrabalho());
            modeloEstacoesLaboratorio.addRow(new Object[]{estacao.getIdEstacaoTrabalho(), estacao.getDescricaoEstacaoTrabalho()});
        }
    }//GEN-LAST:event_jTableLaboratoriosMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:

        String isAtivo = "*";

        LocalizacaoBEAN local = new LocalizacaoBEAN();
        local.setDescricaoLocalizacao(jComboBoxLocalizacao.getSelectedItem().toString());
        local = controle.localizacaoDaCombo(local);

        if (jCheckBoxInativo.isSelected()) {
            isAtivo = "0";
        } else if (!jCheckBoxInativo.isSelected()) {
            isAtivo = "1";
        }

        controle.updateLoboratorio(new LaboratorioBEAN(idAlteraLaboratorio, jTextFieldDescricaoLaboratorio.getText(),
                Integer.parseInt(jTextFieldNumeroEstacoesTrabalho.getText()), isAtivo, local.getIdLocalizacao()));

        if (controle.isExist(idAlteraLaboratorio)) {
            controle.deleteAuxiliarEstacao(idAlteraLaboratorio);

            for (int i = 0; i < listaLaboratoriosEstacao.size(); i++) {
                controle.addAuxiliarLabEstacao(new AuxLaboratorioEstacaoBEAN(idAlteraLaboratorio,
                        listaLaboratoriosEstacao.get(i).getEstacao_trabalho_idEstacaoTrabalho()));
            }
        }

        JOptionPane.showMessageDialog(null, "Laboratorio alterado com sucesso!");
        limparCampos();
        atualizaTabelaLaboratorios();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void limparCampos() {
        jTextFieldDescricaoLaboratorio.setText("");
        jTextFieldNumeroEstacoesTrabalho.setText("");
        jCheckBoxInativo.setSelected(false);
        jComboBoxLocalizacao.setSelectedIndex(0);
        jTextFieldBusca.setText("");
        jCheckBoxMostrarInativos.setSelected(false);
        modeloEstacoesLaboratorio.setNumRows(0);
        listaLaboratoriosEstacao.clear();
        idAlteraLaboratorio = 0;
        contEstacoes = 0;
        atualizaTabelaLaboratorios();
        atualizaTabelaEstacoesDisponiveis();
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
            java.util.logging.Logger.getLogger(LaboratorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaboratorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaboratorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaboratorioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaboratorioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarEstacao;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemoverEstacao;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxInativo;
    private javax.swing.JCheckBox jCheckBoxMostrarInativos;
    private javax.swing.JComboBox<String> jComboBoxLocalizacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEstacoesDisponiveis;
    private javax.swing.JTable jTableEstacoesLaboratorio;
    private javax.swing.JTable jTableLaboratorios;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldDescricaoLaboratorio;
    private javax.swing.JTextField jTextFieldNumeroEstacoesTrabalho;
    // End of variables declaration//GEN-END:variables

}
