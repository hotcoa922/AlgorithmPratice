package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class a240621_q7490_0만들기_g5 {

    static BufferedReader br;
    static int t;


    static void dfs(int start, int end, int result, StringBuilder sb){
        if(start == end){
            if(result == 0){
                System.out.println(sb);
            }
            return;
        }

        sb.append("+" + (start+1));
        dfs(start+1, end, result + (start+1), sb);
        sb.setLength(sb.length()-2);    //상태 되돌리기

        sb.append("-" + (start+1));
        dfs(start+1, end, result - (start+1), sb);
        sb.setLength(sb.length()-2);    //상태 되돌리기

        sb.append(" " + (start+1));
        dfs(start+1, end, result*10 + (start+1), sb);
        sb.setLength(sb.length()-2);    //상태 되돌리기

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));


        t = Integer.parseInt(br.readLine());


        //단순 구현문제로 추론
        //전부 다 탐색해야함 -> 깊이로 가자 -> dfs
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb  = new StringBuilder();
            sb.append(1);
            dfs(1, n, 1, sb);
            System.out.println();

        }

    }
}
