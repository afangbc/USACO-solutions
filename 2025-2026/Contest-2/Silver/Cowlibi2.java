import java.util.*;
public class Cowlibi2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int c = in.nextInt();
		while (t-->0) {
			int n = in.nextInt();
			in.nextLine();
			
			char[] l = in.nextLine().toCharArray();
			char[] r = in.nextLine().toCharArray();
			
			int[] a = new int[n];
			// JN, NJ, JJ, NN
			int[] typecnt = new int[4];
			
			ArrayList<Integer> w = new ArrayList<>();
			ArrayList<Integer> x = new ArrayList<>();
			ArrayList<Integer> y = new ArrayList<>();
			ArrayList<Integer> z = new ArrayList<>();
			
			for (int i=0; i<n; i++) {
				if (l[i]=='J' && r[i]=='N' ) {
					w.add(i);
					a[i]=0;
				} else if (l[i]=='N' && r[i]=='J' ) {
					x.add(i);
					a[i]=1;
				}else if (l[i]=='J' && r[i]=='J' ) {
					y.add(i);
					a[i]=2;
				} else {
					z.add(i);
					a[i]=3;
				}
				typecnt[a[i]]++;
			}
			
			if (typecnt[0]!=typecnt[1]) {
				System.out.println("NO");
				continue;
			}else if ((typecnt[1]+typecnt[3])%2==1){
				System.out.println("NO");
				continue;
			}else if ((typecnt[2]>0 && typecnt[3]>0) && (typecnt[0]==0 && typecnt[1]==0)) {
				System.out.println("NO");
				continue;
			}
			
			System.out.println("YES");
			if (c==0) continue;
			
			
			ArrayList<Integer> arr = new ArrayList<>();
			ArrayList<Integer> str = new ArrayList<>();
			int parity=1;
			if (typecnt[0]-->0) {
				arr.add(w.get(typecnt[0]));
				str.add(parity);
				parity*=-1;
			}
			while (typecnt[3]-->0) {
				arr.add(z.get(typecnt[3])); 
				str.add(parity);
				parity*=-1;
			}
			if (typecnt[1]-->0) {
				arr.add(x.get(typecnt[1])); 
				str.add(parity);
			}
			while (typecnt[2]-->0) {
				arr.add(y.get(typecnt[2])); 
				str.add(parity);
			}
			while (typecnt[0]-->0 && typecnt[1]-->0) {
				arr.add(w.get(typecnt[0])); 
				str.add(parity);
				parity*=-1;

				arr.add(x.get(typecnt[1])); 
				str.add(parity);
			}
			for (int i=0; i<n; i++) {
				System.out.print(arr.get(i)+1);
				if (i!=n-1) System.out.print(" ");
			}
			System.out.println();
			for (int i=0; i<n; i++) {
				if (str.get(i)==1) System.out.print("J");
				else System.out.print("N");
			}
			System.out.println();
		}
		in.close();
	}

}
