package traveller.dominio;

import java.io.Serializable;

public final class Ciudad implements Serializable{
    private String nombre;
    
    public Ciudad(String nombre){
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
        Ciudad ciudad = ((Ciudad) obj);
        return this.getNombre().equalsIgnoreCase(ciudad.getNombre());
    }
    
};

