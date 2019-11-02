/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package face;

import java.sql.*;
import conection.ModuloConnection;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author RIBEIRO
 */
public class cadastro_finança extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form cadastro_finança
     */
    public cadastro_finança() {
        initComponents();
        conexao = ModuloConnection.conector();
    }
// metodo para adicionar uma finança
 private void adicionar() {
        String sql = "insert into cadastro_financeiro(DescCompra, Valor, NomeTipo, Tempo) values(?, ?, ?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtDC.getText());
            pst.setString(2, txtValor.getText());
            pst.setString(3, txtTipo.getText());
            pst.setString(4, txtTempo.getText());
            //verifica campos obrigatorios
            if ((txtDC.getText().isEmpty()) || (txtValor.getText().isEmpty()) || (txtTipo.getText().isEmpty()) || (txtTempo.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios!");
            } else {
            
            
            //a linha abaixo atualiza a tabela cadastro
            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Finança cadastrado com sucesso!");
                txtDC.setText(null);
                txtValor.setText(null);
                txtTipo.setText(null);
                txtTempo.setText(null);
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
 private void pesquisa_financa(){
     String sql = "select * from cadastro_financeiro where DescCompra like ? ";
     try {
         pst = conexao.prepareStatement(sql);
         //passando o conteudo da caixa de pesquisa para o interroga
         pst.setString(1, txtbarraPesq.getText() + "%");
         rs=pst.executeQuery();
         //a linha a baixo usa a biblioteca rs2xml.jar para preencher a tabela
         financas.setModel(DbUtils.resultSetToTableModel(rs));
         
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
     }
     
 }
    
 public void setar_campos(){
     int setar = financas .getSelectedRow();
     txtId.setText(financas.getModel().getValueAt(setar,1).toString());
     txtDC.setText(financas.getModel().getValueAt(setar,2).toString());
     txtTipo.setText(financas.getModel().getValueAt(setar,4).toString());
     txtValor.setText(financas.getModel().getValueAt(setar,3).toString());
     txtTempo.setText(financas.getModel().getValueAt(setar,5).toString());
 }
 
 private void alterar(){
        String sql="update cadastro_financeiro set DescCompra=?, Valor=?, NomeTipo=?, Tempo=? where NCadastro=? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtDC.getText());
            pst.setString(2, txtValor.getText());
            pst.setString(3, txtTipo.getText());
            pst.setString(4, txtTempo.getText());
            pst.setString(5, txtId.getText());
    
            if ((txtDC.getText().isEmpty()) || (txtValor.getText().isEmpty()) || (txtTipo.getText().isEmpty()) || (txtTempo.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios!");
            } else {
            
            
            //a linha abaixo altera a tabela cadastro
            int adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do usuário alterado com sucesso!");
                txtDC.setText(null);
                txtValor.setText(null);
                txtTipo.setText(null);
                txtTempo.setText(null);
               
            }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
 //REMOVER
 
 private void remover(){
        // a estrutura abaixo confirma a remoçao
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta finança!", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql="delete from cadastro_financeiro where NCadastro=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int apagado = pst.executeUpdate();
                if(apagado >0){
                    JOptionPane.showMessageDialog(null, "apagado com sucesso!");
                    txtDC.setText(null);
                    txtTipo.setText(null);
                    txtValor.setText(null);
                    txtTempo.setText(null);
                   
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        jLabel5 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtbarraPesq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        financas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTempo = new javax.swing.JTextField();
        lblAdd = new javax.swing.JButton();
        lblEditar = new javax.swing.JButton();
        lblRemover = new javax.swing.JButton();
        lblSair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("CADASTRO FINANÇAS");

        lblUsuario.setText("*Campos obrigarios");

        txtbarraPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbarraPesqKeyReleased(evt);
            }
        });

        financas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descriçao da compra", "Tipo", "Valor", "Tempo"
            }
        ));
        financas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                financasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(financas);

        jLabel1.setText("*Descriçao da compra");

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        jLabel2.setText("*Tipo");

        txtDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDCActionPerformed(evt);
            }
        });

        jLabel3.setText("*Valor");

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        jLabel4.setText("*Tempo");

        txtTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempoActionPerformed(evt);
            }
        });

        lblAdd.setText("ADICIONAR");
        lblAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblAddActionPerformed(evt);
            }
        });

        lblEditar.setText("EDITAR");
        lblEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblEditarActionPerformed(evt);
            }
        });

        lblRemover.setText("REMOVER");
        lblRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblRemoverActionPerformed(evt);
            }
        });

        lblSair.setText("VOLTAR");
        lblSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSairActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtbarraPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuario)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(354, 354, 354)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(lblEditar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAdd)
                                .addGap(136, 136, 136)
                                .addComponent(lblRemover)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(lblSair)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbarraPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdd)
                    .addComponent(lblEditar)
                    .addComponent(lblRemover)
                    .addComponent(lblSair))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDCActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempoActionPerformed

    private void lblAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblAddActionPerformed
        // Adicina uma finança:
        adicionar();
    }//GEN-LAST:event_lblAddActionPerformed

    private void lblEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblEditarActionPerformed
        // chamando a funçao
        alterar();
    }//GEN-LAST:event_lblEditarActionPerformed

    private void lblRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblRemoverActionPerformed
        // removendo
        remover();
    }//GEN-LAST:event_lblRemoverActionPerformed

    private void lblSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSairActionPerformed

    private void txtbarraPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarraPesqKeyReleased
        // chamar o metodo pesquisar finanças
        pesquisa_financa();
    }//GEN-LAST:event_txtbarraPesqKeyReleased

    private void financasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_financasMouseClicked
        //Sera usado para setar os campos da tabelas e clicar
        setar_campos();
    }//GEN-LAST:event_financasMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

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
            java.util.logging.Logger.getLogger(cadastro_finança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastro_finança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastro_finança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastro_finança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro_finança().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable financas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lblAdd;
    private javax.swing.JButton lblEditar;
    private javax.swing.JButton lblRemover;
    private javax.swing.JButton lblSair;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTempo;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtbarraPesq;
    // End of variables declaration//GEN-END:variables
}
