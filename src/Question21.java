public class Question21 {
    public static void main(String[] args) {
    //Affiche le contenu de l’objet valeur après chaque itération de chacun des algorithmes.
        GrapheListe gl = new GrapheListe("graphes/graphe_boucle.txt");

        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Dijkstra: ");
        for (int i = 0; i < gl.listeNoeuds().size() ;i++) {
            Valeur dijkstra_iteration = dijkstra.resoudre(gl, "A");
            System.out.println("Iteration " + i + " : ");
            System.out.println(dijkstra_iteration);
        }

        BellmanFord bellmanFord = new BellmanFord();
        System.out.println("Bellman Ford:");
        for (int i = 0; i < gl.listeNoeuds().size(); i++) {
            Valeur bellmanFord_iteration = bellmanFord.resoudre(gl, "A");
            System.out.println("Iteration " + i + " : ");
            System.out.println(bellmanFord_iteration);
        }

    }
}
