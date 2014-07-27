/**
 * Here is a perfect shuffle of cards/or number.
 * NOTE: this assumes that the random function that we are using in the random method is perfect.
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class PerfectShuffle {

	int random(int low, int high){
		return low + (int)(Math.random()*(high - low + 1));
	}
	/*
	 * You see what I did with the method name here. :P ;)
	 */
	public int[] iShuffleRecursive(int[] array, int i){
		if(i == 0)
			return array;
		//shuffled the array 
		iShuffleRecursive(array, i - 1);
		int swapIndex = random(0, i);
		int temp = array[i];
		array[i] = array[swapIndex];
		array[swapIndex] = temp;
		return array;		
	}
	
	public int[] iShuffleIterative(int[] array){
		int k = 0;
		int temp = 0;
		for(int i = 0; i < array.length; i++){
			k = (int)Math.random()*(array.length);
			temp = array[k];
			array[k] = array[i];
			array[i] = temp;
		}
		
		return array;
			
	}

	public static void main(String[] args) {
		final int NUMBER_ELEMENTS = 10;
		PerfectShuffle shuffle = new PerfectShuffle();
		int[] array = new int[NUMBER_ELEMENTS];
		for(int i = 0; i < NUMBER_ELEMENTS; i++){
			array[i] = i;
		}
		while(true){
			shuffle.iShuffleRecursive(array, NUMBER_ELEMENTS-1);
			shuffle.iShuffleIterative(array);
			for(int i = 0; i < NUMBER_ELEMENTS; i++){
				System.out.println(array[i]);
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
