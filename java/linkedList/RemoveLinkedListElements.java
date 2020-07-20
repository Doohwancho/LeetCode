package julyChallenge;

public class RemoveLinkedListElements {

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

	// <Trial01>

	//[1],1�����ų� [1,1,1],1�����ų����� �ȵ�.
	
	//head.next�� �ٲٴ°� �ƴ϶� head.val == val�ϸ� head�� �ٲ�� ����. 
	
	//prev���� �Ƿ���

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode start = head;

		while (head != null && head.next != null) {
			if (head.next.val == val) {
				if (head.next != null && head.next.next != null) {
					head.next = head.next.next;
				} else {
					head.next = null;
				}
			}
			head = head.next;
		}

		return start.next == null && start.val == val ? null : start;
	}
	
	
	//<����Ǯ��1>
	
	//head.next == val, change head.next��, ���� head�� ù��°���� remove�ؾ� �ϴ� ��Ȳ�� ���� �ȵ�.
	
	//�׷��� head.next�� �ƴ϶� head���� �ٷ� ���ľߵ�.
	
	//�ٵ� �̰� doubly linked list�� �ƴ϶� singly linked list�̱� ������,
	
	//previous node�� ���� �����ؼ� ������ �� �ʿ䰡 ����.
	
	//ù��°���� �����ϴ°� if(prev==null)�� ���� ó������
	
	//O(n)
	
	//Runtime: 1 ms
	//Memory Usage: 46.6 MB
	
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = head;
        ListNode prev = null;
        
        while(head != null){
            if(head.val == val){
                if(prev == null){//[1,1,1],1
                    head = head.next;
                    start = head; //[1,2],1
                    continue;
                } else {
                    prev.next = head.next;
                    head = prev;
                }
            } 
            prev = head;
            head = head.next;
        }
        
        return start;
    }
    
    
    //<����Ǯ��2 by mscho147>
    
    //�� ��� prev�Ⱦ��� ���ʿ� �������� head��ĭ ������ �߱���
    
    //�׷��� cur.next.val == val�� �������ϰ� �� �� �־���.
    
    //Runtime: 0 ms
    //Memory Usage: 40.2 MB
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return node.next;
    }
}
