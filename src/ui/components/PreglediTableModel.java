/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components;

import domain.Pregled;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class PreglediTableModel extends AbstractTableModel{
    private List<Pregled> pregledi;
    private String[] columnNames = {"ID", "Pacijent", "Datum", "Vreme", "Ordinacija"};
    private Class[] columnClasses = {Long.class, String.class, LocalDate.class, LocalTime.class, String.class};

    public PreglediTableModel(List<Pregled> pregledi) {
        this.pregledi = pregledi;
    }
    
    
    
    @Override
    public int getRowCount() {
        return pregledi.size();
    }

    @Override
    public int getColumnCount() {
        return columnClasses.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pregled pregled = pregledi.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> pregled.getIdPregleda();
            case 1 -> pregled.getPacijent().getIme() + " " + pregled.getPacijent().getPrezime();
            case 2 -> LocalDate.of(pregled.getDatumIVreme().getYear(), pregled.getDatumIVreme().getMonth(), pregled.getDatumIVreme().getDayOfMonth());
            case 3 -> LocalTime.of(pregled.getDatumIVreme().getHour(), pregled.getDatumIVreme().getMinute());
            case 4 -> pregled.getOznakaOrdinacije();
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
