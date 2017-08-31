import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

public class VerbClass {

    private HashMap<String, ArrayList<String>> VerbGrammar =new HashMap<>();
    String Verb;

    public void setVerb(String verb){
        Verb = verb;
    }

    public String getCurrentVerb(){
        return Verb;
    }

    public ArrayList<String> getVerbGrammar(String componentIndex){
        // Slot index numbers: NEG-0 SC-1 ASP-2 MOD-3 OC-4 VR-5 C-6 A-7 R-8 P-9
        ArrayList<String> copy = null;
        if (componentIndex.equals("NEG")){
            copy = VerbGrammar.get("NEG");
        }else if (componentIndex.equals("SC")){
            copy = VerbGrammar.get("SC");
        }else if (componentIndex.equals("ASP")){
            copy = VerbGrammar.get("ASP");
        }else if (componentIndex.equals("MOD")){
            copy =  VerbGrammar.get("MOD");
        }else if (componentIndex.equals("OC")){
            copy =  VerbGrammar.get("OC");
        }else if (componentIndex.equals("VR")){
            copy = VerbGrammar.get("VR");
        }else if (componentIndex.equals("C")){
            copy = VerbGrammar.get("C");
        }else if (componentIndex.equals("A")){
            copy = VerbGrammar.get("A");
        }else if (componentIndex.equals("R")){
            copy = VerbGrammar.get("R");
        }else if (componentIndex.equals("P")){
            copy = VerbGrammar.get("P");
        }
        return copy;
    }

