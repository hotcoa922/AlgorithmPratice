package com.algorithm.algorithmpratice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class a240601_q22233_가희와키워드_s2 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;   //키워드 갯수
    static int m;   //블로그 글 갯수

    //n, m 각각 2만 까지 가능 -> 2중 for문 x
    //메모장의 키워드는 중복 없음
    //글에 있는 키워드는 중복 나올수도 있음

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashSet<String> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(br.readLine());
        }

        ArrayList<String> list2= new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list2.add(br.readLine());
        }


        //리스트에서 remove 사용은 값과 인덱스를 이용한 제거 모두 됨
        //list.remove(3) -> 인덱스 3 제거 -> remove(int index)
        //list.remove(200) -> 값 200 제거(중복값 존재시 첫번째거 제거) -> remove(Object o)

        //이렇게 하면 시간초과...
//        int cnt = n;
//        for (int i = 0; i < m; i++) {
//            String str[] = list2.get(i).split(",");
//
//            for (int j = 0; j < str.length; j++) {
//                if(list1.contains(str[j])){
//                    list1.remove(str[j]);
//                    cnt--;
//                }
//            }
//
//            System.out.println(cnt);
//        }

// ArrayList의 contains는 시간복잡도가 O(n)이고 HashSet의 경우 시간복잡도가 O(1) !!!! -> 매우 중요
        int cnt = n;
        for (int i = 0; i < m; i++) {
            String str[] = list2.get(i).split(",");

            for (int j = 0; j < str.length; j++) {
                if(set1.contains(str[j])){
                    set1.remove(str[j]);
                    cnt--;
                }
            }

            System.out.println(cnt);
        }
    }
}
