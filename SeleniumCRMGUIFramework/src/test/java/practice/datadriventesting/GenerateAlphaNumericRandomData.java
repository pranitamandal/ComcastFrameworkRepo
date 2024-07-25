package practice.datadriventesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		int n=20;
		//choose a character random from this string
		String AlphaNumericstring="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		//create string buffer size of alphanumericstring
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0; i<n; i++) {
			//generate a random number between 0 to alphanumeric string variable length
			int index=(int)(AlphaNumericstring.length()*Math.random());
			
			//add character one by one in end of sb
			sb.append(AlphaNumericstring.charAt(index));
		}
System.out.println(sb);
	}

}
