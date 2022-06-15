public class test {
    public static void main(String[] args) {
        GrapheListe grapheListe=GrapheListe.genererGraphe(10);
        System.out.println(grapheListe.toGraphviz());
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
