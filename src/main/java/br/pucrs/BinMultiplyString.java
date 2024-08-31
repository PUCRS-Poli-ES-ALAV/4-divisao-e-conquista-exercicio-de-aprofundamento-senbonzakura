package br.pucrs;

public class BinMultiplyString {
    private int iteracoes;

    public BinMultiplyString() {
        this.iteracoes = 0;
    }

    public int numIt() {
        return this.iteracoes;
    }

    public long powof2(long pow) {
        return pow == 0 ? 1 : 2 << (pow - 1);
    }

    public long multiply(String x, String y) {
        return multiplyR(x, y, 0, x.length(), 0, y.length());
    }

    private long multiplyR(String a, String b, int loA, int hiA, int loB, int hiB) {
        if (hiA - loA > 1 && hiB - loB > 1) {
            iteracoes++;
            int n = hiA - loA;
            int midA = (hiA + loA) / 2;
            int midB = (hiB + loB) / 2;
            return (2 << n - 1) * multiplyR(a, b, loA, midA, loB, midB) + (2 << (n / 2 - 1)) * (multiplyR(a, b, loA, midA, midB, hiB) + multiplyR(a, b, midA, hiA, loB, midB)) + multiplyR(a, b, midA, hiA, midB, hiB);
        } else {
            iteracoes++;
            return Long.valueOf(a.charAt(loA) - '0') * Long.valueOf(b.charAt(loB) - '0');
        }
    }
}