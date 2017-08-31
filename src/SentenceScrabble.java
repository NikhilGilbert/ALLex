import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 2017-08-10.
 */
public class SentenceScrabble {
    public int sentenceScrabbleExercise(){
        ArrayList<String> sentenceHolder = new ArrayList<>();

        try{
            FileReader fr = new FileReader("ListofZuluSentences.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine = null;

            while((currentLine = br.readLine()) != null){
                String[] splitter = currentLine.split(" ");
                if (splitter.length <= 5){
                    sentenceHolder.add(currentLine);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Random rand = new Random();
        int  n = rand.nextInt(sentenceHolder.size());
        System.out.println(sentenceHolder.get(n));

        String[] shuffle = sentenceHolder.get(n).split(" ");

        ArrayList<String> normalList = new ArrayList<>();
        ArrayList<String> mixedList = new ArrayList<>();

        for (int i = 0; i < shuffle.length; i++){
            normalList.add(shuffle[i]);
            mixedList.add(shuffle[i]);
        }

        Collections.shuffle(mixedList);
        System.out.println(mixedList);

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the sentence in the correct order or, if it is already in the " +
                "correct order, type it out:");
        String answer =sc.nextLine();
        String[] answerCheck = answer.split(" ");

        boolean correctAnswer = true;

        for (int j = 0; j < answerCheck.length; j++){
            if (answerCheck[j].equals(normalList.get(j))){
                continue;
            }
            else{
                System.out.println("Incorrect Answer");
                correctAnswer = false;
                return -1;
            }
        }
        if (correctAnswer){
            System.out.println("Correct Answer");
            return 1;
        }
        return 0;
    }

    public void runExercise(){
        int points = 0;
        while (true){
            points += sentenceScrabbleExercise();
            if(points == 2){
                System.out.println("Well Done! You did it!");
                break;
            }
            else if(points == -2){
                System.out.println("Study your sentences harder :(");
                break;
            }
        }
    }

}
