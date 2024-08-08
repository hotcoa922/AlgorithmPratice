package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a240808_q1839_케빈베이컨의6단계법칙_s1 {

    static BufferedReader br;
    static int n;
    static int m;

    static ArrayList<Integer> list[];
    static int min;
    static boolean isVisited[];

    //각 정점 별 최단거리 -> BFS
    //그래프 문제

    static int bfs(int start, int end){
        Queue<int[]> queue = new LinkedList<>();
        isVisited = new boolean[n+1];   //할때마다 초기화
        queue.add(new int[]{start, 0}); //뒤에 요소로 카운팅
        isVisited[start] = true;

        int cnt = 0;

        while(!queue.isEmpty()){
            int now[] = queue.poll();

            if (now[0] == end) {
                return now[1];
            }

            //now[0] -> 현재 정점
            //now[1] -> 카운팅
            for (int i = 0; i < list[now[0]].size(); i++) {
                int next = list[now[0]].get(i);

                if(!isVisited[next]){
                    queue.add(new int[]{next, now[1]+1});
                    isVisited[next] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        //리스트 초기화
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            // 중복된 관계 방지
            if (!list[a].contains(b) && !list[b].contains(a)) {
                // 양방향
                list[a].add(b);
                list[b].add(a);
            }
        }

        min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int tmpCnt = 0;
            for (int j = 1; j <= n; j++) {
                if(i != j){
                    tmpCnt += bfs(i,j);
                }
            }

//            System.out.println(tmpCnt);
            if (tmpCnt < min) {
                min = tmpCnt;
                result = i;
            }
        }

        System.out.println(result);
    }
}
