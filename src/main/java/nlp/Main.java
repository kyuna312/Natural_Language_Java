package nlp;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Scanner;

public class Main implements ActionListener{
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    JButton b1;
    Main(){
        JFrame f= new JFrame();
        tf1=new JTextField();
        tf1.setBounds(50,50,150,20);
        tf2=new JTextField();
        tf2.setBounds(50,100,300,300);
        tf2.setEditable(false);
        b1=new JButton("Токен");
        b1.setBounds(50,00,50,50);
        b1.addActionListener(this);
        f.add(tf1);f.add(tf2);f.add(b1);
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String txt = tf1.getText();
        //үндсэн класс аа пип класстай хобож байна
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        // шинээр үүсгэж буй обжект
        CoreDocument doc = new CoreDocument(txt);

        // док дээр ажиллах
        stanfordCoreNLP.annotate(doc);

        //List<CoreLabel> lblList = doc.tokens();
        //for (CoreLabel lbl: lblList){
            //String pos = lbl.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            //tf2.setText(lbl.originalText() +  " - " + pos);

        //}
        //List<CoreSentence> sens = doc.sentences();
        //for (CoreSentence sen: sens){ßß
            //tf2.setText(sen.toString());
        //}
        List<CoreLabel> list = doc.tokens();
        for (CoreLabel lbl : list){
            System.out.println(lbl.originalText());
            for(int i = 0;i<10; i++)
            {

                tf2.setText("\n");
                tf2.setText("Токен " + i + lbl.originalText()  + "\n");
            }
            //tf2.setText( "токен" + lbl.originalText() );


        }
    }
    public static void main(String[] args) {
        new Main();
    } }






