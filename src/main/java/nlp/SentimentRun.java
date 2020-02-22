package nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class SentimentRun {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(SentimentRun.class);

        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        CoreDocument doc = new CoreDocument(txt);

        stanfordCoreNLP.annotate(doc);

        List<CoreSentence> sens = doc.sentences();
        for (CoreSentence sen: sens){
            String sentiment = sen.sentiment();

            System.out.println(sen + " \t " + sentiment);

        }



    }
}
