/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author PC
 */
public class SpecijalistickiPodaci {
    private Doktor doktor;
    private Specijalizacija specijalizacija;
    private int godinaPostizanja;

    public SpecijalistickiPodaci() {
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Specijalizacija getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(Specijalizacija specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getGodinaPostizanja() {
        return godinaPostizanja;
    }

    public void setGodinaPostizanja(int godinaPostizanja) {
        this.godinaPostizanja = godinaPostizanja;
    }
    
    
}
