package array;

public class GrumpyBookstoreOwner1052 {
	
	/*
	//<����Ǯ��1>
	
	//step01 - customers�� �������� ���������� container��� ����Ʈ�� �ִ´�. ex) {1,2,3,4,5} -> container = {1,3,6,10,15}
	//container�� i��°�� ���� 1���� i��° �������� ���̴�.   ex) i == 4 && X == 3, 1~i�� ����  container[i] == 15
	//���⼭ i-X��°������ ���� ����,  ex) i-X�� 1�� ���ָ�, container[i] - container[i-X] == container[4] - container[1] == 15 - 3 == 12
	
	//step02 - grumpy�� 0�϶��� customers���� �� ���� ���Ѵ�.(==total)
	
	//step03 - total���� step01���� ���ߴ� �������� ���Ѱ��� ���� ū ���� Math.max()�� �����ִµ�, �� ��, grumpy�� 0�϶��� customer[i]���� �̹� total�� ���������Ƿ�, �� �κ��� step01���� ���� ������ ���ش�.
	
	//Runtime: 456 ms, faster than 8.86% of Java online submissions for Grumpy Bookstore Owner.
	//Memory Usage: 42.9 MB, less than 100.00% of Java online submissions for Grumpy Bookstore Owner.
	
	public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
		//step01
		int[] container = new int[customers.length];
        
        for(int i = 0, sum = 0; i < customers.length; i++){
            container[i] = customers[i];
            int tmp = container[i];
            container[i] += sum;
            sum += tmp;
        }
         
        //step02
        int total = 0;
        int rst = 0;
        
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                total += customers[i];
            }
        }
        
        //step03
        for(int j = 0; j < container.length; j++){
            if(j >= (X-1)){
                int j_ = j;
                if(j >= X){
                    int num = container[j]-container[j-X];
                    while(j_ > j-X){
                        if(grumpy[j_] == 0){
                            num -= customers[j_];
                        }
                        j_--;
                    }
                    rst = Math.max(rst, total + num);
                    
                } else {
                    int num = container[j];
                    while(j_ >= 0){
                        if(grumpy[j_] == 0){
                            num -= customers[j_];
                        }
                        j_--;
                    }
                    rst = Math.max(rst, total + num);
                }
            }
        }
        
        return rst;
    }
	*/
	
	//<����Ǯ��2 by rock>
	
	//��ģ���� ���� 456ms�ɸ��°� 3ms�� Ǫ��
	
	//��Ÿ 5��9��
	
	//for�� �ѹ����� ��ť�� �ذ��ع�����
	
	//grumpy�� 0�ΰ� ��� ���ϰ�,
	
	//1�̶��� ���ܵǴ°͵� win�̶�� ������ ��� ���ϴٰ�, X�� �̻� ���ϸ�, �� loop���� ���� grumpy1�� ���� ���ʰ��� ������ �ִ� ���.
	
	//�� win���� �ִ��� ���� grumpy0�� ���� ���ϸ� ��.
	
	//Runtime: 3 ms, faster than 88.28% of Java online submissions for Grumpy Bookstore Owner.
	//Memory Usage: 43.3 MB, less than 100.00% of Java online submissions for Grumpy Bookstore Owner.
	
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
       int satisfied = 0, maxMakeSatisfied = 0;
       for (int i = 0, win = 0; i < grumpy.length; ++i) {
           if (grumpy[i] == 0) { satisfied += customers[i]; }
           else { win += customers[i]; }
           if (i >= X) { // window's size > X.
               win -= grumpy[i - X] * customers[i - X]; // to maintain the size as X, remove unsastified customers from left end of the window.
           }
           maxMakeSatisfied = Math.max(win, maxMakeSatisfied);
       }
       return satisfied + maxMakeSatisfied;
   }
	
	public static void main(String[] args) {
		int[] customers = new int[] {1,0,1,2,1,1,7,5};
		int[] grumpy = new int[] {0,1,0,1,0,1,0,1};
		int X = 3;
		System.out.println(maxSatisfied(customers, grumpy, X));
	}
}
