package prWordIndex;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CounterIndex extends AbstractIndex {

	
	private Map<String, Integer> index;
	
	
	public CounterIndex() {
		super();
		index = new TreeMap<String, Integer>();
	}

	@Override
	public void solve(String del) {
		Iterator<String> iter = super.statements.iterator();
		while (iter.hasNext()) {
			String line = iter.next();
			Scanner sc = new Scanner(line).useDelimiter(del);
			while (sc.hasNext()) {
				String word = sc.next().toLowerCase();
				if(index.containsKey(word)) {
					int value = index.get(word);
					value++;
					index.put(word, value);
				}
				else {
					index.put(word, 1);
				}
			}
		}
	}
	
	@Override
	public void consoleIndexPrint(){
		for (String x : index.keySet()){
			System.out.println(x + "\t\t" + index.get(x));
		}
	}
	
	@Override
	public void indexPrint(PrintWriter pw) {
		for (String x : index.keySet()){
			pw.println(x + "\t\t" + index.get(x));
		}		
	}
}
