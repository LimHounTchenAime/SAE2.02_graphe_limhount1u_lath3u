import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private List<String> ensNom=new ArrayList<String>();
    private List<Noeud> ensNoeuds=new ArrayList<Noeud>();

    /**
     * retourne tous les nœuds du graphe
     * @return noeuds du graphe
     */
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    /**
     * retourne la liste des arcs partant
     * du nœud n passe en parametre
     * @param n noeud n
     * @return liste des arcs
     */
    public List<Arc> suivants(String n) {
        //TODO
        throw new Error("Todo");
    }

    /**
     * ajouter des nœuds et des
     * arcs `a un objet de type GrapheListe
     * @param depart nom du noeud de depart
     * @param destination nom du noeud d'arrivee
     * @param cout cout de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        this.ensNom.add(depart);
        this.ensNoeuds.get(this.ensNoeuds.size()).ajouterArc(destination, cout);
    }

    public String toString(){
        String res="";
        for (int i=0;i<this.ensNoeuds.size();i++)
            res+=this.ensNom+" -> "+this.ensNoeuds.get(i).getNom()+"("+this.ensNoeuds.get(i);
        return res;
    }
}
