import java.util.List;

public class GrapheLabyrinthe implements Graphe {
    private Labyrinthe laby;
    private Graphe g;

    GrapheLabyrinthe(Labyrinthe l) {
        this.laby = l;
        this.g = laby.genererGraphe();
    }

    /**
     * @return
     */
    @Override
    public List<String> listeNoeuds() {
        return g.listeNoeuds();
    }

    /**
     * @param n
     * @return
     */
    @Override
    public List<Arc> suivants(String n) {
        return g.suivants(n);
    }

}
