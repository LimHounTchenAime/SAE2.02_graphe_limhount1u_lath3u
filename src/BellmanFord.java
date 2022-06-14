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
                String sommet_u = g.listeNoeuds().get(i);
                //pour chaque arc du sommet_u
                for (int k = 0; k < g.suivants(sommet_u).size(); k++) {
                    //sommet_v est un des sucesseurs du sommet_u
                    String sommet_v = g.suivants(sommet_u).get(k).getDest();
                    //on prend la valeur d'un des arcs partant de u
                    double cout_arc_uv = g.suivants(sommet_u).get(k).getCout();
                    //on prend la valeur de sommet_u(antécédent de sommet_v) + le coût de l'arc(u,v)
                    double tmp = v.getValeur(sommet_u) + cout_arc_uv;
                    //si la nouvelle distance est meilleur que la valeur du sommet_v
                    if (tmp < v.getValeur(sommet_v)) {
                        //on met la nouvelle valeur du sommet_v
                        v.setValeur(sommet_v, tmp);
                        //on met en parent le sommet_u
                        v.setParent(sommet_v, sommet_u);
                    }
                }
            }
            cpt++;
        }
        return v;
    }
}
