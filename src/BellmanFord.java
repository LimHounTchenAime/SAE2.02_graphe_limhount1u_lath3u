public class BellmanFord {


    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        //initialisation
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
        }
        v.setValeur(depart, 0);

        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            //successeur du noeuds
            for (int k = 0; k < g.suivants(g.listeNoeuds().get(i)).size(); k++) {
                String u = g.listeNoeuds().get(i);
                String parent = v.getParent(u);
                double arc_uv = g.suivants(g.listeNoeuds().get(i)).get(k).getCout();
                double tmp = v.getValeur(u) + arc_uv;
                if (tmp < v.getValeur(parent)) {
                    v.setValeur(parent, tmp);
                    v.setParent(parent, u);
                }
            }
        }

        return v;
    }
}
