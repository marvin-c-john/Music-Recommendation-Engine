import org.junit.Test;

import static org.junit.Assert.*;

public class VectorServiceTest {

    @Test
    public void testIdenticalVectors() {
        VectorService vectorService = new VectorService();

        double[] a = {3, 4, 5};
        double[] b = {3, 4, 5}; // exakt gleich

        double result = vectorService.cosineSimilarity(a, b);

        // Erwartet: 1.0
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testCompletelyDifferentVectors() {
        VectorService vectorService = new VectorService();

        double[] a = {1, 0, 0};
        double[] b = {0, 1, 0};

        double result = vectorService.cosineSimilarity(a, b);

        // Erwartet: 0.0
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testVectorScaling() {
        VectorService vectorService = new VectorService();

        double[] a = {1, 2, 3};
        double[] b = {2, 4, 6};

        double result = vectorService.cosineSimilarity(a, b);

        // Skalierter Vektor → muss trotzdem 1.0 sein
        assertEquals(1.0, result, 0.001);
    }
}