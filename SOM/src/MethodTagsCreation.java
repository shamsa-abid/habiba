
/**** This class populates method vector ******/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MethodTagsCreation {
	List<List<String>> methodsTagsOriginal = new ArrayList<List<String>>();
	List<List<String>> methodsTagsStemmed = new ArrayList<List<String>>();
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
		 methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "prerequisite", "feecriteria", "tutionfee", "help", "Undergraduate", "Executive", "Transfer"));
		 methodsTagsOriginal.add(Arrays.asList("degree", "tutionfee",  "qualification", "admission", "documents", "FAQs", "FeeStructure", "Dates", "Tutionfee"));
		 methodsTagsOriginal.add(Arrays.asList("weapon","styles", "types", "numberofplayers", "degree", "gamemodes", "colour", "Utilities", "Software", "Process", "Smart", "Phones"));
		 methodsTagsOriginal.add(Arrays.asList("weaponstyles", "degree", "gamemodes", "colour", "Name", "Updates", "Software", "Platform"));
		 methodsTagsOriginal.add(Arrays.asList("weapon",  "numbe-of-players", "types", "instructions", "demo", "colourselection","Updates", "Selections", "Options", "Mobile" ));
		 methodsTagsOriginal.add(Arrays.asList("styles", "gamemodes", "number-of-players", "demo", "levelselection", "player-info","Starred", "Objects", "Weapons", "Play"));
		 methodsTagsOriginal.add(Arrays.asList("degree", "admissions", "applications", "admission-form", "dates", "eligibility","Qualification", "Programs", "Policies", "Options"));
		 methodsTagsOriginal.add(Arrays.asList("feecriteria", "prerequisite", "requirements", "financialaid", "testschedule", "degree","FAQs", "Demo", "Instructions", "Programs"));
		 methodsTagsOriginal.add(Arrays.asList("fee",  "requirements", "prerequisite", "financialaid", "testschedule", "degree","Objects", "ApplyOnline", "Required-Documents", "Transfer-Admissions"));
		 methodsTagsOriginal.add(Arrays.asList("admissions", "weaponstyles", "degree", "number-of-players", "gamemodes", "demo","levelselection", "Software", "Platform", "FAQs"));
		 methodsTagsOriginal.add(Arrays.asList("SATI", "Programmes", "admissionprocess", "AdmissionsandAid", "entrytest", "applye","Transfer", "Executive", "NOP", "Admission"));
		 methodsTagsOriginal.add(Arrays.asList("game", "quickinstructions", "3D", "number-of-players", "help", "demo","Objects", "Play", "levelselection", "Utilities"));
		 methodsTagsOriginal.add(Arrays.asList("payonline", "registeration", "paymodes", "website", "testcriteria", "FAQs","Transfer", "Executive", "NOP", "SmartPhones"));
		 stemMethodsTags();
		 //return methodsTagsOriginal;
		 return methodsTagsStemmed;
	}
	
	/****************************************************
	 **Stems method tags an stores them in a new arraylist methodsTagsStemmed**
	 * *************************************************/
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
	}

}
