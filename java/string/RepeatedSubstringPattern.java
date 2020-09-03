package september;

public class RepeatedSubstringPattern {

	
	//<Trial01>
	
	//"aaaa" return false, when it should return true;
	
    public boolean repeatedSubstringPattern(String s) {
        int[] a = new int[26];
        for(char c : s.toCharArray()){
            a[c-'a']++;
        }
        int even = 0;
        boolean flag = false;
        for(int i : a){
            if(i != 0){
                if(even == 0){
                    even = i;
                } else {
                    if(i != even){
                        return false;
                    } else {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
    
    
    //<Trial02>
    
    //"ababba"���� ����.
    
    //�� ������ �ϸ� �ȵǴ°�, ������ �߿��ϱ���
    
    //������ �ϰ� ����
    
    public boolean repeatedSubstringPattern(String s) {
        int[] a = new int[26];
        for(char c : s.toCharArray()){
            a[c-'a']++;
        }
        int even = 0;
        int t = 0;
        for(int i : a){
            if(i != 0){
                if(t == 0){
                    t = i;
                } else{
                    if(i != t){
                        return false;
                    }
                }
            }
            even += i;
        }
        return even > 1;
    }
    
    
    //<����Ǯ��1>
	
	//���� �� �Ӹ����� ����
    
    //ó���� �ε���, ���� ������, ���� �׵���, ...
    
    //���� ���� �� piece�� ����� space��� ����������,
    
    //0, 0+space, 0+space+space, 0+space+space+space  ��� ���ؼ� ���� �ٸ��� ���� �������� �Ѿ
    
    //���� �����ϰ� ���ɵ� �����ϰ� ������ �ⷡ
	
	//Runtime: 6 ms
	//Memory Usage: 40 MB
    
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() < 2) return false;
        
        int split = 2;
        int len = s.length();
        
        while(len/split >= 1){
            if(len%split != 0){
                split++;
                continue;
            }
            int space = len/split;
            loop:
            for(int i = 0, comp = s.charAt(i); i < space; i++){
                comp = s.charAt(i);
                for(int j = i+space; j < len; j+=space){
                    if(s.charAt(j) != comp){
                        break loop;
                    }
                }
                if(i == space-1){
                    return true;
                }
            }
            split++;
        }
        return false;
    }
    
    
    
    //<����Ǯ��2 by fhqplzj>
    
    //????
    
	//"hello" (is not a repeated string) => hellohello => ellohell ( returns false, as is doesn't contain repeated sequence)
	
	//"alien" (is not a repeated string) => alienalien => lienalie ( returns false, as is doesn't contain repeated sequence)
	
	//"funfun" (is a repeated string) => funfunfunfun => unfunfunfu (returns true, as even after removing the first and last char, you can find the real string)
	
	//"toto" (is a repeated string) => totototo => ototot ( ..."...)
    
    //Runtime: 72 ms
    //Memory Usage: 39.6 MB
    public boolean repeatedSubstringPattern(String str) {
    	return (str + str).substring(1, str.length()*2 - 1).contains(str);
    }
    
}
