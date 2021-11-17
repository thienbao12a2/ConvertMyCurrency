import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ConvertMyCurrency extends JFrame implements ActionListener  {
   private ButtonGroup checkBoxGroup;
   JCheckBox rupee, usd, pound;
   private JPanel panel;
    private final JLabel result, error, result2;
   JTextField txt; 
   JButton button = new JButton("Convert");	
   DecimalFormat f = new DecimalFormat("##.##");
   
   public Check() {
      
	  super("Currency Converer");
      JLabel title = new JLabel("Test");
	  
	  panel = new JPanel(new GridLayout(10,0));
      
	  result = new JLabel();
	  result2 = new JLabel();
	  
      error = new JLabel();
	   
	   txt=new JTextField();    
	   
	  title.setText("Please Select Currency\n");
	  
	  rupee = new JCheckBox("Rupee", false);
      usd = new JCheckBox("USD", false);
      pound = new JCheckBox("Pound", false);
      checkBoxGroup = new ButtonGroup();
      //add CheckBoxes to ButtonGroup
      
	  
	  
	  checkBoxGroup.add(rupee);
      checkBoxGroup.add(usd);
      checkBoxGroup.add(pound);
	  panel.add(error);
	  panel.add(txt); 
	  panel.add(title);
      panel.add(rupee);
      panel.add(usd);
      panel.add(pound);
	  panel.add(button);
	  button.addActionListener(this); 
	  panel.add(result);
	  panel.add(result2);
      add(panel);
      setSize(375, 250);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
	
	
   public void actionPerformed(ActionEvent e){
        
		if (txt.getText().equals("")){
			error.setText(("Please Enter Amount"));
			 
		}else if(!pound.isSelected() && !rupee.isSelected() && !usd.isSelected())
		{
			error.setText(("Please Select Currency"));
		}
		else{
			if(checkBoxGroup.getSelection().equals(pound.getModel())) {
				if (e.getSource() == button) {
				   double amount = Double.parseDouble(txt.getText()); //perform your operation
				   double rupees = amount*218;
				   double dollars  = amount*1.34;
				   
				   result.setText(("Your amount " + amount + " is " + f.format(dollars) + " in Dollar \n"));
				   result2.setText(("Your amount " + amount + " is " + f.format(rupees) + " in Rupee"));
				}
			}
			else if(checkBoxGroup.getSelection().equals(usd.getModel())) {
				if (e.getSource() == button) {
				   double amount = Double.parseDouble(txt.getText()); //perform your operation
				   double pounds = amount/1.34;
				   double rupees  = amount*170;
				   
				   result.setText(("Your amount " + amount + " is " + f.format(pounds) + " in Pound \n"));
				   result2.setText(("Your amount " + amount + " is " + f.format(rupees) + " in Rupee"));
				}
			}
			else if(checkBoxGroup.getSelection().equals(rupee.getModel())) {
				if (e.getSource() == button) {
				   double amount = Double.parseDouble(txt.getText()); //perform your operation 
				   double dollars = amount*170;
				   double pounds  = amount*218;
				   result.setText(("Your amount " + amount + " is " + f.format(dollars) + " in Dollar \n"));
				   result2.setText(("Your amount " + amount + " is " + f.format(pounds) + " in Pound"));
				}
			}
		}
		
		
		
    }

   public static void main(String args[]) {
      new Check();
   }
}
