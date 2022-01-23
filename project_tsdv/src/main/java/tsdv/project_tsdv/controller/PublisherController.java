package tsdv.project_tsdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tsdv.project_tsdv.entity.Publishers;
import tsdv.project_tsdv.repository.PublishersRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin_publishers")
public class PublisherController {
    @Autowired
    PublishersRepository publishersRepository;

    @RequestMapping("")
    public String showPublishersList(Model model) {
        List<Publishers> publishersList = publishersRepository.findAll();
        model.addAttribute("publishersList", publishersList);
        return "admin/publishersList";
    }

    @RequestMapping("add")
    public String addPublishers(Model model) {
        Publishers publishers = new Publishers();
        model.addAttribute("publishers", publishers);
        return "admin/publishersAdd";
    }

    @RequestMapping("/edit/{id}")
    public String editBooks(
            @PathVariable(value = "id") Long id, Model model) {
        Publishers publishers = publishersRepository.getById(id);
        model.addAttribute("publishers", publishers);
        return "admin/publishersEdit";
    }
    @RequestMapping("/save")
    public String save(@Valid Publishers publishers, BindingResult result, Model model,
                       @RequestParam(value = "id", required=false) Long id)
    {
        if (result.hasErrors()) {
            if (id == null) {
                return "admin/publishersAdd";
            } else {
                return "admin/publishersEdit";
            }
        }
        publishers.setId(id);
        publishersRepository.save(publishers);
        return "redirect:/admin_publishers";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable ("id") Long id) {
        Publishers publishers = publishersRepository.getById(id);
        publishersRepository.delete(publishers);
        return "redirect:/admin_publishers";
    }
    @RequestMapping("/{id}")
    public String getAuthorById (Model model,
                                 @PathVariable(value= "id") Long id){
        Publishers publishers = publishersRepository.getById(id);
        model.addAttribute("publishers", publishers);
        return "admin/publishersDetail";
    }
    @RequestMapping("/search")
    public String searchBook(Model model, @RequestParam(value = "name")String name) {
        List<Publishers> publishersList = publishersRepository.findByUsernameContaining(name);
        model.addAttribute("publishersList",publishersList);
        return "admin/booksList";
    }
}
