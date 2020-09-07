package september;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	
	//<����Ǯ��1>
	
	//Runtime: 2 ms
	//Memory Usage: 37.3 MB
	
    public boolean wordPattern(String pattern, String str) {
        String[] strList = str.split("\\s");
        if(pattern.length() != strList.length) return false;
        Map<Character, String> map = new HashMap<>();
        int i = 0;
        for(String s : strList){
            char key = pattern.charAt(i);
            
            if(map.containsKey(key)){
                if(!map.get(key).equals(s)) return false;
                i++;
                continue;
            } 
            else if(map.containsValue(s)){
                for(Map.Entry<Character, String> elem : map.entrySet() ){
                    if(elem.getValue().equals(s)){
                        if(elem.getKey() != key) return false;
                        i++;
                        continue;
                    }
                }
                i++;
                continue;
            }
            map.put(key, s);
            i++;
        }
        return true;
    }
    
    
    //<����Ǯ��2 by StefanPochmann>
    
    //"abba"
//    "dog dog dog dog"

//    null   null
//    null   0
//    1   1
//    0   2
    
    //map.put(key, value)
    
    //���� key�� map�� �ִٸ�, ���� �ε����� ��ȯ�� ��. ó���ִ°Ÿ� null��ȯ���ְ�.
    
    //���� �־��µ� ���ʸ� ���ڰ� ���Դ�? �׷� ������ �̹� �־�������. �ٵ� 
    
    //������ ������ key:value�� ���� �Ȱ�����, ���� ���ڰ� �� ���ƾ� ��. 
    
    //���� ������ ���� ������ key:value �� �� �ϳ��� ������ �����Ŷ� �ٸ��ٴ� �Ҹ�.
    
    //Runtime: 0 ms
    //Memory Usage: 37.1 MB
    
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
