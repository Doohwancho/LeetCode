package juneChallenge;

public class ReverseString {
	
	//<����Ǯ��1>
	
	//�׳� two-pointer�Ἥ swap�ϸ� ���ݾ�.
	
	//���ò� ����ű���
	
    //Runtime: 0 ms
    //Memory Usage: 45.7 MB
    public void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while(l<r){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
