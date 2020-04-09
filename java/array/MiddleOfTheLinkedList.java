package thirtyDayChallenge;

public class MiddleOfTheLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	//<����Ǯ��1>
	
	//1ĭ�� ���� ���� �̵��ϴ� slow�� 2ĭ�� �ٴ��� ���� �̵��ϴ� fast�� �����,
	
	//�䳢�� �ź���ó�� ���� �����µ�
	
	//�䳢�� ���������� ������, �ź��̴� �䳢�� �ӵ��� ���̴ϱ�
	
	//linkedlist�� ������ ������?
	
	//15 / 15 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 37.4 MB
	
	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null) {
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				return slow;
			}
		}
		return slow;
	}
	
	/*
	
	//���� �����ε� �̰� �� ����ϴ�.
	
	public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;    
        }
        return slow;
    }
	 */
}
