package javaFX2button;

import javafx.beans.binding.ObjectBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonController {

	@FXML
	private TextField txf01;
	@FXML
	private TextField txf02;
	@FXML
	private Button btn01;

	@FXML
	private TextField txf01HBind;
	@FXML
	private TextField txf02HBind;

	@FXML
	private TextField txf01LBind;
	@FXML
	private TextField txf02LBind;

	String cockadoodledoo = "Cock a doodle doo";

	@FXML
	void initialize() {
		// Using Event Handler
		assert txf01 != null : "fx:id=\"txf01\" was not injected: check your FXML file 'Button.fxml'.";
		assert btn01 != null : "fx:id=\"btn01\" was not injected: check your FXML file 'Button.fxml'.";
		assert txf02 != null : "fx:id=\"txf02\" was not injected: check your FXML file 'Button.fxml'.";
		this.txf01.setText(cockadoodledoo);
		this.btn01.setGraphic(new ImageView(new Image(this.getClass().getResourceAsStream("res/arrow.png"))));

		// Using Bind (High-level API)
		assert txf01HBind != null : "fx:id=\"txf01HBind\" was not injected: check your FXML file 'Button.fxml'.";
		assert txf02HBind != null : "fx:id=\"txf02HBind\" was not injected: check your FXML file 'Button.fxml'.";
		this.txf02HBind.textProperty().bind(this.txf01HBind.textProperty());
		this.txf01HBind.setText(cockadoodledoo);

		// Using Bind (Low-level API)
		assert txf01LBind != null : "fx:id=\"txf01LBind\" was not injected: check your FXML file 'Button.fxml'.";
		assert txf02LBind != null : "fx:id=\"txf02LBind\" was not injected: check your FXML file 'Button.fxml'.";
		this.txf02LBind.textProperty().bind(this.observer(txf01LBind));
		this.txf01LBind.setText(cockadoodledoo);
	}

	// Using Event Handler
	@FXML
	void btn01OnAction(ActionEvent event) {
		this.txf02.setText(this.txf01.getText().toUpperCase());
	}

	// Using Bind (High-level API)

	// Using Bind (Low-level API)
	private ObjectBinding<String> observer(TextField p) {
		final TextField txf = p;
		ObjectBinding<String> sBinding = new ObjectBinding<String>() {
			{
				super.bind(txf.textProperty());
			}

			@Override
			protected String computeValue() {
				return txf.getText().toUpperCase();
			}
		};
		return sBinding;
	}

}
