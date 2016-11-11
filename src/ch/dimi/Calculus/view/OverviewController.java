//�ڱԳ�
package ch.dimi.Calculus.view;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import ch.dimi.Calculus.util.CalculatorMain;

public class OverviewController {
	
	//�׷��� �κ�
	@FXML private NumberAxis xAxis;
	@FXML private NumberAxis yAxis;
	@FXML private AreaChart<Number, Number> areaChart;
	
	//��� ��� �κ�
	@FXML private Label functionIn;
	@FXML private Label functionOut;
	@FXML private Label resultOut;
	
	//���� �κ�
	@FXML private TextField integralFrom;
	@FXML private TextField integralUntil;
	@FXML private TextField integralInput;
	
	//�̺� �κ�
	@FXML private TextField diffValue;
	@FXML private TextField diffInput;

	//��ư
	@FXML private Button integralCalc;
	@FXML private Button diffCalc;
	
	@FXML private Button function_ex;
	@FXML private Button function_nx;
	@FXML private Button function_sinx;
	@FXML private Button function_cosx;
	@FXML private Button function_tanx;
	
	@FXML private Button input_xn;
	@FXML private Button input_e;
	
	private boolean wasIntegralSelected = true;
	CalculatorMain calc = new CalculatorMain();
	
	@FXML private void initialize() {
		functionIn.setText("Input Needed");
		functionOut.setText("Input Needed");
		resultOut.setText("Input Needed");
	}
	
	@FXML private void handleIntegralCalc() {
		int from = Integer.parseInt(this.integralFrom.getText());
		int until = Integer.parseInt(this.integralUntil.getText());
		String func = this.integralInput.getText();
		System.out.println("func : " + func);
		
		//�̺� �Լ� ����
		CalculatorMain calculator = new CalculatorMain();
		calculator.integral(func);
		this.calc = calculator;
		
		//�Էµ� �Լ��� ���е� �Լ��� ȭ�鿡 ǥ��
		functionIn.setText(func + " (Integral)");
		functionOut.setText(calculator.getProcessedFunction());
		resultOut.setText( Double.toString( calculator.getIntegraledValue(from, until) ) );
		
		//�׷��� ������Ʈ
		updateGraph();
	}
	
	@FXML private void handleDiffCalc() {
		System.out.println("�̺� ��ư Ŭ����");
		
		int value = Integer.parseInt(this.diffValue.getText());
		String func = this.diffInput.getText();
		func = func.trim();
		
		System.out.println("�̺� ĭ�� �Է¹��� �Լ� : " + func);
		System.out.println("�̺� ĭ�� �Է¹��� �� : " + value);
		
		// �̺� �Լ� ����
		CalculatorMain calculator = new CalculatorMain();
		calculator.differential(func);
		this.calc = calculator;
		
		// �Էµ� �Լ��� ���е� �Լ��� ȭ�鿡 ǥ��
		functionIn.setText(func + " (Differential)");
		functionOut.setText(calc.getProcessedFunction());
		resultOut.setText( Double.toString( calc.getProcessedSpecificValue(value) ) );

		// �׷����� ������ ���� ǥ�� �� ������Ʈ
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
			dataSeries.getData().add(new XYChart.Data<>(i, getValueFromOriginalFunction(i)));
		}
		
		areaChart.getData().add(dataSeries);
		areaChart.setLegendVisible(false);
		areaChart.setCreateSymbols(false);

		//xAxis.setAutoRanging(true);	
		xAxis.setUpperBound(until);
		xAxis.setLowerBound(from);
		
	}
	
	public double getValueFromOriginalFunction(double value) {
		double valueOut = 0;
		
		String func = this.integralInput.getText();
		CalculatorMain calcGraph = new CalculatorMain();
		calcGraph.differential(func); //�� ���Ը� ����ϹǷ� Differential�̳� Integral �� �� �ƹ� �Լ��� �������.
		valueOut = calc.getOriginalSpecificValue(value);
		
		
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
	
	@FXML private void handleFunction_nx() {
		addToInputAndFocus("n^x");
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
