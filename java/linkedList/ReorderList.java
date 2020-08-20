package augustChallenge;

import java.util.Stack;

public class ReorderList {

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

	// stack

	// Runtime: 2 ms
	// Memory Usage: 41.8 MB

	public void reorderList(ListNode head) {
		if (head == null) return;
			
		ListNode rst = head;
		ListNode start = head;

		Stack<ListNode> st = new Stack(); //stack�� ������� ���� ����,
		while (head != null) {
			st.add(head);
			head = head.next;
		}

		boolean flag = st.size() % 2 == 1;
		int size = st.size() / 2;
		while (size > 0) {
			ListNode tmp = start.next;
			start.next = st.pop(); //stack.pop()���� �ڿ��ִ¾� ��
			start = start.next; //�ٿ��ְ�
			start.next = tmp; //1->4 ������ �� 2�� �ٿ��ְ�
			start = start.next; //��ĭ ���ܼ� 1->4->2�� ����.
			size--;
		}
		if (flag) {
			start.next = st.pop(); //Ȧ���� ������ �� �������� ���� ���ٸ� ó��
			start = start.next;
		}
		start.next = null; //�̰� ���ϸ� cycle���ٰ� ������

		head = rst; //return void�̱� ������ head�� ���󺹱�
	}
	
	
	//<����Ǯ��2 by jeantimex>
	
	//�䳢�� �ź��̸� �Ἥ �ݶ��ϰ�,
	
	//�ڿ� ���� ������
	
	//ù��° ���̶� �ι�° ���̶� ������� merge
	
	//Runtime: 2 ms
	//Memory Usage: 43.4 MB
	
    ListNode secondStart;
    
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode start = head;
        secondStart = head;
        
        //split into two parts
        ListNode prev = head; //tail of 1st half
        ListNode slow = head; //head of 2nd half
        ListNode fast = head; //tail of 2nd half
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        //reverse the 2nd half
        reverse(slow);
        
        //merge 1st half & 2nd half
        merge(start, secondStart);
    }
    
    //recursive
    private ListNode reverse(ListNode head){
        if(head.next != null){
            ListNode tmp = head;
            ListNode tmp2 = reverse(head.next);
            tmp2.next = tmp;
            tmp2 = tmp2.next;
            tmp2.next = null; //�������� null�� Ȯ���� ������� merge���� fast != null�� ��� ����
            return tmp2;
        } else{
            secondStart = head;
            return head;    
        } 
    }
    
    private void merge(ListNode start, ListNode fast){
        ListNode prev = start;
        while(start != null){
            ListNode tmp = start.next;
            start.next = fast;
            fast = fast.next;
            start = start.next;
            start.next = tmp;
            prev = start;
            start = start.next;    
        }
        //Ȧ�������, ���� ������� fast�� ����
        if(fast != null){
            prev.next = fast;
            prev = prev.next;
            prev.next = null;
        }
    }
}
