public class Dijkstra implements Algorithme {
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();

        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            v.setParent(g.listeNoeuds().get(i), null);
        }
        v.setValeur(depart, 0);

        //tant que ensemble non vide
        for(int j=0;j<5;j++) {
            String sommet_u=depart;
            double tmpPoids=Double.MAX_VALUE;
            //recherche distance minimale
            for (int i=0;i<g.suivants(sommet_u).size();i++){
                if(g.suivants(sommet_u).get(i).getCout()<tmpPoids) {
                    sommet_u = g.listeNoeuds().get(i);
                    tmpPoids=g.suivants(depart).get(i).getCout();

                    double tmp = v.getValeur(sommet_u) + tmpPoids;

                }
            }

            for(int i=0;i<g.listeNoeuds().size();i++){
                //pour chaque arc du sommet_u
                for (int k = 0; k < g.suivants(sommet_u).size(); k++) {
                    //sommet_v est un des sucesseurs du sommet_u
                    String sommet_v = g.suivants(sommet_u).get(k).getDest();
                    //on prend la valeur de sommet_u(antécédent de sommet_v) + le coût de l'arc(u,v)
                    double tmp = v.getValeur(sommet_u) + tmpPoids;
                    //si la nouvelle distance est meilleur que la valeur du sommet_v
                    if (tmp < v.getValeur(sommet_v)) {
                        //on met la nouvelle valeur du sommet_v
                        v.setValeur(sommet_v, tmp);
                        //on met en parent le sommet_u
                        v.setParent(sommet_v, sommet_u);
                    }
                }
            }
        }

        return v;
    }
}
