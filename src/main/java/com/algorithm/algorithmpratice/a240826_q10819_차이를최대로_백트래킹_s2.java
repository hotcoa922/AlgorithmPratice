package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a240826_q10819_차이를최대로_백트래킹_s2 {
    static int n;
    static int arr[];
    static int result[];
    static boolean isVisited[];

        static int ans = Integer.MIN_VALUE;


    static BufferedReader br;

    //백트래킹으로 풀어보자
    static void dfs(int depth) {
        if(depth == n){
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }

            ans = Math.max(ans, sum);

            return;
        }

        for (int i = 0; i < n; i++) {
            if(!isVisited[i]){  //방문하지 않았다면
                isVisited[i] = true;

                result[depth] = arr[i];
                dfs(depth+1);

                isVisited[i] = false;   //상태 복원
            }
        }
    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];    //결과 배열 -> 최종 순서대로 저장됨
        isVisited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);

    }
}
