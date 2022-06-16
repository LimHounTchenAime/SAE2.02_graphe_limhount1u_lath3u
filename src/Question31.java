import java.io.IOException;

public class Question31 {
    public static void main(String[] args) throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/labytest.txt");
        //génération du graphe en fonction du labyrinthe
        GrapheLabyrinthe grapheLabyrinthe = new GrapheLabyrinthe(l);

        BellmanFord bellmanFord = new BellmanFord();
        //cherche le chemin le plus cours
        Valeur v = bellmanFord.resoudre(grapheLabyrinthe, "(0, 0)");
        //affiche les valeurs
        System.out.println(v.toString());
        //affiche le chemin le plus cours
        System.out.println(v.calculerChemin("(4, 2)"));

    }
}
