package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTableExample {
    private String[] columnNames = {"Nombre", "Precio", "Cantidad", "Borrar"};
    private DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    private JTable table = new JTable(model);

    public MyTableExample() {
        // Asigna el renderizador personalizado para la columna del JSpinner
        table.getColumnModel().getColumn(2).setCellRenderer(new SpinnerRenderer());

        // Configura el editor para el JSpinner
        SpinnerEditor spinnerEditor = new SpinnerEditor(new JSpinner());
        table.getColumnModel().getColumn(2).setCellEditor(spinnerEditor);

        // Configura la acción para el botón "Eliminar"
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        ButtonEditor buttonEditor = new ButtonEditor(new JCheckBox());
        table.getColumnModel().getColumn(3).setCellEditor(buttonEditor);

        // Botón para agregar un nuevo renglón
        JButton agregarButton = new JButton("Agregar Renglón");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNuevoRenglon();
            }
        });

        // Botón para eliminar la fila seleccionada
        JButton eliminarButton = new JButton("Eliminar Fila");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarFilaSeleccionada();
            }
        });

        // Panel que contiene los botones y la tabla
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(agregarButton, BorderLayout.NORTH);
        panel.add(eliminarButton, BorderLayout.SOUTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Crea el frame principal
        JFrame frame = new JFrame("Ejemplo de JTable con JSpinner y JButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void agregarNuevoRenglon() {
        // Añade un nuevo renglón con datos predeterminados
        model.addRow(new Object[]{"Nuevo Producto", "0.00", 1, "Eliminar"});
    }

    private void eliminarFilaSeleccionada() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    model.fireTableRowsDeleted(selectedRow, selectedRow);

                    // Verifica si la fila seleccionada sigue siendo válida
                    if (selectedRow >= model.getRowCount()) {
                        // La fila seleccionada ya no es válida, puedes realizar otras operaciones aquí si es necesario
                    }
                }
            }
        });
    }

    class SpinnerRenderer extends JSpinner implements TableCellRenderer {
        public SpinnerRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setValue(value);
            return this;
        }
    }

    class SpinnerEditor extends DefaultCellEditor {
        private JSpinner spinner;

        public SpinnerEditor(JSpinner spinner) {
            super(new JTextField()); // Utiliza un JTextField como editor por defecto
            this.spinner = spinner;
            setClickCountToStart(1); // Haz clic para iniciar la edición
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }

        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Eliminar");
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JButton button;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("Eliminar");
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int modelRow = table.convertRowIndexToModel(table.getEditingRow());
                    if (modelRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(modelRow);
                        fireEditingStopped();
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyTableExample());
    }
}
