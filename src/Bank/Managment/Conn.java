package Bank.Managment;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {

            c=DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem","root","memk200y");
            s=c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
