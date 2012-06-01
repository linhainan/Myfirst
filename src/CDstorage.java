import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CDstorage {
	/*
	CDstorage(){};
	*/
	/*
	 *注意保证，会提前保留一部分CD给订单 
	 * 
	 */

/*	static public void insertCD(CD newCD,int number , boolean rent)
	{
		if(!rent)
		{
			int curnum = AccountBook.searchOrderCD(newCD.getCDname(), newCD.gettype() ,number);
			if(curnum > 0)
			{
				//here ,we need to find if there is a exist cd before add;
				if(number>=curnum)
				{
					insertreservelist(newCD , curnum);
					number -= curnum;
				}
				else
				{
					insertreservelist(newCD , number);
					number = 0;
				}
			}
			insertsalelist(newCD,number);
		}
		else
		{
			insertrentlist(newCD , number);
		}
	}
	//下边两个函数是为了保证当已经有部分CD被放在仓库中后仅需改变数量即可。
	static void insertsalelist(CD newCD,int number)
	{
		if(number<=0)
			return;
		for(int i=0;i<CDonsale[newCD.gettype()].size();i++)
		{
			if(CDonsale[newCD.gettype()].get(i).getCDname().equals(newCD.getCDname()))
			{
				CDonsale[newCD.gettype()].get(i).addnumber(number);
				return ;
			}
		}
		newCD.setnumber(number);
		CD tmp = new CD();
		tmp.copy(newCD);
		CDonsale[newCD.gettype()].add(tmp);
		return ;
	}
	static void insertreservelist(CD newCD,int number)
	{
		if(number<=0)
			return;
		for(int i=0;i<CDreserved[newCD.gettype()].size();i++)
		{
			if(CDreserved[newCD.gettype()].get(i).getCDname().equals(newCD.getCDname()))
			{
				CDreserved[newCD.gettype()].get(i).addnumber(number);
				return ;
			}
		}
		newCD.setnumber(number);
		CD tmp = new CD();
		tmp.copy(newCD);
		CDreserved[newCD.gettype()].add(tmp);
		return ;
	}
	static void insertrentlist(CD newCD , int number)
	{
		if(number<=0)
			return;
		for(int i=0;i<CDonrent[newCD.gettype()].size();i++)
		{
			if(CDonrent[newCD.gettype()].get(i).getCDname().equals(newCD.getCDname()))
			{
				CDonrent[newCD.gettype()].get(i).addnumber(number);
				return ;
			}
		}
		newCD.setnumber(number);
		CD tmp = new CD();
		tmp.copy(newCD);
		CDonrent[newCD.gettype()].add(tmp);
		return ;
	}
	static public void deleteCD(CD newCD,int number ,int businesstype)
	{
		switch(businesstype)
		{
		case 0:
			deletesalelist(newCD,number);
			break;
		case 1:
			deleterentlist(newCD,number);
			break;
		case 2:
			deletereservelist(newCD,number);
			break;		
		default :
			break;
		}
	}
	static int deletesalelist(CD newCD,int number)
	{
		if(number<=0)
			return -1;
		String CDname = newCD.getCDname();
		int type = newCD.gettype();
		int n = searchCDonsale(CDname ,type);
		if(n>=0)
		{
			CDonsale[type].get(n).subnumber(number);
			return 0;
		}
		else
			return -1;
	}
	static int deletereservelist(CD newCD,int number)
	{
		if(number<=0)
			return -1;
		String CDname = newCD.getCDname();
		int type = newCD.gettype();
		int n = searchCDreserved(CDname ,type);
		if(n>=0)
		{
			CDreserved[type].get(n).subnumber(number);
			return 0;
		}
		else
			return -1;
	}
	static int deleterentlist(CD newCD , int number)
	{
		if(number<=0)
			return -1;
		String CDname = newCD.getCDname();
		int type = newCD.gettype();
		int n = searchCDonrent(CDname ,type);
		if(n>=0)
		{
			CDonrent[type].get(n).subnumber(number);
			return 0;
		}
		else
			return -1;
	}
	static void printCDList(int type,boolean rentable){};
	static int search(String CDname,int cdtype ,int businesstype)
	{
		switch(businesstype)
		{
			case 0 :			
				for(int i=0;i<CDonsale[cdtype].size();i++)
				{
					if(CDonsale[cdtype].get(i).getCDname().equals(CDname))
						return i;
				}
				return -1;
			case 1 :
				for(int i=0;i<CDonrent[cdtype].size();i++)
				{
					if(CDonrent[cdtype].get(i).getCDname().equals(CDname))
						return i;
				}
				return -1;
			case 2 :
				for(int i=0;i<CDreserved[cdtype].size();i++)
				{
					if(CDreserved[cdtype].get(i).getCDname().equals(CDname))
						return i;
				}
				return -1;
				default : break;
		}
		return -1;
	}*/
}
