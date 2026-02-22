package br.com.davidd5.service;

import br.com.davidd5.exception.ResourceNotFoundExceptions;
import br.com.davidd5.model.Person;
import br.com.davidd5.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());


    @Autowired
    PersonRepository repository;


    public List<Person> findAll(){
        logger.info("Finding all People!");

       return repository.findAll();

    }


    public Person findById(Long id){
        logger.info("Finding one Person!");

     return repository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundExceptions("No records found for this ID"));

    }

    public Person create(Person person){
        logger.info("Creating one Person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one Person");
        Person entity =  repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundExceptions("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Delete one Person !");

       Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No records found for this ID"));
        repository.delete(entity);
    }

}
