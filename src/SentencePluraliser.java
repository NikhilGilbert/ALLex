import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Admin on 2017-08-21.
 */
public class SentencePluraliser {
    SentenceGeneratorClass sc;

    public SentencePluraliser(){
        sc = new SentenceGeneratorClass();
    }

    public int twoWordSentence() throws IOException {

        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        String nvSentence = sc.generateNVsentence();
        String pluralisedSentence = null;

        String[] splitter = nvSentence.split(" ");
        nc.setNoun(splitter[0]);
        vc.setVerb(splitter[1]);

        pluralisedSentence = nc.pluraliseNoun(nc.findNounClass()) + " " + vc.pluraliseVerb(nc.findNounClass());

        System.out.println(nvSentence);
        System.out.println(pluralisedSentence);

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        if (answer.equals(pluralisedSentence)){
            System.out.println("Right");
            return 1;
        }
        else {
            System.out.println("Wrong");
            return -1;
        }
    }

    public int threeWordSenetence() throws IOException {
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        NounClass nc2 = new NounClass();
        String nvnSentence = sc.generateNVNsentence();
        String pluralisedSentence = null;

        System.out.println(nvnSentence);
        String[] splitter = nvnSentence.split(" ");

        nc.setNoun(splitter[0]);
        vc.setVerb(splitter[1]);
        nc2.setNoun(splitter[2]);

        String nounClassNumber = nc.findNounClass();

        pluralisedSentence = nc.pluraliseNoun(nounClassNumber) + " " + vc.pluraliseVerb(nounClassNumber) + " " +
                nc2.pluraliseNoun(nc2.findNounClass());

        System.out.println(pluralisedSentence);
        return 0;
    }

//    public int runExersize(){
//
//    }

}
