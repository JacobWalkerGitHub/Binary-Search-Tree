import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* COP 3530: Project 2 – Binary Search Trees
* <p>
* Project2 class will scan in all values of the file
* <p>
* it will then take the countries name and calculate the GDP Per Capita and insert it into a binary tree
* <p>
* after, it will constantly ask the user to select their desired out put and call the traverse method
* <p>
*
* @author Jacob Walker
* @version <06/12/2022>
*/

public class Project2 {

	public static void main(String[] args) {
		
		BinarySearchTree Tree = new BinarySearchTree();
		System.out.print("Enter file name: ");
		Scanner fn = new Scanner(System.in);
		String fileName = fn.nextLine();
		Scanner inFile = null;
		
		double[] arrGdpPc = new double[146];
		String[] arrName = new String[146];
		int a = 0;
		
		try {
			inFile = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not find file.");
			System.exit(1);
		}
		
		inFile.useDelimiter(",|\r\n");
		for(int i = 0; i < 7; i++)//gets rid of headers in csv file
			inFile.next();
		
		String countryName;
		while(inFile.hasNext()) {
			countryName = inFile.next();
			inFile.next();
			double pop = inFile.nextDouble();
			double gdp = inFile.nextDouble();

			
			inFile.next();
			inFile.next();
			inFile.next();
			
			double gdppc = gdp/pop;
			
			arrGdpPc[a] = gdppc;
			arrName[a] = countryName;
			a++;
			
			Tree.insert(countryName, gdppc);
		}
		
		Scanner opt = new Scanner(System.in);
		
		
			System.out.print("1) Print tree inorder. \n2) Print tree preorder. \n3) Print tree postorder. \n4) Insert a country with name and GDP per capita. \n5) Delete a country for a given name.\n6) Search and print a country and its path for a given name. \n7) Print bottom countries regarding GDPPC. \n8) Print top countries regarding GDPPC. \n9) Exit.\nEnter your choice: ");
			int option = opt.nextInt();
			while(true) {
				
				if(option >= 1 && option <= 9) {
					
					
					switch(option) {
					case 1 : 
						Tree.traverse(1, arrName, arrGdpPc);
						break;
					case 2 :
						Tree.traverse(2, arrName, arrGdpPc);
						break;
					case 3 :
						Tree.traverse(3, arrName, arrGdpPc);
						break;
					case 4 : 
						Tree.traverse(4, arrName, arrGdpPc);
						break;
					case 5 : 
						Tree.traverse(5, arrName, arrGdpPc);
						break;
					case 6 : 
						Tree.traverse(6, arrName, arrGdpPc);
						break;
					case 7 : 
						Tree.traverse(7, arrName, arrGdpPc);
						break;
					case 8 :
						Tree.traverse(8, arrName, arrGdpPc);
						break;
					case 9: 
						System.out.print("\nGood-bye. Please come again");
						return;
					}
					System.out.print("1) Print tree inorder. \n2) Print tree preorder. \n3) Print tree postorder. \n4) Insert a country with name and GDP per capita. \n5) Delete a country for a given name.\n6) Search and print a country and its path for a given name. \n7) Print bottom countries regarding GDPPC. \n8) Print top countries regarding GDPPC. \n9) Exit.\nEnter your choice: ");
					option = opt.nextInt();
				}
				else {
					try {
						if(option < 1 || option > 9 || option != 0) {	
							System.out.println("Enter a number 1 - 9: ");
						
						}
					}
					catch(InputMismatchException e) {
						System.out.println("Enter a number 1 - 9: ");
					}
					option = opt.nextInt();
					}
				
				}
		}
}
