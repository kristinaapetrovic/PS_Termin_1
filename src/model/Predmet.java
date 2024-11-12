/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Korisnik
 */
public class Predmet {
    private int id;
    private String naziv;
    private int espb;
    private Katedra katedra;

    public Predmet() {
    }

    public Predmet(int id, String naziv, int espb, Katedra katedra) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
        this.katedra = katedra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public Katedra getKatedra() {
        return katedra;
    }

    public void setKatedra(Katedra katedra) {
        this.katedra = katedra;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predmet other = (Predmet) obj;
        return this.id == other.id;
    }
    
   
    
    
    
    
}
