import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017-09-28.
 */
public class SentencePluraliserGenTest {
    @Test
    public void sentencePluraliseExercise() throws Exception {
        SentencePluraliserGen spg = new SentencePluraliserGen();
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();

        String output = spg.sentencePluraliseExercise();
        assertNotNull(output);

        String [] splitter = output.split(",");
        assertEquals(splitter.length, 4);
        assertEquals(splitter[0], "3");

        nc.setNoun(splitter[1].split(" ")[0].split("_")[0]);
        vc.setVerb(splitter[1].split(" ")[1].split("_")[0]);
        String nounClass = nc.findNounClass();

        assertEquals(nc.pluraliseNoun(nounClass), splitter[3].split(" ")[0].split("_")[0]);
        assertEquals(vc.pluraliseVerb(nounClass), splitter[3].split(" ")[1].split("_")[0]);

        assertEquals(splitter[1].split(" ")[0].split("_")[1], "n");
        assertEquals(splitter[1].split(" ")[1].split("_")[1], "v");
        assertEquals(splitter[1].split(" ")[2].split("_")[1], "n");

        assertEquals(splitter[2], "Analyze_v and rewrite_v the sentence so that the noun and verb are plural.");
    }

    @Test
    public void annotate() throws Exception {
        SentencePluraliserGen spg = new SentencePluraliserGen();
        assertEquals("umfana_n ufaka_v ifestile_n", spg.annotate("umfana ufaka ifestile"));
        assertNotEquals("umfana_v ufaka_n ifestile_v", spg.annotate("umfana ufaka ifestile"));
    }

}