import java.util.List;

public class UsuarioProxy implements IUsuario {
    private Usuario usuario;
    private String ip;

    public UsuarioProxy(String ip) {
        this.ip = ip;
    }

    @Override
    public List<String> getInfo() {
        if(this.usuario == null) {
            this.usuario = new Usuario(this.ip);
        }
        return this.usuario.getInfo();
    }

    @Override
    public String acessar(Site site) {
        if(this.usuario == null) {
            this.usuario = new Usuario(this.ip);
        }

        if(site.getIp() != this.usuario.getIpProxy()) {
            throw new IllegalArgumentException("Acesso negado.");
        }
        return this.usuario.acessar(site);
    }
}
