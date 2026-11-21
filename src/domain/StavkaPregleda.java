/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author PC
 */
public class StavkaPregleda {
    private Pregled pregled;
    private Usluga usluga;
    private String simptomi;
    private String napomena;
    private boolean hitnost;

    public StavkaPregleda() {
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public String getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(String simptomi) {
        this.simptomi = simptomi;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public boolean isHitnost() {
        return hitnost;
    }

    public void setHitnost(boolean hitnost) {
        this.hitnost = hitnost;
    }
    
    
}
