import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 2017-09-01.
 */

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

        try{

        }
        catch (Exception e){

        }

    }

    public String generateNVsentence(){
        //
        return null;
    }

    public String generateNVNsentence(){
        return null;
    }
}
