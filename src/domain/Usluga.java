/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author PC
 */
public class Usluga {
    private Long idUsluge;
    private String naziv;
    private String opis;
    private int procenjenoTrajanje;
    private String napomenaZaPacijenta;

    public Usluga() {
    }

    public Long getIdUsluge() {
        return idUsluge;
    }

    public void setIdUsluge(Long idUsluge) {
        this.idUsluge = idUsluge;
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

    public int getProcenjenoTrajanje() {
        return procenjenoTrajanje;
    }

    public void setProcenjenoTrajanje(int procenjenoTrajanje) {
        this.procenjenoTrajanje = procenjenoTrajanje;
    }

    public String getNapomenaZaPacijenta() {
        return napomenaZaPacijenta;
    }

    public void setNapomenaZaPacijenta(String napomenaZaPacijenta) {
        this.napomenaZaPacijenta = napomenaZaPacijenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(naziv);
        sb.append(", ").append(procenjenoTrajanje);
        sb.append("min");
        return sb.toString();
    }
    
    
    
}
