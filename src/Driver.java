import java.io.IOException;

public class Driver {
    public static void main (String[] args) throws IOException {

        /*
        * We need to create a user interface that will allow the users to select the type of exercize they would like to
        * use and construct a point based system where they pass should they get above a certain score. The users should
        * be able to check to see if they have done well on a particular exercize and whether they can make improvements
        * to their score. This will likely be built using a case by case system. Eg. If the user wants to do the verb questions
        * they should access the options lis which then
        * */

        SentenceGeneratorClass sgc = new SentenceGeneratorClass();
        sgc.generateNVsentence();

//        VerbCARPExtension vce = new VerbCARPExtension();
//        vce.changeCPrefixExersize();

//        VerbSCModifier vm = new VerbSCModifier();
//        vm.runExercise();

//        SentenceScrabble ss = new SentenceScrabble();
//        ss.init();

//        NounPlural np = new NounPlural();
//        np.runExercise();

//        NounSingular ns = new NounSingular();
//        ns.runExercize();

    }
}
