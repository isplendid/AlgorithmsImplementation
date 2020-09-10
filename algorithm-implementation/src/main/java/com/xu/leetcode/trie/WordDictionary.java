package com.xu.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sop on 2020/6/13.
 *  211. 添加与搜索单词 - 数据结构设计
 *
 *  a-z表示， . 可以表示任何一个字母
 */
class WordDictionary {

    class TrieNode {
        public boolean isEnd;
        public Map<Character, TrieNode> children; // Map is more applicable to all chars, not limited to 256 ASCII
        public TrieNode(){
            this.isEnd = false;
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    private  TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(null == word || word.length() ==0) return;
        TrieNode node = root;
        for(char c: word.toCharArray()){
            node.children.putIfAbsent(c,new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;  //can set word to node as well, is needed
    }


    public boolean search(String word) {
        return searchHelp(word, root);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean searchHelp(String word, TrieNode root) {
        //if(null == word || word.length() == 0) return false;
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            //对于. 递归判断所有不为空的孩子
            if(word.charAt(i) == '.'){
                for(int j=0; j<26; j++){
                    if(node.children.containsKey( (char) ('a' + j))) {
                        if(searchHelp(word.substring(i+1), node.children.get( (char)('a' + j)))){
                            return true;
                        }
                    }
                }
                return false;
            }

            if(!node.children.containsKey(word.charAt(i))){ //不含有当前节点
                return false;
            }
            node = node.children.get(word.charAt(i));
        }
        return node.isEnd;
    }


    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("b..")); //true
        //System.out.println(wd.search("pad"));  //false
        //System.out.println(wd.search(".ad"));  //true
        //System.out.println(wd.search("..d"));  //true
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */