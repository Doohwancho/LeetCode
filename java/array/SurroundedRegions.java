package juneChallenge;

public class SurroundedRegions {
	
	//<����Ǯ��1>
	
	//board�� for������ ���鼭 O�� ������, O�� �����ڸ����� �� �̾����� ����, �����ڸ����� �پ�������, �Ȱǵ��,
	
	//�����ڸ��� �Ⱥپ�������, 4���� ��� 'X'�� �ѷ��׿��ִٴ� ���̴ϱ�, 'O'���� 'X'�� �ٲ���� ����?
	
	//�ٵ� board���� ���ٰ� 'O'�� ���ͼ� �پ��ִ¾ֵ� �� 'X'�� �ٲ��ְ� �־��µ�, 
	
	//'O'�� �ϳ��� �����ڸ��� �پ��ִ°� Ȯ���ߴٸ�?(== 4���� 'X'�� �ѷ��׿����� ������ Ȯ���ߴٸ�?)
	
	//�׷� �ٽ� 'X'->'O' �Ҳ���? ������������? arraylist�� 'O'->'X'�ٲܶ����� ��ǥ�� int[i][j]������ ��Ƴ�������?
	
	//�̷�������, board�� ������ copy�� for������ ��������, copy���� 'O' 4���� 'X'�ѷ����� ������ ���°ž�.
	
	//���� �ѹ� �ٳణ ����'O'�� 'U'�� �ٲ��ְ�. �ٽ� �� �ʿ� ����.
	
	//�׸��� �����ڸ��� 'O'�� �ִ��� Ȯ�����ִ°���. ������ �����Ǹ� �������� board�� �ٲ��ִ°Ű�.
	
	//Runtime: 3 ms
	//Memory Usage: 45.4 MB
	
	//�پ��ִ� 'O'�� ��, �����ڸ��� �ϳ��� ������ true�� ��ȯ�ϴ� �Լ�
	private static boolean check(char[][] board, int i, int j){
    	if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'X') return false; //���� ��ȿ�� �˻�
        boolean flag = false;
		board[i][j] = 'U'; //�ѹ� �� ���� 'U'�� ��ũ�ؼ� ������ iterate�ÿ� ���� Ȯ���� ���� �� Ȯ�� ���ϵ��� �Ѵ�.
		if(i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) return true; //�����ڸ��ε� 'O'���, return true
		
        //up
        if(i > 0 && board[i-1][j] == 'O') flag |= check(board, i-1, j);
        //right
        if(j < board[0].length-1 && board[i][j+1] == 'O') flag |= check(board, i, j+1);
        //down
        if(i < board.length-1 && board[i+1][j] == 'O') flag |= check(board, i+1, j);
        //left
        if(j > 0 && board[i][j-1] == 'O') flag |= check(board, i, j-1);
        
        return flag;
    }
    
    private static void dfs(char[][] board, int i, int j){
        board[i][j] = 'X';
        //up
        if(i > 0 && board[i-1][j] == 'O') dfs(board, i-1, j);
        //right
        if(j < board[0].length-1 && board[i][j+1] == 'O') dfs(board, i, j+1);
        //down
        if(i < board.length-1 && board[i+1][j] == 'O') dfs(board, i+1, j);
        //left
        if(j > 0 && board[i][j-1] == 'O') dfs(board, i, j-1);
        
    }
    
    public static void solve(char[][] board) {
    	if(board.length == 0) return;
    	
        char[][] copy = new char[board.length][board[0].length];
        for(int p = 0; p < board.length; p++){
            for(int q = 0; q < board[0].length; q++){
                copy[p][q] = board[p][q];
            }
        }
        for(int i = 1; i < board.length-1; i++){
            for(int j = 1; j < board[0].length-1; j++){
                if(copy[i][j] == 'O'){ 
                	if(!check(copy, i, j)) { //�����ڸ��� �ϳ��� 'O'�� �پ����� �ʴٸ�, 4���� 'X'�� �ѷ��׿��ٴ� ���̴ϱ�, 
                        dfs(board, i, j); //board���� 'O'�� 'X'�� �ٲ��ش�.
                    }
                }
            }
        }
    }
}
