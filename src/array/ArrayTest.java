package array;

public class ArrayTest {
	public static void main(String[] agrs)
	{
		// 1���� �迭
		int[] i1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};		
		int[] i2 = new int[] {1,2,3,4,5,6,7,8,9,10};		
		int[] i3 = new int[10];
		for(int i=0; i<i3.length; i++)
			i3[i] = i;
		
		// 2���� �迭
		int[][] ii4 = new int[][] {
				{1,2},
				{3,4},
				{5,6}			
				};	
	
		for (int i=0; i<3; i++) {
			for (int j=0; j<2; j++) {				 
				System.out.print(ii4[i][j]);				 
			}
		}
		
		// �����迭
		int[][] ii5 = new int[2][];
		ii5[0] = new int[3];
		ii5[1] = new int[2];
		for (int i=0; i<ii5.length; i++) {
			for (int j=0; j<ii5[i].length; j++) {
				ii5[i][j] = 5;			
			}
		} 
						
		// ���ڿ� �迭. 		
		String[] s1 = {"string", "string", "string"};
		String[] s2 = new String[10];
		String[] s3 = new String[] {"string", "string"};	 
	}

}
