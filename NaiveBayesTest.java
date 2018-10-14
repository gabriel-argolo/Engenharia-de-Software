/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import naive_bayes.ClassifierEvaluator;
import naive_bayes.NaiveBayesClassifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class NaiveBayesTest {

    public NaiveBayesTest() {

    }

    @Test
    public void testHam() {
        NaiveBayesClassifier nb = new NaiveBayesClassifier();
        //ClassifierEvaluator ce = new ClassifierEvaluator(nb);
        //ce.Evaluate(true);
        nb.train("C://Users//Gustavo//Documents//JSpamFiltering-master//dataset//lingMessages" , "C://Users//Gustavo//Documents//JSpamFiltering-master//dataset//testMessages");
        //Retorna falso pra nãoSpam(Ham)
        assertFalse(nb.classify("Subject: I really enjoyed the meeting, hope to see you again."));
    }

    @Test
    public void testSpam() {
        NaiveBayesClassifier nb = new NaiveBayesClassifier();
 nb.train("C://Users//Gustavo//Documents//JSpamFiltering-master//dataset//lingMessages" , "C://Users//Gustavo//Documents//JSpamFiltering-master//dataset//testMessages");       
        //Retorna verdadeiro para spam
        assertTrue(nb.classify("Subject: With the Holidays approaching quickly...\n"
                + "                       CONTROL YOUR WEIGHT!!\n"
                + "                     Don't let your weight control you!\n"
                + "\n"
                + "Find Out How You Can Lose Weight Naturally & Effectively."));
    }

}
