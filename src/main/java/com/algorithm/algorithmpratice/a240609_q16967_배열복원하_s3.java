package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a240609_q16967_배열복원하_s3 {

    static BufferedReader br;
    static int h;   //세로
    static int w;   //가로
    static int x;
    static int y;

//    static int arr1[][];
    static int arr2[][];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

//        arr1 = new int[h][w];
        arr2 = new int[h+x][w+y];

        for (int i = 0; i < h+x; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < w+y; j++) {
                arr2[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                arr2[i][j] = arr2[i][j] - arr2[i-x][j-y];
            }
        }



        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }





    }

}
