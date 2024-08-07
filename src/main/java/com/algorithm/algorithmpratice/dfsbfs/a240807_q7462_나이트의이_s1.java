package com.algorithm.algorithmpratice.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//최단경로를 찾아야함 -> bfs


public class a240807_q7462_나이트의이_s1 {

    static BufferedReader br;
    static int t;
    static int l;
//    static int map[][];
    static boolean isVisited[][];
    static int cnt;
    static int rX;
    static int rY;

    //나이트 이동 가능 경로
    static int dx[] = {1, 1, -1, -1, 2, -2, 2, -2};
    static int dy[] = {2, -2, 2, -2, 1, 1, -1, -1,};


    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});  //3번째 요소는 이동 횟수

        if(x==rX && y==rY) return 0;

        while(!queue.isEmpty()){
            int now[] = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<l && ny<l && !isVisited[nx][ny]){
                    queue.add(new int[]{nx, ny, now[2]+1});
                    isVisited[nx][ny] = true;
                }

                if(nx==rX && ny==rY){
                    return now[2]+1;
                }
            }
        }
        return -1;
    }


    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());

//            map = new int[l][l];
            isVisited = new boolean[l][l];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            rX = Integer.parseInt(st2.nextToken());
            rY = Integer.parseInt(st2.nextToken());

            cnt = bfs(sX, sY);
            System.out.println(cnt);
        }


    }
}
