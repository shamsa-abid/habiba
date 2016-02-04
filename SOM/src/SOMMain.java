import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;


public class SOMMain {
	
	//public static final int MAX_CLUSTERS = 6;
	public static final double DECAY_RATE = 0.96;
	public static final double MIN_ALPHA = 0.001;
	
	public static void main (String args[]) {
	 
		 double alpha = 0.6;
		 int maxClusters;
		 List<List<String>> methodsTags = new ArrayList<List<String>>();
		 List<List<Integer>> methodsVector = new ArrayList<List<Integer>>();
		 List<String> featureVector = new ArrayList<String>();
		 List<Integer> neuronsList = new ArrayList<Integer>();
		 MethodVectorCreation mVec = new MethodVectorCreation();
		 MethodTagsCreation mTag = new MethodTagsCreation();
		 
		
		 
		 methodsTags = mTag.populateMethodTagsList(methodsTags);
		 JaccardDifference jD = new JaccardDifference(methodsTags);
		 neuronsList = jD.getNeurons();
		 maxClusters = neuronsList.size();
		 //jD.populateMethodsTags(methodsTags);
		 
		 
		 //Population of Feature Vector
		 for (List<String> tags: methodsTags){
			 featureVector.addAll(tags);
		 }
		 	
		 //Duplication removal from Feature Vector
		 featureVector = new ArrayList<String>(new LinkedHashSet<String>(featureVector));		 
		 methodsVector = mVec.populateMethodVector(methodsTags, featureVector);
		 ClusterCreator clusters = new ClusterCreator(neuronsList, maxClusters, featureVector.size(), alpha, MIN_ALPHA, DECAY_RATE, methodsVector.size() );
		
		
		 clusters.initializeNeurons(methodsVector);
		 clusters.trainNeurons(methodsVector);
		 		 
		 clusters.clusterMethods(methodsVector);
		 System.out.println("Feature Vector Size: " + featureVector.size() );
		 System.out.println("Total epochs: " + clusters.getIterations());
		 System.out.println("Final value of learning factor: " + clusters.getAlpha());
		 System.out.println("\nFinal clusters:");
		 clusters.displayClusters();
		 
		 /********Temporary display of method vector for a test***/
		 /*System.out.println("Method Vectors");
			for (int i=0; i<methodsVector.size(); i++)
				System.out.println("M-" + i + ": " +methodsVector.get(i));*/
	}	
	}
