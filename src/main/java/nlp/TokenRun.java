package nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.util.List;
import java.util.Properties;
import java.util.Scanner;


public class TokenRun {
    public static void main(String[] args){
        // логгер ийг хоболт хийж байна
        //логгер функцаар логийн бүх утгийг харах боломжтой
        Logger logger =  LoggerFactory.getLogger(TokenRun.class);
        logger.info("Beginning Java Logger SLF4J");

        //үндсэн класс аа пип класстай хобож байна
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        // бидний үндсэн ажилларх текст
        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();
        // шинээр үүсгэж буй обжект
        CoreDocument doc = new CoreDocument(txt);

        // док дээр ажиллах
        stanfordCoreNLP.annotate(doc);

        List<CoreLabel> list = doc.tokens();
        for (CoreLabel lbl : list){
            System.out.println(lbl.originalText());
        }
    }
}
