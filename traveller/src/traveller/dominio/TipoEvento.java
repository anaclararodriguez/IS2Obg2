package traveller.dominio;

import java.io.Serializable;

public final class TipoEvento implements Serializable{
    private String nombre;
    
    public TipoEvento(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    @Override
    public boolean equals(Object obj){
        TipoEvento tipoEvento = ((TipoEvento) obj);
        return this.getNombre().equalsIgnoreCase(tipoEvento.getNombre());
    }
};