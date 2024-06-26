/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.main;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.text.StyleConstants.FontFamily;

/**
 *
 * @author DUC
 */
public class xacnhandonhang extends javax.swing.JFrame {
    private String tensp, tenkh;
    private String LG;
    private int gia, soluong;
    private float tong;
    /**
     * Creates new form xacnhandonhang
     */
    public xacnhandonhang(String ten, String mana) throws SQLException, ClassNotFoundException {
        this.tensp=ten;
        this.LG=mana;
        initComponents();
        listdata();
        diachi.setEditable(false);
        note.setEditable(false);
    }
    void listdata() throws SQLException, ClassNotFoundException{
        Connection conn=db.DBconnect.getConnection();   
        String sql="select *from laptop";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getString(1).contains(tensp)){
                name.setText(rs.getString(1).replaceAll("  ", ""));
                cpu.setText(rs.getString(2).replaceAll("  ", ""));
                ram.setText(rs.getString(3).replaceAll("  ", ""));
                ssd.setText(rs.getString(4).replaceAll("  ", ""));
                vga.setText(rs.getString(5).replaceAll("  ", ""));
                display.setText(rs.getString(6).replaceAll("  ", ""));
                color.setText(rs.getString(7).replaceAll("  ", ""));
                scaleImage(rs.getString(11).replaceAll("  ", ""), img);
                
                DG.setText(rs.getString(10).replaceAll("  ", ""));
                
                gia=rs.getInt(8);
                break;
            }            
        }
        sql="select *from khachhang";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getString(5).contains(tensp)){
                tenkh=rs.getString(1);
                namekh.setText(rs.getString(1).replaceAll("  ", ""));
                sdt.setText(rs.getString(2).replaceAll("  ", ""));
                diachi.setText(rs.getString(3).replaceAll("  ", ""));
                note.setText(rs.getString(4).replaceAll("  ", ""));
                
                NAME.setText(rs.getString(5).replaceAll("  ", ""));
                SL.setText(rs.getString(6).replaceAll("  ", ""));
                voucher.setText(rs.getString(7).replaceAll("  ", ""));
                TONGTIEN.setText(rs.getString(8).replaceAll("  ", ""));
                
                soluong=rs.getInt(6);
                tong=gia*rs.getInt(6);
                TGia.setText((int)tong+"");
                tong=tong*((float)rs.getInt(7)/100);
                tiengiam.setText((tong)+"");
                tong=rs.getInt(8);
            }
        }
    }
    private void scaleImage(String location, JLabel label){
        ImageIcon icon = new ImageIcon(location);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
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
        ttsp = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        NAME = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tiengiam = new javax.swing.JLabel();
        SL = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        TGia = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        voucher = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TONGTIEN = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        DG = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sdt = new javax.swing.JLabel();
        namekh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        note = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        diachi = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        hoadon = new javax.swing.JButton();
        xacnhan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        huy1 = new javax.swing.JButton();
        huy2 = new javax.swing.JButton();
        ttsp2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        name = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cpu = new javax.swing.JLabel();
        ssd = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        ram = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        vga = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        color = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ttsp.setBackground(new java.awt.Color(255, 255, 255));
        ttsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ttsp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 153));
        jLabel4.setText("THÔNG TIN HÓA ĐƠN");
        ttsp.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 270, 60));

        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ttsp.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 420, 10));

        NAME.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NAME.setForeground(new java.awt.Color(255, 0, 0));
        NAME.setText("Gaming Asus TUF Core i7 12700H          ");
        ttsp.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 350, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("VNĐ");
        ttsp.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 50, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Đơn giá :");
        ttsp.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 30));

        tiengiam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tiengiam.setForeground(new java.awt.Color(255, 102, 0));
        tiengiam.setText("56.000.000");
        ttsp.add(tiengiam, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 120, 30));

        SL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SL.setForeground(new java.awt.Color(255, 0, 51));
        SL.setText("1");
        ttsp.add(SL, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 110, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setText("Số lượng :");
        ttsp.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));
        ttsp.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 420, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Tên SP : ");
        ttsp.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 40));

        TGia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TGia.setForeground(new java.awt.Color(255, 0, 51));
        TGia.setText("56.000.000");
        ttsp.add(TGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 130, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("VNĐ");
        ttsp.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 50, 50));

        voucher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        voucher.setForeground(new java.awt.Color(255, 0, 51));
        voucher.setText("56");
        ttsp.add(voucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 40, 40));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("-");
        ttsp.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 30, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setText("%");
        ttsp.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 30, 40));
        ttsp.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 420, 10));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setText(" Voucher :");
        ttsp.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 90, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 204), java.awt.Color.yellow, null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Phải trả :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 50));

        TONGTIEN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TONGTIEN.setForeground(new java.awt.Color(255, 0, 51));
        TONGTIEN.setText("56.000.000");
        jPanel2.add(TONGTIEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 120, 50));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 51));
        jLabel31.setText("VNĐ");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 60, 50));

        ttsp.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 310, 50));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel32.setText("Thắc mắc? Liên hệ : 0359100154 (Anh Duck)");
        ttsp.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 280, 20));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Tổng : ");
        ttsp.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 80, 50));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 0, 51));
        jLabel48.setText("-");
        ttsp.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 40, 40));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText(")");
        ttsp.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 30, 40));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel49.setText("(");
        ttsp.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 30, 40));

        DG.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        DG.setForeground(new java.awt.Color(255, 0, 51));
        DG.setText("56.000.000");
        ttsp.add(DG, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 110, 30));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 0, 51));
        jLabel50.setText("VNĐ");
        ttsp.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 50, 50));

        jPanel1.add(ttsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 420, 450));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 153));
        jLabel3.setText("THÔNG TIN KHÁCH HÀNG");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 270, 60));

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 420, 10));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Ghi chú :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tên :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 50, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Số điện thoại :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Địa chỉ :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 40));

        sdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sdt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 230, 40));

        namekh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namekh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(namekh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 320, 40));

        note.setColumns(20);
        note.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        note.setRows(5);
        jScrollPane1.setViewportView(note);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 370, 70));

        diachi.setColumns(20);
        diachi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        diachi.setRows(5);
        jScrollPane2.setViewportView(diachi);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 370, 120));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 450));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hoadon.setBackground(new java.awt.Color(204, 255, 255));
        hoadon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hoadon.setForeground(new java.awt.Color(153, 0, 0));
        hoadon.setText("Xuất hóa đơn");
        hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hoadonMouseClicked(evt);
            }
        });
        hoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoadonActionPerformed(evt);
            }
        });
        jPanel4.add(hoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 160, 50));

        xacnhan.setBackground(new java.awt.Color(0, 204, 51));
        xacnhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        xacnhan.setForeground(new java.awt.Color(255, 255, 255));
        xacnhan.setText("Chốt đơn");
        xacnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xacnhanMouseClicked(evt);
            }
        });
        xacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacnhanActionPerformed(evt);
            }
        });
        jPanel4.add(xacnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 117, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DUCK STORE");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 50));

        jLabel2.setFont(new java.awt.Font("Bell MT", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Uy Tin Tao Nen Chat Luong !!");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 250, 50));

        huy1.setBackground(new java.awt.Color(255, 255, 204));
        huy1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        huy1.setForeground(new java.awt.Color(0, 102, 102));
        huy1.setText("Trở về");
        huy1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huy1MouseClicked(evt);
            }
        });
        huy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huy1ActionPerformed(evt);
            }
        });
        jPanel4.add(huy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, 90, 50));

        huy2.setBackground(new java.awt.Color(255, 51, 51));
        huy2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        huy2.setForeground(new java.awt.Color(255, 255, 255));
        huy2.setText("Hủy đơn");
        huy2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huy2MouseClicked(evt);
            }
        });
        huy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huy2ActionPerformed(evt);
            }
        });
        jPanel4.add(huy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 110, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 1360, 70));

        ttsp2.setBackground(new java.awt.Color(255, 255, 255));
        ttsp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ttsp2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 153));
        jLabel10.setText("THÔNG TIN SẢN PHẨM");
        ttsp2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 230, 60));

        jSeparator5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ttsp2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 490, 10));

        name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 0, 0));
        name.setText("Gaming Asus TUF Core i7 12700H          ");
        ttsp2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 350, 40));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setText("Tên SP : ");
        ttsp2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 40));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel51.setText("CPU :");
        ttsp2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 40, 30));

        cpu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cpu.setForeground(new java.awt.Color(51, 102, 255));
        cpu.setText("AMD Ryzen 7 PRO - 6850U                 ");
        ttsp2.add(cpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 350, 40));

        ssd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ssd.setForeground(new java.awt.Color(51, 102, 255));
        ssd.setText("SSD 256 GB PCIe NVMe M.2                ");
        ttsp2.add(ssd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 340, 40));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel52.setText("Hard drive :");
        ttsp2.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel53.setText("RAM :");
        ttsp2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 60, 30));

        ram.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ram.setForeground(new java.awt.Color(51, 102, 255));
        ram.setText("32GB DDR4-3200MHz                       ");
        ttsp2.add(ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 360, 50));

        display.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        display.setForeground(new java.awt.Color(51, 102, 255));
        display.setText("15.6 inch, 2560 x 1440 , IPS, 165 Hz    ");
        ttsp2.add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 330, 40));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel54.setText("VGA :");
        ttsp2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 60, 30));

        vga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        vga.setForeground(new java.awt.Color(51, 102, 255));
        vga.setText("NVIDIA GeForce RTX 3050 Ti 4GB GDDR6    ");
        ttsp2.add(vga, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 400, 30));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        color.setBackground(new java.awt.Color(255, 255, 255));
        color.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        color.setForeground(new java.awt.Color(51, 102, 255));
        color.setText("Black");
        jPanel6.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 70, 40));

        jLabel55.setBackground(new java.awt.Color(204, 204, 255));
        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setText(" Color :");
        jPanel6.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 40));

        ttsp2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 40));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel56.setText("Display :");
        ttsp2.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 80, 40));

        img.setText("         NONE");
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ttsp2.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 100, 70));

        jLabel14.setText("Preview :");
        ttsp2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 60, 30));

        jPanel1.add(ttsp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 490, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hoadonMouseClicked
        String path="";
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x=j.showSaveDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            path=j.getSelectedFile().getPath();
        }
        Document doc=new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"hoadon.pdf"));
            doc.open();
                        
            Paragraph p = new Paragraph(new Phrase(10f,"                    HOA DON SAN PHAM",FontFactory.getFont(FontFactory.TIMES_BOLD, 26.7f)));
            doc.add(p);
            doc.add(new Paragraph("\n"));doc.add(new Paragraph("\n"));doc.add(new Paragraph("\n"));
            PdfPTable TB=new PdfPTable(2) ;
            com.lowagie.text.Font font = FontFactory.getFont("Times-Roman", 15);
            font.setColor(Color.RED);
            TB.addCell("Ten SP "); TB.addCell( NAME.getText());
            TB.addCell("So luong "); TB.addCell( SL.getText());
            TB.addCell("Don gia "); TB.addCell( DG.getText());
            TB.addCell("Tam TONG "); TB.addCell( TGia.getText());
            TB.addCell("VOUCHER  "); TB.addCell( tiengiam.getText());
            TB.addCell(new PdfPCell(new Phrase("Tong tra ", font)));
            TB.addCell(new PdfPCell(new Phrase(TONGTIEN.getText(), font)));
            
            doc.add(TB);
            doc.add(new Paragraph("\n"));doc.add(new Paragraph("\n"));doc.add(new Paragraph("\n"));            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            String a="                                               ";
            doc.add(new Paragraph(new Phrase(10f,a+a+a+dtf.format(now),FontFactory.getFont(FontFactory.TIMES_ITALIC, 10.7f))));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph(new Phrase(10f,a+"------------    DuckStore chan thanh cam on quy khach !    ------------",FontFactory.getFont(FontFactory.TIMES_ITALIC, 10.7f))));
        } catch (Exception e) {
        }
        doc.close();
    }//GEN-LAST:event_hoadonMouseClicked

    private void hoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoadonActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_hoadonActionPerformed

    private void xacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xacnhanMouseClicked
        try {
            Connection conn=db.DBconnect.getConnection();   
            String sql="select *from login";
            PreparedStatement ps=conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals(LG)){
                    String pass=rs.getString(2);
                    int doanhthu=rs.getInt(3)+(int)tong;
                    soluong=rs.getInt(4)+soluong;
                    sql="delete from login where id='"+LG+"';";
                    ps=conn.prepareCall(sql);
                    ps.execute();
                    sql = "INSERT INTO login " +
                    "VALUES ('"+LG+"','"+pass+"',"+doanhthu+","+soluong+")";
                    ps=conn.prepareCall(sql);
                    ps.execute();
                    sql="delete from khachhang where TenKH='"+tenkh+"';";
                    ps=conn.prepareCall(sql);
                    ps.execute();
                    break;
                }
            }
        } catch (Exception e) {
        }  
        try {
            new Manager(LG).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(xacnhandonhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(xacnhandonhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        JOptionPane.showMessageDialog(null, "LỤM TIỀN !!");
    }//GEN-LAST:event_xacnhanMouseClicked

    private void xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacnhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xacnhanActionPerformed

    private void huy1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huy1MouseClicked
        try {
            new Manager(LG).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(xacnhandonhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(xacnhandonhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_huy1MouseClicked

    private void huy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huy1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_huy1ActionPerformed

    private void huy2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huy2MouseClicked
        try {
            Connection conn=db.DBconnect.getConnection();   
            String sql="delete from khachhang where TenKH='"+tenkh+"';";
            PreparedStatement ps=conn.prepareCall(sql);
            ps.execute();
            
        } catch (Exception e) {
        }
        try {
            
            new Manager(LG).setVisible(true); dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_huy2MouseClicked

    private void huy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huy2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_huy2ActionPerformed

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
            java.util.logging.Logger.getLogger(xacnhandonhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(xacnhandonhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(xacnhandonhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(xacnhandonhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new xacnhandonhang("cc", "cl").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(xacnhandonhang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(xacnhandonhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DG;
    private javax.swing.JLabel NAME;
    private javax.swing.JLabel SL;
    private javax.swing.JLabel TGia;
    private javax.swing.JLabel TONGTIEN;
    private javax.swing.JLabel color;
    private javax.swing.JLabel cpu;
    private javax.swing.JTextArea diachi;
    private javax.swing.JLabel display;
    private javax.swing.JButton hoadon;
    private javax.swing.JButton huy1;
    private javax.swing.JButton huy2;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel name;
    private javax.swing.JLabel namekh;
    private javax.swing.JTextArea note;
    private javax.swing.JLabel ram;
    private javax.swing.JLabel sdt;
    private javax.swing.JLabel ssd;
    private javax.swing.JLabel tiengiam;
    private javax.swing.JPanel ttsp;
    private javax.swing.JPanel ttsp2;
    private javax.swing.JLabel vga;
    private javax.swing.JLabel voucher;
    private javax.swing.JButton xacnhan;
    // End of variables declaration//GEN-END:variables
}
