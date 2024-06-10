package org.uphf.sae;

public class Dijkstra {
    int[][] transi = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    public double[] dijkstra(int depart) {
        int longueur = transi.length;
        int[][] matrice = new int[longueur][transi[0].length];
        int posInf = (int) Double.POSITIVE_INFINITY;
        for (int i = 0; i < longueur; i++) {
            for (int j = i + 1; j < longueur; j++) {
                if (transi[i][j] == 0) {
                    transi[i][j] = posInf;
                }
                if (i == j) {
                    transi[i][j] = 0;
                }
            }
        }

        int courant = depart;
        System.arraycopy(transi[courant], 0, matrice[0], 0, transi[courant].length);
        matrice[0][courant] = 0;

        double[] distances = new double[longueur];
        for (int i = 0; i < longueur; i++) {
            distances[i] = Double.POSITIVE_INFINITY;
        }

        distances[courant] = 0;
        int index;
        for (int i = 1; i < longueur; i++) {
            index = index_minimum(matrice[i - 1]);
            for (int k = 0; k < longueur; k++) {
                if (index == k) {
                    matrice[i][k] += Math.min(matrice[i - 1][index] + transi[index][k], matrice[i - 1][k]);
                }
            }
            courant = index;
            distances[courant] = matrice[i - 1][courant];
        }
        return distances;
    }


    private int index_minimum (int[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
