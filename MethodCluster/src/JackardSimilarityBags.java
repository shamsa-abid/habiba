import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
//import java.util.Arrays;
import java.util.List;
//import com.google.common.collect.Sets;
import java.util.Set;


public class JackardSimilarityBags {
	 public static void main (String args[]) {
		 /*String []arrayofTags= {"admissions", "applications", "degree", 
			"fee crietra", "pre requisite", "application requirements", "tution fee",
			"qualification", "admission dates", "admission documents",
			"weapon styles", "weapon types", "number of players", "game modes"
			};*/
		 //int size = arrayofTags.length;
		 //String arrayofTagsCount[][] = new String[size][];
		// List<List<String>> arrayofTagsCount = new ArrayList<List<String>>();
		 //List<String> unions = new ArrayList<String>();
		 //List<String> intersections = new ArrayList<String>();
		 //List<String> method1Tags = new ArrayList<String>("degree", "admissions", "applications");
		// List<List<String>> recommendedCodeTags = new ArrayList<List<String>>();
		// recommendedCodeTags.add(0, ("degree", "admissions", "applications"));
		/* String [][]recommendedCodeTags={
			{"degree", "admissions", "applications"},
			{"degree", "tution fee", "application requirements"},
			{"weapon styles", "weapon types", "number of players"},
			{"weapon types", "weapon styles", "number of players"},
			{"weapon styles",  "number of players", "weapon types"},
			{"weapon styles", "game modes", "number of players"},
			{"degree", "admissions", "applications"},
			{"fee crietra", "pre requisite", "application requirements"},
			{"fee crietra",  "application requirements", "pre requisite"},
			{"admissions", "weapon styles", "degree"}
		 };*/
		 List<List<String>> methodsTags = new ArrayList<List<String>>();
		 /*methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre-requisite", "fee-criteria", "tution-fee"));
		 methodsTags.add(Arrays.asList("degree", "tution-fee", "application-requirements", "qualification", "admission-dates", "admission-documents"));
		 methodsTags.add(Arrays.asList("weapon-styles", "weapon-types", "number-of-players", "degree", "game-modes", "colour"));
		 methodsTags.add(Arrays.asList("weapon-styles", "weapon-types", "number-of-players","degree", "game-modes", "colour-selection"));
		 methodsTags.add(Arrays.asList("weapon-styles",  "numbe-of-players", "weapon-types", "instructions", "demo", "colour-selection"));
		 methodsTags.add(Arrays.asList("weapon-styles", "game-modes", "number-of-players", "demo", "level-selection", "player-info"));
		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "admission-form", "admission-dates", "eligibility-criteria"));
		 methodsTags.add(Arrays.asList("fee-criteria", "pre-requisite", "application-requirements", "financial-aid", "test-schedule", "degree"));
		 methodsTags.add(Arrays.asList("fee-criteria",  "application-requirements", "pre-requisite", "financial-aid", "test-schedule", "degree"));
		 methodsTags.add(Arrays.asList("admissions", "weapon-styles", "degree", "number-of-players", "game-modes", "demo"));
		 methodsTags.add(Arrays.asList("SAT-I", "Programmes", "admission-process", "Admissions-and-Aid", "entry-test", "apply-online"));
		 methodsTags.add(Arrays.asList("game", "quick-instructions", "3D", "number-of-players", "help", "demo"));
		 methodsTags.add(Arrays.asList("pay-online", "registeration", "pay-modes", "website", "test-criteria", "FAQ"));*/
		 
		 
		 /******** Updated Methods for SOM *********/
		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre-requisite", "fee-criteria", "tution-fee", "help", "Undergraduate-Admissions", "Executive-Education", "Transfer-Admissions"));
		 methodsTags.add(Arrays.asList("degree", "tution-fee", "application-requirements", "qualification", "admission-dates", "admission-documents", "FAQs", "Fee-Structure", "Funds", "Tution-fee"));
		 methodsTags.add(Arrays.asList("weapon-styles", "weapon-types", "number-of-players", "degree", "game-modes", "colour", "Utilities", "Software", "Process", "Smart-Phones"));
		 methodsTags.add(Arrays.asList("weapon-styles", "weapon-types", "number-of-players","degree", "game-modes", "colour-selection", "Name", "Updates", "Software", "Platform"));
		 methodsTags.add(Arrays.asList("weapon-styles",  "numbe-of-players", "weapon-types", "instructions", "demo", "colour-selection","Updates", "Selections", "Options", "Mobile-Games" ));
		 methodsTags.add(Arrays.asList("weapon-styles", "game-modes", "number-of-players", "demo", "level-selection", "player-info","Starred", "Objects", "Weapons", "Play"));
		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "admission-form", "admission-dates", "eligibility-criteria","Qualification", "Programs-Offered", "Admission-Policies", "Options"));
		 methodsTags.add(Arrays.asList("fee-criteria", "pre-requisite", "application-requirements", "financial-aid", "test-schedule", "degree","FAQs", "Demo", "Instructions", "Programs"));
		 methodsTags.add(Arrays.asList("fee-criteria",  "application-requirements", "pre-requisite", "financial-aid", "test-schedule", "degree","Objects", "Apply-Online", "Required-Documents", "Transfer-Admissions"));
		 methodsTags.add(Arrays.asList("admissions", "weapon-styles", "degree", "number-of-players", "game-modes", "demo","level-selection", "Software", "Platform", "FAQs"));
		 methodsTags.add(Arrays.asList("SAT-I", "Programmes", "admission-process", "Admissions-and-Aid", "entry-test", "apply-online","Transfer-Admissions", "Executive-Programs", "NOP", "Admission-Policies"));
		 methodsTags.add(Arrays.asList("game", "quick-instructions", "3D", "number-of-players", "help", "demo","Objects", "Play", "level-selection", "Utilities"));
		 methodsTags.add(Arrays.asList("pay-online", "registeration", "pay-modes", "website", "test-criteria", "FAQs","Transfer-Admissions", "Executive-Programs", "NOP", "Smart-Phones"));
		 
		 
		 int totalMethods = methodsTags.size();
		 double dist[][] = new double[totalMethods][totalMethods]; //Distance of each method with the rest 
		 int minDist [] = new int[totalMethods];				   //index of closest cluster
		 int maxDist [] = new int[totalMethods];				   // index of farthest cluster
		 System.out.println("Total methods: "+ totalMethods);
