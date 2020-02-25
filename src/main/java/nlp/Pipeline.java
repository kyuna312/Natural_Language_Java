package nlp;


import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;

public class Pipeline {
    //сангууд тогтмол хувьсагч болгон дуулан заралсан
    private static Properties properties;
    private static String propertiesName = "tokenize, ssplit, pos, lemma, ner, parse, sentiment";
    private static StanfordCoreNLP stanfordCoreNLP;

    //пайп бүхий байгуулагч
    Pipeline(){

    }
    // статик төрөдөөр пропэртийс ээ зарлаг
    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    // пайп байгаа эсэхийг шалгаж буй хэсэг
    public static StanfordCoreNLP getPipeline(){
        if (stanfordCoreNLP == null){
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }



}

