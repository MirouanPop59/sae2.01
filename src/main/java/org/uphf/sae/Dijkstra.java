package org.uphf.sae;
import static java.util.Collections.min;

public class Dijkstra {
    double posInf = Double.POSITIVE_INFINITY;
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

    public int index_minimum(int[] liste) {
        int mini = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < liste.length; i++) {
            if (liste[i] != 0 && liste[i] < mini) {
                mini = liste[i];
                index = i;
            }
        }
        return index;
    }

    public int[][] dijkstra(Secteur[][] leMonde, int depart) {
        int[][] matrice;
        int longueur = transi.length;
        for (int i = 0; i < longueur; i++) {
            for (int j = i + 1; j < longueur; j++) {
                if (leMonde[i][j].verifEau()) {
                    transi[i][j] = (int) posInf;
                }
                if (i==j) {
                    transi[i][j]=0;
                }
            }
        }
        int courant=depart;
        matrice=[leMonde[courant]];
        matrice[0][courant]=0;

        int[][] distances;
        for (int i = 0; i < longueur; i++) {
            distances[i] = new int[]{(int) posInf};
        }
        distances[courant]= new int[]{0};
        int index;
        for (int i = 1; i < longueur; i++) {
            index=index_minimum(leMonde[i-1]);
            for (int k = 0; k < longueur; k++) {
                if (index==k){
                    min(matrice[i - 1][index] + leMonde[index][k], matrice[i - 1][k]);
                }
            }
            courant=index;
            distances[courant] = new int[]{matrice[i - 1][courant]};

        }
    return distances;
    }
}

//
//    # À la différence de Dijkstra classique,
//# On ne cherche pas une destination, mais TOUTES
//
//
//def index_minimum(liste:list)->int:
//    # recherche de l'index de la première apparition du
//    #index_minimum non-nul dans la liste
//    mini=min([liste[i] if liste[i]!=0 else float('inf') \
//    for i in range(len(liste))])
//    return liste.index(mini)
//
//
//def printMatrix(mat):
//
//    for i in range(len(mat)):
//        print(mat[i]);
//
//
//
//
//
//A=[[0,0,20,2,0,0,4],
//   [0,0,4,1,1,0,0],
//   [0,4,0,0,3,1,0],
//   [2,1,0,0,5,1,1],
//   [0,1,3,5,0,1,2],
//   [0,0,1,1,1,0,4],
//   [4,0,0,1,2,4,0]];
//
//print(dijkstra(A,0))
