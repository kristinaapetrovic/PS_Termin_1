/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.util.List;
import model.Katedra;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Predmet;

/**
 *
 * @author Korisnik
 */
public class DBBroker {

    public List<Katedra> vratiListuKatedri() {
        
        try {
            String upit="SELECT * FROM katedra";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            
            ResultSet rs=st.executeQuery(upit);
            List<Katedra> lista=new ArrayList<>();
            
            while(rs.next()){
                int id=rs.getInt("id");
                String naziv=rs.getString("naziv");
                Katedra k=new Katedra(id, naziv);
                lista.add(k);
            }
            
            
            
            st.close();
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean ubaciPredmet(Predmet p) {
        
    
        try {
            String upit="INSERT INTO predmet (naziv, espb, katedra_id) VALUES (?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.setString(1, p.getNaziv());
            ps.setInt(2, p.getEspb());
            ps.setInt(3, p.getKatedra().getId());
            
            int redovi=ps.executeUpdate();
            
            Konekcija.getInstance().getConnection().commit();
            ps.close();
            return redovi>0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Predmet> vratiListuPredmeta() {
        try {
            List<Predmet> lista=new ArrayList<>();
            String upit="SELECT * FROM predmet p JOIN katedra k ON k.id=p.katedra_id ORDER BY p.espb";
            
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            
            ResultSet rs=st.executeQuery(upit);
            
            while(rs.next()){
                int idKtedre=rs.getInt("k.id");
                String nazivKatedre=rs.getString("k.naziv");
                Katedra k=new Katedra(idKtedre, nazivKatedre);
                
                int id=rs.getInt("p.id");
                String naziv=rs.getString("p.naziv");
                int espb=rs.getInt("p.espb");
                Predmet p=new Predmet(id, naziv, espb, k);
                lista.add(p);
                
                
            }
            
            
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean izmeniPredmet(Predmet p) {
        
        try {
            String upit="UPDATE predmet SET naziv=?, espb=?, katedra_id=? WHERE id=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareCall(upit);
            ps.setString(1, p.getNaziv());
            ps.setInt(2, p.getEspb());
            ps.setInt(3, p.getKatedra().getId());
            ps.setInt(4, p.getId());
            
            int red=ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            ps.close();
            return red>0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
    
    
    
}
