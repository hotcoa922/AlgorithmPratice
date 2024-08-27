package com.algorithm.algorithmpratice.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a240827_q2589_보물섬_g5 {

    static int n;
    static int m;
    static char map[][];
    static boolean isVisited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static int ans = 0;

    static BufferedReader br;

    //bfs로 풀면 될듯

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        isVisited[x][y] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx =  now[0] + dx[i];
                int ny =  now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !isVisited[nx][ny] && map[nx][ny] == 'L'){
                    queue.add(new int[]{nx, ny, now[2]+1});
                    isVisited[nx][ny] = true;
                    ans = Math.max(ans, now[2]+1);
                }
            }

        }
    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //할때마다 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'L' ){
                    isVisited = new boolean[n][m];
                    bfs(i, j);
                }
            }
        }


        System.out.println(ans);

    }

}
