package julyChallenge;

public class AddDigits {
	
	//<����Ǯ��1>
	
	//Hide Hint #1  
	//A naive implementation of the above process is trivial. Could you come up with other methods?
	
	//�ϴ� "naive"�ϰ� "trivial"�ϰ� �ߴ�. ��©��
	
    public int addDigits(int num) {
        int a = num / 10;
        int b = num % 10;
        
        while(a > 0){
            b = a%10 + b;
            a /= 10;
            a += b/10;
            b %= 10;
        }
        
        return b;
    }
    
    
    //<����Ǯ�� 2 by carlislelee>
    
    //�������� �������� 9���Ǵ°Ŷ� 0 �����ϰ� ������ �ַ��.
    
    //https://en.wikipedia.org/wiki/Digital_root
    
    //����
    
	//[Step 1]:
	
	//438  == 40*10 +3*10 +8 ;
	
	//4+3+8 == 4*(10%9)*(10%9)+3*(10%9)+8%9= 15   ;
	//[Step 2]:
	
	//15  == 1*10 + 5 ;
	
	//1+5 == 1*(10%9)+5%9= 6 ;
	//[So we can see]:
	
	//ab%9%9%9==ab%9; 
	
	//just return num%9; and don't forget num==0 or num==9   
    
    public int addDigits(int num) {
        return 1 + (num-1) % 9;
    }
}
