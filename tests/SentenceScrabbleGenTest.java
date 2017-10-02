import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017-10-02.
 */
public class SentenceScrabbleGenTest {
    @Test
    public void sentenceScrabbleExercise() throws Exception {
        SentenceScrabbleGen ssg = new SentenceScrabbleGen();
        String output = ssg.sentenceScrabbleExercise();
        assertNotNull(output);

        String [] splitter = output.split(",");
        assertEquals(splitter.length, 4);
        assertEquals(splitter[0], "4");

        assertEquals(splitter[3].split(" ")[0].split("_")[1], "n");
        assertEquals(splitter[3].split(" ")[1].split("_")[1], "v");
        assertEquals(splitter[3].split(" ")[2].split("_")[1], "n");
    }

    @Test
    public void unpackList() throws Exception {
        SentenceScrabbleGen ssg = new SentenceScrabbleGen();
        ArrayList<String> list = new ArrayList<>();
        list.add("This"); list.add("is"); list.add("a"); list.add("test");
        assertEquals(ssg.unpackList(list), "This is a test");
    }

    @Test
    public void annotate() throws Exception {
        SentenceScrabbleGen ssg = new SentenceScrabbleGen();
        assertEquals("umfana_n ufaka_v ifestile_n", ssg.annotate("umfana ufaka ifestile"));
        assertNotEquals("umfana_v ufaka_n ifestile_v", ssg.annotate("umfana ufaka ifestile"));
    }

}