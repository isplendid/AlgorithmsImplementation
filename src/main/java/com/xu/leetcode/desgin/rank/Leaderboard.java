package com.xu.leetcode.desgin.rank;

import java.util.*;

/**
 * Created by sop on 2020/6/14.
 */
public class Leaderboard {
    private Map<Integer, Integer> map;

    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
          if(map.containsKey(playerId)){
              map.put(playerId, map.get(playerId) + score);
          }else {
              map.put(playerId, score);
          }
    }

    public int top(int K) {
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int sum =0;
        for(int i=0; i<K; i++){
            sum += entries.get(i).getValue();
        }
        return sum;
    }

    public void reset(int playerId) {
        map.put(playerId, 0);
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1,73);
        leaderboard.addScore(2, 56);
        leaderboard.addScore(3, 39);
        leaderboard.addScore(4, 51);
        leaderboard.addScore(5,4);

        System.out.println(leaderboard.top(1));;// return 73
        leaderboard.reset(1);
        leaderboard.reset(2);
        leaderboard.addScore(2,51);
        System.out.println(leaderboard.top(3));   //141 = 51 +  51 + 39

    }


}
