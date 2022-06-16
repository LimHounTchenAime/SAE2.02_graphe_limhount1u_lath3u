import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {
    /**
     * Méthode de test de la méthode résoude de Dijkstra
     */
    @Test
    void resoudreTest() {
        //creation du graphe avec les donnees du sujet
        GrapheListe gl = new GrapheListe();

        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("E", "D", 43);

        gl.ajouterArc("A", "D", 87);

        gl.ajouterArc("D", "C", 10);

        gl.ajouterArc("D", "B", 23);

        gl.ajouterArc("A", "B", 12);

        gl.ajouterArc("B", "E", 11);


        Dijkstra dijkstra = new Dijkstra();
        Valeur v = dijkstra.resoudre(gl, "A");
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("A", "B", "E", "D", "C"));
        ArrayList<String> res = (ArrayList<String>) v.calculerChemin("C");

        //vérifie que les valeurs sont les bonnes
        assertEquals(0.0, v.getValeur("A"));
        assertEquals(12.0, v.getValeur("B"));
        assertEquals(76.0, v.getValeur("C"));
        assertEquals(66.0, v.getValeur("D"));
        assertEquals(23.0, v.getValeur("E"));

        assertEquals(null, v.getParent("A"));
        assertEquals("A", v.getParent("B"));
        assertEquals("D", v.getParent("C"));
        assertEquals("E", v.getParent("D"));
        assertEquals("B", v.getParent("E"));

        //on vérifie que le chemin donnée est bien le bon
        assertEquals(expected, res);

    }

    /**
     * Méthode de test de la méthode rechercherMin
     */
    @Test
    void testRechercherMinTest() {
        Dijkstra dijkstra = new Dijkstra();
        ArrayList<String> noeud = new ArrayList<String>();

        noeud.add("A");
        noeud.add("B");
        Valeur v = new Valeur();
        v.setValeur("A", 32);
        v.setValeur("B", 12);

        //on test la méthode rechercheMin retourne bien la valeur la plus petite
        String res = dijkstra.rechercheMin(noeud, v);
        assertEquals("B", res);

    }
}