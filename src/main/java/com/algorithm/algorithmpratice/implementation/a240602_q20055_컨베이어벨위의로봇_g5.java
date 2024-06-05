package com.algorithm.algorithmpratice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단순 구현으로 추정
public class a240602_q20055_컨베이어벨위의로봇_g5 {

    static BufferedReader br;

    static int n;
    static int k;
    static int arr[];   //내구도

    static boolean robot[];


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[2*n];
        robot = new boolean[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        //n = 10 ->   0 19 18 17 16 ... 11 10 9 8  / 추락 -> 10 9 8 7 6  ... 1 0 19 18
        //0 -> 2n-1 -> 2n-2 -> 2n-3 -> 2n-4 ... -> n+1 -> n -> n-1 ...

        
        int turn = 0;
        while(true){
            turn++;

            // 1번
            int tmp = arr[n*2-1];
            for (int i = n*2-1; i > 0; i--) {
                arr[i] = arr[i-1];
            }
            arr[0] = tmp;

            for (int i = n-1; i > 0; i--) {
                robot[i] = robot[i-1];
            }

            robot[0] = false;
            robot[n-1] = false;

            //2번
            for (int i = n-1; i > 0; i--) {
                if(robot[i-1] == true && robot[i] == false && arr[i]>0) {
                    robot[i-1] = false;
                    robot[i] = true;
                    arr[i]--;
                    robot[n-1] = false;
                }
            }


            //3번
            if(arr[0] > 0 ){
                robot[0] = true;
                arr[0]--;
            }

            //4번
            int cnt=0;
            for (int i = 0; i < 2*n; i++) {
                if(arr[i] <= 0) cnt++;
            }
            if(cnt>=k) break;

        }

        System.out.println(turn);

    }
}
