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
}
