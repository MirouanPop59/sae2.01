package org.uphf.sae;

import java.util.LinkedList;
import java.util.Queue;

public class PEL {

    // NOTE :Traduction d'un algo par le chat, ne pas utiliser comme tel !!!

    static void PEL(int[][] G, int s) {
        int numSommets = G.length;

        // Marquer tous les sommets comme non visités (par défaut)
        boolean[] marqués = new boolean[numSommets];

        // File pour le parcours BFS
        Queue<Integer> file = new LinkedList<>();

        // Marquer le sommet source et l'enfiler
        marqués[s] = true;
        file.add(s);

        while (!file.isEmpty()) {
            // Défiler un sommet de la file et l'afficher
            s = file.poll();
            System.out.print(s + " ");

            // Vérifier tous les voisins du sommet défiler
            for (int t = 0; t < numSommets; t++) {
                if (G[s][t] == 1 && !marqués[t]) { // G[s][t] == 1 signifie qu'il y a une arête entre s et t
                    marqués[t] = true;
                    file.add(t);
                }
            }
        }
    }

   public static void main(String[] args) {
        // Représentation du graphe par une matrice d'adjacence 10x10
        int[][] G = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0,0 , 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Parcours en largeur à partir du sommet 2:");
        PEL(G, 2);
    }
}

