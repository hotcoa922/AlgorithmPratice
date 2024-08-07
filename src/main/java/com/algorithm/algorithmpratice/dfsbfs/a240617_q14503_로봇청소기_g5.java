//package com.algorithm.algorithmpratice;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class a240617_q14503_로봇청소기_g5 {
//
//    static BufferedReader br;
//
//    static int n;
//    static int m;
//    static int r;   //시작좌표
//    static int c;   //시작좌표
//    static int d;   //바라보는 방향
//
//
//    static int map[][];
//    static boolean isVisited[][];
//
//    static int cnt;     //청소한 칸 수
//
//    static void dfs(int x, int y){
//        if(map[x][y]==0){
//            cnt++;
//        }
//        isVisited[x][y]=true;
//
//        int dx[] = {0, 0, -1, 1};
//        int dy[] = {1, -1, 0, 0};
//        for(int i=0; i<4; i++){
//            int nx = x+dx[i];
//            int ny = y+dy[i];
//
//
//        }
//
//
//
//
//    }
//
//    static int func1(int x, int y){
//        if(d==0){
//
//        }
//        else if(d==1){
//
//        }
//        else if(d==2){
//
//        }
//        else if(d==3){
//
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//
//        r = Integer.parseInt(st2.nextToken());
//        c = Integer.parseInt(st2.nextToken());
//        d = Integer.parseInt(st2.nextToken());
//
//        map = new int[n][m];
//        isVisited = new boolean[n][m];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st3 = new StringTokenizer(br.readLine());
//            for (int j = 0; j < m; j++) {
//                map[i][j] = Integer.parseInt(st3.nextToken());
//            }
//        }
//
//        dfs(r, c);
//
//
//        //dfs로 풀자
//        //0인 경우 북쪽
//        //1인 경우 동쪽
//        //2인 경우 남쪽
//        //3인 경우 서쪽
//        //반시계니깐 동->북->서->남
//        //1->0->3->2
//
//
//
//
//
//
//
//
//    }
//}
