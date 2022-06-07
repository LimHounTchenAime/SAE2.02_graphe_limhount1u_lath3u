import java.util.List;

public class GrapheListe implements Graphe {
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    /**
     * retourne tous les nœuds du graphe
     * @return
     */
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    public List<Arc> suivants(String n) {
        throw new Error("Todo");
    }

    public void ajouterArc(String depart, String destination, double cout) {
        this.ensNoeuds.get(this.ensNoeuds.size()).ajouterArc(depart, cout);
    }
}
