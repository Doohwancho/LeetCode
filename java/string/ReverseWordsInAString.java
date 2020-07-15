package julyChallenge;

public class ReverseWordsInAString {

	//<����Ǯ��1>
	
	//regex
	
	//.split(" ")�� ���� �����̽��� ���� �ܾ�� ���
	
	//�� �ܾ�� stringbuilder�� ù��° �ε����� �ھƳ���(reverse)
	
	//.split(" +") �� ������
	
	//+�� regex���� �Ѱ� Ȥ�� �� �̻��̶�� ���ε�, testcase���� ���� "my        dad"���� space�ٰ� �볻 �����µ�
	
	//output�� "dad my"�� �����϶�°� ����.
	
	//�� ���, .split(" ")�� ���� �����̽��� �Ѱ��� �����Ǳ� ������, �������� �����̽��ٸ� ��Ÿ���� " +"�� ��.
	
	//�ܾ ���϶����� str+" "�� ���⸦ ���Ƿ� �־��ְ�, 
	
	//�� ������ return�� .trim()�� �Ἥ �� �����ʿ� ���ʿ��� �����̽� ����.
	
	//Runtime: 13 ms
	//Memory Usage: 42 MB
	
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(String str : s.split(" +")){
			sb.insert(0, str+" ");
		}
        
        return sb.toString().trim();
    }
}
