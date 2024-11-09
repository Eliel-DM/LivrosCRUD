module org.aluguelcarros {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.xml.crypto;
    requires java.desktop;

    opens org.aluguelcarros to javafx.fxml;
    exports org.aluguelcarros;
    exports org.aluguelcarros.controller;
    opens org.aluguelcarros.controller to javafx.fxml;
}