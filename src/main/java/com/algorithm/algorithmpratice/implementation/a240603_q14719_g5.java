package com.algorithm.algorithmpratice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단순 구현으로 보임
public class a240603_q14719_g5 {

    static BufferedReader br;

    static int h;   //세로길이
    static int w;   //가로길이
    static int map[];



    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[w];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            map[i] = Integer.parseInt(st2.nextToken());
        }

        //바닥 만 막혀있음
        //양쪽 벽은 뚤려있음

        int tot = 0; //총 저장량

        //처음, 마지막은 제외하고
        //해당 인덱스에 고일 물의 양만 계산
        for (int i = 1; i < w-1; i++) {
            int left = 0;
            int right = 0;

            for (int a = 0; a < i; a++) {
                left = Math.max(left, map[a]);
            }

            for (int z = i+1; z < w; z++) {
                right = Math.max(right, map[z]);
            }

            if(map[i]<left && map[i]<right){
                tot += Math.min(left, right) - map[i];
            }


        }

        System.out.println(tot);



    }
}
