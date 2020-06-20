package juneChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

	// <Trial01>

	//���ڸ� k/factorial(n-1)�� � �ִ°ͱ��� ��µ�, �������� �ȵ� �����?

	public int factorial(int n) {
		if (n <= 1)
			return n;
		else
			return factorial(n - 1) * n;
	}

	public String getPermutation(int n, int k) {
		StringBuilder rst = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			list.add(i);

		while (n > 0) {
			int fn = factorial(n - 1); // �� ����Ŭ�� ����� �ʿ�����?

			if (fn <= 0) {
				rst.append(list.get(0));
				list.remove(0);
			} else if (k % fn > 0) {
				rst.append(list.get(k / fn));
				list.remove(k / fn);
				k %= fn;
			} else {
				rst.append(list.get(k - 1));
				list.remove(k / fn - 1);
				k %= fn;
			}

			n--;
		}
		return rst.toString();
	}

	// <����Ǯ��1 by mo10>

	// Runtime: 3 ms
	// Memory Usage: 37.2 MB

	public String getPermutation(int n, int k) {

		LinkedList<Integer> notUsed = new LinkedList<Integer>();

		int weight = 1;

		for (int i = 1; i <= n; i++) {
			notUsed.add(i);
			if (i == n)
				break;
			weight = weight * i;
		}

		String res = "";
		k = k - 1;        //�̰� ��Ʈ¼�� ��Ʈ��. k/fn������ 2/2��, 0�� ���ߴµ� ��� 1�̳��ͼ� ��� ���� ����ߴµ�, k-1�� �ؼ� �ع����� 0��. ���� k�� ���� 4�� fn�� 2���ٰ� �ص�, 3/2�ϸ� 1���ݾ�. 2�� �ƴ϶�. � ���� �����ϱ� ��Ƴ� �Ͽ�ư k-1�� �����ν� Trial01���� if~if else~else�� �����ϴ°� ���ص� ��
		while (true) {
			res = res + notUsed.remove(k / weight);
			k = k % weight;
			if (notUsed.isEmpty())
				break;
			weight = weight / notUsed.size();
		}

		return res;
	}
	
	
	//<Trial02>
	
	//����Ǯ��1���� ����һ��Ϸ�.
	
	//Runtime: 1 ms
	//Memory Usage: 37.1 MB
	
    public int factorial(int n) {
        if (n <= 1) return n;	
		else return factorial(n - 1) * n;
	}

	public String getPermutation(int n, int k) {
		StringBuilder rst = new StringBuilder();
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) list.add(i);
        k--;
        
		while (n > 0) {
			int fn = factorial(n - 1); 
            if(fn == 0){
                rst.append(list.remove(0));
                if(list.isEmpty()) break;
            } else {
                rst.append(list.remove(k / fn));
                k %= fn;
            }
            n--;
		}
		return rst.toString();
	}
}
