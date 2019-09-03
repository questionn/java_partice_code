/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        while ( l1 != null && l2 != null){
            int ret1 = l1.val;
            int ret2 = l2.val;
            head.next = new ListNode((ret1+ret2+tmp)%10);
            tmp = (ret1+ret2+tmp)/10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            head.next = new ListNode((l1.val+tmp)%10);
            tmp = (l1.val + tmp)/10;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null){
            head.next = new ListNode((l2.val+tmp)%10);
            tmp = (l2.val + tmp)/10;
            l2 = l2.next;
            head = head.next;
        }
        if (tmp != 0){
            head.next = new ListNode(tmp);
        }
        
        return listNode.next;
    }
}