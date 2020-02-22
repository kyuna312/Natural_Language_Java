package nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class PosTagRun {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(PosTagRun.class);
        logger.info("Hello, My name is Hoshino Rin and then my lab 3 started.");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();


        CoreDocument doc = new CoreDocument(txt);

        stanfordCoreNLP.annotate(doc);

        List<CoreLabel> lblList = doc.tokens();
        for (CoreLabel lbl: lblList){
            String pos = lbl.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(lbl.originalText() +  " - " + pos);

        }


    }
}
