import java.io.FileNotFoundException;
import java.io.PrintWriter;

import prWordIndex.*;

public class IndexTest {

	public static void main(String[] args) {


		
		String del = "[ .,:;-[¡][!]¿?]+";
		
		System.out.println("CounterIndex");
		Index cp = new CounterIndex();
		cp.addSentence("The animal I really dig,");
		cp.addSentence("Above all others is the pig.");
		cp.addSentence("Pigs are noble. Pigs are clever,");
		cp.addSentence("Pigs are courteous. However,");
		cp.addSentence("Now and then, to break this rule,");
		cp.addSentence("One meets a pig who is a fool.");
		cp.solve(del);
		cp.consoleIndexPrint();
		
		System.out.println();
		System.out.println("LineIndex");
		cp = new LineIndex();
		cp.addSentence("The animal I really dig,");
		cp.addSentence("Above all others is the pig.");
		cp.addSentence("Pigs are noble. Pigs are clever,");
		cp.addSentence("Pigs are courteous. However,");
		cp.addSentence("Now and then, to break this rule,");
		cp.addSentence("One meets a pig who is a fool.");
		cp.solve(del);
		cp.consoleIndexPrint();
		
		System.out.println();
		System.out.println("LineIndex");
		cp = new WhereInLineIndex();
		cp.addSentence("The animal I really dig,");
		cp.addSentence("Above all others is the pig.");
		cp.addSentence("Pigs are noble. Pigs are clever,");
		cp.addSentence("Pigs are courteous. However,");
		cp.addSentence("Now and then, to break this rule,");
		cp.addSentence("One meets a pig who is a fool.");
		cp.solve(del);
		cp.consoleIndexPrint();
	}

}
