import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Orderlist {
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
	ResultSet add(String LID,String CDid,int num) throws Exception
	{
		CD tmp = new CD();
		tmp = tmp.searchCD_byID(CDid,"sale");
//		tmp.delCD_byID(CDid, "sale", num);
//		while(rs.next())
		{
			String sql = "insert into OrderInfo "+"values("+LID+",'"+tmp.getname()+"','"+CDid+"',"+tmp.gettype()+","+num+","+"0);";
			init.stmtlist.addBatch(sql);
		}
		return rs;
	}
	ResultSet searchCD(String CDid) throws Exception
	{
		init.connect();
		rs = init.stmt.executeQuery("select * from OrderInfo where OrderInfo.CDid="+CDid+" and OrderInfo.curnum < OrderInfo.num");
		return rs;
	}
	int complete(String ListID,String CDid,int number,int curnum,int totalnum) throws Exception
	{
		int result = curnum + number;
		init.connect();
		if(result>=totalnum)
			init.stmt.execute("update OrderInfo set curnum = num where OrderInfo.CDid = "+CDid+" and OrderInfo.ListID ="+ListID+";");
		else
			init.stmt.execute("update OrderInfo set OrderInfo.curnum = OrderInfo.curnum + "+number+" where OrderInfo.CDid = "+CDid+"and OrderInfo.ListID = "+ListID);
		return result-totalnum;
	}
}
