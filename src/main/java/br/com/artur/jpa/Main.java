package br.com.artur.jpa;

import br.com.artur.jpa.entidade.Acessorio;
import br.com.artur.jpa.entidade.Carro;
import br.com.artur.jpa.entidade.Marca;

import jakarta.persistence.*;


import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("seuPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        Marca marca = new Marca();
        marca.setNome("Toyota");

        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setMarca(marca);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Ar-condicionado");



        carro.setAcessorios(List.of(acessorio));
        marca.setCarros(List.of(carro));

        em.persist(marca);
        em.persist(acessorio);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
