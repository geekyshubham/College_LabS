import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import wagu.Block;
import wagu.Board;
import wagu.Table;

public class studentRecord{
    
    int rollno;
    String grno;
    String fname;
    String program;
    String year;
    String gender;
    int sub1;
    int sub2;
    int sub3;
    int total;
    float percent;
    char grade;
    char div;
    String result;

    public int getTotal(){
        total = sub1+sub2+sub3;
        return total;
    }

    public float getPercent() {
        percent = total/3;
        return percent;
    }

    public String getName(){
        return fname;
    }

    public String getProgram(){
        return program;
    }

    public String getYear(){
        return year;
    }

    public String getGender(){
        return gender;
    }

    public int getRollno(){
        return rollno;
    }

    public String getGrno(){
        return grno;
    }

    public char getGrade(){
        if ( percent > 0 )
            result = "PASS";
            if ( percent > 90){
                grade = 'A';
            }
            else if ( percent > 80){
                grade = 'B';
            }
            else if ( percent > 70){
                grade = 'C';
            }
            else if ( percent > 60){
                grade = 'D';
            }
            else if ( percent > 50){
                grade = 'E';
            }
            else{
                result = "FAIL";
                grade = 'F';
            }
            return grade;
        } 

        public void displayTable(List<List<String>> records){

            List<Integer> colAlignList = Arrays.asList(
                           Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER,
                    Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER,
                    Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER);

            List<String> headersList = Arrays.asList("Gr. No.", "Roll No.", "Division", "Name", "Dept.","Year","Gender","SUB1","SUB2","SUB3","Total","Percentage","Grade","Result");
            List<List<String>> rowsList =records;

            Board board = new Board(135);
            Table table = new Table(board, 135, headersList, rowsList);
            Block tableBlock = table.tableToBlocks();
            List<Integer> colWidthsListEdited = Arrays.asList(10, 10, 10, 30, 20,5,5,5,5,5,5,10,5,6);
            table.setGridMode(Table.GRID_FULL).setColWidthsList(colWidthsListEdited);   
            table.setColAlignsList(colAlignList);
            board.setInitialBlock(tableBlock);
            board.build();
            String tableString = board.getPreview();
            System.out.println(tableString);

        }

        public void classRecord(){
            String fileName ="classReport.csv";
            printToFile(fileName,writeRecord(),true);
        }


        public String writeRecord(){

            return grno+","+rollno+","+div+","+fname+","+program+","+year+","+gender+","+sub1+","+sub2+","+sub3+","+getTotal()+","+getPercent()+","+getGrade()+","+result+"\n";

        }




        public void printToFile(String fileName,String str,boolean mode){
            try{
            File file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file,mode);
            writer.write(str);
            writer.close();
            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        
        }





        public void printRecord(){

            List<Integer> colAlign= Arrays.asList(
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER,
                    Block.DATA_CENTER
                    );

            String college = ""
                + "VIT PUNE\n"
                + " \n"
                + "STUDENT RESULT\n"
                + " \n";

                List<String> t1Headers = Arrays.asList("STUDENT GR. NO. ", grno);
                List<List<String>> t1Rows = Arrays.asList(Arrays.asList("STUDENT NAME ",fname));

                String t2Desc = "-----| SUBJECT MARKS |-----";
                List<String> t2Headers = Arrays.asList("SUB1", "SUB2", "SUB3");
                List<List<String>> t2Rows = Arrays.asList(
                Arrays.asList(Integer.toString(sub1), Integer.toString(sub2), Integer.toString(sub3)));
                
                String t3Desc = " ";
                List<String> t3Headers = Arrays.asList("TOTAL MARKS","PERCENTAGE","GRADE");
                List<List<String>> t3Rows = Arrays.asList(Arrays.asList(Integer.toString(getTotal()),Float.toString(getPercent())+"%",Character.toString(getGrade())));

                Board board = new Board(75);
                Block title = new Block(board, 56, 7, college).allowGrid(false).setBlockAlign(Block.BLOCK_CENTRE).setDataAlign(Block.DATA_CENTER);
                board.setInitialBlock(title);

                board.appendTableTo(0,Board.APPEND_BELOW,new Table(board,75,t1Headers,t1Rows));
              
                board.getBlock(3).setBelowBlock(new Block(board, 73, 1, t2Desc).setDataAlign(Block.DATA_CENTER));
                board.appendTableTo(5, Board.APPEND_BELOW, new Table(board, 75, t2Headers, t2Rows).setColAlignsList(colAlign));

                
                board.getBlock(9).setBelowBlock(new Block(board, 73, 1, t3Desc).setDataAlign(Block.DATA_CENTER));
                board.appendTableTo(12, Board.APPEND_BELOW, new Table(board, 75, t3Headers, t3Rows).setColAlignsList(colAlign));
                
            // b.showBlockIndex(true);
                
            //     System.out.println(b.invalidate().build().getPreview());
            board.build();
            String tableString = board.getPreview();
            System.out.println(tableString);

            String fileName = grno +".txt";
            
            //Printing to file
            printToFile(fileName,tableString,false);
        }
    }
    
    

