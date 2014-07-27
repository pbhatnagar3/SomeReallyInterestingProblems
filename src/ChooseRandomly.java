import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Choosing m elements from a n - element array and this is done randomly
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class ChooseRandomly {


	public int random(int low, int high){
		return low + (int)(Math.random() * (high - low + 1));
	}
	public int[] chooseRandomlyIterative(int[] array, int m){
		if(array.length < m)
			throw new RuntimeException("the array length should atleast be " + m + " elements");
		int[] result = new int[m];
		int temp = 0;
		for(int i = 0; i < m; i++){
			result[i] = array[i];
		}
		for(int i = m; i < array.length; i++){
			int k = random(0, i);
//			System.out.println("value of k " + k + "and value of i " + i);
			if(k < m){
				temp = array[i];
				array[i] = result[k];
				result[k] = temp;
			}
		}// end of for loop
		return result;
	}

	public int[] chooseRandomlyRecursively(int[] array, int m, int i){
		int[] result = null;
		if(m == i + 1){
			return Arrays.copyOf(array, m);
		}
		else if(i + 1 > m){
			//recursive call
			result = chooseRandomlyRecursively(array, m, i - 1);
			int k = random(0, i);
			if(k < m){
				int temp = array[i];
				array[i] = result[k];
				result[k] = temp;
			}
			return result;
		}
		return null;
	}
	
	public static void main(String[] args) {
		final int NUMBER_ELEMENTS = 10;
		ChooseRandomly randomness = new ChooseRandomly();
		int[] array = new int[NUMBER_ELEMENTS];
		for(int i = 0; i < NUMBER_ELEMENTS; i++){
			array[i] = i;
		}
		Scanner scan = new Scanner(System.in);
		int m = 0;
		while(true){
			System.out.println("Enter the desired length of the array");
			m = scan.nextInt();
			int[] result = randomness.chooseRandomlyIterative(array, m);
//			int[] result = randomness.chooseRandomlyRecursively(array, m, NUMBER_ELEMENTS - 1);
			for(int i = 0; i < m; i++){
				System.out.println(result[i]);
			}
			System.out.println("***************");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
