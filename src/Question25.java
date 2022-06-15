public class Question25 {
    public static void main(String[] args) {
        //genere des graphes de taille 10
        GrapheListe grapheListe = GrapheListe.genererGraphe(3000);

        //cherche le chemin minimum avec les deux algorithmes
        //On calcule la vitesse de Bellmandford
        Algorithme algorithme = new BellmanFord();
        long startTime = System.nanoTime();
        Valeur v = algorithme.resoudre(grapheListe, "n1");
        long endTime = System.nanoTime();
        long temps_BellmanFord = (endTime - startTime);
        System.out.println("BellmanFord : " + temps_BellmanFord);
        System.out.println(v);

        //On calcule la vitesse de Dijkstra
        algorithme = new Dijkstra();
        startTime = System.nanoTime();
        v = algorithme.resoudre(grapheListe, "n1");
        endTime = System.nanoTime();
        long temps_Dijkstra= (endTime - startTime);
        System.out.println("Dijkstra : " +  temps_Dijkstra);
        System.out.println(v);

        String fast;
        if(temps_Dijkstra>temps_BellmanFord){
            fast = "BellmanFord";
        }else {
            fast ="temps_Dijkstra";
        }
        System.out.println("Le plus rapide : " + fast);
    }
}
