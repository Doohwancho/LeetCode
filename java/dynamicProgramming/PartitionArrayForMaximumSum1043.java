package dynamicProgramming;

public class PartitionArrayForMaximumSum1043 {

	//<Trial01>
	
	//24 / 52 test cases passed.
	
	
	//���� ���� ������ ��, �� �̰�, �� ���� �翷���� ��ĭ�� ������Ű���� �ߴµ�,
	
	//[10,9,3,2]
	//2
	
	//�� ��쿣, ���� ���� ������ �ָ� ������ �ȵ�.
	
	//dp�� ��� ���ʿ��� ����� �� ���� �� ���� ��.
	
	//...���� ���ʿ� ���̰� ���� ū�� ���ַ� ������ ���� ������?
	
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length == 1) return arr[0];
        
        int len = arr.length;
        int cnt = 0;
        boolean[] visited = new boolean[len];
        
        while(cnt < len){
            int max = 0;
            int maxIdx = 0;
            for(int i = 0; i < len; i++){
                if(!visited[i] && arr[i] > max){
                    max = arr[i];
                    maxIdx = i;
                }
            }
            
            visited[maxIdx] = true;
            cnt++;
            
            for(int j = maxIdx, l = j-1, r = j+1, contaminate = 0; contaminate < k-1; ){
                if(l == -1){
                    if(visited[r]) break;
                    arr[r] = arr[j];
                    visited[r] = true;
                    r++;
                } else if(r == len){
                    if(visited[l]) break;
                    arr[l] = arr[j];
                    visited[l] = true;
                    l--;
                } else if(visited[l] && visited[r]){
                    break;
                } else {
                    if(arr[l] < arr[r]){
                        arr[l] = arr[j];
                        visited[l] = true;
                        l--;
                    } else if(arr[l] > arr[r]){
                        arr[r] = arr[j];
                        visited[r] = true;
                        r++;
                    }
                }
                cnt++;
                contaminate++;
            }
        }
        
        int rst = 0;
        for(int a : arr){
            rst += a;
        }
        
        return rst;
    }
}
