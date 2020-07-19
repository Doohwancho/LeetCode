package array;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisibleByK1497 {
	
	//<Trial01>
	
    //arr = [1,2,3,4,5,10,6,7,8,9], k = 5
    
    //1,2,3,4,0,0,1,2,3,4
	
	//i%k�ϰ� k-i�� ã�� ���.
	
	//���̳ʽ����� ������ �����פФ� ��� �Ʊ���
	
	//[-1,1,-2,2,-3,3,-4,4], 3
	
	//�϶� -1�̶� 4�� �����ؾ� �ϴµ�... 4�� 1�̵Ǵ� �̰� �����ұ�
	
	//�� ����� ���巯 �귯?
	
	//[-1,1,-2,2,-3,3,-4,4],3 �̸�
	
	//2,1,1,2,0,0,2,1
	
	//{0:2,1:3,2:3}
	
	//����? ����ī?
    
    public boolean canArrange(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
            map.put(arr[i]%k, map.getOrDefault(arr[i]%k, 0)+1);
        }
        if(total % k > 0) return false;
        
        //find k-arr[i]
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(!map.containsKey((k-m.getKey())%k) || m.getValue() != map.get((k-m.getKey())%k)){
                return false;
            }
        }
        return true;
    }
    
    
    //<Trial02>
    
    //k=2155
    
    //{0=144, 2145=153, 1=166, 2=151, 2146=145, 2147=158, 3=124, 4=148, 2148=143, 2149=158, 5=127, 
    //2150=127, 6=158, 7=143, 2151=148, 8=158, 2152=124, 2153=151, 9=145, 2154=166, 10=153}
    
    //��ģ��ǲ�̸� �ȵȴ�. �ͱ�.
    
    //0�� �н�, 2145�� ����.
    
    public boolean canArrange(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
            if(arr[i] < 0){
                while(arr[i] < 0){
                    arr[i]+=k;
                }   
            }
            map.put(arr[i]%k, map.getOrDefault(arr[i]%k, 0)+1);   
        }
        if(total % k > 0) return false;
        
        //find k-arr[i]
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(!map.containsKey(m.getKey() == 0 ? 0 :(k-m.getKey())) || m.getValue() != map.get(m.getKey() == 0 ? 0 : k-m.getKey())){
                return false;
            }
        }
        return true;
    }
    
    
    //<Trial03>
    
    //Integer���� �񱳴� ==���� �ȵǰ� .equals()��ߵǳ�?
    
    //�ÿ� ��ü��� �ּڰ� �񱳶� �̰ǰ�?
    
    //�̰� ������ ���ǿ� testcase�����鼭 ������
    
    public boolean canArrange(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
            if(arr[i] < 0){
                while(arr[i] < 0){
                    arr[i]+=k;
                }   
            }
            map.put(arr[i]%k, map.getOrDefault(arr[i]%k, 0)+1);   
        }
        if(total % k > 0) return false;
        
        //find k-arr[i]
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            
            if(!map.containsKey(m.getKey() == 0 ? 0 :(k-m.getKey())) || !m.getValue().equals(map.get(m.getKey() == 0 ? 0 : k-m.getKey()))){
                return false;
            }
        }
        return true;
    }
    
    //<����Ǯ��1>
    
    //�ΰ��¸��ΰ�?
    
    //�� ������� �ѵ� ��·�� �н��߱� �߳�.
    
    //������ �Ӹ��� ���ڸ� �չ��� ����Ѵٴ��� 
    
    //���� ���� ���̾���? ����
    
    //Runtime: 90 ms, faster than 9.75% of Java online submissions for Check If Array Pairs Are Divisible by k.
    //Memory Usage: 96.7 MB, less than 100.00% of Java online submissions for Check If Array Pairs Are Divisible by k.
    
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
            arr[i] %= k; //���̳ʽ����� %k�� �Ǳ� ��. �ٸ� %�� ������� ���̳ʽ��� �׷���.
            if(arr[i] < 0){
                arr[i] += k; //�׷� �׳� +k���ָ� k���� ���ų� ���� ����� ��.
            }
            map.put(arr[i]%k, map.getOrDefault(arr[i]%k, 0)+1);   
        }
        if(total % k > 0 || map.containsKey(0) && map.get(0)%2 == 1) return false; //i�� 0�̶�� ���� i�� 0�̰ų� k���ٰ� %k���ؼ� 0��ٴ� �ǵ�, ��·�� �곻���� ¦���������� ��������� ���°� ���ݾ�
        
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
        	//1) k-i�� ���ų�, 2)i�� ������ k-i�� ������ ���� �ʰų�
        	if(!map.containsKey((k-m.getKey())%k) || !m.getValue().equals(map.get((k-m.getKey())%k))){
                return false;
            }
        }
        return true;
    }
    
    //<����Ǯ��2 by harin_mehta>
    
    //�ʾ� �ʿ䰡 ����. %k�ϰ� ��¥�� ���̳ʽ� ���ȭ �ϸ� �� 0���� k-1���� �ڳ�
    
    //int[]���ϱ� �κ�����.
    
    //Runtime: 10 ms, faster than 62.22% of Java online submissions for Check If Array Pairs Are Divisible by k.
    //Memory Usage: 47.7 MB, less than 100.00% of Java online submissions for Check If Array Pairs Are Divisible by k.
    
    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for(int num : arr){
            num %= k;
            if(num < 0) num += k;
            frequency[num]++;
        }
        if(frequency[0]%2 != 0) return false;
        
        for(int i = 1; i <= k/2; i++)
            if(frequency[i] != frequency[k-i]) return false;
			
        return true;
    }
}
