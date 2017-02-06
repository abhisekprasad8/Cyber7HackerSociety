import java.util.Scanner;
public class vigenere {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String plaintext,ciphertext="";
		String key;
		
		System.out.println("Input key word ");
		key=sc.next();
		
		System.out.println("Input plaintext ");
		plaintext=sc.next();
		System.out.println("Plaintext : "+plaintext);
		
		ciphertext=encrypt(plaintext,key);		
		System.out.println("After encryption Ciphertext : "+ciphertext.toUpperCase());
		
		 decrypt(ciphertext,key);
		System.out.println("After decryption Plaintext : "+plaintext);
	}
	
	public static String encrypt(String plaintext,String key)
	{
		int j=0,n=key.length();
		String ciphertext="";
		for(int i=0;i<plaintext.length();i++)
		{
			char ch=plaintext.charAt(i);//1. get i th character from plaintext
			char c=key.charAt(j%n);//2. get (j%n) th character from key
			int v=c-'a'+1;
			int a=((int)(ch-'a'+v+26))%26+'a';//3. shift i th character by (j%n)th key character positions
			
			
			
			//4. find ciphertext character by converting to uppercase
			ciphertext=ciphertext+(char)a;//5. append this character to ciphertext
					
			j++;
		}
		System.out.print(ciphertext);
		
		return ciphertext;
	}
	
	public static String decrypt(String ciphertext,String key)
	{
		int j=0,n=key.length();
		String plaintext="";
		for(int i=0;i<ciphertext.length();i++)
		{
			char ch= ciphertext.charAt(i);//1. get i th character from ciphertext
			int c=j%n;//2. get (j%n) th character from key
			int v=c-'a'+1;
			int a=((int)ch-v-'a'+26)%26+'a';//3. shift back i th character by (j%n)th key character positions
			char ch1=(char)a;
			//4. find plaintext character by converting to lowercase
			plaintext=plaintext+ch1;//5. append this character to plaintext	
			
			j++;
		}
		return plaintext;
	}
}