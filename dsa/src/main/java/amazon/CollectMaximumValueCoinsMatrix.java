package amazon;

public class CollectMaximumValueCoinsMatrix {
    public static boolean isValid(int i, int x, int y, int M, int N) {
        return i < M && x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int getMaxCoins(int[][] mat, int i, int x, int y)
    {

        int M = mat.length;
        int N = mat[0].length;

        if (!isValid(i, x, y, M, N))
        {
            return Integer.MIN_VALUE;
        }

        if (i == M - 1)
        {
            if (x == 0 && y == N - 1)
            {
                return (x == y) ? mat[i][x] : mat[i][x] + mat[i][y];
            }
            return Integer.MIN_VALUE;
        }
        int coins = Integer.MIN_VALUE;

        coins = Math.max(coins, getMaxCoins(mat, i + 1, x - 1, y - 1));
        coins = Math.max(coins, getMaxCoins(mat, i + 1, x - 1, y));
        coins = Math.max(coins, getMaxCoins(mat, i + 1, x - 1, y + 1));

        coins = Math.max(coins, getMaxCoins(mat, i + 1, x, y - 1));
        coins = Math.max(coins, getMaxCoins(mat, i + 1, x, y));
        coins = Math.max(coins, getMaxCoins(mat, i + 1, x, y + 1));

        coins = Math.max(coins, getMaxCoins(mat, i + 1, x + 1, y - 1));
        coins = Math.max(coins, getMaxCoins(mat, i + 1, x + 1, y));
        coins = Math.max(coins, getMaxCoins(mat, i + 1, x + 1, y + 1));

        if (x == y)
        {
            return mat[i][x] + coins;
        }
        else
        {
            return (mat[i][x] + mat[i][y]) + coins;
        }
    }

    public static int getMaxCoins(int[][] mat)
    {
        if (mat == null || mat.length == 0)
        {
            return 0;
        }
        int N = mat[0].length;

        return getMaxCoins(mat, 0, 0, N - 1);
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 0, 2, 4, 1 },
                        { 4, 8, 3, 7 },
                        { 2, 3, 6, 2 },
                        { 9, 7, 8, 3 },
                        { 1, 5, 9, 4 }
                };

        System.out.println("The maximum coins collected is " + getMaxCoins(mat));
    }
}
