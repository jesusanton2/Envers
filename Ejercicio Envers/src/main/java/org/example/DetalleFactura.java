package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;


@Entity
@Audited
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private int subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_factura")
   private Factura factura;

   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "fk_articulo")
    private Articulo articulo;

    //Constructores

    public DetalleFactura(int cantidad, int subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleFactura() {
    }

    public DetalleFactura(int cantidad,int subtotal, Factura factura){
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
//Getter Y Setter


    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Factura getFactura() {
        return factura;
    }

    public long getId() {
        return Id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
