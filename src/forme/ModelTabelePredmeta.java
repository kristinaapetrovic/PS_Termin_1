/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Predmet;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePredmeta extends AbstractTableModel {

    private List<Predmet> lista;
    private String []kolone={"naziv", "esbp", "katedra"};

    public ModelTabelePredmeta(List<Predmet> lista) {
        this.lista = lista;
    }

    public List<Predmet> getLista() {
        return lista;
    }

    public void setLista(List<Predmet> lista) {
        this.lista = lista;
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Predmet p=lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getNaziv();
            case 1: return p.getEspb()+"";
            case 2: return p.getKatedra().getNaziv();
            default: return "n/a";
            
            
        }
    
    
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
}
