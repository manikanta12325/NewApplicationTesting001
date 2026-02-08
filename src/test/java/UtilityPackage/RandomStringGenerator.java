package UtilityPackage;

import java.util.Random;

public class RandomStringGenerator {
	
	private Random random = new Random();
	
	private String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	private String NUMBER = "0123456789";
	
	private String ALPHANUMERIC = ALPHA + NUMBER;
	
	private String stringGenerator(int n,String text)
	{
		StringBuffer output = new StringBuffer();
		
		for(int i=0;i<=n-1;i++)
		{
			int index = random.nextInt(text.length());
			
			output.append(text.charAt(index));
			
		}
		
		return output.toString();
	}
	
	public String getRandomString(int n)
	{
		return stringGenerator(n,ALPHA);
	}
	
	public String getRandomNumber(int n)
	{
		return stringGenerator(n,NUMBER);
	}
	
	public String getRandomAlphaNumeric(int n)
	{
		return stringGenerator(n,ALPHANUMERIC);
	}

}
