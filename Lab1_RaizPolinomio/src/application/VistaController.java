package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class VistaController {
	@FXML
	 private GridPane gp;
	@FXML
	 private TextField amountCoefficent;
	@FXML
	private TextField[] coefficent;
	@FXML
	private Label[] exponent;
	@FXML
	private Button calculate;

	private Main m;
	public VistaController() {
		m=new Main();
	}
	
	// segundo Lo que hace es que despues de que se hayan creado los arreglos de textfield y labels lo agrega al gridlayout y los muestra
	 //pre amountCoefficent es diferente de null && >=10

	
	 public void showPolynomial() {
		 	 
		 int size=Integer.parseInt(amountCoefficent.getText())+1;
		 coefficent=new TextField[size];
		 for (int i = 0; i < size; i++) {
			 gp.add(exponent[i],i,0);	 
			 gp.add(coefficent[i]=new TextField(),i,1);	 

		}
		 calculate.setVisible(true);
	 }
	 
	 
	 //primero entra aqui. lo que hace es que depenciendo del numero que ingresa el usuario crea los esponentes y los textfield
	 //Pos amountCoefficent debe ser diferente de null && >=10
	 
	 public void amountCoefficent() {
		 gp.getChildren().clear();
		 int size=Integer.parseInt(amountCoefficent.getText())+1;
		 if(size<=11) {
		 exponent=new Label[size];
		 for (int i = 0; i < size; i++) {
				exponent[i]=new Label("x^"+(i));
		}
		 showPolynomial();
	 }
		 else {
			 messageAlert("El maximo de exponentes es hasta 10");
		 }
		 
	 }
	 
	 
	 
	 
	 //tercero luego de que el usuario escriba el polinomio lo calcula
	 
	public void calculatePolynomial() {
		double[] c=new double[ coefficent.length];
		for (int i = 0; i < coefficent.length; i++) {
			if(coefficent[i]==null) {
				c[i]=0;
			}
			else {
			
				c[i]=Double.parseDouble(coefficent[i].getText());
			}
		}
		m.addPolynomial(c);
		m.getPolynomial().Bairstow();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(m.getPolynomial().getRoots());
		alert.showAndWait();
		amountCoefficent.clear();
		
	}
	
	//mensaje de alerta en caso de que escriba mas de 10 expoentes
	public void messageAlert(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(message);
		alert.showAndWait();
		amountCoefficent.clear();
	}
	
	
	
	
}
