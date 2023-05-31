package hibernate.assignment.two.services.impl;

import hibernate.assignment.two.entity.Director;
import hibernate.assignment.two.repository.DirectorRepo;
import hibernate.assignment.two.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    @Override
    public List<Director> directorList() {
        return directorRepo.findAll();
    }

    @Override
    public Director findDirectorId(Integer id) {
        return directorRepo.findDirectorsById(id);
    }

    @Override
    public void addDirector(Director director) {
        directorRepo.save(director);
    }

    @Override
    public void deleteDirector(Director director) {
        directorRepo.delete(director);
    }
}
