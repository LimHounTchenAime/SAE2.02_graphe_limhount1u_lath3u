import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GrapheListeTest {

    @org.junit.jupiter.api.Test
    void ajouterArc() {
        GrapheListe gl = new GrapheListe();

        assertEquals(0, gl.listeNoeuds().size());

        //premier ajout
        gl.ajouterArc("A", "B", 120);
        assertEquals(2, gl.listeNoeuds().size());
        assertEquals("A", gl.listeNoeuds().get(0));

        //deuxieme ajout avec le meme depart
        gl.ajouterArc("A", "D", 87);
        assertEquals("A", gl.listeNoeuds().get(0));
        assertEquals(3, gl.listeNoeuds().size());

        //on vérifie l'ajout de l'arc
        gl.ajouterArc("D", "C", 10);
        assertEquals(4, gl.listeNoeuds().size());


    }

    @Test
    void TestToGraphViz() {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("B", "E", 11);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("E", "D", 43);
        // la méthode ne toGraphViz ne trie pas les noeuds par ordre alphabétique
        String res = "digraph {\n" +
                "A -> B [label = 12]\n" +
                "A -> D [label = 87]\n" +
                "B -> E [label = 11]\n" +
                "D -> C [label = 10]\n" +
                "D -> B [label = 23]\n" +
                "E -> D [label = 43]\n" +
                "C -> A [label = 19]\n" +
                "}";

        assertTrue(res.equals(gl.toGraphviz()));
    }

    @Test
    void TestToString() {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("B", "E", 11);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("E", "D", 43);
        String sommet_A = gl.listeNoeuds().get(0);
        String sommet_B = gl.suivants(sommet_A).get(0).getDest();

        //on vérifie pour si l'arc(A,B) existe
        assertEquals("A", sommet_A);
        assertEquals("B", sommet_B);

        //on vérifie le graphe
        String res = "A -> B(12) D(87) \n" +
                "B -> E(11) \n" +
                "D -> C(10) B(23) \n" +
                "E -> D(43) \n" +
                "C -> A(19) \n";

        assertEquals(res, gl.toString());
    }

    @Test
    void testCalculerChemin() {
        GrapheListe gl = new GrapheListe("graphes/graphe_exemple1.txt");
        BellmanFord bellmanFord = new BellmanFord();
        Valeur v = bellmanFord.resoudre(gl, "A");
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("A", "B", "E", "D", "C"));
        ArrayList<String> res = (ArrayList<String>) v.calculerChemin("C");

        //on test si le chemin est bien le même que celui trouvé
        assertTrue(expected.equals(res));
    }


}