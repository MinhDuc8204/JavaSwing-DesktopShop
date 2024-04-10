/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.main;

import db.DBconnect;
import db.Login;
import java.awt.Button;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 *195 60
 * @author DUC
 */
public class Home extends javax.swing.JFrame {
    private int o=0;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();        
        jPanel11.setVisible(true);
//        nullpanel();
        jLabel4.setForeground(Color.red);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\menu.png", menuicon);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\menu.png", menuicon1);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\menu.png", menuicon2);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\close.png", close);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\cart.jpg", carticon);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\shop.jpg", shopicon);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\voucher.jpg", vouchericon);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\contact.jpg", contact);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\search.png", searchicon);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\sort.png", sorticon);  
        try {
            listpanel();
            listgiohang();
            listvoucher();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void listvoucher() throws ClassNotFoundException, SQLException{
        int check=0;
        Connection conn=DBconnect.getConnection();
        String sql="select *from voucher";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();            
        while(rs.next()){
            if(rs.getInt(4)==1){
                check=1;
                addvoucher(rs.getInt(2), rs.getString(1), rs.getInt(3), voucher1);
                break;
            }            
        }
        if(check==0){
            addvoucher(100, "xxxxxxxxxxxxx", 0, voucher1);
        }
        check=0;
        sql="select *from voucher";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();                
        while(rs.next()){
            if(rs.getInt(4)==2){ 
                check=2;                
                addvoucher(rs.getInt(2), rs.getString(1), rs.getInt(3), voucher2);
                break;
            }            
        }
        if(check==0){
            addvoucher(100, "xxxxxxxxxxxxx", 0, voucher2);
        }
        check=0;
        sql="select *from voucher";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();            
        while(rs.next()){
            if(rs.getInt(4)==3){
                check=3;
                addvoucher(rs.getInt(2), rs.getString(1), rs.getInt(3), voucher3);
                break;
            }
        }
        if(check==0){
            addvoucher(100, "xxxxxxxxxxxxx", 0, voucher3);
        }
        check=0;
        sql="select *from voucher";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();            
        while(rs.next()){
            if(rs.getInt(4)==4){
                check=4;
                addvoucher(rs.getInt(2), rs.getString(1), rs.getInt(3), voucher4);
                break;
            }
        }
        if(check==0){
            addvoucher(100, "xxxxxxxxxxxxx", 0, voucher4);
        }
        check=0;
    }
    void newpanel(){    
        jPanel3.removeAll();jPanel6.removeAll();jPanel9.removeAll();jPanel12.removeAll();jPanel15.removeAll();jPanel18.removeAll();
        jPanel4.removeAll();jPanel7.removeAll();jPanel10.removeAll();jPanel13.removeAll();jPanel16.removeAll();jPanel19.removeAll();
        jPanel5.removeAll();jPanel8.removeAll();jPanel11.removeAll();jPanel14.removeAll();jPanel17.removeAll();jPanel20.removeAll();       
    }
    void sortitem(){       
        try {
            if(o%2==0){
                String name="", price="", link="", cpu="", ram="", vga="", ssd="", display="", color=""; 
            Connection conn=DBconnect.getConnection();
            String sql="select *from laptop";
            PreparedStatement ps=conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==1){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel3,cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==2){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel4,cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==3){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel5,cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==4){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel6,cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==5){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel7, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==6){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel8, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==7){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel9, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==8){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel10, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==9){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel11, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==10){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel12, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==11){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel13, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==12){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel14, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==13){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel15, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==14){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel16, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==15){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel17, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==16){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel18, cpu, ram, vga, ssd, display, color);
                ++o;
            }
//            ___________________________________________
            else{
                String name="", price="", link="", cpu = null, ram= null, vga= null, ssd = null, display= null, color= null;
            Connection conn=DBconnect.getConnection();
            String sql="select *from laptop";
            PreparedStatement ps=conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==16){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel3, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==15){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel4, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==14){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel5, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==13){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel6, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==12){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel7,cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==11){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel8, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==10){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel9, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==9){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel10, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==8){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel11, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==7){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel12, sql, name, sql, sql, sql, sql);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==6){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                }                
            }
            addpanel(name, price, link, jPanel13, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==5){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel14, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==4){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel15, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==3){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel16, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==2){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel17, cpu, ram, vga, ssd, display, color);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id")==1){
                    name=rs.getString("Name");
                    price=rs.getString("PriceS");
                    link=rs.getString("link");
                    cpu=rs.getString("CPU");
                    ram=rs.getString("RAM");
                    vga=rs.getString("VGA");
                    ssd=rs.getString("SSD");
                    display=rs.getString("Display");
                    color=rs.getString("Color");
                }                
            }
            addpanel(name, price, link, jPanel18,cpu, ram, vga, ssd, display, color);
                ++o;                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void listgiohang() throws ClassNotFoundException, SQLException{
        Connection conn=DBconnect.getConnection();
        String sql="select *from giohang";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getInt(5)==1){
                String a,b,c;
                int i;
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                i=rs.getInt(4);
                addgiohang(a, b, c, i, don1);
                break;
            }
        }
        sql="select *from giohang";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getInt(5)==2){
                String a,b,c;
                int i;
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                i=rs.getInt(4);
                addgiohang(a, b, c, i, don2);
                break;
            }
        }
        sql="select *from giohang";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getInt(5)==3){
                String a,b,c;
                int i;
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                i=rs.getInt(4);
                addgiohang(a, b, c, i, don3);
                break;
            }
        }
        sql="select *from giohang";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getInt(5)==4){
                String a,b,c;
                int i;
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                i=rs.getInt(4);
                addgiohang(a, b, c, i, don4);
                break;
            }
        }
        sql="select *from giohang";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getInt(5)==5){
                String a,b,c;
                int i;
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                i=rs.getInt(4);
                addgiohang(a, b, c, i, don5);
                break;
            }
        }
        sql="select *from giohang";
        ps=conn.prepareCall(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getInt(5)==6){
                String a,b,c;
                int i;
                a=rs.getString(1);
                b=rs.getString(2);
                c=rs.getString(3);
                i=rs.getInt(4);
                addgiohang(a, b, c, i, don6);
                break;
            }
        }
    }
    void nullmouseacc(){
        int i;
        i=jPanel3.getMouseListeners().length;
        while(i!=0){
            jPanel3.removeMouseListener(jPanel3.getMouseListeners()[i-1]);
            --i;
        }
        i=jPanel4.getMouseListeners().length;
        while(i!=0){
            jPanel4.removeMouseListener(jPanel4.getMouseListeners()[i-1]);
            --i;
        }
        i=jPanel5.getMouseListeners().length;
        while(i!=0){
            jPanel5.removeMouseListener(jPanel5.getMouseListeners()[i-1]);
            --i;
        }i=jPanel6.getMouseListeners().length;
        while(i!=0){
            jPanel6.removeMouseListener(jPanel6.getMouseListeners()[i-1]);
            --i;
        }i=jPanel7.getMouseListeners().length;
        while(i!=0){
            jPanel7.removeMouseListener(jPanel7.getMouseListeners()[i-1]);
            --i;
        }i=jPanel8.getMouseListeners().length;
        while(i!=0){
            jPanel8.removeMouseListener(jPanel8.getMouseListeners()[i-1]);
            --i;
        }i=jPanel9.getMouseListeners().length;
        while(i!=0){
            jPanel9.removeMouseListener(jPanel9.getMouseListeners()[i-1]);
            --i;
        }i=jPanel10.getMouseListeners().length;
        while(i!=0){
            jPanel10.removeMouseListener(jPanel10.getMouseListeners()[i-1]);
            --i;
        }i=jPanel11.getMouseListeners().length;
        while(i!=0){
            jPanel11.removeMouseListener(jPanel11.getMouseListeners()[i-1]);
            --i;
        }i=jPanel12.getMouseListeners().length;
        while(i!=0){
            jPanel12.removeMouseListener(jPanel12.getMouseListeners()[i-1]);
            --i;
        }i=jPanel13.getMouseListeners().length;
        while(i!=0){
            jPanel13.removeMouseListener(jPanel13.getMouseListeners()[i-1]);
            --i;
        }i=jPanel14.getMouseListeners().length;
        while(i!=0){
            jPanel14.removeMouseListener(jPanel14.getMouseListeners()[i-1]);
            --i;
        }i=jPanel15.getMouseListeners().length;
        while(i!=0){
            jPanel15.removeMouseListener(jPanel15.getMouseListeners()[i-1]);
            --i;
        }i=jPanel16.getMouseListeners().length;
        while(i!=0){
            jPanel16.removeMouseListener(jPanel16.getMouseListeners()[i-1]);
            --i;
        }i=jPanel17.getMouseListeners().length;
        while(i!=0){
            jPanel17.removeMouseListener(jPanel17.getMouseListeners()[i-1]);
            --i;
        }i=jPanel18.getMouseListeners().length;
        while(i!=0){
            jPanel18.removeMouseListener(jPanel18.getMouseListeners()[i-1]);
            --i;
        }
    }
    void listpanel() throws ClassNotFoundException, SQLException{
            nullmouseacc();
            nullpanel();           
            newpanel();
        if(jComboBox1.getSelectedItem().toString().equals("CPU")&&jComboBox2.getSelectedItem().toString().equals("VGA")){           
            if(o!=0){                
            sortitem();
            }else{
                sortitem();
                o=0;
            }            
        }else{
            String cpu=jComboBox1.getSelectedItem().toString();
            String vga=jComboBox2.getSelectedItem().toString();            
            if(cpu.contains("CPU")){
                nullpanel(); newpanel();
                int i=0;
                String name, price, link, Cpu = null, Ram, Vga, Ssd, Display, Color;
                Connection conn=DBconnect.getConnection();
                String sql="select *from laptop";
                PreparedStatement ps=conn.prepareCall(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(rs.getString("VGA").contains(vga)){
                        name=rs.getString("Name");
                        price=rs.getString("PriceS");
                        link=rs.getString("link");
                        Cpu=rs.getString("CPU");
                        Ram=rs.getString("RAM");
                        Vga=rs.getString("VGA");
                        Ssd=rs.getString("SSD");
                        Display=rs.getString("Display");
                        Color=rs.getString("Color");
                        System.out.println(name);
                        if(i==0){
                            addpanel(name, price, link, jPanel3, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==1){
                            addpanel(name, price, link, jPanel4, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==2){
                            addpanel(name, price, link, jPanel5, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==3){
                            addpanel(name, price, link, jPanel6, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }
                    }                
                }
                
            }else if(vga.contains("VGA")){
                nullpanel(); newpanel();
                int i=0;
                String name, price, link, Cpu = null, Ram, Vga, Ssd, Display, Color;
                Connection conn=DBconnect.getConnection();
                String sql="select *from laptop";
                PreparedStatement ps=conn.prepareCall(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(rs.getString("CPU").contains(cpu)){
                        name=rs.getString("Name");
                        price=rs.getString("PriceS");
                        link=rs.getString("link");
                        Cpu=rs.getString("CPU");
                        Ram=rs.getString("RAM");
                        Vga=rs.getString("VGA");
                        Ssd=rs.getString("SSD");
                        Display=rs.getString("Display");
                        Color=rs.getString("Color");
                        if(i==0){
                            addpanel(name, price, link, jPanel3, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==1){
                            addpanel(name, price, link, jPanel4, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==2){
                            addpanel(name, price, link, jPanel5, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==3){
                            addpanel(name, price, link, jPanel6, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }
                    }                
                }
            }else{
                nullpanel(); newpanel();
                int i=0;
                String name, price, link, Cpu = null, Ram, Vga, Ssd, Display, Color;
                Connection conn=DBconnect.getConnection();
                String sql="select *from laptop";
                PreparedStatement ps=conn.prepareCall(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(rs.getString("VGA").contains(vga)&&rs.getString("CPU").contains(cpu)){
                        name=rs.getString("Name");
                        price=rs.getString("PriceS");
                        link=rs.getString("link");
                        Cpu=rs.getString("CPU");
                        Ram=rs.getString("RAM");
                        Vga=rs.getString("VGA");
                        Ssd=rs.getString("SSD");
                        Display=rs.getString("Display");
                        Color=rs.getString("Color");
                        if(i==0){
                            addpanel(name, price, link, jPanel3, Cpu, Ram, Vga, Ssd, Display, Color);                           
                            ++i;
                        }else if(i==1){
                            addpanel(name, price, link, jPanel4, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==2){
                            addpanel(name, price, link, jPanel5, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }else if(i==3){
                            addpanel(name, price, link, jPanel6, Cpu, Ram, Vga, Ssd, Display, Color);
                            ++i;
                        }
                    }                
                }
            }
        }
            
    }
    void addvoucher(int Giam, String ma, int soluong, JPanel S){        
        
        JLabel jLabel8 = new javax.swing.JLabel();
        jLabel8.setText("jLabel8");
        jLabel8.setSize(220, 160);
        scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\VOUCHER.png", jLabel8);
        S.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, 220, 160));
        
        JLabel giam = new javax.swing.JLabel();
        giam.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        giam.setForeground(new java.awt.Color(255, 102, 0));
        giam.setText(Giam+"");
        S.add(giam, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 60, 30));

        JLabel jLabel20 = new javax.swing.JLabel();
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("%");
        S.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 30, 30));

        JLabel jLabel11 = new javax.swing.JLabel();
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Giảm ");
        S.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 60, 30));

        JLabel jLabel9 = new javax.swing.JLabel();
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText(" cho tổng hóa đơn");
        S.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 360, 30));

        JPanel jPanel23 = new javax.swing.JPanel();
        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        

        JLabel jLabel12 = new javax.swing.JLabel();
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Mã giảm giá :");
        jPanel23.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        JLabel code = new javax.swing.JLabel();
        code.setFont(new java.awt.Font("Viner Hand ITC", 3, 14)); // NOI18N
        code.setForeground(new java.awt.Color(0, 102, 102));
        code.setText(ma+"");
        jPanel23.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 150, 30));

        JPanel jPanel28 = new javax.swing.JPanel();
        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        

        JLabel jLabel22 = new javax.swing.JLabel();
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Số lượng :");
        jPanel28.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        JLabel jLabel23 = new javax.swing.JLabel();
        jLabel23.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel23.setText(soluong+"");
        jPanel28.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 30, 30));

        JLabel jLabel26 = new javax.swing.JLabel();
        jLabel26.setText("jLabel17");
        jLabel26.setSize(130, 120);
        if(soluong==0){
            scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\runout.png", jLabel26);            
        }else{
            scaleImage("C:\\Users\\DUC\\Documents\\JAVA\\BanLapTop\\src\\com.icon\\getnow.png", jLabel26);
        }
        S.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 310, 50));
        S.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 130, 120));
        S.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 130, 50));
    }
    void addgiohang(String name, String price, String link, int soluong, JPanel S) throws ClassNotFoundException, SQLException{
        Connection conn=DBconnect.getConnection();
        
        JPanel jPanel23 = new javax.swing.JPanel();
        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        
        JLabel jLabel10 = new javax.swing.JLabel();
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText(soluong+"");
        jPanel23.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 20, -1));
        
        JButton jButton3 = new javax.swing.JButton();
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jButton3.setText("-");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String sql="select *from giohang";
                    int stt;
                    PreparedStatement ps=conn.prepareCall(sql);
                    ResultSet rs=ps.executeQuery();
                    int sl=0;
                    while(rs.next()){
                        if(rs.getString("Name").contains(name)){
                            sl=rs.getInt(4);
                            stt=rs.getInt(5);
                            sql="delete from giohang where stt="+stt+";";
                            ps=conn.prepareCall(sql);
                            ps.execute();
                            --sl;
                            sql = "INSERT INTO giohang " +
                                "VALUES ('"+name+"', '"+price+"', '"+link+"',"+(sl)+", "+(stt)+")";
                            ps=conn.prepareCall(sql);
                            ps.execute();
                                if(sl==0){
                                    sql="delete from giohang where stt="+stt+";";
                                    ps=conn.prepareCall(sql);
                                    ps.execute();
                                    dispose(); Home a=new Home(); a.setVisible(true); a.gettab().setSelectedIndex(2);
//                                    sql="select *from giohang";
//                                    ps=conn.prepareCall(sql);
//                                    ps.execute();
//                                    while(rs.next()){
//                                        int tmp=rs.getInt(5);
//                                        break;
//                                    }
                                }
                            break;
                        }
                    }
                    jLabel10.setText(sl+ "");
                } catch (Exception e) {
                    
                }
            }
        });
        S.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 50, 30));
        
        JButton jButton2 = new javax.swing.JButton();
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("+");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                String sql="select *from giohang";
        int stt;
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        int sl = 0;
        while(rs.next()){
            if(rs.getString("Name").contains(name)){
                    sl=rs.getInt(4);
                    ++sl;
                    stt=rs.getInt(5);
                    sql="delete from giohang where stt="+stt+";";
                    ps=conn.prepareCall(sql);
                    ps.execute();
                    sql = "INSERT INTO giohang " +
                    "VALUES ('"+name+"', '"+price+"', '"+link+"',"+(sl)+", "+(stt)+")";
                    ps=conn.prepareCall(sql);
                    ps.execute();
                    break;
                }
        }
        jLabel10.setText(sl+ "");
            } catch (Exception e) {
            }
            }
        });
        S.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 50, 30));
        
        JLabel jLabel8 = new javax.swing.JLabel();
        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("jLabel8");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));        
        jLabel8.setSize(270, 180);
        scaleImage(link, jLabel8);
        S.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 180));
                
        JLabel jLabel14 = new javax.swing.JLabel();
        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText(name);
        S.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 600, 40));
        
        JLabel jLabel12 = new javax.swing.JLabel();
        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Đơn giá :");
        S.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 90, 40));

        JLabel jLabel9 = new javax.swing.JLabel();
        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText(price+"Đ");
        S.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 240, 40));        

        JLabel jLabel11 = new javax.swing.JLabel();
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Số lượng : ");    
        jPanel23.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));
                                        
        JButton jButton1 = new javax.swing.JButton();    
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Đặt hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new bill(name,0).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
        });
        S.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 110, 50));
        S.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 260, 50));
    }
    JTabbedPane gettab(){
        return tabmenu;
    }
    void addpanel(String name, String price, String link, JPanel S , String cpu, String ram, String vga, String ssd, String display, String color){
        
        JLabel a=new JLabel();JLabel b=new JLabel();JLabel c=new JLabel();
        a.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        a.setText(name);
        a.setHorizontalAlignment(SwingConstants.CENTER);
        a.setVerticalAlignment(SwingConstants.CENTER);
        S.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 190, 260, 30));
               
        b.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        b.setForeground(new java.awt.Color(255, 0, 51));
        b.setText(price+" đ");
        S.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 220, 30));
        
        c.setSize(250, 160);
        scaleImage(link, c);
        S.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 160));
        S.setVisible(true);
        S.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new introduce(link, name, cpu, ram, vga, ssd, display, color, price).setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        });
    }
    void nullpanel(){
        jPanel3.setVisible(false);jPanel7.setVisible(false);jPanel11.setVisible(false);jPanel15.setVisible(false);
        jPanel4.setVisible(false);jPanel8.setVisible(false);jPanel12.setVisible(false);jPanel16.setVisible(false);
        jPanel5.setVisible(false);jPanel9.setVisible(false);jPanel13.setVisible(false);jPanel17.setVisible(false);
        jPanel6.setVisible(false);jPanel10.setVisible(false);jPanel14.setVisible(false);jPanel18.setVisible(false);
        jPanel19.setVisible(false);jPanel20.setVisible(false);
    }
    
    private void scaleImage(String location, JLabel label){
        ImageIcon icon = new ImageIcon(location);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }
    void openMenubar(JPanel a){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<264;i++){
                    try {
                        a.setSize(i, 658);
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    void closeMenubar(JPanel a){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=264;i>0;i--){
                    try {
                        a.setSize(i, 658);
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    void changecl(int i){
        if(i==1){
            jLabel4.setForeground(Color.red);
            jLabel5.setForeground(Color.black);
            jLabel6.setForeground(Color.black);
        }else if(i==2){
            jLabel4.setForeground(Color.black);
            jLabel5.setForeground(Color.red);
            jLabel6.setForeground(Color.black);
        }else{
            jLabel4.setForeground(Color.black);
            jLabel5.setForeground(Color.black);
            jLabel6.setForeground(Color.red);
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

        MAIN = new javax.swing.JPanel();
        menubar = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        thongbao = new javax.swing.JLabel();
        thongbao1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        shopicon = new javax.swing.JLabel();
        vouchericon = new javax.swing.JLabel();
        carticon = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        manager = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        tabmenu = new javax.swing.JTabbedPane();
        sanpam = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        menuicon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        searchicon = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        sorticon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        voucher = new javax.swing.JPanel();
        top1 = new javax.swing.JPanel();
        menuicon1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel24 = new javax.swing.JPanel();
        voucher1 = new javax.swing.JPanel();
        voucher2 = new javax.swing.JPanel();
        voucher4 = new javax.swing.JPanel();
        voucher3 = new javax.swing.JPanel();
        giohang = new javax.swing.JPanel();
        top2 = new javax.swing.JPanel();
        menuicon2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        don1 = new javax.swing.JPanel();
        don2 = new javax.swing.JPanel();
        don3 = new javax.swing.JPanel();
        don4 = new javax.swing.JPanel();
        don5 = new javax.swing.JPanel();
        don6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WEBLAPTOP");
        setMinimumSize(new java.awt.Dimension(1095, 655));

        MAIN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menubar.setBackground(new java.awt.Color(255, 255, 255));
        menubar.setPreferredSize(new java.awt.Dimension(261, 60));

        close.setText("closeicon");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DUCK STORE");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Sản phẩm");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setText("Voucher");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Giỏ hàng");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        thongbao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thongbao.setText("Thông báo");

        thongbao1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thongbao1.setText("Hỗ trợ");

        shopicon.setText("jLabel7");

        vouchericon.setText("jLabel7");

        carticon.setText("jLabel7");

        manager.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manager.setText("For staff");
        manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerMouseClicked(evt);
            }
        });

        contact.setText("jLabel2");

        javax.swing.GroupLayout menubarLayout = new javax.swing.GroupLayout(menubar);
        menubar.setLayout(menubarLayout);
        menubarLayout.setHorizontalGroup(
            menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menubarLayout.createSequentialGroup()
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                        .addComponent(jSeparator4)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menubarLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menubarLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(menubarLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(shopicon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vouchericon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)))
                                .addGroup(menubarLayout.createSequentialGroup()
                                    .addComponent(thongbao)
                                    .addGap(67, 67, 67)
                                    .addComponent(thongbao1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menubarLayout.createSequentialGroup()
                                    .addComponent(carticon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addGap(19, 19, 19)))))
                    .addGroup(menubarLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(manager))
                    .addGroup(menubarLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menubarLayout.setVerticalGroup(
            menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menubarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shopicon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vouchericon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carticon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thongbao)
                    .addComponent(thongbao1))
                .addGap(127, 127, 127)
                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manager)
                .addGap(581, 581, 581)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        manager.getAccessibleContext().setAccessibleName("staff");

        MAIN.add(menubar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 669));

        tabmenu.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        sanpam.setBackground(new java.awt.Color(204, 255, 204));
        sanpam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top.setBackground(new java.awt.Color(153, 153, 153));

        menuicon.setText("menuicon");
        menuicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuiconMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchicon.setText("S");
        searchicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchiconMouseClicked(evt);
            }
        });
        jPanel1.add(searchicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 45, 40));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "Intel Core i3", "Intel Core i5", "Intel Core i7", "Intel Core i9", "AMD Ryzen 5", "AMD Ryzen 7", " " }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 165, 40));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VGA", "NVIDIA GeForce RTX 1650", "NVIDIA GeForce RTX 3050", "NVIDIA GeForce RTX 3060", "NVIDIA GeForce RTX 4050", "AMD Radeon ", "AMD Vega", "Intel UHD", "Intel Iris Xe" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1, -1, 40));

        sorticon.setText("jLabel2");
        sorticon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sorticonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("DUCK STORE");

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(menuicon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(sorticon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sorticon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(topLayout.createSequentialGroup()
                        .addComponent(menuicon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sanpam.add(top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, 260));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 290, 260));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 290, 260));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, 260));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 290, 260));

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 290, 260));

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 290, 260));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, 290, 260));

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 620, 290, 260));

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 920, 290, 260));

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 920, 290, 260));

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 920, 290, 260));

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1220, 290, 260));

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 1220, 290, 260));

        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 1220, 290, 260));

        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setVisible(false);

        jPanel2.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1520, 290, 260));

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 1520, 290, 260));

        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 670, -1, -1));

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 1520, 290, 260));

        jScrollPane1.setViewportView(jPanel2);

        sanpam.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1080, 590));

        tabmenu.addTab("tab1", sanpam);

        voucher.setBackground(new java.awt.Color(255, 255, 204));
        voucher.setPreferredSize(new java.awt.Dimension(1076, 600));
        voucher.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top1.setBackground(new java.awt.Color(153, 153, 153));
        top1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuicon1.setText("menuicon");
        menuicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuicon1MouseClicked(evt);
            }
        });
        top1.add(menuicon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 41, 45));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("DUCK STORE");
        top1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 6, 150, 48));

        voucher.add(top1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 60));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voucher1.setBackground(new java.awt.Color(232, 252, 232));
        voucher1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(voucher1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 990, 140));

        voucher2.setBackground(new java.awt.Color(232, 252, 232));
        voucher2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(voucher2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 990, 140));

        voucher4.setBackground(new java.awt.Color(232, 252, 232));
        voucher4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(voucher4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 990, 140));

        voucher3.setBackground(new java.awt.Color(232, 252, 232));
        voucher3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(voucher3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 990, 140));

        jScrollPane3.setViewportView(jPanel24);

        voucher.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1060, 570));

        tabmenu.addTab("tab2", voucher);

        giohang.setBackground(new java.awt.Color(255, 255, 204));
        giohang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top2.setBackground(new java.awt.Color(153, 153, 153));

        menuicon2.setText("menuicon");
        menuicon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuicon2MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("DUCK STORE");

        javax.swing.GroupLayout top2Layout = new javax.swing.GroupLayout(top2);
        top2.setLayout(top2Layout);
        top2Layout.setHorizontalGroup(
            top2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(menuicon2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(812, Short.MAX_VALUE))
        );
        top2Layout.setVerticalGroup(
            top2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(top2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(top2Layout.createSequentialGroup()
                        .addComponent(menuicon2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        giohang.add(top2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(153, 255, 255));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        don1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        don1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(don1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1020, 200));

        don2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        don2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(don2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1020, 200));

        don3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        don3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(don3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 1020, 200));

        don4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        don4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(don4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 750, 1020, 200));

        don5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        don5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(don5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 990, 1020, 200));

        don6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        don6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(don6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1230, 1020, 200));

        jScrollPane2.setViewportView(jPanel22);

        giohang.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1080, 670));

        tabmenu.addTab("tab2", giohang);

        MAIN.add(tabmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -31, -1, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MAIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MAIN, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuiconMouseClicked
        openMenubar(menubar);
    }//GEN-LAST:event_menuiconMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        closeMenubar(menubar);
    }//GEN-LAST:event_closeMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        tabmenu.setSelectedIndex(0);
        changecl(1);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        tabmenu.setSelectedIndex(1);
        changecl(2);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void menuicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuicon1MouseClicked
        openMenubar(menubar);
    }//GEN-LAST:event_menuicon1MouseClicked

    private void menuicon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuicon2MouseClicked
        openMenubar(menubar);
    }//GEN-LAST:event_menuicon2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        tabmenu.setSelectedIndex(2);
        changecl(3);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked

    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void sorticonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sorticonMouseClicked
        if(o==0){
                o=3;
            newpanel();
            nullpanel();
            sortitem();
        }else{
            newpanel();
            nullpanel();
            nullmouseacc();            
            sortitem();
        }
    }//GEN-LAST:event_sorticonMouseClicked

    private void searchiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchiconMouseClicked
        try {
            listpanel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchiconMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerMouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_managerMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MAIN;
    private javax.swing.JLabel carticon;
    private javax.swing.JLabel close;
    private javax.swing.JLabel contact;
    private javax.swing.JPanel don1;
    private javax.swing.JPanel don2;
    private javax.swing.JPanel don3;
    private javax.swing.JPanel don4;
    private javax.swing.JPanel don5;
    private javax.swing.JPanel don6;
    private javax.swing.JPanel giohang;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel manager;
    private javax.swing.JPanel menubar;
    private javax.swing.JLabel menuicon;
    private javax.swing.JLabel menuicon1;
    private javax.swing.JLabel menuicon2;
    private javax.swing.JPanel sanpam;
    private javax.swing.JLabel searchicon;
    private javax.swing.JLabel shopicon;
    private javax.swing.JLabel sorticon;
    private javax.swing.JTabbedPane tabmenu;
    private javax.swing.JLabel thongbao;
    private javax.swing.JLabel thongbao1;
    private javax.swing.JPanel top;
    private javax.swing.JPanel top1;
    private javax.swing.JPanel top2;
    private javax.swing.JPanel voucher;
    private javax.swing.JPanel voucher1;
    private javax.swing.JPanel voucher2;
    private javax.swing.JPanel voucher3;
    private javax.swing.JPanel voucher4;
    private javax.swing.JLabel vouchericon;
    // End of variables declaration//GEN-END:variables
}
