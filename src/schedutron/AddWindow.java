package schedutron;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddWindow extends JFrame {
  JPanel panel = new JPanel(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();
  JButton okButton;
  JButton cancelButton;

  public AddWindow() {
    c.gridx = 0;
    c.gridy = 0;
    panel.add(new JLabel("Course Number"), c);
    c.gridy = 1;
    panel.add(new JLabel("Course Title"), c);
    c.gridy = 2;
    panel.add(new JLabel("Days"), c);
    c.gridy = 3;
    panel.add(new JLabel("Start Time"), c);
    c.gridy = 4;
    panel.add(new JLabel("End Time"), c);
    c.gridy = 5;
    panel.add(new JLabel("Credit Hours"), c);
    c.gridx = 1;
    c.gridy = 0;
  }


}
