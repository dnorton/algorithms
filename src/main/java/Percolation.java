/**
 * Percolation simulation. This is a problem domain for the UnionFind algorithm.
 *
 * Compilation: javac Percolation.java
 *
 * @author Daniel Norton
 */
public class Percolation {

    private int dimensionSize; //the size of each dimension in the grid
    private int totalSize; //the total size of the flattened arrays
    private boolean[] open; //same array as items with boolean property, open
    private int virtualTopIndex;
    private int virtualBottomIndex;
    private WeightedQuickUnionUF quickUnionUF;

    public Percolation(int N) {
        this.dimensionSize = N;
        this.totalSize = N*N;
        open = new boolean[totalSize];
        quickUnionUF = new WeightedQuickUnionUF(totalSize + 2); //the 2 additional arrays are for the virtual top and bottom
        virtualTopIndex = totalSize;
        virtualBottomIndex = totalSize + 1;
    }

    /**
     * Set the site to open and connect it with any open surrounding sites
     *
     * @param i row position
     * @param j column position
     */
    public void open(int i, int j) {
        if (isOpen(i,j)) return;

        int position = flattenPosition(i,j);
        open[position] = true;

        if (i == 1) {
            quickUnionUF.union(virtualTopIndex, position);
        }

        if (i == dimensionSize) {
            quickUnionUF.union(position, virtualBottomIndex);
        }

        //check for open sites to the top, left, right, then bottom
        //top
        if (i - 1 > 0 && isOpen(i - 1, j)) {
            quickUnionUF.union(flattenPosition(i - 1, j), position);
        }

        //left
        if (j - 1 > 0 && isOpen(i, j - 1)) {
            quickUnionUF.union(flattenPosition(i, j - 1), position);
        }

        //right
        if (j + 1 <= dimensionSize && isOpen(i, j + 1)) {
            quickUnionUF.union(position, flattenPosition(i, j + 1));
        }

        //bottom
        if (i + 1 <= dimensionSize && isOpen(i + 1, j)) {
            quickUnionUF.union(position, flattenPosition(i + 1, j));
        }

    }

    /**
     * is the site open
     *
     * @param i row index
     * @param j column index
     * @return boolean
     */
    public boolean isOpen(int i, int j) {
        int position = flattenPosition(i, j);
        return open[position];
    }


    /**
     * Determine whether or not a position connects to a site in the top row
     * @param i row index
     * @param j column index
     * @return boolean
     */
    public boolean isFull(int i, int j) {
        return quickUnionUF.find(flattenPosition(i, j)) == virtualTopIndex;
    }

    /**
     * Determine whether or not a component contains a path from the top to the
     * bottom of the matrix
     * @return boolean
     */
    public boolean percolates(){
        return quickUnionUF.find(virtualBottomIndex) == quickUnionUF.find(virtualTopIndex);
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
