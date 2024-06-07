package com.algorithm.algorithmpratice.twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a240607_q12847_꿀아르바이트_s3 {
    static int n;   //n일
    static int m;   //일할 수 있는 날
    static int arr[];
    static BufferedReader br;

    //2중 for문시 시간 초과
    //투포인터 사용
    //누적합으로 풀어도 ㄱㅊ

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        //n=5 / m=3
        // 012 123 234

        //슬라이딩 윈도우로 풀기
        long max = sum;
        for (int i = 1; i <= n - m; i++) {
            sum = sum - arr[i-1] + arr[i+m-1];
            max = Math.max(max, sum);
        }


        System.out.println(max);


    }
}
