package org.uphf.sae;

import java.util.Stack;

public class Pep {

    // NOTE :Traduction d'un algo par le chat, ne pas utiliser comme tel !!!
//test
    // Méthode pour effectuer le parcours en profondeur itératif à partir d'un sommet donné
    static void Pep (int[][] G, int s) {
        int numSommets = G.length;

        // Marquer tous les sommets comme non visités (par défaut)
        boolean[] marques = new boolean[numSommets];

        // Pile pour le parcours DFS
        Stack<Integer> pile = new Stack<>();

        // Empiler le sommet source
        pile.push(s);

        while (!pile.isEmpty()) {
            // Dépiler un sommet de la pile
            s = pile.pop();

            if (!marques[s]) {
                // Marquer et afficher le sommet
                marques[s] = true;
                System.out.print(s + " ");

                // Empiler tous les voisins non marqués du sommet dépilé
                for (int t = numSommets - 1; t >= 0; t--) {
                    if (G[s][t] == 1 && !marques[t]) {
                        pile.push(t);
                    }
                }
            }
        }
    }
}
