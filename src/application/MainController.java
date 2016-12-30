package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label result;
	private float number1 = 0;
	private String operator = "";
	private boolean start = true;
	private float output = 0;
	private Model model = new Model();
	@FXML
	public void processNumbers(ActionEvent event){	
		if(start){
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+value);
	}
	@FXML
	public void processOperators(ActionEvent event){
		if(start){
			if(((Button)event.getSource()).getText().equals("CLEAR") || operator.isEmpty()){
				operator = "";
				number1 = 0;
				start = true;
				result.setText("0.0");
				return;
			}
			else{
				operator = ((Button)event.getSource()).getText();
				number1 =  output;
				start = false;
				result.setText("");
			}
		}
		String value = ((Button)event.getSource()).getText();
		if (!value.equals("=")) {
			if(!operator.isEmpty())
				return ;
		operator = value;
		number1 = Float.parseFloat(result.getText());
		result.setText("");
		
		}else{
			if(operator.isEmpty())
				return;
			float number2  = Float.parseFloat(result.getText());
			output =  model.calculate(number1, number2, operator);		
			
			result.setText(String.valueOf(output));
			start = true;
		}
	}

}
