/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ProdutoDAO;
import controller.CarrinhoDAO;
import model.Produto;

import java.awt.Component;
import java.awt.Image;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Andre Fernando Machado - 837864
 */
public class CarrinhoView extends javax.swing.JFrame {

    public CarrinhoView() {
        initComponents();
        configColumn();
        setResizable(false);
        setTitle("Carrinho de Compras");
        setLocationRelativeTo(null);
    }

    private void configColumn() {
        preencherTabela();
        tabCarrinho.setRowHeight(90);

        tabCarrinho.getColumnModel().getColumn(0).setCellRenderer(new CarrinhoView.ImageRender());
        tabCarrinho.getColumnModel().getColumn(0).setPreferredWidth(80);

        tabCarrinho.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabCarrinho.getColumnModel().getColumn(2).setPreferredWidth(25);

    }

    private void configurarTabela() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        m.addColumn("Produto");
        m.addColumn("Nome");
        m.addColumn("Qntd");
        m.addColumn("Preço");

        tabCarrinho.setModel(m);
    }

    private void preencherTabela() {
        configurarTabela();
        DefaultTableModel m = (DefaultTableModel) tabCarrinho.getModel();

        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        List<Produto> produtosCarrinho = carrinhoDAO.getCarrinhoPorUsuario();

        double carrinhoTotal = 0.0;

        for (Produto p : produtosCarrinho) {
            double totalProduto = p.getQuantidade() * p.getPreco();
            carrinhoTotal += totalProduto;
            m.addRow(new Object[]{
                p.getNome(),
                p.getNome(),
                p.getQuantidade(),
                "R$ " + p.getPreco()
            });
        }

        txtCarrinhoTotal.setText(String.valueOf(String.format("%.2f", carrinhoTotal)));

        tabCarrinho.setModel(m);
    }

    private class ImageRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String fotoNome = value.toString();
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon("src/images/" + fotoNome + ".jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
            return new JLabel(imageIcon);
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

        jLabel2 = new javax.swing.JLabel();
        btn_Sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabCarrinho = new javax.swing.JTable();
        txtCarrinhoTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnFinalizarCompra = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo3 (Personalizado) (2).png"))); // NOI18N

        btn_Sair.setBackground(new java.awt.Color(255, 255, 255));
        btn_Sair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Sair.setForeground(new java.awt.Color(255, 0, 0));
        btn_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-left.png"))); // NOI18N
        btn_Sair.setText("Voltar");
        btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-cart-empty-side-view.png"))); // NOI18N
        jLabel1.setText("Carrinho");

        tabCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCarrinho.setRowHeight(30);
        tabCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabCarrinho);
        if (tabCarrinho.getColumnModel().getColumnCount() > 0) {
            tabCarrinho.getColumnModel().getColumn(0).setResizable(false);
            tabCarrinho.getColumnModel().getColumn(1).setResizable(false);
            tabCarrinho.getColumnModel().getColumn(2).setResizable(false);
            tabCarrinho.getColumnModel().getColumn(3).setResizable(false);
        }

        txtCarrinhoTotal.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("TOTAL:");

        jLabel3.setText("R$");

        btnFinalizarCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFinalizarCompra.setForeground(new java.awt.Color(0, 0, 0));
        btnFinalizarCompra.setText("Finalizar Compra");
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(142, 142, 142));
        jLabel5.setText("Para a exclusão de um produto basta clicar!");
        jLabel5.setFocusable(false);
        jLabel5.setRequestFocusEnabled(false);
        jLabel5.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(3, 3, 3)
                                .addComponent(txtCarrinhoTotal))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Sair)
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(btnFinalizarCompra)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Sair)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCarrinhoTotal)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SairActionPerformed
        dispose();
        PaginaInicialView f = new PaginaInicialView();
        f.setVisible(true);
    }//GEN-LAST:event_btn_SairActionPerformed

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        if(txtCarrinhoTotal.getText().equals("0,00")){
            JOptionPane.showMessageDialog(null, "Carrinho Vazio");
        }else{
            PagamentoView p = new PagamentoView();
            p.setVisible(true);
        
        }
    }//GEN-LAST:event_btnFinalizarCompraActionPerformed

    private void tabCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabCarrinhoMouseClicked
        int index = tabCarrinho.getSelectedRow();
        TableModel p = tabCarrinho.getModel();

        
        
        int id = new ProdutoDAO().getProdutoIdByNome(p.getValueAt(index, 0).toString());
        
        int qnt = Integer.parseInt(p.getValueAt(index, 2).toString());

        if (qnt < 2) {
            if (new CarrinhoDAO().deletarProdutoCarrinho(id)) {
                configColumn();
                JOptionPane.showMessageDialog(null, "apagado");
            }
        } else {
            Object[] options = {"Excluir do Carrinho", "Remover Apenas 1 unidade"};
            int op = JOptionPane.showOptionDialog(null, "Deseja Apagar o produto ou Remover 1 unidade?", "Edição do Carrinho", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (String.valueOf(op).equals("1")) {
                if (new CarrinhoDAO().diminuirProdutoCarrinho(id)) {
                    configColumn();
                    return;
                };
            }
            new CarrinhoDAO().deletarProdutoCarrinho(id);
        }
        configColumn();

    }//GEN-LAST:event_tabCarrinhoMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarrinhoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JButton btn_Sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabCarrinho;
    private javax.swing.JLabel txtCarrinhoTotal;
    // End of variables declaration//GEN-END:variables
}
