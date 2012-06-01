import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AccountBook {
/*
	static protected ArrayList<Orderlist> orderbook =new ArrayList<Orderlist>();
	static protected ArrayList<Rentlist> rentbook = new ArrayList<Rentlist>();
	static protected ArrayList<Salelist> salebook = new ArrayList<Salelist>();
	static protected ArrayList<CD> CDstockout = new ArrayList<CD>();
	static void printturnover(){};
	
	static int searchOrderlist(String OrderID)
	{
		for(int i=0;i<orderbook.size();i++)
		{
			if(orderbook.get(i).getlistID().equals(OrderID))
				return i;
		}
		return -1;
	}
	static int searchRentlist(String RentID)
	{
		for(int i=0;i<rentbook.size();i++)
		{
			if(rentbook.get(i).getlistID().equals(RentID))
				return i;
		}
		return -1;
	}
	static int searchSalelist(String SaleID)
	{
		for(int i=0;i<salebook.size();i++)
		{
			if(salebook.get(i).getlistID().equals(SaleID))
				return i;
		}
		return -1;
	}
	
	static int searchOrderCD(String CDname,int type ,int num)
	{
		int retnum = 0;
		for(int i=0;i<orderbook.size();i++)
		{
			for(int j=0;j<orderbook.get(i).getcdlist().size();j++)
			{
				if(orderbook.get(i).getcdlist().get(j).CDname.equals(CDname) && orderbook.get(i).getcdlist().get(j).curnum!=0)
				{
					if(orderbook.get(i).getcdlist().get(j).type == type)
					{
						retnum += orderbook.get(i).getcdlist().get(j).curnum;
						if(num>=retnum)
						{
							orderbook.get(i).getcdlist().get(j).curnum = 0;
							num -=retnum;
							continue;
						}
						else
							orderbook.get(i).getcdlist().get(j).curnum -=num;
						return retnum;
					}
				}
			}
		}
		return retnum;
	}
	
	static void insertOrderlist(Orderlist orderlist)
	{
		orderbook.add(orderlist);
	}
	static void insertRentlist(Rentlist rentlist)
	{
		rentbook.add(rentlist);
	}
	static void insertSalelist(Salelist salelist)
	{
		salebook.add(salelist);
	}
	static void insertCDstockout(CD newCD)
	{
		for(int i=0;i<CDstockout.size();i++)
		{
			if(newCD == CDstockout.get(i))
				return;
		}
		CDstockout.add(newCD);
	}/*
	/*删除锁需要的参数待定*/
	/*
	static void deleteOrderlist(String OrderID)
	{
		int r = searchOrderlist(OrderID);
		if(r>=0)
				orderbook.remove(r);
	}
	static void deleteRentlist(String RentID)
	{
		int r = searchRentlist(RentID);
		if(r>=0)
				rentbook.remove(r);
	}
	static void deleteSalelist(String SaleID)
	{
		int r = searchSalelist(SaleID);
		if(r>=0)
				salebook.remove(r);
	}
	public static void Loaddata()
	{
		File file = new File("../dat/account.txt");
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(file));
			String tmp = null;
			tmp = reader.readLine();
			int count = Integer.parseInt(tmp);
			for(int j=0;j<count;j++)
			{
				tmp = reader.readLine();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}*/
	ResultSet rs;
	void init() throws Exception
	{
		init.connect();
		init.ceatetable("create table IF not exists CDneed"+
					"(CDid varchar(20) not null,"+
					"CDname varchar(30),"+
					"type int,"+
					"price double,"+
					"number int,"+
					"state varchar(15),"+
					"limitnumber int,"+
					"primary key(CDid,state));");
		
	}
	ResultSet getinfo() throws Exception
	{
		init.connect();
		ResultSet rs = init.stmt.executeQuery("select * from CDneed;");
		return rs;
	}
	void addCD_byid(String CDid ,String state,int num) throws Exception
	{
		init.connect();
		rs = init.stmt.executeQuery("select * from CDneed where CDneed.CDid='"+CDid+"' and CDneed.state ='"+state+"';");
		String sql ;
		if(rs.next() && rs.getInt(5)+num>=rs.getInt(7))
			sql =	"delete from CDneed "+" where CDneed.CDid='"+CDid+"' and CDneed.state='"+state+"';";
		else
			sql= "update CDneed set CDneed.number=CDneed.number+"+num+" where CDneed.CDid='"+CDid+"' and CDneed.state='"+state+"';";
		init.stmtlist.addBatch(sql);
	}
	
}
