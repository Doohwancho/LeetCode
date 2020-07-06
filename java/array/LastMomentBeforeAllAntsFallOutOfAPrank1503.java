package array;

public class LastMomentBeforeAllAntsFallOutOfAPrank1503 {
	
	//<����Ǯ��1>
	
	//��ģ
	
	//��� ant�� ���Ƽ� ���� �ȵǴϱ�, �΋H���� �ٸ��������� ���ٴ°� �����ϰ�
	
	//�ѹ������θ� �ٰܴ� �����ϸ�, �������κ��� �� �ָ��ִ� ���� �Ÿ��� �˸� ����.
	
	//���� �볪 �����ϰ� �����߾����� 
	
	//[left, x, x, left, x, right]
	
	//���� ������, �ι�° left�� right�� �ѹ� 
	
	//��!
	
	//�ϰ� �ðܼ� ���ٰ� ù��° left�� ��
	
	//��!
	
	//�ϸ�, game of lifeó�� �� state�� int[]a, int[]b �� �Դٰ����ϸ鼭 ǥ������� �ϳ� ����߾��µ�
	
	//�ȱ״�� �Ǵ°�
	
	//[left, x, x, left, x, right]  = 1
	
	//[x, left, x, left, ��!, right] = 2
	
	//[x, left, ��!, left, x, x] = 3,4 (�̶� ���� left�� ������ left�� �Űܰ��ٰ� �����ϼ�)
	
	//[left, x, x, x, left, x] = 5
	
	//[x, x, x, x, x, left] = 6
	
	//iterate = 6
	
	//�� �ð��� �����°� �����ϰ� ������ ���ٰ� �����ص� �Ȱ���
	
	//https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/discuss/720313/C%2B%2B-Python-Java-Beautiful-Visual-Explanation
	
	//���� �׸����� ���ذ� �� ��
	
	
	//time O(n)
	//space O(1)

	//Runtime: 1 ms, faster than 100.00% of Java online submissions for Last Moment Before All Ants Fall Out of a Plank.
	//Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Last Moment Before All Ants Fall Out of a Plank.
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int i: left)
            res = Math.max(res, i);
        for (int i: right)
            res = Math.max(res, n - i);
        return res;
    }
}
