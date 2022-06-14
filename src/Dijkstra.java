import java.util.ArrayList;

public class Dijkstra implements Algorithme {
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        ArrayList<String> Q = new ArrayList<String>();

        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            v.setParent(g.listeNoeuds().get(i), null);
            Q.add(g.listeNoeuds().get(i));
        }
        v.setValeur(depart, 0);

        //tant que ensemble non vide
        while (!Q.isEmpty()) {
            for (int j = 0; j < 5; j++) {
                String sommet_u = depart;
                double tmpPoids = Double.MAX_VALUE;
                //recherche distance minimale
                for (int i = 0; i < g.suivants(sommet_u).size(); i++) {
                    if (g.suivants(sommet_u).get(i).getCout() < tmpPoids) {
                        sommet_u = g.listeNoeuds().get(i);
                        tmpPoids = g.suivants(depart).get(i).getCout();
                    }
                }
                Q.remove(sommet_u);
                for (int i=0;i<)
            }

        }

        return v;
    }
}
