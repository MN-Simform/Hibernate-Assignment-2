package hibernate.assignment.two.services;

import hibernate.assignment.two.entity.Director;

import java.util.List;

public interface DirectorService {

    public List<Director> directorList();

    public Director findDirectorId(Integer id);

    public void addDirector(Director director);

    public void deleteDirector(Director director);
}
