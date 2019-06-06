import java.sql.*;

import com.ibm.as400.access.AS400;

public class as400call
{
  public static void main(String args[])
  {
    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:as400://AS001A.sysco.com","PSRYA000","sysco1010");
      PreparedStatement statement = connection.prepareStatement("SELECT B6ORST,B60RNO FROM SCDBFP10.OPNJB6PF WHERE B6CUNO=?', [772293]");

      ResultSet resultSet = statement.executeQuery();

      while(resultSet.next())
      {
        System.out.println(resultSet.getObject(1));
      }
    }
    catch(SQLException e)
    {
      throw new RuntimeException(e);
    }
    finally
    {
      try{ if(connection!=null) connection.close(); }
      catch(SQLException e)
      {
        throw new RuntimeException(e);
      }
    }

  }
}@
$ javac as400call.java
$ java -cp jtopen_5_0/lib/jt400.jar:. -Djdbc.drivers=com.ibm.as400.access.AS400JDBCDriver As400Jdbc
19138