package com.test.flip;

public class Flip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(1^1);
		
		new Flip().flipChess(new int[][]{{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}},new int[][]{{2,2},{3,3},{4,4}});
	}
	public int[][] flipChess(int[][] A, int[][] f) {
        // write code here
		int m =A.length;
		int n= A[0].length;
		int[][] a = new int[m][n];
		for(int k=0;k<f.length;k++){
			int i=f[k][0];
			int j=f[k][1];
			if(i-2>=0){
				A[i-2][j-1]=A[i-2][j-1]^1;
			}
			if(i<m){
				A[i][j-1]^=1;		
						}
			if(j-2>=0){
				A[i-1][j-2]^=1;
			}
			if(j<n){
				A[i-1][j]^=1;
			}

		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.println(A[i][j]);
			}
		}
		return a;
    }
}
