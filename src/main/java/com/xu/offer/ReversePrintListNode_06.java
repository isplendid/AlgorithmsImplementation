package com.xu.offer;



import com.xu.offer.base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/09/2020/9/1 15:16
 *
 * @Description: Method 1:  递归法
 * <p>
 * <p>
 * Method 2: 使用栈法
 */
public class ReversePrintListNode_06 {

    List<Integer> temp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recusive(head);
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void recusive(ListNode head) {
        if (head == null) return;
        recusive(head.next);
        temp.add(head.val);
    }

    //Method 2: stack
    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }
}
