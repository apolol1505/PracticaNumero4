/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaDatos extends AbstractTableModel {

    private ListaEnlazada<Integer> lista = new ListaEnlazada<>();

    @Override
    public int getRowCount() {
        return getLista().size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            return getLista().get(i);
        } catch (Exception e) {
            return "No definido";
        }

    }

    @Override
    public String getColumnName(int column) {
        return "Datos";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            int newValue = Integer.parseInt(aValue.toString());
            getLista().set(rowIndex, newValue);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void cargarDatos(int cantidadDatos) {
        lista.deleteAll(); // Limpiar la lista existente
        Random random = new Random();
        for (int i = 0; i < cantidadDatos; i++) {
            int dato = random.nextInt(90000) + 10000; // Generar un número aleatorio de 5 cifras
            lista.insertar(dato);
        }
        fireTableDataChanged();
    }

    public void actualizarDatos() {
        fireTableDataChanged(); // La tabla que los datos han cambiado
    }

    /**
     * @return the lista
     */
    public ListaEnlazada<Integer> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaEnlazada<Integer> lista) {
        this.lista = lista;
    }

}
