import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 2017-10-03.
 */
public class VerbSCModifierTest {
    @Test
    public void verbSCModifier() throws Exception {
        VerbSCModifier vscm = new VerbSCModifier();
        String output = vscm.verbSCModifier();
        assertNotNull(output);
        String[] splitter = output.split(",");
        assertEquals(splitter.length, 4);
        assertEquals(splitter[0], "6");
    }

    @Test
    public void changeNegativeConcord() throws Exception {
        VerbSCModifier vscm = new VerbSCModifier();
        String[] output = vscm.changeNegativeConcord();
        assertNotNull(output);
        assertEquals(output.length, 4);
        assertEquals(output[0], "6");
        assertEquals(output[2], "Can you change this verbs form into its positive concord?");
    }

    @Test
    public void changePostiveConcord() throws Exception {
        VerbSCModifier vscm = new VerbSCModifier();
        String[] output = vscm.changePostiveConcord();
        assertNotNull(output);
        assertEquals(output.length, 4);
        assertEquals(output[0], "6");
        assertEquals(output[2], "Can you change this verbs form into its negative concord?");
    }

    @Test
    public void findPositiveConcord() throws Exception {
        String[] negativeConcordList = {"angi", "awu", "asi", "ani", "aba", "ayi", "ali", "awa", "azi", "alu",
                "abu", "aku"};
        String[] positiveConcordList = {"ngi", "u", "si", "ni", "ba", "i", "li", "a", "zi", "lu", "bu", "ku"};
        VerbSCModifier vscm = new VerbSCModifier();
        for (int i = 0; i<negativeConcordList.length; i++){
            assertEquals(vscm.findPositiveConcord(negativeConcordList[i]),positiveConcordList[i]);
        }
    }

    @Test
    public void findNegativeConcord() throws Exception {
        String[] negativeConcordList = {"angi", "awu", "asi", "ani", "aba", "ayi", "ali", "awa", "azi", "alu",
                "abu", "aku"};
        String[] positiveConcordList = {"ngi", "u", "si", "ni", "ba", "i", "li", "a", "zi", "lu", "bu", "ku"};
        VerbSCModifier vscm = new VerbSCModifier();
        for (int i = 0; i<positiveConcordList.length; i++){
            assertEquals(vscm.findNegativeConcord(positiveConcordList[i]),negativeConcordList[i]);
        }
    }
}