module fr.ensisa.alt.presence {
	requires javafx.controls;
	requires javafx.fxml;

	requires com.dlsc.formsfx;

	opens fr.ensisa.alt.presence to javafx.fxml;
	exports fr.ensisa.alt.presence;
}