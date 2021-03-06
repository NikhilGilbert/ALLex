import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Nikhil Gilbert on 2017-09-25.
 */
public class SentenceScrabbleGen{
    public String sentenceScrabbleExercise() throws IOException {
        SentenceGeneratorClass sgc = new SentenceGeneratorClass();
        String sentence = annotate(sgc.generateNVNsentence());
        String[] shuffle = sentence.split(" ");

        ArrayList<String> normalList = new ArrayList<>();
        ArrayList<String> mixedList = new ArrayList<>();

        for (int i = 0; i < shuffle.length; i++){
            normalList.add(shuffle[i]);
            mixedList.add(shuffle[i]);
        }

        Collections.shuffle(mixedList);

        String output = "4," + unpackList(mixedList) + ",Rearrange_v the given words so that the sentence " +
                "is grammatically and semantically correct.," + unpackList(normalList);

        return output;
    }

    public String unpackList(ArrayList<String> list){
        String unpackedList = "";
        for (int i = 0; i<list.size(); i++){
            if (i!=list.size()-1){
                unpackedList += list.get(i) + " ";
            }
            else if (i==list.size()-1){
                unpackedList += list.get(i);
            }
        }
        return unpackedList;
    }

    public String annotate(String sentence){
        String [] plainSentence = sentence.split(" ");
        plainSentence[0] = plainSentence[0] + "_n";
        plainSentence[1] = plainSentence[1] + "_v";
        plainSentence[2] = plainSentence[2] + "_n";

        return plainSentence[0] + " " + plainSentence[1] + " " + plainSentence[2];
    }

}
