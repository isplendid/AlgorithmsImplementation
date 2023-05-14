package com.xu2023.april;

import com.mashibing.juc.c_010.T;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @author xushichao
 * @date 2023/4/29 22:03
 * @desc
 * 我们选择 s的一个子串作为「待替换子串」，只有当 s 剩余的部分中 ‘Q’，‘W’，‘E’，‘R’ 的出现次数都小于等于 partial 时，我们才有可能使 s 变为「平衡字符串」，表示疑问吗？为什么这样就能保证？
 * (因为s的总长度是n，如果剩余部分每一个字母数量都不超过n/4，那么替换部分刚好可以将将剩余部分中缺少的字母补齐（这是由于两部分加起来一定为n，而且替换部分可以任意构造），
 * 反之如果有任意一个部分超过n/4，那么由于替换部分一定也是由QWER四个字母组成，一定会使原来超过n/4的那个字母在总字符串中字母数量不变或者增大，
 * 不可能通过替换操作减少剩余部分已经超过n/4的字母。)
 *
 */
public class BalancedString_1234 {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.first();

        List<Integer> list = new ArrayList<>();
        //list.stream().mapToInt().sum();
    }
}
