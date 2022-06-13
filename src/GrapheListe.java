import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrapheListe implements Graphe {
    private List<String> ensNom = new ArrayList<String>();
    private List<Noeud> ensNoeuds = new ArrayList<Noeud>();

    public GrapheListe(){
    }

    /**
     * construit un graphe a partir d'un nom de fichier
     * @param nom
     */
    public GrapheListe(String nom){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nom));
            String line;
            while((line = bufferedReader.readLine()) != null) {


                String poids="";

                int i = 4;
                while (i < line.length()) {
                    poids+=line.charAt(i);
                    i++;
                }

                ajouterArc(Character.toString(line.charAt(0)), Character.toString(line.charAt(2)), Double.parseDouble(poids));

            }
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("fichier introuvable");
        }
        catch (IOException ioException){

        }
    }

    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }

    /**
     * retourne tous les nœuds du graphe
     *
     * @return
     */
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    /**
     * retourne la liste des arcs partant
     * du nœud n passe en parametre
     *
     * @param n noeud n
     * @return liste des arcs
     */
    public List<Arc> suivants(String n) {
        //TODO
        List<Arc> res = new ArrayList<Arc>();
        for (int i = 0; i < this.ensNoeuds.size(); i++)
            if (this.ensNoeuds.get(i).getNom().equals(n))
                for (int j = 0; j < this.ensNoeuds.get(i).getAdj().size(); j++)
                    res.add(this.ensNoeuds.get(i).getAdj().get(j));
        return res;
    }

    /**
     * ajouter des nœuds et des
     * arcs `a un objet de type GrapheListe
     *
     * @param depart      nom du noeud de depart
     * @param destination nom du noeud d'arrivee
     * @param cout        cout de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        //Noeud de départ
        boolean trouveNoeudDepart = false;
        int i = 0;
        Noeud n = new Noeud(depart);
        //on cherche si le noeud existe deja ou pas
        if (ensNom.size() > 0) {
            while (!trouveNoeudDepart && i < this.ensNom.size()) {
                if (Objects.equals(ensNom.get(i), n.getNom())) {
                    trouveNoeudDepart = true;
                }
                i++;
            }
        }
        if (trouveNoeudDepart) {
            //Si trouve on recupere le noeud existant et on ajoute l'arc au noeud
            n = ensNoeuds.get(i - 1);
            n.ajouterArc(destination, cout);
        } else {
            //si le noeud existe pas on ajoute le noeud aux listes
            n.ajouterArc(destination, cout);
            ensNoeuds.add(n);
            ensNom.add(depart);
        }
        //Noeud de destination
        int k = 0;
        boolean trouveNoeudDestination = false;
        if (ensNom.size() > 0) {
            while (!trouveNoeudDestination && k < this.ensNom.size()) {
                if (Objects.equals(ensNom.get(k), destination)) {
                    trouveNoeudDestination = true;
                }
                k++;
            }
        }
        if (!trouveNoeudDestination) {
            ensNoeuds.add(new Noeud(destination));
            ensNom.add(destination);
        }
    }

    /**
     * afficher le graphe
     *
     * @return chaine
     */
    public String toString() {
        String res = "";
        List<Arc> suivants;
        for (int i = 0; i < this.ensNoeuds.size(); i++) {
            res += this.ensNom.get(i) + " -> ";
            suivants = this.suivants(this.ensNom.get(i));
            for (int j = i; j < suivants.size(); j++)
                res += suivants.get(j).getDest() + "(" + Math.round(suivants.get(j).getCout()) + ") ";
            res += "\n";

        }
        return res;
    }


    /**
     * retourne une chaîne représentant le graphe
     * en respectant le format GraphViz
     *
     * @return chaine
     */
    public String toGraphviz() {
        String res = "digraph {\n";
        for (int i = 0; i < this.ensNoeuds.size(); i++) {
            for(int k = 0; k < this.suivants(ensNom.get(i)).size();k++){
            res += this.ensNom.get(i) + " -> " + this.suivants(ensNom.get(i)).get(k).getDest()  + " [label = " + (int) this.suivants(ensNom.get(i)).get(k).getCout()+"]";
                res += "\n";
            }
        }
        res += "}";

        return res;
    }

}
