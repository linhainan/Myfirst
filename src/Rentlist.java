import java.sql.ResultSet;
import java.util.ArrayList;



public class Rentlist extends List{
/*
	private ArrayList<CDinfo> CDlist;
	Rentlist()
	{
		super();
		this.CDlist = new ArrayList<CDinfo>();
	}
	
*/
	/*
	 *这里，要注意判断光盘是否为可租的。 
	 * 
	 */
/*	void insertCD(String CDname, int type ,int num)
	{
		int n = CDstorage.searchCDonrent(CDname, type);
		if(n<0)
		{
			System.out.println("can't find this CD in rent store!!!");
			return;
		}
		CD tmp = CDstorage.CDonrent[type].get(n);
		CDinfo cdinfo = new CDinfo();
		cdinfo.CDname = CDname;
		cdinfo.CDnumber = tmp.getCDnumber();
		cdinfo.num = num;
		cdinfo.type = type;
		cdinfo.price = tmp.getprice();
		CDlist.add(cdinfo);
	}
	void deleteCD(String CDname,int type,int number)
	{
		for(int i=0;i<CDlist.size();i++)
		{
			CDinfo tmp = CDlist.get(i);
			if(CDlist.get(i).CDname.equals(CDname))
			{
				if(CDlist.get(i).type == type)
				{
					if(number>tmp.num)
					{
						System.out.println("the number is not right!!!");
						return ;
					}
					if(number == tmp.num)
						CDlist.remove(i);
					else
						tmp.num -= number;	
				}
			}
		}
	}
	void payoff()
	{
		if(used)
		{
			System.out.println("this rentlist has been complete!!!");
			return ;
		}
		for(int i=0;i<CDlist.size();i++)
		{
			String CDname = CDlist.get(i).CDname;
			int type = CDlist.get(i).type;
			int number = CDlist.get(i).num;
			int n = CDstorage.searchCDonsale(CDname ,type);
			CDstorage.deleterentlist( CDstorage.CDonrent[type].get(n), number);
		}
		used = true;
	}*/
	//暂时未对丢失做处理
/*	void returnback()
	{
		if(!used)
		{
			System.out.println("this rentlist has not been paid off!!!");
		}
		for(int i=0;i<CDlist.size();i++)
		{
			String CDname = CDlist.get(i).CDname;
			int type = CDlist.get(i).type;
			int number = CDlist.get(i).num;
			int n = CDstorage.searchCDonrent(CDname ,type);
			CDstorage.insertrentlist( CDstorage.CDonrent[type].get(n), number);
		}
	}
	class CDinfo
	{
		String CDnumber;
		String CDname;
		int type;
		int num;
		double price;
	}*/
	private ArrayList<Rentinfo> Rentinfolist = new ArrayList<Rentinfo>();
	ResultSet rs;

	Rentinfo add(String CDid,int num) throws Exception
	{
		CD tmp = new CD();
		tmp = tmp.searchCD_byID(CDid,"rent");
		tmp.delCD_byID(CDid, "rent", num);
		Rentinfo rentinfo = new Rentinfo();
		rentinfo.saveinfo(tmp,super.getListID(),num);
		return rentinfo;
	}
	void delete(String LID,String CDid)
	{
		;
	}
}
