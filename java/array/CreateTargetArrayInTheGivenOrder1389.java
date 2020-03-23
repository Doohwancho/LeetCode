package array;

import java.util.LinkedList;
import java.util.List;

public class CreateTargetArrayInTheGivenOrder1389 {
	
	
	//<����Ǯ��1>
	
	//Runtime: 1 ms, faster than 63.17% of Java online submissions for Create Target Array in the Given Order.
	//Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Create Target Array in the Given Order.
	
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> container = new LinkedList<>(); //�߰��� �����ϴ°� �־ LinkedList����� ArrayList�� �� ������.  linkedlist is always O(1) whereas arraylist is O(n). find the position to add is O(N), and then add is O(1)
        
        for(int i = 0; i < nums.length; i++){
            container.add(index[i], nums[i]);
        }
        
        //�׳� return container.stream().mapToInt(i->i).toArray(); �� ������, �̰ͺ��� 1ms�� ������.
        
        //.stream()���̺귯���� .mapToInt() ã�Ƽ� ���µ� 1ms���� �ɸ��� ����.
        //i->i�� ������ �Ʒ�ó�� ��
        
        //list.stream().mapToInt(num -> Integer.parseInt(num)) 
        //	.filter(num -> num % 3 == 0) 
        //	.forEach(System.out::println); 
       
        //�ٵ� �� ��쿣 .toArray()�Ϸ��� Integer���� intŸ������ wrapper class -> primitive class ����ȯ ������� �ϴµ�,
        
        //�ű⼭ ������ element�� for�� ���� ������ .stream�� �ϰ�
        //�� element�� ������ int�ιٲ��ַ��� .mapToInt(i->i)�� ��. 
        
        //���� ���� �������� ������ �������̶� ����.
        
        int[] rst = new int[nums.length];
        
        for(int j = 0; j < nums.length; j++){
            rst[j] = container.get(j);
        }
        
        return rst;
    }
}
