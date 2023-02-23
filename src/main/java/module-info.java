module com.mycompany.orcasimples {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens com.mycompany.orcasimples to javafx.fxml;
    exports com.mycompany.orcasimples;
}
    
