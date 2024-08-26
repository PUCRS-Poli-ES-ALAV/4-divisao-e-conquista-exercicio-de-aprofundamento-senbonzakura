package br.pucrs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeSortF {
    private int iteracoes;
    
    public MergeSortF() {
        this.iteracoes = 0;    
    }

    public int numIt() {
        return this.iteracoes;
    }

    public <T extends Comparable<T>> void sort(List<T> list, int lo, int hi) {
        if (hi - lo <= 1) {
            return;
        }
        this.iteracoes++;
        int mid = (lo + hi) / 2;
        sort(list, lo, mid);
        sort(list, mid, hi);
        List<T> A = new ArrayList<>(lo + mid);
        List<T> B = new ArrayList<>(mid + hi);
        for (int i = lo; i < mid; i++) {
            this.iteracoes++;
            A.add(list.get(i));
        }
        for (int i = mid; i < hi; i++) {
            this.iteracoes++;
            B.add(list.get(i));
        }
        List<T> C = merge(A, B);
        Iterator<T> it = C.iterator();
        for (int i = lo; i < hi; i++) {
            this.iteracoes++;
            list.set(i, it.next());
        }
    }

    private <T extends Comparable<T>> List<T> merge(List<T> a, List<T> b) {
        List<T> newlist = new ArrayList<>(a.size() + b.size());
        int aIdx = 0, bIdx = 0;
        while (aIdx < a.size() && bIdx < b.size()) {
            this.iteracoes++;
            T aEl = a.get(aIdx);
            T bEl = b.get(bIdx);
            if (aEl.compareTo(bEl) < 0) {
                newlist.add(aEl);
                aIdx++;
            } else {
                newlist.add(bEl);
                bIdx++;
            }
        }
        while (aIdx < a.size()) {
            this.iteracoes++;
            newlist.add(a.get(aIdx));
            aIdx++;
        }
        while (bIdx < b.size()) {
            this.iteracoes++;
            newlist.add(b.get(bIdx));
            bIdx++;
        }
        return newlist;
    }
}
