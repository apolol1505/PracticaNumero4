/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ordenacion;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;

public class QuickSort {

    public static final Integer ASCENDENTE = 0;
    public static final Integer DESCENDENTE = 1;

    public void quicksort(ListaEnlazada<Integer> lista, int izq, int der, int tipoOrden) throws VacioException, PosicionException {
        boolean ascendente = (tipoOrden == ASCENDENTE);

        if (izq < der) {
            Integer pivote = lista.get(izq);
            int i = izq;
            int j = der;

            while (i < j) {
                if (ascendente) {
                    while (lista.get(i) <= pivote && i < j) {
                        i++;
                    }
                    while (lista.get(j) > pivote) {
                        j--;
                    }
                } else {
                    while (lista.get(i) >= pivote && i < j) {
                        i++;
                    }
                    while (lista.get(j) < pivote) {
                        j--;
                    }
                }

                if (i < j) {
                    Integer aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }

            lista.set(izq, lista.get(j));
            lista.set(j, pivote);

            if (izq < j - 1) {
                quicksort(lista, izq, j - 1, tipoOrden);
            }
            if (j + 1 < der) {
                quicksort(lista, j + 1, der, tipoOrden);
            }
        }
    }
}
