
public class Rentinfo {
	
	private String ListID ;
	private String CDname;
	private String CDid;
	private int type;
	private int num;
	private double price;
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

}
