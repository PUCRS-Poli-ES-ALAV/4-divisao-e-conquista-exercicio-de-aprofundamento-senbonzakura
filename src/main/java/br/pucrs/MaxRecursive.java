package br.pucrs;

public class MaxRecursive {
    private int iteracoes;
    
    public MaxRecursive() {
        this.iteracoes++;
    }

    public int numIt() {
        return this.iteracoes;
    }

    public long maxVal(long a[]) {
        return maxVal(a, 0, a.length - 1);
    }
    private long maxVal(long A[], int init, int end) {
        if (end - init <= 1) {
            this.iteracoes++;
            return Math.max(A[init], A[end]);
        }
        this.iteracoes++;
        int m = (init + end) / 2;
        long v1 = maxVal(A, init, m);
        long v2 = maxVal(A, m + 1, end);
        return Math.max(v1,v2);
    }
}
