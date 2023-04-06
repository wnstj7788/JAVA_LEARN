
public class PivoTest2 {
	 
	public static void main(String[] args) {
		long[] pivo=new long[93];
		pivo[0]=0L;
		pivo[1]=1L;   
		System.out.println(1+"= "+pivo[1]);
		for (int i = 2; i <11; i++) {
			pivo[i]=pivo[i-1]+pivo[i-2];
			System.out.println(i+"= "+pivo[i]);
		}
		for (int i = 11; i <93; i++) {
			if(i%2==0) {
				pivo[i]=pivo[i/2]*(2*pivo[i/2-1]+pivo[i/2]);
			}else {
				pivo[i]=pivo[i/2+1]*pivo[i/2+1]+pivo[i/2]*pivo[i/2];
			}
			System.out.println(i+"= "+pivo[i]);
		}
	}

}
