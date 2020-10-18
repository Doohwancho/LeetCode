package graph;

public class SurroundedRegions130 {

	//<����Ǯ��1>
	
	
	//�����ڸ��� 'O'�� �̾��� �ֵ� �ϴ� 'A'�� �ٲ�.
	
	//�׷��� ������ 'O'���� �����ڸ��� �� �̾��� �ֵ��̶� ���̴ϱ�, ��׵��� 'X'�� �ٲٰ�
	
	//�Ʊ� �����ڸ��� �̾��� 'A'���� �ٽ� 'O'�� �ٲ�.
	
	//Runtime: 1 ms, faster than 99.84% of Java online submissions for Surrounded Regions.
	//Memory Usage: 41.1 MB, less than 6.35% of Java online submissions for Surrounded Regions.
	
	private void edge(char[][] board, int i , int j, Character c){
        if(board[i][j] == 'X' || board[i][j] == c) return;
        
        board[i][j] = c;
        
        if(i > 0) edge(board, i-1, j, c);
        if(j > 0) edge(board, i, j-1, c);
        if(i < board.length-1) edge(board, i+1, j, c);
        if(j < board[0].length-1) edge(board, i, j+1, c);
    }
    
    public void solve(char[][] board) {
        if(board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        int rst = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    edge(board, i, j, 'A');    
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j]== 'O'){ 
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j]== 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
