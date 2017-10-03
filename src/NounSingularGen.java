import java.io.IOException;

/**
 * Created by Nikhil Gilbert on 2017-10-02.
 * This exercise requires the user to identify a nouns class and change it from plural to singular
 */
public class NounSingularGen {
    SentenceGeneratorClass sc;

    // The exercise method itself prepares the question and readies it for passing to the complexity measure framework
    public NounSingularGen(){
        sc = new SentenceGeneratorClass();
    }

    public String nounSingularExercises() throws IOException {
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        String nvSentence = sc.generateNVsentence();
        String questionSentence = null;

        String[] splitter = nvSentence.split(" ");
        nc.setNoun(splitter[0]);
        vc.setVerb(splitter[1]);

        String nounClassNumber = nc.findNounClass();

        // This is using the grammar classes to perform the necessary transformations
        questionSentence = nc.pluraliseNoun(nounClassNumber) + " " + vc.getVerb();
        String answerSentence = nc.getNoun() + " " + vc.getVerb();

        String output = "5," + annotate(questionSentence) + ",Identify_v the change needed to make the noun a singular and rewrite_v the " +
                "sentence with this change.," + annotate(answerSentence);

        return output;
    }

    // A helper method that annotates the sentence string so that its componets may be identified by the complexity measure framework
    public String annotate(String sentence){
        String [] plainSentence = sentence.split(" ");

        plainSentence[0] = plainSentence[0] + "_n";
        plainSentence[1] = plainSentence[1] + "_v";

        return plainSentence[0] + " " + plainSentence[1];
    }
}
