import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    @org.junit.jupiter.api.Test
    void ajouterArc() {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A","B",120);
        assertEquals(new String[]{"A"},gl.listeNoeuds().get(0));


    }
}