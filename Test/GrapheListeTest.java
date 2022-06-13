import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    @org.junit.jupiter.api.Test
    void ajouterArc() {
        GrapheListe gl = new GrapheListe();

        assertEquals(0,gl.listeNoeuds().size());

        //premier ajout
        gl.ajouterArc("A","B",120);
        assertEquals(2,gl.listeNoeuds().size());
        assertEquals("A",gl.listeNoeuds().get(0));

        //deuxieme ajout avec le meme depart
        gl.ajouterArc("A","D",87);
        assertEquals("A",gl.listeNoeuds().get(0));
        assertEquals(3,gl.listeNoeuds().size());

        //
        gl.ajouterArc("D","C",10);
        assertEquals(4,gl.listeNoeuds().size());


    }

    //TODO TEST METHODES
}