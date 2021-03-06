package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum15 {

	
	//<Trial01>
	
	//binary search稽 嬢胸惟 走走壱 査紹澗汽 設 照鞠革
	
	//掻差坦軒 嬢追馬澗走 乞牽惟魚たた
	
	//-4,-1,-1,0,1,2
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rst = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int l = j + 1, r = nums.length;
				while (l < r) {
					int m = (l + r) / 2;
					if(nums[m] + nums[i] + nums[j] == 0) {
						l = m;
						break;
					}
					if ((nums[m] + nums[i] + nums[j]) > 0) {
						r = m;
					} else {
						l = m+1;
					}
				}
				if(l < nums.length && nums[l] + nums[i] + nums[j] == 0) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					tmp.add(nums[l]);
					rst.add(tmp);
					System.out.println(rst);
				}
				if (nums[i] == nums[j]) { //掻差坦軒 嬢追馬猿たたたたたた
                    int comp = nums[j];
                    while(j < nums.length && nums[j] == comp){
                        j++;
                    }
                    i = j-1;
					break;
				} 
				
			}
		}
		return rst;
	}
	
	//<庚薦熱戚1 by shpolsky>
	
	//binary search
	
	//貝 3腰属 据社幻 binary search処澗汽 城 砧腰属 室腰�� 却陥 binary search稽 達革
	
	//Runtime: 18 ms, faster than 89.77% of Java online submissions for 3Sum.
	//Memory Usage: 43.3 MB, less than 73.68% of Java online submissions for 3Sum.
	public List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	    	if(num[i] > 0) break;   //nums[i]亜 丞呪虞澗闇, num戚 神硯託授 舛慶戚 �膠� 凶庚拭, 砧腰属, 室腰属 据社亜 却陥 丞呪空 剰奄艦猿 瑳 琶推 蒸製. break. by zizizi
	        if (i == 0 || num[i] != num[i-1]) { //湛腰属 据社税 掻差坦軒. 
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++; //砧腰属 据社税 掻差坦軒
	                    while (lo < hi && num[hi] == num[hi-1]) hi--; //室腰属 据社税 掻差坦軒
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}
}
