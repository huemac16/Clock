package BL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DigitLabel extends JLabel {

    private int digit;

    public DigitLabel() {
        this.setSize(24, 40);
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) throws Exception {

        if (digit < -1 && digit > 9) {
            throw new Exception("not a valid value!");
        }

        this.digit = digit;
        this.defineIcon();
    }

    public void defineIcon() {

        switch (digit) {
            case -1:
                this.setIcon(new ImageIcon("img\\Point.png"));
                break;
            case 0:
                this.setIcon(new ImageIcon("img\\0.png"));
                break;
            case 1:
                this.setIcon(new ImageIcon("img\\1.png"));
                break;
            case 2:
                this.setIcon(new ImageIcon("img\\2.png"));
                break;
            case 3:
                this.setIcon(new ImageIcon("img\\3.png"));
                break;
            case 4:
                this.setIcon(new ImageIcon("img\\4.png"));
                break;
            case 5:
                this.setIcon(new ImageIcon("img\\5.png"));
                break;
            case 6:
                this.setIcon(new ImageIcon("img\\6.png"));
                break;
            case 7:
                this.setIcon(new ImageIcon("img\\7.png"));
                break;
            case 8:
                this.setIcon(new ImageIcon("img\\8.png"));
                break;
            case 9:
                this.setIcon(new ImageIcon("img\\9.png"));
                break;
        }
    }

}
