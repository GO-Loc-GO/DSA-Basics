package ds_labs;

public class PatternMatching {
	
	private static int BruteForceSearch(String text, String pattern) {
		
		char[] t = text.toCharArray();
		char[] p = pattern.toCharArray();
		int i=0;
		int j;
		while(i<t.length-p.length+1) {
			j=0;
			while(j < p.length && t[i+j]==p[j]) {
				j++;
			}
			if(j==p.length) {
				return  i; 
			}
			i++;
		}
		
		return -1;
		
	}
	
	
	private static int[] FailureFunction(String pattern) {
		int[] fn = new int[pattern.length()];
		fn[0] = 0;
		int i = 1;
		int j = 0;
		char[] p = pattern.toCharArray();
		while(i<pattern.length()) {
			if(p[i]==p[j]) {
				fn[i]=j+1;
				j++;
				i++;
			}
			else if(j>0) {
				j = fn[j-1];
			}
			else {
				fn[i] = 0;
				i = i+1;
			}
				
		}
		
		return fn;
	}
	
	private static int KMPSearch(String text, String pattern) {
		char[] t = text.toCharArray();
		char[] p = pattern.toCharArray();
		int[] F = FailureFunction(pattern);
		int i = 0;
		int j = 0;
		while(i<text.length()) {
			if(t[i]==p[j]) {
				if(j == pattern.length()-1) {
					return i-j;
				}
				else {
					i++;
					j++;
				}
			}
			else {
				if(j>0) {
					j = F[j-1];
				}
				else {
					i = i+1;
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String text = "a pattern matching algorithm";
		String pattern = "rithm";
		int result1 = BruteForceSearch(text, pattern);
		int result2 = KMPSearch(text, pattern);
		System.out.println(result1);
		System.out.println(result2);

	}

}
