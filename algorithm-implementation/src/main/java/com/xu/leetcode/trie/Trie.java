package com.xu.leetcode.trie;


import java.util.*;

/**
 * Created by sop on 2019/1/27.
 * @see https://leetcode.com/problems/implement-trie-prefix-tree/
 * Implement a trie with insert, search, and startsWith methods.Implement a trie with insert, search, and startsWith methods.
 */


/*You may assume that all inputs are consist of lowercase letters a-z.
        All inputs are guaranteed to be non-empty strings.
        */

/*
Thougths:
TrieNode: contains the single character, and a list of children.
Note: we will use hashmap<child character, child TrieNode>, because child access is O(1)
*/
class Trie {
    class TrieNode {
        public boolean isEnd;
        public Map<Character, TrieNode> children;          // Map is more applicable to all chars, not limited to 256 ASCII
        public TrieNode(){
            this.isEnd = false;
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
       root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(null == word || word.length() ==0 || search(word)) return;
        TrieNode node = root;
        for(char c: word.toCharArray()){
                node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;  //can set word to node as well, is needed
    }

    /** Returns if the word is in the trie. correct path + isEnd */
    public boolean search(String word) {
        if(null == word || word.length() == 0) return false;
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(null == prefix || prefix.length() == 0) return false;
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */}
