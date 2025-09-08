package Leetcode.java;

/*
1. 아이디어 :
정답 제출을 위해 dummy노드를 생성합니다. dummy.next를 마지막에 정답으로 반환합니다.
dummyNode에 다음 노드를 연결시킬 addNodePos 포인터, head의 현재 포인터를 저장합니다.

while문을 통해 head가 끝까지 갈 때까지 반복합니다.
    while문을 통해, 현재 curr과 curr.next의 값이 같지 않을때까지, 같다면 중복이고, 중복이라는 표시를 합니다.
    중복이지 않으면, addNodePos에 curr를 연결.
마지막으로 addNodePos 노드의 다음을 제거합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
링크드리스트 / -
 */

public class Q82 {
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode addNode = dummy;
        ListNode curr = head;

        while (curr!=null) {
            boolean isDup = false;
            while (curr.next!=null && curr.val == curr.next.val) {
                curr = curr.next;
                isDup = true;
            }
            if (!isDup) {
                addNode.next = curr;
                addNode = addNode.next;
            }
            curr = curr.next;
        }
        addNode.next=null;
        return dummy.next;
    }
}
 */
}
