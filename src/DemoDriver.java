import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil Gilbert on 2017-09-26.
 * This class is the interface used to access the language learning exercises
 */
public class DemoDriver {
    public static void main(String[] args) throws IOException {
        // The class uses this input to declare which language learning exercises are wanted for the complexity measure framework
        VerbSCModifier vscm = new VerbSCModifier();
        GeneratorMethod(false, false, false, false, false, true);
    }
    public static void GeneratorMethod(boolean vP, boolean nP, boolean sP, boolean sS, boolean nS, boolean vS) throws IOException {

        // Uses booleans, if true, samples of 50 langauge learning questions are generated for the specified question
        // Questions are stored in this list and then written to a file
        List<String> lines = new ArrayList<>();

        if(vP){
            VerbPluralGen vpg;
            for (int i = 0; i<50; i++){
                vpg = new VerbPluralGen();
                lines.add(vpg.verbPluralExercise());
            }
        }
        if(nP){
            NounPluralGen npg;
            for (int i = 0; i<50; i++){
                npg = new NounPluralGen();
                lines.add(npg.nounPluralExercises());
            }
        }
        if(sP){
            SentencePluraliserGen spg;
            for (int i = 0; i<50; i++){
                spg = new SentencePluraliserGen();
                lines.add(spg.sentencePluraliseExercise());
            }
        }
        if(sS){
            SentenceScrabbleGen ssg;
            for (int i = 0; i<50; i++){
                ssg = new SentenceScrabbleGen();
                lines.add(ssg.sentenceScrabbleExercise());
            }
        }
        if(nS){
            NounSingularGen nsg;
            for (int i = 0; i<50; i++){
                nsg = new NounSingularGen();
                lines.add(nsg.nounSingularExercises());
            }
        }
        if(vS){
            VerbSCModifier vscm;
            for (int i = 0; i<50; i++){
                vscm = new VerbSCModifier();
                lines.add(vscm.verbSCModifier());
            }
        }
        Path file = Paths.get("questions.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
    }
}
