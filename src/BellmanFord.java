import java.util.List;

public class BellmanFord implements Algorithme{

    /**
     * Méthode appliquant l'algorithme de BellmanFord sur un graphe à partir d'un point de départ
     * @param g graphe
     * @param depart point de départ
     * @return retourne un objet Valeur contenant les valeurs de chaque point selon l'algorithme de BellmanFord
     */
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();

        //initialisation
        //pour chaque sommet v de G faire
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE); //v.distance <- infini
            v.setParent(g.listeNoeuds().get(i), null); //v.précédent <- indéfini
        }
        v.setValeur(depart, 0);//depart.distance <- 0

        //début
        List<String> sommets = g.listeNoeuds();
        String vtmp = null;
        int cpt = 0;
        //tant que non egal(v, vtmp) et cpt<nbSommets faire
        while (!v.toString().equals(vtmp) && cpt < sommets.size()) {
            //   vtmp <- v.toString()
            vtmp = v.toString();
            //pour chaque sommet v de G faire
            for (int i = 0; i < sommets.size(); i++) {
                String sommet_u = g.listeNoeuds().get(i);

                //pour chaque arc (u, v) de G faire
                for (int k = 0; k < g.suivants(sommet_u).size(); k++) {

                    //sommet_u est un antécédent de sommet_v
                    String sommet_v = g.suivants(sommet_u).get(k).getDest(); //on a récupéré l'arc(u,v)


                    //on prend la valeur d'un des arcs partant de u
                    double cout_arc_uv = g.suivants(sommet_u).get(k).getCout();
                    //tmp <- u.distance + poids(u, v)
                    double tmp = v.getValeur(sommet_u) + cout_arc_uv;
                    // si tmp < v.distance alors
                    if (tmp < v.getValeur(sommet_v)) {
                        // v.distance <- tmp
                        v.setValeur(sommet_v, tmp);
                        // v.précédent <- u
                        v.setParent(sommet_v, sommet_u);
                    }
                }
            }
            cpt++;
        }
        return v;
    }

    /**
     * Methode permettant d'appliquer l'algorithme BellmanFord avec un nombre d'iteration
     * @param g
     * @param depart
     * @param nbIteration
     * @return
     */
    public Valeur resoudreNbIteration(Graphe g, String depart, int nbIteration) {
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

        while (!v.toString().equals(vtmp) && cpt < nbIteration) {
            vtmp = v.toString();
            //pour chaque sommet
            for (int i = 0; i < sommets.size(); i++) {

                String sommet_u = g.listeNoeuds().get(i);

                //pour chaque arc du sommet_u
                for (int k = 0; k < g.suivants(sommet_u).size(); k++) {

                    //sommet_u est un antécédent de sommet_v
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
