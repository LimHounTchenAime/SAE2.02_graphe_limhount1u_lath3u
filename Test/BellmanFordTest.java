import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BellmanFordTest {
    /**
     * teste le bon fonctionnement de l'algorithme de BellmanFord avec le graphe donne dans le sujet
     */
    @Test
    public void testBellmanFord() {
        //creation du graphe avec les donnees du sujet
        GrapheListe gl = new GrapheListe();

        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("E", "D", 43);

        gl.ajouterArc("A", "D", 87);

        gl.ajouterArc("D", "C", 10);

        gl.ajouterArc("D", "B", 23);

        gl.ajouterArc("A", "B", 12);

        gl.ajouterArc("B", "E", 11);





        //affichage graphe
        System.out.println(gl);

        //creation objet bellmanFord
        BellmanFord bellmanFord = new BellmanFord();

        //creation objet valeur qui est le resultat obtenu par la methode resoudreNbIteration (nbIteration correspondant au nombre d'iterations de l'algorithme)
        Valeur valeur=bellmanFord.resoudreNbIteration(gl, "A", 0);

        //affichage du resultat de l'algorithme
        System.out.println(valeur);

        //a l'initialisation, on fixe le depart a 0 et les autres sommets a +infini
        assertEquals(0, valeur.getValeur("A"));
        assertEquals(Double.MAX_VALUE, valeur.getValeur("B"));
        assertEquals(Double.MAX_VALUE, valeur.getValeur("D"));
        assertEquals(Double.MAX_VALUE, valeur.getValeur("E"));
        assertEquals(Double.MAX_VALUE, valeur.getValeur("C"));

        //a la premiere iteration B=12A car D est inconnu, , D=87A car C est inconnu, C=97D car on connait D, E=23B car on connait B
        valeur=bellmanFord.resoudreNbIteration(gl, "A", 1);
        System.out.println(valeur);

        assertEquals(0, valeur.getValeur("A"));
        assertEquals(12, valeur.getValeur("B"));
        assertEquals(97, valeur.getValeur("C"));
        assertEquals(87, valeur.getValeur("D"));
        assertEquals(23, valeur.getValeur("E"));

        //a la deuxieme iteration B=12A car 12A<110D, D=66E car 66E<87A, C=76D car on connait D, E=23B car on connait B
        valeur=bellmanFord.resoudreNbIteration(gl, "A", 2);
        System.out.println(valeur);

        assertEquals(0, valeur.getValeur("A"));
        assertEquals(12, valeur.getValeur("B"));
        assertEquals(76, valeur.getValeur("C"));
        assertEquals(66, valeur.getValeur("D"));
        assertEquals(23, valeur.getValeur("E"));

        //a la deuxieme iteration B=12A car 12A<110D, D=66E car 66E<87A, C=76D car on connait D, E=23B car on connait B
        valeur=bellmanFord.resoudreNbIteration(gl, "A", 3);
        System.out.println(valeur);
        assertEquals(0, valeur.getValeur("A"));
        assertEquals(12, valeur.getValeur("B"));
        assertEquals(76, valeur.getValeur("C"));
        assertEquals(66, valeur.getValeur("D"));
        assertEquals(23, valeur.getValeur("E"));


        //le point fixe est atteint

        //on affiche le chemin pour aller de A vers C (backtracking)
        System.out.println(valeur.calculerChemin("C"));

    }
}
