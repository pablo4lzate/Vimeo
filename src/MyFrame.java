import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    static String videoURL = "0";
    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        button = new JButton("Ejecutar");
        button.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setText("Link");
        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            videoURL = textField.getText();
            System.out.println("URL: " + textField.getText());
            // button.setEnabled(false);
            // textField.setEditable(false);
            dispose();
        }
    }

    public static String getVideoURL() {
        return videoURL;
    }

    public static String setVideoURL(){
        videoURL = "0";
        
        return videoURL;
    }
}