public class Dijkstra {
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();

        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            v.setParent(g.listeNoeuds().get(i), null);
        }
        v.setValeur(depart, 0);

        //tant que ensemble non vide
        while () {
            String u_sommet;
            //recherche distance minimale
            for (int i=0;i<g.suivants(depart).size();i++){
                u_sommet = g.listeNoeuds().get(i);
            }
        }

        return v;
    }
}
