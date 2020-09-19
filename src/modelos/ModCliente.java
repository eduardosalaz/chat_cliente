package modelos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ModCliente {

    int ptoLocal = 558;
    int ptoRemoto = 556;
    String ipRemota = null;
    String userName = null;
    Socket s = null;
    ObjectOutputStream oos = null;
    boolean ejecutar = true;
    HiloCliente hc;
    public boolean conexionCorrecta = false;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy', a las' HH:mm: ");

    public void conectar(String ip, String usuario) {
        this.ipRemota = ip;
        this.userName = usuario;
        try {
            s = new Socket(ipRemota, ptoRemoto);
            oos = new ObjectOutputStream(s.getOutputStream());
            levantarServidor();//abajo
            conexionCorrecta = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
                if (s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void levantarServidor() {
        hc = new HiloCliente(ptoLocal);

    }

    public void enviarMsj(String mensaje, String usuario ) throws IOException {
        if(ejecutar){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String tiempo = sdf.format(timestamp);
            mensaje = tiempo + usuario + " dice: " + mensaje;
            oos.writeObject(mensaje);
        }
    }
}
