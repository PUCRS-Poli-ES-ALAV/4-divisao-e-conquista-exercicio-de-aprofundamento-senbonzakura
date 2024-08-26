package br.pucrs;

import java.util.ArrayList;
import java.util.List;

public class MergeSortS {
    private int iteracoes;

    public MergeSortS() {
        this.iteracoes = 0;
    }

    public int numIt() {
        return this.iteracoes;
    }

    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.size() == 1) {
            return list;
        }
        this.iteracoes++;
        List<List<T>> split = split(list);
        List<T> a = split.get(0);
        List<T> b = split.get(1);
        a = sort(a);
        b = sort(b);
        List<T> l = merge(a, b);
        return l;
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

    private <T> List<List<T>> split(List<T> list) {
        ArrayList<T> a = new ArrayList<>();
        ArrayList<T> b = new ArrayList<>();
        for (int i = 0; i < list.size() / 2; i++) {
            this.iteracoes++;
            a.add(list.get(i));
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            this.iteracoes++;
            b.add(list.get(i));
        }
        ArrayList<List<T>> split = new ArrayList<>();
        split.add(a);
        split.add(b);
        return split;
    }
}
