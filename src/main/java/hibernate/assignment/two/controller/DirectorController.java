package hibernate.assignment.two.controller;

import hibernate.assignment.two.entity.Director;
import hibernate.assignment.two.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/directors")
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @RequestMapping("/")
    public List<Director> directorList(){
        return directorService.directorList();
    }

    @RequestMapping(value = "/add_director", method = RequestMethod.POST)
    public String addDirector(@RequestBody Director director){
        if(director.getFirstName() != null){
            directorService.addDirector(director);
            return "Director Added Successfully";
        }
        return "Operation Failed";
    }

    @RequestMapping(value = "/delete_director/{id}", method = RequestMethod.DELETE)
    public String deleteDirector(@PathVariable Integer id){
        if(id != null){
            directorService.deleteDirector(directorService.findDirectorId(id));
            return "Record Deleted Successfully";
        }
        return "Operation Failed";
    }
}
