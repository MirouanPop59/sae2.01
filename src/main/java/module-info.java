module org.uphf.sae {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.uphf.sae to javafx.fxml;
    exports org.uphf.sae;
}