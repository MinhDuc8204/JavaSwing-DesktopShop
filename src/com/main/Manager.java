/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author DUC
 */
public class Manager extends javax.swing.JFrame {
    private DefaultTableModel model;
    private int select;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private String nameLG="tester";
    /**
     * Creates new form Manager
     */
    public Manager(String a) throws ClassNotFoundException, SQLException {
        this.nameLG=a;
        
        initComponents();
        namelogin.setText(nameLG);
        listVoucher();
        listSp();
        listDon();
        listDoanhthu();
    }
    void listDoanhthu() throws ClassNotFoundException, SQLException{
        Connection conn=db.DBconnect.getConnection();
        String sql="select *from login";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            System.out.println(nameLG+"\t"+rs.getString(1));
            if(rs.getString(1).equals(nameLG)){
                doanhthu.setText(rs.getInt(3)+"");
                slsp.setText(rs.getInt(4)+"");
                break;
            }
        }
        
    }
    void listDon() throws ClassNotFoundException, SQLException{
        Connection conn=db.DBconnect.getConnection();
        String sql="select *from khachhang";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            JButton but = new javax.swing.JButton();
            but.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
            but.setForeground(new java.awt.Color(255, 51, 51));
            but.setText("Đơn Hàng Mới từ: "+rs.getString(1).replaceAll("  ", ""));
            String NAMESP=rs.getString(5);
            nhapnhay(but);
            but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        try {
                            new xacnhandonhang(NAMESP, nameLG).setVisible(true);
                            dispose();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            donhang.add(but);
        }
        

    }
    void listSp() throws ClassNotFoundException, SQLException{
        model2=(DefaultTableModel)tbsp.getModel();
        Connection conn=db.DBconnect.getConnection();
        String sql="select *from laptop";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Vector data = new Vector();  
            data.add(rs.getString(1));
            data.add(rs.getString(5));
            data.add(rs.getString(10));
            model2.addRow(data);
            
        }
        tbsp.setModel(model2);
    }
    void listVoucher() throws ClassNotFoundException, SQLException{
        model1=(DefaultTableModel)tbvoucher.getModel();
        Connection conn=db.DBconnect.getConnection();
        String sql="select *from voucher";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Vector data = new Vector();  
            data.add(rs.getString(1));
            data.add(rs.getInt(2));
            data.add(rs.getInt(3));
            model1.addRow(data);
            
        }
        tbvoucher.setModel(model1);
    }
    void nhapnhay(JButton a){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    if(i%2==0){
                        a.setForeground(new java.awt.Color(255, 51, 51));
                        hello.setForeground(new java.awt.Color(255, 255, 51));
                    }else if(i%3==0){
                        a.setForeground(new java.awt.Color(0, 255, 0));
                        hello.setForeground(new java.awt.Color(255, 51, 51));
                    }else{
                        a.setForeground(new java.awt.Color(255, 255, 51));
                        hello.setForeground(new java.awt.Color(0, 255, 0));
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        donhang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbsp = new javax.swing.JTable();
        delsp = new javax.swing.JButton();
        addsp = new javax.swing.JButton();
        editsp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbvoucher = new javax.swing.JTable();
        editvc = new javax.swing.JButton();
        delvc = new javax.swing.JButton();
        addvc = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        doanhthu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        slsp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        namelogin = new javax.swing.JLabel();
        hello = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        donhang.setLayout(new java.awt.GridLayout(7, 1));
        jPanel1.add(donhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 550));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Quản Lý VOUCHER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 190, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Card đồ họa", "Giá SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbsp.setRowHeight(25);
        tbsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbsp);
        if (tbsp.getColumnModel().getColumnCount() > 0) {
            tbsp.getColumnModel().getColumn(0).setPreferredWidth(160);
            tbsp.getColumnModel().getColumn(1).setPreferredWidth(220);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 270));

        delsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delsp.setText("Xóa");
        delsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delspMouseClicked(evt);
            }
        });
        delsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delspActionPerformed(evt);
            }
        });
        jPanel3.add(delsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, -1, 30));

        addsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addsp.setText("Thêm sản phảm");
        addsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addspMouseClicked(evt);
            }
        });
        jPanel3.add(addsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, 30));

        editsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editsp.setText("Chỉnh sửa");
        editsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editspMouseClicked(evt);
            }
        });
        editsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editspActionPerformed(evt);
            }
        });
        jPanel3.add(editsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 100, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 820, 330));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Quản Lý Đơn Hàng");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 40));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tbvoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảm giá", "Giảm (%)", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbvoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbvoucherMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbvoucher);
        if (tbvoucher.getColumnModel().getColumnCount() > 0) {
            tbvoucher.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 530, 110));

        editvc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editvc.setText("Chỉnh sửa");
        editvc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editvcMouseClicked(evt);
            }
        });
        editvc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editvcActionPerformed(evt);
            }
        });
        jPanel4.add(editvc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 100, 30));

        delvc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delvc.setText("Xóa");
        delvc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delvcMouseClicked(evt);
            }
        });
        jPanel4.add(delvc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, 30));

        addvc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addvc.setText("Thêm VOUCHER");
        addvc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addvcMouseClicked(evt);
            }
        });
        jPanel4.add(addvc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 550, 170));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Quản Lý Sản Phẩm");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 230, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 820, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Back to UI");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doanhthu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doanhthu.setForeground(new java.awt.Color(255, 51, 51));
        doanhthu.setText("560000000");
        doanhthu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel6.add(doanhthu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 0));
        jLabel5.setText("Số lượng SP đã bán :");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 30));

        slsp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        slsp.setForeground(new java.awt.Color(255, 51, 51));
        slsp.setText("100");
        jPanel6.add(slsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 70, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 0));
        jLabel7.setText("Doanh thu :");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 80, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("VND");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 40, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 100));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 230, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 420, 250, 190));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namelogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        namelogin.setText("minhduc8204");
        jPanel7.add(namelogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 40));

        hello.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        hello.setText("Hi !");
        jPanel7.add(hello, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 170, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editspActionPerformed

    private void editvcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editvcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editvcActionPerformed

    private void tbspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbspMouseClicked
        model=(DefaultTableModel)tbsp.getModel();
        select=tbsp.getSelectedRow();
    }//GEN-LAST:event_tbspMouseClicked

    private void delspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delspActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addspMouseClicked
        new addSP(nameLG).setVisible(true); dispose();
    }//GEN-LAST:event_addspMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        new Home().setVisible(true); dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void editspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editspMouseClicked
        if(tbsp.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
        }else{
            try {
                editSP a=new editSP((String) model.getValueAt(select, 0), nameLG);
                a.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
    }//GEN-LAST:event_editspMouseClicked

    private void delspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delspMouseClicked
        if(tbsp.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
        }else{
            try {
                Connection conn=db.DBconnect.getConnection();
                String sql="select *from laptop";
                PreparedStatement ps=conn.prepareCall(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(rs.getString(1).contains((String) model.getValueAt(select, 0))){
                        sql="delete from laptop where Name='"+(String) model.getValueAt(select, 0)+"';";
                        ps=conn.prepareCall(sql);
                        ps.execute();
                        break;
                    }
                    
                }
                this.dispose();
                new Manager(nameLG).setVisible(true);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_delspMouseClicked
    
    private void delvcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delvcMouseClicked
        if(tbvoucher.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
        }else{
            try {
                Connection conn=db.DBconnect.getConnection();
                String sql="select *from voucher";
                PreparedStatement ps=conn.prepareCall(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(rs.getString(1).contains((String) model.getValueAt(select, 0))){
                        sql="delete from voucher where ma='"+(String) model.getValueAt(select, 0)+"';";
                        ps=conn.prepareCall(sql);
                        ps.execute();
                        break;
                    }
                }
                new Manager(nameLG).setVisible(true); dispose();
            } catch (Exception e) {
            }            
        }
    }//GEN-LAST:event_delvcMouseClicked

    private void editvcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editvcMouseClicked
        if(tbvoucher.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
        }else{
            try {
                editvoucher a=new editvoucher((String) model.getValueAt(select, 0), nameLG);
                a.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
    }//GEN-LAST:event_editvcMouseClicked

    private void tbvoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbvoucherMouseClicked
        model=(DefaultTableModel)tbvoucher.getModel();
        select=tbvoucher.getSelectedRow();
    }//GEN-LAST:event_tbvoucherMouseClicked

    private void addvcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addvcMouseClicked
        new addvoucher(nameLG).setVisible(true); dispose();
    }//GEN-LAST:event_addvcMouseClicked

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
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Manager("ccc").setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addsp;
    private javax.swing.JButton addvc;
    private javax.swing.JButton delsp;
    private javax.swing.JButton delvc;
    private javax.swing.JLabel doanhthu;
    private javax.swing.JPanel donhang;
    private javax.swing.JButton editsp;
    private javax.swing.JButton editvc;
    private javax.swing.JLabel hello;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel namelogin;
    private javax.swing.JLabel slsp;
    private javax.swing.JTable tbsp;
    private javax.swing.JTable tbvoucher;
    // End of variables declaration//GEN-END:variables
}
