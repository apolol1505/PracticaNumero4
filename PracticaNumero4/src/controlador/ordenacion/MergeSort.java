/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ordenacion;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;

public class MergeSort {

    public static final Integer ASCENDENTE = 0;
    public static final Integer DESCENDENTE = 1;

    public void mergeSort(ListaEnlazada<Integer> lista, int tipoOrden) throws VacioException, PosicionException {
        boolean ascendente = (tipoOrden == ASCENDENTE);

        if (lista.size() > 1) {
            int mitad = lista.size() / 2;

            ListaEnlazada<Integer> listaIzquierda = new ListaEnlazada<>();
            ListaEnlazada<Integer> listaDerecha = new ListaEnlazada<>();

            // Dividir la lista en dos mitades
            for (int i = 0; i < mitad; i++) {
                listaIzquierda.agregarDato(lista.get(i));
            }

            for (int i = mitad; i < lista.size(); i++) {
                listaDerecha.agregarDato(lista.get(i));
            }

            // Llamadas recursivas a mergeSort
            mergeSort(listaIzquierda, tipoOrden);
            mergeSort(listaDerecha, tipoOrden);

            // Combinar las sublistas ordenadas
            int indiceIzquierda = 0;
            int indiceDerecha = 0;
            int indiceLista = 0;

            while (indiceIzquierda < listaIzquierda.size() && indiceDerecha < listaDerecha.size()) {
                if ((ascendente && listaIzquierda.get(indiceIzquierda) <= listaDerecha.get(indiceDerecha))
                        || (!ascendente && listaIzquierda.get(indiceIzquierda) >= listaDerecha.get(indiceDerecha))) {
                    lista.set(indiceLista, listaIzquierda.get(indiceIzquierda));
                    indiceIzquierda++;
                } else {
                    lista.set(indiceLista, listaDerecha.get(indiceDerecha));
                    indiceDerecha++;
                }
                indiceLista++;
            }

            // Agregar los elementos restantes de la lista izquierda
            while (indiceIzquierda < listaIzquierda.size()) {
                lista.set(indiceLista, listaIzquierda.get(indiceIzquierda));
                indiceIzquierda++;
                indiceLista++;
            }

            // Agregar los elementos restantes de la lista derecha
            while (indiceDerecha < listaDerecha.size()) {
                lista.set(indiceLista, listaDerecha.get(indiceDerecha));
                indiceDerecha++;
                indiceLista++;
            }
        }
    }
}
