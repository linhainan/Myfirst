import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.*;




public class loginwindow extends JFrame{
	JFrame f = new JFrame("登录");
	JButton ok = new JButton("确认");
	JButton no= new JButton("取消");
	JTextField ta = new JTextField(10);
	JPasswordField ps = new JPasswordField(10);
	private JComboBox roleSelect = new JComboBox();
	
	public void init()
	{
		Box userNameBox = Box.createHorizontalBox();
		userNameBox.add(Box.createHorizontalStrut(30));
		userNameBox.add(new JLabel("用户名: "));
		userNameBox.add(this.ta);
		userNameBox.add(Box.createHorizontalStrut(30));
		//真实姓名
/*		Box realNameBox = Box.createHorizontalBox();
		realNameBox.add(Box.createHorizontalStrut(17));
		realNameBox.add(this.realNameLabel);
		realNameBox.add(this.realName);
		realNameBox.add(Box.createHorizontalStrut(30));*/
		//密码
		Box passwdBox = Box.createHorizontalBox();
		passwdBox.add(Box.createHorizontalStrut(43));
		passwdBox.add(new JLabel("密码: "));
		passwdBox.add(this.ps);
		passwdBox.add(Box.createHorizontalStrut(30));
		//角色选择
		Box roleSelectBox = Box.createHorizontalBox();
		createRoleSelect();
		roleSelectBox.add(Box.createHorizontalStrut(43));
		roleSelectBox.add(new JLabel("角色: "));
		roleSelectBox.add(this.roleSelect);
		roleSelectBox.add(Box.createHorizontalStrut(30));
		//按钮
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(this.ok);
		buttonBox.add(Box.createHorizontalStrut(40));
		buttonBox.add(this.no);
		
		Box mainBox = Box.createVerticalBox();
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(userNameBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(passwdBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(roleSelectBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(buttonBox);
		mainBox.add(Box.createVerticalStrut(20));
		this.add(mainBox);	
		this.setResizable(false);
		this.setTitle("登陆界面");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.f.setLocation((int)screen.getWidth()*3/7, (int)screen.getHeight()/4);
		JPanel mainpanel = new JPanel();
		mainpanel.add(mainBox);
		this.f.add(mainpanel);
		this.f.setVisible(true);
		this.f.pack();
		initListener();
	}
	//初始化监听器
	private void initListener() {
		this.ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					confirm();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		this.no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	private void createRoleSelect() {
		this.roleSelect.removeAllItems();
		this.roleSelect.addItem("Manager");
		this.roleSelect.addItem("SaleMan");
		this.roleSelect.addItem("Provider");
	}
	private void confirm() throws Exception 
	{
		String user = this.ta.getText();
		if (user.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "请输入用户名", "警告", 
					JOptionPane.OK_CANCEL_OPTION);
			return;
		}
		//得到用户名对应的目录
		File folder = new File(user+".dat");
		//该用户第一次进入系统， 创建目录
		if (!folder.exists()) {
			folder.mkdir();
		}
		//得到配置文件
//		File config = new File(folder.getAbsolutePath() + FileUtil.CONFIG_FILE);
		//try 
		{
			String pass = new String(ps.getPassword());
			if(pass.equals(""))
			{
				JOptionPane.showConfirmDialog(this, "输入密码", "警告", 
						JOptionPane.OK_CANCEL_OPTION);
				return;
			}
			String role = (String)this.roleSelect.getSelectedItem();
			if(role.equals("Manager"))
				System.out.println("Manager");
			if(role.equals("SaleMan"))
				System.out.println("saleMan");
			if(role.equals("Provider"))
			{
				this.f.setVisible(false);
				providerWindow prowindow = new providerWindow();
				prowindow.provider = new Provider("tmp","tmp","tmp"); 
				prowindow.init();
			}
			
		} /*catch (IOException e) {
			e.printStackTrace();
	//		throw new LoginException("配置文件错误");
		}*/
	}
	static public void main(String[] arg) throws Exception
	{
//		new AccountBook().init();
		new loginwindow().init();
//		new providerWindow().init();
	}
	
}
