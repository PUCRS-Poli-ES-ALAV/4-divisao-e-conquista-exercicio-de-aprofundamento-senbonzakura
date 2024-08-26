package br.pucrs;

public class BinProduct {
    private int iteracoes;

    public BinProduct() {
        this.iteracoes = 0;
    }

    public int numIt() {
        return this.iteracoes;
    }

    public long powof2(long pow) {
        return pow == 0 ? 1 : 2 << (pow - 1);
    }

    public long multiply(long x, long y, long n) {
        if (n == 1) {
            this.iteracoes++;
            return x * y;
        }
        this.iteracoes++;
        long m = n >> 1;
        long aux = powof2(m);
        
        long a = x / aux;
        long b = x % aux;

        long c = y / aux;
        long d = y % aux;

        long e = multiply(a, c, m);
        long f = multiply(b, d, m);
        long g = multiply(b, c, m);
        long h = multiply(a, d, m);
        return powof2(m << 1)*e + powof2(m)*(g + h) + f;
    }
}
