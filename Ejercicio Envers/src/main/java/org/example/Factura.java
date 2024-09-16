package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Audited
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "total")
    private int total;

    @Column(name = "numero")
    private int numero;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_Cliente")
    private Cliente cliente;


    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetalleFactura> detallesFacturas = new ArrayList<DetalleFactura>();

    public Factura(String fecha, int total, int numero) {
        this.fecha = fecha;
        this.total = total;
        this.numero = numero;

    }

    public Factura(){}

    public Factura( String fecha, int total, int numero, Cliente cliente) {
        this.fecha = fecha;  // Esto se puede solucionar con un builder
        this.total = total;
        this.numero = numero;
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(List<DetalleFactura> detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public long getId() {
        return Id;
    }

    public String getFecha() {
        return fecha;
    }

    public int getTotal() {
        return total;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
