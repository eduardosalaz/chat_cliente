package controladores;

import modelos.ModCliente;
import vistas.VisLoginUsr;
import vistas.VisPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConLoginCliente implements ActionListener {
    public VisLoginUsr vista;
    public ModCliente modelo;

    public ConLoginCliente(VisLoginUsr visLoginUsr, ModCliente modCliente) {
        this.vista = visLoginUsr;
        this.modelo = modCliente;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
    }

    private void agregarListeners() {
        if (vista.finished) {
            vista.btnIngresar.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {
            String ip = vista.txtIP.getText();
            String usuario = vista.txtUsr.getText();

            if (ip.isEmpty() || usuario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            } else {
                modelo.conectar(ip, usuario);
                if (modelo.conexionCorrecta) {
                    JOptionPane.showMessageDialog(null, "Se ha conectado de manera exitosa");
                    VisPrincipal vistaPrincipal = new VisPrincipal();
                    ConPrincipalCliente conPrincipalCliente = new ConPrincipalCliente(vistaPrincipal, modelo, usuario);
                }
            }
        }
    }
}
