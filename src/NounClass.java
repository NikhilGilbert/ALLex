import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NounClass {

    public String Noun;

    public NounClass(){}

    public NounClass(String n){
        Noun = n;
    }

    public void setNoun(String n){
        Noun = n;
    }

    public String getNoun(){
        return Noun;
    }

    public String getAnnotatedNoun(){
        return Noun + "_n";
    }

    public String pluraliseNoun(String nc){

        String changedNounForm = null;

        if ((Noun.startsWith("um")) && Noun.charAt(2) != 'u' && nc.equals("1")){
            changedNounForm = "aba" + Noun.substring(2, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("u") && nc.equals("1a")){
            changedNounForm = "o" + Noun.substring(1, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("u") && nc.equals("2a")){
            changedNounForm = "o" + Noun.substring(1, Noun.length());
            System.out.println(changedNounForm);
        }
        else if((Noun.startsWith("um")) && ((Noun.charAt(2) == 'a') || (Noun.charAt(2) =='i') || (Noun.charAt(2) == 'o')
                || (Noun.charAt(2) == 'e'))){
            changedNounForm = "ab" + Noun.substring(2, Noun.length());
            System.out.println(changedNounForm);
        }
        else if(Noun.startsWith("umu") && nc.equals("1")){
            changedNounForm = "aba" + Noun.substring(3, Noun.length());
            System.out.println(changedNounForm);
        }
        else if ((Noun.startsWith("um")) && Noun.charAt(2) != 'u' && nc.equals("3")){
            changedNounForm = "imi" + Noun.substring(2, Noun.length());
            System.out.println(changedNounForm);
        }
        else if ((Noun.startsWith("umu")) && nc.equals("3")){
            changedNounForm = "imi" + Noun.substring(3, Noun.length());
            System.out.println(changedNounForm);
        }
        // Remember that this rule applies to both 5 and 9a
        else if ((Noun.startsWith("i")) && (!Noun.substring(0,2).equals("ili")) && (nc.equals("5"))){
            changedNounForm = "ama" + Noun.substring(1, Noun.length());
            System.out.println(changedNounForm);
        }
        else if ((Noun.startsWith("ili")) && nc .equals("5")){
            changedNounForm = "ama" + Noun.substring(3, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("isi") && nc.equals("7")){
            changedNounForm = "izi" + Noun.substring(3, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("is") && nc.equals("7") && ((Noun.charAt(2) == 'a') || (Noun.charAt(2) =='i') || (Noun.charAt(2) == 'o')
                || (Noun.charAt(2) == 'e'))){
            changedNounForm = "iz" + Noun.substring(2, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("i") && Noun.charAt(1) != 'n' && nc.equals("9")){
            changedNounForm = "izi" + Noun.substring(1, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("in") && nc.equals("9")){
            changedNounForm = "izin" + Noun.substring(2, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("u") && !Noun.substring(1,2).equals("lu") && nc.equals("11")){
            changedNounForm = "izi" + Noun.substring(1, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("ulu") && nc.equals("11")){
            changedNounForm = "izi" + Noun.substring(3, Noun.length());
            System.out.println(changedNounForm);
        }
        else if (Noun.startsWith("ubu") && nc.equals("14")){
            changedNounForm = Noun;
            System.out.println(changedNounForm);
        }

        return changedNounForm;
    }

    public String findNounClass() throws IOException {
        // If using a better corpus. We can use this to look up nouns for an unannotated corpus
        FileReader fr = new FileReader("NounCorpus.txt");
        BufferedReader br = new BufferedReader(fr);

        String nounClass = null;

        String currentLine = null;

        while((currentLine = br.readLine()) != null){
            if (currentLine.indexOf(Noun)!=-1){
                break;
            }else{
                continue;
            }
        }

        if (currentLine.contains("<1>")){
            nounClass = "1";
            return nounClass;
        }
        else if(currentLine.contains("<1a>")){
            nounClass = "1a";
            return nounClass;
        }
        else if(currentLine.contains("<2a>")){
            nounClass = "2a";
            return nounClass;
        }
        else if(currentLine.contains("<2>")){
            nounClass = "2";
            return nounClass;
        }
        else if(currentLine.contains("<3>")){
            nounClass = "3";
            System.out.println(3);
            return nounClass;
        }
        else if(currentLine.contains("<4>")){
            nounClass = "4";
            System.out.println(3);
            return nounClass;
        }
        else if(currentLine.contains("<5>")){
            nounClass = "5";
            System.out.println(5);
            return nounClass;
        }
        else if(currentLine.contains("<6>")){
            nounClass = "6";
            System.out.println(3);
            return nounClass;
        }
        else if(currentLine.contains("<7>")){
            nounClass = "7";
            System.out.println(7);
            return nounClass;
        }
        else if(currentLine.contains("<8>")){
            nounClass = "8";
            System.out.println(3);
            return nounClass;
        }
        else if(currentLine.contains("<9>")){
            nounClass = "9";
            System.out.println(9);
            return nounClass;
        }
        else if(currentLine.contains("<10>")){
            nounClass = "10";
            System.out.println(3);
            return nounClass;
        }
        else if(currentLine.contains("<11>")){
            nounClass = "11";
            System.out.println(11);
            return nounClass;
        }
        else if(currentLine.contains("<12>")){
            nounClass = "12";
            System.out.println(3);
            return nounClass;
        }
        else if(currentLine.contains("<13>")){
            nounClass = "13";
            System.out.println(3);
            return nounClass;
        }
        else if(currentLine.contains("<14>")){
            nounClass = "14";
            System.out.println(14);
            return nounClass;
        }
        else if(currentLine.contains("<15>")){
            nounClass = "15";
            System.out.println(15);
            return nounClass;
        }
        else{
            System.out.println("Another noun class");
            return "Noun class not found.";
        }
    }
}
