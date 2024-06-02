package com.algorithm.algorithmpratice.twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a240512_q2531_회전초밥_s1 {
    static BufferedReader br;
    static int n;       //접시 수
    static int d;       //초밥의 가짓수 -> 필요없는 정보
    static int k;       //연속해서 먹는 접시의 수
    static int c;       //쿠폰번호

    static int table[]; //접시정보
    static int check[]; //포함여부 카운팅

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        table = new int[n];
        check = new int[3001];
        for (int i = 0; i < n; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }


        //초기 설정
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            check[table[i]]++;
            if(check[table[i]] == 1){
                cnt++;
            }
        }
        if(check[c] == 0){
            cnt++;
        }


        int start = 0;
        int end = k-1;
        int maxCnt = cnt;
        for (int i = 0; i < n; i++) {
            int out = (start + i) % n;
            int in = (end + 1 + i) % n;

            check[table[out]]--;
            if(check[table[out]] == 0){
                cnt--;
            }
            if(table[out] == c && check[table[out]] == 0){
                cnt++;
            }

            check[table[in]]++;
            if(check[table[in]] == 1){
                cnt++;
            }
            if(table[in] == c){
                cnt--;
            }

            maxCnt = Math.max(cnt, maxCnt);
        }

        System.out.println(maxCnt);

    }
}
