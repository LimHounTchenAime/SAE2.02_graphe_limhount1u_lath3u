import java.util.ArrayList;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Noeud {
    private String nom;
    private List<Arc> adj;

    public List<Arc> getAdj() {
        return adj;
    }

    /**
     *  constructeur prenant en parametre le nom du nœud
     * et initialisant la liste adj `a une liste vide
     * @param nom nom du noeud
     */
    public Noeud(String nom) {
        this.nom = nom;
        this.adj = new ArrayList<Arc>();

    }

    /**
     * retourne le nom du noeud
     * @return nom du noeud
     */
    public String getNom() {
        return nom;
    }

    /**
     * specifie que deux nœuds sont egaux
     * si et seulement si leurs noms sont ´egaux
     * @param o noeud a comparer
     * @return les noeuds sont egaux
     */
    public boolean equals(Object o) {
        Noeud n =(Noeud) o;
        return this.nom.equals(n.getNom());
    }

    /**
     *  ajoute un arc allant vers le nœud destination avec un cout de cout a la liste
     * adj
     * @param destination noeud destination
     * @param cout cout du noeud
     */
    public void ajouterArc(String destination,double cout){
        adj.add(new Arc(destination, cout));
    }



}
