/*
	Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
	
	Return the minimum size of the set so that at least half of the integers of the array are removed.
	
	 
	
	Example 1:
	
	Input: arr = [3,3,3,3,5,5,5,2,2,7]
	Output: 2
	Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
	Possible sets of size 2 are {3,5},{3,2},{5,2}.
	Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
	Example 2:
	
	Input: arr = [7,7,7,7,7,7]
	Output: 1
	Explanation: The only possible set you can choose is {7}. This will make the new array empty.
	Example 3:
	
	Input: arr = [1,9]
	Output: 1
	Example 4:
	
	Input: arr = [1000,1000,3,7]
	Output: 1
	Example 5:
	
	Input: arr = [1,2,3,4,5,6,7,8,9,10]
	Output: 5
	 
	
	Constraints:
	
	1 <= arr.length <= 10^5
	arr.length is even.
	1 <= arr[i] <= 10^5
	
	
	
	
	<����>
	
	arr = [3,3,3,3,5,5,5,2,2,7]
	
	���⼭ Ư�� ���ڸ� ������ ��ü�� ���� �� �ִ�(ex. 3�� �����ϸ� [5,5,5,2,2,7], 3�� 7�� �����ϸ� [5,5,5,2,2]),
	
	Ư�� ����(or ���ڵ�)�� �����Ͽ� �ּ� ���� arr�������� ���� �̻��� ������ �Ѵٸ�, ������ �ϴ� ������ �ּҰ����� ��ȯ�϶�. 
 */
package array;

import java.util.Arrays;

public class ReduceArraySizeToTheHalf1342 {
	
	//<����Ǯ��1>
	
	//	Constraints:
	//1 <= arr.length <= 10^5
	//arr.length is even.
	//1 <= arr[i] <= 10^5
	
	//���⼭ arr�� ������ 1���� 10^5������� ���� �̿��� ������ 100001¥�� ����Ʈ�� �����.
	
	//arr�� for�����鼭 ������ �󵵼��� ������ 100001¥�� ����Ʈ�� ����ϰ�
	
	//Arrays.sort()�� �Ͽ�, �������������ؼ� ���� �󵵼��� ū ���� �� �ڷ� ������ ����.
	
	//���� �󵵼��� ū ���ں��� �ϳ��� ���ذ��鼭 arr.size/2���� ���ų� ū�� Ȯ��.
	
	//arr.size/2���� ���ų� ū�� �������ϴ� �ּҼ��ڹǷ�, 100001-i�� ��ȯ.
	
	//Runtime: 24 ms, faster than 100.00% of Java online submissions for Reduce Array Size to The Half.
	//Memory Usage: 56.5 MB, less than 100.00% of Java online submissions for Reduce Array Size to The Half.
	
    public int minSetSize(int[] arr) {
        int minSize = arr.length/2;
        int[] container = new int[100001];
        for(int element : arr){
            container[element]++;
        }
        Arrays.sort(container);
        
        for(int i = 100001-1, rst = 0; i >= 0; i--){
            rst += container[i];
            if(rst >= minSize){
                return 100001-i;
            }
        }
        return minSize;
    }

}
