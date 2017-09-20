import java.io.IOException;

/**
 * Created by Admin on 2017-08-21.
 */
public class SentencePluraliser {
    SentenceGeneratorClass sc;

    public SentencePluraliser(){
        sc = new SentenceGeneratorClass();
    }

    private String[] twoWordSentence() throws IOException {
        String [] sentences = new String[2];
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        sentences[0] = sc.generateNVsentence();

        String[] splitter = sentences[0].split(" ");
        

        // Pluralise the sentences
        // Scanner input
        // Compare answers, think about compare functionality
        // k

        // sentences[1] = plurlizedSenetence;
        return splitter;
    }

//    private  String[] threeWordSenetence(){
//
//    }
//
//    public int runExersize(){
//
//    }

}
