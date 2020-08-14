package augustChallenge;

public class LongestPalindrome {
	
	//<Trial01>
	
	//¦���� ���� + Ȧ���� �߿� �� ū�� �ƴѰ�?
	
	//"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlo
	//ngendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportion
	//ofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmi
	//ghtliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecanno
	//tdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddead
	//whostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworl
	//dadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheyd
	//idhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichthey
	//whofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothe
	//greattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiont
	//othatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresol
	//vethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbir
	//thoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperish
	//fromtheearth"
	
	//output:655, expected: 983
	
    public int longestPalindrome(String s) {
        int rst = 0;
        int[] a = new int[58];
        
        for(char c : s.toCharArray()){
            a[c-'A']++;
        }
        int maxOdd = 0;
        
        for(int evenCheck : a){
            if(evenCheck % 2 == 1){
                maxOdd = Math.max(maxOdd, evenCheck);
            } else {
                rst += evenCheck;
            }
        }
        return maxOdd+rst;
    }
    
    //<����Ǯ��1 by yuxiangmusic>
    
    //�� ���� �˸�û�̾���
    
    //Ȧ���� �ִ� �ֵ��� �Ѱ����� ���� ¦������ ���ݾ�!!!!
    
    //���������� ����!!!
    
    //Runtime: 1 ms
    //Memory Usage: 37.7 MB
    
    public int longestPalindrome(String s) {
        int arr[] = new int[1 << 7], l = 0;
        for (char c : s.toCharArray()) arr[c]++;
        for (int i : arr) l += i >> 1 << 1; //Ȧ���� �� ���� 1�� ����
        return l == s.length() ? l : l + 1; //l == s.length()�� �����ϴ� ����� ���� s�� ��� ���ĺ��� ¦���� ���. �Ѱ��� Ȧ���� 1�� �̻��� ��ϱ�. ��� ¦���� l��ȯ. Ȧ���� �Ѱ��� ������ +1�ؼ� ��ȯ.
    }
}
