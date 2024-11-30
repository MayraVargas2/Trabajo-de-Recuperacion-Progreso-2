
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaCircularDobleGUI extends JFrame {

    private ListaCircularDoble lista = new ListaCircularDoble();
    private JTextArea resultadoArea;
    private JTextField inputField;

    public ListaCircularDobleGUI() {
        setTitle("Lista Circular Doble");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de controles
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 2));

        // Controles
        inputField = new JTextField();
        JButton insertarBtn = new JButton("Insertar");
        JButton eliminarBtn = new JButton("Eliminar");
        JButton buscarBtn = new JButton("Buscar");
        JButton ordenarAscBtn = new JButton("Ordenar Ascendente");
        JButton ordenarDescBtn = new JButton("Ordenar Descendente");

        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(inputField);
        controlPanel.add(insertarBtn);
        controlPanel.add(eliminarBtn);
        controlPanel.add(buscarBtn);
        controlPanel.add(ordenarAscBtn);
        controlPanel.add(ordenarDescBtn);

        // Resultado
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        // Eventos
        insertarBtn.addActionListener(e -> {
            int valor = Integer.parseInt(inputField.getText());
            lista.insertar(valor);
            actualizarResultado();
        });

        eliminarBtn.addActionListener(e -> {
            int valor = Integer.parseInt(inputField.getText());
            lista.eliminar(valor);
            actualizarResultado();
        });

        buscarBtn.addActionListener(e -> {
            int valor = Integer.parseInt(inputField.getText());
            String resultado = (lista.buscar(valor) != null) ? "Elemento encontrado" : "Elemento no encontrado";
            JOptionPane.showMessageDialog(this, resultado);
        });

        ordenarAscBtn.addActionListener(e -> {
            lista.ordenarAscendente();
            actualizarResultado();
        });

        ordenarDescBtn.addActionListener(e -> {
            lista.ordenarDescendente();
            actualizarResultado();
        });

        // Agregar componentes
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void actualizarResultado() {
        resultadoArea.setText(lista.mostrar());
        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListaCircularDobleGUI().setVisible(true));
    }
}

