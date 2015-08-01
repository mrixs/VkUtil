package ui;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import listeners.RequestButtonListener;

/**
 * Created by Mrixs on 01.Aug.2015 15:43
 * Project: vk_util
 * Package: ui
 */
public class Window extends JFrame {
    public Window(){
        super("VK Age Util");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
            }
            @Override
            public void windowClosed(WindowEvent e) {
            }
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
            }});
        JFrame f = new JFrame();
        this.setSize(600, 800);
        this.setResizable(false);
        JLabel idLabel = new JLabel("Vk ID");
        JLabel medianAgeLabel = new JLabel("Median Age");
        JLabel mediumAgeLabel = new JLabel("Medium Age");
        JLabel friendsNumLabel = new JLabel("Number of Friends");
        JLabel friendsWithAgeNumLabel = new JLabel("Number of Friends with Age");
        JTextField idInput = new JTextField(10);
        JTextField medianInput = new JTextField(4);
        JTextField mediumInput = new JTextField(4);
        JTextField friendsNumInput = new JTextField(4);
        JTextField friendsWithAgeNumInput = new JTextField(4);
        JButton requestButton = new JButton("Do request");
        JTextArea debugText = new JTextArea(20,80);
        debugText.setLineWrap(true);
        idInput.setText("");                                                                                            // TODO: remove debug
        Container container = f.getContentPane();
        container.setLayout(new GridLayout(2,1));
        JPanel controls = new JPanel();
        JScrollPane debug = new JScrollPane(debugText);
        JPanel inputsPanel = new JPanel();
        JPanel agesPanel = new JPanel();
        JPanel friendsPanel = new JPanel();
        JPanel debugPanel = new JPanel();                                                                               // TODO: remove debug
        inputsPanel.setLayout(new FlowLayout());
        agesPanel.setLayout(new FlowLayout());
        friendsPanel.setLayout(new FlowLayout());
        inputsPanel.add(idLabel);
        inputsPanel.add(idInput);
        inputsPanel.add(requestButton);
        agesPanel.add(medianAgeLabel);
        agesPanel.add(medianInput);
        agesPanel.add(mediumAgeLabel);
        agesPanel.add(mediumInput);
        friendsPanel.add(friendsNumLabel);
        friendsPanel.add(friendsNumInput);
        friendsPanel.add(friendsWithAgeNumLabel);
        friendsPanel.add(friendsWithAgeNumInput);
        controls.add(inputsPanel);
        controls.add(agesPanel);
        controls.add(friendsPanel);
        debug.add(debugPanel);                                                                                          // TODO: remove debug
        container.add(controls);
        container.add(debug);
        this.add(container);
        requestButton.addActionListener(new RequestButtonListener(idInput,medianInput,mediumInput,friendsNumInput,friendsWithAgeNumInput,debugText,this));
    }
}