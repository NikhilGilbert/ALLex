import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SentenceGeneratorClass{

    private HashMap<String, ArrayList<String>> NounConsumables = new HashMap<>();
    private HashMap<String, ArrayList<String>> VerbConsumables = new HashMap<>();

    public SentenceGeneratorClass(){

        // Load nouns into a hashtable
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

    public String generateNVsentence(){
        // select random key from the noun list
        // Add that to the sentence constructor

        return null;
    }

    public String generateNVNsentence(){
        return null;
    }

    public String generateNVVsentence(){
        return null;
    }
}
