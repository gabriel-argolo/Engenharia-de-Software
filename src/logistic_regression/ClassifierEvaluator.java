package logistic_regression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class ClassifierEvaluator
{

	//total number of messages that we tested.
	private int number_of_messages_tested;

	//the total number of messages that we correctly classified as ling.
	private int TrueNegatives;
	
	//the total number of messages that we correctly classified as spam.
	private int TruePositives;
	
	//the total number of messages that we wrongly classified as ling.
	private int FalseNegatives;
	
	//the total number of messages that we wrongly classified as spam.
	private int FalsePositives;

	//The classifier that we want to evaluate;
	private LogisticRegressionClassifier lg;
	
	
	
	
    public ClassifierEvaluator(LogisticRegressionClassifier lg)
	{
 		this.lg=lg;
		this.number_of_messages_tested=0;
		this.TrueNegatives=0;
		this.TruePositives=0;
		this.FalseNegatives=0;
		this.FalsePositives=0;
	}
	
	
    
    
 	public void Evaluate()
 	{
 		lg.train("dataset/lingMessages" , "dataset/spamMessages");
 		Classify("dataset/testMessages");
 	}
 	
 	
 	
 	
	//Classifies the incoming messages. Returns true if message is a spam , false otherwise.
	private void Classify(String testPath)
	{
		File f = new File(testPath);
		File[] files = f.listFiles();
			
		this.number_of_messages_tested=files.length;
		
		try
		{
			
			for(File fl : files)
			{
				BufferedReader br = new BufferedReader(new FileReader(fl));
				
				String msg="";
					
				String line = br.readLine();
					
				while(line!=null) 
				{
					msg+=line;
					line=br.readLine();
				}
				
				boolean result = lg.classify(msg);
				
				if(fl.getName().contains("spm") && result)        TruePositives++;
				else if (fl.getName().contains("spm") && !result) FalseNegatives++;
				else if(!fl.getName().contains("spm") && result)  FalsePositives++;
				else if(!fl.getName().contains("spm") && !result) TrueNegatives++;
				
				br.close();
			} 
		}
			
		catch(Exception e)
		{
				System.err.println("ERROR : "+e.getMessage());
		}
	}
	
	
	
	
	public double getAccuracy()
	{
		if(number_of_messages_tested==0) return 0;
		return ( (double)(TruePositives + TrueNegatives)/(double)number_of_messages_tested);
	}
	
	
	
	
	public double getPrecision()
	{
		if((TruePositives + FalsePositives)==0) return 0;
		return  ( (double)TruePositives / (double)(TruePositives + FalsePositives));
	}
	
	
	
	
	public double getRecall()
	{
		if((TruePositives + FalseNegatives)==0) return 0;
		return ((double)TruePositives / (double)(TruePositives + FalseNegatives));
	}
	
	
	
	
	public double getFMeasure()
	{
		double precision = getPrecision();
		double recall = getRecall();
		
		if(precision + recall == 0) return 0;
		return (2 * precision * recall)/(precision + recall); 
	}
}