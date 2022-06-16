import java.io.IOException;

public class tmp {
    public static void main(String[] args) throws IOException {
        GrapheListe grapheListe=new GrapheListe("graphes/Graphe101.txt");
        System.out.println(grapheListe.toGraphviz());
    }
}
