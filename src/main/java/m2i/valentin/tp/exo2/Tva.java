package m2i.valentin.tp.exo2;

public class Tva {
    /**
     * Constante contenant la valeur de la TVA
     */
    public final double TVA = 1.20;

    /**
     * Calcul le prix TTC à partir du prix HT indiqué
     * @param prixHt - Prix HT
     * @return double - Le prix TTC
     */
    public double convertirPrixHtEnTtc(double prixHt) {
        verifierPrix(prixHt);

        return ajouterTva(prixHt);
    }

    /**
     * Ajoute la TVA à un nomnre
     * @param prixHt - Nombre à multiplier à la TVA
     * @return double - Retourne le nombre multiplié par la TVA
     */
    private double ajouterTva(double prixHt) {
        return prixHt * TVA;
    }

    /**
     * Vérifie que le prix HT est positif
     * @param prixHt - Prix HT
     */
    private void verifierPrix(double prixHt) {
        if(prixHt < 0) {
            throw new IllegalArgumentException("Le prix HT ne peut pas être inférieur à 0");
        }
    }
}
