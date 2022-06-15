import java.io.IOException;

public class Question31 {
    public static void main(String[] args) throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/labytest.txt");
        GrapheLabyrinthe grapheLabyrinthe = new GrapheLabyrinthe(l);

        BellmanFord bellmanFord = new BellmanFord();
        Valeur v = bellmanFord.resoudre(grapheLabyrinthe,"(0, 0)");
        System.out.println(v.toString());
        System.out.println(v.calculerChemin("(4, 2)"));

    }
}
