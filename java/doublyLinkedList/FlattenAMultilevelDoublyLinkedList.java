package julyChallenge;

public class FlattenAMultilevelDoublyLinkedList {
	
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	};
	
	//<Trial01>
	
	//���� �°� ���µ� doubly linked list�� �ƴ϶�� ��ٸ�? 
	
	//�ذ�� : **head.child�� �־ ���ڷ� ���̰� �� ��, head.child = null ���־�� leetcode�� doubly linked list��� �ν���.
	
	//���� �� õ���
	
	//Runtime: 3 ms
	//Memory Usage: 39.6 MB
	
    public Node flatten(Node head) {
        Node start = head;
        Node tail;
        Node tmp;
        
        while(head != null){ 
            if(head.child != null){ //child�� ������
                tail = head.next;  //child�� �ƴ� ���� �����ֵ��� tail�� ���ΰ�
                head.next = flatten(head.child); //recursive�� child���� �����. head.child�� �Ǵٸ� child���� ������ ������. head.next�� ��������.
                head.child = null; //�̰� ���ϸ� not a valid doubly linked list ���� ��
                while(head.next != null){ //�����͸� child�� �� ������ ���� ��. �� ��, �ճ��� �޳�带 �̾��ָ鼭 ��.
                    tmp = head;
                    head = head.next;
                    head.prev = tmp;
                }
                head.next = tail; //�� �������� ������, �Ʊ� ������� ���� tail�ٿ���
                if(tail != null) tail.prev = head; //tail�̶� head���� �ٿ���
            }
            head = head.next;
        }
        
        return start;
    }
}
