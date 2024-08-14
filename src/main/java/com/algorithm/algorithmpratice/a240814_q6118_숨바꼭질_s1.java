package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a240814_q6118_숨바꼭질_s1 {

    static BufferedReader br;
    static int n;
    static int m;
    static boolean isVisited[];

    static ArrayList<Integer> list[];
    static int info[];  //거리정보
    static int num = 0; //최대에 있는 농장번호

    static void bfs(int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        isVisited[start] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();

            for (int i = 0; i < list[now[0]].size(); i++) {
                int next = list[now[0]].get(i);

                if(!isVisited[next]){
                    queue.add(new int[]{next, now[1] + 1});
                    isVisited[next] = true;
                    info[next] = now[1] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n+1];
        info = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        //1번에서 가장 먼 것 찾기(최단경로를 가지며)

        bfs(1);

        int len = 0;
        for (int i = 2; i <= n; i++) {
            if(len < info[i]){
                num = i;
                len = info[num];
            }
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if(info[num] == info[i]) cnt++;

        }

        //숨어야 하는 헛간 번호 max
        //그 헛간까지의 거리 y
        //그 헛간과 같은 거리를 갖는 헛간의 개수 cnt

        System.out.println(num + " " + info[num] + " " + cnt);

    }
}
