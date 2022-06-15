import java.util.Scanner;

public class MainDijkstra {
    public static void main(String[] args) {
        //• la lecture des graphes à partir de fichiers texte ;
        //• le calcul des chemins les plus courts pour des nœuds donnés ;
        //• l’affichage des chemins pour des nœuds donnés.
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle graphe ? (fichier texte)");
        GrapheListe gl = new GrapheListe(sc.next());
        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Point de départ ? : ");
        Valeur v = dijkstra.resoudre(gl, sc.next());
        System.out.println(v.toString());
        System.out.println("Point d'arrivé :");
        System.out.println(v.calculerChemin(sc.next()));
        System.out.println("Voice le chemin le plus court :");
        sc.close();
    }
}
