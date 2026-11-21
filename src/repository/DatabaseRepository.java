/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import domain.Doktor;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.ConnectionUtil;

/**
 *
 * @author PC
 */
public class DatabaseRepository {
    private Connection connection;
    
    public void connect() throws Exception{
        try {
            connection = DriverManager.getConnection(ConnectionUtil.getInstance().getUrl(), ConnectionUtil.getInstance().getUser(), ConnectionUtil.getInstance().getPassword());
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    public void disconnect() throws Exception{
        try{
            if(connection != null && !connection.isClosed())
                connection.close();
        }catch(Exception ex){
            throw ex;
        }
    }
    public void commit() throws Exception{
        try{
            if(connection != null && !connection.isClosed())
                connection.commit();
        }catch(Exception ex){
            throw ex;
        }
    }
    public void rollback() throws Exception{
        try{
            if(connection != null && !connection.isClosed())
                connection.rollback();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
    public Doktor getDoktorByKorisnickoIme(String korisnickoIme) throws Exception{
        try{
            String query = "SELECT * FROM doktor WHERE korisnickoIme = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, korisnickoIme);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Doktor d = new Doktor();
                d.setIdDoktora(rs.getLong("idDoktora"));
                d.setIme(rs.getString("ime"));
                d.setPrezime(rs.getString("prezime"));
                d.setZvanje(rs.getString("zvanje"));
                d.setKontakt(rs.getString("kontakt"));
                d.setEmail(rs.getString("email"));
                d.setKorisnickoIme(rs.getString("korisnickoIme"));
                d.setLozinka(rs.getString("lozinka"));
                return d;
            }
            return null;
        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
