package ma.emsi.jpaapp.repositories;

import ma.emsi.jpaapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository <Patient,Long>{
    public List<Patient> findByMalade(boolean m);
     Page<Patient> findByMalade(boolean m, Pageable pageable);
    List<Patient> findByMaladeAndScoreLessThan(boolean m , int score);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1,Date d2, String mc);
    @Query("select p from Patient p where  p.nom like :z and p.score<:y")
    List<Patient> chercherPatients(@Param("z") String nom, @Param("y") int scoreMin);

}
