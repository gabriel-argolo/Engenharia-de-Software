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
public class LeituraTest {
    
    public LeituraTest() {
    }
    
      @Test
    public void testLerArquivo(){
        NaiveBayesClassifier nb = new NaiveBayesClassifier();
        ClassifierEvaluator ce = new ClassifierEvaluator(nb);
        //prova que ta lendo o arquivo na pasta
        //arquivo esperado
        String msg = "textoHam.txt";
        ce.Evaluate(true);
        assertEquals(msg,ce.getNome());
      // assertEquals("Ham||Arquivo lido: textoHam.txt", ce.Evaluate(true));
    }
    
}
