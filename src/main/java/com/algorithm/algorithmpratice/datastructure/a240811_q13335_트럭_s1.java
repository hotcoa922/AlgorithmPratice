package com.algorithm.algorithmpratice.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a240811_q13335_트럭_s1 {

    static BufferedReader br;
    static int n;
    static int w;
    static int l;
    static int arr[];


    // FIFO -> Queue
    //단순 자료구조 문제로 보임
    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);
        int time = 1;
        int sum = arr[0];
        int idx = 1;

        while(idx<n) {
            time++;

            if(queue.size() >= w){
                int tmp = queue.poll();
                sum -= tmp;
            }

            if(sum+arr[idx] <= l){
                sum += arr[idx];
                queue.add(arr[idx]);
                idx++;
            }
            else{   //못올라가는 대신 0 넣자
                queue.add(0);
            }

        }

        int result = time + w;  //다리에 마지막 열차가 올라온 순간 반복문이 종료됨
        System.out.println(result);
    }

}

