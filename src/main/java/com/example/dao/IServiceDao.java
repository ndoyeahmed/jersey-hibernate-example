package main.java.com.example.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import main.java.com.example.models.Employe;
import main.java.com.example.models.Service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IServiceDao {
    List<Service> all();
    Service getById(Long id);
    Boolean addEmploye(Employe employe);
    List<Employe> allEmploye();
    Employe getEmployeById(Long id);
}
