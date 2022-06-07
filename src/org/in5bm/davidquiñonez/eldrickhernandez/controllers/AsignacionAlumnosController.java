package org.in5bm.davidquiñonez.eldrickhernandez.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.in5bm.davidquiñonez.eldrickhernandez.system.Principal;
import org.in5bm.davidquiñonez.eldrickhernandez.models.AsignacionesAlumnos;
import org.in5bm.davidquiñonez.eldrickhernandez.models.Alumnos;
import org.in5bm.davidquiñonez.eldrickhernandez.models.Cursos;


/**
 *
 * @author informatica
 */
public class AsignacionAlumnosController implements Initializable {

    private Principal escenarioPrincipal;

    @FXML
    private Button btnNuevo;
    @FXML
    private ImageView imgNuevo;
    @FXML
    private Button btnModificar;
    @FXML
    private ImageView imgModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private ImageView imgEliminar;
    @FXML
    private Button btnReporte;
    @FXML
    private TextField txtId;
    @FXML
    private DatePicker dpFechaAsignacion;
    @FXML
    private TableView<AsignacionesAlumnos> tblAsignacionAlumnos;
    @FXML
    private TableColumn<AsignacionesAlumnos, Integer> colid;
    @FXML
    private TableColumn<AsignacionesAlumnos, String> colCarne;
    @FXML
    private TableColumn<Alumnos, String> colNombreAlumno;
    @FXML
    private TableColumn<Cursos, String> ColCursos;
    @FXML
    private TableColumn<AsignacionesAlumnos, LocalDate> colFechaAsignacion;
    @FXML
    private ComboBox<Alumnos> cmbAlumno;
    @FXML
    private ComboBox<Cursos> cmbIdCursos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    @FXML
    private void clicNuevo(ActionEvent event) {
    }

    @FXML
    private void clicModificar(ActionEvent event) {
    }

    @FXML
    private void clicEliminar(ActionEvent event) {
    }

    @FXML
    private void clicReporte(ActionEvent event) {
    }

    @FXML
    private void seleccionarElemento(MouseEvent event) {
    }

    @FXML
    private void clicRegresar(MouseEvent event) {
    }

}
