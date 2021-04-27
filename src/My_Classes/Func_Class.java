/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My_Classes;

import com.mysql.cj.jdbc.result.ResultSetFactory;
import java.awt.Color;
import java.awt.Image;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
/**
 *
 * @author LaptopAZ.vn
 */
public class Func_Class {
    public  void displayImage(int width, int height, String imagePath,JLabel label) {
        ImageIcon imgIco = new ImageIcon(getClass().getResource(imagePath));
        Image image = imgIco.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
        
        
    }
    public void customTable(JTable table)
    {
        table.setSelectionBackground(new Color(249,105,14));
        table.setSelectionForeground(Color.white);
        table.setRowHeight(35);
        table.setShowGrid(false);
        
        table.setBackground(new Color(248,248,248));
        table.setShowHorizontalLines(true);
    }
    
    
    public ResultSet getData(String query)
    {
         
        PreparedStatement ps;
       ResultSet rs = null;
        try {
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
             }
        catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
