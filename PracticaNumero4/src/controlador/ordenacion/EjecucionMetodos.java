/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ordenacion;

import controlador.ed.lista.ListaEnlazada;

public class EjecucionMetodos {

    public void Imprimir(Object[] m) {
        System.out.println("IMPRIMIR MATRIZ ");
        for (int i = 0; i < m.length; i++) {

            System.out.print(m[i].toString() + ", ");
        }
        System.out.println("\nFinal ------");
    }

    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        for (int i = 0; i < 10; i++) {
            int dato = (int) (Math.random() * 100000);
            lista.agregarDato(dato);
        }

        System.out.println("Lista original:");
        try {
            lista.imprimir();
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
        }

        QuickSort quickSort = new QuickSort();
        try {
            quickSort.quicksort(lista, 0, lista.size() - 1, QuickSort.ASCENDENTE);
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
        }

        System.out.println("Lista ordenada en forma ascendente:");
        try {
            lista.imprimir();
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
        }

        MergeSort mergeSort = new MergeSort();
        try {
            mergeSort.mergeSort(lista, MergeSort.DESCENDENTE);
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
        }

        System.out.println("Lista ordenada en forma descendente:");
        try {
            lista.imprimir();
        } catch (Exception e) {
            // Manejo de excepciones si es necesario
        }
    }

//        long startTime = System.currentTimeMillis();
//        System.out.println("Lista original:");
//        try {
//            lista.imprimir();
//        } catch (Exception e) {
//            // Manejo de excepciones si es necesario
//        }
//
//        MergeSort mergeSort = new MergeSort();
//        try {
//            mergeSort.mergeSort(lista, MergeSort.ASCENDENTE);
//        } catch (Exception e) {
//            // Manejo de excepciones si es necesario
//        }
//
//        System.out.println("Lista ordenada en forma ascendente:");
//        try {
//            lista.imprimir();
//        } catch (Exception e) {
//            // Manejo de excepciones si es necesario
//        }
//
//        try {
//            mergeSort.mergeSort(lista, MergeSort.DESCENDENTE);
//        } catch (Exception e) {
//            // Manejo de excepciones si es necesario
//        }
//
//        System.out.println("Lista ordenada en forma descendente:");
//        try {
//            lista.imprimir();
//        } catch (Exception e) {
//            // Manejo de excepciones si es necesario
//        }
//        long endTime = System.currentTimeMillis();
//        long duration = endTime - startTime;
//        System.out.println("Tiempo de ejecución : " + duration + " milisegundos");
//
//    }
}
