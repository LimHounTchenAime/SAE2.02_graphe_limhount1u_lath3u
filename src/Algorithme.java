public interface Algorithme {
    /**
     * Permet de trouver le chemin le plus court en fonction du départ
     * @param g
     * @param depart
     * @return
     */
    Valeur resoudre(Graphe g, String depart);

}
