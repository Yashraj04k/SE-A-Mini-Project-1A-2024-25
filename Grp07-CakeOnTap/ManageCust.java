/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CakeOnTap;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.function.Function;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author vaish444
 */
public class ManageCust extends javax.swing.JFrame {
    private static final String username = "root";
    private static final String password = "123456";
    private static final String dataConn = "jdbc:mysql://localhost:3306/cake_on_tap";
    
    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet rs= null;
    int q,i,id,deleteItem;

    /**
     * Creates new form ManageCust
     */
    public ManageCust() {
        initComponents();
        upDateDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    //=====================================Function======================================================
    public void upDateDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(dataConn, username, password);
            pst = Con.prepareStatement("select * from customization");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                
                for(i=1;i<=q;i++){
                    columnData.add(rs.getString("id"));
                    columnData.add(rs.getString("options"));
                    columnData.add(rs.getString("price"));
                    
                }
                RecordTable.addRow(columnData);  
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtprice = new javax.swing.JTextField();
        txtsr = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jbtnclear = new javax.swing.JButton();
        jbtnadd = new javax.swing.JButton();
        jbtnupdate = new javax.swing.JButton();
        jbtndelete = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtoption = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("ADD PRICE:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jTable1.setBackground(new java.awt.Color(255, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNO.", "CUSTOMIZATION OPTION", "PRICE"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 560, 360));

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 280, 50));

        txtsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsrActionPerformed(evt);
            }
        });
        jPanel1.add(txtsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 280, 50));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText("CUSTOMIZATION");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText("SNO:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jbtnclear.setBackground(new java.awt.Color(190, 106, 51));
        jbtnclear.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jbtnclear.setForeground(new java.awt.Color(102, 0, 0));
        jbtnclear.setText("CLEAR");
        jbtnclear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnclearActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 110, 40));

        jbtnadd.setBackground(new java.awt.Color(190, 106, 51));
        jbtnadd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jbtnadd.setForeground(new java.awt.Color(102, 0, 0));
        jbtnadd.setText("ADD");
        jbtnadd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnaddActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 110, 40));

        jbtnupdate.setBackground(new java.awt.Color(190, 106, 51));
        jbtnupdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jbtnupdate.setForeground(new java.awt.Color(102, 0, 0));
        jbtnupdate.setText("UPDATE");
        jbtnupdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 110, 40));

        jbtndelete.setBackground(new java.awt.Color(190, 106, 51));
        jbtndelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jbtndelete.setForeground(new java.awt.Color(102, 0, 0));
        jbtndelete.setText("DELETE");
        jbtndelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jbtndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 110, 40));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 0));
        jLabel13.setText("ADD OPTION:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        txtoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtoptionActionPerformed(evt);
            }
        });
        jPanel1.add(txtoption, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 280, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsrActionPerformed

    private void jbtnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnaddActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(dataConn, username, password);
            pst = Con.prepareStatement("insert into customization(id,options,price)value(?,?,?)");

            pst.setString(1, txtsr.getText());
            pst.setString(2, txtoption.getText());
            pst.setString(3, txtprice.getText());
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Added!!");
            upDateDB();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCakes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ManageCakes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jbtnaddActionPerformed

    private void jbtnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnupdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();

        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(dataConn, username, password);
            pst = Con.prepareStatement("update customization set  options =?,price=? where  id =?");
            
            pst.setString(3, txtsr.getText());
            pst.setString(1, txtoption.getText());
            pst.setString(2, txtprice.getText());
           

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated!!");
            upDateDB();
            
            txtsr.setText("");
            txtoption.setText("");
            txtprice.setText("");
                
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCakes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ManageCakes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        
    }//GEN-LAST:event_jbtnupdateActionPerformed

    private void jbtndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtndeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        
        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null,"Confirm If you want to delete ??","warning",JOptionPane.YES_NO_OPTION);
            if (deleteItem==JOptionPane.YES_OPTION)
            {
                Class.forName("com.mysql.jdbc.Driver");
                Con = DriverManager.getConnection(dataConn, username, password);
                pst = Con.prepareStatement("delete from customization where id=?");
                pst.setInt(1,id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Deleted!!");
                upDateDB();
                
                txtsr.setText(""); 
                txtoption.setText("");
                txtprice.setText("");        
                
            }
        }catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCakes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex){
            System.err.println(ex);
        }
        
    }//GEN-LAST:event_jbtndeleteActionPerformed

    private void txtoptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtoptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoptionActionPerformed

    private void jbtnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnclearActionPerformed
        // TODO add your handling code here:
        txtsr.setText("");
        txtoption.setText("");        
        txtprice.setText("");
    }//GEN-LAST:event_jbtnclearActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedIndex = jTable1.getSelectedRow();
        
        txtsr.setText(RecordTable.getValueAt(SelectedIndex, 0).toString());
        txtoption.setText(RecordTable.getValueAt(SelectedIndex, 1).toString());
        txtprice.setText(RecordTable.getValueAt(SelectedIndex, 2).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        AdminDashboard ad=new AdminDashboard();
        ad.show();
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(ManageCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCust().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnadd;
    private javax.swing.JButton jbtnclear;
    private javax.swing.JButton jbtndelete;
    private javax.swing.JButton jbtnupdate;
    private javax.swing.JTextField txtoption;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtsr;
    // End of variables declaration//GEN-END:variables
}
