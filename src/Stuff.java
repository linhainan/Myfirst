
public class Stuff {
	
	final private String StuffID;
	final private String name;
	final private String ID;
	private double salary;
	Stuff(String StuffID,String name,String ID)
	{
		this.ID = ID;
		this.name = name;
		this.StuffID = StuffID;
	}
	String getID()
	{
		return this.ID ;
	}
	String getStuffID()
	{
		return this.StuffID;
	}
	String getname()
	{
		return this.name;
	}
	double getsalary()
	{
		return this.salary;
	}
}
