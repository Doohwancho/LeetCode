package september;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	
	//<Trial01>
	
	//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 
	//8 5 8 5 7 5 8 7 8 14 15 11 15 13 14 15 19 22 23 19 20 21 22 23
	
	//string.lastIndexOf(char)�� �̿���, i��° �ִ� char�� S�� ���������� ���°���� ����.
	
	//���� ���� ��, �ٷ� ������ �ֵ��� S���� �� �ѹ������ϴ� �ֵ��̰ų�(i == S.lastIndexOf(S.charAt(i))) 
	
	//�̹� a......a �̹� �ι�° a��, S.lastIndexOf(S.charAt(i))�ϸ� ������ ������ �ֵ�(�̰� ���� i == S.lastIndexOf(S.charAt(i)))
	
	//�� ����.
	
	//��� �Ʊ���? ���� �� �°Ű�����
	
    public List<Integer> partitionLabels(String S) {
        List<Integer> rst = new ArrayList<>();
        int len = S.length();
        for(int i = 0, prev = 0, acc = 0; i < len; ){
            i = S.lastIndexOf(S.charAt(i));
            acc = i - prev + 1;
            i++;
            while(i < len && i == S.lastIndexOf(S.charAt(i))){
                i++;
                acc++;
            }
            prev = i;
            rst.add(acc);
        }
        return rst;
    }
    
    
    //<Trial02>
    
    //�����غ���, "hijhklij"�� ��쿡
    
    //i == S.lastIndexOf(S.charAt(i))�� �ع�����, h->hã�� ��,
    
    //k,l,i,j��� ȥ�ڹۿ� ���¾ְų� �ι�° ������ �ִϱ� �ַ�� ��������. 
    
    //�ٵ� ��׵��� �������� �ϴ� ������, hijh�� ���ԵǼ�����, �������� �ֵ��̴ϱ� �������� ���� ����.
    
    //�������� �������ξֵ�� "�ִ��� ����" ������� �߱� ����.
    
    //�׷��� i > S.indexOf(S.charAt(i)) �� �ٲ�. 
    
    //���� ��Ÿ�� ���� ������ ��ġ�°ɷ�.
    
    //�׷��� ���⼭ ������, "hijhklij"����
    
    //h->h�� ��, k�� ���� �ȳ������ϱ� �и��ǰ�, l�� �и��Ǵµ�, 
    
    //i�� ������ ��, ���� �������ϱ� ���� ������ k+l+i�� �� �ٿ���� �ϴµ�,
    
    //�̹� ����Ʈ�� ������. ��..
    
    
    public List<Integer> partitionLabels(String S) {
        List<Integer> rst = new ArrayList<>();
        int len = S.length();
        for(int i = 0, prev = 0, acc = 0; i < len; ){
            System.out.println(i);
            i = S.lastIndexOf(S.charAt(i));
            acc = i - prev + 1;
            i++;
            while(i < len && i > S.indexOf(S.charAt(i))){ //�ٷ� �����ʿ� �پ��ִ� ���
                i++;
                acc++;
            }
            prev = i;
            rst.add(acc);
        }
        return rst;
    }
    
    
    //<����Ǯ��1 by kay_deep>
    
    //last�� �������� ���� ���ĺ��� �ε����� �����,
    
    //�Ķ���ͷ� �־��� String�� iterate�ϸ鼭, i�� �������� ���¾ָ� rst�� �����ִ� ���.
    
    //�갡 trial02���� ���� ����, 
    
    //Trial02�� String.lastIndexOf()�� ã�µ�, ���� �갡 �̹� �ѹ� ���ͼ� �ι�°�� ���� �ֶ��,
    
    //�̰� Ȯ���ϱ� ���ؼ� �� String.indexOf()�� �����.
    
    //������
    
    //�ٵ� ����Ǯ��1�� ���ʿ� ������ �ε����� �̾Ƴ��� �����ϱ� ������, 
    
    //�������� ���ص� ��.
    
    //�߰���, end = Math.max(end, last[S.charAt(i)-'a']); �� �ϴ� ������,
    
    //0~i���� ������ �ֵ��߿� �� ū�� ��������.
    
    //"ababcbacadefegdehijhklij"
    //8 8 8 8 8 8 8 8 8 14 15 15 15 15 15 15 19 22 23 23 23 23 23 23 
    
    //���� end = last[S.charAt(i)-'a']=�� �ϸ�,
    
    //8 5 8 5 7 5 8 7 8 14 15 11 15 13 14 15 19 22 23 19 20 21 22 23 
    
    //���߳����ؼ�, �ҽɾ��� [6,2,1,3,2,1,1,4,1,1,1,1] ���� ��.
    
    //String���� �� �ѹ��� ������ �ֵ��� ������ �������� ���̰�, n�� �ִ¾ֵ鵵 �������� �ִ¾ִ� ������ �������� ���̴� �һ�� �߻�.
    
    //Runtime: 2 ms
    //Memory Usage: 38 MB
    public List<Integer> partitionLabels(String S) {
        List<Integer> rst = new ArrayList<>();
        int[] last = new int[26];
        char[] cs = S.toCharArray();
        int len = S.length();
        for(int i = 0; i < len; i++){
            last[S.charAt(i)-'a'] = i; 
        }
        int start = -1;
        int end = -1;
        for(int i = 0; i < len; i++){
            if(start == -1){
                start = i;
            }
            end = Math.max(end, last[S.charAt(i)-'a']); 
            if(end == i){
                rst.add(end-start+1);
                start = -1;
            }
        }
        return rst;
    } 
}
