public class Arc {
    private String dest;
    private double cout;

    /**
     * constructeur prenant en parametres le nœud de destination et le cout
     *
     * @param dest destination
     * @param cout cout ou poids
     */
    public Arc(String dest, double cout) {
        this.dest = dest;
        if (cout > 0)
            this.cout = cout;
    }

    /**
     * renvoie le cout de l'arc
     * @return cout
     */
    public double getCout(){
        return this.cout;
    }

    public String getDest(){
        return this.dest;
    }
}
