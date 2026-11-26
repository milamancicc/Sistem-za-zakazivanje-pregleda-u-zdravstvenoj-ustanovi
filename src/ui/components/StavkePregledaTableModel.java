/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components;

import domain.StavkaPregleda;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class StavkePregledaTableModel extends AbstractTableModel {

    private List<StavkaPregleda> stavkePregleda;
    private String[] columnNames = {"RB", "Usluga", "Opis", "Trajanje", "Simptomi", "Napomena", "Hitnost", "Obriši"};
    private Class[] columnClasses = {Long.class, String.class, String.class, int.class, String.class, String.class, Boolean.class, JButton.class};

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
            case 7 -> "Obriši";
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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex == 4 || columnIndex == 5 || columnIndex == 6);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaPregleda stavkaPregleda = stavkePregleda.get(rowIndex);
        switch (columnIndex) {
            case 4:
                stavkaPregleda.setSimptomi((String) aValue);
                break;
            case 5:
                stavkaPregleda.setNapomena((String) aValue);
                break;
            case 6:
                stavkaPregleda.setHitnost((boolean) aValue);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
    
    
    
}
