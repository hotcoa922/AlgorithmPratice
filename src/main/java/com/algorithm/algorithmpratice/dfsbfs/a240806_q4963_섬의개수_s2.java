package com.algorithm.algorithmpratice.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//완전 탐색 문제
public class a240806_q4963_섬의개수_s2 {
    static BufferedReader br;

    static int w;
    static int h;
    static int map[][];
    static boolean isVisited[][];
    static int dx[] = {0, 0, -1, 1, 1, -1, 1, -1};     //대각선도 고려
    static int dy[] = {1, -1, 0, 0, 1, -1, -1, 1};     //대각선도 고려

    //1 = 땅
    //0 = 바다

    static void dfs(int x, int y){
        isVisited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<h && ny<w && !isVisited[nx][ny] && map[nx][ny]==1){
                dfs(nx, ny);
            }
        }





    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));



        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            map = new int[h][w];
            isVisited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j]==1 && !isVisited[i][j]){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);



        }







    }
}
