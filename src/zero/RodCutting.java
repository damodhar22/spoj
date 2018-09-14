package zero;

public class RodCutting {

	
	public static void main(String[] args) {
		
		int a[] = {1,2,3,4};
		int b[] = {2,5,9,6};
		
		System.out.println(rodCutMax(a,b,5));
	}
	
	static int rodCutMax(int a[],int b[],int l){
		
		if(l==0){
			return 0;
		}
		int max=0;
		for(int i=0;i<a.length;i++){
			if(l-a[i]>=0){
				max=Math.max(max,b[i]+rodCutMax(a,b,l-a[i]));
			}
		}
		
		return max;
	}
}
