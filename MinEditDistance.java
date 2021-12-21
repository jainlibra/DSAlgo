/**
 * Bottom up(tabulation) DP solution for edit distance
 * the first row and first column of the dp matrix will be filled
 * before hand.
 * @author jainlibra
 *
 */
public class MinEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "CAUS";
		String str2 = "CUTT";
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=i;
			//System.out.println(i);
		}
		
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=i;
			//System.out.println(i);
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
				}
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);

	}

}
