/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author PC
 */
public class Specijalizacija {
    private Long idSpecijalizacije;
    private String naziv;
    private String opis;

    public Specijalizacija() {
    }

    public Long getIdSpecijalizacije() {
        return idSpecijalizacije;
    }

    public void setIdSpecijalizacije(Long idSpecijalizacije) {
        this.idSpecijalizacije = idSpecijalizacije;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    
}
