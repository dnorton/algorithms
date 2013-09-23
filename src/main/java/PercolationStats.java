/**
 * Created with IntelliJ IDEA.
 */
public class PercolationStats {

    private double[] results;
    private int dimensionSize;
    private int times; //number of times, T, to repeat the percolation steps

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {

        if (N <= 0 || T <= 0) throw new IllegalArgumentException("N and T must be greater than 0");

        dimensionSize = N;
        times = T;
        results = new double[T];
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return 0;
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return 0;
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(N, T);
        stats.runSimulation();
        System.out.println("mean=" + stats.mean());
        System.out.println("stdev=" + stats.stddev());
    }

    private void runSimulation() {
        for (int t = 0; t < results.length; t++) {
            int count = 0;

            Percolation percolation = new Percolation(dimensionSize);
            while(!percolation.percolates()) {
                int i = StdRandom.uniform(1, dimensionSize + 1);
                int j = StdRandom.uniform(1, dimensionSize + 1);

                while(percolation.isOpen(i, j)) {
                    i = StdRandom.uniform(1, dimensionSize + 1);
                    j = StdRandom.uniform(1, dimensionSize + 1);
                }
                percolation.open(i,j);
                count++;

            }
            results[t] = ((double)count) / (dimensionSize * dimensionSize);
        }

    }
}
