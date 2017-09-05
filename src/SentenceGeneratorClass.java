import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SentenceGeneratorClass{

    private HashMap<String, ArrayList<String>> NounConsumables = new HashMap<>();
    private HashMap<String, ArrayList<String>> VerbConsumables = new HashMap<>();

    public SentenceGeneratorClass(){

        try{
            FileReader fr = new FileReader("NounChainList.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine = null;

            while((currentLine = br.readLine()) != null){
                String [] splitter = currentLine.split(" ");
                if (splitter.length == 3){

                    ArrayList<String> approvedVerbs = new ArrayList<>();
                    String[] verbSplitter = splitter[2].split(";");
                    for (int i = 0; i<verbSplitter.length; i++){
                        approvedVerbs.add(verbSplitter[i]);
                    }
                    NounConsumables.put(splitter[0] + " " + splitter[1], approvedVerbs);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //Load Verbs into a hashtable
        try{
            FileReader fr = new FileReader("VerbChain.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine = null;

            while((currentLine = br.readLine()) != null){
                String [] splitter = currentLine.split(" ");
                if (splitter.length == 3){

                    ArrayList<String> approvedNouns = new ArrayList<>();
                    String[] nounSplitter = splitter[2].split(";");
                    for (int i = 0; i < nounSplitter.length; i++){
                        approvedNouns.add(nounSplitter[i]);
                    }
                    VerbConsumables.put(splitter[0] + " " + splitter[1], approvedNouns);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateNVsentence() throws IOException {

        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();

        // select random key from the noun list
        List<String> keysAsArray = new ArrayList<String>(NounConsumables.keySet());
        Random rand = new Random();
        String key = keysAsArray.get(rand.nextInt(keysAsArray.size()));
        String [] splitKey = key.split(" ");
        nc.setNoun(splitKey[0]);

        ArrayList<String> exceptionList = new ArrayList<>();
        ArrayList<String> approvedVerbs = NounConsumables.get(key);

        for (int i = 0; i < approvedVerbs.size(); i++){
            if (approvedVerbs.get(i).startsWith("e_")){
                exceptionList.add(approvedVerbs.get(i));
                approvedVerbs.remove(approvedVerbs.indexOf(approvedVerbs.get(i)));
                i -= i;
            }
        }

        //make sure that this verb is terminal // and not in the exclusion list
        String useableVerb = approvedVerbs.get(rand.nextInt(approvedVerbs.size()));
        boolean exclusionVerb = true;
        List<String> verbKeys = new ArrayList<String>(VerbConsumables.keySet());

        while(exclusionVerb == true){
            if (useableVerb.startsWith("ALL_v")){
                String verbKey = verbKeys.get(rand.nextInt(verbKeys.size()));
                String [] splitVerbKey = verbKey.split(" ");
                for (String s: exceptionList){
                    if (s.contains(splitVerbKey[0])){
                        exclusionVerb = true;
                    }
                    else if (!splitVerbKey[1].contains("t")){
                        exclusionVerb = true;
                    }
                    else{
                        exclusionVerb = false;
                        useableVerb = splitVerbKey[0];
                    }
                }
            }else {
                exclusionVerb = false;
            }
        }
        vc.setVerb(useableVerb);
        vc.setVerb(vc.nounClassModifier(nc.findNounClass()));
        System.out.println(nc.getNoun() + " " + vc.getVerb());
        String NVsentence = nc.getNoun() + " " + vc.getVerb();
        return NVsentence;
    }

    public String generateNVNsentence() throws IOException {
        NounClass nc = new NounClass();
        VerbClass vc = new VerbClass();
        NounClass nc2 = new NounClass();

        // select random key from the noun list
        List<String> keysAsArray = new ArrayList<String>(NounConsumables.keySet());
        Random rand = new Random();
        String key = keysAsArray.get(rand.nextInt(keysAsArray.size()));
        String [] splitKey = key.split(" ");
        nc.setNoun(splitKey[0]);

        ArrayList<String> exceptionList = new ArrayList<>();
        ArrayList<String> approvedVerbs = NounConsumables.get(key);

        for (int i = 0; i < approvedVerbs.size(); i++){
            if (approvedVerbs.get(i).startsWith("e_")){
                exceptionList.add(approvedVerbs.get(i));
                approvedVerbs.remove(approvedVerbs.indexOf(approvedVerbs.get(i)));
                i -= i;
            }
        }

        //make sure that this verb is terminal // and not in the exclusion list
        String useableVerb = approvedVerbs.get(rand.nextInt(approvedVerbs.size()));
        boolean exclusionVerb = true;
        List<String> verbKeys = new ArrayList<String>(VerbConsumables.keySet());

        while(exclusionVerb == true){
            if (useableVerb.startsWith("ALL_v")){
                String verbKey = verbKeys.get(rand.nextInt(verbKeys.size()));
                String [] splitVerbKey = verbKey.split(" ");
                for (String s: exceptionList){
                    if (s.contains(splitVerbKey[0])){
                        exclusionVerb = true;
                    }
                    else{
                        exclusionVerb = false;
                        useableVerb = splitVerbKey[0];
                    }
                }
            }else {
                exclusionVerb = false;
            }
        }
        vc.setVerb(useableVerb);


        // Getting the Third noun
        String useableNoun = null;
        ArrayList<String> approvedNouns = new ArrayList<>();
        ArrayList<String> exclusionList = new ArrayList<>();

        List<String> VerbConsumablesKeys = new ArrayList<String>(VerbConsumables.keySet());
        for (String s: VerbConsumablesKeys){
            if (s.startsWith(vc.getVerb())){
                approvedNouns = VerbConsumables.get(s);
            }
        }

        // search the list at randomly and return a value
        // create checks for the ALL identifiers, make sure they are good
        for (int i = 0; i<approvedNouns.size(); i++){
            if(approvedNouns.get(i).startsWith("e_")){
                exclusionList.add(approvedNouns.get(i));
                approvedNouns.remove(i);
                i -= i;
            }
        }

        if (exclusionList.isEmpty()){
            useableNoun = approvedNouns.get(rand.nextInt(approvedNouns.size()));
            if (useableNoun.startsWith("ALL_")){
                String nounClass = useableNoun.substring(4, useableNoun.length());


            }

        }
        else if (!exclusionList.isEmpty()){
            boolean exclusionNoun = true;
            useableNoun = approvedNouns.get(rand.nextInt(approvedNouns.size()));

            while(exclusionNoun == true){
                if (useableNoun.startsWith("ALL_")){
//                    String [] splitVerbKey = verbKey.split(" ");
//                    for (String s: exceptionList){
//                        if (s.contains(splitVerbKey[0])){
//                            exclusionVerb = true;
//                        }
//                        else{
//                            exclusionVerb = false;
//                            useableVerb = splitVerbKey[0];
//                        }
//                    }
                }else {
                    exclusionVerb = false;
                }
            }
        }




        // vc.setVerb(vc.nounClassModifier(nc.findNounClass()));
        return null;
    }

    public String generateNVVsentence(){
        return null;
    }

    public String retrieveFromNounCorpus(String nounClass){
        String noun = null;
        ArrayList approvedNouns = new ArrayList();

        try{
            FileReader fr = new FileReader("NounCorpus.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine = null;

            while((currentLine = br.readLine()) != null){
                String[] splitter = currentLine.split(" ");
                if (splitter[1].equals("<"+ nounClass +">")){
                    approvedNouns.add(splitter[0]);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Random rand = new Random();
        noun = approvedNouns.get(rand.nextInt(approvedNouns.size())).toString();
        return noun;
    }

}
