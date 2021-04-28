import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ApplicationSorterPanel extends JPanel {
	
	//create global variables to be reused during runtime
	ApplicationSorter as;
	Application newApp;
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JButton submitButton, refButton, refCancelButton, refSubmitButton, employerEvaluateButton;
	
	//injects ApplicationSorter, calls employee page on startup
	public ApplicationSorterPanel(ApplicationSorter as) {
		this.as = as;
		employeePage();
	}

	//displays the reference page
	public void refPage() {
		removeAll();
		revalidate(); 
		
		System.out.println("ref page");
		
		l1 = new JLabel("Enter New Reference");
		l2 = new JLabel("Enter name");
		tf1 = new JTextField();
		tf1.setColumns(28);
		l3 = new JLabel("Enter relationship");
		tf2 = new JTextField();
		tf2.setColumns(28);
		l4 = new JLabel("Enter phone number");
		tf3 = new JTextField();
		tf3.setColumns(28);
		refSubmitButton = new JButton("    Submit    ");
		buttonListenerRefSubmit refSubmit = new buttonListenerRefSubmit();
		refSubmitButton.addActionListener(refSubmit);
		
		refCancelButton = new JButton("    Cancel    ");
		buttonListenerRefCancel refCancel = new buttonListenerRefCancel();
		refCancelButton.addActionListener(refCancel);
		
		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(l4);
		add(tf3);
		add(refSubmitButton);
		add(refCancelButton);
		
		JButton employerButton = new JButton("Employer Page");
		buttonListenerEmployer employer = new buttonListenerEmployer();
		employerButton.addActionListener(employer);
		JButton employeeButton = new JButton("Employee Page");
		buttonListenerEmployee employee = new buttonListenerEmployee();
		employeeButton.addActionListener(employee);

		add(employeeButton);
		add(employerButton);
		
		repaint();
	}
	
	//returns the employee page with current employee information provided
	public void returnEmployeePage() {
		System.out.println("return employee page");
		removeAll();
		revalidate();
		
		l1 = new JLabel("Enter Application");
		l2 = new JLabel("Enter name");
		tf1 = new JTextField();
		tf1.setColumns(28);
		tf1.setText(newApp.name);
		l3 = new JLabel("Why this job?");
		tf2 = new JTextField();
		tf2.setColumns(28);
		tf2.setText(newApp.whyYouWantThisJob);
		l4 = new JLabel("What qualifications?");
		tf3 = new JTextField();
		tf3.setColumns(28);
		tf3.setText(newApp.whatMakesYouQualified);
		l5 = new JLabel("When to start?");
		tf4 = new JTextField();
		tf4.setColumns(28);
		tf4.setText(newApp.whenToStart);
		l6 = new JLabel("Years of previous experience?");
		tf5 = new JTextField();
		tf5.setColumns(28);
		tf5.setText(String.valueOf(newApp.yearsOfPrevExp));
		submitButton = new JButton("Submit");
		buttonListenerSubmit submit = new buttonListenerSubmit();
		submitButton.addActionListener(submit);
		
		refButton = new JButton("References");
		buttonListenerRef ref = new buttonListenerRef();
		refButton.addActionListener(ref);
		
		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(l4);
		add(tf3);
		add(l5);
		add(tf4);
		add(l6);
		add(tf5);
		add(submitButton);
		add(refButton);
		
		JButton employerButton = new JButton("Employer Page");
		buttonListenerEmployer employer = new buttonListenerEmployer();
		employerButton.addActionListener(employer);
		JButton employeeButton = new JButton("Employee Page");
		buttonListenerEmployee employee = new buttonListenerEmployee();
		employeeButton.addActionListener(employee);

		add(employeeButton);
		add(employerButton);
		
		repaint();
	}
	
	//displays the employee page
	public void employeePage() {
		removeAll();
		revalidate();
		
		newApp = new Application();
		
		l1 = new JLabel("Enter Application");
		l2 = new JLabel("Enter name");
		tf1 = new JTextField();
		tf1.setColumns(28);
		l3 = new JLabel("Why this job?");
		tf2 = new JTextField();
		tf2.setColumns(28);
		l4 = new JLabel("What qualifications?");
		tf3 = new JTextField();
		tf3.setColumns(28);
		l5 = new JLabel("When to start?");
		tf4 = new JTextField();
		tf4.setColumns(28);
		l6 = new JLabel("Years of previous experience?");
		tf5 = new JTextField();
		tf5.setColumns(28);
		submitButton = new JButton("Submit");
		buttonListenerSubmit submit = new buttonListenerSubmit();
		submitButton.addActionListener(submit);
		
		refButton = new JButton("References");
		buttonListenerRef ref = new buttonListenerRef();
		refButton.addActionListener(ref);
		
		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(l4);
		add(tf3);
		add(l5);
		add(tf4);
		add(l6);
		add(tf5);
		add(submitButton);
		add(refButton);
		
		JButton employerButton = new JButton("Employer Page");
		buttonListenerEmployer employer = new buttonListenerEmployer();
		employerButton.addActionListener(employer);
		JButton employeeButton = new JButton("Employee Page");
		buttonListenerEmployee employee = new buttonListenerEmployee();
		employeeButton.addActionListener(employee);

		add(employeeButton);
		add(employerButton);
		
		repaint();
	}
	
	//displays the employer page
	public void employerPage() {
		removeAll();
		revalidate(); 
		
		employerEvaluateButton = new JButton("Evaluate All Submitted Applications");
		buttonListenerEmployerEvaluate eval = new buttonListenerEmployerEvaluate();
		employerEvaluateButton.addActionListener(eval);
		
		add(employerEvaluateButton);
		
		JButton employerButton = new JButton("Employer Page");
		buttonListenerEmployer employer = new buttonListenerEmployer();
		employerButton.addActionListener(employer);
		JButton employeeButton = new JButton("Employee Page");
		buttonListenerEmployee employee = new buttonListenerEmployee();
		employeeButton.addActionListener(employee);

		add(employeeButton);
		add(employerButton);
		
		repaint();
	}
	
	//returns the employer page with evaluated apps added as a label list
	public void returnEmployerPage() throws ListFullException {
		removeAll();
		revalidate(); 
		
		Application[] array = as.evaluateApps();
		System.out.println(array);
		System.out.println(as.printChosenApps());
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] == null) break;
			System.out.println(array[i]);
			l1 = new JLabel("Application " + array[i].appNum + "\n" 
					+ "    Name: " + array[i].name + "\n" 
					+ "    Why: " + array[i].whyYouWantThisJob + "\n"
					+ "    What: " + array[i].whatMakesYouQualified + "\n"
					+ "    When: " + array[i].whenToStart + "\n"
					+ "    Experience: " + array[i].yearsOfPrevExp + "\n"
					+ "    References: " + array[i].size);
			add(l1);
		}
		
		JButton employerButton = new JButton("Employer Page");
		buttonListenerEmployer employer = new buttonListenerEmployer();
		employerButton.addActionListener(employer);
		JButton employeeButton = new JButton("Employee Page");
		buttonListenerEmployee employee = new buttonListenerEmployee();
		employeeButton.addActionListener(employee);

		add(employeeButton);
		add(employerButton);
		
		repaint();
	}
	
	//submit application to ApplicationSorter, returns to employee page
	class buttonListenerSubmit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (tf1.getText() != null) {
				newApp.name = tf1.getText();
				newApp.whyYouWantThisJob = tf2.getText();
				newApp.whatMakesYouQualified = tf3.getText();
				newApp.whenToStart = tf4.getText();
			    try {
			        int exp = Integer.parseInt(tf5.getText());
			        newApp.yearsOfPrevExp = exp;
			    } catch (final NumberFormatException ex) {
			    	newApp.yearsOfPrevExp = 0;
			    }
			    as.createApp(newApp);
			}
		    
		    employeePage();
		}
	}
	
	//saved input text to newApp, returns to ref page
	class buttonListenerRef implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			newApp.name = tf1.getText();
			newApp.whyYouWantThisJob = tf2.getText();
			newApp.whatMakesYouQualified = tf3.getText();
			newApp.whenToStart = tf4.getText();
		    try {
		        int exp = Integer.parseInt(tf5.getText());
		        newApp.yearsOfPrevExp = exp;
		    } catch (final NumberFormatException ex) {
		    	newApp.yearsOfPrevExp = 0;
		    }
			refPage();
		}
	}
	
	//cancels the reference, calls return employee page
	class buttonListenerRefCancel implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			returnEmployeePage();
		}
	}
	
	//submits reference to ApplicationSorter, calls return employee page
	class buttonListenerRefSubmit implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tf1.getText() != null) {
				Reference newRef = new Reference();
				newRef.name = tf1.getText();
				newRef.relationship = tf2.getText();
				newRef.phoneNum = tf3.getText();
				newApp.addReference(newRef);
			}
			returnEmployeePage();
		}
	}
	
	//calls return employer page
	class buttonListenerEmployerEvaluate implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				returnEmployerPage();
			} catch (ListFullException ex) {
				// TODO Auto-generated catch block
				System.out.println("Too many applications");
			}
		}
	}
	
	//calls employer page
	class buttonListenerEmployer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			employerPage();
		}
	}
	
	//calls employee page
	class buttonListenerEmployee implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			employeePage();
		}
	}
}
