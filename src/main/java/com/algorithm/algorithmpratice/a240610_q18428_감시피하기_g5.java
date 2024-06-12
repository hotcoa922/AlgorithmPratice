package com.algorithm.algorithmpratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a240610_q18428_감시피하기_g5 {

    static BufferedReader br;
    static int n;

    static char map[][];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        List<List<Integer>> listS = new ArrayList<>();
        List<List<Integer>> listT = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String tmp[] = str.split(" ");

            for (int j = 0; j < n; j++) {
                map[i][j] = tmp[j].charAt(0);

                if(map[i][j] == 'S'){
                    listS.add(List.of(i,j));
                }

                if(map[i][j] == 'T'){
                    listT.add(List.of(i,j));
                }

            }
        }



        //구현으로 풀면 될듯

        //학생의 정보 체크     0,1 / 1,2
        //선생의 정보 체크     0,4 / 1,0 / 3,1 / 4,2

        //0,1 과 마주치게 되는 것 3,1 / 0,4 -> y=1, x=0 무조건 막기
        //1,2 와 마주치게 되는 것 1,0 / 4,2 -> x=1, y=2 무조건 막기

        // x= 0, 1 / y= 1, 2 무조건 막기 -> set에 넣기

        //해쉬셋에 마주치는것 넣고 최종 사이즈가 3 초과인지 확인하자

       Set<Integer> set = new HashSet<>();
       for(List<Integer> tmpS : listS){
            int x = tmpS.get(0);
            int y = tmpS.get(1);

            for(List<Integer> tmpT : listT){
                int tmpX = tmpT.get(0);
                int tmpY = tmpT.get(1);

                if(x == tmpX){
                    set.add(tmpX);
                }
                else if(y == tmpY){
                    set.add(tmpY);
                }
            }
       }


       if(set.size() > 3){
           System.out.println("NO");
       }
       else {

           for(List<Integer> tmpT : listT){
               int tmpX = tmpT.get(0);
               int tmpY = tmpT.get(1);

               int dx[] = {-1, 1, 0, 0};
               int dy[] = {0, 0, -1, 1};

               for (int i = 0; i < 4; i++) {
                   int nx = tmpX + dx[i];
                   int ny = tmpY + dy[i];

                   if(nx>=0 && ny>=0 && nx<n && ny<n){
                       if(map[nx][ny] == 'S'){
                           System.out.println("NO");
                           System.exit(0);
                       }
                   }
               }
           }

           System.out.println(set.size());
           System.out.println("YES");
       }



    }
}
