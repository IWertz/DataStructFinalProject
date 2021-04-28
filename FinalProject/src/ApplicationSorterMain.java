import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationSorterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creates ApplicationSorter to be injected
		ApplicationSorter as = new ApplicationSorter();
		//create application window
		JFrame frame = new JFrame();
		//create panel for application interface
		JPanel panel = new ApplicationSorterPanel(as);
		
		frame.setSize(300, 450);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
