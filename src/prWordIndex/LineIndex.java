package prWordIndex;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class LineIndex extends AbstractIndex {

	private Map<String, Set<Integer>> index;
	
	public LineIndex(){
		super();
		index = new TreeMap<String, Set<Integer>>();
	}
	
	@Override
	public void solve(String del){
		Iterator <String> iter = super.statements.iterator();
		int lineNumber = 1;
		while(iter.hasNext()){
			String line = iter.next();
			Scanner sc = new Scanner(line).useDelimiter(del);
			while(sc.hasNext()){
				String word = sc.next().toLowerCase();
				//Set<Integer> value = new HashSet<Integer>();
				Set<Integer> value;
				if(index.containsKey(word)){
					value = index.get(word);
					value.add(lineNumber);
					index.put(word, value);
				}
				else{
					value = new HashSet<Integer>();
					value.add(lineNumber);
					index.put(word, value);
				}
			}
			lineNumber++;
		}
	}
	
	@Override
	public void consoleIndexPrint(){
		for(String x : index.keySet()){
			System.out.println(x + "\t\t" + index.get(x));
		}
	}
	
	@Override
	public void indexPrint(PrintWriter pw){
		for(String x : index.keySet()){
			pw.println(x + "\t\t" + index.get(x));
		}
	}
	
	
}
