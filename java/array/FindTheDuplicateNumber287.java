package array;

public class FindTheDuplicateNumber287 {
	
	/*
	//<Trial01>
	
	//�׳� Ǯ�� �̰ű� �ѵ�
	
	//2. You must use only constant, O(1) extra space.
	//3. Your runtime complexity should be less than O(n2).
	
	//�� ���ǿ� �ȸ¾Ƽ� Ʋ��. bitmask�̿��ϴ°ǰ�?
	
	//Arrays.sort()�Ѵ����� binary search...�� 
	
	//1. You must not modify the array (assume the array is read only).
	
	//�� ���ǿ� ��߳���
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
	//Memory Usage: 42.4 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
	
    public int findDuplicate(int[] nums) {
        int[] container = new int[nums.length];
        
        for(int i : nums){
            if(container[i] > 0){
                return i;
            }
            container[i]++;
        }
        return 0;
    }
    */
	
	/*
	//<Trial02>
	
	//������ ���ϱ� 1���� nums.length-1������ ������� ���� �����°� + ������ �ϳ� �ߺ��̴ϱ�,
	
	//1���� nums.length-1������ ���� ��� ���� ���� �ߺ� ����, -�ߺ����� �����°� Ȱ���ϸ� ���� ������?
	
	//[1,2,3,4,2] �̸�, 1���� n������ ������ (1+2+3+4)�ؼ� 10�ε�, �� ����Ʈ�� ������ 12�̴ϱ�, 10-12�ϸ� -2, ���� -(-2)�ϸ� ���� ������?
	
	//Input : [2,2,2,2,2]
	//Output : 0
	//Expected : 2
	
	//�ߺ����� �̻ڰ� 2���� ������ �Ǵµ�, 2������ �� ���� ���ö� �ȸ��� ����.
	
	public int findDuplicate(int[] nums) {
        if(nums.length == 2) return nums[0];
        
        int total = (1+nums.length-1)*((nums.length-1)/2);
        
        for(int i : nums){
            total -= i;
        }
        return -total;
    }
    */
	
	/*
	//<����Ǯ��1 by qgambit2>
	
	//�ȶ�����
	
	//���ڰ� 1���� n���� �����ϴµ�, �� ���ڸ� bitmask�� �ε��� ���, 1�̸� 0000 0010, 3�̸� 0000 1000, �̷������� ó���ϴµ�,
	
	//XOR����� �Ἥ, �����Ŷ� �ٸ���(���ο�Ÿ�) �����س���. 1������ 3�� ���ԾƸ�, 0000 1010�� �ǰ���.
	
	//java.math.BigInteger�� �� ������, 0000 0000�̰� 2�� 7�±����ۿ� ����� ���ϴϱ�, ���Ѵ���� �����ִ� java.math.BigInteger�� ��.
	
	//�׷��� for���� ���ٰ� ���� ���� �ߺ��ؼ� ������, XOR������ �ش� �ڸ��� 0�̵Ǿ� ���� �پ������.
	
	//�� ��, test1.compareTo(test)�� �̿��ؼ�, �ش� ���ڸ� ��ȯ��.
	
	//�ȶ��ϱ��� �ⷡ
	
	//���� ���ǿ� �ȸ´°� ���� ������ ��������.
	
	//Runtime: 120 ms, faster than 5.05% of Java online submissions for Find the Duplicate Number.
	//Memory Usage: 43.3 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
	
    public int findDuplicate(int[] nums) {
        java.math.BigInteger test = new java.math.BigInteger("0");
        
        for (int n:nums){
            java.math.BigInteger twoPowN = new java.math.BigInteger("2").pow(n);
            java.math.BigInteger test1 = test.xor(twoPowN);
            
            if (test1.compareTo(test) < 0){
                return n;
            }
            test = test1;
        }
        return 0;
    }
    */
    
	/*
    //<����Ǯ��2 by pratik_patil>
    
    //Floyd's Cycle Detection Algorithm
	
	//The idea is to consider array items as linked list nodes. Any particular index is pointing to the value at that index, like index -> A[index] -> A[A[index]] and so on.
	//For example- given array is A = [1, 2, 3, 4, 5, 6, 3]. In case of duplicate, two indexes will have same value and they will form a cycle just like in the image given below: So we can find the entry point of cycle in the linked-list and that will be our duplicate element.

	//https://leetcode.com/problems/find-the-duplicate-number/discuss/222352/Java-Solutions
	
	//Algorithm:
	
	//1. We maintain two pointers fast and slow
	//2. For each step fast will move to the index that is equal toA[A[fast]] which is two steps at a time and slow will move to the index A[slow] which is one step at a time. Eventually, fast and slow will meet in a cycle and the entry point of that circle will be the duplicate element.
	//3. When fast == slow that means now we are in a cycle.
	//4. Now we need to find entry point so we will start with slow = 0 and visit one step at a time for both fast and slow. When fast == slow that will be entry point.
	//5. Return the entry point.
	
	//Time complexity: O(n)
	//Space Complexity: O(1)
    
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
    //Memory Usage: 42.8 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
    
    public int findDuplicate(int[] a) {
        int s = 0, f = 0;
        
        //First we need to find an entry where the index and nums[index] is not the same, so that we can get into the chain;
        do {
            s = a[s];
            f = a[a[f]];
        } while(s != f);
        
        //1 -> 3 -> 2 -> 4 
        //3 -> 4 -> 4 -> 4
        
        //Once we are in the chain, nums[index] is very similar with ListNode.next operation. So by setting a fast and a slow pointer, we can find where the loop begins just like we did with the linked list.
        s = 0;
        while(s != f) {
            s = a[s];
            f = a[f];
        }

        //0 -> 1 -> 3 -> 2
        //4 -> 2 -> 4 -> 2
        
        return s;
    }
    */
	
	//<����Ǯ��3 by pratik_patil>
	
	//The idea is when visiting a number i, flip the number at index i - 1 to negative. 
	//If the number at index i - 1 is already negative, then i is the number that occurs more than once.
	
	//Time complexity: O(n)
	//Space complexity: O(1)
	
	//�ٵ� ���� 1. You must not modify the array (assume the array is read only)�� �ش����� �ʳ�.
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
	//Memory Usage: 42.9 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
	
	public int findDuplicate(int[] A)
    {
		//[1,3,4,2,2]
		
		//i = 0, index = 0, A[0] = 0, [0,3,4,2,2]
		//i = 1, index = 2, A[2] = -4, [0, 3, -4, 2, 2]
		//i = 2, index = 2, A[2] < 0, return 2
		//i = 3,
		//i = 4,
		
        for(int i = 0; i < A.length; i++) 
		{
			int index = Math.abs(A[i]) - 1;

			if(A[index] < 0)
				return index + 1;
            else
			    A[index] = -A[index];
		}
        return -1;
    }

}
