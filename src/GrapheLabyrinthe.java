import java.util.ArrayList;
import java.util.List;

public class GrapheLabyrinthe implements Graphe{
    private Labyrinthe laby;

    GrapheLabyrinthe(Labyrinthe l){
        this.laby = l;
    }

    @Override
    public List<String> listeNoeuds() {
        return null;
    }

    @Override
    public List<Arc> suivants(String n) {
        List<Arc> res=new ArrayList<>();

        return res;
    }
}
