public class BellmanFord {


    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        //initiatlisation valeur
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            if (g.listeNoeuds().get(i) == depart) {
                v.setValeur(depart, 0);
            }
        }
        return v;
    }
}
