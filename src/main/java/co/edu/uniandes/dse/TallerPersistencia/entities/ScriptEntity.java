package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ScriptEntity extends BaseEntity {
    private String name;
    private String originalName;

    @OneToOne
    @JoinColumn(name = "movie_id",nullable = false)
    private MovieEntity movie;
}