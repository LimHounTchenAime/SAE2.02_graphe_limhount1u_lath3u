import java.io.IOException;

public class Question30 {
    public static void main(String[] args) throws IOException {
        Labyrinthe labyrinthe=new Labyrinthe("labySimple/labytest.txt");
        Graphe graphe=labyrinthe.genererGraphe();

        Algorithme algorithme=new BellmanFord();
        Valeur v=algorithme.resoudre(graphe, "(0, 0)");
        System.out.println(v.calculerChemin("(4, 0)"));

        algorithme=new Dijkstra();
        v=algorithme.resoudre(graphe, "(0, 0)");
        System.out.println(v.calculerChemin("(4, 0)"));
    }
}
