package lydia.porter.chThirteen.One;
//Text and number input
//Lydia Porter
//Jan 5, 2020   

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ch13_1exe implements ActionListener,ChangeListener{
	JFrame frame;
	JPanel contentPane;
	JTextField firstName;
	JTextField lastName;
	JButton my_btn;
	JTextArea description;
	JSpinner ageSpinner;
	JOptionPane messageBox;
	String favList[] = {"piano", "HP#3","HP#4","GG #6","java","GG #5", "100 Days","videomaking","beachwaver","Reese's","chocolate pretzels","chocolate","bike","HP#2","HP#1"};
	//in positions. you must do this here and this is the order you're making
	//FIFO stack, not a line. data structure: queue
	//stack: last in first out
	
	int index = 0;
	JScrollPane glistScrollPane;
	JComboBox cBtestBox;
	
	public Ch13_1exe() { //CONSTRUCTOR!
		String[][]testArray = new String[3][3]; //block with 3 rows, 3 columns
		testArray[1][1] = "middle";
		String[][][]testArray3 = new String[3][3][3]; //3D. these ones are better to do with a database
		String[][][][]testArray4 = new String[3][3][3][3]; //4D
		
		//fav list array so you don't have to make separate strings for each.
		//String[] OR favList[]
		//remember that the computer starts counting at 0
		//arrays take up a lot less space than variables.
		
		frame = new JFrame();
		contentPane = (JPanel)frame.getContentPane();
		FlowLayout flow = new FlowLayout();
		contentPane.setLayout(flow);
		BoxLayout box = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
		contentPane.setLayout(box);
		
		frame.setTitle("Message Dialog Gui");
		frame.setSize(800,500);
		frame.setLocation(0,0); //top left corner
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		firstName = new JTextField(20); //pass in number of characters you expect
		lastName = new JTextField();
		
		description = new JTextArea(5,20);
		description.setLineWrap(false);
		description.setText(favList[0]); //first thing is added into the description box
		
		JScrollPane scrollbar = new JScrollPane(description,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ageSpinner = new JSpinner (new SpinnerNumberModel(0.1,0,1,0.00001));
		ageSpinner.addChangeListener(this);
	
		
		JList favGames = new JList(favList); //must pass in an array into a JList
		favGames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //only select one (single)
		glistScrollPane = new JScrollPane(favGames,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //(where you want it to be added to,etc.)
		//favGames.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //choose multiple regardless of where they are located; DEFAULT
		//favGames.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //choose multiple items if they're next to each other
		favGames.setSelectedIndex(1); //which one is "default" selected but you can still change it
		cBtestBox = new JComboBox(favList);
		cBtestBox.setEditable(true);//you can type in it now
	//	cBtestBox.setSelectedItem("piano");
		//cBtestBox.setSelected
		
		//ADD THEM! 
		//the order you add these affects where they will pop up because it's flow layout
		contentPane.add(new JLabel("First Name:")); //anonymous class
		contentPane.add(firstName);
		contentPane.add(new JLabel("Last Name:")); 
		contentPane.add(lastName);
		contentPane.add(new JLabel ("description"));
		contentPane.add(cBtestBox);
		contentPane.add(description);
		
		contentPane.add(scrollbar);
		//contentPane.add(favGames); //now you can select a favorite
		contentPane.add(new JLabel("age"));
		contentPane.add(ageSpinner);
		
		contentPane.add(glistScrollPane);
		//contentPane.add(deswithScrollBar);
		
		my_btn = new JButton("submit");
		contentPane.add(my_btn);
		my_btn.addActionListener(this);
		
		frame.pack();		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Ch13_1exe();
	}

	@Override
	public void actionPerformed(ActionEvent e) { //WHEN BUTTON IS CLICKED, DO THE FOLLOWING (depending on which button):
		Object control = e.getSource();
		
		if (control == my_btn) {
			index++;
			description.setText(favList[index]);
			String fName = firstName.getText();
			String lName = lastName.getText();
			String dText = description.getText();
			//JOptionPane.showMessageDialog(frame, "Hello "+fName+" "+lName"\n"+desText);
			//glistScrollPane.getSelectedValueList();
			cBtestBox.addItem(fName);
			cBtestBox.addItem(lName);
			//cBtestBox.addItem(desText);
			String selected = (String)cBtestBox.getSelectedItem();
			//converted
			firstName.setText(selected);
		}
		else {
			messageBox = new JOptionPane();
			String title = messageBox.showInputDialog(frame,"Enter your title: ","Your Color",JOptionPane.WARNING_MESSAGE); 
			String color = messageBox.showInputDialog(frame,"Enter your favorite color: ",JOptionPane.WARNING_MESSAGE); 
			JOptionPane.showMessageDialog(null, "So, I hear you like the color "+color+".");
		}
		
		//so when you click the button it should pop up a message box that takes input. Nice! always stores a string
		//message box pops up holding/showing the result/input
	}

	@Override
	public void stateChanged(ChangeEvent e) { //age spinner
		//now you can do something every time age changes
		//String result = messageBox.showInputDialog("Are you sure you are that old?");
		int userAge = (Integer)ageSpinner.getValue(); //converts to object Integer
		int targetAge = 25;
		if (userAge < targetAge) {
			int toTargetAge = targetAge - userAge;
			JOptionPane.showMessageDialog(frame, "You are "+toTargetAge+" years from the target age.");
		}
		else {
			JOptionPane.showMessageDialog(frame, "Wow, you're old!");
		}
		
	}
}
