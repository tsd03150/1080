import java.util.Scanner;

class Main {
    static int n;
    static int m;
    static int[][] a;
    static int[][] b;

    public void trans(int n1, int n2) {
        for (int i = n1; i < n1 + 3; i++) {
            for (int j = n2; j < n2 + 3; j++) {
                if (a[i][j] == 1) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        a = new int[n][m];
        b = new int[n][m];

        // a 배열 입력
        for (int i = 0; i < n; i++) {
            String tmp = kb.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = tmp.charAt(j) - '0';
            }
        }

        // b 배열 입력
        for (int i = 0; i < n; i++) {
            String tmp = kb.next();
            for (int j = 0; j < m; j++) {
                b[i][j] = tmp.charAt(j) - '0';
            }
        }

        // 행렬 비교, 다르다면 trans 메서드 호출
        int answer = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    answer++;
                    T.trans(i, j);
                }
            }
        }

        // 최종 a, b 행렬 비교
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

}
