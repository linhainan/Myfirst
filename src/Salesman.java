import java.io.File;



public class Salesman extends Stuff{
	
	Salesman(String StuffID,String name,String ID)
	{
		super(StuffID,name,ID);
	}
/*	int search(String CDname,int cdtype ,int businesstype)
	{
		return CDstorage.search(CDname, cdtype, businesstype);
	}
	void rentCD()
	{
		Rentlist newRentlist = new Rentlist();
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//�������ǽ�Ҫ��������
		newRentlist.payoff();
		AccountBook.insertRentlist(newRentlist);
	}
	void saleCD()
	{
		Salelist newSalelist = new Salelist();
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//�������ǽ�Ҫ��������
		newSalelist.payoff();
		AccountBook.insertSalelist(newSalelist);
	}
	void bookCD()
	{
		Orderlist newOrderlist = new Orderlist();
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//�������ǽ�Ҫ��������
		AccountBook.insertOrderlist(newOrderlist);
	}
	int checkVIP(String VIPnum,String passwd)
	{
		return VIP.checkvip(VIPnum, passwd);
	}
	void registVIP(String VIPnum,String passwd)
	{
		new VIP().addvip(VIPnum, passwd);
	}
	//��֧��������������˻�
	void returnSaleCD(String SalelistID)
	{
		int n = AccountBook.searchSalelist(SalelistID);
		if(n<0)
		{
			System.out.println(SalelistID + " is not correct!!!");
			return ;
		}
		Salelist curSalelist = AccountBook.salebook.get(n);
		while(true)
		{
			;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//��������
			String CDname = null;
			int type = 0;
			int num = 0;
			curSalelist.deleteCD(CDname,type ,num);
		}
	}
	void returnRentCD(String RentlistID)
	{
		int n = AccountBook.searchRentlist(RentlistID);
		if(n<0)
		{
			System.out.println(RentlistID + " is not correct!!!");
			return ;
		}
		Rentlist curRentlist = AccountBook.rentbook.get(n);

		curRentlist.returnback();
		System.out.println("the " + RentlistID + "has been complete!!!");
	}
	void completeOrderlist(String OrderlistID)
	{
		int n = AccountBook.searchOrderlist(OrderlistID);
		if(n<0)
		{
			System.out.println(OrderlistID + " is not correct!!!");
			return ;
		}
		Orderlist curOrderlist = AccountBook.orderbook.get(n);
		
		curOrderlist.payoff();
		System.out.println("the Order" + OrderlistID + "has been complete!!!");
	}*/
	
}
