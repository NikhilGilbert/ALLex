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

    public int changeNegativeConcord(){
        ArrayList<String> negativeForm = vc.generateSpecificVerbForm(1, 0, 0, 0, 0, 1, 0, 0, 0, 0);
        System.out.println("Can you change this verbs form into its positive concord?: "
                + vc.concatenateVerb(negativeForm));
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        String positiveConcord = findPositiveConcord(negativeForm.get(0));
        negativeForm.set(0, positiveConcord);
        negativeForm.set(negativeForm.size()-1, "a");

        if (answer.equals(vc.concatenateVerb(negativeForm))){
            System.out.println("Correct!");
            return 1;
        }
        else{
            System.out.println("The correct answer is " + vc.concatenateVerb(negativeForm));
            return -1;
        }
    }

    public int changePostiveConcord(){
        ArrayList<String> positiveForm = vc.generateSpecificVerbForm(0, 1, 0, 0, 0, 1, 0, 0, 0, 0);
        System.out.println("Can you change this verbs form into its negative concord?: "
                + vc.concatenateVerb(positiveForm));

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        String negativeConcord = findNegativeConcord(positiveForm.get(0));
        positiveForm.set(0, negativeConcord);
        positiveForm.set(positiveForm.size()-1, "i");

        if (answer.equals(vc.concatenateVerb(positiveForm))){
            System.out.println("Correct!");
            return 1;
        }
        else{
            System.out.println("The correct answer is " + vc.concatenateVerb(positiveForm));
            return -1;
        }
    }

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

    public void runExercise(){
        int points = 0;
        Random rand = new Random();
        int choice = rand.nextInt(1);

        while (true){
            if (choice == 1){
                points += changeNegativeConcord();
            }else{
                points += changePostiveConcord();
            }

            if(points == 2){
                System.out.println("Well Done! You did it!");
                break;
            }
            else if(points == -2){
                System.out.println("Study your plurals harder :(");
                break;
            }
        }
    }

}

