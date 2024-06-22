import javax.swing.*;
import java.awt.*;

public class RelatorioFrame extends JFrame {

    public RelatorioFrame(String relatorio) {
        setTitle("Relatório de Contas");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea(relatorio);
        textArea.setEditable(false);
        
        // Set dark theme
        textArea.setBackground(new Color(43, 43, 43));
        textArea.setForeground(new Color(187, 187, 187));
        textArea.setFont(new Font("Arial", Font.PLAIN, 17));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPane.setBackground(new Color(43, 43, 43));

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
