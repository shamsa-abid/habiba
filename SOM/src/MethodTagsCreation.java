
/**************************************** 
 * This class populates method vector
 * Then stems them
 * 	 ************************************/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MethodTagsCreation {
	
	private static final double MIN_SIMILARITY_SCORE = 0.35;
	List<List<String>> methodsTagsOriginal = new ArrayList<List<String>>();
	List<List<String>> methodsTagsStemmed = new ArrayList<List<String>>();
	List<List<String>> methodsTagsStmdSyn = new ArrayList<List<String>>();
	String inputFile = System.getProperty("user.dir")+"/SEWordSim-r1.db";
	WordSimFinder facade = new WordSimFinder(inputFile);
				
	/***** Creates arraylist of recommended methods with their tags *******/
	public List<List<String>> populateMethodTagsList(List<List<String>> methodsTags){
		 /*methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre requisite", "fee criteria", "tution fee"));
		 
//		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre requisite", "fee criteria", "tution fee"));
//		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre requisite", "fee criteria", "tution fee"));
//		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre requisite", "fee criteria", "tution fee"));
		 methodsTags.add(Arrays.asList("degree", "tution fee", "application requirements", "qualification", "admission dates", "admission documents"));
		 //methodsTags.add(Arrays.asList("weapon styles", "weapon types", "number of players", "degree", "game modes", "colour"));
		 methodsTags.add(Arrays.asList("weapon styles", "weapon types", "number of players","degree", "game modes", "colour selection"));
		 methodsTags.add(Arrays.asList("weapon styles",  "number of players", "weapon types", "instructions", "demo", "colour selection"));
		 methodsTags.add(Arrays.asList("weapon styles", "game modes", "number of players", "demo", "level selection", "player info"));
		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "admission form", "admission dates", "eligibility criteria"));
		 methodsTags.add(Arrays.asList("fee criteria", "pre requisite", "application requirements", "financial aid", "test schedule", "degree"));
		 methodsTags.add(Arrays.asList("fee criteria",  "application requirements", "pre requisite", "financial aid", "test schedule", "degree"));
		 //methodsTags.add(Arrays.asList("pay online", "registeration", "pay modes", "website", "test criteria", "FAQ"));
		 methodsTags.add(Arrays.asList("game", "quick instructions", "3D", "number of players", "help", "demo"));
		 methodsTags.add(Arrays.asList("SAT I", "Programmes", "admission process", "Admissions and Aid", "entry test", "apply online"));
		 methodsTags.add(Arrays.asList("admissions", "weapon styles", "degree", "number of players", "game modes", "demo"));
		 methodsTags.add(Arrays.asList("weapon styles", "weapon types", "number of players", "applications", "game modes", "colour"));
		 methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre requisite", "fee criteria", "tution fee"));
		 */
		/* methodsTags.add(Arrays.asList("degree", "admissions", "applications", "pre-requisite", "fee-criteria", "tution-fee"));
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
		 
		 /******************Method Updates after adding new tags*****************/
		 /*methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "pre-requisite", "fee-criteria", "tution-fee", "help", "Undergraduate-Admissions", "Executive-Education", "Transfer-Admissions"));
		 methodsTagsOriginal.add(Arrays.asList("degree", "tution-fee", "application-requirements", "qualification", "admission-dates", "admission-documents", "FAQs", "Fee-Structure", "Funds", "Tution-fee"));
		 methodsTagsOriginal.add(Arrays.asList("weapon-styles", "weapon-types", "number-of-players", "degree", "game-modes", "colour", "Utilities", "Software", "Process", "Smart-Phones"));
		 methodsTagsOriginal.add(Arrays.asList("weapon-styles", "weapon-types", "number-of-players","degree", "game-modes", "colour-selection", "Name", "Updates", "Software", "Platform"));
		 methodsTagsOriginal.add(Arrays.asList("weapon-styles",  "numbe-of-players", "weapon-types", "instructions", "demo", "colour-selection","Updates", "Selections", "Options", "Mobile-Games" ));
		 methodsTagsOriginal.add(Arrays.asList("weapon-styles", "game-modes", "number-of-players", "demo", "level-selection", "player-info","Starred", "Objects", "Weapons", "Play"));
		 methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "admission-form", "admission-dates", "eligibility-criteria","Qualification", "Programs-Offered", "Admission-Policies", "Options"));
		 methodsTagsOriginal.add(Arrays.asList("fee-criteria", "pre-requisite", "application-requirements", "financial-aid", "test-schedule", "degree","FAQs", "Demo", "Instructions", "Programs"));
		 methodsTagsOriginal.add(Arrays.asList("fee-criteria",  "application-requirements", "pre-requisite", "financial-aid", "test-schedule", "degree","Objects", "Apply-Online", "Required-Documents", "Transfer-Admissions"));
		 methodsTagsOriginal.add(Arrays.asList("admissions", "weapon-styles", "degree", "number-of-players", "game-modes", "demo","level-selection", "Software", "Platform", "FAQs"));
		 methodsTagsOriginal.add(Arrays.asList("SAT-I", "Programmes", "admission-process", "Admissions-and-Aid", "entry-test", "apply-online","Transfer-Admissions", "Executive-Programs", "NOP", "Admission-Policy"));
		 methodsTagsOriginal.add(Arrays.asList("game", "quick-instructions", "3D", "number-of-players", "help", "demo","Objects", "Play", "level-selection", "Utilities"));
		 methodsTagsOriginal.add(Arrays.asList("pay-online", "registeration", "pay-modes", "website", "test-criteria", "FAQs","Transfer-Admissions", "Executive-Programs", "NOP", "Smart-Phones"));
		 */
		
		/********** More Updations with small broken method tags *********/
		/* methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "prerequisite", "feecriteria", "tutionfee", "help", "Undergraduate", "Executive", "Transfer"));
		 methodsTagsOriginal.add(Arrays.asList("degree", "tutionfee",  "qualification", "admission", "documents", "FAQs", "FeeStructure", "Dates", "Tutionfee"));
		 methodsTagsOriginal.add(Arrays.asList("weapon","styles", "types", "numberofplayers", "degree", "gamemodes", "colour", "Utilities", "Software", "Process", "Smart", "Phones"));
		 methodsTagsOriginal.add(Arrays.asList("weaponstyles", "degree", "gamemodes", "colour", "Name", "Updates", "Software", "Platform"));
		 methodsTagsOriginal.add(Arrays.asList("weapon",  "number-of-players", "types", "instructions", "demo", "colourselection","Updates", "Selections", "Options", "Mobile" ));
		 methodsTagsOriginal.add(Arrays.asList("styles", "gamemodes", "number-of-players", "demo", "levelselection", "player-info","Starred", "Objects", "Weapons", "Play"));
		 methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "admission-form", "dates", "eligibility","Qualification", "Programs", "Policies", "Options"));
		 methodsTagsOriginal.add(Arrays.asList("feecriteria", "prerequisite", "requirements", "financialaid", "testschedule", "degree","FAQs", "Demo", "Instructions", "Programs"));
		 methodsTagsOriginal.add(Arrays.asList("fee",  "requirements", "prerequisite", "financialaid", "testschedule", "degree","Objects", "ApplyOnline", "Required-Documents", "Transfer-Admissions"));
		 methodsTagsOriginal.add(Arrays.asList("admissions", "weaponstyles", "degree", "number-of-players", "gamemodes", "demo","levelselection", "Software", "Platform", "FAQs"));
		 methodsTagsOriginal.add(Arrays.asList("SATI", "Programmes", "admissionprocess", "AdmissionsandAid", "entrytest", "applye","Transfer", "Executive", "NOP", "Admission"));
		 methodsTagsOriginal.add(Arrays.asList("game", "quickinstructions", "3D", "number-of-players", "help", "demo","Objects", "Play", "levelselection", "Utilities"));
		 methodsTagsOriginal.add(Arrays.asList("payonline", "registeration", "paymodes", "website", "testcriteria", "FAQs","Transfer", "Executive", "NOP", "SmartPhones"));*/
		 
		 /********** More Updations with single words tags *********/
		 methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "prerequisite", "fee","criteria", "tution", "help", "Undergraduate", "Executive", "Transfer"));
		 
		 methodsTagsOriginal.add(Arrays.asList("degree", "fee",  "qualification", "admission", "documents", "FAQs", "Structure", "Dates", "Tution"));
		
		 methodsTagsOriginal.add(Arrays.asList("weapon","styles", "types", "players", "degree", "game","modes", "colour", "Utilities", "Software", "Process", "Smart", "Phones"));
		 
		 methodsTagsOriginal.add(Arrays.asList("weapon", "styles", "degree", "game", "modes", "colour", "Name", "Updates", "Software", "Platform"));
		 
		 methodsTagsOriginal.add(Arrays.asList("weapon",  "players", "types", "instructions", "demo", "colour","Updates", "Selections", "Options", "Mobile" ));
		 
		 methodsTagsOriginal.add(Arrays.asList("styles", "game", "modes", "players", "demo", "level", "selection", "info","Starred", "Objects", "Weapons", "Play"));
		 
		 methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "form", "dates", "eligibility","Qualification", "Programs", "Policies", "Options"));
		 
		 methodsTagsOriginal.add(Arrays.asList("fee","criteria", "prerequisite", "requirements", "financial","aid", "test", "schedule", "degree","FAQs", "Demo", "Instructions", "Programs"));
		 
		 methodsTagsOriginal.add(Arrays.asList("fee",  "requirements", "prerequisite", "financial", "aid", "test", "schedule", "degree","Objects", "Apply", "Online", "Required", "Documents", "Transfer", "Admissions"));
		 
		 methodsTagsOriginal.add(Arrays.asList("admissions", "weapon", "styles", "degree", "players", "game", "modes", "demo","level", "selection", "Software", "Platform", "FAQs"));
		
		 methodsTagsOriginal.add(Arrays.asList("SATI", "Programmes", "process", "Admissions", "Aid", "entry", "test", "apply","Transfer", "Executive", "NOP"));
		 
		 methodsTagsOriginal.add(Arrays.asList("game", "instructions", "3D", "players", "help", "demo","Objects", "Play", "level", "Utilities"));
		
		 methodsTagsOriginal.add(Arrays.asList("pay", "online", "registeration", "modes", "website", "test", "criteria", "FAQs","Transfer", "Executive", "NOP", "Phones"));
		 stemMethodsTags();
		 //return methodsTagsOriginal;
		 return methodsTagsStemmed;
	}
	
	/* *****************************************************************
	 *Stems method tags 
	 *Handles synonyms
	 *Stores the method tags in a new arraylist methodsTagsStemmed
	 * ****************************************************************/
	private void stemMethodsTags(){
				
		for (int i=0; i<methodsTagsOriginal.size(); i++){
			List<String> tags= methodsTagsOriginal.get(i);
			List<String> stemmedTags = new ArrayList<String>();
			for(int j=0; j<tags.size(); j++){
				stemmedTags.add(facade.stemWord(tags.get(j)));
			}
			methodsTagsStemmed.add(stemmedTags);
			
		}
		System.out.println("\nStemmed Methods Tags");
		for(int i=0; i<methodsTagsStemmed.size(); i++){
			System.out.println(methodsTagsStemmed.get(i));
		}
		handleSynonyms();
		System.out.println("\nStemmed Methods Tags with synonyms removed");
		for(int i=0; i<methodsTagsStemmed.size(); i++){
			System.out.println(methodsTagsStemmed.get(i));
		}
	}
	
	/* *****************************************************************
	 *Handles synonyms of methodsTagsStemmed arraylist 
	 * *****************************************************************/
	private void handleSynonyms (){
		
		
		double similarityScore;
		
		for (int i=0; i<methodsTagsStemmed.size(); i++){
			List<String> tags1 = methodsTagsStemmed.get(i);
			//System.out.println("Methd for comparison\n" + tags1);
			for (int j=0; j<tags1.size(); j++){
				String tag = tags1.get(j);
				if(facade.isInDatabase(tag)){
					for (int k=i+1; k<methodsTagsStemmed.size(); k++){
						List<String> tags2 = methodsTagsStemmed.get(k);
						//System.out.println("Method "+ k + " for syn removal\n" + tags2);
						for(int l=0; l<tags2.size(); l++){
							//System.out.println("Tag before replace: " + tags2.get(l));
							if (!tag.equals(tags2.get(l))){
								similarityScore = facade.computeSimilarity(tag, tags2.get(l));
								if (similarityScore>=MIN_SIMILARITY_SCORE){
									System.out.println("\nIn method: " + i + " & method: " +k);
									System.out.println("Original n syn tags: " + tag + " - " +tags2.get(l) + ", Sim. Score: " + similarityScore);
									tags2.set(l, tag);	
									//System.out.println("Tag after replace: " + tags2.get(l));
									break;
								}
							}
						}
						methodsTagsStemmed.set(k, tags2);
						//System.out.println("Updated method after synonym removal " + k + "\n" + methodsTagsStemmed.get(k));
					}
				}
			}
		}
		
	}

}
