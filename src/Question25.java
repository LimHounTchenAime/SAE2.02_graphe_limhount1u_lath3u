public class Question25 {
    public static void main(String[] args) {
        //genere des graphes de taille 10
        GrapheListe grapheListe= GrapheListe.genererGraphe(10);
        //Génére le graphe au format graphviz
        System.out.println(grapheListe.toGraphviz());

        //cherche le chemin minimum avec les deux algorithmes
        Algorithme algorithme=new BellmanFord();
        Valeur v=algorithme.resoudre(grapheListe, "n1");
        System.out.println(v);
        System.out.println(v.calculerChemin("n9"));

        algorithme=new Dijkstra();
        v=algorithme.resoudre(grapheListe, "n1");
        System.out.println(v);
        System.out.println(v.calculerChemin("n9"));
    }
}
