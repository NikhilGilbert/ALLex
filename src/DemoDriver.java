import java.io.IOException;

/**
 * Created by Admin on 2017-09-26.
 */
public class DemoDriver {
    public static void main(String[] args) throws IOException {
        SentenceScrabbleGen sentenceScrabbleGen;
        for (int i = 0; i<50; i++){
            sentenceScrabbleGen = new SentenceScrabbleGen();
            sentenceScrabbleGen.sentenceScrabbleExercise();
        }

    }
}
