/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.List;
import model.Katedra;
import model.Predmet;

/**
 *
 * @author Korisnik
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb=new DBBroker();
    private Controller() {
    }
    
    public static Controller getInstance(){
        if(instance==null) instance=new Controller();
        return instance;
    }

    public List<Katedra> vratiListuKatedri() {
        return dbb.vratiListuKatedri();
    }

    public boolean ubaciPredmet(Predmet p) {
        return dbb.ubaciPredmet(p);
    }

    public List<Predmet> vratiListuPredmeta() {
        return dbb.vratiListuPredmeta();
    }

    public boolean izmeniPredmet(Predmet p) {
        return dbb.izmeniPredmet(p);
    }
    
    
    
}
