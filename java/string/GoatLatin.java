package augustChallenge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GoatLatin {
	
	//<����Ǯ��1>
	
	//self-explanatory
	
	//improvement point 1)
	//set.add()�ִ°� 10�� ���ٷ� ���̱� ����.
	//for(char c : "aeiouAEIOU".toCharArray()) set.add(c);
	//�̷���. 10��->1��. ��2��
	
    //set�����̶� �ƿ��̿��� �ִ°� ���ٷ� ���� �� �ֱ� ��.
    //Set<Character> set = "aeiouAEIOU".chars().mapToObj(e -> (char)e).collect(Collectors.toSet()); 
    //�ٵ� 12ms���ͼ� ���� ������.
	//������
	//�� ����
	
	
	//improvement point 2)
	//step1�̶� 2�� 10���� �Ѿ�µ�, ���ٷ� ���డ��
	//sb.append(set.contains(s.charAt(0)) ? s+"ma" : s.substring(1)+s.charAt(0)+"ma");
	//�ٵ� string+string�̶� ������ ������.
	//stringbuilder���°� �ǰ�
	
	//Runtime: 4 ms
	//Memory Usage: 38.2 MB
	
	public String toGoatLatin(String str) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        
        
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for(String s : str.split("\\s")) {
        	
            //1 - vowel : add "ma" at the end
            if(set.contains(s.charAt(0))){
                sb.append(s);
                sb.append("ma");
            } 
            //2 - consonant : 1st letter to last + add "ma" at the end
            else {
                for(int i = 1; i < s.length(); i++){
                    sb.append(s.charAt(i));
                }
                sb.append(s.charAt(0));
                sb.append("ma");
            }
            
            //3 - add "a" 'cnt' times
            for(int i = 0; i < cnt; i++){
                sb.append("a");
            }
            sb.append(" ");
            cnt++;
		}
        return sb.toString().trim();
    }

}
