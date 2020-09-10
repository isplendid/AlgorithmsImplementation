package com.xu.leetcode.desgin.search;

import java.util.*;

/**
 * Created by sop on 2020/6/14.
 * 自动补全系统
 */
public class AutocompleteSystem_642 {

    class TrieNode implements  Comparable<TrieNode> {
         Map<Character, TrieNode> children;
         String s;//sentence   s and times: only the last char has..句子最后节点
         int times;//sentence hot degree
         List<TrieNode> hots; //hot TrieNode list,  each node has its list
        public TrieNode() {
            children = new HashMap<>();
            s = null;
            times = 0;
            hots = new ArrayList<>();
        }

        @Override
        public int compareTo(TrieNode o) { //leaf node, can compare
            if(this.times == o.times){
                return this.s.compareTo(o.s);
            }
           return o.times - this.times;
        }

        /***
         *
         * @param leafNode  sentence last node
         */
        public void update(TrieNode leafNode){ //node为句子最后的节点，hots是每个TrieNode都有
            if(!this.hots.contains(leafNode)){
                this.hots.add(leafNode);
            }
            Collections.sort(hots);
            if(hots.size() > 3){
                hots.remove(hots.size()-1);
            }
        }
    }
    TrieNode root;
    TrieNode cur;  //当前输入节点
    StringBuilder sb; //历史输入字符串，遇到 '#'结束,重置全局参数，添加新的hot sentence

    public AutocompleteSystem_642(String[] sentences, int[] times) {
          root = new TrieNode();
          cur = root;
         sb = new StringBuilder();
        for(int i=0; i<sentences.length; i++){
            add(sentences[i], times[i]);
        }
    }

    public void add(String sentence, int times){
        TrieNode tmp = root;
        List<TrieNode> list = new ArrayList<>();
        for(char c: sentence.toCharArray()){
            if(!tmp.children.containsKey(c)){
                tmp.children.put(c, new TrieNode());
            }
            tmp = tmp.children.get(c);
            list.add(tmp);
        }
        //tmp: leaf node, add s, add times
        tmp.s = sentence;
        tmp.times += times;

        for(TrieNode innerNode : list){
            innerNode.update(tmp);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
       if(c=='#'){
           add(sb.toString(), 1);
           sb = new StringBuilder();
           cur = root;
           return res;
       }
        sb.append(c);
        if(cur != null){
            cur = cur.children.get(c);
        }
        if(cur == null){
            return res;
        }
        for(TrieNode node : cur.hots){  //hots 句子最后节点
            res.add(node.s);
        }
        return res;
    }
}
