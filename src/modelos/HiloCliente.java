package modelos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import controladores.ConPrincipalCliente;

public class HiloCliente extends Thread {
    int ptoLocal;
    boolean ejecutar = true;
    Socket s = null;
    ServerSocket ss = null;
    ObjectInputStream ois = null;
    public ConPrincipalCliente conPrincipalCliente = null;

    public HiloCliente(int ptoLocal) {
        this.ptoLocal = ptoLocal;
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        try {
            ss = new ServerSocket(ptoLocal);
            while (true) {
                s = ss.accept();
                ois = new ObjectInputStream(s.getInputStream());
                do {
                    String mensaje = (String) ois.readObject();


                } while (ejecutar);
                break;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
                if (ss != null) ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
