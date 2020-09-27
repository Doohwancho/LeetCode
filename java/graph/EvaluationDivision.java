package september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationDivision {
	
	
	//<Trial01>
	
	//������ ���� �׷��� �ľ߰ڴ� �巯���� ���ظ԰ڳ�
	
	//�� �ٽ� �κ� ���� �� ������ ��� �ߴµ�...
	
	//������ ���� ���γ��� ���� ��� ������� �ǳ��� ����.
    
    private int find(double v){
        int a = 1;
        while((int)(a * v) != (a * v)){
            a++;
        }
        return a;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<Double> rst = new ArrayList<>();
        Map<String, List<String>> pair = new HashMap<>();
        Map<String, Integer> charNum = new HashMap<>();
        
        //mapping
        for(int i = 0; i < equations.size(); i++){
            List<String> tmp = equations.get(i);
            String a = tmp.get(0);
            String b = tmp.get(1);
            
            
            if(pair.containsKey(a)){
                List<String> partners = pair.get(a);
                
                int newMultiply = find(values[i]);

                for(String partner : partners){
                    charNum.put(partner, charNum.get(partner) * (int)(values[i]*newMultiply));
                }
                
                charNum.put(a, charNum.get(a) * (int)(values[i]*newMultiply));
                charNum.put(b, newMultiply);
                
                partners.add(b);
                
                List<String> tmp1 = new ArrayList<>();
                tmp1.add(a);
                pair.put(b, tmp1);
            }
            else if(pair.containsKey(b)){
                List<String> partners = pair.get(b);
                
                int newMultiply = find(values[i]);

                for(String partner : partners){
                    charNum.put(partner, charNum.get(partner) * (int)(values[i]*newMultiply));
                }
                
                charNum.put(b, charNum.get(b) * (int)(values[i]*newMultiply));
                charNum.put(a, newMultiply);
                
                
                partners.add(a);
                
                List<String> tmp1 = new ArrayList<>();
                tmp1.add(b);
                pair.put(a, tmp1);
            } 
            else{
                int multiply = find(values[i]);
                
                List<String> tmp1 = new ArrayList<>();
                tmp1.add(b);
                pair.put(a, tmp1);
                
                List<String> tmp2 = new ArrayList<>();
                tmp2.add(a);
                pair.put(b, tmp2); //��������� �־���
                
                charNum.put(a, (int)(multiply * values[i]));
                charNum.put(b, multiply);
            }
        }
        
        //extracting
        for(List<String> q : queries){
            String a = q.get(0);
            String b = q.get(1);
            
            if(!pair.containsKey(a) || !pair.containsKey(b)){
                rst.add(-1.0);
            } else {
                rst.add((double)charNum.get(a)/(double)charNum.get(b));
            }
        }
        
        double[] db = new double[rst.size()];
        
        for(int i = 0; i < rst.size(); i++){
            db[i] = rst.get(i);
        }
        
        return db;
    }
	
    
    //<����Ǯ��1 by yuxiaofei2016>
    
    //�Ķ���� Ÿ���� List<List<String>>�� �ƴ϶� String[][]�� ���ִ°� ���ľ� ���ư�.
    
    //�ϴ� equations�� i��°�� �ְ� query�� i��°�� �ֶ��, (�̻ڰ� ��������) �ٷ� ����ؼ� result�� ���,
    
    //���ٸ�, query�� ���ʸ� �ִ��� ã��, �ٸ� ���ʰ� ��Ī
    
    //���̰� �Ӹ������ڳ�.
    
    class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
            double[] result = new double[query.length];

            Set<String> words = new HashSet<>();
            for (String[] strs : equations) {
                words.add(strs[0]);
                words.add(strs[1]);
            }
            for (int i = 0; i < query.length; ++i) {
                String[] keys = query[i];
                if (!words.contains(keys[0]) || !words.contains(keys[1])) result[i] = -1.0d;
                else {
                    Stack<Integer> stack = new Stack<>();
                    result[i] = helper(equations, values, keys, stack);
                }
            }
            return result;
        }

        public double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {

            for (int i = 0; i < equations.length; ++i) {
                if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1])) return values[i];
                if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0])) return 1 / values[i];
            }
            for (int i = 0; i < equations.length; ++i) {
                if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
                    stack.push(i);
                    double temp = values[i] * helper(equations, values, new String[]{equations[i][1], keys[1]}, stack);
                    if (temp > 0) return temp;
                    else stack.pop();
                }
                if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
                    stack.push(i);
                    double temp = helper(equations, values, new String[]{equations[i][0], keys[1]}, stack) / values[i];
                    if (temp > 0) return temp;
                    else stack.pop();
                }
            }
            return -1.0d;
        }
    }
	
    
}
