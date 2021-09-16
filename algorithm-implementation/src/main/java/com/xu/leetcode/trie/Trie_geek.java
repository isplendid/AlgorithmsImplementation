package com.xu.leetcode.trie;

/**
 * @author xushichao
 * @date 2021/9/16 9:12 PM
 * @desc
 *
 * 构造Trie树，扫描所有字符串，时间复杂度O(N)
 * 每次查询时，如果查询字符串长度是K，对比K个节点即可
 *
 * 适用场景：
 * 1） 第一，字符串中包含的字符集不能太大。我们前面讲到，如果字符集太大，那存储空间可能就会浪费很多。即便可以优化，但也要付出牺牲查询、插入效率的代价。
 * 2） 第二，要求字符串的前缀重合比较多，不然空间消耗会变大很多。
 * 实际上，Trie 树只是不适合精确匹配查找，这种问题更适合用散列表或者红黑树来解决。Trie 树比较适合的是查找前缀匹配的字符串
 * 综合这几点，针对在一组字符串中查找字符串的问题，
 * 我们在工程中，更倾向于用散列表或者红黑树。因为这两种数据结构，我们都不需要自己去实现，直接利用编程语言中提供的现成类库就行了。
 */
public class Trie_geek {
    class TrieNode {

        public char data;
        public TrieNode[] children;

        public boolean isEndingChar;

        public TrieNode(char data) {
            this.data = data;
            this.children = new TrieNode[26];
            this.isEndingChar = false;
        }
    }

    private TrieNode root = new TrieNode('/'); // 存储无意义字符

    //插入字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(text[index]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }


    //查询字符串
    public boolean find(char[] pattern){
        TrieNode p = root;
        for(int i=0; i<pattern.length; i++){
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if(p.isEndingChar == false) {
            return false;
        }
        return true;
    }


}
