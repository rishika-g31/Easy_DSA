import java.util.Scanner;

public class KnapsackAlgorithm {

    static int[][] dp;

    static int knapsack(int[] wt, int[] val, int n, int w) {
        if (n < 0 || w <= 0)
            return 0;
        if (dp[n][w] != -1)
            return dp[n][w];

        int ans = knapsack(wt, val, n - 1, w);

        if (wt[n] <= w) {
            ans = Math.max(ans, knapsack(wt, val, n - 1, w - wt[n]) + val[n]);
        }

        return dp[n][w] = ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of items and max weight: ");
        int n = scanner.nextInt();
        int w = scanner.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];

        System.out.print("Enter the weights and values: ");
        for (int i = 0; i < n; i++) {
            wt[i] = scanner.nextInt();
            val[i] = scanner.nextInt();
        }

        dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Max possible price: " + knapsack(wt, val, n - 1, w));
    }
}
