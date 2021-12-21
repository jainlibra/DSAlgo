/**
 * Bottom up(tabulation) DP solution for edit distance
 * the first row and first column of the dp matrix will be filled
 * before hand.
 * @author ajain
 *
 */
public class MinEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "CAUS";
		String str2 = "CUTT";
		//create a 2d array with num rows equal to 1+length  of first word
		//and num columns equal to 1+length of second word
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		//fill the first row of the 2d array. the leftmost corner will be 0 as for empty strings
		//nothing needs to be edited(removed).the second column will be 1
		//(1 character needs to be removed to make empty string).fill the remaining columns accordingly
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=i;
			//System.out.println(i);
		}
		//fill the first column of the 2d array. the leftmost corner will be 0 as for empty strings
		//nothing needs to be edited(removed).the second row first column will be 1
		//(1 character needs to be removed to make empty string).fill the remaining rows first column accordingly
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=i;
			//System.out.println(i);
		}
		//start filling up the remaining 2d array
		//if the characters of both the words at indexes i and j match,no edit operation happens
		//so we fill with the diagonal left cell's value in dp[i][j]
		//let's take an example of character A in CAUS and character U in CUTT,
		//we can either (delete C from both words (2 ops) and (delete both A and U(2 ops) 
		//or change A to U or vice versa(1 op)) leading to a total of 3 or 4 ops)
		//the minimum op count is obtained by changing just A to U or vice versa(1 op)
		//so,to fill dp[i][j] when characters do not match,we add 1(for current op) + (a minimum of left diagonal cell,left cell and top cell) 
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
				}
			}
		}
		//print the dp array just for illustration
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
		//minimnum number of operations
		System.out.println(dp[str1.length()][str2.length()]);

	}

}

