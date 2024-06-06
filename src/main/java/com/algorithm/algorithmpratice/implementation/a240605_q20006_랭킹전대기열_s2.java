package com.algorithm.algorithmpratice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class a240605_q20006_랭킹전대기열_s2 {

    static BufferedReader br;

    static int p;   // 플레이어 수
    static int m;   // 방의 정원
    static List<List<String>> rooms; // 방 목록
    static List<Integer> roomLevels; // 방의 기준 레벨 목록

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new ArrayList<>();
        roomLevels = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st2.nextToken());
            String name = st2.nextToken();

            boolean added = false;

            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j).size() < m && Math.abs(roomLevels.get(j) - level) <= 10) {
                    rooms.get(j).add(level + " " + name);
                    added = true;
                    break;
                }
            }

            if (!added) {
                List<String> newRoom = new ArrayList<>();
                newRoom.add(level + " " + name);
                rooms.add(newRoom);
                roomLevels.add(level);
            }
        }

        for (List<String> room : rooms) {
            if (room.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            room.sort(Comparator.comparing(s -> s.substring(s.indexOf(" ") + 1))); // 이름 순으로 정렬
            for (String player : room) {
                System.out.println(player);
            }
        }
    }
}