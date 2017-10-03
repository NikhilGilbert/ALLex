import java.io.IOException;

/**
 * Created by Nikhil Gilbert on 2017-09-26.
 * This class is the noun pluralisation exercise, it requires users to identify the classof a noun and pluralise it according to rules
 */
public class NounPluralGen {
    SentenceGeneratorClass sc;

    public NounPluralGen(){
        sc = new SentenceGeneratorClass();
    }

    // The exercise method itself prepares the question and readies it for passing to the complexity measure framework
    public String nounPluralExercises() throws IOException {
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        String nvSentence = sc.generateNVsentence();
        String questionSentence = null;

        String[] splitter = nvSentence.split(" ");
        nc.setNoun(splitter[0]);
        vc.setVerb(splitter[1]);

        String nounClassNumber = nc.findNounClass();

        // This is using the grammar classes to perform the necessary transformations
        questionSentence = nc.getNoun() + " " + vc.pluraliseVerb(nc.findNounClass());
        String answerSentence = nc.pluraliseNoun(nounClassNumber) + " " + vc.pluraliseVerb(nc.findNounClass());

        String output = "1," + annotate(questionSentence) + ",Identify_v the change needed to make the noun a plural and rewrite_v the " +
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
