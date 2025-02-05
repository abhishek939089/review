import java.util.Scanner;
public class removeDuplicate{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = sc.nextLine();
		String newString = duplicate(str);
		System.out.println("String without duplicate: " + newString);
	}
	public static String duplicate(String str){
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
            if (newString.indexOf(str.charAt(i)) == -1) {
                newString += str.charAt(i);
            }
        }
        return newString;
	}
}