package wasdev.sample.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;

public class Start {
	
	private static LinkedList<Object[]> unprocessedData = new LinkedList<Object[]>();
	
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

		String baseURL = "http://www.britishpoliticalspeech.org/speech-archive.htm?speech=";
		Object[] result = new Object[2];
		for(int i=1; i<=367; i++)
		{
			result = BeforeWatsonParser.urlToArray(baseURL + String.valueOf(i));
			//if(!result[1].equals("Owing to a copyright issue this speech has been removed.")) // && !result[1].equals("Owing to a copyright claim this speech has been removed.") && !result[1].equals(null))
			//{
				unprocessedData.add(result);
				for(Object o: result)
				{
					if(o != null)
						System.out.println(String.valueOf(o));
				}
			//}
		}
	}

}
