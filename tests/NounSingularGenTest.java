import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017-10-02.
 */
public class NounSingularGenTest {
    @Test
    public void nounSingularExercises() throws Exception {
        NounSingularGen nsg = new NounSingularGen();
        NounClass nc = new NounClass();

        String output = nsg.nounSingularExercises();
        assertNotNull(output);

        String [] splitter = output.split(",");
        assertEquals(splitter.length, 4);
        assertEquals(splitter[0], "5");

        nc.setNoun(splitter[3].split(" ")[0].split("_")[0]);

        assertEquals(splitter[1].split(" ")[0].split("_")[1], "n");
        assertEquals(splitter[1].split(" ")[1].split("_")[1], "v");
        assertEquals(splitter[2], "Identify_v the change needed to make the noun a singular and " +
                "rewrite_v the sentence with this change.");
    }

    @Test
    public void annotate() throws Exception {
        NounSingularGen nsg = new NounSingularGen();
        assertEquals("umfana_n ufaka_v", nsg.annotate("umfana ufaka"));
        assertNotEquals("umfana_v ufaka_v", nsg.annotate("umfana ufaka"));
    }

}