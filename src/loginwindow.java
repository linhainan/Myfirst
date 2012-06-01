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
	JFrame f = new JFrame("��¼");
	JButton ok = new JButton("ȷ��");
	JButton no= new JButton("ȡ��");
	JTextField ta = new JTextField(10);
	JPasswordField ps = new JPasswordField(10);
	private JComboBox roleSelect = new JComboBox();
	
	public void init()
	{
		Box userNameBox = Box.createHorizontalBox();
		userNameBox.add(Box.createHorizontalStrut(30));
		userNameBox.add(new JLabel("�û���: "));
		userNameBox.add(this.ta);
		userNameBox.add(Box.createHorizontalStrut(30));
		//��ʵ����
/*		Box realNameBox = Box.createHorizontalBox();
		realNameBox.add(Box.createHorizontalStrut(17));
		realNameBox.add(this.realNameLabel);
		realNameBox.add(this.realName);
		realNameBox.add(Box.createHorizontalStrut(30));*/
		//����
		Box passwdBox = Box.createHorizontalBox();
		passwdBox.add(Box.createHorizontalStrut(43));
		passwdBox.add(new JLabel("����: "));
		passwdBox.add(this.ps);
		passwdBox.add(Box.createHorizontalStrut(30));
		//��ɫѡ��
		Box roleSelectBox = Box.createHorizontalBox();
		createRoleSelect();
		roleSelectBox.add(Box.createHorizontalStrut(43));
		roleSelectBox.add(new JLabel("��ɫ: "));
		roleSelectBox.add(this.roleSelect);
		roleSelectBox.add(Box.createHorizontalStrut(30));
		//��ť
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
		this.setTitle("��½����");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.f.setLocation((int)screen.getWidth()*3/7, (int)screen.getHeight()/4);
		JPanel mainpanel = new JPanel();
		mainpanel.add(mainBox);
		this.f.add(mainpanel);
		this.f.setVisible(true);
		this.f.pack();
		initListener();
	}
	//��ʼ��������
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
			JOptionPane.showConfirmDialog(this, "�������û���", "����", 
					JOptionPane.OK_CANCEL_OPTION);
			return;
		}
		//�õ��û�����Ӧ��Ŀ¼
		File folder = new File(user+".dat");
		//���û���һ�ν���ϵͳ�� ����Ŀ¼
		if (!folder.exists()) {
			folder.mkdir();
		}
		//�õ������ļ�
//		File config = new File(folder.getAbsolutePath() + FileUtil.CONFIG_FILE);
		//try 
		{
			String pass = new String(ps.getPassword());
			if(pass.equals(""))
			{
				JOptionPane.showConfirmDialog(this, "��������", "����", 
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
	//		throw new LoginException("�����ļ�����");
		}*/
	}
	static public void main(String[] arg) throws Exception
	{
//		new AccountBook().init();
		new loginwindow().init();
//		new providerWindow().init();
	}
	
}
