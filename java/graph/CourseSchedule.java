package mayChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	
	//<Trial01>
	
	//queue採歳拭辞 嬢胸惟 坦軒拝走 乞牽畏革
	
	//陥橿娃員聖 set拭 隔壱 set.contains()稽 陥橿娃員聖 暁 尽生檎 return false 梅澗汽
	
	//幻鉦拭, (1,2),(1,3),(3,4),(4,2),(2,5)
	
	//旭戚, 1->3->4->2->5 坦軍 焼巷 庚薦 蒸澗汽, 2研 陥獣廃腰 級軒澗 井酔拭辞 厳毘
	
	//戚闇 int[]研 床壱 暗団娃 員聖 1稽 原滴背亀 疑析廃 庚薦 降持. 
	
	//焼たたたたたたた
	
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> p = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
        	p.add(new ArrayList<>());
        }
    	for(int[] pr : prerequisites) {
    		p.get(pr[0]).add(pr[1]);
    	}
    	int[] c = new int[numCourses];
        for(int i = 1; i < numCourses+1; i++){
        	c[i-1] = i;

            Queue<Integer> q = new LinkedList<>();
            q.add(i-1);
            
            while(!q.isEmpty()) {
            	int cur = q.poll();
            	for(int pr : p.get(cur)) {
            		if(c[pr] != i) {
            			c[pr] = i;
            		}
//            		if(c[pr] == c[cur]) //??
//            		if(c[pr] == 0) {
//            			c[pr] = c[cur] == i ? 2 : 1;
//            		} else {
//            			if(c[pr] == c[cur]) return false;
//            		}
            	}
            }
        }
        return true;
    }
    
    //<庚薦熱戚1 by jeantimex>
    
    //trial01引 号縦精 旭精汽, 託戚繊精
    
    //trial01旭精 井酔殖, (1,2),(1,3)旭戚 食君哀掘稽 算嬢蟹亜澗 井酔拭 却陥 疑獣坦軒敗. 
    
    //悦汽 庚薦熱戚1精 (1,2)魚稽, (1,3) 魚稽 坦軒敗.
    
    ////(1,2),(1,3),(3,4),(4,2),(2,5)拭辞, trial01税 井酔殖,
    
    //丞哀掘(1,2),(1,3)研 却陥 疑獣拭 端滴馬奄 凶庚拭, 3生稽 娃 蕉亜 (3->4),(4->2)坦軍 2拭 亀鐸馬檎, 2拭 廃腰 亀鐸梅奄 凶庚拭(1->2) return false馬澗汽,
    
    //庚薦熱戚1旭精 井酔, (1,2)魚稽, (1,3)魚稽 坦軒敗.
    
    //(1->2) 馬壱 戚雌蒸革? 馬檎, stack[]聖 陥獣 段奄鉢 獣徹壱
    
    //(1->3)聖 宜凶 stack[]精 (1->2)櫛 紺鯵亀 宜焼辞, (3->4),(4->2)背亀 庚薦蒸製.
    
    //Runtime: 3 ms
    //Memory Usage: 40.5 MB
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(numCourses);
        
        for (int i = 0; i < numCourses; i++) 
            adjList.add(i, new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; i++)
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        boolean[] visited = new boolean[numCourses];
        
        for (int u = 0; u < numCourses; u++)
            if (hasCycle(adjList, u, visited, new boolean[numCourses]))
                return false;
        
        return true;
    }
    
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, boolean[] stack) {
        if (visited[u]) //stack幻床走 瓜戚 visited亀 床澗 戚政澗, 森研級嬢 (1,2),(2,3),(3,4), ... 拭辞, 1->2->3->4研 伊装梅壱 戚雌蒸陥檎, visited[u] = true稽 郊餓摂焼? 悦汽 蟹掻拭 (8->9),(9->1)聖 尽嬢. 悦汽 1 戚板殖 戚耕 菰堕馬陥澗杏 伊装梅生艦猿 希 瑳 琶推亜 蒸摂焼. 益掘辞 床澗暗醤.
            return false;
            
        if (stack[u])  //recursive獣 廃腰 級携生檎 return false廃陥.
            return true;
            
        stack[u] = true;
            
        for (Integer v : adjList.get(u))
            if (hasCycle(adjList, v, visited, stack))
                return true;
        
        visited[u] = true;
        
        return false;
    }
	
	public static void main(String[] args) {
//		int a = 4;
//		int[][] p = {{0,1},{3,1},{1,3},{3,2}};
//		int a = 3;
//		int[][] p = {{1,0},{2,1}};
		int a = 8;
		int[][] p = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
		System.out.println(canFinish(a,p));
	}
}
