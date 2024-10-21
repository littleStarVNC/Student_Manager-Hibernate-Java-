package view;

import javax.swing.JPanel;

import Controller.QuanLyThongKeController;

import java.awt.Color;

public class StatisticsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StatisticsPanel() {
		setLayout(null);
		
		JPanel jpnChart1 = new JPanel();
		jpnChart1.setBounds(10, 10, 1006, 264);
		add(jpnChart1);
		jpnChart1.setLayout(null);
		
		JPanel jpnChart2 = new JPanel();
		jpnChart2.setBounds(10, 288, 1006, 264);
		add(jpnChart2);
		jpnChart2.setLayout(null);

		 if (jpnChart1 != null && jpnChart2 != null) {
	            QuanLyThongKeController controller = new QuanLyThongKeController();
	            controller.setDataToChart1(jpnChart1);
	            controller.setDataToChart2(jpnChart2);
	        } else {
	            System.err.println("ThongKeJPanel: Các thành phần jpnChart1 hoặc jpnChart2 chưa được khởi tạo hoặc thêm vào.");
	        }
	}
}
