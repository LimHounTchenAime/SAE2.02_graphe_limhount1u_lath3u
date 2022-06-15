public class Main {
    public static void main(String[] args) {

        //Question 15
        GrapheListe gl = new GrapheListe("graphes/graphe_exemple1.txt");

        //test de la méthode resoudre de BellmanFord
        BellmanFord bellmanFord = new BellmanFord();
        Valeur v = bellmanFord.resoudre(gl, "A");
        System.out.println(v.toString());
        System.out.println(v.calculerChemin("C"));
    }
}
