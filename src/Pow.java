import java.util.Scanner;

/**
 * Testing one of the methods that is used in Cryptography for finding the very large powers. Super cool.
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU :D
 */
public class Pow {
	
	public static int pow(int base, int exp){
		int result = 1;
		while(exp > 0){
			if((exp & 1) == 1)
				result *= base;
			exp >>= 1;
			base *= base;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value of the base");
		int base = scan.nextInt();
		System.out.println("enter the value of the exponent");
		int exponent = scan.nextInt();
		System.out.println("here is the answer to the computation, my lord, " + pow(base, exponent));
	}

}
