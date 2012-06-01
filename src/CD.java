import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;


public class CD {

	private String CDnumber;
	private String CDname;
	private int type;
	private double price;
	private int number;
	private String state;
	private  int limitnum;
	final private String Tablename = "CD";
	CD()
	{
		this.CDname = null;
		this.CDnumber = null;
		this.type = 0;
		this.price =0;
		this.number = 0;
//		this.limitnum = 0;
	}
	void copy(CD newCD)
	{
		this.CDname = newCD.CDname;
		this.CDnumber = newCD.CDnumber;
		this.type = newCD.type;
		this.price = newCD.price;
		this.number = newCD.number;
//		this.limitnum = newCD.limitnum;
	}
	String getid()
	{
		return this.CDnumber;
	}
	String getname()
	{
		return this.CDname;
	}
	int gettype()
	{
		return this.type;
	}
	String getstate()
	{
		return this.state;
	}
	double getprice()
	{
		return this.price;
	}
	int getlimit()
	{
		return this.limitnum;
	}
	ResultSet rs;
	void init() throws Exception
	{
		init.connect();
		init.ceatetable("create table IF not exists CD"+
					"(CDid varchar(20) not null,"+
					"CDname varchar(30),"+
					"type int,"+
					"price double,"+
					"number int,"+
					"state varchar(15),"+
					"limitnumber int,"+
					"primary key(CDid,state));");
	}
	CD searchCD_byname(String CDname ,int type,String state) throws Exception
	{
		init.connect();
		ResultSet rs = init.stmt.executeQuery("select * from CD where CD.CDname='"+CDname+"' and CD.state='"+state+"' and CD.type="+type+";");
		while(rs.next())
		{
			System.out.println("1."+rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getDouble(4)
					+"  "+rs.getInt(5)+"  "+rs.getString(6));
			this.CDnumber = rs.getString(1);
			this.CDname = rs.getString(2);
			this.type = rs.getInt(3);
			this.price = rs.getDouble(4);
			this.number = rs.getInt(5);
			this.state = rs.getString(6);
			this.limitnum = rs.getInt(7);
		}
		return this;
	}
	CD searchCD_byID(String CDid ,String state) throws Exception
	{
		init.connect();
		rs = init.stmt.executeQuery("select * from CD where CD.CDid='"+CDid+"' and CD.state ='"+state+"';");
		while(rs.next())
		{
			System.out.println("1.  "+rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getDouble(4)
					+"  "+rs.getInt(5)+"  "+rs.getString(6));
			this.CDnumber = rs.getString(1);
			this.CDname = rs.getString(2);
			this.type = rs.getInt(3);
			this.price = rs.getDouble(4);
			this.number = rs.getInt(5);
			this.state = rs.getString(6);
			this.limitnum = rs.getInt(7);
		}
		rs.absolute(1);
		return this;
	}
	void addCD_byname(String CDname ,int type,String state,int num) throws Exception
	{
		String sql = "update CD set number=number+"+num+" where CD.CDname='"+CDname+"' and CD.state='"+state+"' and CD.type="+type+";";
		init.stmt.addBatch(sql);
	}
	void addCD_byID(String CDid ,String state, int num) throws Exception
	{
		init.connect();
		ResultSet rls = init.stmt.executeQuery("select * from CD where CD.CDid='"+CDid+"' and CD.state ='"+state+"';");
		String sql;
		
		if(rls.next())
		{
			sql = "update CD set number=number+"+num+" where CD.CDid='"+CDid+"' and CD.state='"+state+"';";
		}
		else
		{
			init.connect();			
			rls = init.stmt.executeQuery("select * from CD where CD.CDid='"+CDid+"' and CD.state ='sale';");
			rls.next();
			sql = "insert into CD values('"+CDid+"','"+rls.getString(2)+"',"+num+","+rls.getDouble(4)+","+rls.getInt(5)+",'reserve',"+rls.getInt(7)+");";
		}
		//init.connect();
		init.stmtlist.addBatch(sql);
	}
	/*注意，要有两个触发器约束，数目不能小于0*，低于底线要有相应的处理*/
	void delCD_byname(String CDname ,int type,String state,int num) throws Exception
	{
		String sql = "update CD set CD.number=CD.number-"+num+" where CD.CDname="+CDname+" and CD.state='"+state+"' and CD.type="+type+";";
		init.stmtlist.addBatch(sql);
	}
	void delCD_byID(String CDid ,String state, int num) throws Exception
	{
		String sql = "update CD set CD.number=CD.number-"+num+" where CD.CDid="+CDid+" and CD.state='"+state+"';";
		init.stmtlist.addBatch(sql);
	}
	void finish() throws Exception
	{
		try
		{
			int[] result = init.stmtlist.executeBatch();
			for(int i=0;i<result.length;i++)
			{
				;
			}
		}
		finally
		{
			init.disconnect();
		}
		
	}
	void insertCD()
	{
		//String sql ="";
	}
	void deleteCD()
	{
		
	}
}