    public VerbClass(){

        VerbGrammar.put("NEG", new ArrayList<String>());
        VerbGrammar.put("SC", new ArrayList<String>());
        VerbGrammar.put("ASP", new ArrayList<String>());
        VerbGrammar.put("MOD", new ArrayList<String>());
        VerbGrammar.put("OC", new ArrayList<String>());
        VerbGrammar.put("VR", new ArrayList<String>());
        VerbGrammar.put("C", new ArrayList<String>());
        VerbGrammar.put("A", new ArrayList<String>());
        VerbGrammar.put("R", new ArrayList<String>());
        VerbGrammar.put("P", new ArrayList<String>());

        Properties properties = new Properties();
        String[] VerbRules;

        try {
            properties.load(new FileInputStream("ZuluVerbRules.cfg"));
            VerbRules = properties.toString().split(",");

            for (int i = 0; i<VerbRules.length; i++){
                if (VerbRules[i].startsWith(" NS=->")){
                    String[] elements = VerbRules[i].substring(6, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("NEG").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" SC=->")){
                    String[] elements = VerbRules[i].substring(6, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("SC").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" ASP=->")){
                    String[] elements = VerbRules[i].substring(11, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("ASP").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" M=->")){
                    String[] elements = VerbRules[i].substring(6, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("MOD").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" O=->")){
                    String[] elements = VerbRules[i].substring(5, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("OC").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" C=->")){
                    String[] elements = VerbRules[i].substring(5, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("C").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" A=->")){
                    String[] elements = VerbRules[i].substring(5, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("A").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" R=->")){
                    String[] elements = VerbRules[i].substring(5, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("R").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" P=->")){
                    String[] elements = VerbRules[i].substring(5, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("P").add(elements[j].replace("\"", ""));
                        }
                    }
                }
                else if (VerbRules[i].startsWith(" VR=->")){
                    String[] elements = VerbRules[i].substring(10, VerbRules[i].length()).split(" ");
                    for (int j = 0; j< elements.length; j++){
                        if(!elements[j].contains("|") && !elements[j].isEmpty()){
                            VerbGrammar.get("VR").add(elements[j].replace("\"", ""));
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> generateSpecificVerbForm(Integer NEG, Integer SC, Integer ASP, Integer MOD, Integer OC,
                                 Integer VR, Integer C, Integer A, Integer R, Integer P){
        String newVerbForm = null;
        Random rand = new Random();

        int[] slots = {NEG, SC, ASP, MOD, OC, VR, C, A, R, P};
        int[] revisedSlots = checkVerbRuleConsistency(slots);
//        System.out.print(revisedSlots[0]);System.out.print(revisedSlots[1]);
//        System.out.print(revisedSlots[2]);System.out.print(revisedSlots[3]);
//        System.out.print(revisedSlots[4]);System.out.print(revisedSlots[5]);
//        System.out.print(revisedSlots[6]);System.out.print(revisedSlots[7]);
//        System.out.print(revisedSlots[8]);System.out.print(revisedSlots[9]);


        ArrayList<String> verbSlotHolder = new ArrayList<>();

        if(revisedSlots[0] == 1){
            verbSlotHolder.add(VerbGrammar.get("NEG").get(rand.nextInt(VerbGrammar.get("NEG").size())));
        }
        if(revisedSlots[1] == 1){
            verbSlotHolder.add(VerbGrammar.get("SC").get(rand.nextInt(VerbGrammar.get("SC").size())));
        }
        if(revisedSlots[2] == 1){
            verbSlotHolder.add(VerbGrammar.get("ASP").get(rand.nextInt(VerbGrammar.get("ASP").size())));
        }
        if(revisedSlots[3] == 1){
            verbSlotHolder.add(VerbGrammar.get("MOD").get(rand.nextInt(VerbGrammar.get("MOD").size())));
        }
        if(revisedSlots[4] == 1){
            verbSlotHolder.add(VerbGrammar.get("OC").get(rand.nextInt(VerbGrammar.get("OC").size())));
        }
        if(revisedSlots[5] == 1){
            verbSlotHolder.add(VerbGrammar.get("VR").get(rand.nextInt(VerbGrammar.get("VR").size())));
        }
        if(revisedSlots[6] == 1){
            verbSlotHolder.add(VerbGrammar.get("C").get(rand.nextInt(VerbGrammar.get("C").size())));
        }
        if(revisedSlots[7] == 1){
            verbSlotHolder.add(VerbGrammar.get("A").get(rand.nextInt(VerbGrammar.get("A").size())));
        }
        if(revisedSlots[8] == 1){
            verbSlotHolder.add(VerbGrammar.get("R").get(rand.nextInt(VerbGrammar.get("R").size())));
        }
        if(revisedSlots[9] == 1){
            verbSlotHolder.add(VerbGrammar.get("P").get(rand.nextInt(VerbGrammar.get("P").size())));
        }

        //Negative or positive final vowel
        if(revisedSlots[0] == 1){
            verbSlotHolder.add("i");
        }else if (revisedSlots[1] == 1){
            verbSlotHolder.add("a");
        }

        return verbSlotHolder;
    }

    // Creates a new verb with randomised suffixes and prefixes
    public ArrayList<String> generateRandomVerbForm(){
        String newVerbForm = null;
        Random rand = new Random();

        int NEG = rand.nextInt(2); int SC = rand.nextInt(2); int ASP = rand.nextInt(2); int MOD = rand.nextInt(2);
        int OC = rand.nextInt(2); int C = rand.nextInt(2); int A = rand.nextInt(2); int R = rand.nextInt(2);
        int P = rand.nextInt(2);

        int[] slots = {NEG, SC, ASP, MOD, OC, 1, C, A, R, P};
        int[] revisedSlots = checkVerbRuleConsistency(slots);

        // This portion of the code will generate the final
        ArrayList<String> verbSlotHolder = new ArrayList<>();

        if(revisedSlots[0] == 1){
            verbSlotHolder.add(VerbGrammar.get("NEG").get(rand.nextInt(VerbGrammar.get("NEG").size())));
        }
        if(revisedSlots[1] == 1){
            verbSlotHolder.add(VerbGrammar.get("SC").get(rand.nextInt(VerbGrammar.get("SC").size())));
        }
        if(revisedSlots[2] == 1){
            verbSlotHolder.add(VerbGrammar.get("ASP").get(rand.nextInt(VerbGrammar.get("ASP").size())));
        }
        if(revisedSlots[3] == 1){
            verbSlotHolder.add(VerbGrammar.get("MOD").get(rand.nextInt(VerbGrammar.get("MOD").size())));
        }
        if(revisedSlots[4] == 1){
            verbSlotHolder.add(VerbGrammar.get("OC").get(rand.nextInt(VerbGrammar.get("OC").size())));
        }
        if(revisedSlots[5] == 1){
            verbSlotHolder.add(VerbGrammar.get("VR").get(rand.nextInt(VerbGrammar.get("VR").size())));
        }
        if(revisedSlots[6] == 1){
            verbSlotHolder.add(VerbGrammar.get("C").get(rand.nextInt(VerbGrammar.get("C").size())));
        }
        if(revisedSlots[7] == 1){
            verbSlotHolder.add(VerbGrammar.get("A").get(rand.nextInt(VerbGrammar.get("A").size())));
        }
        if(revisedSlots[8] == 1){
            verbSlotHolder.add(VerbGrammar.get("R").get(rand.nextInt(VerbGrammar.get("R").size())));
        }
        if(revisedSlots[9] == 1){
            verbSlotHolder.add(VerbGrammar.get("P").get(rand.nextInt(VerbGrammar.get("P").size())));
        }

        //Negative or positive final vowel
        if(revisedSlots[0] == 1){
            verbSlotHolder.add("i");
        }else{
            verbSlotHolder.add("a");
        }

        return verbSlotHolder;
    }

    // Overided method which allows user to create a new verb form with their own specified root
    public ArrayList<String> generateRandomVerbForm(String VR){
        String newVerbForm = null;
        Random rand = new Random();

        int NEG = rand.nextInt(2); int SC = rand.nextInt(2); int ASP = rand.nextInt(2); int MOD = rand.nextInt(2);
        int OC = rand.nextInt(2); int C = rand.nextInt(2); int A = rand.nextInt(2); int R = rand.nextInt(2);
        int P = rand.nextInt(2);

        int[] slots = {NEG, SC, ASP, MOD, OC, 1, C, A, R, P};
        int[] revisedSlots = checkVerbRuleConsistency(slots);

        // This portion of the code will generate the final
        ArrayList<String> verbSlotHolder = new ArrayList<>();

        if(revisedSlots[0] == 1){
            verbSlotHolder.add(VerbGrammar.get("NEG").get(rand.nextInt(VerbGrammar.get("NEG").size())));
        }
        if(revisedSlots[1] == 1){
            verbSlotHolder.add(VerbGrammar.get("SC").get(rand.nextInt(VerbGrammar.get("SC").size())));
        }
        if(revisedSlots[2] == 1){
            verbSlotHolder.add(VerbGrammar.get("ASP").get(rand.nextInt(VerbGrammar.get("ASP").size())));
        }
        if(revisedSlots[3] == 1){
            verbSlotHolder.add(VerbGrammar.get("MOD").get(rand.nextInt(VerbGrammar.get("MOD").size())));
        }
        if(revisedSlots[4] == 1){
            verbSlotHolder.add(VerbGrammar.get("OC").get(rand.nextInt(VerbGrammar.get("OC").size())));
        }
        if(revisedSlots[5] == 1){
            verbSlotHolder.add(VR);
        }
        if(revisedSlots[6] == 1){
            verbSlotHolder.add(VerbGrammar.get("C").get(rand.nextInt(VerbGrammar.get("C").size())));
        }
        if(revisedSlots[7] == 1){
            verbSlotHolder.add(VerbGrammar.get("A").get(rand.nextInt(VerbGrammar.get("A").size())));
        }
        if(revisedSlots[8] == 1){
            verbSlotHolder.add(VerbGrammar.get("R").get(rand.nextInt(VerbGrammar.get("R").size())));
        }
        if(revisedSlots[9] == 1){
            verbSlotHolder.add(VerbGrammar.get("P").get(rand.nextInt(VerbGrammar.get("P").size())));
        }

        //Negative or positive final vowel
        if(revisedSlots[0] == 1){
            verbSlotHolder.add("i");
        }else{
            verbSlotHolder.add("a");
        }

        return verbSlotHolder;
    }

    public String concatenateVerb(ArrayList<String> verbSlotHolder){
        String newVerbForm = verbSlotHolder.get(0);

        for (int i = 1; i<verbSlotHolder.size(); i++){
            newVerbForm += verbSlotHolder.get(i);
        }

        return newVerbForm.replace("\"", "");
    }

    // Use this to ensure that the system is not breaking any rules when automatically generating a verb
    private int[] checkVerbRuleConsistency(int [] slots){
        // Slot index numbers: NEG-0 SC-1 ASP-2 MOD-3 OC-4 VR-5 C-6 A-7 R-8 P-9
        //checks to ensure that the verb generated is not both positive and negative
        if (slots[0]== 1 && slots[1] == 1){
            slots[0] = 0;
        }
        // if something is causative it must include both a subject concord and an object concord
        if (slots[6] == 1){
            slots[1] = 1;
            slots[4] = 1;
        }
        // if a verb is applicative then it must include both a subject concord and an object concord
        if (slots[7] == 1){
            slots[1] = 1;
            slots[4] = 1;
        }
        // if a verb is passive then it must include an object concord and not a subject concord
        if (slots[9] == 1){
            slots[1] = 0;
            slots[4] = 1;
        }

        return slots;
    }

    public String nounClassModifier(int precedingNounClass){
        String modifiedVerb = null;

        /* Each of these modifiers correspond to a noun class. This will be used to change the verb to make it adhere
         the changes of the */
        if (precedingNounClass == 1){
            modifiedVerb = "u" + Verb;
        }
        else if (precedingNounClass == 3){
            modifiedVerb = "u" + Verb;
        }
        else if(precedingNounClass == 5){
            modifiedVerb = "li" + Verb;
        }
        else if (precedingNounClass == 7){
            modifiedVerb = "si" + Verb;
        }
        else if (precedingNounClass == 9){
            modifiedVerb = "i" + Verb;
        }
        else if (precedingNounClass == 11){
            modifiedVerb = "lu" + Verb;
        }
        return modifiedVerb;
    }

    public String pluraliseVerb(String precedingNoun) throws IOException {
        String pluralisedVerb = null;
        NounClass nc = new NounClass(precedingNoun);
        int nounClass = nc.findNounClass();

        // These rules can be extended with further study of the patterns
        if (nounClass == 1){
            pluralisedVerb =  "ba" + Verb;
        }
        else if (nounClass == 3){
            pluralisedVerb = "i" + Verb;
        }
        else if(nounClass == 5){
            pluralisedVerb = "a" + Verb;
        }
        else if (nounClass == 7){
            pluralisedVerb = "zi" + Verb;
        }
        else if (nounClass == 9){
            pluralisedVerb = "zi" + Verb;
        }
        else if (nounClass == 11){
            pluralisedVerb = "zi" + Verb;
        }
        return pluralisedVerb;
    }
}
