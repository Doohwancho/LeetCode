package mayChallenge;

public class OddEvenLinkedList {

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
	
	//�̰�����~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//head�� 1,3,5,... Ȧ�� �ְ�
	
	//even�� 2,4,6,... ¦�� �ְ�
	
	//���߿� head.next = even���� ���� ������ϱ�
	
	//even�� �����Ͱ� 2�� �ƴϰ� 6�����ֳ�?
	
	//�׷� even�� 2���� �����ϴϱ�, ó�� �����ϴ°��� ����Ű�� �Ǵٸ� ���� evenStart�� ����.
	
	//�׷��� head.next = evenStart���� �ؼ� submit�Ϸ��ϱ�
	
	//head�� 1���� �����ϴ°� �ƴ϶� 5(Ȧ���� ��)���� �����ϳ�?
	
	//�׷��� 1�� ����Ű�� headStart�� �����, head.next = evenStart�� ��, ���� ó���� headStart�� ������
	
	//�ٵ� �� �������� null�� �ȳ����� ��������, even.next = null�� ������ ġ�� �̾���.

	// Runtime: 0 ms
	// Memory Usage: 39.1 MB

	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) return head;
        
		ListNode headStart = head;
        ListNode even = null;
        ListNode evenStart = null;
        
        while(head.next != null && head.next.next != null){
            if(even == null){
                even = head.next;
                evenStart = even;
                 
            } else {
                even.next = head.next;    
                even = even.next;
            }
            if(head.next.next != null){
                head.next = head.next.next;
                head = head.next;
            } 
        }
        
        if(head.next != null){
            even.next = head.next;
            even.next.next = null;
        } else{
            even.next = null;    
        }
        
        head.next = evenStart;
        return headStart;
	}
	
	
	//<����Ǯ��2 by caikehe>
	
	//���� ����ε� �ξ� �����.
	
	public ListNode oddEvenList(ListNode head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
	    ListNode p1 = head, p2 = head.next, pre = p2;
	    while (p2 != null && p2.next != null) {
	        p1.next = p2.next;
	        p1 = p1.next;
	        p2.next = p1.next;
	        p2 = p2.next;
	    }
	    p1.next = pre;
	    return head;
	}
	
	//<����Ǯ��3 by StefanPochmann>
	
	//¥���� ���� xor����
	
	//�̰� �ٷ� ���ι�����
	
	//����� ����
	
	public ListNode oddEvenList(ListNode head) {
	    ListNode odd = new ListNode(0), even = new ListNode(0), tail[] = {odd, even};
	    for (int i=0; head != null; i^=1) {
	        tail[i] = tail[i].next = head;
	        head = head.next;
	    }
	    tail[0].next = even.next;
	    tail[1].next = null;
	    return odd.next;
	}
}
