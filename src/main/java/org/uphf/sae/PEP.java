package org.uphf.sae;

import java.util.Stack;

public class PEP {

    // NOTE :Traduction d'un algo par le chat, ne pas utiliser comme tel !!!

    // Méthode pour effectuer le parcours en profondeur itératif à partir d'un sommet donné
    static void PEP(int[][] G, int s) {
        int numSommets = G.length;

        // Marquer tous les sommets comme non visités (par défaut)
        boolean[] marqués = new boolean[numSommets];

        // Pile pour le parcours DFS
        Stack<Integer> pile = new Stack<>();

        // Empiler le sommet source
        pile.push(s);

        while (!pile.isEmpty()) {
            // Dépiler un sommet de la pile
            s = pile.pop();

            if (!marqués[s]) {
                // Marquer et afficher le sommet
                marqués[s] = true;
                System.out.print(s + " ");

                // Empiler tous les voisins non marqués du sommet dépilé
                for (int t = numSommets - 1; t >= 0; t--) {
                    if (G[s][t] == 1 && !marqués[t]) {
                        pile.push(t);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Représentation du graphe par une matrice d'adjacence 10x10
        int[][] G = {
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 1, 1, 0}
        };

        System.out.println("Parcours en profondeur à partir du sommet 2:");
        PEP(G, 2);
    }
}
