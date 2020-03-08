package array;

import java.util.LinkedList;

public class NumberOfMatchingSubsequence792 {
	
	/*
	//<Trial01>
	
	//test case missing the word length longer than S

	//test case�� �ϳ��� �� �̻��ϴ�.
	
	//brute-force
	
    public static int numMatchingSubseq(String S, String[] words) {
        int rst = 0;
    	int[] alphabet = new int[26];
        for(char ch : S.toCharArray()){
            alphabet[ch-97]++;
        }
        
        for(String str : words) {
        	boolean flag = true;
        	int[] copiedArray = new int[26];
        	System.arraycopy(alphabet, 0, copiedArray, 0, 26);
        	
        	for(char ch : str.toCharArray()) {
        		copiedArray[ch-97]--;
        		if(copiedArray[ch-97] < 0) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) rst++;
        }
        
        return rst;
    }
    */
	
	//<����Ǯ��1 by fluency03>
	
	//Runtime: 25 ms, faster than 98.77% of Java online submissions for Number of Matching Subsequences.
	//Memory Usage: 42.8 MB, less than 12.50% of Java online submissions for Number of Matching Subsequences.
	
	
    static class Mover {
        char[] word;
        int pos = 0;
        Mover (String w) {
            this.word = w.toCharArray();
        }
        char currChar() {
            return this.word[pos];
        }
        void move() {
            this.pos++;
        }
        boolean hasEnded() {
            return this.word.length == pos;
        }
    }
    
