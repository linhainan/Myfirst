import java.sql.ResultSet;
import java.sql.SQLException;


public class Orderinfo {

	String CDname;
	String CDid;
	int type;
	int num;
	int curnum;
	ResultSet rs;
	void init() throws Exception
	{
		init.connect();

		init.ceatetable("create table IF not exists OrderInfo"+
				"(ListID varchar(20),"+
				"CDname varchar(30),"+
				"CDid varchar(20),"+
				"type int,"+
				"num int,"+
				"curnum int," +
				"foreign key(ListID) references List(ListID));");
	}
	void saveinfo(CD tmp,String LID,int num) throws SQLException
	{
		this.CDid = tmp.getid();
		this.CDname = tmp.getname();
		this.type = tmp.gettype();
		this.num = num;
		this.curnum = 0;
		String sql = "insert into SaleInfo "+"values("+LID+",'"+tmp.getname()+"','"+CDid+"',"+tmp.gettype()+","+num+","+tmp.getprice()+");";
		init.stmtlist.addBatch(sql);
	}
}
