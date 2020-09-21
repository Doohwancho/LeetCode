package september;

public class CarPooling {
	
	//<����Ǯ��1>
	
	//brute-force
	
	//1) �ִ� �Ÿ� ����
	
	//2) i��°�� ����� �ʿ����� ǥ��
	
	//3) i��°�� �ʿ��� �մ��� capacity���� �� ũ�ٸ�, return false
	
	//Runtime: 3 ms
	//Memory Usage: 39.3 MB
	
	
    public boolean carPooling(int[][] trips, int capacity) {
        
    	//1)
    	int len = 0;
        for(int[] trip : trips){
            len = Math.max(len, trip[2]);
        }
        int[] a = new int[len];
        
        //2)
        for(int[] trip : trips){
            for(int i = trip[1]-1; i < trip[2]-1; i++){
                a[i] += trip[0];
            }
        }
        
        //3)
        for(int i : a){
            if(i > capacity){
                return false;
            }
        }
        return true;
    }
    
    
    //<����Ǯ��1 by lee215>
    
    //ũ.. ���ȴ�
    
    //hashmap�ƴϰ� treemap�̾�!
    
    //������� �־�� �Ǽ� �׷�.
    
    //����Ҷ� trip[0]��ŭ ��� ���������� trip[0]��ŭ �ٽ� ä���ִ� ���
    
    //��Ʈ���� ��Ʈ��
    
    //Runtime: 5 ms
    //Memory Usage: 39.1 MB
    
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] trip : trips){
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        
        for(int i : map.values()){
            capacity -= i;
            if(capacity < 0){
                return false;
            }
        }
        return true;
    }
    
    //<����Ǯ��2 by votrubac>
    
    //����Ǯ��1�� ���� ����.
    
    //Runtime: 1 ms
    //Memory Usage: 39.5 MB
    
    //Runtime: O(n), where n is the number of trips.
    //Memory: O(m), where m is the number of stops.
    
    public boolean carPooling(int[][] trips, int capacity) {
        int[] a = new int[1001];
        for(int[] t : trips){
            a[t[1]]+=t[0];
            a[t[2]]-=t[0];
        }
        for(int i = 0; i < 1001 && capacity >= 0; i++) capacity -= a[i];
        return capacity >= 0;
    }
}
