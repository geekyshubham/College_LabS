import java.io.*;
import java.util.Scanner;

public class studentResult extends studentRecord{

    public static void main(String[] args) throws IOException {
        
        String art = extracted();  

		System.out.println(art);
        Scanner records;
        records = new Scanner(new File("D:\\Test\\javaP\\StudentRecords\\input.csv"));
        records.useDelimiter("[,\n]");

        System.out.println("Enter your Gr. No.:");

        String searchID = (System.console().readLine()).toUpperCase(); 
  
        while(records.hasNext()){

            String ID = records.next();
            // System.out.println(records.next());

            if (ID.equals(searchID)){
                // System.out.println("id: " + ID+" searchID: " +searchID);
                //grno,rollno,div,Name,Program,Year,Gender,sub1,sub2,sub3

                studentRecord student = new studentRecord();
                student.grno = searchID;
                student.rollno=Integer.parseInt(records.next());
                student.div=(records.next()).charAt(0);
                student.fname=records.next();
                student.program=records.next();
                student.year=records.next();
                student.gender=records.next();
                student.sub1=Integer.parseInt(records.next());
                student.sub2=Integer.parseInt(records.next());
                student.sub3=Integer.parseInt((records.next()).trim());

                // System.out.println(student.getRollno());
                // System.out.println(student.div);
                // System.out.println(student.getName());
                // System.out.println(student.sub1);
                // System.out.println(student.sub2);
                // System.out.println(student.sub3);
                // System.out.println("Percentage:"+student.getPercent()+"%");
                // System.out.println("Grade:"+student.getGrade());

                student.printRecord();

            }
            
        }
       


     
    }

    private static String extracted() {
        String art =
        "░██████╗████████╗██╗░░░██╗██████╗░███████╗███╗░░██╗████████╗  ██████╗░███████╗░██████╗██╗░░░██╗██╗░░░░░████████╗"+"\n"+
        "██╔════╝╚══██╔══╝██║░░░██║██╔══██╗██╔════╝████╗░██║╚══██╔══╝  ██╔══██╗██╔════╝██╔════╝██║░░░██║██║░░░░░╚══██╔══╝"+"\n"+
        "╚█████╗░░░░██║░░░██║░░░██║██║░░██║█████╗░░██╔██╗██║░░░██║░░░  ██████╔╝█████╗░░╚█████╗░██║░░░██║██║░░░░░░░░██║░░░"+"\n"+
        "░╚═══██╗░░░██║░░░██║░░░██║██║░░██║██╔══╝░░██║╚████║░░░██║░░░  ██╔══██╗██╔══╝░░░╚═══██╗██║░░░██║██║░░░░░░░░██║░░░"+"\n"+
        "██████╔╝░░░██║░░░╚██████╔╝██████╔╝███████╗██║░╚███║░░░██║░░░  ██║░░██║███████╗██████╔╝╚██████╔╝███████╗░░░██║░░░"+"\n"+ "╚═════╝░░░░╚═╝░░░░╚═════╝░╚═════╝░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝░░╚═╝╚══════╝╚═════╝░░╚═════╝░╚══════╝░░░╚═╝░░░"+"\n"+"\n"+  "░██████╗░███████╗███╗░░██╗███████╗██████╗░░█████╗░████████╗░█████╗░██████╗░"+"\n"+       "██╔════╝░██╔════╝████╗░██║██╔════╝██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗"+"\n"+       "██║░░██╗░█████╗░░██╔██╗██║█████╗░░██████╔╝███████║░░░██║░░░██║░░██║██████╔╝"+"\n"+       "██║░░╚██╗██╔══╝░░██║╚████║██╔══╝░░██╔══██╗██╔══██║░░░██║░░░██║░░██║██╔══██╗"+"\n"+       "╚██████╔╝███████╗██║░╚███║███████╗██║░░██║██║░░██║░░░██║░░░╚█████╔╝██║░░██║"+"\n"+
        "░╚═════╝░╚══════╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝"+"\n";
        return art;
    }
}

    
