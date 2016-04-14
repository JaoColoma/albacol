import Classes.Account;
import com.ibm.db2.jcc.DB2SimpleDataSource;

import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.parser.ParseException;

import java.sql.Date;


public class DBHelper {

    private static final long serialVersionUID = 1L;
    
    private String databaseHost = "localhost";
    private long port = 50000;
    private String databaseName = "mydb";
    private String user = "myuser";
    private String password = "mypass";
    private String url = "myurl";
    private Connection con;
    PrintWriter writer;
    private final boolean statusVCAP;

    public DBHelper(PrintWriter writer) throws ParseException {
        this.writer = writer;
        this.statusVCAP = processVCAP();
        getConnection();
        createTable();

        
    }

    private boolean processVCAP() throws ParseException {
        
        Map<String, String> env = System.getenv();
        if (env.containsKey("VCAP_SERVICES")) {
            
            JSONParser parser = new JSONParser();
            JSONObject vcap = (JSONObject) parser.parse(env.get("VCAP_SERVICES"));
            JSONObject service = null;
            writer.println("Searching through VCAP keys");
            for (Object key : vcap.keySet()) {
                String keyStr = (String) key;
                if (keyStr.toLowerCase().contains("sqldb")) {
                    service = (JSONObject) ((JSONArray) vcap.get(keyStr)).get(0);
                    break;
                }
            }
            if (service != null) {
                JSONObject creds = (JSONObject) service.get("credentials");
                databaseHost = (String) creds.get("host");
                databaseName = (String) creds.get("db");
                port = (long) creds.get("port");
                user = (String) creds.get("username");
                password = (String) creds.get("password");
                url = (String) creds.get("jdbcurl");
            } else {
                writer.println("VCAP_SERVICES is null");
                return false;
            }
            writer.println("database host: " + databaseHost);
            writer.println("database port: " + port);
            writer.println("database name: " + databaseName);
            writer.println("username: " + user);
            writer.println("password: " + password);
            writer.println("url: " + url);
            return true;
        }
        return false;
    }

    private void getConnection() {
        
        if (statusVCAP) {
            
            try {
                writer.println();
                writer.println("Connecting to the database");
                DB2SimpleDataSource dataSource = new DB2SimpleDataSource();
                dataSource.setServerName(databaseHost);
                dataSource.setPortNumber((int) port);
                dataSource.setDatabaseName(databaseName);
                dataSource.setUser(user);
                dataSource.setPassword(password);
                dataSource.setDriverType(4);
                writer.println();
                this.con = dataSource.getConnection();
                if (con == null) {
                    System.out.println("con is null");
                    writer.println("con is null");
                }
            } catch (SQLException e) {
                writer.println("Error connecting to database");
                writer.println("SQL Exception: " + e);
                this.con = null;
            }
        }
    }

    
    Statement stmt = null;
    String tableName = "Account";
    String sqlStatement = "";

   
    private void createTable() {
        
        if (con != null) {
            try {
                stmt = con.createStatement();

                sqlStatement = "CREATE TABLE " + tableName
                        + " (votersID integer GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), lastname VARCHAR(20), firstname VARCHAR(20), middlename VARCHAR(20), "
						+" birthday DATE, address VARCHAR(20),  nationality VARCHAR(20), gender VARCHAR(20), "
						+" status VARCHAR(20), number VARCHAR(20), PRIMARY KEY (votersID))";
                writer.println("Executing: " + sqlStatement);
                stmt.executeUpdate(sqlStatement);
            } catch (SQLException e) {
                writer.println("Error creating table: " + e);
            }
        }

    }

    public String insertInto(Account bean) {
        if (con != null) {
            try {
                sqlStatement = "INSERT INTO " + tableName
                        + " (lastname, firstname, middlename, birthday, address, nationality, gender, status, number) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(sqlStatement);
                preparedStatement.setString(1, bean.getLastname());
                preparedStatement.setString(2, bean.getFirstname());
                preparedStatement.setString(3, bean.getMiddlename());
                preparedStatement.setDate(4, bean.getBirthday());
                preparedStatement.setString(5, bean.getAddress());
                preparedStatement.setString(6, bean.getNationality());
                preparedStatement.setString(7, bean.getGender());
                preparedStatement.setString(8, bean.getStatus());
                preparedStatement.setString(9, bean.getNumber());

                writer.println("Executing: " + sqlStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                writer.println("Error " + e);
            }
            return "none";

        }
        return null;
    }

    public Account selectUser(String votersID) {
        try {
            sqlStatement = "SELECT * FROM " + tableName + " where votersID=" + votersID;
			Account a = new Account();
	        ResultSet rs = stmt.executeQuery(sqlStatement);
            writer.println("Executing: " + sqlStatement);
            while (rs.next()) {
  				
                a.setLastname(rs.getString("lastname"));
				a.setFirstname(rs.getString("firstname"));
                a.setMiddlename(rs.getString("middlename"));
                    
				a.setBirthday(rs.getDate("birthday"));
                a.setAddress(rs.getString("address"));
                a.setNationality(rs.getString("nationality"));
                a.setStatus(rs.getString("status"));

				a.setGender(rs.getString("gender"));
					
                a.setNumber(rs.getString("number"));
					
				a.setVotersID(String.valueOf(rs.getInt("votersID")));
            }
                return a;
        } catch (SQLException e) {
            writer.println("Error " + e);
            return null;
        }
    }

    public ArrayList<Account> getAllAccount() {
        if (con != null) {
            try {
                sqlStatement = "SELECT * FROM " + tableName;
                ArrayList<Account> beans = new ArrayList<>();
                ResultSet rs = stmt.executeQuery(sqlStatement);
                writer.println("Executing: " + sqlStatement);
                while (rs.next()) {
                    Account a = new Account();
                    a.setLastname(rs.getString("lastname"));
					a.setFirstname(rs.getString("firstname"));
                    a.setMiddlename(rs.getString("middlename"));
                    
					a.setBirthday(rs.getDate("birthday"));
                    a.setAddress(rs.getString("address"));
                    a.setNationality(rs.getString("nationality"));
                    a.setStatus(rs.getString("status"));

					a.setGender(rs.getString("gender"));
					
                    a.setNumber(rs.getString("number"));
					
					a.setVotersID(String.valueOf(rs.getInt("votersID")));

                    beans.add(a);
                }
                return beans;
            } catch (SQLException e) {
                writer.println("Error " + e);
                return null;
            }
        }
        return null;
    }

    public void deleteAllAccount() {
        if (con != null) {
            try {
                sqlStatement = "delete FROM " + tableName;
                ArrayList<Account> beans = new ArrayList<>();
                stmt.executeUpdate(sqlStatement);
            } catch (Exception e) {
            }
        }
    }
}
