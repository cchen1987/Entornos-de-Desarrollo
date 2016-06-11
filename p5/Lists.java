package p5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author chao
 */
public class Lists {
    
    public interface IComparer {
        public boolean compare(int a, int b);
    }
    
    List<Integer> lista;
    List<Integer> listaEnl;
    Random rnd;
    double tInicio;
    double tFin;
    double tTranscurrido;
    double tTranscurridoEnl;
    String color;
    String colorEnl;
    int tempInt;
    DecimalFormat df;
    List<List<Integer>> listas;
    
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
        df = new DecimalFormat("0.0000000000");
        
        listas = new ArrayList<>();
    }
    
    public List<List<Integer>> CreateOrderedList(boolean isArrayList){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp;
        if (isArrayList) {
            for (int i = 0; i < 10000; i++) {
                temp = new ArrayList<>();
                for (int j = 0; j < 1000; j++) {
                    temp.add(i);
                }
                list.add(temp);
            }
        }
        else {
            for (int i = 0; i < 10000; i++) {
                temp = new LinkedList<>();
                for (int j = 0; j < 1000; j++) {
                    temp.add(i);
                }
                list.add(temp);
            }
        }
        return list;
   }
    
    public boolean binarySearch(List<Integer> list, int num) {
        int inicio = 0;
        int fin = 999;
        int mid = (fin + inicio) / 2;
        while (inicio < mid) {
            if (inicio == mid) {
                return false;
            }
            if (list.get(mid) == num) {
                return true;
            }
            else if (list.get(fin) == num) {
                return true;
            }
            if (list.get(mid) > num) {
                fin = mid;
            }
            else if (list.get(mid) < num) {
                inicio = mid;
            }
            mid = (fin + inicio) / 2;
        }
        return false;
    }
    
    public void insertar() {
        System.out.println("-- Inserción --");
        tTranscurrido = 0;
        System.out.println("                             ArrayList            LinkedList");
        
        // Inserción al final de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).add(1000);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Inserción al final de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).add(1000);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Inserción al principio de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).add(0, 0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Inserción al principio de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).add(0, 0);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        int mid = 999 / 2;
        // Inserción a la mitad de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).add(mid, 0);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Inserción a la mitad de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).add(mid, 0);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void borrarPorPosicion() {
        int indFinal = 999;
        int indPrinc = 0;
        int mid = 999 / 2;
        
        System.out.println("-- Borrado por posición --");
        System.out.println("                             ArrayList            LinkedList");
        
        // Borrado de un elemento al final de un ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(indFinal);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Borrado de un elemento al final de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(indFinal);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Borrado de un elemento al principio de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(indPrinc);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Borrado de un elemento al principio de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(indPrinc);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Borrado de un elemento a la mitad de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(mid);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Borrado de un element a la mitad de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(mid);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void borrarPorValor() {
        // Obtener elementos de las listas
        int mid = 999 / 2;
        Integer finLista = new Integer(999);
        Integer prinLista = new Integer(0);
        Integer midLista = new Integer(mid);
        
        System.out.println("-- Borrado por valor --");
        System.out.println("                             ArrayList            LinkedList");
        
        // Borrar por valor un elemento que está al final de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(finLista);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Borrar por valor un elemento que está al final de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(finLista);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Borrar por valor un elemento que está al principio de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(prinLista);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Borrar por valor un elemento que está al principio de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(prinLista);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Borrar por valor un elemento que está a la mitad de un ArrayList
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(midLista);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Borrar por valor un elemento que está a la mitad de un LinkedList
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).remove(midLista);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void vaciado() {
        System.out.println("-- Vaciado --");
        System.out.println("                             ArrayList            LinkedList");
        
        // Vaciado de un arraylist
        listas = CreateOrderedList(true);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).clear();
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Vaciado de un linkedlist
        listas = CreateOrderedList(false);
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listas.get(i).clear();
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- Vaciado del array          " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void busqueda() {
        lista = new ArrayList<>();
        listaEnl = new LinkedList<>();
        // Llenado de listas con números ordenados
        for (int i = 0; i < 1000; i++) {
            lista.add(i);
            listaEnl.add(i);
        }
        int finNum = 999;
        int iniNum = 0;
        int midNum = 999 / 2;
        System.out.println("-- Búsqueda con funciones propias --");
        System.out.println("                             ArrayList            LinkedList");
        
        // Búsqueda con función propio de un ArrayList de un elemento al final de la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(finNum)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda con función propio de un LinkedList de un elemento al final de la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(finNum)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda con función propio de un ArrayList de un elemento al principio de la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(iniNum)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda con función propio de un LinkedList de un elemento al principio de la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(iniNum)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda con función propio de un ArrayList de un elemento a la mitad de la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(midNum)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda con función propio de un LinkedList de un elemento a la mitad de la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(midNum)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda con función propio de un ArrayList de un elemento no existente en la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(4000000)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda con función propio de un LinkedList de un elemento no existente en la lista
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(4000000)) {
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- no existente               " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        System.out.println();
        System.out.println("-- Búsqueda secuencial --");
        System.out.println("                             ArrayList            LinkedList");
        
        // Búsqueda secuencial de un número al final de un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lista.get(j) == finNum) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda secuencial de un número al final de un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (listaEnl.get(j) == finNum) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda secuencial de un número al principio de un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lista.get(j) == iniNum) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda secuencial de un número al principio de un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (listaEnl.get(j) == iniNum) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda secuencial de un número a la mitad de un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lista.get(j) == midNum) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda secuencial de un número a la mitad de un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (listaEnl.get(j) == midNum) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda secuencial de un número no existente en un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lista.get(j) == 4000000) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda secuencial de un número no existente en un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (listaEnl.get(j) == 4000000) {
                    break;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- no existente               " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        System.out.println();
        System.out.println("-- Búsqueda binaria --");
        System.out.println("                             ArrayList            LinkedList");
        
        // Búsqueda binaria de un número al final de un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(lista, finNum);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda binaria de un número al final de un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(listaEnl, finNum);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda binaria de un número al principio de un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(lista, iniNum);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda binaria de un número al principio de un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(listaEnl, iniNum);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda binaria de un número a la mitad de un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(lista, midNum);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda binaria de un número a la mitad de un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(listaEnl, midNum);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // Búsqueda binaria de un número no existente de un arraylist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(lista, 4000000);
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // Búsqueda binaria de un número no existente de un linkedlist
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            binarySearch(listaEnl, 4000000);
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- no existente               " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void RunTimes() {
        System.out.println("Todos los tests basados en 10000 repeticiones sobre ArrayList y LinkedList de tamaño 1000");
        System.out.println("Obteniendo la media de las 10000 repeticiones");
        System.out.println();
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
        myList.RunTimes();
        
        // Class Sort
        System.out.println();
        Sort mySort = new Sort();
        mySort.RunTimes();
        System.out.println();
        mySort.RunTests();
    }
}
