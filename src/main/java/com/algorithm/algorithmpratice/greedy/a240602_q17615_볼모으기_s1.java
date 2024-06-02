package com.algorithm.algorithmpratice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//dfs bfs로 풀려했으나 아님 -> 문자열임
// 그리디로 풀어보자 50만회임

public class a240602_q17615_볼모으기_s1 {
    static BufferedReader br;

    static int n;
    static char arr[];


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n];

        String str  = br.readLine();

        int rCnt = 0;
        int bCnt = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i);
            if(arr[i] == 'R'){
                rCnt++;
            }
            else bCnt++;
        }

        //결국bb..rr 또는 rr..bb로 만드는것

        //rrrbbrbbbrrrrbb
        //bb..rr로 만들 때 -> 3 + 1 + 4  -> 연속되는 r갯수 합산

        //rrrbbrbbbrrrrbr 이라면
        //bb..rr로 만들 때 -> 3 + 1 + 4 + 1(x)-> 연속되는 r갯수 합산   -> 좌측 끝의 연속은 제외

        //bbbbrrrrrb 이러면
        //bb..rr로 만들 때  -> 5
        //rr..bb로 만들 때 -> 4

        //흠 이러면 안됨

        //r, b를 연속된 숫자 배열로 바꿔보자
        //rrrbbrbbbrrrrbb -> 3-2-1-3-4-2    -> 3+1+4 / 2+3+2
        //rrrbbrbbbrrrrbr -> 3-2-1-3-4-2-1  ->
        //RRRRBBBBBR -> 4-5-1               -> 5 / 5
        //BBRBBBBR -> 2-1-4-1               -> 6 / 2

        //위 풀이 전부 무시 -> 경우의 수로 나눠보자
        //일단 색깔별 공 갯수를 구해둠
        //1. r을 전부 좌측으로
        //2. r을 전부 우측으로
        //3. b를 전부 좌측으로
        //4. b를 전부 우측으로

        int result = Integer.MAX_VALUE;

        int cnt1 = 0;
        //좌측의 첫번쨰 r묶음은 제외해야함 따라서 아래에서 그걸 카운팅함
        for (int i = 0; i < n; i++) {
            if(arr[i] == 'R'){
                cnt1++;
            }
            else break;
        }
        result = Math.min(result, rCnt-cnt1);


        int cnt2 = 0;
        for (int i = n-1; i >= 0; i--) {
            if(arr[i] == 'R'){
                cnt2++;
            }
            else break;
        }
        result = Math.min(result, rCnt-cnt2);

        int cnt3 = 0;
        //좌측의 첫번쨰 r묶음은 제외해야함 따라서 아래에서 그걸 카운팅함
        for (int i = 0; i < n; i++) {
            if(arr[i] == 'B'){
                cnt3++;
            }
            else break;
        }
        result = Math.min(result, bCnt-cnt3);

        int cnt4 = 0;
        for (int i = n-1; i >= 0; i--) {
            if(arr[i] == 'B'){
                cnt4++;
            }
            else break;
        }
        result = Math.min(result, bCnt-cnt4);


        System.out.println(result);

    }
}
