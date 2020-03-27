package array;

import java.util.Arrays;

public class AdvantageShuffle870 {

	/*
	//<Trial01>
	
	//������ A[i] > B[i]���� �Ѵٴµ�,
	
	//tr.ceiling�� A[i] >= B[i]�ΰ� �̾Ƴ��� ����
	
	//���� TreeSet�� �ߺ��� ���� ó�� ���ؼ� ����.. set�̴ϱ�..
	
	public static int[] advantageCount(int[] A, int[] B) {
        TreeSet<Integer> tr = new TreeSet<>();
        for(int a : A) tr.add(a);
        
        int[] rst = new int[A.length];
        int i = 0;
        
        for(int b : B){
        	int num = tr.ceiling(b) != null ? tr.ceiling(b) : tr.pollFirst();
            rst[i++] = num;
            tr.remove(num);
        }
        return rst;
    }
    */
	
	/*
	//<����Ǯ��1 by lee215>
	
	//treeset��� treemap����
	
	//treemap�� treeset�� �޼ҵ� .ceiling()���� �ٸ���
	
	//greater�� �Ǵ� �޼ҵ��� .higherKey�� �ֱ���
	
	//Runtime: 94 ms, faster than 13.23% of Java online submissions for Advantage Shuffle.
	//Memory Usage: 42.5 MB, less than 83.33% of Java online submissions for Advantage Shuffle.
    public static int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i : A) m.put(i, m.getOrDefault(i, 0) + 1);
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            Integer x = m.higherKey(B[i]);
            if (x == null) x = m.firstKey();
            m.put(x, m.get(x) - 1);
            if (m.get(x) == 0) m.remove(x);
            res[i] = x;
        }
        return res;
    }
    */
	
	//<����Ǯ��2 by WHJ425>
	
	//explaination for (a, b) -> (B[a] - B[b]) ?
	
	//same as compare();
	
	//new Comparator<Integer>() {
	//    @Override
	//    public int compare(int a, int b) {
	//        return B[a] - B[b];
	//    }
	//}
	
	//Runtime: 28 ms, faster than 89.23% of Java online submissions for Advantage Shuffle.
	//Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Advantage Shuffle.
	public static int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        
        Integer[] bIdxArr = new Integer[B.length];
        for (int i = 0; i < bIdxArr.length; i++) {
            bIdxArr[i] = i;
        }
        Arrays.sort(bIdxArr, (a, b) -> (B[a] - B[b])); //B�� �������� ������� �ε����� ǥ��

        int[] res = new int[A.length];
        
        for (int idxA = 0, idxB = 0, r = res.length - 1; idxA < A.length; idxA++) {
            if (A[idxA] > B[bIdxArr[idxB]]) {
                res[bIdxArr[idxB]] = A[idxA]; //res�� ������� 0���� �������� �״°� �ƴ϶� B�� �������� �ε����� �°� A�� ����
                idxB++;
            } else {
                res[bIdxArr[r]] = A[idxA]; //���� B���� �� ū A�� ������ �� �ں��� ���ų���. ��¥�� ���� �����ص� �����ٰ� �����ϱ�.
                r--;
            }
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		int[] A = {12,24,8,32};
		int[] B = {13,25,32,11};
		System.out.println(advantageCount(A,B));
	}
}
