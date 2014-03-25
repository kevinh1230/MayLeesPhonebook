import java.util.Scanner;
import java.io.*;

public class editaddress{
	public static void main (String [] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		Scanner in = null;
		String line;
		PrintWriter out = null;
		String number = "none";
		String line1;
		String choice;
		String newnumber, newaddress;
		String deletenumber;
		File addressdata = new File("addresses.txt");
		in = new Scanner(addressdata);
		List list = new List();
		while (in.hasNextLine()){
			if(in.nextLine().equals("===")){
				line = in.nextLine();
				line1 = in.nextLine();
				list.insertBack(line,line1);
			}
		}
		while(!number.equals("Q")){
			System.out.println();
			System.out.println("Enter 'A' to add a new address");
			System.out.println("Enter 'D' to delete an address");
			System.out.println("Enter 'S' to save");
			System.out.println("Enter 'Q' to exit");
			System.out.println();
			choice = scanner.nextLine();
			if (choice.equals("A") || choice.equals("a")){
				System.out.print("Enter the PHONE NUMBER to add: ");
				newnumber = scanner.nextLine();
				list.moveTo(0);
				while (!list.offEnd()){
					if (newnumber.equals(list.getCurrentNumber())){
						System.out.println();
						System.out.println("*****NUMBER ALREADY EXISTS*****");
						break;
					}
					else{
						list.moveNext();
					}
				if(list.offEnd()){
					System.out.print("Enter the ADDRESS to add: ");
					newaddress = scanner.nextLine();
					System.out.println();
					list.insertBack(newnumber,newaddress);
					System.out.println("*****NUMBER SUCCESSFULLY ADDED*****");
					}
				}
			}
			else if (choice.equals("D") || choice.equals("d")){
				System.out.print("Enter the phone number to delete: ");
				deletenumber = scanner.nextLine();
				list.moveTo(0);
				while (!list.offEnd()){
					if (deletenumber.equals(list.getCurrentNumber())){
						list.deleteCurrent();
						System.out.println();
						System.out.println("*****NUMBER SUCCESSFULLY DELETED*****");
						break;
					}
					else{
						list.moveNext();
					}
					if(list.offEnd()){
						System.out.println();
						System.out.println("****NUMBER NOT FOUND*****");
					}
				}
			}
			else if(choice.equals("S") || choice.equals("s")){
				out = new PrintWriter("addresses.txt");
				list.moveTo(0);
				while(!list.offEnd()){
					out.println("===");
					out.println(list.getCurrentNumber());
					out.println(list.getCurrentAddress());
					list.moveNext();
				}
				out.close();
				System.out.println();
				System.out.println("*****SAVE SUCCESSFUL*****");
			}
			else if(choice.equals("Q") || choice.equals("q")){
				return;
			}
			else {
				System.out.println();
				System.out.println("*****NOT A VALID CHOICE*****");
			}
		}
	}
}
