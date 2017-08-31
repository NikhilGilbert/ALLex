import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VerbCARPExtension {
    // Generate a verb with C initiated
    // Display verb on the screen with CARP extension and FV(will decide NEG, or SC)
    // Ask for user input separated by a space for all parts of the verb
        // Evaluate 1st input as NEG/SC and Second input as OC
        // 3rd will be root verb and FV as given in the beginning of the question

    VerbClass vc;

    public VerbCARPExtension(){
        vc = new VerbClass();
    }

    public int changeCPrefixExersize(){
        ArrayList<String> negativeForm = vc.generateSpecificVerbForm(0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
        System.out.println(negativeForm);
        negativeForm.set(0, "");
        negativeForm.set(1, "");
        negativeForm.set(4, "");
        System.out.println(negativeForm);

        Random rand = new Random();
        String finalVowel;
        int random = rand.nextInt(2);
        if (random == 0){
            finalVowel = "a";
        }else{
            finalVowel = "i";
        }
        System.out.println("Can you change this C verbs form correctly?: "
                + vc.concatenateVerb(negativeForm) + finalVowel);
        System.out.println("Separate your anwer in the format: __ Root Verb __");
        System.out.println("Leave space between every suffix to be added to the root verb");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        String [] answerEvaluation = answer.split(" ");
        for (int i = 0; i<answerEvaluation.length; i++){
            System.out.println(answerEvaluation[i]);
        }

        boolean isFirstPartCorrect = false;
        boolean isSecondPartCorrect = false;

        if (finalVowel.equals("i")){
            for (String s: vc.getVerbGrammar("NEG")){
                if (s.equals(answerEvaluation[0])){
                    isFirstPartCorrect = true;
                }
            }
        }else if (finalVowel.equals("a")){
            for (String s: vc.getVerbGrammar("SC")){
                if (s.equals(answerEvaluation[0])){
                    isFirstPartCorrect = true;
                }
            }
        }

        for (String s: vc.getVerbGrammar("OC")){
            if (s.equals(answerEvaluation[1])){
                isSecondPartCorrect = true;
            }
        }

        if (isFirstPartCorrect && isSecondPartCorrect){
            System.out.println("You got it!");
        }else{
            System.out.println("Wrong, the verb should contain a Subject Concord and Object Concord");
        }


        return 0;
    }
}
