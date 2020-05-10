package mayChallenge;

public class FindTheTownJudge {
	
	//<����Ǯ��1>
	
	//������� ����޾ƾ� �ϴϱ�, ������������� p[t[1]]++; ���ְ� 
	
	//�� ��������, if(p[i]==N-1)�� ���� ���� ����޾Ҵ��� ������
	
	//�ٵ� judge trusts no one in town�̶�� �����ϱ�
	
	//���� ���� �ٸ�����鿡�� ��� �ŷڹ޾Ƶ�, ������ ���� �ŷ��ϸ� judge�� �ƴ��ݾ�?
	
	//�׷� �� ��� ����ó���� ��� ���� �����ϴٰ�
	
	//�׳� ������ ���� �ŷ��Ҷ� -1ó���� ���ָ�, ��������鿡�� ��� �ŷڸ� �޾Ƶ�, ��������� N-2�� ���״ϱ� �Ƴ�.
	
	//Runtime: 2 ms
	//Memory Usage: 46.8 MB
    public int findJudge(int N, int[][] trust) {
        if(N==1) return 1;
        int[] p = new int[N+1];
        for(int[] t : trust){
            p[t[0]]--;
            p[t[1]]++;
        }
        for(int i = 0; i < N+1; i++){
            if(p[i]==N-1) return i;
        }
        return -1;
    }
}
