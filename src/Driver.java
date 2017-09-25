import java.io.IOException;

public class Driver {
    public static void main (String[] args) throws IOException {

//        SentenceGeneratorClass sgc ;
//
//        for (int i= 0; i < 50; i++){
//            sgc = new SentenceGeneratorClass();
//            sgc.generateNVsentence();
//        }

        SentencePluraliser sp;
        for(int i = 0; i< 50; i++){
            sp = new SentencePluraliser();
            sp.threeWordSenetence();
        }

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
