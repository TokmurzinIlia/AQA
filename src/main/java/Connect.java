import org.jooq.impl.DSL;

import java.sql.*;

public class Connect {
    private static final String host = "localhost";
    private static final String DBName = "sakila";
    private static final String url = "jdbc:mysql://" + host + ":3306/" + DBName;
    private static final String user = "root";
    private static final String password = "ASDSD123asdsd";

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static Connection connectToDB() {

            // открытие коннекта к MySQL server
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return con;
    }

    public static void closeConnection() {
        if (con != null) {

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        if (stmt != null) {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (rs != null) {

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

        public static void createTable(String query) {
            try {
                stmt = connectToDB().prepareStatement(query);

                stmt.executeUpdate(query);

            } catch (SQLException se) {

            }
        }

    public static void dropTable(String tableName) {
        String query = "DROP TABLE " + tableName;
        try {
            stmt = connectToDB().prepareStatement(query);

            stmt.executeUpdate(query);

        } catch (SQLException se) {

        }
    }

    public static ResultSet selectFromTable(String query) {
        try {
            stmt = connectToDB().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stmt.executeQuery(query);
            //перемещение курсора к следующемей строке значений, удовлетворяющих запросу
            rs.next();
            //логирование результатов запроса

        } catch (SQLException se) {

        }
        return rs;
    }

    //метод необязательный, приведен в качестве примера
    //логирование результатов запроса
    private static void addSQLRequestResultsToLog(String query) {
        StringBuilder builder = new StringBuilder();
        DSL.using(connectToDB()).fetchStream(query)
                .forEach(r -> builder.append(r.format()));

    }

    public static void insertIntoTable(String query) {
        try {
            stmt = connectToDB().createStatement();

            stmt.executeUpdate(query);

        } catch (SQLException se) {

        }
    }

    public static void updateInTable(String query) {
        try {
            stmt = connectToDB().createStatement();

            stmt.executeUpdate(query);

        } catch (SQLException se) {

        }
    }

    public static void deleteFromTable(String query) {
        try {

            stmt = connectToDB().createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException se) {

        }
    }

}



