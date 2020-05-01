package mayChallenge;

public class FirstBadVersion {

	//<����Ǯ��1>
	
	//binary search
	
	//���� binary search�� �������� ���ĵ� ���� �迭���� ���µ�, 
	
	//{false,false,false,true,true,true,true} ����
	
	//� ������ �ݺ��Ǵٰ� �ٸ� ����2�� �Ѿ�� ��輱�� ã������ �� �� �ִ�.
	
	//binary search��°� {1,2,3,4,5}���� 2�� �ε����� ã�´ٰ� ġ��, ������ �� �߶�
	
	//��� �ִ� 3�� ����, ���? 2���� ũ��? �׷��� ���� ����(left~right)���� right�� 3�� �ε���-1�� ������ �� �ٽú��� �ڴ�
	
	//��� �ؼ� �ι�° ���� left~right�� index 0~index1�� �ǰ�, �ش� ������ ��� ���� �ְ� �츮�� ã�� �������� Ȯ���ϰ�,
	
	//�ƴ϶�� �ٽ� �ڸ� �ݿ��� �� ���� �ڸ��°� ã�������� �ݺ��ϴ� �ǵ�.
	
	//�� ��쵵, true�� right�� ��ĭ �������� ���ܼ� �ٽ� �� ���ٰ�
	
	//false�� ������ �̹��� left�� ��ĭ ���������� ���ܼ� �ٽ� ã�°� �ݺ��ϴ°�.
	
	//l==r�� �ɋ�����.
	
	//�׷��� �������� l�� true���� ���� ù��° �ε����� ����Ű�� �Ǿ��ִ�.

	//22 / 22 test cases passed.
	//Status: Accepted
	//Runtime: 12 ms
	//Memory Usage: 35.9 MB
	
	public int firstBadVersion(int n) {
        int l = 0, r = n, m;
        while(l <= r){
            m = l + (r-l)/2; //(l+r)/2�� �ߴµ� testcase���� l+r�� Integer.MAX_VALUE�� �ʰ��ϴ� ��츦 ����ؼ�, �̷��� ����.
            if(isBadVersion(m)==true) r = m-1;
            else l = m+1;
        }
        return l;
    }
}
