module com.mycompany.orcasimples {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens com.mycompany.orcasimples to javafx.fxml;
    opens com.mycompany.orcasimples.controllers to javafx.fxml;
    exports com.mycompany.orcasimples;
}
    
