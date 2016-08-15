package ccnu.test.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    /*Scanner s = new Scanner(System.in);
        int[] data = new int[2];
        do{
	        data[0] = s.nextInt();
	        data[1] = s.nextInt();
	        ArrayList<Integer> array = new ArrayList<Integer>();
	        for(int i = 0; i < data[0]; i ++){
	            array.add(s.nextInt());
	        }
	        int num = 0;
	        char a ;
	        int b,c;
	        while(num < data[1]){
	            a = s.next().charAt(0);
	            b = s.nextInt();
	            c = s.nextInt();
	            if('Q' == a){
	                int start, end;
	                if(b <= c){
	                start = b - 1;
	                end = c - 1;
	                }else{
	                    start = c - 1;
	                    end = b - 1;
	                }
	                int max = array.get(start);
	                for(int index = start; index <= end; index ++){
	                    if(array.get(index) >= max)
	                        max = array.get(index);
	                }
	                //result.add(max);
	                System.out.println(max);
	            }
	            if('U' == a){
	                int index1 = b - 1;
	                int newValue = c;
	                array.set(index1, newValue);
	            }
	            s.nextLine();
	            num ++;
	        }
        }while(s.hasNext());
        s.close();*/
		new Main().getResult();
   }
	public void getResult(){
		Scanner sc = new Scanner (System.in);
		String str = sc.nextLine();
		String[] ss= str.split(" ");
		int m = Integer.parseInt(ss[0]);
		int n = Integer.parseInt(ss[1]);
		String line = sc.nextLine();
		ss= line.split(" ");
		int[] a = new int[m];
		for(int i=0;i<a.length;i++){
			a[i]=Integer.parseInt(ss[i]);
		}
		for(int i=0;i<n;i++){
			line = sc.nextLine();
			ss = line.split(" ");
			int start = Integer.parseInt(ss[1])-1;
			int end = Integer.parseInt(ss[2]);
			if("Q".equals(ss[0])){
				System.out.println(getMax(a,start,end-1));
			}
			if("U".equals(ss[0])){
				change(a,start,end);
			}
		}
		sc.close();
		
	}
	private void change(int[] a, int start, int end) {
		a[start]=end;
	}
	public int getMax(int[] a,int start,int end){
		int result=0;
		int temp=0;
		if(start>end){
			temp=end;
			end= start;
			start=temp;
		}
		for(int i=start;i<=end;i++){
			if(a[i]>result){
				result=a[i];
			}
		}
		return result;
	}
	

}
