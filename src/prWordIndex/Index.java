package prWordIndex;

import java.io.PrintWriter;

public interface Index {
	
	public void addSentence(String sentence);
	
	public void solve (String del);
	
	public void consoleIndexPrint();
	
	public void indexPrint (PrintWriter pw);
}
