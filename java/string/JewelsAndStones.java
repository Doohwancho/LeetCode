package mayChallenge;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	
	//<����Ǯ��1>
	
	//hint��
	
	//for each stone, check if it is a jewel
	
	//�ΰ� ��ȭ��?
	
	//�̰� ���� ó�� �� ����
	
	//�׷��� �� ��¼��°���? ��ø��°ǰ�?
	
	//strings J representing the types of stones that are jewels, and S representing the stones you have. 
	
	//String J�� "aA"�ݾ�? �׷� ������ ���� a~Z�߿� 'a'�� 'A'�� �����̰� �������� �׳� �����̶�°��ݾ�?
	
	//�ٵ� ���� ���� String S = "aAAbbbb"�� �������� �����̰�.
	
	//�ϴ� �������� �ϳ��� ���� ���߰���?
	
	//�׷��� �ʿ��Ѱ� .toCharArray()
	
	//String������ "aAAbbbb"�� char[]Ÿ���� {'a','A','A','b','b','b','b'}�� �������
	
	//�װ� for������ ���鼭 �ϳ��� ���� ���� ������ ����'a'�� 'A'���� Ȯ���ϴ°ž�
	
	//���� 2�� for���� ����ؼ�, 
	
//	for(char s : S.toCharArray()){
//        for(char j : J.toCharArray()) {
//        	if(s==j) {
//        		rst++;
//        		break;
//        	}
//        }
//    }
//	return rst;
	
	//���൵ �Ǵµ�, �׷��� ������ ���� �ȳ��ϱ�
	
	//���� �ƴ�ô�� �ϱ����� Set�� ����.
	
	//set�� �־��ĸ� .contains()��� �޼��尡 �ִµ�,
	
	//.contains(alphabet)�ϸ�, alphabet�� set�ȿ� ���ԵǾ��ִ��� �˷��ִ°���.
	
	//�� ��쿣, ���� ���� �����߿� ������ �ִ��� �˾ƺ��� �Ű���.
	
	//�׷��� set�� �������� �ְ�, .contains()�޼���� ���� ���� �������� for������ loop�������� set�� �ִ� ��������Ʈ�� �ִ��� Ȯ���ϴ� �������.
	
	//254 / 254 test cases passed.
	//Status: Accepted
	//Runtime: 2 ms
	//Memory Usage: 39.8 MB
	
	public int numJewelsInStones(String J, String S) {
        Set<Character> s = new HashSet<>();
        int rst = 0;
        for(char c : J.toCharArray()) {
        	s.add(c);
        }
        for(char c : S.toCharArray()){
            if(s.contains(c)){
                rst++;
            }
        }
        return rst;
    }
}
