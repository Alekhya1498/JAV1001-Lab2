/* Student Name: Alekhya Gollamudi
 * Student ID : A00245382
 * Program Description : This program encrypts and decrypts the string given by user,the method accepts the array type
  the average of the array and also reversing of an array is done. Also written a method that searches the given value and
  gives an output whether the value is present in array or not .
 */
import java.util.Arrays;
import java.util.Scanner;

public class Encrypt {

	public static final String alph = "abcdefghijklmnopqrstuvwxyz";
    // static because all other functions are static, and we can't reference from a non static
 
    public static String encoding(String plainT, int shift) {
        plainT = plainT.toLowerCase();
        // converting the text to lowercase
        String cipherT = "";
        // initializing empty string to add alphabets iteratively
        for (int i = 0; i < plainT.length(); i++) {
            int mappingV = alph.indexOf(plainT.charAt(i));
            // value of each alphabet in integers like for A=0, B=1 ...
            int enVal = (shift + mappingV) % 26;
            char Val = alph.charAt(enVal); // the character to be replaced
            cipherT = cipherT + Val; // adding to ciphertext
        }
        return cipherT;
    }
 
    // following same algorithm but in reverse way, plaintext becomes
    // ciphertext and vice versa
    public static String decoding(String cipherT, int shift) {
        cipherT = cipherT.toLowerCase();
        // converting the text to lowercase
        String plainT = "";
        // initializing empty string to add alphabets iteratively
        for (int i = 0; i < cipherT.length(); i++) {
            int mappingV = alph.indexOf(cipherT.charAt(i));
            int deVal = (mappingV - shift) % 26;
            if (deVal < 0) // to handle the negative values
            {
                deVal = alph.length() + deVal;
            }
            char Val = alph.charAt(deVal); // the character to be replaced
            plainT = plainT + Val; // adding to plaintext
        }
        return plainT;
    }
    
    
    
    public static void average(int array[]){
    	double sum = 0;
    	for(int i=0;i<array.length;i++) { //Initializing for loop to add values of array
    		sum = sum+array[i];
    	}
    	double average = sum/array.length; // average of the values is stored in average
    	System.out.println(array.length);
    	System.out.println("Average of array is " +average); 	
    }
    
    
    public static void identify(int array[],int num) {
    	boolean v=false;
    	for(int i=0;i<array.length;i++) { // identifying the value is present in array or not
    		if(num==array[i]) {
    			v=true;
    		}
    		else {
    			v=false;
    		}
    		
    	}
    	if(v=true) {
    		System.out.println("The array contains "+num);
    	}
    	else {
    		 System.out.println("\n");
    		System.out.println("The array does not contain "+num);
    	}
    	
    }
    
    
    public static void reverse(int array[]) {
    	 System.out.println("\n");
    	System.out.println("The reversed array is ");
    	System.out.print("[ ");
    	for(int i=array.length-1;i>=0;i--) { // reversing the given array
    		System.out.print(array[i]+ " ");
    	}
    	System.out.println("]");
    }
    
    
    
    
 
    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        int array[]= {12,13,14,15,16,17};
        int num;
        System.out.println("Enter the text message to be encrypted ");
        String msg;
        msg = scan.next(); // input given by user is stored into msg
        System.out.println("Enter a value to encrypt with" );
        int shift;
        shift = scan.nextInt(); // the value to encrypt is taken
        String encmsg = encoding(msg, shift); //calling the encoding method
        System.out.println("Encrypted Text : " + encmsg);
        
        System.out.print("Decrypted Text : ");
        System.out.print(decoding(encmsg, shift)); //calling the decrypted method
        
        System.out.println("\n");
        System.out.println("\nThe array is " +(Arrays.toString(array)));
        average(array);  // calling the average method
        System.out.println("\n");
        System.out.println("Enter a value to search for ");
        num = scan.nextInt();
        identify(array, num); // calling the identify method
        reverse(array);    // calling the average method
        scan.close();   // closing the scanner class
        
    }
}
