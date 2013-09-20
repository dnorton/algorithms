import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * test class for Percolation.java
 */
public class PercolationTest {

    @Test
    public void testOpen() throws Exception {
        System.out.println("testOpen start");

        Percolation percolation = new Percolation(8);
        assertNotNull(percolation);
        percolation.open(1,2);
        assertTrue(percolation.isOpen(1,2));
        assertFalse(percolation.isOpen(2,1));


    }

    @Test
    public void testPercolates() throws Exception {

    }
}
