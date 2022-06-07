package org.in5bm.davidquiñonez.eldrickhernandez.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import org.in5bm.davidquiñonez.eldrickhernandez.models.Cursos;

/**
 *
 * @author informatica
 */
public class CursosController implements Initializable {

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
    private ImageView imgReporte;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombreCursos;
    @FXML
    private Spinner<?> spnCiclo;
    @FXML
    private Spinner<?> spnCupoMaximo;
    @FXML
    private Spinner<?> spnCupoMinimo;
    @FXML
    private ComboBox<?> cmbCarreraTecnica;
    @FXML
    private ComboBox<?> cmbHorarios;
    @FXML
    private ComboBox<?> cmbInstructor;
    @FXML
    private TableView<Cursos> tblCursos;
    @FXML
    private TableColumn<?, ?> colCarne;
    @FXML
    private TableColumn<?, ?> colNombre1;
    @FXML
    private TableColumn<?, ?> colNombre2;
    @FXML
    private TableColumn<?, ?> colNombre3;
    @FXML
    private TableColumn<?, ?> colApellido1;
    @FXML
    private TableColumn<?, ?> colApellido2;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void seleccionarElemento(KeyEvent event) {
    }

    @FXML
    private void clicRegresar(MouseEvent event) {
    }

}
