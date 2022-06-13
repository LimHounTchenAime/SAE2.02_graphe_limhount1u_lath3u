import java.util.List;

public class BellmanFord {


    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();

        //initialisation
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            v.setParent(g.listeNoeuds().get(i), null);
        }
        v.setValeur(depart, 0);

        List<String> sommets = g.listeNoeuds();
        //pour chaque sommets
        for (int j = 0 ; j< sommets.size();j++) {
            //pour chaque arcs
            for (int i = 0; i < sommets.size(); i++) {
                String u_sommet = g.listeNoeuds().get(i);
                for (int k = 0; k < g.suivants(u_sommet).size(); k++) {
                    //v_sommet est un des parents de u_sommet
                    String v_sommet = g.suivants(u_sommet).get(k).getDest();
                    //arc(u,v)
                    double arc_uv = g.suivants(u_sommet).get(k).getCout();
                    double tmp = v.getValeur(u_sommet) + arc_uv;
                    if (tmp < v.getValeur(v_sommet)) {
                        v.setValeur(v_sommet, tmp);
                        v.setParent(v_sommet, u_sommet);
                    }
                }
            }
        }
        return v;
    }
}
