package prWordIndex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractIndex implements Index {

	protected List<String> statements;
	
		
	public AbstractIndex() {
		statements = new ArrayList<String>();
	}

	public void addSentence (String statement) {
		statements.add(statement);
	}

	public void consoleIndexPrint() {
		Iterator<String> iter = statements.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}


