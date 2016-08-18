package com.test.visit;

public class Visit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map=new int[][]{{0,1,0,},{0,0,2}};
		int n=2;
		int m=3;
		System.out.println(new Visit().countPath(map, n, m));
		
	}
	public int countPath(int[][] map, int n, int m) {
        // write code here
		int x1=0,x2=0,y1=0,y2=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(map[i][j]==1){
					x1=i;
					y1=j;
				}
				if(map[i][j]==2){
					x2=i;
					y2=j;
				}
			}
		}
		
		return visit(map,x2,y2,x1,y1,x2,y2);
	}
	public int visit(int[][] map,int x,int y,int m,int n,int m1,int n1){
		
		if(m1>=m&&n1>=n){
			if(x<m||y<n) return 0;
			if(map[x][y]==1){
				return 1;
			}
			if(map[x][y]==-1)return 0;
			return visit(map,x-1,y,m,n,m1,n1)+visit(map,x,y-1,m,n,m1,n1);
		}
		 if(m1>=m&&n1<n){
			 if(x<m||y>n) return 0;
			 if(map[x][y]==1){
					return 1;
				}
			 if(map[x][y]==-1)return 0;
			return visit(map,x-1,y,m,n,m1,n1)+visit(map,x,y+1,m,n,m1,n1);
			}
		 if(m1<m&&n1>=n){
			 if(x>m||y<n) return 0;
			 if(map[x][y]==1){
					return 1;
				}
			 if(map[x][y]==-1)return 0;
			return visit(map,x+1,y,m,n,m1,n1)+visit(map,x,y-1,m,n,m1,n1);
			}
		 if(m1<m&&n1<n){
			 if(x>m||y>n) return 0;
			 if(map[x][y]==1){
					return 1;
				}
			 if(map[x][y]==-1)return 0;
			return visit(map,x+1,y,m,n,m1,n1)+visit(map,x,y+1,m,n,m1,n1);
		}
		return 0;
	}
}
