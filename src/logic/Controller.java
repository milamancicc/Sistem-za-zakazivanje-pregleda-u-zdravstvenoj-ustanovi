/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Doktor;
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
    
    
    
    public Doktor prijaviSe(String korisnickoIme, String lozinka) throws Exception{
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
}
