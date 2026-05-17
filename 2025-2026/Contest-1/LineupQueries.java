import java.util.*;
public class LineupQueries {
	
	public static long query1(long c, long t) {
		if (c*2 > t) {
			return c;
		}
		
		long time=c*2-1; t-=time;
		long pos=c;
		while (t>=0) {
			if (t<=pos) {
				return pos-t;
			}
			
			time+=pos;
			t-=pos;
			pos = 0;
			
			time++;
			t--;
			pos=time/2;
			
		}
		
		return pos;
	}
	
	public static long query2(long x, long t) {
		if (t==0) {
			return x;
		}
		if (x<t/2) {
			long step =Math.max(1, (t-2*x)/3);
			return query2(x+step,t-step);
		}
		if (x==t/2) {
			return query2(0,t-1);
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		while (tc-->0) {
			int q = in.nextInt();
			long c = in.nextLong();
			long t = in.nextLong();
			if (q==1) {
				System.out.println(query1(c,t));
			}else {
				System.out.println(query2(c,t));
				
			}
		}
		in.close();
	}

}