	public static int numMatchingSubseq(String S, String[] words) {
		//String S = "abcde";
		//words = {"a", "bb", "acd", "ace"};
        LinkedList<Mover>[] map = new LinkedList[26];
        
        //[] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] 
        for (char c = 'a'; c <= 'z'; c++) {
            map[c-'a'] = new LinkedList<Mover>();
        }
        
        //["a","acd","ace"] ["bb"] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] []
        for (String word : words) {
            map[word.charAt(0)-'a'].addLast(new Mover(word));
        }

        
        //S.toCharArray�� ������ ���ĺ����� for�� ���鼭, �ش� ���ĺ��� ���� �������� �����Ͽ��ٸ�, +1���ִ°�,
        
        //�������, S="abc"�� ��, str = "a"�� Ƣ�����, for������ "a"�� ��, str�� ���� �������� ��ġ�� ���ĺ��� "a"�ΰ�� +1���ش�.
        
        //���� str�� "ab"���ٸ�, map�󿡼� "b"������ "ab"�� ��ġ��Ų��. �̶� str.pos+1 �� �Ͽ�, currChar()�� ������ �ι�° �ε����� "b"�� ����Ű���� �Ѵ�.

        //���� S="aabc"�ε�, str="aca"�ΰ�� �ȵǳ�. ������� ���ƾ��ؼ�. �̰� substring�̶�� ���ļ� �׷��� ����.
        
		//alphabet:  a  i: 0
		//if    a  pos: 1
		//alphabet:  a  i: 1
		//else   acd  pos: 1
		//alphabet:  a  i: 2
		//else   ace  pos: 1
		//alphabet:  b  i: 0
		//else   bb  pos: 1
		//alphabet:  c  i: 0
		//else   acd  pos: 2
		//alphabet:  c  i: 1
		//else   ace  pos: 2
		//alphabet:  d  i: 0
		//if    acd  pos: 3
		//alphabet:  e  i: 0
		//if    ace  pos: 3
        int count = 0;
        for (char c : S.toCharArray()) {
            LinkedList<Mover> ll = map[c-'a']; //["a","acid","ace"]
            int size = ll.size(); 
            for (int i = 0; i < size; i++) {
                Mover m = ll.removeFirst(); 
                m.move(); 
                if (m.hasEnded()) {
                    count++;
                } else {
                    map[m.currChar()-'a'].addLast(m);
                }
            }
        }
        return count;
    }
    

    
    public static void main(String[] args) {
		String S = "aabcde";
    	String[] words = new String[] {"a", "bb", "acd", "acea"};
//    	String S = "";
//		String[] words = new String[] {"iowuuudrgzmw","azfcxtvhkruvuturdicnucvndigovkzrq","ylmmo","maptilrbfpjxiarmwalhbd","oqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqgl","ytldcdlxqbaszbuxsacqwqnhrewhagldzhr","zeeab","cqie","pvrazfcxtvhkruvuturdicnucvndigovkzrqiya","zxnvpluwicurrtshyvevkriudayyysepzq","wyhxltligahroyshfn","nhrewhagldzhryzdmmrwn","yqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmw","nhrptuugyfsghluythksqhmxlmggtcbdd","","zdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzq","ncygycdpehteiugqbptyqbvokpwovbnplshnzafun","gdzutwgjofowhryrubnxkahocqjzww","eppapjoliqlhbrbgh","qwhgobwyhxltligahroys","dzutwgjofowhryrubnxkah","rydhxkdhffyytldcdlxqbaszbuxs","tyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjc","khvyjyrydhxkdhffyytldcdlxqbasz","jajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqn","ppapjoliqlhbrbghq","zmwwxzjckmaptilrbfpjxiarm","nxkahocqjzwwagqidjhwbunvlchoj","ybfxpvqywqjdlyznmojdhbeomyjqptltp","udrgzmwnxae","nqglnpjvwddvdlmjjyzmww","swlvtlbmkrsurrcsgdzutwgjofowhryrubn","hudqbfnzxnvpluwicurr","xaezuqlsfvchjf","tvibbwxnokzkhndmdhweyeycamjeplec","olnswlvtlbmkrsurrcsgdzu","qiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyyt","","cgiowuuudrgzmwnxaezuqlsfvchjflocz","rxric","cygycdpehteiugqbptyqbvokpwovbnplshnzaf","g","surrcsgd","yzenflfnhrptuugyfsghluythksqh","gdzutwgjofowhryrubnxkahocqjzwwagqid","ddeoincygycdpeh","yznmojdhbeomyjqptltpugzceyzenflfnhrptuug","ejuisks","","mrwnxhaqfezeeabuacyswollycgio","qfskkpfakjretogrokmxemjjbvgmmqrfdxlkfvycwalbdeumav","wjgjhlrpvhqozvvkifhftnfqcfjmmzhtxsoqbeduqmnpvimagq","","ydlddogzvzttizzzjohfsenatvbpngarutztgdqczkzoenbxzv","rmsakibpprdrttycxglfgtjlifznnnlkgjqseguijfctrcahbb","pqquuarnoybphojyoyizhuyjfgwdlzcmkdbdqzatgmabhnpuyh","akposmzwykwrenlcrqwrrvsfqxzohrramdajwzlseguupjfzvd","vyldyqpvmnoemzeyxslcoysqfpvvotenkmehqvopynllvwhxzr","ysyskgrbolixwmffygycvgewxqnxvjsfefpmxrtsqsvpowoctw","oqjgumitldivceezxgoiwjgozfqcnkergctffspdxdbnmvjago","bpfgqhlkvevfazcmpdqakonkudniuobhqzypqlyocjdngltywn","ttucplgotbiceepzfxdebvluioeeitzmesmoxliuwqsftfmvlg","xhkklcwblyjmdyhfscmeffmmerxdioseybombzxjatkkltrvzq","qkvvbrgbzzfhzizulssaxupyqwniqradvkjivedckjrinrlxgi","itjudnlqncbspswkbcwldkwujlshwsgziontsobirsvskmjbrq","nmfgxfeqgqefxqivxtdrxeelsucufkhivijmzgioxioosmdpwx","ihygxkykuczvyokuveuchermxceexajilpkcxjjnwmdbwnxccl","etvcfbmadfxlprevjjnojxwonnnwjnamgrfwohgyhievupsdqd","ngskodiaxeswtqvjaqyulpedaqcchcuktfjlzyvddfeblnczmh","vnmntdvhaxqltluzwwwwrbpqwahebgtmhivtkadczpzabgcjzx","yjqqdvoxxxjbrccoaqqspqlsnxcnderaewsaqpkigtiqoqopth","wdytqvztzbdzffllbxexxughdvetajclynypnzaokqizfxqrjl","yvvwkphuzosvvntckxkmvuflrubigexkivyzzaimkxvqitpixo","lkdgtxmbgsenzmrlccmsunaezbausnsszryztfhjtezssttmsr","idyybesughzyzfdiibylnkkdeatqjjqqjbertrcactapbcarzb","ujiajnirancrfdvrfardygbcnzkqsvujkhcegdfibtcuxzbpds","","nizuzttgartfxiwcsqchizlxvvnebqdtkmghtcyzjmgyzszwgi","egtvislckyltpfogtvfbtxbsssuwvjcduxjnjuvnqyiykvmrxl","ozvzwalcvaobxbicbwjrububyxlmfcokdxcrkvuehbnokkzala","azhukctuheiwghkalboxfnuofwopsrutamthzyzlzkrlsefwcz","yhvjjzsxlescylsnvmcxzcrrzgfhbsdsvdfcykwifzjcjjbmmu","tspdebnuhrgnmhhuplbzvpkkhfpeilbwkkbgfjiuwrdmkftphk","jvnbeqzaxecwxspuxhrngmvnkvulmgobvsnqyxdplrnnwfhfqq","bcbkgwpfmmqwmzjgmflichzhrjdjxbcescfijfztpxpxvbzjch","bdrkibtxygyicjcfnzigghdekmgoybvfwshxqnjlctcdkiunob","koctqrqvfftflwsvssnokdotgtxalgegscyeotcrvyywmzescq","boigqjvosgxpsnklxdjaxtrhqlyvanuvnpldmoknmzugnubfoa","jjtxbxyazxldpnbxzgslgguvgyevyliywihuqottxuyowrwfar","zqsacrwcysmkfbpzxoaszgqqsvqglnblmxhxtjqmnectaxntvb","izcakfitdhgujdborjuhtwubqcoppsgkqtqoqyswjfldsbfcct","rroiqffqzenlerchkvmjsbmoybisjafcdzgeppyhojoggdlpzq","xwjqfobmmqomhczwufwlesolvmbtvpdxejzslxrvnijhvevxmc","ccrubahioyaxuwzloyhqyluwoknxnydbedenrccljoydfxwaxy","jjoeiuncnvixvhhynaxbkmlurwxcpukredieqlilgkupminjaj","","nizbnxpqbzsihakkadsbtgxovyuebgtzvrvbowxllkzevktkuu","hklskdbopqjwdrefpgoxaoxzevpdaiubejuaxxbrhzbamdznrr","uccnuegvmkqtagudujuildlwefbyoywypakjrhiibrxdmsspjl","awinuyoppufjxgqvcddleqdhbkmolxqyvsqprnwcoehpturicf"};
		
		System.out.println(numMatchingSubseq(S, words));
		
	}
}
