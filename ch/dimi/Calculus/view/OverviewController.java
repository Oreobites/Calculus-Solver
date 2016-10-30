//박규남
package ch.dimi.Calculus.view;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import ch.dimi.Calculus.util.CalculatorMain;

public class OverviewController {
	
	//그래프 부분
	@FXML private NumberAxis xAxis;
	@FXML private NumberAxis yAxis;
	@FXML private AreaChart<Number, Number> areaChart;
	
	//결과 출력 부분
	@FXML private Label functionIn;
	@FXML private Label functionOut;
	@FXML private Label resultOut;
	
	//적분 부분
	@FXML private TextField integralFrom;
	@FXML private TextField integralUntil;
	@FXML private TextField integralInput;
	
	//미분 부분
	@FXML private TextField diffValue;
	@FXML private TextField diffInput;

	//버튼
	@FXML private Button integralCalc;
	@FXML private Button diffCalc;
	
	@FXML private Button function_ex;
	@FXML private Button function_lnx;
	@FXML private Button function_sinx;
	@FXML private Button function_cosx;
	@FXML private Button function_tanx;
	
	@FXML private Button input_xn;
	@FXML private Button input_e;
	
	private boolean wasIntegralSelected = true;
	
	@FXML private void initialize() {
		functionIn.setText("Input Needed");
		functionOut.setText("Input Needed");
		resultOut.setText("Input Needed");
	}
	
	@FXML private void handleIntegralCalc() {
		int from = Integer.parseInt(this.integralFrom.getText());
		int until = Integer.parseInt(this.integralUntil.getText());
		String func = this.integralInput.getText();
		
		//미분 함수 연동
		CalculatorMain calculator = new CalculatorMain();
		calculator.integral(func);
		
		//입력된 함수와 적분된 함수를 화면에 표기
		functionIn.setText(func + " (Integral)");
		functionOut.setText(calculator.getProcessedFunction());
		resultOut.setText( Double.toString( calculator.getIntegraledValue(from, until) ) );
		
		//그래프 업데이트
		updateGraph();
	}
	
	@FXML private void handleDiffCalc() {
		System.out.println("미분 버튼 클릭됨");
		
		int value = Integer.parseInt(this.diffValue.getText());
		String func = this.diffInput.getText();
		func = func.trim();
		
		System.out.println("미분 칸에 입력받은 함수 : " + func);
		System.out.println("미분 칸에 입력받은 값 : " + value);
		
		// 미분 함수 연동
		CalculatorMain calculator = new CalculatorMain();
		calculator.differential(func);

		// 입력된 함수와 적분된 함수를 화면에 표기
		functionIn.setText(func + " (Differential)");
		functionOut.setText(calculator.getProcessedFunction());
		resultOut.setText( Double.toString( calculator.getDifferentialedValue(value) ) );

		// 그래프는 적분할 때만 표시 및 업데이트
		// updateGraph();
	}
	
	private void updateGraph() {	
		areaChart.setVisible(false);
		areaChart.getData().clear();
		setDataForArea();
		areaChart.setVisible(true);
	}

	public void setDataForArea() {

		int from = Integer.parseInt(this.integralFrom.getText());
		int until = Integer.parseInt(this.integralUntil.getText());
		
		XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
		dataSeries.setName("Values");
		
		for (double i = from; i <= until ; i += 0.1) {
			dataSeries.getData().add(new XYChart.Data<>(i, getValueFromFunction(i)));
		}
		
		areaChart.getData().add(dataSeries);
		areaChart.setLegendVisible(false);
		areaChart.setCreateSymbols(false);

		//xAxis.setAutoRanging(true);	
		xAxis.setUpperBound(until);
		xAxis.setLowerBound(from);
		
	}
	
	public double getValueFromFunction(double value) {
		double valueOut;
		
		//TODO 함수값 제공 연동
		CalculatorMain calculator = new CalculatorMain();
		valueOut = calculator.getSpecificValue(value);
		
		return valueOut;
	}
	
	private void addToInputAndFocus(String str) {
		if (wasIntegralSelected) {
			integralInput.setText(integralInput.getText() + str);
			integralInput.requestFocus();
			integralInput.selectRange(integralInput.getLength(), integralInput.getLength());
		} else {
			diffInput.setText(diffInput.getText() + str);
			diffInput.requestFocus();
			diffInput.selectRange(diffInput.getLength(), diffInput.getLength());
		}
	}
	
	@FXML private void handleClickIntegralInput() {
		wasIntegralSelected = true;
	}
	
	@FXML private void handleClickDiffInput() {
		wasIntegralSelected = false;
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
