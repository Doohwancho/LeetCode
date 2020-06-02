package array;

public class MakeTwoArraysEqualByReversingSubArr1460 {
	
	//<����Ǯ��1>
	
	//�������� ������ ������ ��¼�� �ϸ鼭 ����ũ �ְ��ִµ�
	
	//�� �ʿ���� target�̶� arr�̶� ���� ���ڵ��� ���� �󵵼��� ���Դ����� ���ϸ� ��.
	
	//�ֳĸ� ���� ���ڵ��� �Ȱ��� �󵵼��� �ڼ��� �־, 
	
	//���� �ڸ� �ٲٱ⸦ �밡�ٷ� ��~~~�� ���� �ϸ� ������ �Ȱ��� ���� �� ���ڳ�
	
	//�������� ���ڰ� 1���� 1000���� ���´ٱ׷����ϱ�, 
	
	//int[] ����� 1001�� ���� �󵵼��� ���ϸ� ��.
	
	//Runtime: 1 ms, faster than 98.76% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
	//Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
	
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] c = new int[1001];
        for(int a : arr) c[a]++;
        for(int t : target){
            if(c[t] == 0){
                return false;
            }
            c[t]--;
        } 
        return true;
    }
}
