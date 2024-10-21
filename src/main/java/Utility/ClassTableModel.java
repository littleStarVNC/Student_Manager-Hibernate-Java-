package Utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HocVien;

public class ClassTableModel {

    public DefaultTableModel setTableHocVien(List<HocVien> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Cột thứ 7 chứa Boolean, các cột khác chứa String
                if (columnIndex == 7) {
                    return Boolean.class;
                } else if (columnIndex == 3) {
                    return java.util.Date.class; // Cột ngày sinh
                }
                return String.class;
            }
        };

        dtm.setColumnIdentifiers(listColumn);

        for (int i = 0; i < listItem.size(); i++) {
            HocVien hocVien = listItem.get(i);
            Object[] row = new Object[columns];

            row[0] = hocVien.getMaHocVien();
            row[1] = i + 1;
            row[2] = hocVien.getHoTen();
            row[3] = hocVien.getNgaySinh();
            row[4] = hocVien.isGioiTinh() ? "Nam" : "Nữ";
            row[5] = hocVien.getSoDienThoai();
            row[6] = hocVien.getDiaChi();
            row[7] = hocVien.isTinhTrang();

            dtm.addRow(row);
        }

        return dtm;
    }
}