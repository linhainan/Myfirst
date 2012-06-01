import java.sql.ResultSet;
import java.util.ArrayList;


public class Salelist extends List{
	
/*
	private ArrayList<CDinfo> CDlist;
	Salelist()
	{
		super();
		this.CDlist = new ArrayList<CDinfo>();
	}
	
	void insertCD(String CDname,int type ,int num)
	{
		int n = CDstorage.searchCDonsale(CDname ,type);
		CD tmp = CDstorage.CDonsale[type].get(n);
		CDinfo cdinfo = new CDinfo();
		cdinfo.CDname = CDname;
		cdinfo.CDnumber = tmp.getCDnumber();
		cdinfo.num = num;
		cdinfo.type = type;
		cdinfo.price = tmp.getprice();
		CDlist.add(cdinfo);
	}
	void deleteCD(String CDname,int type ,int num)
	{
		for(int i=0;i<CDlist.size();i++)
		{
			if(CDlist.get(i).CDname.equals(CDname))
			{
				if(CDlist.get(i).type == type)
				{
					if(num>CDlist.get(i).num)
					{
						System.out.println("the number is not right!!!");
						return ;
					}
					if(num == CDlist.get(i).num)
						CDlist.remove(i);
					else
						CDlist.get(i).num -= num;			
				}
			}
		}
	}
	void payoff()
	{
		if(used)
		{
			System.out.println("this salelist has been complete!!!");
			return ;
		}
		for(int i=0;i<CDlist.size();i++)
		{
			String CDname = CDlist.get(i).CDname;
			int type = CDlist.get(i).type;
			int number = CDlist.get(i).num;
			int n = CDstorage.searchCDonsale(CDname ,type);
			CDstorage.deletesalelist( CDstorage.CDonsale[type].get(n), number);
		}
		used = true;
	}
	
	class CDinfo
	{
		String CDnumber;
		String CDname;
		int type;
		int num;
		double price;
	}
	*/

	Saleinfo add(String CDid,int num) throws Exception
	{
		CD tmp = new CD();
		tmp = tmp.searchCD_byID(CDid,"sale");
		tmp.delCD_byID(CDid, "sale", num);
		Saleinfo saleinfo = new Saleinfo();
		saleinfo.saveinfo(tmp,super.getListID(),num);
		return saleinfo;
	}
}
