package p5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sort {
    List<Integer> listaAle; // aleatoria
    List<Integer> listaOrd; // ordenada
    List<Integer> listaInvOrd; // inversamente ordenada
    List<Integer> listaIgual; // todos los elementos iguales
    Random rnd;
    double tInicio;
    double tFin;
    double tTranscurrido;
    int swaps;
    int comparaciones;
    int accesos;
    DecimalFormat df;
    
    public Sort() {
        comparaciones = 0;
        swaps = 0;
        accesos = 0;
        listaAle = new ArrayList<>();
        listaOrd = new ArrayList<>();
        listaInvOrd = new ArrayList<>();
        listaIgual = new ArrayList<>();
        rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            listaAle.add(rnd.nextInt(20000));
            listaOrd.add(i);
            listaInvOrd.add(999 - i);
            listaIgual.add(0);
        }
        df = new DecimalFormat("0.0000000000");
    }
    
    public void bubbleSort(List<Integer> list) {
        int tempInt = 0;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (list.get(i) > list.get(j)) {
                    tempInt = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tempInt);
                    swaps++;
                }
                comparaciones++;
                accesos++;
            }
        }
    }
    
    public void selectionSort(List<Integer> list) {
        int tempInt = 0;
        int menor;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            menor = i;
            for (int j = i + 1; j < size; j++) {
                comparaciones++;
                if (list.get(j) < list.get(menor)) {
                    menor = j;
                }
                accesos++;
            }
            if (i != menor) {
                tempInt = list.get(i);
                list.set(i, list.get(menor));
                list.set(menor, tempInt);
                swaps++;
                accesos++;
            }
        }
    }
    
    public void insertionSort(List<Integer> list) {
        int tempInt = 0;
        int j;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            j = i - 1;
            comparaciones++;
            while ((j >= 0) && (list.get(j) > list.get(j + 1))) {
                tempInt = list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, tempInt);
                j--;
                comparaciones++;
                swaps++;
                accesos++;
            }
            accesos++;
        }
    }
    
    public void quickSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int q = particion(list, left, right);
            quickSort(list, left, q - 1);
            quickSort(list, q + 1, right);
        }
    }
    
    public int particion(List<Integer> list, int left, int right) {
        int tempInt = 0;
        int pivot = list.get(right);
        
        int i = left;
        for (int j = left; j < right; j++) {
            if (list.get(j) < pivot) {
                tempInt = list.get(j);
                list.set(j, list.get(i));
                list.set(i, tempInt);
                i++;
                swaps++;
            }
            accesos++;
            comparaciones++;
        }
        
        list.set(right, list.get(i));
        list.set(i, pivot);
        accesos += 3;
        return i;
    }
    
    public void mergeSort(List<Integer> a, List<Integer> b, int from, int to) {
        if (from < to) {
            int pivot = (to + from) / 2;
            mergeSort(a, b, from, pivot);
            mergeSort(a, b, pivot + 1, to);
            merge(a, b, from, pivot, to);
        }
    }
    
    public void merge(List<Integer> a, List<Integer> b, int from, int pivot, int to) {
        int i = from;
        int h = from;
        int j = pivot + 1;
        
        while ((h <= pivot) && (j <= to)) {
            comparaciones++;
            if (a.get(h) <= a.get(j)) {
                b.set(i, a.get(h));
                h++;
            }
            else {
                b.set(i, a.get(j));
                j++;
                swaps++;
            }
            i++;
            accesos++;
        }
        if (h > pivot) {
            for (int k = j; k <= to; k++) {
                b.set(i, a.get(k));
                i++;
                accesos++;
            }
        }
        else {
            for (int k = h; k <= pivot; k++) {
                b.set(i, a.get(k));
                i++;
                accesos++;
            }
        }
        for (int k = from; k <= to; k++) {
            a.set(k, b.get(k));
            accesos++;
        }
    }
    
    public boolean sequentialSearch(List<Integer> list, int value) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }
    
    public boolean binarySearch(List<Integer> list, int value) {
        int left = 0;
        int right = list.size() - 1;
        int mid = (left + right) / 2;
        if (list.get(left) == value) {
            return true;
        }
        while (left < mid) {
            if (list.get(mid) == value) {
                return true;
            }
            else if (list.get(right) == value) {
                return true;
            }
            if (list.get(mid) < value) {
                left = mid;
            }
            else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return false;
    }
    
    public void RunTimes() {
        List<Integer> tempLista;
        System.out.println("-- Bubble sort --");
        System.out.println("Datos basados en 10 ejecuciones");
        System.out.println("                             Tiempo             Comparaciones     Swaps       accesos");
        int time = 0;
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaAle);
            tInicio = System.nanoTime();
            bubbleSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos aleatorios           " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "      " + accesos);
        time = 0;
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaOrd);
            tInicio = System.nanoTime();
            bubbleSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos ordenados            " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "           " + accesos);
        time = 0;
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaInvOrd);
            tInicio = System.nanoTime();
            bubbleSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos invers. ordenados    " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "      " + accesos);
        time = 0;
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaIgual);
            tInicio = System.nanoTime();
            bubbleSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos iguales              " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "           " + accesos);
        
        System.out.println();
        
        System.out.println("-- Selection sort --");
        System.out.println("Datos basados en 10 ejecuciones");
        System.out.println("                             Tiempo             Comparaciones     Swaps       accesos");
        time = 0;
        
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaAle);
            tInicio = System.nanoTime();
            selectionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos aleatorios           " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "         " + accesos);
        time = 0;
        
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaOrd);
            tInicio = System.nanoTime();
            selectionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos ordenados            " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "           " + accesos);
        time = 0;
        
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaInvOrd);
            tInicio = System.nanoTime();
            selectionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos invers. ordenados    " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "         " + accesos);
        time = 0;
        
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaIgual);
            tInicio = System.nanoTime();
            selectionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos iguales              " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "           " + accesos);
        
        System.out.println();
        
        System.out.println("-- Insertion sort --");
        System.out.println("Datos basados en 10 ejecuciones");
        System.out.println("                             Tiempo             Comparaciones     Swaps       accesos");
        time = 0;
        
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaAle);
            tInicio = System.nanoTime();
            insertionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos aleatorios           " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "      " + accesos);
        
        time = 0;
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaOrd);
            tInicio = System.nanoTime();
            insertionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos ordenados            " + df.format(tTranscurrido) + " ms    " + comparaciones + "              " + swaps + "           " + accesos);
        
        time = 0;
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaInvOrd);
            tInicio = System.nanoTime();
            insertionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos invers. ordenados    " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "      " + accesos);
        
        time = 0;
        for (int k = 0; k < 10; k++) {
            comparaciones = 0;
            swaps = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaIgual);
            tInicio = System.nanoTime();
            insertionSort(tempLista);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos iguales              " + df.format(tTranscurrido) + " ms    " + comparaciones + "              " + swaps + "           " + accesos);
        
        System.out.println();
        
        System.out.println("-- Quick sort --");
        System.out.println("Datos basados en 10 ejecuciones");
        System.out.println("                             Tiempo             Comparaciones     Swaps       accesos");
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            swaps = 0;
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaAle);
            tInicio = System.nanoTime();
            quickSort(tempLista, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos aleatorios           " + df.format(tTranscurrido) + " ms    " + comparaciones + "             " + swaps + "        " + accesos);
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            swaps = 0;
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaOrd);
            tInicio = System.nanoTime();
            quickSort(tempLista, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos ordenados            " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "      " + accesos);
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            swaps = 0;
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaInvOrd);
            tInicio = System.nanoTime();
            quickSort(tempLista, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos invers. ordenados    " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "      " + accesos);
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            swaps = 0;
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaIgual);
            tInicio = System.nanoTime();
            quickSort(tempLista, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos iguales              " + df.format(tTranscurrido) + " ms    " + comparaciones + "            " + swaps + "           " + accesos);
        System.out.println();
        
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            temp.add(0);
        }
        
        System.out.println("-- Merge sort --");
        System.out.println("Datos basados en 10 ejecuciones");
        System.out.println("                             Tiempo             Comparaciones       accesos");
        List<Integer> listaApoyo;
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaAle);
            listaApoyo = new ArrayList<>(temp);
            tInicio = System.nanoTime();
            mergeSort(tempLista, listaApoyo, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos aleatorios           " + df.format(tTranscurrido) + " ms    " + comparaciones + "                " + accesos);
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaOrd);
            listaApoyo = new ArrayList<>(temp);
            tInicio = System.nanoTime();
            mergeSort(tempLista, listaApoyo, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos ordenados            " + df.format(tTranscurrido) + " ms    " + comparaciones + "                " + accesos);
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaInvOrd);
            listaApoyo = new ArrayList<>(temp);
            tInicio = System.nanoTime();
            mergeSort(tempLista, listaApoyo, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos invers. ordenados    " + df.format(tTranscurrido) + " ms    " + comparaciones + "                " + accesos);
        
        time = 0;
        for (int i = 0; i < 10; i++) {
            comparaciones = 0;
            accesos = 0;
            tempLista = new ArrayList<>(listaIgual);
            listaApoyo = new ArrayList<>(temp);
            tInicio = System.nanoTime();
            mergeSort(tempLista, listaApoyo, 0, 999);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 7);
        System.out.println("- datos iguales              " + df.format(tTranscurrido) + " ms    " + comparaciones + "                " + accesos);
        System.out.println();
        
        int finNum = listaAle.get(999);
        int midNum = listaAle.get(499);
        int prinNum = listaAle.get(0);
        int notNum = 30000;
        System.out.println("Datos basados en 10000 ejecuciones");
        System.out.println("-- Sequential search --");
        System.out.println("                             Tiempos");
        System.out.println("- datos aleatorios -");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaAle, finNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al final                   " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaAle, prinNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al principio               " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaAle, midNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- a mitad                    " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaAle, notNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- no existente               " + df.format(tTranscurrido) + " ms");
        
        finNum = listaOrd.get(999);
        prinNum = listaOrd.get(0);
        midNum = listaOrd.get(499);
        
        System.out.println("- datos ordenados -");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaOrd, finNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al final                   " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaOrd, prinNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al principio               " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaOrd, midNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- a mitad                    " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaOrd, notNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- no existente               " + df.format(tTranscurrido) + " ms");
        
        finNum = listaInvOrd.get(999);
        midNum = listaInvOrd.get(499);
        prinNum = listaInvOrd.get(0);
        
        System.out.println();
        System.out.println("- datos inversamente ordenados -");
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaInvOrd, finNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al final                   " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaInvOrd, prinNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al principio               " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaInvOrd, midNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- a mitad                    " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaInvOrd, notNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- no existente               " + df.format(tTranscurrido) + " ms");
        
        prinNum = listaIgual.get(999);
        
        System.out.println();
        System.out.println("- datos iguales -");
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaIgual, prinNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- existente                  " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            sequentialSearch(listaIgual, notNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- no existente               " + df.format(tTranscurrido) + " ms");
        
        prinNum = listaOrd.get(0);
        finNum = listaOrd.get(999);
        midNum = listaOrd.get(499);
        
        System.out.println();
        System.out.println("Datos basados en 10000 ejecuciones");
        System.out.println("-- Binary search (Sólo para arrays ordenados o arrays con el mismo numero en todas sus posiciones) --");
        System.out.println("                             Tiempos");
        
        System.out.println("- datos ordenados o inversamente ordenados -");
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            binarySearch(listaOrd, finNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al final                   " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            binarySearch(listaOrd, prinNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- al principio               " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            binarySearch(listaOrd, midNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- a mitad                    " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            binarySearch(listaOrd, notNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- no existente               " + df.format(tTranscurrido) + " ms");
        
        System.out.println();
        System.out.println("- datos iguales -");
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            binarySearch(listaIgual, prinNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- existente                  " + df.format(tTranscurrido) + " ms");
        
        time = 0;
        for (int i = 0; i < 10000; i++) {
            tInicio = System.nanoTime();
            binarySearch(listaIgual, notNum);
            tFin = System.nanoTime();
            time += tFin - tInicio;
        }
        tTranscurrido = time / Math.pow(10, 10);
        System.out.println("- no existente               " + df.format(tTranscurrido) + " ms");
        
    }
    
    public void RunTests() {
        int[] array = new int[] { 10, 25, 2, 0, 1241, 4};
        List<Integer> list1 = new ArrayList<>() ;
        List<Integer> list2 = new ArrayList<>() ;
        List<Integer> list3 = new ArrayList<>() ;
        List<Integer> list4 = new ArrayList<>() ;
        List<Integer> list5 = new ArrayList<>() ;
        List<Integer> tempList = new ArrayList<>();
        boolean notValid;
        for (int i = 0; i < array.length; i++) {
            list1.add(array[i]);
            list2.add(array[i]);
            list3.add(array[i]);
            list4.add(array[i]);
            list5.add(array[i]);
            tempList.add(array[i]);
        }
        System.out.println("Tests");
        System.out.println("-- Antes de ordenar --");
        System.out.print("- ArrayList 1:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(" " + list1.get(i));
        }
        System.out.println();
        System.out.print("- ArrayList 2:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(" " + list2.get(i));
        }
        System.out.println();
        System.out.print("- ArrayList 3:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(" " + list3.get(i));
        }
        System.out.println();
        System.out.print("- ArrayList 4:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(" " + list4.get(i));
        }
        System.out.println();
        System.out.print("- ArrayList 5:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(" " + list5.get(i));
        }
        System.out.println();
        System.out.println();
        
        bubbleSort(list1);
        selectionSort(list2);
        insertionSort(list3);
        quickSort(list4, 0, list4.size() - 1);
        mergeSort(list5, tempList, 0, list5.size() - 1);
        
        System.out.println("-- Despues de ordenar --");
        System.out.print("- ArrayList 1 Bubble sort:   ");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(" " + list1.get(i));
        }
        // Comprobar que se ha ordenado bien
        notValid = false;
        for (int i = 0; i < array.length - 1 && !notValid; i++) {
            if (list1.get(i) > list1.get(i + 1)) {
                notValid = true;
            }
        }
        if (notValid)
            System.out.println((char)27 + "[37;31m Failed!" + (char)27 + "[0m");
        else
            System.out.println((char)27 + "[37;32m Success!" + (char)27 + "[0m");
        
        System.out.println();
        System.out.print("- ArrayList 2 Selection sort:");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(" " + list2.get(i));
        }
        // Comprobar que se ha ordenado bien
        notValid = false;
        for (int i = 0; i < array.length - 1 && !notValid; i++) {
            if (list2.get(i) > list2.get(i + 1)) {
                notValid = true;
            }
        }
        if (notValid)
            System.out.println((char)27 + "[37;31m Failed!" + (char)27 + "[0m");
        else
            System.out.println((char)27 + "[37;32m Success!" + (char)27 + "[0m");
        
        System.out.println();
        System.out.print("- ArrayList 3 Insertion sort:");
        for (int i = 0; i < list3.size(); i++) {
            System.out.print(" " + list3.get(i));
        }
        // Comprobar que se ha ordenado bien
        notValid = false;
        for (int i = 0; i < array.length - 1 && !notValid; i++) {
            if (list3.get(i) > list3.get(i + 1)) {
                notValid = true;
            }
        }
        if (notValid)
            System.out.println((char)27 + "[37;31m Failed!" + (char)27 + "[0m");
        else
            System.out.println((char)27 + "[37;32m Success!" + (char)27 + "[0m");
        
        System.out.println();
        System.out.print("- ArrayList 4 Quick sort:    ");
        for (int i = 0; i < list4.size(); i++) {
            System.out.print(" " + list4.get(i));
        }
        // Comprobar que se ha ordenado bien
        notValid = false;
        for (int i = 0; i < array.length - 1 && !notValid; i++) {
            if (list4.get(i) > list4.get(i + 1)) {
                notValid = true;
            }
        }
        if (notValid)
            System.out.println((char)27 + "[37;31m Failed!" + (char)27 + "[0m");
        else
            System.out.println((char)27 + "[37;32m Success!" + (char)27 + "[0m");
        
        System.out.println();
        System.out.print("- ArrayList 5 Merge sort:    ");
        for (int i = 0; i < list5.size(); i++) {
            System.out.print(" " + list5.get(i));
        }
        // Comprobar que se ha ordenado bien
        notValid = false;
        for (int i = 0; i < array.length - 1 && !notValid; i++) {
            if (list5.get(i) > list5.get(i + 1)) {
                notValid = true;
            }
        }
        if (notValid)
            System.out.println((char)27 + "[37;31m Failed!" + (char)27 + "[0m");
        else
            System.out.println((char)27 + "[37;32m Success!" + (char)27 + "[0m");
        
        System.out.println();
        
        System.out.println();
        int num = list1.get(5);
        System.out.println("Búsqueda secuencial en posición 5 del array, valor: " + num);
        if (sequentialSearch(list1, num)) {
            System.out.println((char)27 + "[37;32mEncontrado!" + (char)27 + "[0m");
        }
        else
            System.out.println((char)27 + "[37;31mNo encontrado" + (char)27 + "[0m");
        System.out.println();
        num = 12;
        System.out.println("Búsqueda secuencial con valor no existente en el array, valor: " + num);
        if (sequentialSearch(list1, num)) {
            System.out.println((char)27 + "[37;32mEncontrado!" + (char)27 + "[0m");
        }
        else
            System.out.println((char)27 + "[37;31mNo encontrado" + (char)27 + "[0m");
        
        System.out.println();
        num = list1.get(5);
        System.out.println("Búsqueda binaria en posición 5 del array, valor " + num);
        if (sequentialSearch(list1, num)) {
            System.out.println((char)27 + "[37;32mEncontrado!" + (char)27 + "[0m");
        }
        else
            System.out.println((char)27 + "[37;31mNo encontrado" + (char)27 + "[0m");
        System.out.println();
        num = 12;
        System.out.println("Búsqueda secuencial con valor no existente en el array, valor: " + num);
        if (sequentialSearch(list1, num)) {
            System.out.println((char)27 + "[37;32mEncontrado!" + (char)27 + "[0m");
        }
        else
            System.out.println((char)27 + "[37;31mNo encontrado" + (char)27 + "[0m");
    }
}
