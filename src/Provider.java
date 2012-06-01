import java.sql.ResultSet;
import java.sql.SQLException;


public class Provider extends Stuff{

	Provider(String StuffID,String name,String ID)
	{
		super(StuffID,name,ID);
	}
	ResultSet checkoutCD() throws Exception
	{
		ResultSet rs;
		rs = new AccountBook().getinfo();
		return rs;
	}
	void addCD(String CDid, int number , boolean rent) throws Exception
	{
		init.connectlist();
		init.connect();
		CD tmpCD = new CD();
		AccountBook acb= new AccountBook();
		Orderlist tmplist = new Orderlist();
		ResultSet rs=tmplist.searchCD(CDid);

		init.connect();
		int prenumber =number;
		while(rs.next())
		{
			number = tmplist.complete(rs.getString(1), CDid, number, rs.getInt(6), rs.getInt(5));
			if(number<=0)
				break;
			
		}
		if(number>=0)
		{
			tmpCD.addCD_byID(CDid, "reserve", prenumber-number);
			tmpCD.addCD_byID(CDid, "sale", number);
			acb.addCD_byid(CDid, "sale", number);
		}
		else
			tmpCD.addCD_byID(CDid, "reserve", prenumber);
		
		tmpCD.finish();
	}
}
