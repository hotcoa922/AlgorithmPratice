package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼성코테_q17144 {

    static BufferedReader br;
    static int r;
    static int c;
    static int t;   //시간

    static int map[][];

    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        int loc = 0;

        for (int i = 0; i < r; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());


                if(map[i][j] == -1){
                    if(loc == 0){
                        start = i;
                        loc++;
                    }
                    else{
                        end = i;
                    }
                }
            }
        }

        //확산되는 양은 /5 한 값

        for (int i = 0; i < t; i++) {
            //깊은 복사
            int newMap[][] = new int[r][c];
            for (int a = 0; a < r; a++) {
                for (int b = 0; b < c; b++) {
                    newMap[a][b] = map[a][b];
                }
            }

            fuc1(newMap);

            for (int a = 0; a < r; a++) {
                for (int b = 0; b < c; b++) {
                    map[a][b] = newMap[a][b];
                }
            }

            ////////////////////////
            int newMap2[][] = new int[r][c];
            for (int a = 0; a < r; a++) {
                for (int b = 0; b < c; b++) {
                    newMap2[a][b] = map[a][b];
                }
            }

            fuc2(newMap2);

            for (int a = 0; a < r; a++) {
                for (int b = 0; b < c; b++) {
                    map[a][b] = newMap2[a][b];
                }
            }
        }

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }


        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum+2);


    }

    static void fuc1(int newMap[][]){
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        //확산 값 지장 없게 미리 플러스 배열 생성
        int plusMap[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                plusMap[i][j] = map[i][j]/5;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = i;
                int y = j;

                int plus = map[x][y]/5;

                for (int k = 0; k < 4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if(nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny] != -1){
                        newMap[nx][ny] += plus;
                        newMap[x][y] -= plus;
                    }
                }
            }
        }
    }

    static void fuc2(int newMap2[][]) {

        //청정기 상단
        for (int i = start - 1; i > 0; i--) newMap2[i][0] = newMap2[i - 1][0];
        for (int i = 0; i < c - 1; i++) newMap2[0][i] = newMap2[0][i + 1];
        for (int i = 0; i < start; i++) newMap2[i][c - 1] = newMap2[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--) newMap2[start][i] = newMap2[start][i - 1];
        newMap2[start][1] = 0;

        //청정기 하단
        for (int i = end + 1; i < r - 1; i++) newMap2[i][0] = newMap2[i + 1][0];
        for (int i = 0; i < c - 1; i++) newMap2[r - 1][i] = newMap2[r - 1][i + 1];
        for (int i = r - 1; i > end; i--) newMap2[i][c - 1] = newMap2[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--) newMap2[end][i] = newMap2[end][i - 1];
        newMap2[end][1] = 0;
    }


}

