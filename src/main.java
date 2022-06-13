public class main {
    public static void main(String[] args) {


        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("B", "E", 11);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("E", "D", 43);

        System.out.println(gl.toGraphviz());

        GrapheListe grapheListe=new GrapheListe("graphes/test1.txt");
        System.out.println(grapheListe.toGraphviz());
        System.out.println(grapheListe.toString());
    }
}
