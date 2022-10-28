package com.base;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class CaesarFrame extends JFrame {
    private JTextField t0 = new JTextField("", 20);
    JTextField tlast = t0;
    public class Fl implements FocusListener{
        public void focusGained(FocusEvent e) {
            tlast = (JTextField)e.getSource();
        }
        public void focusLost(FocusEvent e) {
        }
        
    }

    private class OkButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(tlast.equals(t0)){
                String input = t0.getText();
                char c = jc0.getSelectedItem().toString().toCharArray()[0];
                String output = caesarCode(input, c);
                t1.setText(output);
            }
            else if(tlast.equals(t1)){
                String input = t1.getText();
                char c = jc0.getSelectedItem().toString().toCharArray()[0];
                String output = caesarCoded(input, c);
                t0.setText(output);
            }
        }
    }

    private class InputFieldKeyListener implements DocumentListener{
        public void changedUpdate(DocumentEvent e) {
            String input = t0.getText();
            char c = jc0.getSelectedItem().toString().toCharArray()[0];
            String output = caesarCode(input, c);
            t1.setText(output);
            
        }

        public void insertUpdate(DocumentEvent e) {
            String input = t0.getText();
            char c = jc0.getSelectedItem().toString().toCharArray()[0];
            String output = caesarCode(input, c);
            t1.setText(output);
            
        }

        public void removeUpdate(DocumentEvent e) {
            String input = t0.getText();
            char c = jc0.getSelectedItem().toString().toCharArray()[0];
            String output = caesarCode(input, c);
            t1.setText(output);            
        }
    }
    private String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
    private JComboBox<String> jc0 = new JComboBox<String>(alphabet);
    private JButton b0 = new JButton("Code!");
    private JTextField t1 = new JTextField("", 20);

    public CaesarFrame(){
        setSize(400, 110);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(new GridLayout(2,1));
        JLabel l0 = new JLabel("Output:");
        
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        p0.setLayout(layout);
        p1.setLayout(layout);
        add(p0);
        add(p1);
        
        t0.addFocusListener(new Fl());
        t1.addFocusListener(new Fl());
        t0.addFocusListener(new Fl());
        b0.addActionListener( new OkButtonActionListener());
        t0.getDocument().addDocumentListener(new InputFieldKeyListener());
        p0.add(jc0);
        p0.add(t0);
        p0.add(b0);

        t1.setEditable(true);
        p1.add(l0);
        p1.add(t1);


    }
    private String caesarCode(String input, char offset){
        char[] out = input.toCharArray();
		for (int i = 0; i < out.length; i++) {
			out[i] += offset - 'a';
			if (out[i] > 'z'){
				out[i] -= ('z'-'a' + 1);
            }
		}
		return new String(out);    
    }
    private String caesarCoded(String input, char offset){
        char[] out = input.toCharArray();
		for (int i = 0; i < out.length; i++) {
			out[i] -= offset - 'a';
			if (out[i] < 'a'){
				out[i] += ('z'-'a' + 1);
            }
		}
        System.out.println(out[0]);
		return new String(out);    
    }
}
