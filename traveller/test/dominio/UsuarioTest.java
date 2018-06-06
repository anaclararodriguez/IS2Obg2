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
import java.util.Date;
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

    private Usuario unUsuario;
    private Ciudad ciudad;
    private Date fechaI;
    private Date fechaF;
   
    @Before
    public void setUp() throws UsuarioException {
        Email mail =  new Email("jp@gmail.com");
        unUsuario = new Usuario("Juancho", "qwer1234", "Juan", "Perez",mail);
        ciudad = new Ciudad("MADRID");
        fechaI= new Date(2018,11,01);
        fechaF=new Date(2018,12,22);
    }

    @Test
    public void testExisteNombreViajeTrue() throws ViajeException,FechaException,ViajeExistenteException{
        unUsuario.altaViaje("Vacaciones", ciudad, fechaI,fechaF, "descripcion");
        boolean viajeRepetido=false;
        try {
             unUsuario.altaViaje("Vacaciones", ciudad, fechaI,fechaF, "descripciond");
        }catch(ViajeExistenteException e){
            viajeRepetido=true;
        }

        assertTrue(viajeRepetido);
    }
    
    @Test
    public void testExisteNombreViajeFalse() throws ViajeException, FechaException {
        int cantInicial = unUsuario.getListaViajes().size();
        unUsuario.altaViaje("Vacaciones", ciudad, fechaI,fechaF, "descripcion");
        int cantFinal = unUsuario.getListaViajes().size();
        assertEquals(cantInicial+1, cantFinal);  
    }

    @Test
    public void testBajaViaje() throws ViajeException, FechaException {
        Viaje viaje = new Viaje("Vacaciones");
        unUsuario.altaViaje("Vacaciones", ciudad, fechaI,fechaF, "descripcion");
        unUsuario.bajaViaje(viaje);
        assertFalse(unUsuario.getListaViajes().contains(viaje));
    }

    @Test
    public void testAltaViaje() throws Exception {
        int cantInicial = unUsuario.getListaViajes().size();
        unUsuario.altaViaje("Vacaciones de verano", ciudad, fechaI,fechaF, "descripcion");
        int cantFinal = unUsuario.getListaViajes().size();
        assertEquals(cantInicial+1, cantFinal);  
    }

    public void testAltaViajeErrorNombreExistente() throws Exception {
        boolean existeNombre=false;
        Date desde = new Date(01,11,2013);
        Date hasta = new Date(23,12,2013);
        Ciudad ciud = new Ciudad("MADRID");
        unUsuario.altaViaje("Vacaciones", ciud, desde,hasta, "descripcion");
        try {
            unUsuario.altaViaje("Vacaciones", ciud, desde,
                    hasta, "descripcion");
        } catch (ViajeExistenteException e) {
            existeNombre=true;
        }
        assertTrue(existeNombre);
    }

    @Test
    public void testAltaViajeErrorFechaIniVacio() throws Exception {
        boolean fechaCorrecta=true;
        try {
            unUsuario.altaViaje("Vacaciones", ciudad,null,fechaF, "descripcion");
        } catch (FechaVaciaException e) {
            fechaCorrecta=false;
        }
        assertFalse(fechaCorrecta);
    }

    @Test
    public void testAltaViajeErrorFechaFinVacio() throws Exception {
        boolean fechaCorrecta=true;
        try {
            unUsuario.altaViaje("Vacaciones", ciudad,fechaI,null, "descripcion");
        } catch (FechaVaciaException e) {
            fechaCorrecta=false;
        }
        
        assertFalse(fechaCorrecta);
    }

    @Test
    public void testAgregarAmigo() {
        Usuario a1 = new Usuario("Usuario1");
        int largoActual = unUsuario.getListaAmigos().size();
        unUsuario.agregarAmigo(a1);
        int largoEsperado = unUsuario.getListaAmigos().size();

        assertEquals(largoActual+1, largoEsperado);
    }

    @Test
    public void testGetApellido() {
        String expResult = "Perez";
        String result = unUsuario.getApellido();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetApellido() throws Exception {
        String apellido = "Pereira";
        unUsuario.setApellido(apellido);
        assertEquals(apellido, unUsuario.getApellido());
    }

    @Test
    public void testSetApellidoErrorVacio() throws Exception {
        boolean apellidoVacio=false;
        try {
            unUsuario.setApellido("");
        } catch (ApellidoVacioException e) {
            apellidoVacio=true;
        }
        
        assertTrue(apellidoVacio);
    }

    @Test
    public void testSetApellidoErrorMuyCorto() throws Exception {
        boolean apellidoCorto=false;
        try {
            unUsuario.setApellido("a");
        } catch (LargoApellidoInvalidoException e) {
            apellidoCorto=true;
        }
        
        assertTrue(apellidoCorto);
    }

    @Test
    public void testSetApellidoErrorMuyLargo1() throws Exception {
        boolean apellidoLargo=false;
        try {
            unUsuario.setApellido("Apellido demasiado largo para validarlo.");
        } catch (LargoApellidoInvalidoException e) {
            apellidoLargo=true;
        }
                
        assertTrue(apellidoLargo);        
    }

    @Test
    public void testGetEmail() {
        Email expResult = new Email("jp@gmail.com");
        Email result = unUsuario.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEmail() throws Exception {
        Email email = new Email("jp@gmail.com");
        unUsuario.setEmail(email);
        assertEquals(email, unUsuario.getEmail());
    }

    @Test
    public void testSetEmailErrorVacio() throws Exception {
        boolean mailVacio=false;
        try {
            Email email = new Email("");
            unUsuario.setEmail(email);
        } catch (EmailInvalidoException e) {
            mailVacio=true;
        }
         assertTrue(mailVacio);
    }

    @Test
    public void testGetNombre() {
        String expResult = "Juan";
        String result = unUsuario.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNombre() throws Exception {
        String nombre = "Carlos";
        unUsuario.setNombre(nombre);
        assertEquals(nombre, unUsuario.getNombre());
    }

    @Test
    public void testSetNombreErrorVacio() throws Exception {
        boolean nombreVacio=false;
        try {
            String nombre = "";
            unUsuario.setNombre(nombre);
        } catch (NombreVacioException e) {
            nombreVacio=true;
        }
        
        assertTrue(nombreVacio);
    }
    
    @Test
    public void testSetNombreErrorMuyCorto() throws Exception {
        boolean nombreCorto=false;
        try {
            String nombre = "C";
            unUsuario.setNombre(nombre);
        } catch (LargoNombreInvalidoException e) {
            nombreCorto=true;
        }
        
        assertTrue(nombreCorto);
    }
    
    @Test
    public void testSetNombreErrorMuyLargo() throws Exception {
        boolean nombreLargo = false;
        try {
            String nombre = "Carlos Perez de la Cuenca German";
            unUsuario.setNombre(nombre);
        } catch (LargoNombreInvalidoException e) {
           nombreLargo=true;
        }
        
        assertTrue(nombreLargo);
    }
   
    @Test
    public void testGetNombreUsuario() {
        String expResult = "Juancho";
        String result = unUsuario.getNombreUsuario();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetNombreUsuario() throws Exception {
        String nombre = "CaRlOs";
        unUsuario.setNombreUsuario(nombre);
        assertEquals(nombre, unUsuario.getNombreUsuario());
    }
    
    @Test
    public void testSetNombreUsuarioErrorVacio() throws Exception {
        boolean nombreVacio = false;
        try {
            String nombre = "";
            unUsuario.setNombreUsuario(nombre);
        } catch (NombreUsuarioVacioException e) {
            nombreVacio=true;
        }
        
        assertTrue(nombreVacio);
    }

    @Test
    public void testSetNombreUsuarioErrorMuyCorto() throws Exception {
        boolean nombreCorto=false;
        try {
            String nombre = "C";
            unUsuario.setNombreUsuario(nombre);
        } catch (LargoNombreUsuarioInvalidoException e) {
            nombreCorto=true;
        }
        
        assertTrue(nombreCorto);
    }
    
    @Test
    public void testSetNombreUsuarioErrorMuyLargo() throws Exception {
        boolean nombreLargo=false;
        try {
            String nombre = "Carlos Perez de la Cuenca German";
            unUsuario.setNombreUsuario(nombre);
        } catch (LargoNombreUsuarioInvalidoException e) {
            nombreLargo=true;
        }
        
        assertTrue(nombreLargo);
    }
    
    @Test
    public void testEqualsOK() throws UsuarioException {
        Object obj = new Usuario("Juancho", "qwer1234", "Juan", "Perez", new Email("jp@gmail.com"));
        boolean expResult = true;
        boolean result = unUsuario.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsError1() throws UsuarioException {
        Object obj = new Usuario("JuAnChO", "qwer1234", "Juan", "Perez", new Email("jp@gmail.com"));
        boolean expResult = false;
        boolean result = unUsuario.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToString() {
        String expResult = "Juan Perez";
        String result = unUsuario.toString();
        assertEquals(expResult, result);
    }
}
