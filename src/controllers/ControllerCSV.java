/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewCSV;
import models.ModelCSV;

/**
 *clase nos permit tomar valores de la vista y manipular los datos para ser guardados en un csv
 * @author manl_
 */
public class ControllerCSV {
    ModelCSV modelCSV;
    ViewCSV viewCSV;
    /**
     * action listener con todos los eventos para la interaccion con el csv
     */
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewCSV.jb_niuevo)
                jb_nuevo_actionPerformed();
            else if(e.getSource() == viewCSV.jb_guardar)
                jb_guardar_actionPerformed();
            else if(e.getSource() == viewCSV.jb_primero)
                jb_primero_actionPerformed();
        }
    };   
    /**
     * metodo que vacia las cajas de la vista y los valores de el modelo
     */
    public void jb_nuevo_actionPerformed(){
        viewCSV.jtf_nombre.setText(null);
        modelCSV.setNombre(null);
        viewCSV.jtf_email.setText(null);
        modelCSV.setEmail(null);
    }
    /**
     * Constructor que permite la ejecucion del programa con sus acciones y la interaccion de vista y modelo
     * @param modelCSV objeto que permite usar los valores de esta clase
     * @param viewCSV objeto que permite tomar valores de la vista
     */
    public ControllerCSV(ModelCSV modelCSV, ViewCSV viewCSV) {
        this.modelCSV = modelCSV;
        this.viewCSV = viewCSV;
        this.viewCSV.jb_niuevo.addActionListener(al);
        this.viewCSV.jb_guardar.addActionListener(al);
        this.viewCSV.jb_primero.addActionListener(al);
        initComponents();
    }
    /**
     * metodo que permite leer el archivo e ingresar nuevo dato al csv, en caso de que algun dato 
     * este vacio enviara un mensaje de error
     */
    public void jb_guardar_actionPerformed(){
       modelCSV.readFile();
       modelCSV.setNombre(viewCSV.jtf_nombre.getText());
       modelCSV.setEmail(viewCSV.jtf_email.getText());
       if (modelCSV.getNombre().isEmpty() || modelCSV.getEmail().isEmpty())
           JOptionPane.showMessageDialog(null,"Campos vacios ingrese datos");
       else
           modelCSV.writeFile();
    }
    public void jb_primero_actionPerformed(){
       modelCSV.primero();
    }
    /**
     * metodo que permite iniciar la aplicacion
     */
    public void initComponents(){
       this.viewCSV.setVisible(true);
       modelCSV.readFile();
       modelCSV.primero();
       this.viewCSV.jtf_nombre.setText(modelCSV.getNombre());
       this.viewCSV.jtf_email.setText(modelCSV.getEmail());
    }
}
