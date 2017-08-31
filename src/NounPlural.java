import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class NounPlural {

    private HashMap<String, ArrayList<String>> NounList =new HashMap<>();

    public NounPlural(){
        try{
            FileReader fr = new FileReader("NounCorpus.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine = null;

            while((currentLine = br.readLine()) != null){

                String [] splitter = currentLine.split(" ");

                if (splitter[1].contains("<1>")){
                    if (NounList.containsKey("<1>")){
                        NounList.get("<1>").add(splitter[0]);
                    }else{
                        NounList.put("<1>", new ArrayList<String>());
                        NounList.get("<1>").add(splitter[0]);
                    }
                }
                else if (splitter[1].contains("<1a>")){
                    if (NounList.containsKey("<1a>")){
                        NounList.get("<1a>").add(splitter[0]);
                    }else{
                        NounList.put("<1a>", new ArrayList<String>());
                        NounList.get("<1a>").add(splitter[0]);
                    }
                }
                else if (splitter[1].contains("<2a>")){
                    if (NounList.containsKey("<2a>")){
                        NounList.get("<2a>").add(splitter[0]);
                    }else{
                        NounList.put("<2a>", new ArrayList<String>());
                        NounList.get("<2a>").add(splitter[0]);
                    }
                }
                else if (splitter[1].contains("<3>")){
                    if (NounList.containsKey("<3>")){
                        NounList.get("<3>").add(splitter[0]);
                    }else{
                        NounList.put("<3>", new ArrayList<String>());
                        NounList.get("<3>").add(splitter[0]);
                    }
                }
                else if (splitter[1].contains("<5>")){
                    if (NounList.containsKey("<5>")){
                        NounList.get("<5>").add(splitter[0]);
                    }else{
                        NounList.put("<5>", new ArrayList<String>());
                        NounList.get("<5>").add(splitter[0]);
                    }
                }
                else if (splitter[1].contains("<7>")){
                    if (NounList.containsKey("<7>")){
                        NounList.get("<7>").add(splitter[0]);
                    }else{
                        NounList.put("<7>", new ArrayList<String>());
                        NounList.get("<7>").add(splitter[0]);
                    }
                }
                else if (splitter[1].contains("<9>")){
                    if (NounList.containsKey("<9>")){
                        NounList.get("<9>").add(splitter[0]);
                    }else{
                        NounList.put("<9>", new ArrayList<String>());
                        NounList.get("<9>").add(splitter[0]);
                    }
                }
                else if (splitter[1].contains("<11>")){
                    if (NounList.containsKey("<11>")){
                        NounList.get("<11>").add(splitter[0]);
                    }else{
                        NounList.put("<11>", new ArrayList<String>());
                        NounList.get("<11>").add(splitter[0]);
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public int nounPluralQuestion(){
        Random rand = new Random();
        String [] nounClassIndices = {"1", "1a", "2a", "3", "5", "7", "9", "11"};
        String nounClassIndex = nounClassIndices[rand.nextInt(8)];

        String nounKey = "<" + nounClassIndex + ">";

        String noun = NounList.get(nounKey).get(rand.nextInt(NounList.get(nounKey).size()));
        System.out.println(noun);
        NounClass nc = new NounClass(noun);
        String pluralisedNoun = nc.pluraliseNoun(nounClassIndex);

        System.out.println("Can you make this noun plural? : " + noun);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        if (answer.equals(pluralisedNoun)){
            System.out.println("Correct Answer!");
            return 1;
        }else{
            System.out.println("Wrong answer :(");
            System.out.println("This is the correct answer: " + pluralisedNoun);
            return -1;
        }
    }

    public void runExercise(){
        int points = 0, goal = 5;
        while (true){
            points += nounPluralQuestion();
            if(points == 5){
                System.out.println("Well Done! You did it!");
                break;
            }
            else if(points == -3){
                System.out.println("Study your plurals harder :(");
                break;
            }
        }
    }
}
