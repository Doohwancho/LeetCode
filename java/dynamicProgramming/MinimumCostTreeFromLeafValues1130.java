package dynamicProgramming;

public class MinimumCostTreeFromLeafValues1130 {

	//<Trial01>
	
	//31 / 103 test cases passed.
	
	//[15,13,5,3,15]
	
	//�̰� ������ �糡�ܿ��� �������� �ʾƵ� �Ǵ±���.
	
	//�߰����� �����ص� �ǳ� 
	
    public int mctFromLeafValues(int[] arr) {
        int rst = 0;
        int len = arr.length;
        
        for(int i = 0, j = len-1; i < j; ){
            int l = arr[i] * arr[i+1];
            int r = arr[j-1] * arr[j];
            
            if(l < r){
                rst += l;
                i++;
                arr[i] = Math.max(arr[i], arr[i-1]);
            } else {
                rst += r;
                j--;
                arr[j] = Math.max(arr[j], arr[j+1]);
            }
        }
        
        return rst;
    }
}
