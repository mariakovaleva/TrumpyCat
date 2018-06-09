package wasdev.sample.servlet;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class BeforeWatsonParser {
	
	public BeforeWatsonParser() {}
	
	public static void main(String[] args)
	{
		Object[] temp = urlToArray("http://www.britishpoliticalspeech.org/speech-archive.htm?speech=367");
		System.out.println(String.valueOf(temp[0]));
		System.out.println(temp[1]);
		
	}
	
	public static Object[] urlToArray(String url) {
		
		Object[] yearAndBody = new Object[2]; 
		
		try {
			Document doc = (Document) Jsoup.connect(url).get();
			String tempString = doc.getElementsByTag("h3").toString();
			tempString = tempString.substring(tempString.length()-9, tempString.length()-5);
			yearAndBody[0] = Integer.parseInt(tempString);
			yearAndBody[1] = doc.getElementsByClass("speech-content").text();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		return yearAndBody;

	}

}
