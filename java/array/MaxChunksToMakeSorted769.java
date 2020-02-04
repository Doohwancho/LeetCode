/*
	Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
	
	What is the most number of chunks we could have made?
	
	Example 1:
	
	Input: arr = [4,3,2,1,0]
	Output: 1
	Explanation:
	Splitting into two or more chunks will not return the required result.
	For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
	Example 2:
	
	Input: arr = [1,0,2,3,4]
	Output: 4
	Explanation:
	We can split into two chunks, such as [1, 0], [2, 3, 4].
	However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
	Note:
	
	arr will have length in range [1, 10].
	arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
	
	
	
	
	<����>
	
	arr = [4,3,2,1,0]
	
	�� ����Ʈ�� 0���� arr.size-1������ ���� ������ ����(permutation)�̴�.
	
	���� �� ����Ʈ�� �κ����� �ɰ��ǵ�,                   //[4,3]�� [2,1,0]�� �ɰ��� [4,3,2,1]�� [0]���� �ɰ��� �� ���̰�
	
	�ɰ� ����Ʈ�� �������� û���ؼ� ������� �ٽ� �ٿ��� ��,     //[3,4]�� [0,1,2] -> [3,4,0,1,2]
	
	ó�� �־��� arr�� �������� ���ĵ� �Ͱ� ���� ����� �ʹٸ�,   //[3,4,0,1,2]�� ó�� �־��� arr�� �������� ������ [0,1,2,3,4]�� �ٸ��Ƿ� �̰� �ƴ�.
	
	'�ִ�'�� ��� �ɰ� �� ������?
	
	�������, [1, 0, 2, 3, 4]�� ���,  [1,0]�� [2,3,4] 2���� �ɰ��� ���� �����ؼ� ��ġ�� [0,1,2,3,4]�� ���� �� ������,
	
	[1,0]�� [2] [3] [4] �̷��� '�ִ�'�� �ɰ��� �����ؼ� ���ĵ� [0,1,2,3,4]�� ���� �� �����ϱ�
	
	�� ��� ���� 2�� �ƴ϶� 4�� �ȴ�.
 */
package array;

public class MaxChunksToMakeSorted769 {
	
	//<����Ǯ��1>
	
	//ũ.. �̰���
	
	//[4,3,2,1,0,5] �� ����, ���ڸ� �ɰ��� �������� �����Ϸ���, �ʰ� ����Ʈ ���� ���� ū ���ڰ� ���ڸ��� ������ +1�� ī��Ʈ �ؾ� �Ѵٴ°� �� �� �ִ�.
	
	//4�� 0�� �ڸ��� ���������� ī��Ʈ�� ���ϴٰ�, 4�� 0���ڸ�(index 4)�� ���� �� +1�� ���־�� �Ѵ�. 5�� index 5�������� �׳� +1���ְ�.
	
	//�̰� �̿��� ���.
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Chunks To Make Sorted.
	//Memory Usage: 36.1 MB, less than 10.00% of Java online submissions for Max Chunks To Make Sorted.
	public int maxChunksToSorted(int[] arr) {
        int rst = 0;
        int offMax = -1;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != i){
                offMax = Math.max(offMax, arr[i]);
                if(offMax == i){
                    rst++;
                    offMax = -1;
                }
            } else if(offMax == -1){
                rst++;   
            }  
        }
        return rst;
    }
}
