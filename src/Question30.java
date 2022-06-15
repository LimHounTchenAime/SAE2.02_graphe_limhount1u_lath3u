import java.io.IOException;

public class Question30 {
    public static void main(String[] args) throws IOException {
        //labyrinthe utilise
        Labyrinthe labyrinthe=new Labyrinthe("labySimple/labytest.txt");

        //creation du graphe a l'aide de la methode genererGraphe
        Graphe graphe=labyrinthe.genererGraphe();

        //algoritme utilise Bellman-Ford
        Algorithme algorithme=new BellmanFord();

        //entree du labyrinthe
        Valeur v=algorithme.resoudre(graphe, "(0, 0)");
        //sortie du labyrinthe
        System.out.println(v.calculerChemin("(4, 0)"));

        //algorithme utilise Dijkstra
        algorithme=new Dijkstra();
        v=algorithme.resoudre(graphe, "(0, 0)");
        System.out.println(v.calculerChemin("(4, 0)"));
    }
}
