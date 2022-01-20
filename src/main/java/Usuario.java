import java.util.Arrays;
import java.util.List;

public class Usuario implements IUsuario {
    private String ip;
    private String ipProxy;

    public Usuario(String ip) {
        this.ip = ip;
        this.ipProxy = "YYY.YYY.Y.YY";
    }

    public Usuario(String ip, String ipProxy) {
        this.ip = ip;
        this.ipProxy = ipProxy;
    }

    public String getIp() {
        return ip;
    }
    public String getIpProxy() {
        return ipProxy;
    }

    @Override
    public List<String> getInfo() {
        return Arrays.asList(this.ip, this.ipProxy);
    }

    @Override
    public String acessar(Site site) {
        return "Acessando " + site.getNome();
    }
}
