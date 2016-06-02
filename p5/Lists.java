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
    
    List<Integer> lista;
    List<Integer> listaEnl;
    List<Integer> tempList;
    List<Integer> tempListEnl;
    Random rnd;
    double tInicio;
    double tFin;
    double tTranscurrido;
    double tTranscurridoEnl;
    String color;
    String colorEnl;
    int tempInt;
    DecimalFormat df;
    
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
        tempList = new ArrayList<>(lista);
        tempListEnl = new LinkedList<>(listaEnl);
        df = new DecimalFormat("0.0000000000");
    }
    
    public void insertar() {
        System.out.println("-- Inserción --");
        tTranscurrido = 0;
        int sum = 0;
        System.out.println("                             ArrayList            LinkedList");
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.add(0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.remove(1000);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.add(0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.remove(1000);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        sum = 0;
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.add(0, 0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.remove(0);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.add(0, 0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.remove(0);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        sum = 0;
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.add(499, 0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.remove(499);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.add(499, 0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.remove(499);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void borrarPorPosicion() {
        System.out.println("-- Borrado por posición --");
        tTranscurrido = 0;
        int sum = 0;
        System.out.println("                             ArrayList            LinkedList");
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.remove(999);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.add(0);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.remove(999);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.add(0);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        sum = 0;
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.remove(0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.add(0, 0);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.remove(0);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.add(0, 0);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        sum = 0;
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.remove(499);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.add(499, 0);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.remove(499);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.add(499, 0);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void borrarPorValor() {
        lista = new ArrayList<>();
        listaEnl = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(i);
            listaEnl.add(i);
        }
        tempList = new ArrayList<>(lista);
        tempListEnl = new LinkedList<>(listaEnl);
        int finLista = lista.get(999);
        int prinLista = lista.get(0);
        int midLista = lista.get(499);
        int finListaEnl = listaEnl.get(999);
        int prinListaEnl = listaEnl.get(0);
        int midListaEnl = listaEnl.get(499);
        
        System.out.println("-- Borrado por valor --");
        tTranscurrido = 0;
        int sum = 0;
        System.out.println("                             ArrayList            LinkedList");
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.removeIf(x -> x == finLista);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.add(finLista);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.removeIf(x -> x == finListaEnl);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.add(finListaEnl);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        sum = 0;
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.removeIf(x -> x == prinLista);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.add(0, prinLista);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.removeIf(x -> x == prinListaEnl);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.add(0, prinListaEnl);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        sum = 0;
        // ArrayList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempList.removeIf(x -> x == midLista);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempList.add(499, midLista);
        }
        tTranscurrido = sum / Math.pow(10, 10);
        sum = 0;
        // LinkedList
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            tempListEnl.removeIf(x -> x == midListaEnl);
            tFin = System.nanoTime();
            sum += tFin - tInicio;
            tempListEnl.add(499, midListaEnl);
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void vaciado() {
        System.out.println("-- Vaciado --");
        System.out.println("                             ArrayList            LinkedList");
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            tempList = new ArrayList<>(lista);
            tInicio = System.nanoTime();
            tempList.clear();
            tFin = System.nanoTime();
            sum += tFin - tInicio;
        }
        tTranscurrido = sum / Math.pow(10, 10);
        
        sum = 0;
        for (int i = 0; i < 10000; i++) {
            tempListEnl = new LinkedList<>(listaEnl);
            tInicio = System.nanoTime();
            tempListEnl.clear();
            tFin = System.nanoTime();
            sum += tFin - tInicio;
        }
        tTranscurridoEnl = sum / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- Vaciado del array          " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
    }
    
    public void busqueda() {
        lista = new ArrayList<>();
        listaEnl = new LinkedList<>();
        tTranscurrido = 0;
        // Llenado de listas con números ordenados
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
        tTranscurridoEnl = (time) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
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
        tTranscurridoEnl = (time) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
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
        tTranscurridoEnl = (time) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (lista.contains(4000000)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurrido = (time) / Math.pow(10, 10);
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (listaEnl.contains(4000000)) {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
            else {
                tFin = System.nanoTime();
                time = tFin - tInicio;
            }
        }
        tTranscurridoEnl = (time) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- no existente               " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        System.out.println();
        System.out.println("-- Búsqueda secuencial --");
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
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
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
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
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
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (lista.get(j) == 4000000) {
                    encontrado = true;
                }
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            encontrado = false;
            for (int j = 0; j < 1000 && !encontrado; j++) {
                if (listaEnl.get(j) == 4000000) {
                    encontrado = true;
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
        
        int inicio, fin, mid ;
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
                if (lista.get(mid) == finNum) {
                    encontrado = true;
                }
                else if (lista.get(fin) == finNum) {
                    encontrado = true;
                }
                if (lista.get(mid) > finNum) {
                    fin = mid;
                }
                else if (lista.get(mid) < finNum) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
                if (listaEnl.get(mid) == finNum) {
                    encontrado = true;
                }
                else if (listaEnl.get(fin) == finNum) {
                    encontrado = true;
                }
                if (listaEnl.get(mid) > finNum) {
                    fin = mid;
                }
                else if (listaEnl.get(mid) < finNum) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al final de la lista       " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
                if (lista.get(mid) == iniNum) {
                    encontrado = true;
                }
                else if (lista.get(fin) == iniNum) {
                    encontrado = true;
                }
                if (lista.get(mid) > iniNum) {
                    fin = mid;
                }
                else if (lista.get(mid) < iniNum) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
                if (listaEnl.get(mid) == iniNum) {
                    encontrado = true;
                }
                else if (listaEnl.get(fin) == iniNum) {
                    encontrado = true;
                }
                if (listaEnl.get(mid) > iniNum) {
                    fin = mid;
                }
                else if (listaEnl.get(mid) < iniNum) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- al principio de la lista   " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
                if (lista.get(mid) == midNum) {
                    encontrado = true;
                }
                else if (lista.get(fin) == midNum) {
                    encontrado = true;
                }
                if (lista.get(mid) > midNum) {
                    fin = mid;
                }
                else if (lista.get(mid) < midNum) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
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
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- a mitad de la lista        " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
        
        // ArrayList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
                if (lista.get(mid) == 4000000) {
                    encontrado = true;
                }
                else if (lista.get(fin) == 4000000) {
                    encontrado = true;
                }
                if (lista.get(mid) > 4000000) {
                    fin = mid;
                }
                else if (lista.get(mid) < 4000000) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurrido = (tFin - tInicio) / Math.pow(10, 10);
        
        // LinkedList
        tInicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            inicio = 0;
            fin = 999;
            mid = (fin + inicio) / 2;
            encontrado = false;
            while (!encontrado && inicio < mid) {
                if (inicio == mid) {
                    break;
                }
                if (listaEnl.get(mid) == 4000000) {
                    encontrado = true;
                }
                else if (listaEnl.get(fin) == 4000000) {
                    encontrado = true;
                }
                if (listaEnl.get(mid) > 4000000) {
                    fin = mid;
                }
                else if (listaEnl.get(mid) < 4000000) {
                    inicio = mid;
                }
                mid = (fin + inicio) / 2;
            }
        }
        tFin = System.nanoTime();
        tTranscurridoEnl = (tFin - tInicio) / Math.pow(10, 10);
        color = tTranscurrido < tTranscurridoEnl ? "[37;32m" : "[37;31m";
        colorEnl = tTranscurrido > tTranscurridoEnl ? "[37;32m" : "[37;31m";
        System.out.println("- no existente               " + (char)27 + color + df.format(tTranscurrido) + " ms"+ "      " + 
                (char)27 + colorEnl + df.format(tTranscurridoEnl) + " ms" + (char)27 + "[0m");
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
