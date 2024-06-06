package com.algorithm.algorithmpratice.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a240606_q14940_쉬운최단거리_s1 {


    static BufferedReader br;

    static int n;   //세로
    static int m;   //가로
    static int map[][];
    static int result[][];
    static boolean isVisited[][];

    //dfs-bfs 문제로 보임
    //최단거리 문제 이므로 bfs 사용

    static void bfs(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(new int[]{startX, startY});
        isVisited[startX][startY] = true;
        result[startX][startY] = cnt;

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            int dx[] = {-1, 1, 0, 0};
            int dy[] = {0, 0, -1, 1};


            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && isVisited[nx][ny] == false && map[nx][ny] != 0){
                    queue.offer(new int[]{nx, ny});
                    isVisited[nx][ny] = true;
                    result[nx][ny] = result[nowX][nowY] + 1;
                }
            }


        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        isVisited = new boolean[n][m];



        //0=못감 1=길 2=목표지점

        int startX = -1;
        int startY = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());

                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1  && result[i][j] == 0){
                    System.out.print(-1 + " ");
                }
                else {
                    System.out.print(result[i][j] + " ");
                }
            }
            System.out.println();
        }








    }
}
