import java.util.List;

public class Noeud {
    private String nom;
    private List<Arc> adj;

    Noeud(String nom) {
        this.nom = nom;
        this.adj = new List<Arc>();

    }

    public String getNom() {
        return nom;
    }

    public boolean equals(Object o) {
        Noeud n =(Noeud) o;
        return this.nom.equals(n.getNom());
    }

    public void ajouterArc(String destination,double cout){
        adj.add(new Arc(destination, cout));
    }

}
