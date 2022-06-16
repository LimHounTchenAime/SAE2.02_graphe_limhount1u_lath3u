import java.util.List;

public class GrapheLabyrinthe implements Graphe {
    private Labyrinthe laby;
    private Graphe g;

    /**
     * Construit un graphe depuis un labyrinthe
     *
     * @param l Labyrinthe
     */
    GrapheLabyrinthe(Labyrinthe l) {
        this.laby = l;
        this.g = laby.genererGraphe();
    }

    /**
     * retoune la liste de noeuds
     *
     * @return
     */
    @Override
    public List<String> listeNoeuds() {
        return g.listeNoeuds();
    }

    /**
     * retourne la liste des arcs partant
     * du nœud n passe en parametre
     *
     * @param n
     * @return
     */
    @Override
    public List<Arc> suivants(String n) {
        return g.suivants(n);
    }

}
