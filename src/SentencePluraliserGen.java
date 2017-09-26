import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Admin on 2017-09-26.
 */
public class SentencePluraliserGen {
    SentenceGeneratorClass sc;

    public SentencePluraliserGen(){
        sc = new SentenceGeneratorClass();
    }

//    public int twoWordSentence() throws IOException {
//
//        NounClass nc = new NounClass();
//        VerbClass vc = new VerbClass();
//        String nvSentence = sc.generateNVsentence();
//        String pluralisedSentence = null;
//
//        String[] splitter = nvSentence.split(" ");
//        nc.setNoun(splitter[0]);
//        vc.setVerb(splitter[1]);
//
//        pluralisedSentence = nc.pluraliseNoun(nc.findNounClass()) + " " + vc.pluraliseVerb(nc.findNounClass());
//
//        System.out.println(nvSentence);
//        System.out.println(pluralisedSentence);
//        return 0;
//    }

    public int threeWordSenetence() throws IOException {
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        NounClass nc2 = new NounClass();
        String nvnSentence = sc.generateNVNsentence();
        String pluralisedSentence = null;


        String[] splitter = nvnSentence.split(" ");

        nc.setNoun(splitter[0]);
        vc.setVerb(splitter[1]);
        nc2.setNoun(splitter[2]);

        String nounClassNumber = nc.findNounClass();

        pluralisedSentence = nc.pluraliseNoun(nounClassNumber) + " " + vc.pluraliseVerb(nounClassNumber) + " " +
                nc2.pluraliseNoun(nc2.findNounClass());

        System.out.println("3," + annotate(nvnSentence) + ",Analyze_v and rewrite_v the sentence so that the noun and verb are plural.," +
                annotate(pluralisedSentence));
        return 0;
    }

    public String annotate(String sentence){
        String [] plainSentence = sentence.split(" ");
        plainSentence[0] = plainSentence[0] + "_n";
        plainSentence[1] = plainSentence[1] + "_v";
        plainSentence[2] = plainSentence[2] + "_n";

        return plainSentence[0] + " " + plainSentence[1] + " " + plainSentence[2];
    }
}
