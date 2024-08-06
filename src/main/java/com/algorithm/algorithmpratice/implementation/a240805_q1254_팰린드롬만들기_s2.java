package com.algorithm.algorithmpratice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//문자열 최대길이 50글자 -> 전부 다 해봐도 됨
public class a240805_q1254_팰린드롬만들기_s2 {

    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder(br.readLine());

//        int staticLen = sb.length();
//
//        while(true){
//            int len = sb.length();
//
//            boolean flag = true;
//            for (int i = 0; i < len/2; i++) {
//                char tmp1 = sb.charAt(i);
//                char tmp2 = sb.charAt(len-i-1);
//
//                if(tmp1 != tmp2) {
//                    System.out.println(sb);
//                    sb.insert(staticLen, tmp1);  //원하는 위치에 문자 삽입
//
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag == true) break;
//        }


        //위 접근은 잘못됨

        //하다보니깐 문자열 내부에 팰린드롬이 있는지를 확인한다 -> 인덱스 0 기준부터 찾기 -> 가지고있는 팰랜드롬중에 최대길이 찾아야하므로 찾자마자 break
        //qwerty -> 원래길이 6 + 없음 5 = 11
        //qwert -> 원래길이 5 + 없음 4 = 9
        //abab -> 원래길이 4 + aba (b 한개 남음으로) 1 = 5
        //abacaba -> 원래길이 7 + abacaba(전체가 그럼) 0 = 7

        int len = sb.length();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            String str = sb.substring(i);   //i번쨰 인덱스 부터의 문자열
            int start = 0;
            int end = str.length() - 1;

            //팰린드롬이 맞는지 체크
            boolean flag = true;
            while(start <= end){
                if(str.charAt(start) != str.charAt(end)){
                    cnt++;
                    flag = false;
                    break;
                }
                start++;
                end--;
            }

            if(flag == true){break;}    //찾으면 더이상 체킹 x

        }

        System.out.println(len + cnt);

    }
}