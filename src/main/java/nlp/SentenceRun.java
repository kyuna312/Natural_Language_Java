package nlp;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class SentenceRun {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(SentenceRun.class);
        logger.info("Sentence log started");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();

        CoreDocument doc = new CoreDocument(txt);
        stanfordCoreNLP.annotate(doc);

        List<CoreSentence> sens = doc.sentences();
        for (CoreSentence sen: sens){
            System.out.println(sen.toString());
        }

    }
}
