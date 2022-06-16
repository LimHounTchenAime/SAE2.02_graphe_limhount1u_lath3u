import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Question23 {
    public static void main(String[] args) throws IOException {
        File folder = new File("graphes");
        folder.getName();
        File[] listFiles = folder.listFiles();
        System.out.println(listFiles.length);
        System.out.println(listFiles[0]);

        BufferedWriter out = new BufferedWriter(new FileWriter("resultat.txt"));
        out.write("nbNoeuds,nbArc,tempsBellmanFord,tempsDijkstra");


        for (int i = 0; i < listFiles.length; i++) {
            //on écrit le nombre de noeuds
            out.newLine();
            GrapheListe gl = new GrapheListe(listFiles[i].toString());
            int nbNoeuds = gl.getEnsNoeuds().size();

            //on écrit le nombre d'arc
            int cpt = 0;
            int nbArcs = 0;
            while (cpt < gl.listeNoeuds().size()) {
                String noeud = gl.listeNoeuds().get(cpt);
                for (int k = 0; k < gl.suivants(noeud).size(); k++) {
                    nbArcs++;
                }
                cpt++;
            }

            //chrono de résoudre de BellmanFord
            long startTime = System.nanoTime();
            BellmanFord bellmanFord = new BellmanFord();
            Valeur valeurBellmanFord = bellmanFord.resoudre(gl, "1");
            long endTime = System.nanoTime();
            long temps_BellmanFord = (endTime - startTime);

            //chrono de résoudre de Dijkstra
            startTime = System.nanoTime();
            Dijkstra dijkstra = new Dijkstra();
            Valeur valeurDijkstra = dijkstra.resoudre(gl, "1");
            endTime = System.nanoTime();
            long temps_Dijkstra = (endTime - startTime);

            out.write(nbNoeuds + "," + nbArcs + "," + String.valueOf(temps_BellmanFord) + "," + String.valueOf(temps_Dijkstra));
        }
        out.close();

    }
}
