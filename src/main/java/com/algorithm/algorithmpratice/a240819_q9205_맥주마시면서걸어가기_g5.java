package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a240819_q9205_맥주마시면서걸어가기_g5 {


    static int t;
    static int n;
    static int house[] = new int[2];
    static int party[] = new int[2];

    static int map[][] = new int[66000][66000];
    static boolean isVisited[][] = new boolean[66000][66000];

    static BufferedReader br;

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,19});
        isVisited[x][y] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int nx = now[0];
            int ny = now[1];


        }
    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            n = Integer.parseInt(br.readLine());    //맥주를 파는 편의점 갯수

            //집 = 1
            //편의점 갯수 n개 = 2
            //페스티벌 = 3
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 32768;       //음수값 보정위해
            int b = Integer.parseInt(st.nextToken()) + 32768;       //음수값 보정위해
            map[a][b] = 1;  //집

            for (int j = 0; j < n; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int tmpA = Integer.parseInt(st.nextToken()) + 32768;
                int tmpB = Integer.parseInt(st.nextToken()) + 32768;
                map[tmpA][tmpB] = 2; //편의점
            }

            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int tmpAA = Integer.parseInt(st.nextToken()) + 32768;       //음수값 보정위해
            int tmpBB = Integer.parseInt(st.nextToken()) + 32768;       //음수값 보정위해
            map[tmpAA][tmpBB] = 3;  //패스티벌


        }



    }
}
