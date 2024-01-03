package m2i.valentin.tp.exo2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TvaTest {

    private Tva tva;

    /**
     * Instanciation de la classe TVA
     */
    @BeforeEach
    public void setUp() {
        tva = new Tva();
    }


    /**
     * Test du prix HT en le convertissant en TTC avec plusieurs prix différents
     * @param prixHt double - PrixHT
     */
    @ParameterizedTest(name = "Test du prix TTC avec plusieurs prix HT différents {index} : {0}")
    @ValueSource(doubles = {100, 200, 300})
    @DisplayName("Test de la TVA")
    public void testHtToTtcAvecPlusieursPrix(double prixHt) {

        double expected = prixHt * tva.TVA;

        assertEquals(expected,
                tva.convertirPrixHtEnTtc(prixHt),
                "Le calcul du prix TTC pour différents prix HT est incorrect"
        );
    }

    /**
     * Test du PrixHT en TTC avec une liste de valeur négative
     * @param prixHt double - Prix HT
     */
    @ParameterizedTest
    @ValueSource(doubles = {-200, -123, -10})
    @DisplayName("Test de la valeur négative de la TVA")
    public void testHtToTtcAvecPrixNegatif(double prixHt) {

        double expected = prixHt;

        assertThrows(IllegalArgumentException.class,
                () -> tva.convertirPrixHtEnTtc(prixHt),
                "Le prix HT négatif devrait lancer une exception"
        );
    }

    /**
     * Test du PrixHT en TTC avec un prix qui est égal à 0
     */
    @Test
    @DisplayName("Test de de la TVA avec une valeur nulle")
    public void testHtToTtcAvecPrixNul() {

        double prixHt = 0;
        double expected = 0;

        assertEquals(expected,
                tva.convertirPrixHtEnTtc(prixHt),
                "Le calcul du prix TTC pour un prix HT de zéro est incorrect"
        );
    }
}