package mayChallenge;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	
	/*
	
	//�Ķ���ͷ� ransomeNote�� "aa", magazine�� "abca"�̷��� �־����� ��,
	
	//ransomNote�� �ִ� ���ĺ� �ϳ��ϳ����� ��� magazine�� ���ԵǾ� ������ true, �ƴϸ� false�� ��ȯ�϶�� ���ݾ�?
	
	//�̰� Ǫ�� ����� ũ�� �ΰ�������
	
	//�ϳ��� ransomNote�� ���ĺ����� ������ �ľ��� �� ������, magazine�� loop���鼭 ransomNote�� ���ĺ����� ��� �����ϴ��� Ȯ���ϴ� ����̰�
	
	//�ι�° ����� magazine�� ���ĺ��� ������ �ľ��� �� ������, ransomNote�� loop ���鼭 ransomNote�� 3�� ���°� magazine�� 2���ۿ� �ȳ��� �ٴ���, �ƿ� ���ٸ� return false�ϰ�, 
	
	//loop�� ������ �ƹ� �̻� ���ٸ� return true�ϴ� �������.
	
	//�ι�° ����� discuss���� ���� ��ȸ���� ����. �ι�° ����� �̷��� �����.
	 
	//<����Ǯ��1>
	 */
	
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> magM = new HashMap<>();
		for (char c:magazine.toCharArray()){
		    int newCount = magM.getOrDefault(c, 0)+1;
		    magM.put(c, newCount);
		}
		for (char c:ransomNote.toCharArray()){
		    int newCount = magM.getOrDefault(c,0)-1;
		    if (newCount<0)
		        return false;
		    magM.put(c, newCount);
		}
		return true;
	}
	
	//�ٵ� �������� ������ Runtime: 11 ms Memory Usage: 40 MB ����.
	
	//�ٵ� ù��° ������� ������ ������ Runtime: 3 ms, Memory Usage: 40 MB �̷��� ����.
	
	//8ms�� ��������.
	
	//���ϱ�?
	
	//���հ������� �����ϸ�, ransomNote�� magazine�ȿ� �� ���Ե��ݾ�?
	
	//ransomNote�� ���ĺ� ������ magazine���� �� ���� �� �ۿ� ����.
	
	//�� ũ�ٸ�, �� ó�� ��ȿ�� �˻翡�� return false���־�� ��. 
	
	//ransomNote�� magazine���� ����� �� �۴ٸ�, map�� �־ �󵵼� ī��Ʈ �� ��, magazine���� ����� �� ���� ransomNote�� �ִ°� ������.
	
	//map�� �ִ°� �ð��� �����ɸ��ϱ�, ����� �� ������ �ִ°ž�.
	
	//�׸����� magazine�� loop���� ������ �����Ǹ� �ٷ� ������� �̵��� �ϴ°� 8ms�� ������.
	
	
	//<����Ǯ��2>
	  
	
	//126 / 126 test cases passed.
	//Status: Accepted
	//Runtime: 3 ms
	//Memory Usage: 39.6 MB
	
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for(char c: ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            cnt++;
            }
        for(char c : magazine.toCharArray()){
            if(map.getOrDefault(c, 0)>0){
                map.put(c, map.get(c)-1);
                cnt--;
                if(cnt == 0){
                    return true;
                    }
                }
        
            }
        return false;
    }
    
    //<����Ǯ��3 by yubad2000>
    
    //�� ����� map�� �ִ°� �����ɸ��ϱ�, �� ���� int[]�� �ִ°ž�.
    
    //String�� .toCharArray()�� �ɰ��� char, �׷��ϱ� Character type�� �Ǵµ� ��� int[]�� �ֳİ�?
    
    //'a', 'b', �̷��� �� ���� ��ȣ�� �־�.
      
    //�������, 'a'�� 97�̰�, 'b'�� 98�̰�, ... 'z'�� 122��.
    
    //����ڵ� ���� ����̾�. 'A'�� 65�� 'B'�� 66�̰�, ... 'Z'�� 90�̾�.
     
	//System.out.println('a'-97);  //result : 0
	//System.out.println('z'-122); //result : 0
	//System.out.println('A'-65);  //result : 0
	//System.out.println('Z'-90);  //result : 0
     
    //���ĺ� -���ڷ� ������ ���ڸ� �ε���ó�� �̿��ؼ�, int[]�� �ִ°���. 
    
    //HashMap���� �ְ� ������ �ξ� ���� ������ ����. ����.
    
    //�ι��� ������� 1ms�� �����ݾ�.
    
    //Runtime: 2 ms
    //Memory Usage: 40.1 MB
    
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote==null || ransomNote.length() == 0) return true;
        if (magazine==null || magazine.length() == 0) return false;
        int[] counts = new int[256];
        for (char c: magazine.toCharArray()) {
            counts[c]++;
        }
        for (char c: ransomNote.toCharArray()) {
            if (counts[c]==0) return false;
            counts[c]--;
        }
        return true;
    }
    */
	
	//<����Ǯ��4 by UpTheHell>
	
	//����Ǯ��3���� int[256]�̶�� �����־ �Ǿ�����?
	
	//�ֳ��ϸ� 'a'�� 97�̰�, 'b'�� 98�̰�, ... 'z'�� 122�̶��, ���ĺ� �ҹ��ڰ� �� 26���ۿ� �����ϱ�
    
    //���� 256���� �޸𸮰����� �ʿ���ݾ�?
	
	//�׷��� int[]�� ���鶧, �ҹ��� ���ĺ� ������ 26���� �����,
	
	//magazine.toCharArray()�� loop����, �� ���ĺ����� alphabet-'a'(==97)�� ���༭
	
	//int[]�� �ִ°���.
	
	//�ٵ� ������� ���� �̷��� ����. 
	
	//Runtime: 2 ms, Memory Usage: 39.7 MB
	
	//����Ǯ��3�� ������ ��, �޸� ��뷮�� 0.4MB �Ʋ��µ�, runtime�� �Ȱ��� 2ms��.
	
	//��������� int[]���� ���� �ְ� ���Ë�, 256���� ������ �����°ͺ��� 26���� ������ �����°� �� �����ٵ� �� �׷���?
	
	//�ֳ��ϸ�, ����Ǯ��4������ �� loop���� alphabet-'a'������ �ϱ� ������, �� �������� �׷��ž�.
	
	//int[]�� ����� �۾����� ã�µ� �ð��� ����ǵ�, ���� �� loop���� -'a'���� ������ �ð��� ����Ǽ� +- ������ ������.
	
	//�ٵ� magazine�� ���ĺ� ������ ��������, ����Ǯ��3�� ����Ǯ�� 4���� �� �����ž�. �޸𸮴� ���� �� ��ƸԾ -'a'������ �����ݾ�.
	
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(char c: magazine.toCharArray()){
            cnt[c-'a']++;
        }
        
        for(char c: ransomNote.toCharArray()){
            if(--cnt[c-'a']<0)
                return false;
        }
        return true;
    }
	
    public static void main(String[] args) {
		System.out.println('a'-97);
		System.out.println('z'-122);
		System.out.println('A'-65);
		System.out.println('Z'-90);
	}
    
}
