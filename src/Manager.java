import java.sql.SQLException;


public class Manager extends Stuff{

	Manager(String StuffID,String name,String ID)
	{
		super(StuffID,name,ID);
	}
	void checkturnover(){};
	void setlimit(int type ,int low) throws SQLException
	{
		init.stmt.execute("update CD set limitnumber="+low+"where CD.type="+type);
	}
}
