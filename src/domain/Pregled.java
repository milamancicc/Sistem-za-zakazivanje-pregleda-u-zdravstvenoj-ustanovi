/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class Pregled {
    private Long idPregleda;
    private LocalDateTime datumIVreme;
    private String oznakaOrdinacije;
    private int brojUsluga;
    private int ukupnoTrajanje;
    private String napomena;
    private Doktor doktor;
    private Pacijent pacijent;

    public Pregled() {
    }

    public Long getIdPregleda() {
        return idPregleda;
    }

    public void setIdPregleda(Long idPregleda) {
        this.idPregleda = idPregleda;
    }

    public LocalDateTime getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public String getOznakaOrdinacije() {
        return oznakaOrdinacije;
    }

    public void setOznakaOrdinacije(String oznakaOrdinacije) {
        this.oznakaOrdinacije = oznakaOrdinacije;
    }

    public int getBrojUsluga() {
        return brojUsluga;
    }

    public void setBrojUsluga(int brojUsluga) {
        this.brojUsluga = brojUsluga;
    }

    public int getUkupnoTrajanje() {
        return ukupnoTrajanje;
    }

    public void setUkupnoTrajanje(int ukupnoTrajanje) {
        this.ukupnoTrajanje = ukupnoTrajanje;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }
    
    
}
