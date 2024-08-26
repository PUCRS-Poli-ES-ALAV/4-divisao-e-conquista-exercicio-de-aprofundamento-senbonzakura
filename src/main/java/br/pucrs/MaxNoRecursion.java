package br.pucrs;

public class MaxNoRecursion {
    private int iteracoes;

    public MaxNoRecursion() {
        this.iteracoes = 0;
    }

    public int numIt() {
        return this.iteracoes;
    }

    public long maxVal(long a[]) {
        return maxVal1(a, a.length);
    }

    private long maxVal1(long A[], int n) {
        long max = A[0];
        for (int i = 0; i < n; i++) {
            this.iteracoes++;
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
}
