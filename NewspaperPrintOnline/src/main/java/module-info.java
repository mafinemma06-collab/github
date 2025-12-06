module mainpackage.newspaperprintonline {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;



    //requires mainpackage.newspaperprintonline;


    opens mainpackage.newspaperprintonline to javafx.fxml;
    exports mainpackage.newspaperprintonline;

    opens Mafin.Publisher to javafx.fxml;
    exports Mafin.Publisher;

    opens Mafin.Reader to javafx.fxml;
    exports Mafin.Reader;
}