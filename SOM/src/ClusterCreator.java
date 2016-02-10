import java.util.ArrayList;
import java.util.List;
//import java.util.Random;


public class ClusterCreator {
	
	private int tVectorLength;
	private int maxClusters;
	private double minAlpha;
	private double alpha;
	private double decayRate;
	private int iterations;
	private int clusterSize;
	
	private double dist[];
	
	
	private List<Integer>neuronsList = new ArrayList<Integer>();      				//Method Numbers for initial neurons
	private List<List<Float>> neurons = new ArrayList<List<Float>>();
	private List<List<Integer>> clusters = new ArrayList<List<Integer>>();
	
	public ClusterCreator(List<Integer> neuronsNumbers, int max_Clusters, int cluster_Size, double alpha_Start, double min_Alpha, double decay_Rate, int methodVector_Size){
		neuronsList = neuronsNumbers;
		maxClusters =  max_Clusters;
		clusterSize = cluster_Size;
		tVectorLength = cluster_Size;
		alpha = alpha_Start;
		minAlpha = min_Alpha;
		decayRate = decay_Rate;
		//trainingVectorSize = methodVector_Size;
		dist = new double[maxClusters];
		iterations = 0;
		clusters = new ArrayList<List<Integer>>(maxClusters);
		//Random r = new Random();
		
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

		for (int i=0; i<neuronsList.size(); i++){
			List<Float> neuron = new ArrayList<Float>();;
			for (Integer n: methodVector.get(neuronsList.get(i))){
				neuron.add(n.floatValue());
			}
			neurons.add(neuron);
		}
		
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
	            //System.out.println("Method #: " + vecNum + " Closest neuron is: " + minDistanceIndex );
	            List<Float> neuron = neurons.get(minDistanceIndex);
	            
	            
	            //Update the weights on the winning neuron.
	            for(int i = 0; i < trainingData.size(); i++){
	            	float x ;//= neuron.get(i);
	                x= (float)Math.floor((neuron.get(i) + alpha * (trainingData.get(i)-neuron.get(i)))*100)/100;
	                neuron.set(i,x);	                
	            }
	            neurons.set(minDistanceIndex, neuron);
	            /*System.out.println("Upated neurons");
	            for (int i=0; i<neurons.size(); i++){
	            	System.out.println("neuron-" + i + ": " + neurons.get(i));
	            }*/
	        }

	        // Reduce the learning rate.
	        alpha = decayRate * alpha;

	    }
	    return;
	}
	
	public void clusterMethods(List<List<Integer>> methodVector){
		
			int minDistanceIndex;
			List<Integer> nearestNeuronList = new ArrayList<Integer>(); //List of neuron numbers which is nearest to the method
			
						
			// Print clusters created.
			//System.out.println("Clusters for training input:");
			for(int vecNum = 0; vecNum < methodVector.size(); vecNum++)
	        {
	        	List<Integer> method = methodVector.get(vecNum);
	        	//List<Integer> methodNumber = new ArrayList<Integer>();
	        	//Find nearest neuron
	            computeDistance(vecNum, method);
	            
	            //Find the index of the nearest neuron
	            minDistanceIndex = computeSmallestDistanceIndex();
	            System.out.println("Method # "+ vecNum + " clusters with neuron # "+ minDistanceIndex);
	            
	            //Place the found index number in the arraylist
	            nearestNeuronList.add(minDistanceIndex);
	            
	           // methodNumber.add(vecNum);
	           
	        }
			System.out.println("Nearest neurons list: " + nearestNeuronList);
			for (int i=0; i<maxClusters; i++){
				List<Integer> methodsIndices = new ArrayList<Integer>();
				for (int j=0;j<nearestNeuronList.size(); j++){
					if (i==nearestNeuronList.get(j)){
						methodsIndices.add(j);
					}
				}
				clusters.add(i, methodsIndices);
				System.out.println("Cluster # " + i + " has methods: " + clusters.get(i));
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
        	
        	//System.out.println("\n\n neuron: " + neuron);
        	//System.out.println("training data: " + trainingData);
        	
        	//Add up distances of a neuron from a training/method vector
	        for( j = 0; j < tVectorLength; j++){	        	
	        	dist[i] += Math.floor(Math.pow((neuron.get(j) - trainingData.get(j)), 2)*100)/100;	        	
	        } // j
	    } // i
	    
	    /*for(int i=0; i<dist.length; i++){
	    	System.out.print("D= " + i + ": "+  dist[i] + "\t");
	    }
    	System.out.println();*/
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
		for (int i=0; i<clusters.size(); i++){
			System.out.println("Cluster# " + i + ": " + clusters.get(i));
		}
			
		
	}
	public List<List<Integer>> getNeurons(){
		return clusters;
	}
	
}
