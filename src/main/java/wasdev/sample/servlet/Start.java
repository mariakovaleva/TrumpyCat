package wasdev.sample.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;

public class Start {
	
	public static void main(String args[])
	{
		final String USER="f4213659-1594-4f60-88df-9c37d3e2ec37";
		final String PASS="F6DwD7JCvw6B";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		String date=String.valueOf(sdf.format(currentTime));
		NaturalLanguageUnderstanding service =new NaturalLanguageUnderstanding(date,
				  USER,
				  PASS);
		
		service.setEndPoint("https://gateway-fra.watsonplatform.net/natural-language-understanding/api");


		
		String test="Well, I hate banks, I just can't stand 'em Gimme a shovel and, man, I'll plant 'em Six feet under, that's where they belong I Hate Banks\" is the name of this song I think I'll rob myself one or two I hate banks, yeah, how 'bout you? Well, lend me a nickel and lend me a dime"; 
				
		Request RehTest=new Request(service, 2005, test);
		System.out.println(RehTest.ReturnRequest());
	}

}
