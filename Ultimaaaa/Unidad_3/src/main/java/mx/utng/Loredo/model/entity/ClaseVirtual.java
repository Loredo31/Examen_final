package mx.utng.Loredo.model.entity;


import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ClaseVirtual {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 90)
    private String nombreClase;

    
    @Column(length = 90)
    private String plataforma;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombreClase() {
        return nombreClase;
    }


    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }


    public String getPlataforma() {
        return plataforma;
    }


    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

   
}
