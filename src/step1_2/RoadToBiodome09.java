package step1_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome09 {

    // 상하좌우 이동용 배열
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int N; //map의 세로 크기
    private static int M; //map의 가로 크기

    //BFS(너비 우선 탐색)
    private static int BFS(int[][] map) {
        int n = map.length; //map의 세로 크기
        int m = map[0].length;//map의 가로 크기
        boolean[][] visited = new boolean[n][m]; //map과 동일한 크기의 방문 여부를 검사할 boolean 배열
        Queue<int[]> queue = new LinkedList<>(); // BFS 탐색을 위한 큐

        queue.add(new int[]{0, 0}); // 시작점 큐에 추가
        visited[0][0] = true; // 시작점 방문 처리
        int depth = 0; // 현재 깊이 (시작점부터 도착점 까지의 거리)

        //큐가 비어있지않는 동안 계속 탐색한다.
        while (!queue.isEmpty()) {
            int currentSize = queue.size(); // 현재 깊이에서 탐색할 노드의 수

            for (int i = 0; i < currentSize; i++) {
                int[] current = queue.poll(); // 큐에서 노드를 하나 꺼냄;

                int x = current[0];
                int y = current[1];

                if (x == n - 1 && y == m - 1) return depth; // 도착점에 도달하면 현재 깊이 반환

                for (int j = 0; j < 4; j++) { // 상하좌우 탐색
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 맵 범위 안에 있고, 방문하지 않았으며, 이동 가능한 위치(값이 1인 지점)라면, 해당 위치를 큐에 추가하고 방문 처리
                    // 이 과정을 도착점에 도달할 때까지 반복한다
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true; // 해당 위치 방문 처리
                    }
                }
            }
            depth++; // 다음 깊이로 이동
        }
        return -1; // 모든 경로를 탐색했으나 도착점에 도달하지 못한 경우
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        N = args.length; // 맵의 세로 크기
        M = args[0].length(); // 맵의 가로 크기

        int[][] map = new int[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (args[i].length() != M) {
                System.out.println("이차원 배열로 입력해주세요.");
                return;
            }
            for (int j = 0; j < M; j++) {
                map[i][j] = args[i].charAt(j) - '0';
                cnt += map[i][j];
                if (map[i][j] > 2 || map[i][j] < 0) {
                    System.out.println("0, 1, 2만 입력 가능합니다.");
                    return;
                }
            }

            if(cnt == 0) {
                System.out.println("시작은 0으로 이뤄질 수 없다.");
                return;
            }
        }

        int result = BFS(map);

        if (result == -1) {
            System.out.println("안전한 경로가 없습니다.");
        } else {
            System.out.println(result);
        }
    }
}
