/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

import excepcion.MaEx;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alexandru
 */
public abstract class Vehicle {
    
    private String matricula;
    private String marca;

    public Vehicle(String matricula, String marca) throws MaEx {
        if (matricula == null || matricula.isBlank()) {
            throw new MaEx("Matrícula sense assignar");
        }
        if (marca == null || marca.isBlank()) {
            throw new MaEx("Marca sense assignar");
        }
        this.matricula = matricula;
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Vehicle)) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    public String getMarca() {
        return marca;
    }
    
    public abstract void afegirUnRepos(Repostage repos);

    public abstract String llistatRepositoris();
    
    public abstract String llistatRuta();
    
    public abstract void afegirRepostatges(List<Repostage> dadesRepostatge);

    @Override
    public String toString() {
        return matricula + " Marca:" + marca;
    }
}
