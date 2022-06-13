import java.util.List;

public class BellmanFord {


    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        //initialisation
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            v.setParent(g.listeNoeuds().get(i),null);
        }
        v.setValeur(depart, 0);

        List<String> sommets = g.listeNoeuds();
        for (int i = 0; i < sommets.size(); i++) {
            //successeur du noeuds
            for (int k = 0; k < g.suivants(sommets.get(i)).size(); k++) {
                String u_sommet = g.listeNoeuds().get(i);
                String v_sommet = g.suivants(sommets.get(i)).get(k).getDest();
                double arc_uv = g.suivants(g.listeNoeuds().get(i)).get(k).getCout();
                double tmp = v.getValeur(u_sommet) + arc_uv;
                    if (tmp < v.getValeur(v_sommet)) {
                        v.setValeur(v_sommet, tmp);
                        v.setParent(v_sommet, u_sommet);
                    }

            }
        }

        return v;
    }
}
