package com.algorithm.algorithmpratice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a240806_q13414_수강신청_s3 {


    static BufferedReader br;

    static int k;
    static int l;
    static LinkedHashSet<String> set;

    //큐 사용하면 될듯?
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        set = new LinkedHashSet<>();

        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());


//        for (int i = 0; i < l; i++) {
//            String target = br.readLine();
//
//            if(queue.contains(target)) {
//                queue.remove(target);
//                queue.add(target);
//            }
//            else{
//                queue.add(target);
//            }
//        }

        //add, remove, contains는 각각 시간복잡도가  O(n)
        // 즉 이렇게 풀면 O(n^2)

        //set을 이용 -> set는 순서를 보장하지 않지만 LinkedHashSet은 순서 보장
        //LinkedHashSet은 O(1)이다 전부
        for (int i = 0; i < l; i++) {
            String target = br.readLine();

            if(set.contains(target)) {
                set.remove(target);
                set.add(target);
            }
            else{
                set.add(target);
            }
        }

        int cnt = 0;
        for(String i : set){
            System.out.println(i);
            cnt++;
            if(cnt==k) break;
        }

    }

}
