package robot_return;

public class Robot_Return_Origin_a {

	public static boolean judgeCircle(String moves) {
	int[] point = {0,0};
	char abcd;
	for (int i=0; i<moves.length(); i++) {
		abcd = moves.charAt(i);
		switch(abcd) {
		case 'U':
			point[1]++;
			break;
		case 'D':
			point[1]--;
			break;
		case 'L':
			point[0]--;
			break;
		case 'R':
			point[0]++;
			break;
		default:
			return false;
		}}if(point[0]==0&&point[1]==0)
			return true;
		return false;
	}
	public static void main(String[] args) {
		System.out.println(judgeCircle("UDUDLRLRU"));
	
}	
}
