package vistas;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class VisLoginUsr {

    public JFrame frame;
    public JTextField txtUsr;
    public JButton btnIngresar;
    public JTextField txtIP;
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
        frame.setBounds(100, 100, 540, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(51, 51, 51));

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), Color.DARK_GRAY, new Color(0, 0, 0), new Color(0, 0, 0)));
        panel.setBounds(114, 68, 299, 468);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        //panel

        panel.setBackground(new Color(28, 28, 28));

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Arial", Font.PLAIN, 28));
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setBounds(117, 30, 84, 41);
        panel.add(lblLogin);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 17));
        lblUsuario.setBounds(119, 120, 65, 26);
        panel.add(lblUsuario);

        txtUsr = new JTextField();
        txtUsr.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        txtUsr.setBounds(37, 156, 228, 19);
        panel.add(txtUsr);
        txtUsr.setColumns(10);

        JLabel lblIP = new JLabel("Direccion IP a conectar:");
        lblIP.setForeground(Color.WHITE);
        lblIP.setFont(new Font("Arial", Font.PLAIN, 17));
        lblIP.setBounds(59, 200, 191, 26);
        panel.add(lblIP);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnIngresar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(0, 0, 0), new Color(0, 0, 0)));
        btnIngresar.setFocusable(false);
        btnIngresar.setFocusTraversalPolicyProvider(true);
        btnIngresar.setRequestFocusEnabled(false);
        btnIngresar.setRolloverEnabled(false);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBounds(76, 399, 151, 41);
        btnIngresar.setBackground(new Color(51, 51, 51));
        panel.add(btnIngresar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBorder(new LineBorder(Color.WHITE));
        lblNewLabel.setBounds(37, 81, 228, 1);
        panel.add(lblNewLabel);

        txtIP = new JTextField();
        txtIP.setColumns(10);
        txtIP.setBounds(37, 236, 228, 19);
        panel.add(txtIP);

    }
}
