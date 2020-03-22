package optimization.dynamicprogramming;

public class Fibonacci {

    public long fibonacciRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public long fibonacciDynamicProgramming(int n) {
        if (n <= 1)
            return n;
        long[] f = new long[n + 1];
        f[0] = 0l;
        f[1] = 1l;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    /**
     * Dynamic Programming is mainly an optimization over plain recursion.
     * Wherever we see a recursive solution that has repeated calls for same inputs, we can optimize it using Dynamic Programming.
     * The idea is to simply store the results of subproblems, so that we do not have to re-compute them when needed later.
     * This simple optimization reduces time complexities from exponential to polynomial
     *
     * In this example, we can compare the time taken to find the first 50 fibonacci numbers
     * - Using recursion: 133,350ms (2 mins and 20 seconds)
     * - Using dynamic programming: 3ms (yes! 3 milliseconds)
     *
     * https://www.geeksforgeeks.org/dynamic-programming/
     * @param args
     */
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();

        int N = 50;
        System.out.println("First " + N + " fibonacci numbers using recursion");
        long t0 = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            long start = System.currentTimeMillis();
            long n = f.fibonacciRecursion(i);
            System.out.println("fib(" + i + ") = " + n + " in " + (System.currentTimeMillis() - start) + "ms");
        }
        System.out.println("Finding the first " + N + "  numbers using recursion took " + (System.currentTimeMillis() - t0) + "ms");
        System.out.printf("------------");

        System.out.println("First " + N + " fibonacci numbers using dynamic programming");
        t0 = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            long start = System.currentTimeMillis();
            long n = f.fibonacciDynamicProgramming(i);
            System.out.println("fib(" + i + ") = " + n + " in " + (System.currentTimeMillis() - start) + "ms");
        }
        System.out.println("Finding the first " + N + "  numbers using dynamic programming took " + (System.currentTimeMillis() - t0) + "ms");
    }
}
