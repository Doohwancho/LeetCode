package september;

import java.util.HashSet;
import java.util.Set;

public class BullsAndCows {

	//<Trial01>
	
	//"1122"
	//"1222"
	
	//�̷��� ���� ��,
	
	//"3A0B"���;� �Ǵµ�,
	
	//"3A1B"�̷��� ������ ��츦 ����ϴ°� �ٽ�.
	
	//�ϴ� �� �����ϰ�, secret = "112", guess = "122"��� ġ��.
	
	//secret "112"�� int[]�� ������ [0,2,1, ...]����?
	
	//�̰� for������ iterate�� ��,
	
	//ù������ 1�Ѱ� ��� a++����. �׷�, [0,1,1] a=1����?
	
	//2������ b�Ѱ� ��� b++����. �׷�, [0,1,0] a=1, b=1����?
	
	//�̹����� �߿���.
	
	//3������ 2�Ѱ� ��� a+1�ؾ��ϴµ� �̹� �����ְ� �Ծ���?
	
	//�츰 bī��Ʈ�ι� a�� �켱������ �ؾ����ݾ�? �״ϱ�
	
	//secret(i) == guess(i)�� ��쿡 (������ �ε���2�� �Ѵ� 2)
	
	//�̹� ī��Ʈ �� ������ 0�� �����(== ������ b�� ����ä���ٸ�)
	
	//b-1�� ���ְ� a+1����.
	
	
	
	
    public String getHint(String secret, String guess) {
        int[] digit = new int[10];
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        
        for(char c : secret.toCharArray()){
            digit[c-'0']++;
        }
        
        Character s = null;
        Character g = null;
        
        for(int i = 0; i < secret.length(); i++){
            s = secret.charAt(i);
            g = guess.charAt(i);
            if(s==g){
                a++;
                if(digit[s-'0'] == 0){ //������ b�� �̹� ����ä������, ���ϼ��� �ִ¾��� a�� �켱�õǾ�� �ϱ� ������
                    b--;  //b�� �ϳ� ���ְ� a�� �Ű���.
                } else {
                    digit[s-'0']--;
                }
                
            } else if(digit[g-'0'] > 0){
                b++;
                digit[g-'0']--;
            }
        }
        if(a > 0){
            sb.append(a);
            sb.append("A");    
        } else {
            sb.append("0A");
        }
        if(b > 0){
            sb.append(b);
            sb.append("B");    
        } else {
            sb.append("0B");
        }
        
        return sb.toString();
    }
}
