package augustChallenge;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	//<����Ǯ��1>
	
	//EZ
	
	//if (i % 3 == 0 && i % 5 == 0) {
	//    list.add("FizzBuzz");
	//} else if (i % 3 == 0) {
	//    list.add("Fizz");
	//} else if (i % 5 == 0) {
	//    list.add("Buzz");
	//} else {
	//    list.add(String.valueOf(i));
	//}
	
	//�̰� ���� ����ϳ�. ��¥�� ���� �Ȱ��� ������
	
	//�ƴѰ�? ���� ���� �����϶� if-else if-else �̷��� 3�� ��ġ�µ�
	
	//�겨�� ���� �����϶�  if-else if-else if-else �̷��� 4�� ��ġ�ϱ�
	
	//���� �ƴұ�? ������ڰ� 3�̶� 5�� ������� ��~�� �� �����žƳ�.
	
	//�겫 �ڵ尡 ����ϴ� �ܿ� ������ 3�� 5�� ������� �������� ��ť�� �����ε�
	
	//���� 2�� ���ľ� �ϰ�. �ٵ� 15�� ����� �ѹ� ���ö� �ٸ� ���� ���ڵ��� �ξ� ���� �����ϱ�
	
	//���������� ���ư��°� ����ϸ� �ɱ� �������°� ���� ���
	
	//Runtime: 1 ms
	//Memory Usage: 40.9 MB
	
    public List<String> fizzBuzz(int n) {
        List<String> rst = new ArrayList<>();
        for(int i = 1; i < n+1; i++){
            if(i % 3 == 0){
                if(i % 5 == 0){
                    rst.add("FizzBuzz");
                } else {
                    rst.add("Fizz");
                }
            } else if(i % 5 == 0){
                if(i % 3 == 0){
                    rst.add("FizzBuzz");
                } else {
                    rst.add("Buzz");
                }
            } else {
                rst.add(Integer.toString(i));
            }
        }
        return rst;
    }
    
    
}
