package com.xu.leetcode.disjointset;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sop on 2020/2/23.
 */
public class SentenceSimilarTwo_734_no {
    public boolean areSentencesSimilar(
            String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;

        Set<String> pairset = new HashSet();
        for (String[] pair: pairs)
            pairset.add(pair[0] + "#" + pair[1]);

        for (int i = 0; i < words1.length; ++i) {
            if (!words1[i].equals(words2[i]) &&
                    !pairset.contains(words1[i] + "#" + words2[i]) &&
                    !pairset.contains(words2[i] + "#" + words1[i]))
                return false;
        }
        return true;
    }

    /**
     * 时间复杂度：O(N+P)。其中 NN 是 words1 的长度和 words2 的长度的最大值，PP 单词对的长度。
     空间复杂度：O(P)，集合 Set 中需要存放 PP 个单词对

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/sentence-similarity/solution/ju-zi-xiang-si-xing-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
