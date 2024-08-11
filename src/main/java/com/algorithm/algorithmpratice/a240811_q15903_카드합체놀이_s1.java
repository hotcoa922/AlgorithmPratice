package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class a240811_q15903_카드합체놀이_s1 {

    static BufferedReader br;
    static int n;
    static int m;
    static List<Long> arr;  //Collections로 정렬하기 위함
    static Long sum;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sum = 0L;
        arr = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Long.parseLong(st2.nextToken()));
            sum += arr.get(i);
        }

        //누적 합으로 보임
        //아닌가?  가장 작은수 2개 찾아서 더해줘야함 -> 정렬?
        //자바의 Arrays.sort -> 최악 n^2 / 평군 nlogn
        // Collections.sort -> 둘다 nlogn
        // 1 4 6 9 20 -> 40
        // 5 5 6 9 20 -> 40 + 1 + 4 -> 45
        // 10 10 6 9 20 -> 45 + 5 + 5 ->55
        // 10 10 15 15 20 -> 55 + 6 + 9 -> 70


//        Collections.sort(arr, Collections.reverseOrder());


        for (int i = 0; i < m; i++) {
            //오름차순으로 해야함
//            Collections.sort(arr, Collections.reverseOrder());
            Collections.sort(arr);
            sum += (arr.get(0) + arr.get(1));

            long tmp = arr.get(0) + arr.get(1);
            arr.set(0, tmp);
            arr.set(1, tmp);
        }

        System.out.println(sum);

    }
}
