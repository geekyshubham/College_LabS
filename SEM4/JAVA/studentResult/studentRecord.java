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
    float percent;
    char grade;
    char div;
    String result;

    public float getPercent() {
        percent = (sub1+sub2+sub3)/3;
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

        public String writeRecord(){
            return grno+","+rollno+","+div+","+fname+","+program+","+year+","+gender+","+sub1+","+sub2+","+sub3+","+percent+","+grade+","+result;
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
                List<List<String>> t3Rows = Arrays.asList(Arrays.asList(Integer.toString(sub1+sub2+ sub3),Float.toString(getPercent())+"%",Character.toString(getGrade())));

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

            //Printing to file
            try{
            File file = new File(grno+".txt");
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(tableString);
            writer.close();
            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    

