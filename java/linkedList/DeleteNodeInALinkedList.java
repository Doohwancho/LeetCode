package juneChallenge;

public class DeleteNodeInALinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// <����Ǯ��1>

	// � head����ȾƸԾ���

	// 1->2->3->4 �ε�, node�� 2��� �غ���,
	
	//node.val = node.next.val�ϸ�
	
	//1->3->3->4 �� �ǰ���?
	
	//�׸��� 3��° node�� �����°���
	
	//node.next = node.next.next �ϸ�
	
	//1->3->4
	
	//�� �Ǽ� 2�� ���� �� ����.
	
	//�ٵ� ���� �̷������� head�� �ִµ�.. ���� input������ head�� �����ֱ���
	
	//���̾���
	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
