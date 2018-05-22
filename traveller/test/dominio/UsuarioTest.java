/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import traveller.dominio.Usuario;
import traveller.dominio.Email;
import traveller.dominio.Ciudad;
import traveller.dominio.Viaje;
import traveller.excepciones.fecha.FechaException;
import traveller.excepciones.fecha.FechaFinAnteriorInicioException;
import traveller.excepciones.fecha.FechaInicioAnteriorException;
import traveller.excepciones.fecha.FechaVaciaException;
import traveller.excepciones.fecha.FormatoFechaFinException;
import traveller.excepciones.fecha.FormatoFechaInicioException;
import traveller.excepciones.usuario.ApellidoVacioException;
import traveller.excepciones.usuario.EmailInvalidoException;
import traveller.excepciones.usuario.LargoApellidoInvalidoException;
import traveller.excepciones.usuario.LargoNombreInvalidoException;
import traveller.excepciones.usuario.LargoNombreUsuarioInvalidoException;
import traveller.excepciones.usuario.NombreUsuarioVacioException;
import traveller.excepciones.usuario.NombreVacioException;
import traveller.excepciones.usuario.UsuarioException;
import traveller.excepciones.viaje.ViajeException;
import traveller.excepciones.viaje.ViajeExistenteException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pablo
 */
public class UsuarioTest {

    private Usuario instance;

