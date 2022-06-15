import java.io.IOException;

public class Question31 {
    public static void main(String[] args) throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby2.txt");
        GrapheLabyrinthe grapheLabyrinthe = new GrapheLabyrinthe(l);

        BellmanFord bellmanFord = new BellmanFord();
        Valeur v = bellmanFord.resoudre(grapheLabyrinthe,"(1, 1)");
        System.out.println(v.toString());


    }
}
