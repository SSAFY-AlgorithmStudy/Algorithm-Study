import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int[][] arrRealation = new int[n + 1][n + 1];
        boolean[] visitCheck = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int personA = Integer.parseInt(st.nextToken());
        int personB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int realation = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= realation; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrRealation[x][y] = 1;
            arrRealation[y][x] = 1;

        }
        visitCheck[personA] = true;
        dfs(arrRealation, visitCheck, personA, personB, 0);
        if (visitCheck[personB] == false) System.out.println(-1);

    }

    public static void dfs(int[][] arrRealation, boolean[] visitCheck, int personA, int personB, int cnt) {
        if (personA == personB) {
            int k = cnt;
            System.out.println(k);
        }
        for (int i = 1; i <= n; i++) {
            if (arrRealation[personA][i] == 1 && !visitCheck[i]) {
                visitCheck[i] = true;
                dfs(arrRealation, visitCheck, i, personB, cnt + 1);
            }
        }
    }
}

