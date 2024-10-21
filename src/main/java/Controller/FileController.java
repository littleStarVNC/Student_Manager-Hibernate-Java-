package Controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class FileController {
	public void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (FileWriter out = new FileWriter(file + ".xls");
                 BufferedWriter bwrite = new BufferedWriter(out)) {

                TableModel model = table.getModel();

                // Ghi tên các cột
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");

                // Ghi dữ liệu các hàng
                for (int j = 0; j < model.getRowCount(); j++) {
                    for (int k = 0; k < model.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k).toString() + "\t");
                    }
                    bwrite.write("\n");
                }

                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
                e.printStackTrace();
            }
        }
    }
    
}