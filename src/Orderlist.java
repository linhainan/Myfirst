import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Orderlist extends List{

	Orderinfo add(String LID,String CDid,int num) throws Exception
	{
		CD tmp = new CD();
		tmp = tmp.searchCD_byID(CDid,"sale");
		Orderinfo orderinfo = new Orderinfo();
		orderinfo.saveinfo(tmp, super.getListID(), num);
		return orderinfo;
	}
	ResultSet searchCD(String CDid) throws Exception
	{
		ResultSet rs ;
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
