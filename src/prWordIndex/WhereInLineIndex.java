package prWordIndex;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WhereInLineIndex extends AbstractIndex{

	private Map<String, Map<Integer, Set<Integer>>> index;
	
	
	public WhereInLineIndex (){
		super();
		index = new TreeMap <String, Map<Integer, Set<Integer>>>();
	}
	
	@Override
	public void solve (String del){
		Iterator<String> iter = super.statements.iterator();
		int lineNumber = 1;
		while(iter.hasNext()){
			String line = iter.next();
			Scanner sc = new Scanner(line).useDelimiter(del);
			int wordNumber = 1;
 			while (sc.hasNext()){
				String word = sc.next().toLowerCase();
				Set<Integer> wordPosition;
				Map<Integer, Set<Integer>> linePosition;
				
				if(index.containsKey(word)){ //when word is in map
					linePosition = index.get(word);
					//wordPosition = linePosition.get
					
					//when we have some values in this line already we add new word number
					if (linePosition.containsKey(lineNumber)){
						wordPosition = linePosition.get(lineNumber);
						wordPosition.add(wordNumber);
						linePosition.put(lineNumber, wordPosition);
						index.put(word, linePosition);
					}
					//when we have word but we are in another number of line 
					else{
						wordPosition = new HashSet<Integer>();
						wordPosition.add(wordNumber);
						linePosition.put(lineNumber, wordPosition);
						index.put(word, linePosition);
					}
					
				}
				else{
					wordPosition = new HashSet<Integer>();
					wordPosition.add(wordNumber);
					linePosition = new TreeMap<Integer, Set<Integer>>();
					linePosition.put(lineNumber, wordPosition);
					index.put(word, linePosition);
				}
				wordNumber++;
			}
			lineNumber++;
		}
	}
	
	@Override
	public void consoleIndexPrint(){
		for(String word : index.keySet()){
			System.out.println(word);
			Map<Integer, Set<Integer>> linePosition = index.get(word);
			for(int x : linePosition.keySet()){
				System.out.println("\t" + x + " " + linePosition.get(x));
			}
		}
	}
	
	@Override
	public void indexPrint(PrintWriter pw){
		for(String word : index.keySet()){
			pw.println(word);
			Map<Integer, Set<Integer>> linePosition = index.get(word);
			for(int x : linePosition.keySet()){
				pw.println("\t" + x + " " + linePosition.get(x));
			}
		}
	}
	
	
}
