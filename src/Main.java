public class Main {
    public static void main(String[] args) {


        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("B", "E", 11);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("E", "D", 43);

        System.out.println(gl.suivants("D").get(0).getDest());
        System.out.println(gl.toGraphviz());
        GrapheListe grapheListe = new GrapheListe("graphes/graphe_exemple1.txt");
        System.out.println(grapheListe.toString());
        Dijkstra dijkstra = new Dijkstra();
        Valeur v = dijkstra.resoudre(gl, "A");
        System.out.println(v.toString());
        System.out.println(v.calculerChemin("C"));



    }
}
