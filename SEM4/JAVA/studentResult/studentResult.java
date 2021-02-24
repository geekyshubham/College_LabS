import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class studentResult extends studentRecord{

    public static void main(String[] args) throws IOException {
        
        String art = extracted();  

		System.out.println(art);
        Scanner records;
        
        int input;
        
        
        do{
            System.out.println("Enter appropriate option:\n(1) For Student Result \n(2) For Class Result [CSV File]\n(3) EXIT");
            input = Integer.parseInt(System.console().readLine());

        switch (input) {
            
            case 1:
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
                break;
            case 2:
            records = new Scanner(new File("D:\\Test\\javaP\\StudentRecords\\input.csv"));
            records.useDelimiter("[,\n]");
            records.nextLine();
            studentRecord student = new studentRecord();
            String header = "Gr. No., Roll No., Division, Name, Dept.,Year,Gender,SUB1,SUB2,SUB3,Total,Percentage,Grade,Result\n";
            student.printToFile("classReport.csv",header, false);
            while(records.hasNext()){
                    records.next();
                    
                    student.grno = records.next();
                    student.rollno=Integer.parseInt(records.next());
                    student.div=(records.next()).charAt(0);
                    student.fname=records.next();
                    student.program=records.next();
                    student.year=records.next();
                    student.gender=records.next();
                    student.sub1=Integer.parseInt(records.next());
                    student.sub2=Integer.parseInt(records.next());
                    student.sub3=Integer.parseInt((records.next()).trim());

                    List<List<String>> record = Arrays.asList(
                        Arrays.asList(student.grno,Integer.toString(student.rollno), Character.toString(student.div), student.fname, student.program,student.year,student.gender,Integer.toString(student.sub1), Integer.toString(student.sub2), Integer.toString(student.sub3),Integer.toString(student.getTotal()),Float.toString(student.getPercent()),Character.toString(student.getGrade()),student.result));

                    student.displayTable(record);
                    
                    student.classRecord();

                }
            

            break;
            case 3:
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            break;
            default:
                System.out.println("\033[4A\033[K");
                System.out.println("*Please enter appropriate option.");
                break;
        }
    }while(input != 3);
        
       


     
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

    
