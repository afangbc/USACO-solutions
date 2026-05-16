import java.util.*;
public class SlidingWindowSummation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-->0) {
			int n = in.nextInt();
			int k = in.nextInt();
			in.nextLine();
			char[] a = in.nextLine().toCharArray();
			
			int[] r = new int[n-k+1];
			for (int i=0; i<n-k+1; i++) {
				r[i]=a[i]-'0';
			}
			
			int minsum=0;
			int parity=0;
			
			int mindiff=Integer.MAX_VALUE;
			for (int i=0; i<k; i++) {
				ArrayList<Integer> cand = new ArrayList<>();
				cand.add(0);
				for (int j=i+k; j<n; j+=k) {
					int prev=cand.get(cand.size()-1);
	                int flip = (r[j-k] ^ r[j-k+1]);
	                cand.add(prev ^ flip);
				}
				
				int sum0 = 0;
	            for (int x : cand) sum0 += x;
	            int sum1 = cand.size()-sum0;
	            
	            minsum+=Math.min(sum0, sum1);
	            
	            if (sum1<sum0) {
	            	parity^=1;
	            }
	            
	            mindiff = Math.min(mindiff, Math.abs(sum0-sum1));
			}
			
			long minans = minsum+((parity!=r[0])? mindiff:0);
			long maxans = n-(minsum+((((parity+k)&1)!=r[0])? mindiff:0));
			
			System.out.println(minans +" "+maxans);
			
			
			
		}
		in.close();
	}

}
