package wasdev.sample.servlet;


import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;

public class Request {
	NaturalLanguageUnderstanding ser;
	final int year;
	final String body;
	Object[] re;

	
	public Request(NaturalLanguageUnderstanding service, int yea, String bod){
		
		ser=service;
		year=yea;
		body=bod;
		re=new Object[2];
		
		
	}
	public Object[] ReturnRequest( )
	{
		try {
			
			EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
					  .emotion(true)
					  .sentiment(true)
					  .limit(10)
					  .build();
			
			KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
					  .emotion(true)
					  .sentiment(true)
					  .limit(10)
					  .build();

			
			Features features = new Features.Builder()
					  .entities(entitiesOptions)
					  .keywords(keywordsOptions)
					  .build();
			
			AnalyzeOptions parameters = new AnalyzeOptions.Builder()
					  .text(this.body)
					  .features(features)
					  .build();

			AnalysisResults response = ser
					  .analyze(parameters)
					  .execute();
			
			re[0]=response;
			re[1]=year;



		
		}
		catch(ServiceResponseException e)
		{
			System.out.println(e.getStatusCode()+"\n"+e.getMessage());
		}
		return re ;

	}
	

}
