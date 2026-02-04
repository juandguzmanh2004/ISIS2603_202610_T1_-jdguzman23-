package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class MovieEntity extends BaseEntity {
    private String title;
    private Integer releaseYear;

    @ManyToOne
    private DirectorEntity director;

    @ManyToMany (mappedBy = "movies")
    private List<GenreEntity> genres= new ArrayList<>();

    @OneToOne (
        mappedBy = "movie",
        cascade = jakarta.persistence.CascadeType.REMOVE,  
        orphanRemoval = true
    )
    private ScriptEntity script;
}
