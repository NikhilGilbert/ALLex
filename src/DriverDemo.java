import java.io.IOException;

/**
 * Created by Admin on 2017-09-26.
 */
public class DriverDemo {
    public static void main(String[] args) throws IOException {
        for(int i = 0; i< 20; i++){
            SentenceScrabbleGen ssg = new SentenceScrabbleGen();
            ssg.sentenceScrabbleExercise();
        }
    }
}
