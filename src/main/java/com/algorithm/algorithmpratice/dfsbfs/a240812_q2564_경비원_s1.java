//package com.algorithm.algorithmpratice.dfsbfs;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//
////단순 개빡구현 문제
//
//public class a240812_q2564_경비원_s1 {
//    static BufferedReader br;
//    static int x;
//    static int y;
//
//    static int n;
//
//    static int map[][];
//
//
//    public static void main(String args[]) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        x = Integer.parseInt(st.nextToken());
//        y = Integer.parseInt(st.nextToken());
//
//        n = Integer.parseInt(br.readLine());
//
//        map = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st2 = new StringTokenizer(br.readLine());
//            map[i][0] = Integer.parseInt(st2.nextToken());
//            map[i][1] = Integer.parseInt(st2.nextToken());
//        }
//
//        StringTokenizer st3 = new StringTokenizer(br.readLine());
//        int dongX = Integer.parseInt(st3.nextToken());
//        int dongY = Integer.parseInt(st3.nextToken());
//
//        //1 4
//        //3 2
//        //2 8
//
//        //2 3
//
//        //반시계
//        //목표까지 1->2->3->4->1...
//        int result1[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            int targetX = map[i][0];
//            int targetY = map[i][1];
//
//            int tmpL = 0;
//            while(true){
//                if(targetX != dongX && targetY <=){
//                    if(targetX == 1){
//                        tmpL += targetY;
//                        targetY = 0;
//                        targetX++;
//                    }
//                    else if(targetX == 2){
//                        tmpL += y-targetY;
//                        targetY = 0;
//                        targetX++;
//                    }
//                    else if(targetX == 3){
//                        tmpL += x-targetY;
//                        targetY = 0;
//                        targetX++;
//                    }
//                    else if(targetX == 4){
//                        tmpL += targetY;
//                        targetY = 0;
//                        targetX=1;
//                    }
//                }
//
//                if(targetX == dongX){
//
//                }
//            }
//        }
//
//        //시계
//        int result2[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            int targetX = map[i][0];
//            int targetY = map[i][1];
//        }
//
//
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            result += Math.min(result1[i], result2[i]);
//        }
//
//        System.out.println(result);
//
//    }
//}
