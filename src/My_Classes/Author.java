/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LaptopAZ.vn
 */
public class Author {
    private  int id;
    private String firstName;
       private String lastName;
          private String field_of_expertise;
             private String about;
      public Author(int _id,String _fname, String _lname, String _expertise , String _about)
      {
          this.id = _id;
          this.firstName = _fname;
          this.lastName = _lname;
          this.field_of_expertise = _expertise;
          this.about = _about;
          
      }

    public Author() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setField_of_expertise(String field_of_expertise) {
        this.field_of_expertise = field_of_expertise;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getField_of_expertise() {
        return field_of_expertise;
    }

    public String getAbout() {
        return about;
    }
    public void addAuthor(String _fname, String _lname, String _expertise, String _about)
    {
        String insertQuery = "INSERT INTO `author`(`firstName`, `lastName`, `expertise`, `about`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _expertise);
            ps.setString(4, _about);
           
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null,"Author Added", "add author",1);
            }else
            {
                JOptionPane.showMessageDialog(null,"Author not Added", "add author",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void editAuthor(int _id,String _fname, String _lname, String _expertise, String _about)
    {
        String editQuery = "UPDATE `author` SET `firstName`= ? ,`lastName`= ? ,`expertise`= ? ,`about`= ? WHERE `id`=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _expertise);
            ps.setString(4, _about);
            ps.setInt(5, _id);
            
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null,"Author Edited", "edit author",1);
            }else
            {
                JOptionPane.showMessageDialog(null,"Author not Edited", "author genre",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void removeAuthor(int _id)
    {
        String removeQuery = "DELETE FROM `author` WHERE `id` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() != 0)
            {
                JOptionPane.showMessageDialog(null,"Author Deleted", "romove",1);
            }else
            {
                JOptionPane.showMessageDialog(null,"Author not Deleted", "remove",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public ArrayList<Author> authorsList()
       { 
        ArrayList<Author> aList= new ArrayList<>();
        
       
       My_Classes.Func_Class func= new My_Classes.Func_Class() ;
        try {
           
          ResultSet rs = func.getData("SELECT * FROM `author`");
            Author author;
            while(rs.next())
            {
                author = new Author(rs.getInt("id"), rs.getString("firstName"),rs.getString("lastName"),rs.getString("expertise"),rs.getString("about"));
                aList.add(author);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
          return aList;  
           
       
    }
    
}
