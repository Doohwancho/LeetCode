package augustChallenge;

public class ImplementRand10UsingRand7 {
	

	//<����Ǯ��1 by lee215>
	
	//fourty = (rand7()-1)*7;
	
	//�� �ص�, ���ڴ� �ִ� 42���� ���ͼ� ���� ������? ��� ������ �ߴµ�,
	
	//1-> 0 -> 0       ->  1
	//2-> 1 -> 7       ->  8
	//3-> 2 -> 14      ->  5
	//4-> 3 -> 21      ->  2  
	//5-> 4 -> 28      ->  9
	//6-> 5 -> 35      ->  6
	//7-> 6 -> 42 -> 39 -> 10
	
	//evenly distributed ���� �ʾƼ� pass�ȵ�.
	
	//3,4,7�� �ȳ���.
	
	//���� (rand7()-1)*7 + (rand7()-1); ���� �ϴ� ������, 
	
	//���� ����° �ٿ� ������ 0~6���� �����ָ� ��� ���ڰ� Ŀ���Ǳ� ����.
	
	//�ι�° (rand7()-1) ��Ʈ�� ��¥ �������� �����ϴ� ������ �ϰ�
	
	//ù��° (rand7()-1)*7 ��Ʈ�� 0~42���� Ʋ�� ����� ������ �Ѵٰ� ���� ��
	
	//Runtime: 5 ms
	//Memory Usage: 45 MB
	
    public int rand10() {
        int fourty = Integer.MAX_VALUE;
        while(fourty >= 40){
            fourty = (rand7()-1)*7 + (rand7()-1);
        }
        return fourty%10+1;
    }
}
