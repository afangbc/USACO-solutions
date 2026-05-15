import java.util.*;
public class LineupQueries {
	public static long query1(long c,long t) {
		if (t==2) {
			if (c==1) return 0;
			if (c==0) return 1;
			if (c==2) return 2;
		}
		
		if (t<c*2) {
			return c;
		}else {
			long time=c*2;
			long pos=c;
			long startpos=c;
			while (true) {
				//start moving toward pos 0
				time = time+pos-1;
				pos=0;
//				System.out.println(time);
				if (time>=t)break;
				time++;
				//get rotated
				long lenofrotation=time/2;
				pos=lenofrotation;
				startpos=lenofrotation;
				if (time>=t)break;
				time++;
			}
//			System.out.println(startpos+" "+time);
			long ans=0;
			if (pos==0) {
				long starttime=time-startpos;
				ans=startpos-(t-starttime);
			}else {
				ans=pos;
			}
			return ans;
			
		}
	}
	
	public static long query2(long x, long t) {
		if (t==0) return x;
		if (x < t/2) {
			long step = Math.max(1, (t-2*x )/3);
			return query2(x+step, t-step);
		}
		if (x==t/2) {
			return query2(0,t-1);
		}
		return x;
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		while (Q-->0) {
			int type = in.nextInt();
			if (type==1) {
				long c=in.nextLong();
				long t=in.nextLong();
				System.out.println(query1(c,t));
			}else {
				long x=in.nextLong();
				long t=in.nextLong();
				System.out.println(query2(x,t));
			}
				
		}
		in.close();
	}

}
