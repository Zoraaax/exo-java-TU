package m2i.valentin.tp.exo1;

public class Moyenne {

    /**
     * Affiche la moyenne du tableau de note
     * @param notes Tableau de note
     * @return La moyenne du tableau de note
     */
    public int getMoyenne(int[] notes) {
        verifierTaille(notes);

        verifierNotes(notes);

        return calculerMoyenne(notes);
    }

    /**
     *  Calcule la moyenne des notes
     * @param notes Tableau de notes
     * @return La moyenne des notes
     */
    private int calculerMoyenne(int[] notes) {
        int somme = 0;

        for (int note : notes) {
            somme += note;
        }
        return somme / notes.length;
    }

    /**
     * Vérifie que les notes dans le tableau sont comprise en 0 et 20
     * @param notes Tableau de note
     */
    private void verifierNotes(int[] notes) {
        for (int note : notes) {
            if (note < 0 || note > 20) {
                throw new IllegalArgumentException("Les notes doivent être comprise en 0 et 20");
            }
        }
    }

    /**
     * Vérifie que le tableau contient trois notes
     * @param notes Tableau de notes
     */
    private void verifierTaille(int[] notes) {
        if (notes.length != 3) {
            throw new IllegalArgumentException("Le tableau doit contenir trois notes");
        }
    }
}
