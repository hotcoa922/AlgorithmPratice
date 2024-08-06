package com.algorithm.algorithmpratice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a240806_q1051_숫자정사각형_s3 {


    static BufferedReader br;

    static int n;
    static int m;
    static int arr[][];

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int k = Math.min(n, m);
        int max = 1;

        for (int i = 1; i <= k; i++) {  //한 변의 길이

            for (int a = 0; a < n-i+1; a++) {
                for (int b = 0; b < m-i+1; b++) {
                    int tmp = arr[a][b];    //좌측 상단
                    if(tmp==arr[a+i-1][b] && tmp==arr[a][b+i-1] && tmp==arr[a+i-1][b+i-1]){
//                        System.out.println(a+ " "+ b +" " + i);
                        max = Math.max(i, max);
                    }
                }
            }
        }

        int result = (max)*(max);
        System.out.println(result);

    }
}