//		 for (int i=0; i<minDist.length; i++)
//			 minDist[i]=0;
		 /*for (int i=0; i<arrayofTagsCount.length; i++)
			 arrayofTagsCount[i] = new String[];*/
		/****** Creation of array of tags ************/
		 /*for (int i=0; i<arrayofTags.length; i++){
			 List<String> x = new ArrayList<String>();
			 int l=0;  
			 for (int k=0; k<recommendedCodeTags.length; k++) {
			 for (int j=0; j<3; j++)
			 {
				 if (arrayofTags[i].equalsIgnoreCase(recommendedCodeTags[k][j].toString()) ){
					 x.add( "m" + k);
					 l++;
				 }
				
			 }
			}
			 arrayofTagsCount.add(x); 
		 }*/
		 
		 /********** Conversion of two - dim methods array to arraylist ********//* 
		 List<List<String>> methodsTags = new ArrayList<List<String>>();
		 for (int i=0; i<recommendedCodeTags.length; i++){
		 List<String> list = new ArrayList<String>();
		    for(String[]  array : recommendedCodeTags[i]) {
		        list.addAll(Arrays.asList(array));
		    }
		 }*/
		 /**********************************************
		  * Tags wise jaccard similarity
		  */
		 
		 /******** Tags and methods list that have these tags *********/
		 /*for (int i=0; i<arrayofTags.length; i++){
			 System.out.print(arrayofTags[i] + ": " );
			 //for (int j=0; j<arrayofTags[i].length(); j++)
				 //System.out.println(arrayofTags[i] + ":" );
			 //for ()arrayofTagsCount.get(i) + '\t');
			 for(Object ls : arrayofTagsCount.get(i).toArray()) {
						    //System.out.println(Arrays.deepToString(((List<String>) ls).toArray()));
				 System.out.print(ls.toString() + "    ");
						}
			 System.out.println();
		 }
		 
		 System.out.println("==================Jaccard Similarity of 1st two tags==============S");*/
		 /*Union of 1st two tags*/
		/* calculateJaccardSimilarity(arrayofTagsCount.get(0), arrayofTagsCount.get(1));*/
		 /*System.out.print("Union: ");
		 for (int i=0; i<unions.size(); i++){
			 System.out.print(unions.get(i) + '\t');
		 }
		 System.out.println();
			 
		 Intersection of 1st two tags	 
		 intersections = findIntersection(arrayofTagsCount.get(0), arrayofTagsCount.get(1));
		 System.out.print("Intersection: ");
		 for (int i=0; i<intersections.size(); i++){
			 System.out.print(intersections.get(i) + '\t');
		 }
		 System.out.println();	 
		 System.out.println("Similarity: " + jaccardSimilarity(intersections, unions));
		 
			*/
		 /**********************************************
		  * Method wise jaccard similarity
		  ***********************************************/
		/*System.out.println("==================Jaccard Similarity of 1st two methods==============S");
		calculateJaccardSimilarity(methodsTags.get(0), methodsTags.get(1));
		
		System.out.println("==================Jaccard Similarity of m0 and m3==============S");
		calculateJaccardSimilarity(methodsTags.get(0), methodsTags.get(3));*/
		
		//System.out.println("==================Jaccard Similarity of m2 and m3==============");
		//calculateJaccardSimilarity(methodsTags.get(2), methodsTags.get(3));
		
		//System.out.println("Jaccard Difference: " + calculateJaccardDifference(methodsTags.get(2), methodsTags.get(3)));
		
		/**** Jaccard Difference Matrix Creation *****/
		createDistanceMatrix(dist, methodsTags, minDist, maxDist);
		
		//System.out.println();
		 
	 }
	public static void createDistanceMatrix(double d[][], List<List<String>> list, int minD[], int maxD[] ){
		for (int i=0; i<d.length; i++){
			for (int j=0; j<d[i].length; j++){
				if (i==j) d[i][j]=2.0;
					//d[i][j] = Double.POSITIVE_INFINITY;
				else {
					d[i][j] = calculateJaccardDifference(list.get(i), list.get(j));
				}
				//Maintain minimum index of closest cluster
				if (d[i][j]<d[i][minD[i]] && d[i][j]!=2)
					minD[i] = j;
				//if (d[i][j]>=d[i][maxD[i]] || d[i][maxD[i]]==2)
				if (d[i][j]>d[i][maxD[i]] && i!=j)
					maxD[i] = j;
				else if (i==0 && j==0) maxD[i] = 1;  
			}
		}
		
		for (int i=0; i<d.length; i++){
			System.out.print("Node-" + i + ": ");
			for(int j=0; j<d[i].length; j++){
			//for (int j=0; j<i; j++){
				System.out.print(Math.round(d[i][j]*100.0)/100.0 + "	");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i<minD.length; i++){
			System.out.println("min distant node of  node " +i+": "+ minD[i]);
		}
		
		System.out.println();
		for(int i=0; i<maxD.length; i++){
			System.out.println("max distant node of  node " +i+": "+ maxD[i]);
		}
	}
	 
	public static double calculateJaccardDifference(List<String> list1, List<String> list2){
		double jaccardDifference = 1- calculateJaccardSimilarity(list1, list2);
		return jaccardDifference;
		
	}

	public static double calculateJaccardSimilarity(List<String> list1, List<String> list2){
		 List<String> unions = new ArrayList<String>();
		 List<String> intersections = new ArrayList<String>();
		 double similarity;
		unions = findUnion(list1, list2);
		 System.out.print("Union: ");
		 for (int i=0; i<unions.size(); i++){
			 System.out.print(unions.get(i) + '\t');
		 }
		 System.out.println();
			 
		// Intersection of 1st two methods	 
		 intersections = findIntersection(list1, list2);
		 System.out.print("Intersection: ");
		 for (int i=0; i<intersections.size(); i++){
			 System.out.print(intersections.get(i) + '\t');
		 }
		 System.out.println();
		 similarity = jaccardSimilarity(intersections, unions);
		 System.out.println("Similarity: " + similarity);
		 return similarity;
		 
		
	}
	 public static <T> List<T> findUnion(List<T> list1, List<T> list2) {
	        Set<T> set = new HashSet<T>();

	        set.addAll(list1);
	        set.addAll(list2);

	        return new ArrayList<T>(set);
	    }

    public static <T> List<T> findIntersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
    
    public static  <T> double jaccardSimilarity(List<T> list1, List<T> list2){
    	float intersectionCount = list1.size();
    	float unionCount = list2.size();
    	return intersectionCount/unionCount;
    }
	
}
