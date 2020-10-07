package october;

public class RotateList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// <����Ǯ��1>
	
	
	
	//100�����̸� 100���� �� ���ʿ䰡 ���ݾ�. k/head.size()��ŭ ��ȸ�� �ϴ°Ŵϱ� %���༭ �������� ����.
	
	//step01) k % head.size() �ؼ� ���° ���� ���ƾ� �ϴ��� �ľ�
	
	//step02) i��° ���ķ� �� ���� ù��°�� �ٿ��� �ϴϱ�, i��°���� �̵���. i+1��° �ִ� �� �� ù��° ������ �ٿ��ٰ���.
	
	//step03) i+1��° �ְ� null�̶� ����, �� ���� ù��° ������ �ٿ��� �ְ� ���� ���̴ϱ�, �ٷ� head�� ��ȯ��.
	
	//step04) i.next = null. ���� ������ְ�, i+1��� ������ �� ����, �� ù��° �ֶ� �ٿ���. end.next = first ����.
	//		  tail.next.next ... �ؼ� ������ �� ���� ������, �Ʊ� head.size()���Ҷ� �̹� ������ �� head�� �̿��ؼ� head.next = first; ����

	//Runtime: 0 ms
	//Memory Usage: 38 MB

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;
		
		//step01)
		int len = 1;
		ListNode first = head;
		ListNode second = head;

		while (head != null && head.next != null) {
			len++;
			head = head.next;
		}
		int idx = len - (k % len) - 1;
		
		//step02)
		while (idx > 0) {
			second = second.next;
			idx--;
		}
		ListNode tail = second.next;
		
		//step03)
		if (tail == null) return first;
		
		//step04)
		second.next = null;
		head.next = first;

		return tail;
	}

}
