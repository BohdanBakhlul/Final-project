package Shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    private NoteRepository noteRepository;

    private User curentUser = null;


    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

//    @GetMapping(path="/login")
//    public @ResponseBody String login (@RequestParam String email) {
//
//        User n = new User();
//        n.setName(name);
//        n.setEmail(email);
//        userRepository.save(n);
//        return "Saved";
//    }



    @GetMapping(path="/addnote")
    public @ResponseBody String addNewNote (@RequestParam String header
            , @RequestParam String text, @RequestParam Integer user_id) {

        Note n = new Note();
        n.setHeader(header);
        n.setText(text);

        Optional<User> u = Optional.of(new User());
        u = userRepository.findById(user_id);

        u.get().addNote(n);

        userRepository.save(u.get());

        return "Saved to " + u.get().getName();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
