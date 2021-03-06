package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition886 {
	
	//yet
	
	//2 - decided
	//1 - undecided
	//0 - yet visited

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] a = new int[N+1];
        int[] b = new int[N+1];
        int[] yet = new int[N+1];
        
        for(int[] d : dislikes){
            int x = d[0];
            int y = d[1];
            
            if(a[x] == 2){
                if(a[y] == 2) return false;
                b[y] = 2;
                continue;
            } else if(b[x] == 2){
                if(b[y] == 2) return false;
                a[y] = 2;
                continue;
            } else if(a[y] == 2){
                if(a[x] == 2) return false;
                b[x] = 2;
                continue;
            } else if(b[y] == 2){
                if(b[x] == 2) return false;
                a[x] = 2;
                continue;
            }
            
            if(a[x] == 1){
                a[x] = 2;
                if(a[y] == 2) return false;
                b[y] = 2;
                continue;
            } else if(b[x] == 1){
                b[x] = 2;
                if(b[y] == 2) return false;
                a[y] = 2;
                continue;
            } else if(a[y] == 1){
                a[y] = 2;
                if(a[x] == 2) return false;
                b[x] = 2;
                continue;
            } else if(b[y] == 1){
                b[y] = 2;
                if(b[x] == 2) return false;
                a[x] = 2;
                continue;
            }
            
            a[x] = 1;
            a[y] = 1;
            b[x] = 1;
            b[y] = 1;
            yet[x] = y;
            yet[y] = x;
        }
        
        return true;
    }
    
    //<문제풀이1 by wangzi6147>
    
    //dfs
    
    //0 : not visited yet
    //1 : group 1
    //-1 : group 2
    
    //Runtime: 68 ms, faster than 9.68% of Java online submissions for Possible Bipartition.
    //Memory Usage: 80.1 MB, less than 5.39% of Java online submissions for Possible Bipartition.
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for(int[] d : dislikes){
            graph[d[0]-1][d[1]-1] = 1;
            graph[d[1]-1][d[0]-1] = 1; //쌍방으로 표시
        }
        int[] color = new int[N];
        
        for(int i = 0; i < N; i++){
            if(color[i] == 0 && !dfs(graph, color, i, 1)){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] color, int idx, int group){
        color[idx] = group;
        for(int i = 0; i < color.length; i++){
            if(graph[idx][i] == 1){
                if(color[i] == group) return false; 
                if(color[i] == 0 && !dfs(graph, color, i, -group)) return false; //i에 dislike에 있는 j는 계~속 반대 그룹에 넣고 돌리다가, 바로위에 if(color[i] == group) 이 true뜨면, i가 dislike한 애 j가 i랑 같은그룹에 있다는 말이니까 return false 
            }
        }
        return true;
    }
    
    //<문제풀이2>
    
    //bfs
    
    //dfs랑 원리는 동일. 다만, dfs에서 int[N][N]만들고 재귀로 매번 dislike를 타고타고 갈때마다 int[N]을 다 iterate해줘서 느렸던 것을
    
    //이번 방식에서는 arraylist에 dislikes만 딱딱 꽂아줘서 불필요한 곳을 안돌게 되었음. 56ms 더 빨라짐.
    
    //Runtime: 12 ms, faster than 90.39% of Java online submissions for Possible Bipartition.
    //Memory Usage: 46.9 MB, less than 5.39% of Java online submissions for Possible Bipartition.
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> list = new ArrayList<>(N+1);
        for(int i = 0; i < N+1; i++){
            list.add(new ArrayList<>());
        }
        for(int[] d : dislikes){
            list.get(d[0]).add(d[1]);
            list.get(d[1]).add(d[0]);
        }
        
        int[] color = new int[N+1];
        
        for(int i = 1; i < N+1; i++){
            if(color[i] == 0){
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                
                while(!q.isEmpty()){
                    int key = q.poll();
                    for(int dis : list.get(key)){
                        if(color[dis] == 0){ //이부분이 없으면 무한으로 돈다.
                            color[dis] = color[key] == 2 ? 1 : 2; //이전애랑 다른그룹으로 매핑
                            q.add(dis);
                        } else {
                            if(color[dis] == color[key]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
