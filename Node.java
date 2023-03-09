
public class Node {
	public String countryName;
	public double gdpPC; 
	public Node leftChild;
	public Node rightChild;
	
	
	public static void printMethod() {	
		System.out.printf("%-35s %s\n", "Country Name", "GDP Per Capita");
		System.out.println("---------------------------------------------------");
	}
	
}