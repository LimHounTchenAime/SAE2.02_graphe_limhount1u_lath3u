public class Question21 {
    public static void main(String[] args) {
        //Cette classe permet de répondre à la question 21
        //Permettant de connaitre le nombre d'itération de chaque algoritheme pour le graphe_boucle.txt
        GrapheListe gl = new GrapheListe("graphes/graphe_boucle.txt");
        int nbIteration = gl.listeNoeuds().size();
        //Dijkstra
        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Dijkstra: ");
        for (int i = 0; i < nbIteration; i++) {
            Valeur dijkstra_iteration = dijkstra.resoudreNbIteration(gl, "A", i);
            System.out.println("Iteration " + i + " : ");
            System.out.println(dijkstra_iteration);
        }
        //BellmanFord
        BellmanFord bellmanFord = new BellmanFord();
        System.out.println("Bellman Ford:");
        for (int i = 0; i < nbIteration; i++) {
            Valeur bellmanFord_iteration = bellmanFord.resoudreNbIteration(gl,"A",i);
            System.out.println("Iteration " + i + " : ");
            System.out.println(bellmanFord_iteration);
        }

    }
}
