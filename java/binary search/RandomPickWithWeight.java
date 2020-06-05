package juneChallenge;

public class RandomPickWithWeight {

	//<Trial01 - memory limit exceeded>
	
	//���� ������ �����Ƽ� �ϴ� �������� ��ũ ����
	
    //question explained
    
    //https://leetcode.com/problems/random-pick-with-weight/discuss/671445/Question-explained
	
	//w[i]/total �� Ȯ���̶� �׷����ϱ�,
	
	//total ũ�⸸ŭ�� int[]�� �����, i�� weight�� w[i]��ŭ i�� ��ܳ��� ������
	
	//�������� 0���� total-1������ ���ڸ� Math.random()�Լ��� �̾Ƽ�, �װ� �ε��� ��� ���� ã������ ������,
	
	//���� ��ǲ�� 18���� ���� ������
    
    int[] a;
    int total = 0;
    
    public Solution(int[] w) {
        for(int w_ : w){
            total += w_;
        }
        a = new int[total]; 
        
        for(int i = 0, j = 0, accum = 0; i < w.length; i++){
            while(j < total && j < (w[i]+accum)){
                a[j] = i;
                j++;
            }
            accum = j;
        }
    }
    
    public int pickIndex() {
        double dValue = Math.random();
	    int iValue = (int)(dValue * total);
        return a[iValue];
    }
    
    
    //<����Ǯ��1>
    
    //binary search
    
    //trial01���� total���ϰ� w[i]/total�� Ȯ���� ���°Ͱ� 
    
    //double dValue = Math.random();�̶� int iValue = (int)(dValue * total); ���°� �´ٰ� �����ؼ� ŵ��
    
    //int[]�� ����� �ʹ� Ŀ���� ����
    
    //��� totalũ���� int[]�� �ƴ϶�, w�� ���� �������� int[]�ε� �߿䵵�� �������� �״� int[]�� ����
    
    //�������, ��ǲ�� [1,3,1]�̶��,
    
    //int[] a�� [1,4,5]�� �Ǵ°���. �߿䵵�� �������� ���ڳ�
    
    //�ϴ� Math.random()���� 0���� 4(5-1)������ ������ iValue�� ��������, 
    
    //binary search�� [1,4,5]���� ã��.
    
    //iValue�� 3�̶�� �غ���.
    
    //3�� [1,4,5]���� ã�µ�, a[m]�� 4��? �ٵ� 4�� 3���� ũ�ϱ� �ϴ� ��ĭ ����
    
    //�׷� 1����? �׷� 3�� 0~1�� ������ ������ �ȵǴϱ� ��ĭ �ø�
    
    //�׷� l = 1�̵ǰ�, r�� 1�λ��´ϱ�, l<r�� ������ �ȵǼ� while���� ������ l�� ��ȯ�ϸ�, �츮�� ã�� 1�� ����.
    
    //Runtime: 22 ms
    //Memory Usage: 43.4 MB
    
    int total = 0;
    int[] a;
    
    public Solution(int[] w) {
        a = new int[w.length];
        
        for(int w_ : w){
            total += w_;
        }
        
        for(int i = 0, j = 0; i < w.length; i++){
            a[i] = w[i] + j;
            j = a[i];
        }
    }
    
    public int pickIndex() {
        double dValue = Math.random();
	    int iValue = (int)(dValue * total);
        int l = 0, r = a.length;
        while(l<r){
            int m = (l+r)/2;
            if(a[m] > iValue){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
