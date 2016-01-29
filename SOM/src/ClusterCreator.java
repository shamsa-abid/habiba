import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ClusterCreator {
	
	private int tVectorLength;
	private int maxClusters;
	private double minAlpha;
	private double alpha;
	private double decayRate;
	private int iterations;
	private int clusterSize;
	
	private double dist[];
	
	private List<Integer>cluster1 = new ArrayList<Integer>();
	private List<Integer>cluster2 = new ArrayList<Integer>();
	private List<Integer>cluster3 = new ArrayList<Integer>();	
	private List<Integer>cluster4 = new ArrayList<Integer>();
	private List<Integer>cluster5 = new ArrayList<Integer>();
	private List<Integer>cluster6 = new ArrayList<Integer>();
	private List<List<Float>> neurons = new ArrayList<List<Float>>();
	private List<List<Integer>> clusters = new ArrayList<List<Integer>>();
	
	public ClusterCreator(int max_Clusters, int cluster_Size, double alpha_Start, double min_Alpha, double decay_Rate, int methodVector_Size){
		maxClusters =  max_Clusters;
		clusterSize = cluster_Size;
		tVectorLength = cluster_Size;
		alpha = alpha_Start;
		minAlpha = min_Alpha;
		decayRate = decay_Rate;
		//trainingVectorSize = methodVector_Size;
		dist = new double[maxClusters];
		iterations = 0;
		Random r = new Random();
		
	    //default neurons
		/*for(int i = 0; i <  maxClusters; i++){
	    	List<Float> neuron = new ArrayList<Float>();
	    	for (int k=0; k<clusterSize; k++)
	    		neuron.add((float)(Math.floor(r.nextFloat()*100.0)/100.0));
	    	neurons.add(neuron);
	    }*/
		
		
		    /*for (int i=0; i<neurons.size();i++){
		    	List<Float> neuron = neurons.get(i);
		    	System.out.println("neuron-"+ i + ": " + neuron);
		    	
		    }*/
	}
	
	public void initializeNeurons(List<List<Integer>> methodVector){
		
		List<Float> neuron1 = new ArrayList<Float>();
		for (Integer n: methodVector.get(0)){
			neuron1.add(n.floatValue());
		}
		
		List<Float> neuron2 = new ArrayList<Float>();
		for (Integer n: methodVector.get(1)){
			neuron2.add(n.floatValue());
		}
		
		List<Float> neuron3 = new ArrayList<Float>();
		for (Integer n: methodVector.get(3)){
			neuron3.add(n.floatValue());
		}
		List<Float> neuron4 = new ArrayList<Float>();
		for (Integer n: methodVector.get(4)){
			neuron4.add(n.floatValue());
		}
		List<Float> neuron5 = new ArrayList<Float>();
		for (Integer n: methodVector.get(5)){
			neuron5.add(n.floatValue());
		}
		List<Float> neuron6 = new ArrayList<Float>();
		for (Integer n: methodVector.get(10)){
			neuron6.add(n.floatValue());
		}
		neurons.add(neuron1);
		neurons.add(neuron2);
		neurons.add(neuron3);
		neurons.add(neuron4);
		neurons.add(neuron5);
		neurons.add(neuron6);
		
		for (int i=0; i<neurons.size();i++){
    	List<Float> neuron = neurons.get(i);
    	System.out.println("neuron-"+ i + ": " + neuron);
    	
    }
		
		
	}
	public void trainNeurons(List<List<Integer>> trainingVector)
	{
		int vecNum;
		int minDistanceIndex;

	    while(alpha > minAlpha)
	    {
	        iterations += 1;

	        for(vecNum = 0; vecNum < trainingVector.size(); vecNum++)
	        {
	        	List<Integer> trainingData = trainingVector.get(vecNum);
	        	
	        	// Compute distance
	            computeDistance(vecNum, trainingData);
	            
	            //Find the smallest distant neuron
	            minDistanceIndex = computeSmallestDistanceIndex();
	            System.out.println("Method #: " + vecNum + " Closest neuron is: " + minDistanceIndex );
	            List<Float> neuron = neurons.get(minDistanceIndex);
	            
	            
	            //Update the weights on the winning neuron.
	            for(int i = 0; i < trainingData.size(); i++){
	            	float x ;//= neuron.get(i);
	                x= (float)Math.floor((neuron.get(i) + alpha * (trainingData.get(i)-neuron.get(i)))*100)/100;
	                neuron.set(i,x);	                
	            }
	            neurons.set(minDistanceIndex, neuron);
	            System.out.println("Upated neurons");
	            for (int i=0; i<neurons.size(); i++){
	            	System.out.println("neuron-" + i + ": " + neurons.get(i));
	            }
	        }

	        // Reduce the learning rate.
	        alpha = decayRate * alpha;

	    }
	    return;
	}
	
	public void clusterMethods(List<List<Integer>> methodVector){
		
			int minDistanceIndex;		

			// Print clusters created.
			System.out.println("Clusters for training input:");
			for(int vecNum = 0; vecNum < methodVector.size(); vecNum++)
	        {
	        	List<Integer> method = methodVector.get(vecNum);
	        	
	        	//Find nearest neuron
	            computeDistance(vecNum, method);
	            minDistanceIndex = computeSmallestDistanceIndex();
	            System.out.println("Method #: " +vecNum + " clusers with neuron #: " +minDistanceIndex);
	            
	            /********** Have to make this code dynamic,,,,it is static yet  *********/
	            /************************************************************************/
	            if(minDistanceIndex == 0)
	            	cluster1.add(vecNum);
	            else if(minDistanceIndex == 1)
	            	cluster2.add(vecNum);
	            else if(minDistanceIndex ==2)
	            	cluster3.add(vecNum);	
	            else if(minDistanceIndex == 3)
	            	cluster4.add(vecNum);
	            else if(minDistanceIndex ==4)
	            	cluster5.add(vecNum);
	            else if(minDistanceIndex ==5)
	            	cluster6.add(vecNum);	
	        }
		    
		    return;		
	}
	
	private void computeDistance(int trainingVectorNumber, List<Integer> trainingData)
	{
	
		//Initialize all distances to zero
		int j;
	    for(int i=0; i<dist.length; i++){
	    	dist[i] = 0.0;
	    }
	    
	    for(int i = 0; i < maxClusters; i++){	    
	    	List<Float> neuron = neurons.get(i);
        	
        	System.out.println("\n\n neuron: " + neuron);
        	System.out.println("training data: " + trainingData);
        	
        	//Add up distances of a neuron from a training/method vector
	        for( j = 0; j < tVectorLength; j++){	        	
	        	dist[i] += Math.floor(Math.pow((neuron.get(j) - trainingData.get(j)), 2)*100)/100;	        	
	        } // j
	    } // i
	    
	    for(int i=0; i<dist.length; i++){
	    	System.out.print("D= " + i + ": "+  dist[i] + "\t");
	    }
    	System.out.println();
	    return;
	}
	
	//Returns index number of nearest neuron
	private int computeSmallestDistanceIndex(){
		int  min = 0; //index number of nearest neuron
		for (int i=1; i<dist.length; i++ ){
			if (dist[i]<dist[min]) min = i;
		}
		return min;
	}
	
	//Returns number of iterations/epochs
	public int getIterations()
	{
		return iterations;
	}

	
	//Returns value of learning factor
		public double getAlpha()
		{
			return alpha;
		}
	//Displays resultant clusters
	public void displayClusters(){
		System.out.println("Cluster#1: " + cluster1);
		System.out.println("Cluster#2: " + cluster2);
		System.out.println("Cluster#3: " + cluster3);
		System.out.println("Cluster#4: " + cluster4);
		System.out.println("Cluster#5: " + cluster5);
		System.out.println("Cluster#6: " + cluster6);
		
	}
	
}
