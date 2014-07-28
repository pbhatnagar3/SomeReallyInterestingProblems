import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * to goal is to find the largest word in any given sequence
 * One of the places where a classic top down recursion is reqd
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class FindingLargestWord {

	public static class StringComparator implements Comparator<String>{
		@Override
		public int compare(String a, String b){
			return -1 * ((Integer)a.length()).compareTo((Integer)b.length());
		}

	}
	public static String[] sort(String[] words){
		Arrays.sort(words, new StringComparator());
		return words;
	}

	public static boolean recursiveFinder(String s, boolean isOriginal, Map<String, Boolean> mapper){
		if(mapper.containsKey(s) && !isOriginal ){
			return mapper.get(s);
		}
		for(int i = 1; i < s.length(); i++){
			String left = s.substring(0, i);
			String right = s.substring(i);
			if(mapper.containsKey(left) && mapper.get(left) == true && recursiveFinder(right, false, mapper)){
				return true;
			}
		}//end of the for loop
		mapper.put(s, false);
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Enter a sentence containing all the words seperated by a space");
		Scanner scan = new Scanner(System.in);
		String sentence = scan.nextLine();
		String[] input = sentence.split(" ");
		sort(input);
		//now all the strings are sorted
		//adding all of them to the HashMap
		final Map<String, Boolean> mapper = new HashMap<String, Boolean>();
		for(String s : input){
			mapper.put(s, true);
		}
		boolean flag = true;
		for(String s: input){
			if(recursiveFinder(s, true, mapper) == true){
				System.out.println("The largest String combination is " + s);
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("No string found");

	}


}
