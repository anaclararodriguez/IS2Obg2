/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import traveller.dominio.Ciudad;
import traveller.dominio.TipoEvento;
import traveller.dominio.Evento;
import traveller.dominio.Viaje;
import traveller.excepciones.comentario.ContenidoVacioException;
import traveller.excepciones.evento.EventoException;
import traveller.excepciones.evento.EventoExistenteException;
import traveller.excepciones.fecha.FechaEventoFueraViajeException;
import traveller.excepciones.fecha.FechaException;
import traveller.excepciones.fecha.FechaVaciaException;
import traveller.excepciones.fecha.FormatoFechaInicioException;
import traveller.excepciones.viaje.LargoNombreViajeInvalidoException;
import traveller.excepciones.viaje.NombreViajeVacioException;
import traveller.excepciones.viaje.ViajeException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class ViajeTest {

    private Viaje unViaje;
    private Ciudad ciudad;
    private TipoEvento tipoEvento;
    private Date fechaEvento;
    

    @Before
    public void setUp() throws ViajeException {
        Date fechaInicio = Calendar.getInstance().getTime();
        Date fechaFin = new Date(23,11,204);
        unViaje = new Viaje("Vacaciones", ciudad, fechaInicio, fechaFin, "Descripcion");
        tipoEvento = new TipoEvento("Familiar");
        fechaEvento = new Date(2018,07,07);
    }


    @Test
    public void testAgregarComentarioError() throws Exception {
        boolean comentarioVacio=false;
        try {
            unViaje.agregarComentario("fecha1", "autor", "");
        } catch (ContenidoVacioException e) {
            comentarioVacio=true;
        }
        
        assertTrue(comentarioVacio);
    }

    @Test
    public void testExisteEventoTrue() {
        boolean expResult = true;
        Evento evento1 = new Evento("Evento1");
        unViaje.agregarEventos(evento1);
        boolean result = unViaje.existeEvento(evento1);
        assertEquals(expResult, result);
    }

    @Test
    public void testExisteEventoFalse() {
        Evento evento1 = new Evento("Evento1");
        Evento evento2 = new Evento("Evento1");
        unViaje.agregarEventos(evento1);
        boolean result = unViaje.getListaEventos().contains(evento2);
        
        assertFalse(result);
    }

    @Test
    public void testAltaEventoOK() throws Exception {
        Evento evento1 = new Evento("Visita al parque");
        unViaje.altaEvento("Visita al parque", fechaEvento, "Parque","descripcion", tipoEvento);
        assert (unViaje.existeEvento(evento1));
    }

    @Test
    public void testAltaEventoErrorNombreNoExistente() throws Exception{
        boolean nomobreExistente=false;
        unViaje.altaEvento("Parque Acuaticoo", fechaEvento, "Aquopolis","Descripcion", tipoEvento);
        try {
            unViaje.altaEvento("Parque Acuatico", fechaEvento, "Aquopolis","Descripcion", tipoEvento);
        } catch (EventoExistenteException e) {
            nomobreExistente=true;
        }
        
        assertFalse(nomobreExistente);
    }

    @Test
    public void testAltaEventoErrorNombreExistente() throws Exception{
        boolean nomobreExistente=false;
        unViaje.altaEvento("Parque Acuatico", fechaEvento, "Aquopolis","Descripcion", tipoEvento);
        try {
            unViaje.altaEvento("Parque Acuatico", fechaEvento, "Aquopolis","Descripcion", tipoEvento);
        } catch (EventoExistenteException e) {
            nomobreExistente=true;
        }
        
        assertTrue(nomobreExistente);
    }

    @Test
    public void testAltaEventoErrorFechaVacia() throws Exception {
        boolean fechaCorrecto=false;
        try {
            unViaje.altaEvento("Parque Acuatico", null, "Aquopolis", "Descripcion", tipoEvento);
        } catch (FechaVaciaException e) {
            fechaCorrecto=true;
        }
        
        assertTrue(fechaCorrecto);
    }


    @Test
    public void testAltaEventoErrorFechaAnterior() throws Exception {
        Date nuevafecha = new Date(2011,06,06);
        boolean fechaCorrecta=true;
        try {
            unViaje.altaEvento("Parque Acuatico",nuevafecha, "Aquopolis","Descripcion", tipoEvento);
        } catch (FechaEventoFueraViajeException e) {
            fechaCorrecta=false;
        }
        
        assertFalse(fechaCorrecta);
    }

    @Test
    public void testAltaEventoErrorFechaPosterior() throws Exception {
        Date nuevafecha = new Date(2019,06,06);
        boolean fechaCorrecta=true;
        try {
            unViaje.altaEvento("Parque Acuatico", nuevafecha, "Aquopolis", "Descripcion", tipoEvento);
            assert (false);
        } catch (FechaEventoFueraViajeException e) {
            fechaCorrecta=false;
        }
        
        assertFalse(fechaCorrecta);
    }

    /**
     * Test of bajaEvento method, of class Viaje.
     */
    @Test
    public void testBajaEvento() throws EventoException, FechaException {
        Evento aux = new Evento("Evento");
        unViaje.agregarEventos(aux);
        unViaje.bajaEvento(aux);
        assertFalse(unViaje.getListaEventos().contains(aux));
    }


    @Test
    public void testGetDescripcion() {
        String expResult = "Descripcion";
        String result = unViaje.getDescripcion();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDescripcion() {
        String descripcion = "Nueva descripcion";
        unViaje.setDescripcion(descripcion);
        assertEquals(descripcion, unViaje.getDescripcion());
    }

    @Test
    public void testGetDestino() {
        Ciudad expResult = ciudad;
        Ciudad result = unViaje.getDestino();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDestino() {
        Ciudad destino = ciudad;
        unViaje.setDestino(destino);
        assertEquals(destino, unViaje.getDestino());
    }

    @Test
    public void testGetFechaFin() {
        Date fin =  new Date(23,11,204);
        Date result = unViaje.getFechaFin();
        assertEquals(fin, result);
    }

    @Test
    public void testSetFechaFin() {
        Date fechaFin = Calendar.getInstance().getTime();
        unViaje.setFechaFin(fechaFin);
        assertEquals(fechaFin, unViaje.getFechaFin());
    }


    @Test
    public void testGetFechaInicio() {
        Date expResult = Calendar.getInstance().getTime();
        Date result = unViaje.getFechaInicio();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetFechaInicio() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = null;
        try {
            fechaInicio = formatter.parse(Integer.parseInt("23") + "/" + Integer.parseInt("11")
                    + "/" + Integer.parseInt("2014"));
        } catch (ParseException ex) {
        }
        unViaje.setFechaInicio(fechaInicio);
        assertEquals(fechaInicio, unViaje.getFechaInicio());
    }

    @Test
    public void testGetNombre() {
        String expResult = "Vacaciones";
        String result = unViaje.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNombre() throws Exception {
        String nombre = "Negocio";
        unViaje.setNombre(nombre);
        assertEquals(nombre, unViaje.getNombre());
    }

    @Test
    public void testSetNombreErrorVacio() throws Exception {
        try {
            String nombre = "";
            unViaje.setNombre(nombre);
            assert (false);
        } catch (NombreViajeVacioException e) {
            assert (true);
        }
    }

    @Test
    public void testSetNombreErrorMuyCorto() throws Exception {
        try {
            String nombre = "V";
            unViaje.setNombre(nombre);
            assert (false);
        } catch (LargoNombreViajeInvalidoException e) {
            assert (true);
        }
    }

    @Test
    public void testSetNombreErrorMuyLargo() throws Exception {
        try {
            String nombre = "Nombre de viaje muy largo para validar";
            unViaje.setNombre(nombre);
            assert (false);
        } catch (LargoNombreViajeInvalidoException e) {
            assert (true);
        }
    }

    @Test
    public void testEqualsOK() throws ViajeException {
        Object obj = new Viaje("Vacaciones", ciudad, Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(), "Descripcion");
        boolean expResult = true;
        boolean result = unViaje.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsError1() throws ViajeException {
        Object obj = new Viaje("VACACIONES", ciudad, Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(), "Descripcion");
        boolean expResult = false;
        boolean result = unViaje.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsError2() throws ViajeException {
        Object obj = new Viaje("Negocio", ciudad, Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(), "Descripcion");
        boolean expResult = false;
        boolean result = unViaje.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testToStringError() {
        String expResult = "Vacaciones";
        String result = unViaje.toString();
        assertEquals(expResult, result);
    }
}
