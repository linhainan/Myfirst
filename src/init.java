import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;


public  class init {
	static private String driver = "com.mysql.jdbc.Driver";
	static private String url = "jdbc:mysql://127.0.0.1:3306/mytest";
	static private String user = "root";
	static private String pass = "zbx123456";
	static Connection conn;
	static Connection connlist;
	static java.sql.Statement stmt;
	static java.sql.Statement stmtlist;

	static public void connect()throws Exception
	{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		stmt = conn.createStatement();
	}
	static public void connectlist()throws Exception
	{
		Class.forName(driver);
		connlist = DriverManager.getConnection(url, user, pass);
		stmtlist = connlist.createStatement();
	}
	static public void disconnect() throws Exception
	{
		if(stmt != null)
			((java.sql.Statement) stmt).close();
		if(conn != null)
			conn.close();
	}
	static public void ceatetable(String sql) throws Exception
	{
		try
		{
			((java.sql.Statement) stmt).executeUpdate(sql);
		}
		finally
		{
			disconnect();
		}
	}
	public  static void main(String arg[]) throws Exception
	{
			new CD().init();
			new List().init();
			new Orderlist().init();
			new Rentlist().init();
			new Salelist().init();
	//		init.connect();
	//		new CD().addCD_byID("1", "sale",30);
	//		new CD().addCD_byID("2", "sale", 30);
	//		init.connect();
	//		new CD().searchCD_byID("2", "sale");
	//		new CD().delCD_byID("1", "sale", 15);
	//		new CD().finish();
			init.connect();
//			Orderlist tmp=new Orderlist();
//			tmp.add("1234", "1", 10);
	//		init.connect();
			new CD().finish();
			init.connect();
			new CD().searchCD_byID("1", "sale");
			init.connect();
			new Provider("ee","ee","ee").addCD("1", 10, false);
					
	}

}
