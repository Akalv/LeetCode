package LeetCode;

public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode currentNode = head.next;
        head.next = null;
        while (currentNode != null) {
            ListNode noSortHead = currentNode.next;
            System.out.println(currentNode.val);
            currentNode.next = null;
            ListNode tmp = head;
            ListNode lastTmp = null;

            while (tmp != null && currentNode.val >= tmp.val) {
                lastTmp = tmp;
                tmp = tmp.next;
            }
            if (lastTmp == null) {
                currentNode.next = head;
                head = currentNode;
            } else {
                lastTmp.next = currentNode;
                lastTmp.next.next = tmp;
            }
            currentNode = noSortHead;
        }
        return head;
    }
}
