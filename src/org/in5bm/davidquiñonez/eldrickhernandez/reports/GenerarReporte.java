/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.in5bm.davidquiñonez.eldrickhernandez.reports;

/**
 *
 * @author informatica
 */
/*/
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRJRXmlLoader;



public class GenerarReporte {
    private static GenerarReporte instance;
    private JasperViewer jasperViewer:
    
    
    public GenerarReporte(){
        Locale locale = new Locale("es, "GT");
        Locale.setDefault(locale);
    }
    
    //patron de diseño singleton 
    public static GenerarReporte getInstance(){
        if (instance == null){
            instance = new GenerarReporte();
        }
        return instance;
    }
    
    public void mostrarReporte(String nombreReporte,Map <String, Object> parametros, String titulo){
        try{
            URL urlFile = new URL(getClass().getResource(nombreReporte).toString());
            
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(urlFile);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, Conexion.getInstance().getConexion()); 
            
            jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle(titulo);
            jasperViewer.setVisible(true);
            
        } catch (Exception e){
            e.printStackTrace();
            
        }
        
    }
}






*/
































