package julyChallenge;

public class TaskScheduler {
	
	//<Trial01>
	
	//�ʹ� �������� Ǫ�°� �ƴϳ�
	
	//�� �������� Ǯ�� ��
	
    public int leastInterval(char[] tasks, int n) {
        
        int rst = 0;
        
        int[] alphabet = new int[26];
        for(char t : tasks){
            alphabet[t-'A']++;
        }
        
        int max = 0;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, alphabet[i]);
        }
        
        for(int k = 0; k < 26; k++){
            if(alphabet[k] == max){
                alphabet[k] = 0;
                break;
            }
        }
        
        rst += (1+n) * (max-1) + 1;
        
        int rest = 0;
        int lastRest = 0;
        int cnt = 0;
        do{
            lastRest = rest;
            rest = 0;
            for(int j = 0; j < 26; j++){
                if(alphabet[j] > 0){
                    alphabet[j]--;
                    rest++;
                    if(rest == n){
                        break;
                    }
                }
            }
            cnt++;
        }
        while(rest > 0);
        
        
        if(cnt-1 > max-1){
            rst += lastRest;
        }
        
        return rst;
    }
    
    
    //<Trial02>
    
    //input�� �����ؼ� ��� �������� �ľ��� �ȵǳ�
	
    public int leastInterval(char[] tasks, int n) {
        
        int[] alphabet = new int[26];
        for(char t : tasks){
            alphabet[t-'A']++;
        }
        
        int maxIdx = 0;
        int max = 0;
        int total = 0;
        for(int i = 0; i < 26; i++){
            if(alphabet[i] > max){
                max = alphabet[i];
                maxIdx = i;
            };
            total += alphabet[i];
        }
        
        int rst = 0;
        int n_ = n;
        int limit = max-1;
        int adder = 0;
        
        while(limit > 0){
            
            for(int j = 0; j < 26; j++){
                if(j != maxIdx && alphabet[j] > 0){
                    alphabet[j]--;
                    n_--;
                    total--;
                    adder++;
                    if(n_ == 0) break;
                }
            }
            
            rst += (n == 0 ? 1+adder : (1+n));
            
            n_ = n;
            adder = 0;
            limit--;
            total--;
        }
        
        return rst + total;
    }
    
    
    //<����Ǯ��1 by alexander>
    
    //priority queue
    
    //Runtime: 59 ms
    //Memory Usage: 67.4 MB
    
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char t : tasks) {
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a); //�󵵼� ū �������
        pq.addAll(counts.values());

        int alltime = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            int worktime = 0;
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll()); //�󵵼� �� ū�ְ� �Ϻ����� �尨. 
                    worktime++;
                }
            }
            for (int cnt : tmp) {
                if (--cnt > 0) {
                    pq.offer(cnt); //pq.offer()�� �ٽ� �󵵼� ��� ���� ������ ���� �Ű�Ἥ �ȳ־ ��
                }
            }
            alltime += !pq.isEmpty() ? cycle : worktime; //������ ������ 1+n�����ְ�, ������ ������ �������� worktime������
        }
        
        return alltime;
    }
    
    
    //<����Ǯ��2 by yu6>
    
    //�̰Ŷ��~~~~~~~~~~
    
    //�̰� ÷���� �����ϴ��ǵ� �� ����� �س³�
    
    //�����ϱ���
    
    //Runtime: 4 ms
    //Memory Usage: 55.2 MB
    
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int mf = 0, mc = 0;
        for(char c:tasks) mf = Math.max(mf, ++freq[c-'A']);
        for(int f:freq) if(f==mf) mc++; //�ֺ��̶� �����ֵ��� ������ �����״�, �곻�� ���ؼ� �� �������� ������
        return Math.max(tasks.length, (n+1)*(mf-1)+mc); //n�� 0�ϰ� ���, Math.max(tasks.length, ~)
    }
}
