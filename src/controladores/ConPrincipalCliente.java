package controladores;

import modelos.ModCliente;
import vistas.VisPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ConPrincipalCliente implements ActionListener, KeyListener {
    public ModCliente modelo;
    public VisPrincipal vista;
    public String usuario;
    public String mensajeEntrante = null;


    public ConPrincipalCliente(VisPrincipal vistaPrincipal, ModCliente modelo, String usuario) {
        this.vista = vistaPrincipal;
        this.modelo = modelo;
        this.usuario = usuario;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
    }

    private void agregarListeners() {
        if (vista.finished){
            vista.btnEnviar.addActionListener(this);
            vista.btnEstado.addActionListener(this);
            vista.btnSilenciarSonidos.addActionListener(this);
            vista.txtMensaje.addKeyListener(this);
        }
    }

    private void cambiarEstado() {
        String[] opciones = {"Conectado", "Ausente", "Desconectado"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion.\n\n", "Cambiar Estado", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (opcion.equals("Conectado")) {
            vista.lblEstado.setText("Conectado");
        } else if (opcion.equals("Ausente")) {
            vista.lblEstado.setText("Ausente");
        } else {
            vista.lblEstado.setText("Desconectado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnSilenciarSonidos){
            silenciarSonidos();
        }else if(e.getSource() == vista.btnEstado){
            cambiarEstado();
        }else if(e.getSource() == vista.btnEnviar){
            enviarMensaje();

        }
    }

    private void enviarMensaje() {
        String mensaje = vista.txtMensaje.getText();
        try {
            modelo.enviarMsj(mensaje, usuario);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void silenciarSonidos() {
        System.out.println("se han silenciado los sonidos");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String mensaje = vista.txtMensaje.getText();
            try {
                modelo.enviarMsj(mensaje, usuario);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            vista.txtMensaje.setText("");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
