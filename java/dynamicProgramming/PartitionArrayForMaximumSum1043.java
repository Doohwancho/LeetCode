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
	
	//�� �ƴϾ�~
	
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
    
    
    //<����Ǯ��1 by lee215, explained by tianchi-seattle>
    
    // Let k be 2
    // Focus on "growth" of the pattern
    // Define A' to be a partition over A that gives max sum
    
    // #0
    // A = {1}
    // A'= {1} => 1
    
    // #1
    // A = {1, 2}
    // A'= {1}{2} => 1 + 2 => 3 X
    // A'= {1, 2} => {2, 2} => 4 AC
        
    // #2
    // A = {1, 2, 9}
    // A'= {1, 2}{9} => {2, 2}{9} => 4 + 9 => 13 X
    // A'= {1}{2, 9} => {1}{9, 9} => 1 + 18 => 19 AC
    
    // #3
    // A = {1, 2, 9, 30}
    // A'= {1}{2, 9}{30} => {1}{9, 9}{30} => 19 + 30 => 49 X
    // A'= {1, 2}{9, 30} => {2, 2}{30, 30} => 4 + 60 => 64 AC
    
    // Now, label each instance. Use F1() to represent how A is partitioned and use F2() to represent
    // the AC value of that partition. F2() is the dp relation we are looking for.
    
    // #4
    // A = {1, 2, 9, 30, 5}
    // A'= F1(#3){5} => F2(#3) + 5 => 69 X
    // A'= F1(#2){30, 5} => F2(#2) + 30 + 30 => 79 AC
    // => F2(#4) = 79
    
    
    
    
    //Runtime: 5 ms, faster than 79.03% of Java online submissions for Partition Array for Maximum Sum.
    //Memory Usage: 38.7 MB, less than 50.26% of Java online submissions for Partition Array for Maximum Sum.
    
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }
    
    
}