    public UsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws UsuarioException {
        instance = new Usuario("Juancho", "qwer1234", "Juan", "Perez", new Email("jp@gmail.com"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of existeNombreViaje method, of class Usuario.
     */
    @Test
    public void testExisteNombreViajeTrue() throws ViajeException, FechaException {
        boolean expResult = true;
        instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                "23", "12", "2014", "descripcion");
        boolean result = instance.existeNombreViaje("Vacaciones");
        assertEquals(expResult, result);
    }

    /**
     * Test of existeNombreViaje method, of class Usuario.
     */
    @Test
    public void testExisteNombreViajeFalse() throws ViajeException, FechaException {
        boolean expResult = false;
        instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                "23", "12", "2014", "descripcion");
        boolean result = instance.existeNombreViaje("Vacaciones ");
        assertEquals(expResult, result);
    }

    /**
     * Test of bajaViaje method, of class Usuario.
     */
    @Test
    public void testBajaViaje() throws ViajeException, FechaException {
        instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                "23", "12", "2014", "descripcion");
        instance.bajaViaje(new Viaje("Vacaciones"));
        assert (!instance.getListaViajes().contains(new Viaje("Vacaciones")));
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeOK1() throws Exception {
        instance.altaViaje("Vaca", Ciudad.MADRID, "01", "11", "2013",
                "23", "12", "2014", "");
        assert (instance.existeNombreViaje("Vaca"));
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeOK2() throws Exception {
        instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                "01", "11", "2013", "");
        assert (instance.existeNombreViaje("Vacaciones"));
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeOK3() throws Exception {
        instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                "23", "12", "2016", ".    ");
        instance.altaViaje("Vacacion", Ciudad.MADRID, "01", "11", "2013",
                "23", "12", "2016", ".    ");
        assert (instance.existeNombreViaje("Vacaciones")
                && instance.existeNombreViaje("Vacacion"));
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorNombreExistente() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    "23", "12", "2014", "descripcion");
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (ViajeExistenteException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorDiaIniVacio() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "", "11", "2013",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FechaVaciaException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorMesIniVacio() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "", "2013",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FechaVaciaException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorAñoIniVacio() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FechaVaciaException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorDiaFinVacio() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    "", "12", "2014", "descripcion");
            assert (false);
        } catch (FechaVaciaException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorMesFinVacio() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    "23", "", "2014", "descripcion");
            assert (false);
        } catch (FechaVaciaException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorAñoFinVacio() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    "23", "12", "", "descripcion");
            assert (false);
        } catch (FechaVaciaException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFormatoDiaIni() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "DD", "11", "2013",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FormatoFechaInicioException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFormatoMesIni() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "13", "2013",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FormatoFechaInicioException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFormatoAñoIni() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "1900",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FormatoFechaInicioException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFormatoDiaFin() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    ".", "12", "2014", "descripcion");
            assert (false);
        } catch (FormatoFechaFinException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFormatoMesFin() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    "23", "MM", "2014", "descripcion");
            assert (false);
        } catch (FormatoFechaFinException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFormatoAñoFin() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "01", "11", "2013",
                    "23", "12", "yyyy", "descripcion");
            assert (false);
        } catch (FormatoFechaFinException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFechaIni() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "23", "11", "2012",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FechaInicioAnteriorException e) {
            assert (true);
        }
    }

    /**
     * Test of altaViaje method, of class Usuario.
     */
    @Test
    public void testAltaViajeErrorFechaFin() throws Exception {
        try {
            instance.altaViaje("Vacaciones", Ciudad.MADRID, "24", "12", "2014",
                    "23", "12", "2014", "descripcion");
            assert (false);
        } catch (FechaFinAnteriorInicioException e) {
            assert (true);
        }
    }

    /**
     * Test of agregarViajes method, of class Usuario.
     */
    @Test
    public void testAgregarViajes() {
        Viaje v1 = new Viaje("viaje1");
        Viaje v2 = new Viaje("viaje2");
        Viaje v3 = new Viaje("viaje3");

        ArrayList<Viaje> expResult = new ArrayList<Viaje>();
        expResult.add(v1);
        expResult.add(v2);
        expResult.add(v3);

        instance.agregarViajes(v1);
        instance.agregarViajes(v2);
        instance.agregarViajes(v3);

        ArrayList result = instance.getListaViajes();
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarAmigo method, of class Usuario.
     */
    @Test
    public void testAgregarAmigo() {
        Usuario a1 = new Usuario("Usuario1");
        Usuario a2 = new Usuario("Usuario2");
        Usuario a3 = new Usuario("Usuario3");

        ArrayList<Usuario> expResult = new ArrayList<Usuario>();
        expResult.add(a1);
        expResult.add(a2);
        expResult.add(a3);

        instance.agregarAmigo(a1);
        instance.agregarAmigo(a2);
        instance.agregarAmigo(a3);

        ArrayList result = instance.getListaAmigos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getApellido method, of class Usuario.
     */
    @Test
    public void testGetApellido() {
        String expResult = "Perez";
        String result = instance.getApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setApellido method, of class Usuario.
     */
    @Test
    public void testSetApellido() throws Exception {
        String apellido = "Pereira";
        instance.setApellido(apellido);
        assertEquals(apellido, instance.getApellido());
    }

    /**
     * Test of setApellido method, of class Usuario.
     */
    @Test
    public void testSetApellidoErrorVacio() throws Exception {
        try {
            instance.setApellido("");
            assert (false);
        } catch (ApellidoVacioException e) {
            assert (true);
        }
    }

    /**
     * Test of setApellido method, of class Usuario.
     */
    @Test
    public void testSetApellidoErrorMuyCorto() throws Exception {
        try {
            instance.setApellido("a");
            assert (false);
        } catch (LargoApellidoInvalidoException e) {
            assert (true);
        }
    }

    /**
     * Test of setApellido method, of class Usuario.
     */
    @Test
    public void testSetApellidoErrorMuyLargo1() throws Exception {
        try {
            instance.setApellido("Apellido demasiado largo para validarlo.");
            assert (false);
        } catch (LargoApellidoInvalidoException e) {
            assert (true);
        }
    }

    /**
     * Test of setApellido method, of class Usuario.
     */
    @Test
    public void testSetApellidoErrorMuyLargo2() throws Exception {
        try {
            instance.setApellido("apellido de 21 caract");
            assert (false);
        } catch (LargoApellidoInvalidoException e) {
            assert (true);
        }
    }

    /**
     * Test of getEmail method, of class Usuario.
     */
    @Test
    public void testGetEmail() {
        Email expResult = new Email("jp@gmail.com");
        Email result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Usuario.
     */
    @Test
    public void testSetEmail() throws Exception {
        Email email = new Email("jp@gmail.com");
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of setEmail method, of class Usuario.
     */
    @Test
    public void testSetEmailErrorVacio() throws Exception {
        try {
            Email email = new Email("");
            instance.setEmail(email);
            assert (false);
        } catch (EmailInvalidoException e) {
            assert (true);
        }
    }

    /**
     * Test of getNombre method, of class Usuario.
     */
    @Test
    public void testGetNombre() {
        String expResult = "Juan";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombre() throws Exception {
        String nombre = "Carlos";
        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreErrorVacio() throws Exception {
        try {
            String nombre = "";
            instance.setNombre(nombre);
            assert(false);
        } catch (NombreVacioException e) {
            assert(true);
        }
    }
    
    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreErrorMuyCorto() throws Exception {
        try {
            String nombre = "C";
            instance.setNombre(nombre);
            assert(false);
        } catch (LargoNombreInvalidoException e) {
            assert(true);
        }
    }
    
    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreErrorMuyLargo1() throws Exception {
        try {
            String nombre = "Carlos Perez de la Cuenca German";
            instance.setNombre(nombre);
            assert(false);
        } catch (LargoNombreInvalidoException e) {
            assert(true);
        }
    }
    
    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreErrorMuyLargo2() throws Exception {
        try {
            String nombre = "Nombre de 21 cararact";
            instance.setNombre(nombre);
            assert(false);
        } catch (LargoNombreInvalidoException e) {
            assert(true);
        }
    }

    /**
     * Test of getNombreUsuario method, of class Usuario.
     */
    @Test
    public void testGetNombreUsuario() {
        String expResult = "Juancho";
        String result = instance.getNombreUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombreUsuario method, of class Usuario.
     */
    @Test
    public void testSetNombreUsuario() throws Exception {
        String nombre = "CaRlOs";
        instance.setNombreUsuario(nombre);
        assertEquals(nombre, instance.getNombreUsuario());
    }
    
    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreUsuarioErrorVacio() throws Exception {
        try {
            String nombre = "";
            instance.setNombreUsuario(nombre);
            assert(false);
        } catch (NombreUsuarioVacioException e) {
            assert(true);
        }
    }
    
    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreUsuarioErrorMuyCorto() throws Exception {
        try {
            String nombre = "C";
            instance.setNombreUsuario(nombre);
            assert(false);
        } catch (LargoNombreUsuarioInvalidoException e) {
            assert(true);
        }
    }
    
    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreUsuarioErrorMuyLargo1() throws Exception {
        try {
            String nombre = "Carlos Perez de la Cuenca German";
            instance.setNombreUsuario(nombre);
            assert(false);
        } catch (LargoNombreUsuarioInvalidoException e) {
            assert(true);
        }
    }
    
    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombreUsuarioErrorMuyLargo2() throws Exception {
        try {
            String nombre = "Nombre de 21 cararact";
            instance.setNombreUsuario(nombre);
            assert(false);
        } catch (LargoNombreUsuarioInvalidoException e) {
            assert(true);
        }
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEqualsOK() throws UsuarioException {
        Object obj = new Usuario("Juancho", "qwer1234", "Juan", "Perez", new Email("jp@gmail.com"));
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEqualsError1() throws UsuarioException {
        Object obj = new Usuario("JuAnChO", "qwer1234", "Juan", "Perez", new Email("jp@gmail.com"));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEqualsError2() throws UsuarioException {
        Object obj = new Usuario("Juancho ", "qwer1234", "Juan", "Perez", new Email("jp@gmail.com"));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Usuario.
     */
    @Test
    public void testToString() {
        String expResult = "Juan Perez";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
