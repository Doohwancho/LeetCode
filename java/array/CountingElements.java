package thirtyDayChallenge;

public class CountingElements {
	
	/*
	//<����Ǯ��1>

	//35 / 35 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 39.5 MB
    public int countElements(int[] arr) {
        int[] container = new int[1001];
        for(int i : arr){
            container[i]++; //�� �����ھ�
        }
        
        int rst = 0;
        for(int i = 1; i < container.length; i++){
            if(container[i] > 0 && container[i-1] > 0){ //���� �޷� ������
                while(container[i-1] > 0){ //�ڿ����� ��.  greedy. 
                    rst++;
                    container[i-1]--;
                }
            }
        }
        return rst;
    }
    */
    
    //<����Ǯ��2 by Losty>
    
    //�̹���� �� ����ϳ�

	//35 / 35 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 37.1 MB
    public static int countElements(int[] arr) {
        int[] a = new int[1002];
        for (int i : arr) a[i] = 1;
        int count = 0;
        for (int i : arr) count += a[i + 1]; //�ٵ� [1,1,2]��? a = {0,1,1,....}���ٵ�, �׷� �� 2�����ݾ�? �ٵ� �������� If there're duplicates in arr, count them seperately. ��� ������ 2�� �ƴ϶� 1�� �����̾�� �ϴ°� �Ƴ�? 
        return count;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,1,2};
		System.out.println(countElements(arr));
	}
}
