import java.util.ArrayList;

public class Dijkstra implements Algorithme {
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        ArrayList<String> Q = new ArrayList<String>();
        //initialisation
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            v.setParent(g.listeNoeuds().get(i), null);
            Q.add(g.listeNoeuds().get(i));
        }
        v.setValeur(depart, 0);
        //début
        //tant que ensemble non vide
        while (!Q.isEmpty()) {
            String sommet_u = rechercheMin(Q,v);
            Q.remove(sommet_u);
            //Pour chaque sommet_v de Q tel que l'arc(u,v) existe
            for(int i = 0; i < g.suivants(sommet_u).size();i++){
                String sommet_v = g.suivants(sommet_u).get(i).getDest();
                if(Q.contains(sommet_v)){
                    double poids_arc_uv = g.suivants(sommet_u).get(i).getCout();
                    Double D = v.getValeur(sommet_u) + poids_arc_uv;
                    if(D < v.getValeur(sommet_v)){
                        v.setValeur(sommet_v,D);
                        v.setParent(sommet_v,sommet_u);
                    }
                }
            }

        }

        return v;
    }


    /**
     *
     * @param liste
     * @param v
     * @return
     */
    public String rechercheMin(ArrayList<String> liste, Valeur v) {
        String min = liste.get(0);
        if (!liste.isEmpty()) {
            int indice = 0;
            while (indice < liste.size()) {
                if (v.getValeur(liste.get(indice)) < v.getValeur(min)) {
                    min = liste.get(indice);
                }
                indice++;
            }

        }
        return min;
    }
}
