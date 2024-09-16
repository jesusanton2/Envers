package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "Articulo")
@Audited
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "cantidad")
    private int   cantidad;

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "precio")
    private int precio;

    @OneToMany(mappedBy = "articulo",cascade = CascadeType.PERSIST)
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "articulo_catgoria" ,
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categoria = new ArrayList<Categoria>();


    public Articulo(int cantidad,String denominacion,int precio){
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    public Articulo(){

    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public long getId() {
        return Id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getPrecio() {
        return precio;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }
}
