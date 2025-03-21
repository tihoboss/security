package tiho.boss.sqll2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiho.boss.sqll2.Person;
import tiho.boss.sqll2.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface SRepository extends JpaRepository<Persons, Person> {

    List<Persons> findByCityOfLiving(String city);
    List<Persons> findById_Age(int age);
    Optional<Persons> findById_NameAndId_Surname(String name, String surname);
}