import java.util.Scanner;
class multiTables extends Thread{
	int x;
	multiTables(int num){
		x=num;
	}
	public void run(){
		printTable(x);
	}	
	synchronized public void printTable(int x){
		for(int i=1;i<=10;i++){
		System.out.println(x+"x"+i+"="+x*i);
		}
		
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Table to print");
		int num1 = sc.nextInt();
		System.out.println("Enter Second Table to print:");
		int num2 = sc.nextInt();
		sc.close();
		multiTables t1 =new multiTables(num1);
	        multiTables t2 =new multiTables(num2);	
		t1.start();
		try{  
			  t1.join();  
			   }catch(Exception e){System.out.println(e);}  
		t2.start();
	}

}
