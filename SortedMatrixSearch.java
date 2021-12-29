import java.util.Arrays;

/**
 * Search for a number in a sorted matrix(matrix rows and columns are sorted)
 *
 */
public class SortedMatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[4][4];
		matrix[0][0] = 1;
		matrix[0][1] = 4;
		matrix[0][2] = 8;
		matrix[0][3] = 10;
		
		matrix[1][0] = 3;
		matrix[1][1] = 9;
		matrix[1][2] = 13;
		matrix[1][3] = 17;
		
		matrix[2][0] = 6;
		matrix[2][1] = 11;
		matrix[2][2] = 16;
		matrix[2][3] = 21;
		
		matrix[3][0] = 9;
		matrix[3][1] = 15;
		matrix[3][2] = 23;
		matrix[3][3] = 34;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println(" ");
		}
		
		System.out.println(searchInSortedMatrix(matrix, 22));

	}
	/**
	 * searches for a number in a sorted matrix.The matrix is assumed to be
	 * sorted in ascending order.For descending order sorted matrix,the conditions need to change
	 * @param matrix
	 * @param numberToBeSearched
	 * @return
	 */
	public static boolean searchInSortedMatrix(int[][] matrix,int numberToBeSearched) {
		System.out.println(matrix.length);
		//the bottom right corner will contain the maximum.If that number is less
		//than the number being searched,no point going through the entire matrix
		if(matrix[matrix.length-1][matrix[0].length-1]<numberToBeSearched) {
			return false;
		}
		//the top left corner will have the lowest value.If that number is greater
		//than the number being searched,no point going through the entire matrix
		if(matrix[0][0]>numberToBeSearched) {
			return false;
		}
		
		for(int i=0;i<4;i++) {
			int[] arr = matrix[i];
			if(Arrays.binarySearch(arr, numberToBeSearched)>=0) {
				return true;
			}
		}
		return false;
	}

}

