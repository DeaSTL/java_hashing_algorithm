package test_project;

public class Main {
	
	public static void main(String[] args) {
		
		easyhash hash = new easyhash("password","SHA-256");
		System.out.println(hash.getHex());
		

	}

}
