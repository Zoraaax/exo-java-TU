package m2i.valentin.tp.exo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MoyenneTest {

    private Moyenne moyenne = new Moyenne();
    private int[] tableauNotes;

    /**
     * Initialise la classe qui doit être testé après chaque tests
     */
    @BeforeEach
    public void setUp() {
        moyenne = new Moyenne();
    }

    /**
     * Remet la valeur du tableau à vide après chaque tests
     */
    @AfterEach
    public void tearDown() {
        tableauNotes = null;
    }

    /**
     * Teste la moyenne en comparant la valeur du tableau attendu par la valeur obtenu
     * @param note1 - Première note du tableau
     * @param note2 - Deuxième note du tableau
     * @param note3 - Troisième note du tableau
     * @param expected - Récupère la moyenne attendu
     */
    @ParameterizedTest(name = "Test de la moyenne avec les notes {index} : {3}")
    @CsvSource({
            "12, 12, 12, 12",
            "4, 17, 20, 13"
    }) // Valeur du tableau de notes, 3 notes et la valeur attendu.
    @DisplayName("Test de la moyenne")
    public void testMoyenne(int note1, int note2, int note3, int expected) {

        tableauNotes = new int[]{note1, note2, note3};

        int resultat = moyenne.getMoyenne(tableauNotes);

        assertEquals(expected, resultat);
    }

    /**
     * Vérifie la longueur du tableau de note
     */
    @ParameterizedTest(name = "Test de la longueur du tableau de note {index} : {arguments}")
    @ValueSource(ints = {1, 2, 4, 5, 6, 7, 8, 9, 10})
    @DisplayName("Test de la longueur du tableau de note")
    public void testTailleTableauNote() {
        tableauNotes = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertThrows(IllegalArgumentException.class, () -> moyenne.getMoyenne(tableauNotes));
    }

    /**
     * Vérifie que les notes sont comprise entre 0 et 20
     * @param note1 - Première note du tableau
     * @param note2 - Deuxième note du tableau
     * @param note3 - Troisième note du tableau
     */
    @ParameterizedTest(name = "Test de la valeur des notes {index} : {arguments}")
    @CsvSource({
            "12, 12, 21",
            "4, 17, -1"
    })
    @DisplayName("Test de la valeur des notes")
    public void testValeurNotes(int note1, int note2, int note3) {
        tableauNotes = new int[]{note1, note2, note3};

        assertThrows(IllegalArgumentException.class, () -> moyenne.getMoyenne(tableauNotes));
    }

}