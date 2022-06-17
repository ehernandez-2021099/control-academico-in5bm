 package org.in5bm.davidquiñonez.eldrickhernandez.controllers;

import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.in5bm.davidquiñonez.eldrickhernandez.db.Conexion;
import org.in5bm.davidquiñonez.eldrickhernandez.models.Instructores;
import org.in5bm.davidquiñonez.eldrickhernandez.system.Principal;

/**
 *
 * @author David - Eldrick
 * @date 26 abr. 2022
 * @time 8:32:00
 *
 * Código Técnico: IN5BM
 */
public class InstructoresController implements Initializable {

    private enum Operacion {
        NINGUNO, GUARDAR, ACTUALIZAR
    }

    Instructores instructores = new Instructores();

    private final String PAQUETE_IMAGES = "org/in5bm/davidquiñonez/eldrickhernandez/resources/images/";

    private Operacion operacion = Operacion.NINGUNO;
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
    private ImageView imgReporte;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre1;
    @FXML
    private TextField txtNombre3;
    @FXML
    private TextField txtApellido1;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtApellido2;
    @FXML
    private TextField txtNombre2;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefono;
    @FXML
    private JFXDatePicker dpFechaNacimiento;
    @FXML
    private TableView<Instructores> tblInstructores;
    @FXML
    private TableColumn<Instructores, Integer> colId;
    @FXML
    private TableColumn<Instructores, String> colNombre1;
    @FXML
    private TableColumn<Instructores, String> colNombre2;
    @FXML
    private TableColumn<Instructores, String> colNombre3;
    @FXML
    private TableColumn<Instructores, String> colApellido1;
    @FXML
    private TableColumn<Instructores, String> colApellido2;
    @FXML
    private TableColumn<Instructores, String> colDireccion;
    @FXML
    private TableColumn<Instructores, String> colEmail;
    @FXML
    private TableColumn<Instructores, String> colTelefono;
    @FXML
    private TableColumn<Instructores, String> colFechaNacimiento;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cargarDatos();
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    //DESHABILITAR CAMPOS
    private void deshabilitarCampos() {
        txtId.setDisable(true);
        txtNombre1.setDisable(false);
        txtNombre2.setDisable(false);
        txtNombre3.setDisable(false);
        txtApellido1.setDisable(false);
        txtApellido2.setDisable(false);
        txtEmail.setDisable(false);
        txtDireccion.setDisable(false);
        txtTelefono.setDisable(false);
        dpFechaNacimiento.setDisable(false);
        txtId.setEditable(false);

        txtNombre1.setEditable(true);
        txtNombre2.setEditable(true);
        txtNombre3.setEditable(true);
        txtApellido1.setEditable(true);
        txtApellido2.setEditable(true);
        txtEmail.setEditable(true);
        txtDireccion.setEditable(true);
        txtTelefono.setEditable(true);
    }

    //HABILITAR CAMPOS
    private void habilitarCampos() {
        txtId.setDisable(true);
        txtNombre1.setDisable(true);
        txtNombre2.setDisable(true);
        txtNombre3.setDisable(true);
        txtApellido1.setDisable(true);
        txtApellido2.setDisable(true);
        txtEmail.setDisable(true);
        txtDireccion.setDisable(true);
        txtTelefono.setDisable(true);
        dpFechaNacimiento.setDisable(true);

        txtId.setEditable(false);
        txtNombre1.setEditable(false);
        txtNombre2.setEditable(false);
        txtNombre3.setEditable(false);
        txtApellido1.setEditable(false);
        txtApellido2.setEditable(false);
        txtEmail.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
    }

    //LIMPIAR CAMPOS
    private void limpiarCampos() {
        txtId.clear();
        txtNombre1.clear();
        txtNombre2.clear();
        txtNombre3.clear();
        txtApellido1.clear();
        txtApellido2.clear();
        txtDireccion.clear();
        txtEmail.clear();
        txtTelefono.clear();
        dpFechaNacimiento.setValue(null);
    }

