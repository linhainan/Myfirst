import java.sql.ResultSet;
import java.sql.SQLException;


public class List {
/*
	private String listID;
	private String customer;
	private String date;
	private double all_price;
	boolean used;
	
	List()
	{
		all_price = 0;
		used = false;
	}
	void setlistID(String listID)
	{
		this.listID = listID;
	}
	void setcustomer(String name)
	{
		this.customer = name;
	}
	void setdate(String date)
	{
		this.date = date;
	}
	void setallprice(double price)
	{
		this.all_price = price;
	}
	void addprice(double price)
	{
		this.all_price += price;
	}
	String getlistID()
	{
		return this.listID;
	}
	String getcustomer()
	{
		return this.customer;
	}
	String getdate()
	{
		return this.date;
	}
	double getallprice()
	{
		return this.all_price;
	}
*/
	private String ListID;
	private String custom;
	private String datetime;
	private double price;
	private String state;
	final private String ListTable = "List";
	private ResultSet rs;
	void init() throws Exception
	{
		init.connect();
		init.ceatetable("create table IF not exists List"+
				"(ListID varchar(20) primary key,"+
				"customer varchar(20),"+
				"curdate datetime,"+
				"price double,"+
				"state varchar(12),"+
				"used tinyint(1));");
	}
	void search(String ListID) throws SQLException
	{
		rs = init.stmt.executeQuery("select * from List where List.ListID="+ListID);
		rs.next();
		this.ListID = rs.getString(1);
		this.custom = rs.getString(2);
		this.price = rs.getDouble(4);
		this.state = rs.getString(5);
	}
	void create(String ListID,String custom,String date,String state) throws Exception
	{
		init.connect();
		String sql = "insert into List values('"+ListID+"','"+custom+"',null,'"+state+"',0);";
		init.stmt.execute(sql);
	}
/*	void add(String ListID,int type,String CDid,int num) throws Exception
	{
		init.connectlist();
		switch(type)
		{
		case 0:
			new Rentlist().add(CDid, num);
			break;
		case 1:
			new Orderlist().add(ListID, CDid, num);
			break;
		case 2:
			new Salelist().add(CDid, num);
		}
	}
	*/
	void finish() throws SQLException
	{
		init.stmtlist.executeBatch();
	}
	String getListID()
	{
		return this.ListID;
	}
}
