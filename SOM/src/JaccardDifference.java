import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class JaccardDifference {
	
	List<List<String>> methodsTags = new ArrayList<List<String>>();
	int totalMethods; 
	double dist[][];  										 //Distance of each method with the rest 
	int[] minDist;	 										//index of closest cluster
	int[] maxDist; 											// index of farthest cluster
	static List<Integer> neurons= new ArrayList<Integer>();

	public JaccardDifference(List<List<String>> tagsList){
		methodsTags = tagsList;
		totalMethods = methodsTags.size();
		dist = new double[totalMethods][totalMethods];
		maxDist = new int[totalMethods];
		minDist = new int[totalMethods];
		createDistanceMatrix(dist, methodsTags, maxDist, minDist);
	}
	
	public static void createDistanceMatrix(double d[][], List<List<String>> list, int maxD[], int minD[] ){
		for (int i=0; i<d.length; i++){
			for (int j=0; j<d[i].length; j++){
				if (i==j) d[i][j]=2.0;
					//d[i][j] = Double.POSITIVE_INFINITY;
				else {
					d[i][j] = calculateJaccardDifference(list.get(i), list.get(j));
				}
				if (d[i][j]<d[i][minD[i]] && d[i][j]!=2)
					minD[i] = j;
				//Maintain  index of farthest cluster
				
				if (d[i][j]>d[i][maxD[i]] && i!=j)
					maxD[i] = j;
				else if (i==0 && j==0) maxD[i] = 1;  
			}
		}
		
		//neurons = new ArrayList<Integer>(Arrays.asList(maxD));
		for (int i=0; i<maxD.length; i++){
			if (maxD[i]>=1.0){
				neurons.add(maxD[i]);
			}
		}
		System.out.println("\nNeurons list with duplication: " + neurons);
		
		//Duplication removal from neurons list
		neurons = new ArrayList<Integer>(new LinkedHashSet<Integer>(neurons));
		//Sorting of neurons
		Collections.sort(neurons);
		System.out.println("Neurons list after duplication removal: " + neurons + "\n");
		System.out.println("****** Distance Matrix **********");
		for (int i=0; i<d.length; i++){
			System.out.print("Node-" + i + ": ");
			for(int j=0; j<d[i].length; j++){
			//for (int j=0; j<i; j++){
				System.out.print(Math.round(d[i][j]*100.0)/100.0 + "	");
			}
			System.out.println();
		}
				
		System.out.println();
		for(int i=0; i<maxD.length; i++){
			System.out.println("max distant node of  node " +i+": "+ maxD[i]);
		}
		
		System.out.println();
		for(int i=0; i<minD.length; i++){
			System.out.println("min distant node of  node " +i+": "+ minD[i]);
		}
	}
	 
	private static double calculateJaccardDifference(List<String> list1, List<String> list2){
		double jaccardDifference = 1- calculateJaccardSimilarity(list1, list2);
		return jaccardDifference;
		
	}

	private static double calculateJaccardSimilarity(List<String> list1, List<String> list2){
		 List<String> unions = new ArrayList<String>();
		 List<String> intersections = new ArrayList<String>();
		 double similarity;
		unions = findUnion(list1, list2);
		/* System.out.print("Union: ");
		 for (int i=0; i<unions.size(); i++){
			 System.out.print(unions.get(i) + '\t');
		 }
		 System.out.println();*/
			 
		// Intersection of 1st two methods	 
		 intersections = findIntersection(list1, list2);
		 /*System.out.print("Intersection: ");
		 for (int i=0; i<intersections.size(); i++){
			 System.out.print(intersections.get(i) + '\t');
		 }
		 System.out.println();*/
		 similarity = jaccardSimilarity(intersections, unions);
		 //System.out.println("Similarity: " + similarity);
		 return similarity;
		 
		
	}
	private static <T> List<T> findUnion(List<T> list1, List<T> list2) {
	        Set<T> set = new HashSet<T>();

	        set.addAll(list1);
	        set.addAll(list2);

	        return new ArrayList<T>(set);
	    }

    private static <T> List<T> findIntersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
    
    private static  <T> double jaccardSimilarity(List<T> list1, List<T> list2){
    	float intersectionCount = list1.size();
    	float unionCount = list2.size();
    	return intersectionCount/unionCount;
    }
 
    public List<Integer> getNeurons(){
		return neurons;
	}
	
}