    private ObservableList<Instructores> listaInstructor = FXCollections.observableArrayList();

    public boolean agregarInstructores() {

        Instructores instructor = new Instructores();

        instructor.setNombre1(txtNombre1.getText());
        instructor.setNombre2(txtNombre2.getText());
        instructor.setNombre3(txtNombre3.getText());
        instructor.setApellido1(txtApellido1.getText());
        instructor.setApellido2(txtApellido2.getText());
        instructor.setDireccion(txtDireccion.getText());
        instructor.setEmail(txtEmail.getText());
        instructor.setTelefono(txtTelefono.getText());
        instructor.setFechaNacimiento(Date.valueOf(dpFechaNacimiento.getValue()));
        PreparedStatement pstmt = null;
        try {

            pstmt = Conexion.getInstance().getConexion().prepareCall("{CALL sp_instructores_create (?,?,?,?,?,?,?,?,?)}");

            pstmt.setString(1, instructor.getNombre1());
            pstmt.setString(2, instructor.getNombre2());
            pstmt.setString(3, instructor.getNombre3());
            pstmt.setString(4, instructor.getApellido1());
            pstmt.setString(5, instructor.getApellido2());
            pstmt.setString(6, instructor.getDireccion());
            pstmt.setString(7, instructor.getEmail());
            pstmt.setString(8, instructor.getTelefono());
            pstmt.setDate(9, instructor.getFechaNacimiento());
            System.out.println(pstmt.toString());
            pstmt.execute();
            listaInstructor.add(instructor);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SE PRODUJO UN ERROR AL INGRESAR LOS DATOS " + instructor.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean actualizarInstructor() {
        Instructores instructor = new Instructores();
        instructor.setNombre1(txtNombre1.getText());
        instructor.setNombre2(txtNombre2.getText());
        instructor.setNombre3(txtNombre3.getText());
        instructor.setApellido1(txtApellido1.getText());
        instructor.setApellido2(txtApellido2.getText());
        instructor.setDireccion(txtDireccion.getText());
        instructor.setEmail(txtEmail.getText());
        instructor.setTelefono(txtTelefono.getText());
        PreparedStatement pstmt = null;

        try {

            pstmt = Conexion.getInstance().getConexion().prepareCall("{CALL sp_instructores_update(?,?,?,?,?,?,?,?,?,?)}");

            pstmt.setString(1, instructor.getNombre1());
            pstmt.setString(2, instructor.getNombre2());
            pstmt.setString(3, instructor.getNombre3());
            pstmt.setString(4, instructor.getApellido1());
            pstmt.setString(5, instructor.getApellido2());
            pstmt.setString(6, instructor.getDireccion());
            pstmt.setString(7, instructor.getEmail());
            pstmt.setString(8, instructor.getTelefono());
            pstmt.setDate(9, instructor.getFechaNacimiento());
            pstmt.setInt(10, Integer.parseInt(txtId.getText()));
            pstmt.execute();
            System.out.println(pstmt.toString());

            btnNuevo.setDisable(true);
            btnReporte.setDisable(true);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //ELIMINAR ALUMNOS
    public boolean eliminarInstructores() {
        if (existeElemento()) {
            Instructores instructor = ((Instructores) tblInstructores.getSelectionModel().getSelectedItem());
            System.out.println(instructor.toString());
            PreparedStatement pstmt = null;

            try {
                pstmt = Conexion.getInstance().getConexion()
                        .prepareCall("{CALL sp_alumnos_delete(?)}");
                pstmt.setInt(1, instructor.getId());
                System.out.println(pstmt);
                pstmt.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("\nSe produjo un error al intentar eliminar el siguiente registro " + instructor.toString());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {

                    if (pstmt != null) {
                        pstmt.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public ObservableList getInstructores() {
        ArrayList<Instructores> lista = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            System.out.println("INICIANDO TRY!");
            pstmt = Conexion.getInstance().getConexion().prepareCall("CALL sp_instructores_read");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ENTRE!");
                Instructores instructores = new Instructores();
                instructores.setId(rs.getInt(1));
                instructores.setNombre1(rs.getString(2));
                instructores.setNombre2(rs.getString(3));
                instructores.setNombre3(rs.getString(4));
                instructores.setApellido1(rs.getString(5));
                instructores.setApellido2(rs.getString(6));
                instructores.setDireccion(rs.getString(7));
                instructores.setEmail(rs.getString(8));
                instructores.setTelefono(rs.getString(9));
                instructores.setFechaNacimiento(rs.getDate(10));
                lista.add(instructores);
                System.out.println(" 1 1 1 1 1 1 1 1 1 11 1 1 1 1 ");
                System.out.println(lista);
                System.out.println(" 1 1 1 1 1 1 1 1 1 11 1 1 1 1 ");
                //System.out.println(instructores.toString());

            }
            listaInstructor = FXCollections.observableArrayList(lista);
            System.out.println("SEPARADORSEPARADOR");
            System.out.println(listaInstructor);
            System.out.println("SEPARADORSEPARADOR");

        } catch (SQLException e) {
            System.err.println("\n Se produjo un error al intentar consultar la lista instructores");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaInstructor;
    }

    // EXISTE ELEMENTO
    public boolean existeElemento() {
        return ((tblInstructores.getSelectionModel().getSelectedItem() != null));
    }

    // CLIC NUEVO
    @FXML
    private void clicNuevo() {

        switch (operacion) {
            case NINGUNO:
                habilitarCampos();
                tblInstructores.setDisable(true);

                txtId.setEditable(true);
                txtId.setDisable(false);

                limpiarCampos();

                btnNuevo.setText("Guardar");
                imgNuevo.setImage(new Image(PAQUETE_IMAGES + "disco-flexible.png"));

                btnModificar.setText("Cancelar");
                imgModificar.setImage(new Image(PAQUETE_IMAGES + "icons8-cancelar-100.png"));

                btnEliminar.setDisable(true);
                btnEliminar.setVisible(false);

                btnReporte.setDisable(true);
                btnReporte.setVisible(false);

                operacion = Operacion.GUARDAR;
                break;
            case GUARDAR:

                /* if (txtId.getText().isEmpty()) {
                    validacionI();

                } else if (txtNombre1.getText().isEmpty()) {
                    validacionI();
                } else if (txtApellido1.getText().isEmpty()) {
                    validacionI();
                } else if (txtCarne.getText().length() > 7) {
                    validacionI();
                } else if (txtNombre1.getText().length() > 15) {
                    validacionI();
                } else if (txtNombre2.getText().length() > 15) {
                    validacionI();
                } else if (txtNombre3.getText().length() > 15) {
                    validacionI();
                } else if (txtApellido1.getText().length() > 15) {
                    validacionI();
                } else if (txtApellido2.getText().length() > 15) {
                    validacionI();
                } else*/ if (agregarInstructores()) {

                    cargarDatos();
                    limpiarCampos();
                    deshabilitarCampos();
                    tblInstructores.setDisable(false);

                    btnNuevo.setText("Nuevo");
                    imgNuevo.setImage(new Image(PAQUETE_IMAGES + "pagina.png"));

                    btnModificar.setText("Modificar");
                    imgModificar.setImage(new Image(PAQUETE_IMAGES + "editar.png"));

                    btnEliminar.setDisable(false);
                    btnEliminar.setVisible(true);

                    btnReporte.setDisable(false);
                    btnReporte.setVisible(true);

                    operacion = Operacion.NINGUNO;
                }

                break;
        }
    }

    // CLIC MODIFICAR
    @FXML
    private void clicModificar() {

        switch (operacion) {
            case NINGUNO:
                if (existeElemento()) {
                    habilitarCampos();
                    /*tblAlumnos.setDisable(false);*/

                    btnNuevo.setDisable(true);
                    btnNuevo.setVisible(false);

                    btnModificar.setText("Guardar");
                    imgModificar.setImage(new Image(PAQUETE_IMAGES + "disco-flexible.png"));

                    btnEliminar.setText("Cancelar");
                    imgEliminar.setImage(new Image(PAQUETE_IMAGES + "icons8-cancelar-100.png"));

                    btnReporte.setDisable(true);
                    btnReporte.setVisible(false);

                    operacion = Operacion.ACTUALIZAR;
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Control Academico - El Bosque");
                    alert.setHeaderText(null);
                    alert.setContentText("Antes de continuar selecciona un registro");
                    Stage stagee = (Stage) alert.getDialogPane().getScene().getWindow();
                    stagee.getIcons().add(new Image(PAQUETE_IMAGES + "aprender-en-linea.png"));
                    alert.show();
                }
                break;
            case GUARDAR: //Cancelar

                btnNuevo.setText("Nuevo");
                imgNuevo.setImage(new Image(PAQUETE_IMAGES + "pagina.png"));

                btnModificar.setText("Modificar");
                imgModificar.setImage(new Image(PAQUETE_IMAGES + "editar.png"));

                btnEliminar.setDisable(false);
                btnEliminar.setVisible(true);

                btnReporte.setDisable(false);
                btnReporte.setVisible(true);

                limpiarCampos();
                deshabilitarCampos();

                tblInstructores.setDisable(false);

                operacion = Operacion.NINGUNO;
                break;
            case ACTUALIZAR:
                /* if (txtCarne.getText().isEmpty()) {
                    validacionI();

                } else if (txtNombre1.getText().isEmpty()) {
                    validacionI();
                } else if (txtApellido1.getText().isEmpty()) {
                    validacionI();
                } else if (txtCarne.getText().length() > 7) {
                    validacionI();
                } else if (txtNombre1.getText().length() > 15) {
                    validacionI();
                } else if (txtNombre2.getText().length() > 15) {
                    validacionI();
                } else if (txtNombre3.getText().length() > 15) {
                    validacionI();
                } else if (txtApellido1.getText().length() > 15) {
                    validacionI();
                } else if (txtApellido2.getText().length() > 15) {
                    validacionI();
                } else*/ if (existeElemento()) {
                    if (actualizarInstructor()) {
                        limpiarCampos();
                        cargarDatos();
                        deshabilitarCampos();

                        tblInstructores.setDisable(false);

                        tblInstructores.getSelectionModel().clearSelection();

                        btnModificar.setText("Nuevo");
                        btnNuevo.setDisable(false);
                        btnNuevo.setVisible(true);
                        imgModificar.setImage(new Image(PAQUETE_IMAGES + "pagina.png"));

                        btnModificar.setText("Modificar");
                        imgModificar.setImage(new Image(PAQUETE_IMAGES + "editar.png"));

                        btnEliminar.setText("Eliminar");
                        imgEliminar.setImage(new Image(PAQUETE_IMAGES + "eliminar.png"));

                        btnReporte.setDisable(false);
                        btnReporte.setVisible(true);

                        operacion = Operacion.NINGUNO;

                    }
                }

                break;
        }
    }

    // CLIC ELIMINAR
    @FXML
    private void clicEliminar() {
        switch (operacion) {
            case ACTUALIZAR: //Cancelar la actualizacion
                btnNuevo.setDisable(false);
                btnNuevo.setVisible(true);

                btnModificar.setText("Modificar");
                imgModificar.setImage(new Image(PAQUETE_IMAGES + "editar.png"));

                btnEliminar.setText("Eliminar");
                imgEliminar.setImage(new Image(PAQUETE_IMAGES + "eliminar.png"));

                btnReporte.setDisable(false);
                btnReporte.setVisible(true);

                limpiarCampos();
                deshabilitarCampos();

                tblInstructores.getSelectionModel().clearSelection();

                operacion = Operacion.NINGUNO;
                break;
            case NINGUNO:
                if (existeElemento()) {
                    Alert alertaC = new Alert(Alert.AlertType.CONFIRMATION);
                    alertaC.setTitle("Control Academico - El Bosque");
                    alertaC.setHeaderText(null);
                    alertaC.setContentText("¿Seguro que quieres eliminar el registro?");
                    Stage dialog = new Stage();
                    Stage stage = (Stage) alertaC.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image(PAQUETE_IMAGES + "aprender-en-linea.png"));

                    Optional<ButtonType> botonC = alertaC.showAndWait();

                    if (botonC.get().equals(ButtonType.OK)) {

                        if (eliminarInstructores()) {

                            listaInstructor.remove(tblInstructores.getSelectionModel().getFocusedIndex());
                            limpiarCampos();
                            cargarDatos();

                            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                            alerta.setTitle("Control Academico");
                            alerta.setHeaderText(null);
                            alerta.setContentText("Eliminacion Exitosa");
                            Stage stag = (Stage) alerta.getDialogPane().getScene().getWindow();
                            stag.getIcons().add(new Image(PAQUETE_IMAGES + "aprender-en-linea.png"));
                            alerta.show();

                            limpiarCampos();
                        }
                    } else if (botonC.get().equals(ButtonType.CANCEL)) {
                        alertaC.close();
                        tblInstructores.getSelectionModel().clearSelection();
                        limpiarCampos();
                    }
                } else {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Control Academico - El Bosque");
                    alert.setHeaderText(null);
                    alert.setContentText("Antes de continuar selecciona un registro");
                    Stage dialog = new Stage();
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image(PAQUETE_IMAGES + "aprender-en-linea.png"));
                    alert.show();

                }
                break;
        }
    }

    //CLIC REPORTE
    @FXML
    private void clicReporte() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("¡AVISO!");
        alerta.setHeaderText(null);
        alerta.setContentText("Esta opcion solo esta disponible en la versión PRO");
        Stage dialog = new Stage();
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(PAQUETE_IMAGES + "aprender-en-linea.png"));
        // stage.getIcons().add(new Image(this.getClass().getResource("../resources/images/aprender-en-linea.png").toString()));
        alerta.show();
    }

    public void cargarDatos() {
        System.out.println(" - - - -- - - - - - - - - - - - -");
        System.out.println(listaInstructor);
        System.out.println(" - - - -- - - - - - - - - - - - -");
        tblInstructores.setItems(getInstructores());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre1.setCellValueFactory(new PropertyValueFactory<>("nombre1"));
        colNombre2.setCellValueFactory(new PropertyValueFactory<>("nombre2"));
        colNombre3.setCellValueFactory(new PropertyValueFactory<>("nombre3"));
        colApellido1.setCellValueFactory(new PropertyValueFactory<>("apellido1"));
        colApellido2.setCellValueFactory(new PropertyValueFactory<>("apellido2"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
    }

    @FXML
    public void seleccionarElemento() {
        txtId.setText(String.valueOf((((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getId())));
        txtNombre1.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getNombre1());
        txtNombre2.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getNombre2());
        txtNombre3.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getNombre3());
        txtApellido1.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getApellido1());
        txtApellido2.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getApellido2());
        txtDireccion.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getDireccion());
        txtEmail.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getEmail());
        txtTelefono.setText(((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getTelefono());
        dpFechaNacimiento.setValue((((Instructores) tblInstructores.getSelectionModel().getSelectedItem()).getFechaNacimiento().toLocalDate()));

    }

    @FXML
    private void clicRegresar() {
        escenarioPrincipal.mostrarEscenaPrincipal();
    }

}