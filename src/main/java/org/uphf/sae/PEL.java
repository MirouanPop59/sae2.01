package org.uphf.sae;

import java.util.LinkedList;
import java.util.Queue;

public class Pel {

    // NOTE :Traduction d'un algo par le chat, ne pas utiliser comme tel !!!
//test
    static void Pel (int[][] G, int s) {
        int numSommets = G.length;

        // Marquer tous les sommets comme non visités (par défaut)
        boolean[] marques = new boolean[numSommets];

        // File pour le parcours BFS
        Queue<Integer> file = new LinkedList<>();

        // Marquer le sommet source et l'enfiler
        marques[s] = true;
        file.add(s);

        while (!file.isEmpty()) {
            // Défiler un sommet de la file et l'afficher
            s = file.poll();
            System.out.print(s + " ");

            // Vérifier tous les voisins du sommet défiler
            for (int t = 0; t < numSommets; t++) {
                if (G[s][t] == 1 && !marques[t]) { // G[s][t] == 1 signifie qu'il y a une arête entre s et t
                    marques[t] = true;
                    file.add(t);
                }
            }
        }
    }
}

