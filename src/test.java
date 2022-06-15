public class test {
    public static void main(String[] args) {
        GrapheListe grapheListe=GrapheListe.genererGraphe(100);
        System.out.println(grapheListe.toGraphviz());

    }
}
