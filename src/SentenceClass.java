import java.util.ArrayList;

public class SentenceClass {

    // This list includes the verbs that will be used in the noun verb noun sentence
    String[] NVNverbInclusionList = {};
    // This list essentially includes all the verbs that we want to see occur in the sentence generation
    String[] NVverbInclusionList = {"udla", "gijima", "ima", "igxuma", "cabanga", "funda", "landela"};
    // The nouns that go into this list cannot be used in conjuction with the above verbs
    ArrayList<String> nounExclusionList = new ArrayList<>();

    public String generateNVNsentence(){
        //VerbClass verb = new VerbClass();
        NounClass subject = new NounClass();
        NounClass object = new NounClass();

        return null;
    }

    public String generateNVsentence(){
        NounClass subject = new NounClass();
        //VerbClass verb = new VerbClass();

        return null;
    }

    // Represent the Template choices as methods
    // Draw for each
    // Create an annotation mechanism for when the sentence gets passed
    // Create an exclusion list for all the words that would not work
}