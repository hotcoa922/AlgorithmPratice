package com.algorithm.algorithmpratice.twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class a240607_q20437_문자열게임2_g5 {

    static BufferedReader br;

    static int t;       //테스트케이스

    // 각 알파벳의 인덱스를 저장할 리스트 배열
    static List<Integer>[] list = new ArrayList[26];

    //문자열 문제
    //슬라이딩 윈도우 문제인듯
    //테스트케이스 100개까지 가능해서 그냥 풀면 시간초과

    //발상이 안나서 찾아봄..

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 리스트 배열 초기화
        for (int i = 0; i < 26; i++){
            list[i] = new ArrayList<>();
        }
        

        t = Integer.parseInt(br.readLine());



        for (int i = 0; i < t; i++) {
            String str = br.readLine(); //대상문자열
            int k = Integer.parseInt(br.readLine());    // 대상 k

            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;

            //테스트 마다 리스트 초기화
            for (int j = 0; j < 26; j++) {
                list[j].clear();
            }

            // 문자열의 각 문자 위치를 해당 리스트에 추가
            for (int a = 0; a < str.length(); a++) {
                int alphabet = str.charAt(a) - 'a';
                list[alphabet].add(a);
            }

            // 각 문자의 인덱스 리스트를 사용해 k개를 포함하는 부분 문자열 찾기
            for (int j = 0; j < 26; j++) {
                if (list[j].size() >= k) {
                    List<Integer> list2 =list[j];   //현재 알파벳의 출현 인덱스 리스트 가져옴
                    for (int l = 0; l <= list2.size() - k; l++) {
                        int len = list2.get(l + k - 1) - list2.get(l) + 1;
                        minLen = Math.min(minLen, len);
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }

            if(maxLen == Integer.MIN_VALUE){
                System.out.println(-1);
            }
            else {
                System.out.println(minLen + " " + maxLen);
            }

        }
    }
}

