package utilities;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    //methods static so we can call only with class name
    // establishConnection() -> we will automatically connect to database
    // runSQLQuery(String query) -> return listOfMaps
    // closeDatabase()
    // countRows(String query) -> will return int


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    // this method establishing connection with Oracle SQL Database

    public static void establishConnection() throws IOException, SQLException {
        connection = DriverManager.getConnection(
                Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * This method will run query to Database and will return the data as List of Maps
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public static List<Map<String, Object>> runSQLQuery(String query) throws SQLException {

        resultSet = statement.executeQuery(query);
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        List<Map<String, Object>> listOfMaps = new ArrayList<>();

        int columnCount = rsMetadata.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsMetadata.getColumnName(i);
                Object columnValue = resultSet.getObject(columnName);
                row.put(columnName, columnValue);
            }
            listOfMaps.add(row);
        }
        return listOfMaps;

    }

    /**
     * this method will execute query and return number of rows
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public static int countRows(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        resultSet.last();
        return resultSet.getRow(); // number of rows

    }

    /**
     * this methos will close Database, statement, resultSet
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {

        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
