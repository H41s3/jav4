import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private Timer timer;
    private Random random = new Random();

    public DigitalClock() {
        setTitle("Digital Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 72));
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setOpaque(true);
        add(timeLabel, BorderLayout.CENTER);

        // cre8 a timer to update the time and background color
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
                Date date = new Date();
                timeLabel.setText(dateFormat.format(date));

                // change the background color
                timeLabel.setBackground(getRandomColor());
            }
        });
        timer.start();
    }

    private Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
        });
    }
}
