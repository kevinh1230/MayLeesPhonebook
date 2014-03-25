import java.util.Scanner;
import java.io.*;

public class address {
	public static void main (String [] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		String number = "none"	; //need to initialize number variable
		Scanner in = null;
		String pnumber = null;
		String addr = null;
		File addressdata = new File("addresses.txt"); //create file
		in = new Scanner(addressdata); //pass all data in address test to scanner
		
		//when program is opened new list is created with all data from txt
		List list = new List(); //create a new linked list
		while (in.hasNextLine()){ //while not end of file
			if(in.nextLine().equals("===")){ //if line does not contain ===
				pnumber = in.nextLine(); //put phone number in variable
				addr = in.nextLine(); //put address in variable
				list.insertBack(pnumber,addr); //insert into list
			}
		}
		//"Enter a phone number" loop until quit is entered
		while(!number.equals("quit")){
			System.out.println();
			System.out.print("Enter a phone number: ");
			number = scanner.nextLine(); //entered number is stored as variable number
			list.moveTo(0); //move to beginning of list created 
			while(!list.isEmpty()){ //while list isnt empty
				if(list.offEnd()){ //if list ends address is not found
					System.out.println("*****ADDRESS NOT FOUND*****");
					System.out.println("");
					break;
				}
				else if(number.equals("quit")){ //if user types quit program exits
					break;
				}
				else if(number.equals(list.getCurrentNumber())){ //if number in database and entered number match
					System.out.println();
					System.out.println(list.getCurrentAddress()); //print out address associate with number
					System.out.println(); 
					break;
				}
				else {
					list.moveNext(); //check next node
				}
			}
		}
	}	
}