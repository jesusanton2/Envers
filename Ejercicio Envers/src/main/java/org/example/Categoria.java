package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Audited
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categoria")
    private List<Articulo> articulos = new ArrayList<Articulo>();

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }

    public Categoria() {
    }

    public void setId(long id) {
        Id = id;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public long getId() {
        return Id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }
}

