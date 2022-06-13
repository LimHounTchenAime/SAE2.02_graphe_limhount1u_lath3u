import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

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

        //
        gl.ajouterArc("D", "C", 10);
        assertEquals(4, gl.listeNoeuds().size());


    }

    @Test
    public void testCreerGrapheListeNomFichier() throws IOException {
        GrapheListe grapheListe=new GrapheListe("graphes/test1.txt");

    }

    //TODO TEST METHODES
}