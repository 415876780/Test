import java.util.HashMap;
import java.util.Map;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Test().calculateMax(new int[]{3,8,5,1,7,8});
		System.out.println(new Test().calculateMax(new int[]{1,10,2,12}));
	}
    public int calculateMax(int[] prices) {
    	int[] lprice=new int[prices.length];
    	lprice[0]=0;
    	int min=prices[0];
    	for(int i=1;i<prices.length;i++){
    		lprice[i]=lprice[i-1]>(prices[i]-min)?lprice[i-1]:(prices[i]-min);
    		min=prices[i]<min?prices[i]:min;
    	}
    	int[] rprice = new int[prices.length];
    	rprice[prices.length-1]=0;
    	int max= prices[prices.length-1];
    	for(int i=prices.length-2;i>-1;i--){
    		rprice[i]=rprice[i+1]>(max-prices[i])?rprice[i+1]:(max-prices[i]);
    		max=prices[i]>max?prices[i]:max;
    	}
    	int result=0;
    	for(int i=0;i<prices.length;i++){
    		result=(lprice[i]+rprice[i])>result?(lprice[i]+rprice[i]):result;
    	}
    	System.out.println(result);
    	return result;
    }
}
