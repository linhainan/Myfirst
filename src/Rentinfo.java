import java.sql.SQLException;


public class Rentinfo {
	

	private String CDname;
	private String CDid;
	private int type;
	private int num;
	private double price;
	final private String RentinfoTable = "RentInfo";
	void init() throws Exception
	{
		init.connect();
		init.ceatetable("create table IF not exists RentInfo"+
				"(ListID varchar(20),"+
				"CDname varchar(30),"+
				"CDid varchar(20),"+
				"type int,"+
				"num int,"+
				"price double,"+
				"foreign key(ListID) references List(ListID));");
	}
	void saveinfo(CD tmp,String LID,int num) throws SQLException
	{
		this.CDid = tmp.getid();
		this.CDname = tmp.getname();
		this.type = tmp.gettype();
		this.num = num;
		this.price = tmp.getprice();
		String sql = "insert into RentInfo "+"values("+LID+",'"+tmp.getname()+"','"+CDid+"',"+tmp.gettype()+","+num+","+tmp.getprice()+");";
		init.stmtlist.addBatch(sql);

	}

}
