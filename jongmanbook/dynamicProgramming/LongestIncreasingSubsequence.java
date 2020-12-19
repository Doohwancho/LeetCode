package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	static int cnt = 0;
	
	//{1,3,4,2,4,10,6}���� longest increasing subsequence�� ���̸� ��ȯ�϶�.
	
	//1. ����Ž��
	
	//O(N^2+N) == O(N^2)
	
	//ans:4
	//loop:21
	
	private static int wholeSearch(int[] test){
		if(test.length == 0) return 0;
		int rst = 0;
		for(int i = 0; i < test.length; i++) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(test[i]);
			for(int j = i+1; j < test.length; j++) {
				if(tmp.get(tmp.size()-1) < test[j]) {
					tmp.add(test[j]);
				}
			}
			if(tmp.size() > rst) {
				rst = tmp.size();
			}
		}
		return rst;
	}
	
	
	//2. memoization
	
	//O(N^2+N) == O(N^2)
	
	//ans:4
	//loop:21
	
	private static int dp(int[] test) {
		if(test.length == 0) return 0;
		int[] mem = new int[test.length];
		for(int i = test.length-1; i >= 0; i--) {
			for(int j = i+1; j < test.length; j++) {
				if(test[j] > test[i]) {
					mem[i] = Math.max(mem[i], mem[j]+1);
				}
			}
		}
		
		int rst = 0;
		for(int ele : mem) {
			rst = Math.max(rst, ele);
		}
		return rst+1;
	}
	
	
	//3. dp
	
	//ans:4
	//loop:18
	
	//1 0 0 0 0 0 0 
	//1 1 0 0 0 0 0 
	//1 1 1 0 0 0 0 
	//1 1 1 0 0 1 0 
	//1 1 2 0 0 1 1 
	//1 3 2 0 1 1 1 
	//4 3 2 1 2 1 1
	
	static int[] S = {1,3,4,2,4,10,6};
	static int[] mem = new int[7];
	
	private static int dp2(int start) {
		if(mem[start] != 0) return mem[start];
		mem[start] = 1;
		for(int next = start+1; next < S.length; next++) {
			if(S[start] < S[next]) {
				mem[start] = Math.max(mem[start], dp2(next)+1);
			}
		}
		return mem[start];
	}
	
	
	//4. dp + optimization
	
	//O(N^2)
	
	//-1 1 -1 -1 -1 -1 -1 -1 
	//-1 1 1 -1 -1 -1 -1 -1 
	//-1 1 1 1 -1 -1 -1 -1 
	//-1 1 1 1 -1 -1 1 -1 
	//-1 1 1 2 -1 -1 1 1 
	//-1 1 3 2 -1 1 1 1 
	//-1 4 3 2 1 2 1 1
	
	static int[] S = {1,3,4,2,4,10,6};
	static int[] mem = new int[8];
	
	private static int dp3(int start) {
		if(mem[start+1] != -1) return mem[start+1];
		mem[start+1] = 1;
		draw(mem);
		for(int next = start+1; next < S.length; next++) {
			if(start == -1 || S[start] < S[next]) {
				mem[start+1] = Math.max(mem[start+1], dp3(next)+1);
			}
		}
		return mem[start+1];
	}
	
	
	//5. binary search
	
	//O(logN * N)
	
	
	//binary search�� �ð����⵵�� O(logN)�� ����
	
	//ù �����Ҷ� ���� �������� N/2
	
	//�ι�° ���� ��, �� ���� �������� 1/2 * N/2
	
	//����° ���� ��, �� ���� �������� 1/2 * 1/2 * N/2
	
	//...
	
	//K�� �����ϸ�, (1/2)^K * N
	
	//�׸��� Ž���� �ݺ��ϴٺ���, Ž���� ������ �������� �־��� ���(ã�� �����Ͱ� ���� ���) ���� �ڷᰡ 1��.
	
	//���� (1/2)^K * N = 1
	
	//���⼭ �纯�� 2^K�� �����ָ�,
	
	//N = 2^K
	
	//�纯�� 2�� ������ ���ϴ� �α׸� �����,
	
	//K = log2N
	
	//���� �ð����⵵�� O(logN)
	
	//ans:4
	//loop:10
	
	private static void insertBS(int[] mem, int val, int limit) {
		int l = 0, r = limit-1;
		while(l < r) {
			int m = (l+r)/2;
			if(mem[m] == val) return;
			else if(mem[m] < val) {
				l = m+1;
			} else {
				r = m;
			}
		}
		mem[l] = val;
	}
	
	private static int binarySearch(int[] test) {
		if(test.length == 0) return 0;
		
		int[] mem = new int[test.length];
		mem[0] = test[0];
		int idx = 0;
		
		for(int i = 0; i < test.length; i++) {
			if(test[i] > mem[idx]) {
				idx++;
				mem[idx] = test[i];
			} else {
				insertBS(mem, test[i], idx);
			}
		}
		
		return idx+1;
	}

	public static void main(String[] args) {
//		int[] test = {1,3,4,2,4,10,6};
		
		Arrays.fill(mem, -1);
		
		System.out.println(dp3(0));
		System.out.println(cnt);
	}
}
