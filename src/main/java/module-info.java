module org.crud.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires jakarta.persistence; // Mantido para compatibilidade JPA// Permitir acesso ao JavaFX para refletir as classes
    requires org.hibernate.orm.core; // Hibernate ORM Core
    exports org.crud.demo;
    opens org.crud.demo;

}
