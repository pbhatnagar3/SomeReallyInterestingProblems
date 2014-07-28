/**
 * Some really interesting partitioning and the ranking algorithm and all of it in linear time
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
//finds the median or the nth order element in a array
public class RankFinder {
/*
 * So the partition method takes in one of elements of the array as the input in variable pivot. 
 * And then it manipulates the array and returns the index of the last element of left partition.
 * There is no guarantee that the pivot will be in the appropriate middle. 
 * OUTPUT : This is the only thing that is required to make partition work. This is the index of the last element in the left 
 * partition.
 */
	public int partition(int[] array, int left, int right, int pivot){
		//we are assuming that there is a value of a pivot already there
		while(left <= right){
			while(array[left] < pivot)
				left++;
			while(array[right] > pivot)
				right--;
			if(left <= right){
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left - 1; 
	}

	public int max(int[] array, int start, int end){
		int max = 0;
		for(int i = start; i <= end; i++){
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}

	public void printArray(int[] array, int left, int right){
		for(int i = left; i <= right; i++){
			System.out.print(array[i] + " -->");
		}
	}

	public int rankFinder(int[] array, int left, int right, int rank){
		int pivot = array[left + (int)(Math.random() * (right - left + 1))];
		System.out.println("\n here is the original array");
		printArray(array, left, right);
		int leftEnd = partition(array, left, right, pivot);
		System.out.println("\nthe partition is " + pivot + " function returned value is "+ leftEnd + " resulting array is ");
		printArray(array, left, right);
		int leftSize = leftEnd - left + 1;
		if(leftSize == rank + 1){
			return max(array, left, leftEnd);
		}
		else if(leftSize > rank){
			return rankFinder(array, left, leftEnd, rank);
		}
		else{
			return rankFinder(array, leftEnd + 1, right, rank - leftSize);
		}
	}
	public void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	public int[] quickSort(int[] array, int left, int right){
		int pivot = array[left + (int)(Math.random() * (right - left + 1))];
		int index = partition(array, left, right, pivot);
		if(left < index - 1){
			quickSort(array, left, index -1);
		}
		if(right > index){
			quickSort(array, index, right);
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = {14, 12, 16,13, 11};
		RankFinder find = new RankFinder();
		int rank = 2;
		System.out.println("\nWe are trying to find the following rank " + rank);
		System.out.println("\nhere is the ranks answer" + find.rankFinder(array, 0, array.length - 1, rank));
		find.quickSort(array, 0, array.length - 1);
		System.out.println("Here is the sorted array");
		for(int i = 0; i < array.length; i++ ){
			System.out.println(array[i]);
		}
	}
}
