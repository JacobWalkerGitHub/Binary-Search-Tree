
import java.util.Scanner;
/**
* BinarySearchTree.Java will supply the user with all the algorithms and data structures to perform the desired output
*
* @author Jacob Walker
* @version <06/12/2022>
*/
public class BinarySearchTree {
	
	private static Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	/**
	* 
	* @param name - holds the countries name
	* @param GDPPC - hold the GDP Per Capita
	*/
	public void insert(String name, double GDPPC) {
		Node newNode = new Node();
			newNode.countryName = name;
			newNode.gdpPC = GDPPC;
		
		if(root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(name.compareTo(current.countryName) < 0) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						
					//System.out.println(newNode);
						return;
					}
				}
			}
		}
	}
	
	/**
	* 
	* @param root - supplies a already set Node to every method
	* @param name - holds the countries name
	* @param namePath[] - will assign localroot.countryName to namePath[i] 
	* @param localRoot - helps move through out the binary tree
	* @return -1 - will return -1 if country does not exist on tree
	* @return localRoot.GdpgdpPc - will return the given countries GDP Per capita if found
	*/
	public double find(Node localRoot, String name, String[] namePath) {
		int i = 0;
		while(!name.equals(localRoot.countryName)) {
			if(name.compareTo(localRoot.countryName) > 0) {
				namePath[i] = localRoot.countryName;
				i++;
				localRoot = localRoot.rightChild;
				
			}
			else {
				namePath[i] = localRoot.countryName;
				i++;
				localRoot = localRoot.leftChild;
				
			}
			if(localRoot == null)	{
				return -1;
			}
		}
		return localRoot.gdpPC;
	} 
 	
	/**
	* 
	* @param name - holds the countries name
	* @param localRoot - helps move through out the binary tree
	*/
	public void delete(Node localRoot, String name) {
		while(!name.equals(localRoot.countryName)) {
			if(name.compareTo(localRoot.countryName) > 0) {
				localRoot = localRoot.rightChild;
			}
			else {
				localRoot = localRoot.leftChild;
			}
		}
		localRoot.countryName = " ";
		localRoot.gdpPC = 0;
	}
	/**
	* @param localRoot - helps move through out the binary tree
	*/
	public void printInorder(Node localRoot) {
		if(localRoot != null) {
			printInorder(localRoot.leftChild);
			System.out.printf("%-35s %s\n", localRoot.countryName, String.format("%.3f", localRoot.gdpPC));
			printInorder(localRoot.rightChild);	
		}
	}
	/**
	* @param localRoot - helps move through out the binary tree
	*/
	public void printPreorder(Node localRoot) {
		if(localRoot != null) {
			System.out.printf("%-35s %s\n", localRoot.countryName, String.format("%.3f", localRoot.gdpPC));
			printPreorder(localRoot.leftChild);
			printPreorder(localRoot.rightChild);
		}
		
	}
	/**
	* @param localRoot - helps move through out the binary tree
	*/
	public void printPostorder(Node localRoot) {
		if(localRoot != null) {
			printPostorder(localRoot.leftChild);
			printPostorder(localRoot.rightChild);
			System.out.printf("%-35s %s\n", localRoot.countryName, String.format("%.3f", localRoot.gdpPC));
		}
		
	}
	/**
	* @param localRoot - helps move through out the binary tree
	* @param arrName[] - creates an array with the countries that have the lowest GDPPC
	* @param arrGdpPc[] - creates an array to hold the lowest GDPPC
	* @param minName - temporarily hold the name of the country 
	* @param tempGdp - holds the value of 0
	* @param minGdp - temporarily holds lowest GDPPC value
	*/
	public void printBottomCountries(Node localRoot, int c, String[] arrName, double[] arrGdpPc) {
		
		String minName = arrName[0];
		
		boolean border = true;

		int n = 0;
		double tempGdp = 0;
		for(int k = 0; k < c; k++) {
			double minGdp = 10000000;
			int i = 0;
			while(i < 145) {
				
				if(arrGdpPc[i] < minGdp && arrGdpPc[i] > tempGdp) {
					minGdp = arrGdpPc[i];
					minName = arrName[i];
					n = i;
				}
				i++;
			}
			tempGdp = minGdp;
			String tempName = minName;
			
			arrGdpPc[n] = arrGdpPc[k];
			arrGdpPc[k] = tempGdp;
			
			arrName[n] = arrName[k];
			arrName[k] = tempName;
			
			while(border == true) {
				Node.printMethod();
				border = false;
			}

			System.out.printf("%-35s %s\n", arrName[k], String.format("%.3f", arrGdpPc[k]));
		}
			
		}	
	
	/**
	* @param localRoot - helps move through out the binary tree
	* @param arrName[] - creates an array with the countries that have the highest GDPPC
	* @param arrGdpPc[] - creates an array to hold the highest GDPPC
	* @param maxName - temporarily hold the name of the country 
	* @param tempGdp - holds the value of 100000000
	* @param maxGdp - temporarily holds highest GDPPC value
	*/
	public void printTopCountries(Node localRoot, int c, String[] arrName, double[] arrGdpPc) {
		String maxName = arrName[0];
		
		boolean border = true;

		int n = 0;
		double tempGdp = 100000000;
		for(int k = 0; k < c; k++) {
			double maxGdp = 0;
			int i = 0;
			while(i < 145) {
				
				if(arrGdpPc[i] > maxGdp && arrGdpPc[i] < tempGdp) {
					maxGdp = arrGdpPc[i];
					maxName = arrName[i];
					n = i;
				}
				i++;
			}
			tempGdp = maxGdp;
			String tempName = maxName;
			
			arrGdpPc[n] = arrGdpPc[k];
			arrGdpPc[k] = tempGdp;
			
			arrName[n] = arrName[k];
			arrName[k] = tempName;
			
			while(border == true) {
				Node.printMethod();
				border = false;
			}

			System.out.printf("%-35s %s\n", arrName[k], String.format("%.3f", arrGdpPc[k]));
		}
	}
	
	/*
	 * traverse method calls specific method depending on what the user inputs
	 */
	public void traverse(int traverseType, String[] arrName, double[] arrGdpPc) {
	
		switch(traverseType) {
			case 1 : 
				System.out.print("\nInorder traversal: \n");
				Node.printMethod();
				printInorder(root);
				
				break;
				
				
			case 2: 
				System.out.print("\nPreorder traversal: \n");
				Node.printMethod();
				printPreorder(root);
				
				break;
				
				
			case 3 :
				System.out.print("\nPostorder traversal: ");
				Node.printMethod();
				printPostorder(root);
				
				break;
				
				
			case 4 :
				System.out.print("\n" + "Enter a new countries name: ");
					Scanner newCn = new Scanner(System.in);
					String cName = newCn.next();
				
				System.out.print("Enter new country GDP Per Capita: ");
					Scanner newCgdppc = new Scanner(System.in);
					double nGDPPC = newCgdppc.nextDouble();
					
				
				insert(cName, nGDPPC);
				
				System.out.println();
				
				break;
				
				
			case 5 :
				System.out.print("\nEnter country's name you wish to delete: ");
					Scanner dn = new Scanner(System.in);
					String delName = dn.next();
					
				delete(root, delName);
				System.out.println("\n" + delName + " has been delted.\n");
				
				break;
				
				
			case 6 :
				
				String[] namePath = new String[145];
				System.out.println("Enter country name: ");
					Scanner cn = new Scanner(System.in);
					String countryN = cn.next();
					double gdppc = find(root, countryN, namePath);
				
				if(gdppc == -1)
					System.out.println("\n" + countryN + " was not found.");
				else {
					System.out.println("\n" + countryN + " is found with GDP Per Capita of " + String.format("%.3f", gdppc));
					int i = 0;
					while(namePath[i] != null) {
						System.out.print(namePath[i]);
						if(namePath[i] != null)
							System.out.print(" -> ");
							
						i++;
					}
					System.out.println(countryN + "\n");
				}
					
				break;
				
			case 7 :
				Scanner ncmin = new Scanner(System.in);
				System.out.print("Enter number of countries: ");
				int c = ncmin.nextInt();
				printBottomCountries(root, c, arrName, arrGdpPc);
				
				break;
				
				
			case 8 :
				Scanner ncmax = new Scanner(System.in);
				System.out.print("Enter number of countries: ");
				int v = ncmax.nextInt();
				printTopCountries(root, v, arrName, arrGdpPc);
				
				break;
				
		}
	}

}
