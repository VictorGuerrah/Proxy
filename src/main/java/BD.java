import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static Usuario getUsuario(String ip) {
        return usuarios.get(ip);
    }

    public static void adicionaUsuario(Usuario usuario) {
        usuarios.put(usuario.getIpProxy(), usuario);
    }
}