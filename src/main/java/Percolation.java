import java.util.Arrays;

/**
 * Percolation simulation. This is a problem domain for the UnionFind algorithm.
 */
public class Percolation {

    private int dimensionSize;
    private int totalSize; //the total size of the flattened arrays
    private int[] items; // list of items (ints) with their identities set to their index values from 0 to N*N -1
    private boolean[] open; //same array as items with boolean property, open
    private int[] componentSize; //the totalSize of the current site's component used for weighted union compare

    public Percolation(int N) {
        this.dimensionSize = N;
        this.totalSize = N*N;
        initializeArrays(totalSize);
    }

    //TODO: incomplete
    public void open(int i, int j) {
        int position = flattenPosition(i,j);
        open[position] = true;

    }

    public boolean isOpen(int i, int j) {
        int position = flattenPosition(i, j);
        return open[position];
    }


    public boolean isFull(int i, int j) {
        return false;
    }

    public boolean percolates(){
        return false;
    }

    /**
     * helper method to initialize arrays in the constructor
     * @param size
     */
    private void initializeArrays(int size) {
        items = new int[size];
        for (int i = 0; i < size; i++) {
            items[i] = i;
        }
        open = new boolean[size];
        componentSize = new int[size];
        Arrays.fill(componentSize, 1);
    }


    /**
     * helper method to convert the two dimensional position (i,j) to a single array index
     * @param i
     * @param j
     * @return int valid position with the items array
     * @throws IndexOutOfBoundsException if either i or j is less than 1 or greater than row/column size
     */
    private int flattenPosition (int i, int j) {
        if (i < 1 || i > dimensionSize + 1) throw new IndexOutOfBoundsException("row index i=" + i + " is out of bounds");
        if (j < 1 || j > dimensionSize + 1) throw new IndexOutOfBoundsException("column index j=" + i + " is out of bounds");

        return (dimensionSize * (i - 1))  + (j - 1);
    }

}
