package Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utility.ClassTableModel;
import model.HocVien;
import service.HocVienService;
import service.HocVienServiceImpl;
import view.HocVienJFrame;

public class QuanLyHocVienController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnPrint;
    private JTextField jtfSearch;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã học viên", "STT", "Tên học viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Trạng thái"};
    private HocVienService hocVienService = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyHocVienController(JPanel jpnView, JButton btnAdd, JButton btnDelete, JButton btnPrint, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.btnDelete = btnDelete;
        this.btnPrint = btnPrint;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.hocVienService = new HocVienServiceImpl();
    }

    public void setDataToTable() {
        List<HocVien> listItem = hocVienService.getList();
        DefaultTableModel model = classTableModel.setTableHocVien(listItem, COLUMNS);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.setBackground(new Color(255, 51, 51)); // Màu đỏ cho nút Xóa
        btnDelete.setFont(new Font("Arial", Font.BOLD, 14));

        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length > 0) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    for (int i = selectedRows.length - 1; i >= 0; i--) {
                        int selectedRowIndex = table.convertRowIndexToModel(selectedRows[i]);
                        int idToDelete = (int) model.getValueAt(selectedRowIndex, 0); // Giả sử cột đầu tiên chứa ID
                        // Xóa hàng từ cơ sở dữ liệu
                        hocVienService.delete(idToDelete);
                        // Loại bỏ hàng từ mô hình bảng
                        model.removeRow(selectedRowIndex);
                    }
                }
            }
        });

        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    HocVien hocVien = new HocVien();
                    hocVien.setMaHocVien((int) model.getValueAt(selectedRowIndex, 0));
                    hocVien.setHoTen(model.getValueAt(selectedRowIndex, 2).toString());
                    hocVien.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 3));
                    hocVien.setGioiTinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    hocVien.setSoDienThoai(model.getValueAt(selectedRowIndex, 5).toString());
                    hocVien.setDiaChi(model.getValueAt(selectedRowIndex, 6).toString());
                    hocVien.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 7));

                    HocVienJFrame frame = new HocVienJFrame(hocVien);
                    frame.setTitle("Thông Tin Học Viên");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
        });

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HocVienJFrame frame = new HocVienJFrame(new HocVien());
                frame.setTitle("Thông Tin Học Viên");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
            
            
        });
        

        btnPrint.addActionListener(e -> {
            JTable table = (JTable) ((JScrollPane) jpnView.getComponent(0)).getViewport().getView();
            (new FileController()).exportExcel(table);
        });
        

    }
}
