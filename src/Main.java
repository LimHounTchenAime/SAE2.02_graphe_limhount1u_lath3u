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

        System.out.println(gl);

        BellmanFord bellmanFord=new BellmanFord();

        System.out.println(bellmanFord.resoudre(gl, "A"));
    }
}
