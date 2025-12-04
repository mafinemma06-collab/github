module mainpackage.newspaperprintonline {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpackage.newspaperprintonline to javafx.fxml;
    exports mainpackage.newspaperprintonline;

    opens Mafin.Photographer to javafx.fxml;
    exports Mafin.Photographer;

    opens Mafin.Reader to javafx.fxml;
    exports Mafin.Reader;
}