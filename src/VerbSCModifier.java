import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VerbSCModifier {

    VerbClass vc;
    private String[] positiveConcordList = {"ngi", "u", "si", "ni", "ba", "i", "li", "a", "zi", "lu", "bu", "ku"};
    private String[] negativeConcordList = {"angi", "awu", "asi", "ani", "aba", "ayi", "ali", "awa", "azi", "alu",
            "abu", "aku"};

    public VerbSCModifier(){
        vc = new VerbClass();
    }

    public String verbSCModifier(){
        Random rand = new Random();
        boolean exerciseChoice = rand.nextBoolean();
        // Selects a question type at random and chooses to present the user with that quesion
        if(exerciseChoice){
            String[] questionSet = changePostiveConcord();
            return questionSet[0] + "," + questionSet[1] + "," + questionSet[2] + "," + questionSet[3];
        }
        else{
            String[] questionSet = changeNegativeConcord();
            return questionSet[0] + "," + questionSet[1] + "," + questionSet[2] + "," + questionSet[3];
        }
    }

    // Method for changing negatives
    public String[] changeNegativeConcord(){
        ArrayList<String> negativeForm = vc.generateSpecificVerbForm(1, 0, 0, 0, 0, 1, 0, 0, 0, 0);
        String question = vc.concatenateVerb(negativeForm);

        String positiveConcord = findPositiveConcord(negativeForm.get(0));
        negativeForm.set(0, positiveConcord);
        negativeForm.set(negativeForm.size()-1, "a");

        String answer = vc.concatenateVerb(negativeForm);

        String[] questionAndAnswer = {"6",question,"Can you change this verbs form into its positive concord?" ,answer};

        return questionAndAnswer;
    }

    // Methods for changing positives
    public String[] changePostiveConcord(){
        ArrayList<String> positiveForm = vc.generateSpecificVerbForm(0, 1, 0, 0, 0, 1, 0, 0, 0, 0);
        String question = vc.concatenateVerb(positiveForm);

        String negativeConcord = findNegativeConcord(positiveForm.get(0));
        positiveForm.set(0, negativeConcord);
        positiveForm.set(positiveForm.size()-1, "i");

        String answer = vc.concatenateVerb(positiveForm);

        String[] questionAndAnswer = {"6",question,"Can you change this verbs form into its negative concord?" ,answer};

        return questionAndAnswer;
    }

    // Helper methods to find opposite concord
    public String findPositiveConcord(String negativeConcord){
        for (int i = 0; i<negativeConcordList.length; i++){
            if (negativeConcord.equals(negativeConcordList[i])){
                return positiveConcordList[i];
            }
        }
        return null;
    }

    public String findNegativeConcord(String concord){
        for (int i = 0; i<positiveConcordList.length; i++){
            if (positiveConcordList[i].equals(concord)){
                return negativeConcordList[i];
            }
        }
        return null;
    }
}

