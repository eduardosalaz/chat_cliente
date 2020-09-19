package principal;

import controladores.ConLoginCliente;
import modelos.ModCliente;
import vistas.VisLoginUsr;

public class LauncherCliente {
    public static void main(String[] args) {
        VisLoginUsr visLoginUsr = new VisLoginUsr();
        ModCliente modCliente = new ModCliente();
        ConLoginCliente conLoginCliente = new ConLoginCliente(visLoginUsr, modCliente);

    }
}
