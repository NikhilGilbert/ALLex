import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017-09-28.
 */
public class NounPluralGenTest {
    @Test
    public void nounPluralExercises() throws Exception {
        NounPluralGen npg = new NounPluralGen();
        NounClass nc = new NounClass();

        String output = npg.nounPluralExercises();
        assertNotNull(output);

        String [] splitter = output.split(",");
        assertEquals(splitter.length, 4);
        assertEquals(splitter[0], "1");

        nc.setNoun(splitter[1].split(" ")[0].split("_")[0]);
        assertEquals(nc.pluraliseNoun(nc.findNounClass()), splitter[3].split(" ")[0].split("_")[0]);

        assertEquals(splitter[1].split(" ")[0].split("_")[1], "n");
        assertEquals(splitter[1].split(" ")[1].split("_")[1], "v");
        assertEquals(splitter[2], "Identify_v the change needed to make the noun a plural and " +
                "rewrite_v the sentence with this change.");
    }

    @Test
    public void annotate() throws Exception {
        NounPluralGen npg = new NounPluralGen();
        assertEquals("umfana_n ufaka_v", npg.annotate("umfana ufaka"));
        assertNotEquals("umfana_v ufaka_v", npg.annotate("umfana ufaka"));
    }

}