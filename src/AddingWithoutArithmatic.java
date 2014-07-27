/**
 * 
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class AddingWithoutArithmatic {

	public int sumWithoutOperators(int a, int b){
		if(b == 0)
			return a;
		int xor = a ^ b;
		int shiftedAnd = (a & b) << 1;
		return sumWithoutOperators(xor, shiftedAnd);
	}
	
	public static void main(String[] args) {
		
	}
}
