import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LabyTest {
    @Test
    public void testCreerGrapheAvecLabyrinthe() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labytest.txt");
        GrapheListe grapheListe = labyrinthe.genererGraphe();
        System.out.println(grapheListe);
    }
}
