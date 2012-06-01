import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;

public class providerWindow extends JFrame
{
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT , JTabbedPane.WRAP_TAB_LAYOUT);	
	ImageIcon icon = new ImageIcon("ico/close.gif");
	JTextField CDID = new JTextField(20);
	JTextField CDNum = new JTextField(5);
	JButton Config = new JButton("ȷ��");
	JButton FinalConfig = new JButton("ȷ������");
	JTable Table;
	DefaultTableModel table;
	JPanel OP_ADD_PANEL;
	JPanel OP_SEE_PANEL;
	
	Provider provider;
	public void init() throws Exception
	{

		//��ʾ�ʼ����ݵ�JScrollPane
		String tip = "OK";
		init_add_frame();
		init_see_frame();
		this.tabbedPane.addTab("���CD",icon,OP_ADD_PANEL,tip );
		initListener();
		this.tabbedPane.addTab("CDȱ��״��",icon,OP_SEE_PANEL,tip );
		this.add(tabbedPane);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)screen.getWidth()/3, (int)screen.getHeight()/4);
		this.setTitle("�����߽���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);

		this.setVisible(true);
		this.pack();
	}
	void init_add_frame()
	{
		OP_ADD_PANEL = new JPanel();
		JSplitPane mailInfoPane;
		table = new DefaultTableModel();
		String []item = {"���","����","����","��Ŀ","�۸�","����"};
		Table = new JTable(table);
		table.setDataVector(null, item);
		setTableFace(Table);
		
		JPanel addpanel =new JPanel();

		
		addpanel.add(new JLabel("CD���",JLabel.CENTER));
		addpanel.add(CDID);
		addpanel.add(new JLabel("����", JLabel.CENTER));
		addpanel.add(CDNum);
		addpanel.add(Config);
		
		JScrollPane tablePane = new JScrollPane(Table);
		
		mailInfoPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,addpanel,tablePane);
		this.OP_ADD_PANEL.add(mailInfoPane);
	}
	void init_see_frame() throws Exception
	{
		OP_SEE_PANEL = new JPanel();
		DefaultTableModel table = new DefaultTableModel();
		String []item = {"���","����","����","��Ŀ","�۸�","����"};
		JTable Table = new JTable(table);
		table.setDataVector(null, item);
		seefresh(table);
		JScrollPane tablePane = new JScrollPane(Table);
		
		this.OP_SEE_PANEL.add(tablePane);
	}

	private void initListener() {
		this.Config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					confirm();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	void seefresh(DefaultTableModel table) throws Exception
	{
		ResultSet rs =provider.checkoutCD();
		String []Type = {"��Ϸ","����","����"};
		while(rs.next())
		{
			
			String CDid = rs.getString(1);
			int number = rs.getInt(5);
			String name = rs.getString(2);
			int type = rs.getInt(3);
			double price = rs.getDouble(4);
			int limit = rs.getInt(7);
			String []row = {CDid,name,""+Type[type],""+number,""+price,""+limit};
			table.addRow(row);
		}
	}
	void confirm() throws Exception
	{
		String []Type = {"��Ϸ","����","����"};
		String CDid = CDID.getText();
		int number = Integer.parseInt(CDNum.getText());
		System.out.println(provider);
		provider.addCD(CDid, number,false);
		CD tmp = new CD();
		tmp =  tmp.searchCD_byID(CDid, "sale");
		String name = tmp.getname();
		int type = tmp.gettype();
		double price = tmp.getprice();
		int limit = tmp.getlimit();
		String []row = {CDid,name,""+Type[type],""+number,""+price,""+limit};
		table.addRow(row);
		Table.repaint();
	}
	private void setTableFace(JTable tableMode) {
		
		tableMode.getColumn("���").setMinWidth(30);
		tableMode.getColumn("����").setMinWidth(30);
		tableMode.getColumn("��Ŀ").setMinWidth(10);
		tableMode.getColumn("�۸�").setMinWidth(10);
		tableMode.setRowHeight(30);
	}


}
