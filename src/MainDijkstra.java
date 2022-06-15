public class MainDijkstra {
    public static void main(String[] args) {
        Dijkstra dijkstra=new Dijkstra();
        GrapheListe grapheListe=new GrapheListe("graphes/test1.txt");
        Valeur cheminMinimum=dijkstra.resoudre(grapheListe, "A");
        System.out.println(cheminMinimum.calculerChemin("C"));
        System.out.println(cheminMinimum.calculerChemin("D"));
        System.out.println(cheminMinimum.calculerChemin("E"));
    }
}
