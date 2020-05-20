package array;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR1442 {

    
    //<����Ǯ��1 by Admin007>
	
	//i<j������ xor�� a�̰�,
	
	//j<=k������ xor�� b�϶�
	
	//a==b�� ������ ã�°��ݾ�?
	
	//�ٵ� a==b���, a^b == 0�̰���?
	
	//�������ڸ� xor�ϸ� 0���ݾ�. ���� bitmask�� digit�� 0�̵Ǵϱ�. 
	
	//�������, 3^3 = 0�̰�, 15243^15243 = 0�̴ϱ�.
	
	//�׷� xor==0��Ʈ�� ���ذ� ��
	
	//�ٵ� j-i��Ʈ��? ��?
	
	//1,3,2 �� �ִٰ� ġ��.
	
	//�׷� (1),(3,2)��
	
	//(1,3)(2) �ΰ��� ����?
	
	//1�̶� (3,2)�� ���� ����, 3^2 = 1�̿���, 1^1 = 0����.
	
	//(1,3)�̶� 2�� ����, 1^3�� 2��, 2^2=0����.
	
	//�׷��ϱ�, i���� j������ ���ڵ��� xor���� ��, �� ���̸� ������� �������� a==b�� �����Ǳ� ������, j-i�� �����ִ°�.
	
	//a^b^c^d^e = 0�̶��,
	
	//�곻�� �ѷ� �ɰ�����, 
	
	//a = b^c^d^e �̰�,
	
	//a^b = c^d^e �̰�,
	
	//a^b^c = d^e �̰�,
	
	//a^b^c^d = e ��.
	
	//�ֳĸ�, =�� ���ʾֵ��̶� =�� �����ʾֵ��̶� ���ƾ� ���� ^������ 0�̵ɰžƳ�.
	
	//�׷��ϱ� e�� �ε����� 4���� a�� �ε����� 0�� �� 4�� �����ִ°Ű�. �̰� j-i.
    
    //Runtime: 2 ms, faster than 78.67% of online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
    //Memory Usage: 38.9 MB, less than 100.00% of online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
    
    //Give the observation: For all pairs of i and k, where arr[i] ^ arr[i + 1] ^ ... ^ arr[k] = 0, 
    //then any j (i < j <= k) will be good to set as the answer 
    //(hint: proof by contradiction, if you cannot understand this trick immediately). 
    //So you just need to find all segments where XOR equals zero.
    
    public int countTriplets(int[] arr) {
        int ans = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    ans += (j - i);
                }
            }
        }
        return ans;
    }
}
