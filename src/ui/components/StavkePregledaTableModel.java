/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components;

import domain.StavkaPregleda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class StavkePregledaTableModel extends AbstractTableModel {

    private List<StavkaPregleda> stavkePregleda;
    private String[] columnNames = {"RB", "Usluga", "Opis", "Trajanje", "Simptomi", "Napomena", "Hitnost"};
    private Class[] columnClasses = {Long.class, String.class, String.class, int.class, String.class, String.class, Boolean.class};

    public StavkePregledaTableModel(List<StavkaPregleda> stavkePregleda) {
        this.stavkePregleda = stavkePregleda;
    }
    
    
    
    @Override
    public int getRowCount() {
        return stavkePregleda.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPregleda stavkaPregleda = stavkePregleda.get(rowIndex);
        return switch(columnIndex){
            case 0 -> stavkaPregleda.getRb();
            case 1 -> stavkaPregleda.getUsluga().getNaziv();
            case 2 -> stavkaPregleda.getUsluga().getOpis();
            case 3 -> stavkaPregleda.getUsluga().getProcenjenoTrajanje();
            case 4 -> stavkaPregleda.getSimptomi();
            case 5 -> stavkaPregleda.getNapomena();
            case 6 -> stavkaPregleda.isHitnost();
            default -> "n/a";
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }
    
    
    
}
