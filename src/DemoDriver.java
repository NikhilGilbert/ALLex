import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017-09-26.
 */
public class DemoDriver {
    public void GeneratorMethod(boolean vP, boolean nP, boolean sP, boolean sS) throws IOException {
        boolean verbPlural = vP;
        boolean nounPlural = nP;
        boolean sentencePlural = sP;
        boolean sentenceScrabble = sS;

        List<String> lines = new ArrayList<>();

        if(verbPlural){
            VerbPluralGen vpg;
            for (int i = 0; i<50; i++){
                vpg = new VerbPluralGen();
                lines.add(vpg.verbPluralExercise());
            }
        }
        if(nounPlural){
            NounPluralGen npg;
            for (int i = 0; i<50; i++){
                npg = new NounPluralGen();
                lines.add(npg.nounPluralExercises());
            }
        }
        if(sentencePlural){
            SentencePluraliserGen spg;
            for (int i = 0; i<50; i++){
                spg = new SentencePluraliserGen();
                lines.add(spg.sentencePluraliseExercise());
            }
        }
        if(sentenceScrabble){
            SentenceScrabbleGen ssg;
            for (int i = 0; i<50; i++){
                ssg = new SentenceScrabbleGen();
                lines.add(ssg.sentenceScrabbleExercise());
            }
        }

        Path file = Paths.get("questions.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
    }
}
