import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017-09-29.
 */
public class VerbPluralGenTest {
    @Test
    public void verbPluralExercise() throws Exception {
        VerbPluralGen vpg = new VerbPluralGen();
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();

        String output = vpg.verbPluralExercise();
        assertNotNull(output);

        String [] splitter = output.split(",");
        assertEquals(splitter.length, 4);
        assertEquals(splitter[0], "2");

        nc.setNoun(splitter[1].split(" ")[0].split("_")[0]);
        vc.setVerb(splitter[1].split(" ")[1].split("_")[0]);

        assertEquals(splitter[1].split(" ")[0].split("_")[1], "n");
        assertEquals(splitter[1].split(" ")[1].split("_")[1], "v");

        assertEquals(splitter[2], "Identify_v the change needed to make the verb pluralized and rewrite_v " +
                "the sentence with this change.");
    }

    @Test
    public void annotate() throws Exception {
        VerbPluralGen vpg = new VerbPluralGen();
        assertEquals("umfana_n ufaka_v", vpg.annotate("umfana ufaka"));
        assertNotEquals("umfana_v ufaka_v", vpg.annotate("umfana ufaka"));
    }

}