package vistas;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VisPrincipal{

    public JFrame frame;
    public JTextField txtMensaje;
    public JButton btnEstado, btnEnviar, btnSilenciarSonidos;
    public JTextArea txtAreaChat;
    public JLabel lblEstado;
    public boolean finished = false;

    public void lanzarVista() {
        try {
            crearGUI();
            frame.setVisible(true);
            frame.setResizable(false);
            finished = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void crearGUI() {

        frame = new JFrame();
        frame.setVisible(true);
        frame.getContentPane().setEnabled(false);
        frame.setBounds(100, 100, 906, 642);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(51, 51, 51));

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), Color.DARK_GRAY, new Color(0, 0, 0), new Color(0, 0, 0)));
        panel.setBounds(10, 10, 872, 583);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        //panel

        panel.setBackground(new Color(28, 28, 28));

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(646, 108, 216, 344);
        panel.add(panel_2);

        txtMensaje = new JTextField();
        txtMensaje.setBounds(10, 467, 486, 31);
        panel.add(txtMensaje);
        txtMensaje.setColumns(10);


        btnEnviar = new JButton("Enviar");
        btnEnviar.setRolloverEnabled(false);
        btnEnviar.setRequestFocusEnabled(false);
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)));
        btnEnviar.setBackground(new Color(51, 51, 51));
        btnEnviar.setBounds(506, 466, 130, 33);
        panel.add(btnEnviar);

        btnEstado = new JButton("Cambiar de estado");
        btnEstado.setRolloverEnabled(false);
        btnEstado.setRequestFocusEnabled(false);
        btnEstado.setForeground(Color.WHITE);
        btnEstado.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)));
        btnEstado.setBackground(new Color(51, 51, 51));
        btnEstado.setBounds(10, 45, 114, 31);
        panel.add(btnEstado);

        btnSilenciarSonidos = new JButton("Silenciar Sonidos");
        btnSilenciarSonidos.setRolloverEnabled(false);
        btnSilenciarSonidos.setRequestFocusEnabled(false);
        btnSilenciarSonidos.setForeground(Color.WHITE);
        btnSilenciarSonidos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)));
        btnSilenciarSonidos.setBackground(new Color(51, 51, 51));
        btnSilenciarSonidos.setBounds(748, 462, 114, 37);
        panel.add(btnSilenciarSonidos);

        JLabel lblNewLabel = new JLabel("Estado actual: ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(10, 10, 121, 31);
        panel.add(lblNewLabel);

        lblEstado = new JLabel("Conectado");
        lblEstado.setForeground(Color.WHITE);
        lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEstado.setBounds(126, 10, 121, 31);
        panel.add(lblEstado);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 108, 626, 344);
        panel.add(scrollPane_1);

        txtAreaChat = new JTextArea();
        txtAreaChat.setEditable(false);
        scrollPane_1.setViewportView(txtAreaChat);


    }

}

