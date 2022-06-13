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
        //début
        List<String> sommets = g.listeNoeuds();
        String vtmp = null;
        //tant que non point fixe
        int cpt = 0;
        while (!v.toString().equals(vtmp) && cpt < sommets.size()) {
            vtmp = v.toString();
            //pour chaque sommet
            for (int i = 0; i < sommets.size(); i++) {
                String u_sommet = g.listeNoeuds().get(i);
                //pour chaque arc du sommet u
                for (int k = 0; k < g.suivants(u_sommet).size(); k++) {
                    //v_sommet est un des parents de u_sommet
                    String v_sommet = g.suivants(u_sommet).get(k).getDest();
                    //arc(u,v)
                    double arc_uv = g.suivants(u_sommet).get(k).getCout();
                    double tmp = v.getValeur(u_sommet) + arc_uv;
                    //si la nouvelle distance est meilleur que la valeur de v_sommet
                    if (tmp < v.getValeur(v_sommet)) {
                        v.setValeur(v_sommet, tmp);
                        v.setParent(v_sommet, u_sommet);
                    }
                }
            }
            cpt++;
        }
        return v;
    }
}
