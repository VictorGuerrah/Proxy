import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.adicionaUsuario(new Usuario("XXX.XXX.X.XX", "YYY.YYY.Y.YY"));
    }

    @Test
    void deveRetornarDadosUsuario() {
        UsuarioProxy usuario = new UsuarioProxy("XXX.XXX.X.XX");

        assertEquals(Arrays.asList("XXX.XXX.X.XX, YYY.YYY.Y.YY"), usuario.getInfo());
    }

    @Test
    void deveRetornarAcesso() {
        Site site = new Site("site.com", "Site", "YYY.YYY.Y.YY");
        UsuarioProxy usuario = new UsuarioProxy("XXX.XXX.X.XX");

        assertEquals("Acessando Site", usuario.acessar(site));
    }

    @Test
    void mustThrowIllegalArgumentExceptionNoAvailable() {
        try {
            Site site = new Site("site.com", "Site", "ZZZ.ZZZ.Z.ZZ");
            UsuarioProxy usuario = new UsuarioProxy("XXX.XXX.X.XX");

            usuario.acessar(site);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Acesso negado.",
                    e.getMessage() );
        }
    }
}