package step1_2;

import java.util.*;
import java.util.Queue;

public class RoadToBiodome10 {

    //이중 리스트로 그래프를 표현한다.
    //바깥쪽 그래프는 모든 그래프의 정점을 나타내고
    //내부 리스트는 해당 정점에 연결된 다른 정점들의 목록을 나타낸다.
    public static List<List<Integer>> graph =  new ArrayList<>();
    public static boolean[] visited;
    public static final int N = 100;

    private static void DFS(int i) {
        //현재 정점을 방문 true
        visited[i] = true;

        //현재 정점이 갈 수 있는 연결된 정점에 대해 아직 방문하지않은 정점이 있다면 방문한다.
        for(int n : graph.get(i)){
            if(!visited[n]){
                DFS(n);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(String plant : args){

            String[] text = plant.split(",");

            int plant1 = Integer.parseInt(text[0]);
            int plant2 = Integer.parseInt(text[1]);

            // 숫자로만 구성되었는지 확인
            if(!text[0].matches("\\d+") || !text[1].matches("\\d+")){
                System.out.println("입력값은 숫자여야 합니다.");
                return;
            }

            if(plant1 < 1  || plant1 > 100 || plant2 < 1 || plant2 > 100){
                System.out.println("연구 대상 식물은 최대 100가지입니다");
                return;
            }
            
            //두개의 수를 그래프에 연결시킨다.
            //plant1의 리스트에 plant2를 연결
            //plant2의 리스트에 plant1를 연결
            graph.get(plant1).add(plant2);
            graph.get(plant2).add(plant1);
        }


        visited = new boolean[N]; //그래프에 방문했는지 확인하는 boolean 배열을 만들고 false로 초기화한다.

        int group = 0;
        for(int i = 0 ; i < N; i++){
            //각정점에 대해 아직 방문하지않았고 연결된 다른 정점이 있다면 DFS로 요소를 방문한다.
            if(!visited[i] && !graph.get(i).isEmpty()){
                DFS(i);
                group++;
            }

        }

        visited = new boolean[N]; // 방문 상태 초기화
        int groupBFS = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && !graph.get(i).isEmpty()){
                BFS(i);
                groupBFS++;
            }
        }

        System.out.println(group);
        System.out.println(groupBFS);
    }


}
