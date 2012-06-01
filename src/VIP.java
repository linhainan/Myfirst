import java.util.ArrayList;

public class VIP {

	static private ArrayList<vip> VIPList= new ArrayList<vip>();
	VIP()
	{
	}
	static int checkvip(String VIPnum,String passwd)
	{
		for(int i=0;i<VIPList.size();i++)
		{
			if(VIPList.get(i).VIPID.equals(VIPnum))
			{
				if(VIPList.get(i).passwd.equals(passwd))
					return i;
				else
					return -1;
			}
		}
		return -1;
	}
	static void addscore(int score,int id)
	{
		VIPList.get(id).addscore(score);
	}
	void addvip(String VIPnum,String passwd)
	{
		VIPList.add(new vip(VIPnum,passwd));
	}
	public class vip
	{
		final private String VIPID;
		private String passwd;
		private int score;
		vip(String ID,String passwd)
		{
			this.VIPID =ID;
			this.passwd = passwd;
			score = 0;
		}
		void addscore(int score)
		{
			this.score += score;
		}
	}

}

