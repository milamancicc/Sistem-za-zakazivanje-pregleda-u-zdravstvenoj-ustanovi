/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import domain.Doktor;
import domain.Grad;
import domain.Pacijent;
import domain.Pol;
import domain.Pregled;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
    
    
    public List<Pregled> getPreglediByDoktor(Doktor doktor) throws Exception{
        try{
            String query = "SELECT * FROM pregled p INNER JOIN pacijent pa ON p.idPacijenta = pa.idPacijenta WHERE idDoktora = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, doktor.getIdDoktora());
            ResultSet rs = ps.executeQuery();
            List<Pregled> pregledi = new ArrayList<>();
            while(rs.next()){
                Pregled p = new Pregled();
                p.setIdPregleda(rs.getLong("idPregleda"));
                LocalDate datum = rs.getDate("datumIVreme").toLocalDate();
                LocalTime vreme = rs.getTime("datumIVreme").toLocalTime();
                p.setDatumIVreme(LocalDateTime.of(datum.getYear(), datum.getMonth(), datum.getDayOfMonth(), vreme.getHour(), vreme.getMinute()));
                p.setOznakaOrdinacije(rs.getString("oznakaOrdinacije"));
                p.setBrojUsluga(rs.getInt("brojUsluga"));
                p.setUkupnoTrajanje(rs.getInt("ukupnoTrajanje"));
                p.setNapomena(rs.getString("napomena"));
                p.setDoktor(doktor);
                Pacijent pacijent = new Pacijent();
                pacijent.setIdPacijenta(rs.getLong("idPacijenta"));
                pacijent.setIme(rs.getString("ime"));
                pacijent.setPrezime(rs.getString("prezime"));
                pacijent.setDatumRodjenja(rs.getDate("datumRodjenja").toLocalDate());
                pacijent.setPol(Pol.valueOf(rs.getString("pol")));
                pacijent.setGodine(rs.getInt("godine"));
                pacijent.setKontakt(rs.getString("kontakt"));
                pacijent.setGodine(rs.getInt("godine"));
                p.setPacijent(pacijent);
                pregledi.add(p);
            }
            return pregledi;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
    public Pregled kreirajPregled() throws Exception{
        try{
            String query = "INSERT INTO pregled (datumIVreme, oznakaOrdinacije, brojUsluga, ukupnoTrajanje, napomena, idDoktora, idPacijenta) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            Pregled pregled = new Pregled();
            if(rs.next()){
                pregled.setIdPregleda(rs.getLong(1));
            }
            return pregled;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void kreirajPregled(Pregled pregled) throws Exception{
        try{
            String query = "UPDATE pregled SET datumIVreme = ?, oznakaOrdinacije = ?, napomena = ?, idDoktora = ?, idPacijenta = ? WHERE idPregleda = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setTimestamp(1, Timestamp.valueOf(pregled.getDatumIVreme()));
            ps.setString(2, pregled.getOznakaOrdinacije());
            ps.setString(3, pregled.getNapomena());
            ps.setLong(4, pregled.getDoktor().getIdDoktora());
            ps.setLong(5, pregled.getPacijent().getIdPacijenta());
            ps.setLong(6, pregled.getIdPregleda());
            ps.execute();
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public List<Pacijent> getAllPacijent() throws Exception{
        try{
            String query = "SELECT * FROM pacijent INNER JOIN grad ON pacijent.zipkod = grad.zipkod";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            List<Pacijent> pacijenti = new ArrayList<>();
            while(rs.next()){
                Pacijent pacijent = new Pacijent();
                pacijent.setIdPacijenta(rs.getLong("idPacijenta"));
                pacijent.setIme(rs.getString("ime"));
                pacijent.setPrezime(rs.getString("prezime"));
                pacijent.setDatumRodjenja(rs.getDate("datumRodjenja").toLocalDate());
                pacijent.setPol(Pol.valueOf(rs.getString("pol")));
                pacijent.setGodine(rs.getInt("godine"));
                pacijent.setKontakt(rs.getString("kontakt"));
                
                Grad grad = new Grad();
                grad.setZipkod(rs.getLong("zipkod"));
                grad.setNaziv(rs.getString("naziv"));
                
                pacijent.setGrad(grad);
                
                pacijenti.add(pacijent);
            }
            return pacijenti;
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
