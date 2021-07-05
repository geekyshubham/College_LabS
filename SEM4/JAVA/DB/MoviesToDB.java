
import java.io.*;
import java.sql.*;
 
public class MoviesToDB {
 
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/imdbtopmovies";
        String username = "root";
        String password = "root";
 
        String csvFilePath = "movies.csv";
 
        int batchSize = 20;
 
        Connection connection = null;
 
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
 
            String sql = "INSERT INTO movies (movieid, rating, title, year) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
 
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
 
            int count = 0;
 
            lineReader.readLine(); // skip header line
 
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String movieid = data[0];
                String rating = data[1];
                String title = data[2];
                String year = data[3];
                year.substring(1,year.length());
 
                statement.setString(1, movieid);
 
                Float fRating = Float.parseFloat(rating);
                statement.setFloat(2, fRating);
                
                statement.setString(3, title);

                statement.setString(4, year);
 
                statement.addBatch();
 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
 
            lineReader.close();
 
            // execute the remaining queries
            statement.executeBatch();
 
            connection.commit();
            connection.close();
 
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }
}