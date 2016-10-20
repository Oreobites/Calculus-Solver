package ch.dimi.Calculus.view;

import ch.dimi.Calculus.MainApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OverviewController {
	
	@FXML private Label functionIn;
	@FXML private Label functionOut;
	@FXML private Label resultOut;
	
	@FXML private RadioButton inputModeIntegral;
	@FXML private RadioButton inputModeDiff;
	
	@FXML private TextField integralFrom;
	@FXML private TextField integralUntil;
	@FXML private TextField integralInput;
	
	@FXML private TextField diffValue;
	@FXML private TextField diffInput;
	
	@FXML private Button integralCalc;
	@FXML private Button diffCalc;
	
	@FXML private Button function_ex;
	@FXML private Button function_lnx;
	@FXML private Button function_sinx;
	@FXML private Button function_cosx;
	@FXML private Button function_tanx;
	
	@FXML private Button input_xn;
	@FXML private Button input_e;
	
	@FXML final ToggleGroup group = new ToggleGroup();
	
	private boolean isInputModeIntegral = true;
	
	@FXML private void initialize() {

		functionIn.setText("Input Needed");
		functionOut.setText("Input Needed");
		resultOut.setText("Input Needed");
		
		//RadioButton 관련
		inputModeIntegral.setToggleGroup(group);
		inputModeDiff.setToggleGroup(group);
		inputModeIntegral.setSelected(true);	
		
	}
	
	@FXML private void handleInputModeIntegral() {
		isInputModeIntegral = true;
	}
	
	@FXML private void handleInputModeDiff() {
		isInputModeIntegral = false;
	}
	
	@FXML private void handleIntegralCalc() {
		int from = Integer.parseInt(this.integralFrom.getText());
		int until = Integer.parseInt(this.integralUntil.getText());
		String func = this.integralInput.getText();
		
		functionIn.setText(func + "; Integral");
		
		//TODO 미분 함수 연동
		//integral(func, from, until);
		
	}
	

	
	@FXML private void handleDiffCalc() {
		int value = Integer.parseInt(this.diffValue.getText());
		String func = this.diffInput.getText();
		
		functionIn.setText(func + "; Differential");
		//TODO 적분 함수 연동
		//differential(func, value);
	
	}
	
	private void addToInputAndFocus(String str) {
		if (isInputModeIntegral) {
			integralInput.setText(integralInput.getText() + str);
			integralInput.requestFocus();
			integralInput.selectRange(integralInput.getLength(), integralInput.getLength());
		}
		else {
			diffInput.setText(diffInput.getText() + str);
			diffInput.requestFocus();
			diffInput.selectRange(integralInput.getLength(), integralInput.getLength());
		}
	}
	
	@FXML private void handleFunction_ex() {
		addToInputAndFocus("e^x");
	}
	
	@FXML private void handleFunction_lnx() {
		addToInputAndFocus("ln x");
	}
	
	@FXML private void handleFunction_sinx() {
		addToInputAndFocus("sin x");
	}
	
	@FXML private void handleFunction_cosx() {
		addToInputAndFocus("cos x");
	}
	
	@FXML private void handleFunction_tanx() {
		addToInputAndFocus("tan x");
	}
	
	@FXML private void handleInput_xn() {
		addToInputAndFocus("x^");
	}
	
	@FXML private void handleInput_e() {
		addToInputAndFocus("e");
	}
	
	public OverviewController() {
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
