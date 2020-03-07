package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/3/1.
 *
 * https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 */
public class SortList_Merge_148 {

    /***
     * Bottom-up
     * 对于非递归的归并排序，需要使用迭代的方式替换cut环节
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
       if(head == null || head.next == null)  return head;
       int len = listLength(head);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for(int i=1; i<len; i *=2){
            ListNode prev = dummy;
            ListNode curr = dummy.next;

            //循环划分，合并
            while(curr != null){
                ListNode left = curr;
                ListNode right = split(left, i);
                curr = split(right,i);
                prev.next = mergeTwoLists(left, right);

                while(prev.next != null){ //找到未分治的节点
                    prev = prev.next;
                }
            }//while
        }//for

        return dummy.next;
    }

    //获取链表长度
    private int listLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            length++;
        }
        return length;
    }

    //分隔：根据步长分隔链表
    //head, right
    private ListNode split(ListNode head, int step) {
        if(head == null) return head;
        for(int i=1; head.next != null && i< step; i++){
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    //合并：合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }




    /***
     * 递归调用函数将带来O(logn)的 空间复杂度
     * 时间复杂度分别为O(nlogn)
     *
     * 通过递归实现链表归并排序，有以下两个环节 (自顶下向下)
     * 1) 分割 cut 环节：
     * cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点
     * 2) 合并 merge 环节
     * 将两个排序链表合并，转化为一个排序链表
     * @param head
     * @return
     */
    public ListNode sortListTopDown(ListNode head) {
        //1. 分割

        if(head==null || head.next == null){
            return head;
        }
        ListNode fast = head, slow = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstRight = slow.next;
        slow.next = null;//断开右边节点
        ListNode left = sortListTopDown(head);
        ListNode right = sortListTopDown(firstRight);

        //2. 合并
        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left != null ? left : right;
        return dummy.next;
    }
}
