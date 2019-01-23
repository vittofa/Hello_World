import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Finestra {
	JLabel b1 = new JLabel("Parallelo");
	JButton reset = new JButton("Reset");
	JTextField R1 = new JTextField();
	JTextField R2 = new JTextField();
	JTextField Risultato = new JTextField();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	int i = new Integer(0);
	//String prova = new String("Bottone ");
	inputTesto txt1 = new inputTesto();
	inputTesto txt2 = new inputTesto();
	
	public Finestra() {
		Font f1 = new Font("Arial", Font.PLAIN, 50);
		JFrame finestra = new JFrame("Resistenze Parallelo");
		Container contenuto = finestra.getContentPane();
		GridLayout box1 = new GridLayout(0, 2);
		contenuto.setLayout(box1);
		
		
		l1.setText("R1 =");
		l1.setHorizontalAlignment(JLabel.RIGHT);
		l1.setFont(f1);
		contenuto.add(l1);
		contenuto.add(R1);
		R1.addKeyListener(txt1);
		R1.setFont(f1);
		l2.setText("R2 =");
		l2.setHorizontalAlignment(JLabel.RIGHT);
		l2.setFont(f1);
		contenuto.add(l2);
		contenuto.add(R2);
		R2.addKeyListener(txt2);
		R2.setFont(f1);
		b1.setText("Risultato =");
		b1.setHorizontalAlignment(JLabel.RIGHT);
		b1.setFont(f1);
		Risultato.setFont(f1);
		Risultato.setEditable(false);
		contenuto.add(b1);
		contenuto.add(Risultato);
		//Contenuto.add(reset);
		//Risultato.setBounds(new Rectangle(0,0,100,100));
		finestra.setBounds(500, 500, 1000, 300);
		finestra.setVisible(true);
		
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String Compute() {
		float Result1, Result2, Parallel;
		try {
			Result1 = Float.parseFloat(R1.getText());
			Result2 = Float.parseFloat(R2.getText());
			Parallel = ((Result1*Result2)/(Result1+Result2));
			return Float.toString(Parallel);
		}catch(NumberFormatException ex) {
			return "NaN";
		}
	}
	
	public class inputTesto implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			char c = e.getKeyChar();
			if(c == KeyEvent.VK_ENTER) {
				Risultato.setText(Compute());
			}
			if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
				e.consume();
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
