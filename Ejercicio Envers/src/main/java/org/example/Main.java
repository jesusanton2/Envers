package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
            // Persistir
            entityManager.getTransaction().begin();

            //Creo Cliente
            Cliente cliente1 = new Cliente(11111,"Fermin","Lopez");


            //CreoDomicilio
            Domicilio domicilio1= new Domicilio("San Martin",123);

            //Creo Una factura
            Factura factura1= new Factura("12-02-22",2500,25);

            //Creo detalle factura
            DetalleFactura detalle1 = new DetalleFactura(5,500);
            DetalleFactura detalle2 = new DetalleFactura(10,10000);
            DetalleFactura detalle3 = new DetalleFactura(1,150000);

            //Creo categoria
            Categoria Electricidad = new Categoria("Electricidad");

            //Creo articulo
            Articulo articulo1 = new Articulo(1,"Enchufe",100);
            Articulo articulo2= new Articulo(1,"Cable reforzado x mt",1000);
            Articulo articulo3 = new Articulo(1,"Generador",15000);
            factura1.setCliente(cliente1);


            //Asigno y hago la bidireccionalidad
            cliente1.setDomicilio(domicilio1);
            domicilio1.setCliente(cliente1);
            factura1.setCliente(cliente1);
            cliente1.getFacturas().add(factura1);



            factura1.getDetallesFacturas().add(detalle1);
            factura1.getDetallesFacturas().add(detalle2);
            factura1.getDetallesFacturas().add(detalle3);

            articulo1.getCategoria().add(Electricidad);
            articulo2.getCategoria().add(Electricidad);
            articulo3.getCategoria().add(Electricidad);
            Electricidad.getArticulos().add(articulo1);
            Electricidad.getArticulos().add(articulo2);
            Electricidad.getArticulos().add(articulo3);

            detalle1.setArticulo(articulo1);
            detalle2.setArticulo(articulo2);
            detalle3.setArticulo(articulo3);

            detalle1.setFactura(factura1);
            detalle2.setFactura(factura1);
            detalle3.setFactura(factura1);

            articulo1.getDetalleFacturas().add(detalle1);
            articulo2.getDetalleFacturas().add(detalle2);
            articulo3.getDetalleFacturas().add(detalle3);


            entityManager.flush();


            entityManager.getTransaction().commit();
            // Consultar cliente y mostrar entidad persistida
           /*  Cliente mostrarCliente = entityManager.find(Cliente.class,cliente1.getId());
            System.out.println("Cliente: "+mostrarCliente.getNombre() + " " + mostrarCliente.getApellido());
            Factura mostrarFactura = entityManager.find(Factura.class, factura1.getId());
            System.out.println("Factura: "+mostrarFactura.getDetallesFacturas()
                                 + " "        +mostrarFactura.getCliente()
                                 + " "         +mostrarFactura.getFecha()
                  );     */
            // Consultar y mostrar la entidad persistida
          //  Persona retrievedPerson = entityManager.find(Persona.class, person.getId());
            //System.out.println("Retrieved Person: " + retrievedPerson.getName());

        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase ");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
