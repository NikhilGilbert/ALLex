import java.io.IOException;

/**
 * Created by Nikhil Gilbert on 2017-09-26.
 */
public class VerbPluralGen {
    SentenceGeneratorClass sc;

    public VerbPluralGen(){
        sc = new SentenceGeneratorClass();
    }

    public String verbPluralExercise() throws IOException {
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        String nvSentence = sc.generateNVsentence();
        String questionSentence = null;

        String[] splitter = nvSentence.split(" ");
        nc.setNoun(splitter[0]);
        vc.setVerb(splitter[1]);

        String nounClassNumber = nc.findNounClass();

        questionSentence = nc.pluraliseNoun(nounClassNumber) + " " + vc.getVerb();
        String answerSentence = nc.pluraliseNoun(nounClassNumber) + " " + vc.pluraliseVerb(nc.findNounClass());

        String output = "2," + annotate(questionSentence) + ",Identify_v the change needed to make the verb pluralized and rewrite_v " +
                "the sentence with this change.," + annotate(answerSentence);

        return output;
    }

    public String annotate(String sentence){
        String [] plainSentence = sentence.split(" ");

        plainSentence[0] = plainSentence[0] + "_n";
        plainSentence[1] = plainSentence[1] + "_v";

        return plainSentence[0] + " " + plainSentence[1];
    }
}
