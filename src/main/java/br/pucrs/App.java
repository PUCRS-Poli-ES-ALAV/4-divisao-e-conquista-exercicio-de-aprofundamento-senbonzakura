package br.pucrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final int tam = 1048576 / 2;
        System.out.println( "Hello World!" );
        List<Long> list = new ArrayList<>();
        for (long i : geraVetor(tam,tam)) {
            list.add(i);
        }
        execMerge(list);
        execMaxNoRec(geraVetor(tam, tam));
        execMaxRec(geraVetor(tam, tam));
        execBinMultiply(2, 6, 10);
    }

    public static void execBinMultiply(long a, long b, long bits) {
        long it = System.nanoTime();
        BinProduct alg = new BinProduct();
        alg.multiply(a, b, bits);
        System.out.printf("Algoritmo: binProd, Tempo de execução: %f, Iterações: %d\n", (System.nanoTime() - it) / 1e6, alg.numIt());
    }

    public static void execMaxRec(long arr[]) {
        long it = System.nanoTime();
        MaxRecursive alg = new MaxRecursive();
        alg.maxVal(arr);
        System.out.printf("Algoritmo: maxRecursive, Tempo de execução: %f, Iterações: %d\n", (System.nanoTime() - it) / 1e6, alg.numIt());
    }

    public static void execMaxNoRec(long arr[]) {
        long it = System.nanoTime();
        MaxNoRecursion alg = new MaxNoRecursion();
        alg.maxVal(arr);
        System.out.printf("Algoritmo: maxNoRecursion, Tempo de execução: %f, Iterações: %d\n", (System.nanoTime() - it) / 1e6, alg.numIt());
    }

    public static void execMerge(List<Long> list) {
        long it = System.nanoTime();
        MergeSortF alg = new MergeSortF();
 *        alg.sort(list, 0, list.size());
        System.out.printf("Algoritmo: mergeSortF, Tempo de execução: %f, Iterações: %d\n", (System.nanoTime() - it) / 1e6, alg.numIt());
    }

    private static long[] geraVetor(int nroPares, int nroImpares){
        long [] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                (nroPares + nroImpares > 0)) {

            res = new long[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98)+1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar+contImpar] = novoNum;
                    contPar++;
                }
                else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar+contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }
}
