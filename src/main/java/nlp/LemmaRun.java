package nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Scanner;

public class LemmaRun {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(LemmaRun.class);

        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        CoreDocument doc = new CoreDocument(txt);

        stanfordCoreNLP.annotate(doc);

        List<CoreLabel> lst = doc.tokens();
        for (CoreLabel lbl: lst){
            String lemma = lbl.lemma();

            System.out.println(lbl.originalText() + " - " + lemma);

        }

    }

}

