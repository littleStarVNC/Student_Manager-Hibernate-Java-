package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.DanhMucBean;
import view.HomePagePanel;
import view.LearnerPanel;
import view.Relax;
import view.SentEmail;
import view.StatisticsPanel;

public class ChuyenManHinhController {

	private JPanel root;
	private String kindSelected = "";
	 private List <DanhMucBean> listItem = null;
	
	public ChuyenManHinhController(JPanel jpnRoot) {
		this.root = jpnRoot;
	}
	public void setView(JPanel jpnItem , JLabel jlbItem) {
		kindSelected = "TrangChu";
		jpnItem.setBackground(new Color(96, 100 ,191));
		jlbItem.setBackground(new Color(96 , 100 ,191));
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new HomePagePanel());
		root.validate();
		root.repaint();
	}
	
	public void setEvent(List <DanhMucBean> listItem) {
		this.listItem = listItem;
		for (DanhMucBean item : listItem) {
			item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn() , item.getJlb()));
		}
	}
	
	class LabelEvent implements MouseListener {
		
		private JPanel node;
		private String kind;
		
		private JPanel jpnItem;
		private JLabel jlbItem;
		

		public LabelEvent( String kind, JPanel jpnItem, JLabel jlbItem) {
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch(kind) {
			case "TrangChu":
				node = new HomePagePanel();
				break;
			case "HocVien":
				node = new LearnerPanel();
				break;
			case "KhoaHoc":
				node = new SentEmail();
				break;
			case "LopHoc":
				node = new Relax();
				break;
			case "ThongKe":
				node = new StatisticsPanel();
				break;
				
				default:
					node = new HomePagePanel();
					break;
			}
			// TODO Auto-generated method stub
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackgroud(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			kindSelected = kind;
			jpnItem.setBackground(new Color(96 , 100 ,191));
			jlbItem.setBackground(new Color(96 , 100 ,191));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(96 , 100 ,191));
			jlbItem.setBackground(new Color(96 , 100 ,191));
		}

		@Override
		public void mouseExited(MouseEvent e) {
if(!kindSelected.equalsIgnoreCase(kind)) {
			jpnItem.setBackground(new Color(76 , 175 ,80));
			jlbItem.setBackground(new Color(76 , 175 ,80));
		}
}
	}
	private void setChangeBackgroud(String kind) {
	for (DanhMucBean item : listItem) 
	{
		if(item.getKind().equalsIgnoreCase(kind))
		{
		item.getJpn().setBackground(new Color(96 ,100 , 191));
		item.getJlb().setBackground(new Color(96 ,100 , 191));
	   }else 
	   {
		   item.getJpn().setBackground(new Color(76 ,175 , 80));
			item.getJlb().setBackground(new Color(76 ,175 , 80));
	   }
	}
	}
}
