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

        int n = 8;

        System.out.println("testOpen start");

        Percolation percolation = new Percolation(n);
        assertNotNull(percolation);
        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(5, 5);
        assertTrue(percolation.isOpen(1, 2));
        assertFalse(percolation.isOpen(2,1));
        System.out.println("Finished");


    }

    @Test
    public void testIsFull() throws Exception {

        int n = 8;

        Percolation percolation = new Percolation(n);
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 2);

        assertTrue(percolation.isFull(3, 2));
        assertFalse(percolation.isFull(3, 4));


    }

    @Test
    public void testPercolates() throws Exception {
        int n = 8;

        Percolation percolation = new Percolation(n);
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 2);

        assertFalse(percolation.percolates());

        percolation.open(4,2);
        percolation.open(5,2);
        percolation.open(6,2);
        percolation.open(7,2);
        percolation.open(8,2);

        assertTrue(percolation.percolates());

    }
}
