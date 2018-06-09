package wasdev.sample.servlet;
import org.json.*;


public class ProcessedResponse {
	
	private double[] emotions;
	private double[] sentiment;

	public ProcessedResponse (JSONObject o, int y) {
		
		//emotions array
				emotions = new double[7];
				
				//year
				emotions[0] = y;
				
				//joy
				emotions[2] = Double.parseDouble(o.getJSONObject("emotion").getJSONObject("document").
						getJSONObject("emotion").getString("joy"));
				
				//anger
				emotions[3] = Double.parseDouble(o.getJSONObject("emotion").getJSONObject("document").
						getJSONObject("emotion").getString("anger"));
				
				//disgust
				emotions[4] = Double.parseDouble(o.getJSONObject("emotion").getJSONObject("document").
						getJSONObject("emotion").getString("disgust"));
				
				//sadness
				emotions[5] = Double.parseDouble(o.getJSONObject("emotion").getJSONObject("document").
						getJSONObject("emotion").getString("sadness"));
				
				//fear
				emotions[6] = Double.parseDouble(o.getJSONObject("emotion").getJSONObject("document").
						getJSONObject("emotion").getString("fear"));
		
		//sentiment array
				sentiment = new double[2];
				
				//year
				sentiment[0] = emotions[0];
				
				//sentiment
				sentiment[1] = Double.parseDouble(o.getJSONObject("sentiment").getJSONObject("document").
						getJSONObject("sentiment").getString("score"));
		
		
	}
	
	public double[] getEmotions()
	{
		return emotions;
	}
	
	public double[] getSentiment()
	{
		return sentiment;
	}
	
}
