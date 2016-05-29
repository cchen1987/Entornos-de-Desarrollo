package p5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author chao
 */
public class Lists {
    
    List<Integer> lista;
    List<Integer> listaEnl;
    List<Integer> tempList;
    List<Integer> tempListEnl;
    Random rnd;
    double tInicio;
    double tFin;
    double tTranscurrido;
    double tCopiaLista;
    double tCopiaListaEnl;
    int tempInt;
    
    public Lists() {
        rnd = new Random();
        // ArrayList
        lista = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(rnd.nextInt(2000000));
        }
        
        // LinkedList
        listaEnl = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            listaEnl.add(rnd.nextInt(2000000));
        }
        
        // Medición tiempo medio para copiar un ArrayList
        tInicio = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
        }
        tFin = System.currentTimeMillis();
        tCopiaLista = (tFin - tInicio);
        
        // Medición tiempo medio para copiar un LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
        }
        tFin = System.nanoTime();
        tCopiaListaEnl = (tFin - tInicio);
    }
    
    public void insertar() {
        System.out.println("-- Inserción --");
        System.out.println("-- Cada medición lleva consigo el tiempo de copia de los arrays --");
        tTranscurrido = 0;
        
        System.out.println("                             ArrayList            LinkedList");
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
            tempList.add(0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- al final de la lista       " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.add(0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
            tempList.add(0, 0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- al principio de la lista   " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.add(0, 0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
            tempList.add(499, 0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- a mitad de la lista        " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.add(499, 0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
    }
    
    public void borrarPorPosicion() {
        System.out.println("-- Borrado por posición --");
        System.out.println("-- Cada medición lleva consigo el tiempo de copia de los arrays --");
        tTranscurrido = 0;
        
        System.out.println("                             ArrayList            LinkedList");
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
            tempList.remove(999);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- al final de la lista       " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.remove(999);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
            tempList.remove(0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- al principio de la lista   " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.remove(0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("       " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
            tempList.remove(499);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- a mitad de la lista        " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.remove(499);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("       " + tTranscurrido + " ms");
    }
    
    public void borrarPorValor() {
        lista = new ArrayList<>();
        listaEnl = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(i);
            listaEnl.add(i);
        }
        
        int finLista = lista.get(999);
        int prinLista = lista.get(0);
        int midLista = lista.get(499);
        int finListaEnl = listaEnl.get(999);
        int prinListaEnl = listaEnl.get(0);
        int midListaEnl = listaEnl.get(499);
        
        System.out.println("-- Borrado por valor --");
        System.out.println("-- Cada medición lleva consigo el tiempo de copia de los arrays --");
        tTranscurrido = 0;
        
        System.out.println("                             ArrayList            LinkedList");
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new LinkedList<>(lista);
            tempList.removeIf(x -> x == finLista);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- al final de la lista       " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.removeIf(x -> x == finListaEnl);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new LinkedList<>(lista);
            tempList.removeIf(x -> x == prinLista);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- al principio de la lista   " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.removeIf(x -> x == prinListaEnl);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new LinkedList<>(lista);
            tempList.removeIf(x -> x == midLista);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- a mitad de la lista        " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.removeIf(x -> x == midListaEnl);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
    }
    
    public void vaciado() {
        System.out.println("-- Vaciado --");
        System.out.println("-- Cada medición lleva consigo el tiempo de copia de los arrays --");
        
        System.out.println("                             ArrayList            LinkedList");
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempList = new LinkedList<>(lista);
            tempList.clear();
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- Vaciado del array          " + tTranscurrido + " ms");
        
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tempListEnl.clear();
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
    }
    
    public void busqueda() {
        lista = new ArrayList<>();
        listaEnl = new LinkedList<>();
        tTranscurrido = 0;
        for (int i = 0; i < 1000; i++) {
            lista.add(i);
            listaEnl.add(i);
        }
        int finNum = 999;
        int iniNum = 0;
        int midNum = 499;
        double time = 0;
        System.out.println("-- Búsqueda con funciones propias --");
        System.out.println("                             ArrayList            LinkedList");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(finNum)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurrido = (time) / Math.pow(10, 10);
        System.out.print("- función propia final       " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(finNum)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurrido = (time) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(iniNum)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurrido = (time) / Math.pow(10, 10);
        System.out.print("- función propia principio   " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(iniNum)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurrido = (time) / Math.pow(10, 10);
        System.out.println("        " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(midNum)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurrido = (time) / Math.pow(10, 10);
        System.out.print("- función propia mitad       " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(midNum)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurrido = (time) / Math.pow(10, 10);
        System.out.println("       " + tTranscurrido + " ms");
        
        System.out.println();
        System.out.println("-- Búsqueda normal --");
        System.out.println("                             ArrayList            LinkedList");
        
        // ArrayList
        boolean encontrado;
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (lista.get(j) == finNum) {
                    encontrado = true;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- final de la lista          " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (listaEnl.get(j) == finNum) {
                    encontrado = true;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (lista.get(j) == iniNum) {
                    encontrado = true;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- principio de la lista      " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (listaEnl.get(j) == iniNum) {
                    encontrado = true;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("         " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (lista.get(j) == midNum) {
                    encontrado = true;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- mitad de la lista          " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (listaEnl.get(j) == midNum) {
                    encontrado = true;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("      " + tTranscurrido + " ms");
        
        System.out.println();
        System.out.println("-- Búsqueda binaria --");
        System.out.println("                             ArrayList            LinkedList");
        
        int inicio, fin, mid ;
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio != mid) {
                if (lista.get(mid) == finNum) {
                    encontrado = true;
                }
                else if (lista.get(fin) == finNum) {
                    encontrado = true;
                }
                if (lista.get(mid) > finNum) {
                    fin = mid;
                    mid = (fin + inicio) / 2;
                }
                else if (lista.get(mid) < finNum) {
                    inicio = mid;
                    mid = (fin + inicio) / 2;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- final de la lista          " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio != mid) {
                if (listaEnl.get(mid) == finNum) {
                    encontrado = true;
                }
                else if (listaEnl.get(fin) == finNum) {
                    encontrado = true;
                }
                if (listaEnl.get(mid) > finNum) {
                    fin = mid;
                    mid = (fin + inicio) / 2;
                }
                else if (listaEnl.get(mid) < finNum) {
                    inicio = mid;
                    mid = (fin + inicio) / 2;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("       " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio != mid) {
                if (lista.get(mid) == iniNum) {
                    encontrado = true;
                }
                else if (lista.get(fin) == iniNum) {
                    encontrado = true;
                }
                if (lista.get(mid) > iniNum) {
                    fin = mid;
                    mid = (fin + inicio) / 2;
                }
                else if (lista.get(mid) < iniNum) {
                    inicio = mid;
                    mid = (fin + inicio) / 2;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- principio de la lista      " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio != mid) {
                if (listaEnl.get(mid) == iniNum) {
                    encontrado = true;
                }
                else if (listaEnl.get(fin) == iniNum) {
                    encontrado = true;
                }
                if (listaEnl.get(mid) > iniNum) {
                    fin = mid;
                    mid = (fin + inicio) / 2;
                }
                else if (listaEnl.get(mid) < iniNum) {
                    inicio = mid;
                    mid = (fin + inicio) / 2;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("       " + tTranscurrido + " ms");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio != mid) {
                if (lista.get(mid) == midNum) {
                    encontrado = true;
                }
                else if (lista.get(fin) == midNum) {
                    encontrado = true;
                }
                if (lista.get(mid) > midNum) {
                    fin = mid;
                    mid = (fin + inicio) / 2;
                }
                else if (lista.get(mid) < midNum) {
                    inicio = mid;
                    mid = (fin + inicio) / 2;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.print("- mitad de la lista          " + tTranscurrido + " ms");
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio != mid) {
                if (inicio == mid) {
                    break;
                }
                if (listaEnl.get(mid) == midNum) {
                    encontrado = true;
                }
                else if (listaEnl.get(fin) == midNum) {
                    encontrado = true;
                }
                if (listaEnl.get(mid) > midNum) {
                    fin = mid;
                }
                else if (listaEnl.get(mid) < midNum) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        System.out.println("       " + tTranscurrido + " ms");
    }
    
    public void RunTimes() {
        insertar();
        System.out.println();
        borrarPorPosicion();
        System.out.println();
        borrarPorValor();
        System.out.println();
        vaciado();
        System.out.println();
        busqueda();
    }
    
    public static void main(String[] args) {
        // Class Lists
        Lists myList = new Lists();
        System.out.println("Todos los tests basados en 10000 repeticiones sobre ArrayList y LinkedList de tamaño 1000");
        System.out.println("Obteniendo la media de las 10000 repeticiones");
        System.out.println();
        myList.RunTimes();
        
        // Class Sort
        System.out.println();
        Sort mySort = new Sort();
        mySort.RunTimes();
        System.out.println();
        mySort.RunTests();
    }
    
}
