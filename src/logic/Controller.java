/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Doktor;
import domain.Pacijent;
import domain.Pregled;
import domain.StavkaPregleda;
import domain.Usluga;
import java.util.List;
import repository.DatabaseRepository;

/**
 *
 * @author PC
 */
public class Controller {
    private DatabaseRepository databaseRepository;

    public Controller() {
        databaseRepository = new DatabaseRepository();
    }
    
    
    
    public Doktor prijaviDoktor(String korisnickoIme, String lozinka) throws Exception{
        try{
            databaseRepository.connect();
            Doktor doktor = databaseRepository.getDoktorByKorisnickoIme(korisnickoIme);
            databaseRepository.disconnect();
            if(korisnickoIme == null || korisnickoIme.isEmpty())
                throw new Exception("Nije uneto korisničko ime.");
            if(lozinka == null || lozinka.isEmpty())
                throw new Exception("Nije uneta lozinka.");
            if(doktor == null){
                throw new Exception("Ne postoji doktor sa korisnickim imenom: " + korisnickoIme);            
            }
            if(!doktor.getLozinka().equals(lozinka)){
                throw new Exception("Netačna lozinka.");
            }
            return doktor;
        }catch(Exception ex){
            throw ex;
        }
        
    }
    
    public List<Pregled> vratiListuPregled(Doktor doktor) throws Exception{
        try{
            databaseRepository.connect();
            List<Pregled> pregledi = databaseRepository.vratiListuPregled(doktor);
            databaseRepository.disconnect();
            return pregledi;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public Pregled kreirajPregled() throws Exception{
        try{
            databaseRepository.connect();
            Pregled pregled = databaseRepository.kreirajPregled();
            databaseRepository.commit();
            return pregled;
        }catch(Exception ex){
            databaseRepository.rollback();
            throw ex;
        }finally{
            databaseRepository.disconnect();            
        }
    }
    
    public void promeniPregled(Pregled pregled) throws Exception{
        try{
            databaseRepository.connect();
            databaseRepository.promeniPregled(pregled);
            databaseRepository.commit();
            
        }catch(Exception ex){
            databaseRepository.rollback();
            throw ex;
        }finally{
            databaseRepository.disconnect();
        }
    }
    
    public List<Pacijent> vratiListuPacijent() throws Exception{
        try{
            databaseRepository.connect();
            List<Pacijent> pacijenti = databaseRepository.vratiListuPacijent();
            databaseRepository.disconnect();
            return pacijenti;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void obrisiPregled(Pregled pregled) throws Exception{
        try{
            databaseRepository.connect();
            databaseRepository.obrisiPregled(pregled);
            databaseRepository.commit();
        }catch(Exception ex){
            databaseRepository.rollback();
            throw ex;
        }finally{
            databaseRepository.disconnect();
        }
    }
    
    public List<Usluga> vratiListuUsluga() throws Exception{
        try{
            databaseRepository.connect();
            List<Usluga> usluge = databaseRepository.vratiListuUsluga();
            databaseRepository.disconnect();
            return usluge;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public StavkaPregleda kreirajStavkaPregleda(StavkaPregleda stavkaPregleda) throws Exception{
        try{
            databaseRepository.connect();
            stavkaPregleda = databaseRepository.kreirajStavkaPregleda(stavkaPregleda);
            databaseRepository.commit();
            return stavkaPregleda;
        }catch(Exception ex){
            databaseRepository.rollback();
            throw ex;
        }finally{
            databaseRepository.disconnect();
        }
    }
}
