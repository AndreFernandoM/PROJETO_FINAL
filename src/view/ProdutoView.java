/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;

import model.Produto;
import controller.ProdutoDAO;
import controller.CarrinhoDAO;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Andre Fernando Machado - 837864
 */
public class ProdutoView extends javax.swing.JFrame {

    int quantidadeProduto = 1;
    double parcela = 10;

    double precoFrete;
    int id;

    /**
     * Creates new form ProdutoView
     */
    public ProdutoView() {
        setUndecorated(true);
        setResizable(false);
        initComponents();

        setLocationRelativeTo(null);
        txtCepValido.setVisible(false);

    }

    public ProdutoView(int id) {
        setUndecorated(true);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        txtCepValido.setVisible(false);

        Produto p = new ProdutoDAO().getProduto(id);
        SpinnerModel sp = new SpinnerNumberModel();

        txtNome.setText(p.getNome());
        txtDescricao.setText(p.getDescricao());
        txtQuantidade.setText(String.valueOf(p.getQuantidade()));
        txtPreco.setText(String.valueOf(p.getPreco()));

        txtParcela.setText("10 x R$: " + String.valueOf(String.format("%.2f", ((p.getPreco() + parcela) / 10))));
        this.id = p.getId();

        this.precoFrete = (p.getPreco() + 10);

        ImageIcon imgProd = new ImageIcon(
                new ImageIcon("src/images/" + p.getNome() + ".jpg").getImage().getScaledInstance(177, 177, Image.SCALE_DEFAULT));
        imgProduto.setIcon(imgProd);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVoltar = new javax.swing.JButton();
        txtNome = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtPreco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtParcela = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCarrinho = new javax.swing.JButton();
        txtCalcFrete = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btnFrete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JLabel();
        txtPrecoFrete = new javax.swing.JLabel();
        txtCepValido = new javax.swing.JLabel();
        spnQuantidade = new javax.swing.JSpinner();
        imgProduto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Descrição");
        setAutoRequestFocus(false);
        setUndecorated(true);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-left.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtNome.setText("Nome do Produto");

        jScrollPane2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(214, 217, 223));
        jScrollPane2.setFocusable(false);
        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane2.setRequestFocusEnabled(false);

        txtDescricao.setEditable(false);
        txtDescricao.setBackground(new java.awt.Color(165, 167, 172));
        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(0, 0, 0));
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        txtDescricao.setAutoscrolls(false);
        txtDescricao.setCaretColor(new java.awt.Color(0, 0, 0));
        txtDescricao.setEnabled(false);
        txtDescricao.setFocusable(false);
        txtDescricao.setOpaque(false);
        jScrollPane2.setViewportView(txtDescricao);

        txtPreco.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Preço");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("R$: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("ou");

        txtParcela.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtParcela.setForeground(new java.awt.Color(255, 0, 51));

        btnCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-cart-empty-side-view.png"))); // NOI18N
        btnCarrinho.setText("Adicionar Ao Carrinho");
        btnCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrinhoActionPerformed(evt);
            }
        });

        try {
            txtCalcFrete.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCalcFrete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCalcFreteFocusGained(evt);
            }
        });

        jLabel5.setText("Calcular com FRETE:");

        btnFrete.setText("Calcular");
        btnFrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFreteActionPerformed(evt);
            }
        });

        jLabel6.setText("Restantes:");

        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtPrecoFrete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtCepValido.setForeground(new java.awt.Color(255, 0, 0));
        txtCepValido.setText("Informe um CEP válido");
        txtCepValido.setFocusable(false);
        txtCepValido.setOpaque(true);
        txtCepValido.setRequestFocusEnabled(false);

        spnQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnQuantidade.setEditor(new javax.swing.JSpinner.NumberEditor(spnQuantidade, ""));
        spnQuantidade.setName("1"); // NOI18N
        spnQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnQuantidadeStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCepValido)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCalcFrete)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFrete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPrecoFrete))
                        .addGap(12, 12, 12)
                        .addComponent(btnCarrinho)
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(txtNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtParcela, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtPreco))
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(imgProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6))
                                        .addGap(10, 10, 10)
                                        .addComponent(txtQuantidade)))))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 518, Short.MAX_VALUE)
                        .addComponent(btnVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPreco))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(txtParcela)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imgProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecoFrete))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCarrinho)
                    .addComponent(txtCalcFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFrete)
                    .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(txtCepValido)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
//TODO: ARRUMAR ADICIONAR NO CARRINHO 
    private void btnCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrinhoActionPerformed
        int maxAllowed = Integer.parseInt(spnQuantidade.getValue().toString());
        System.out.println(maxAllowed);
        int quantAtual = new ProdutoDAO().getQuantProduto(this.id) - new CarrinhoDAO().getQuantCarrinho(this.id);
        System.out.println(quantAtual);
        
        System.out.println(String.valueOf(txtQuantidade.getText()));
        
        if (!((Integer.parseInt(spnQuantidade.getValue().toString())) >= (new ProdutoDAO().getQuantProduto(this.id) - new CarrinhoDAO().getQuantCarrinho(this.id)))) {
            new CarrinhoDAO().adicionarProdutoAoCarrinho(this.id, Integer.parseInt(spnQuantidade.getValue().toString()));
            JOptionPane.showMessageDialog(null, "Produto Adicionado Ao Carrinho! ");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Sem estoque disponivel, por favor diminua a quantidade");

        }


    }//GEN-LAST:event_btnCarrinhoActionPerformed

    private void btnFreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFreteActionPerformed
        if (!txtCalcFrete.getText().isEmpty()) {
            txtPrecoFrete.setText(String.valueOf(String.format("%.2f", precoFrete)));
            txtCalcFrete.setBackground(Color.WHITE);
            txtCepValido.setVisible(false);

        } else {
            txtCalcFrete.setBackground(new Color(255, 0, 0, 60));
            txtCepValido.setVisible(true);

        }
    }//GEN-LAST:event_btnFreteActionPerformed

    private void txtCalcFreteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalcFreteFocusGained
        txtCalcFrete.setBackground(Color.white);
        txtCepValido.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalcFreteFocusGained

    private void spnQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnQuantidadeStateChanged
        quantidadeProduto = spnQuantidade.getComponentCount();


    }//GEN-LAST:event_spnQuantidadeStateChanged

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ProdutoView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarrinho;
    private javax.swing.JButton btnFrete;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel imgProduto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spnQuantidade;
    private javax.swing.JFormattedTextField txtCalcFrete;
    private javax.swing.JLabel txtCepValido;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtParcela;
    private javax.swing.JLabel txtPreco;
    private javax.swing.JLabel txtPrecoFrete;
    private javax.swing.JLabel txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
