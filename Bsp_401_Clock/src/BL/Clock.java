package BL;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Clock extends JPanel implements Runnable {

    ArrayList<DigitLabel> labels = new ArrayList<>();

    private ZoneId zoneid;
    private ZonedDateTime time;

    private int count = 1;

    public Clock(ZoneId zoneid) {
        this.zoneid = zoneid;
        this.setSize(362, 48);
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(1, 8));

        for (int i = 0; i < 8; i++) {

            DigitLabel label = new DigitLabel();

            try {
                if (i == 2 || i == 5) {
                    label.setDigit(-1);
                    label.setName("point");
                } else {
                    label.setDigit(0);
                    label.setName("" + count);
                    count++;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "not a valid value");
            }

            this.add(label);
            labels.add(label);

        }

    }

    @Override
    public void run() {
        while (true) {
            time = ZonedDateTime.now(zoneid);

            try {
                this.setValues(time);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void setValues(ZonedDateTime time) throws Exception {
        labels.get(0).setDigit(time.getHour() / 10);
        labels.get(1).setDigit(time.getHour() % 10);
        labels.get(3).setDigit(time.getMinute() / 10);
        labels.get(4).setDigit(time.getMinute() % 10);
        labels.get(6).setDigit(time.getSecond() / 10);
        labels.get(7).setDigit(time.getSecond() % 10);

    }

}
