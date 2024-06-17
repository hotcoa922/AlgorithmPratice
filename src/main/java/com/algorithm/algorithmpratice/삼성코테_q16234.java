package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 삼성코테_q16234 {

    static BufferedReader br;
    static int n;   //배열 사이즈
    static int l;   //인구차이 최소
    static int r;   //인구차이 최대

    static int map[][];
    static boolean isVisited[][];


    static void bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        isVisited[x][y] = true;
        int sum = map[x][y];

        ArrayList<int[]> list = new ArrayList<>();  //좌표값 저장
        list.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            int dx[] = {-1, 1, 0, 0};
            int dy[] = {0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                //20 50 일때 30이상 40 이하여야함
                if(nx>=0 && ny>=0 && nx<n && ny<n && isVisited[nx][ny] == false){
                    if(Math.abs(map[nx][ny] - map[nowX][nowY]) >= l && Math.abs(map[nx][ny] - map[nowX][nowY]) <= r){
                        sum += map[nx][ny];
                        queue.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                        list.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int tmp = sum / list.size();
        for(int[] i : list) {
            map[i[0]][i[1]] = tmp;
        }
    }

    static boolean isCheck(){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int dx[] = {-1, 1, 0, 0};
                int dy[] = {0, 0, 1, -1};

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        int diff = Math.abs(map[nx][ny] - map[i][j]);
                        if (diff >= l && diff <= r) {
                            return true; // 하나라도 조건을 만족하면 true 반환
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        //다 벋어나가야하니깐 bfs로 접근
        int cnt = 0;
        while(true){
            if (!isCheck()) {
                break; // 인구 이동이 더 이상 필요 없다면 루프 종료
            }

//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.println(map[i][j]);
//                }
//            }

            cnt++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!isVisited[i][j]){
                        bfs(i, j);
                    }
                }
            }

            //생각해보니 2차원배열은 이렇게 초기화못함
            //Arrays.fill(isVisited, false);
            for (int i = 0; i < n; i++) {
                Arrays.fill(isVisited[i], false);
            }

        }

        System.out.println(cnt);
    }

}
