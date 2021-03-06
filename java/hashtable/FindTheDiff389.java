/*
	Given two strings s and t which consist of only lowercase letters.
	
	String t is generated by random shuffling string s and then add one more letter at a random position.
	
	Find the letter that was added in t.
	
	Example:
	
	Input:
	s = "abcd"
	t = "abcde"
	
	Output:
	e
	
	Explanation:
	'e' is the letter that was added.
	
	
	
	
	
	<문제>
	
	String타입의 s와 t가 다음과 같이 주어진다.
	
	Input:
	s = "abcd"
	t = "abcde"
	
	t는 s를 랜덤하게 섞은것 + 새로운 문자이다. t에 새롭게 더해진 문자를 반환하라.
 */



package HashTable;

public class FindTheDiff389 {
	/*
	//<Trial01>
	
	//아 그냥 t를 loop돌리면서 s.contains()로 확인해주면 되지?
	
	//라고 쉽게 생각했으나, s = "a", t = "aa"인 경우를 생각을 못함.
	
	//제기랄.
	
	//hashmap으로 빈도수 카운트해서 담거나, int[26]으로 해야할텐데, 후자가 더 빠르니까 후자로 해야지.
	
	public static char findTheDifference(String s, String t) {
		for(char c : t.toCharArray()) if(!s.contains(c+"")) return c;
		return 'a';
    }
    */
	
	
	//<문제풀이1>
	
	//알파벳이 소문자만 나온다고 했으니까, 알파벳 26개만큼 new int[26]생성 후, 
	
	//알파벳 - 'a'하면 숫자로 변환되는 것을 이용하여, int[]에 저장하고, t를 loop돌 때, 
	
	//해당 알파벳의 빈도수를 1씩 빼면서, 빈도수가 -됬다는 말은 한번도 등장하지 않았단 말이니까 해당 알파벳을 반환.
	
	//Runtime: 1 ms, faster than 98.83% of Java online submissions for Find the Difference.
	//Memory Usage: 35.6 MB, less than 100.00% of Java online submissions for Find the Difference.
	public static char findTheDifference(String s, String t) {
		int[] alphabet = new int[26];
		for(char c : s.toCharArray()) alphabet[c-'a']++;
		for(char c : t.toCharArray()) if(--alphabet[c-'a'] < 0) return c;
		return 'a';
	}

	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		System.out.println(findTheDifference(s, t));
	}
}
