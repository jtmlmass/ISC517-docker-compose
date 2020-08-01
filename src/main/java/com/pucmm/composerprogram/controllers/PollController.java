package com.pucmm.composerprogram.controllers;

import com.pucmm.composerprogram.entities.Poll;
import com.pucmm.composerprogram.entities.User;
import com.pucmm.composerprogram.repositories.PollRepository;
import com.pucmm.composerprogram.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class PollController {
    private final UserRepository userRepository;
    private final PollRepository pollRepository;

    private final String mainHeader = "Give us your opinion!";
    private final String pathHeader = "Fill de poll which any value you see true to your experience. ";
    private final String copyRight = "Copyright &copy; Your Website 2019";

    public PollController(UserRepository userRepository, PollRepository pollRepository){
        this.userRepository = userRepository;
        this.pollRepository = pollRepository;
    };

    @GetMapping("/poll")
    public String poll(Principal principal, Model model){
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("isAdmin", user.isAdmin());

        int pollsNumber = pollRepository.findByUser(user).size();
        model.addAttribute("pollsNumber", pollsNumber);

        String template = "poll.ftl";
        model.addAttribute("plantilla", template);
        return "/base";
    }

    @GetMapping("/polls")
    public String polls(Principal principal, Model model){
        model.addAttribute("pathHeader", "Results of the polls done. ");
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", "Report");
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("isAdmin", user.isAdmin());

        List<Poll> polls = pollRepository.findAll();
        model.addAttribute("polls", polls);

        //Valores para gráfica
        Integer value1 = pollRepository.findValuesToAnswer1(1);
        model.addAttribute("question11", (value1 != null ? value1 : 0));
        Integer value2 = pollRepository.findValuesToAnswer1(2);
        model.addAttribute("question12", (value2 != null ? value2 : 0));
        Integer value3 = pollRepository.findValuesToAnswer1(3);
        model.addAttribute("question13", (value3!= null ? value3 : 0));
        Integer value4 = pollRepository.findValuesToAnswer1(4);
        model.addAttribute("question14", (value4 != null ? value4 : 0));
        Integer value5 = pollRepository.findValuesToAnswer1(5);
        model.addAttribute("question15", (value5 != null ? value5 : 0));

        value1 = pollRepository.findValuesToAnswer2(1);
        model.addAttribute("question21", (value1 != null ? value1 : 0));
        value2 = pollRepository.findValuesToAnswer2(2);
        model.addAttribute("question22", (value2 != null ? value2 : 0));
        value3 = pollRepository.findValuesToAnswer2(3);
        model.addAttribute("question23", (value3!= null ? value3 : 0));
        value4 = pollRepository.findValuesToAnswer2(4);
        model.addAttribute("question24", (value4 != null ? value4 : 0));
        value5 = pollRepository.findValuesToAnswer2(5);
        model.addAttribute("question25", (value5 != null ? value5 : 0));

        value1 = pollRepository.findValuesToAnswer3(1);
        model.addAttribute("question31", (value1 != null ? value1 : 0));
        value2 = pollRepository.findValuesToAnswer3(2);
        model.addAttribute("question32", (value2 != null ? value2 : 0));
        value3 = pollRepository.findValuesToAnswer3(3);
        model.addAttribute("question33", (value3!= null ? value3 : 0));
        value4 = pollRepository.findValuesToAnswer3(4);
        model.addAttribute("question34", (value4 != null ? value4 : 0));
        value5 = pollRepository.findValuesToAnswer3(5);
        model.addAttribute("question35", (value5 != null ? value5 : 0));

        value1 = pollRepository.findValuesToAnswer4(1);
        model.addAttribute("question41", (value1 != null ? value1 : 0));
        value2 = pollRepository.findValuesToAnswer4(2);
        model.addAttribute("question42", (value2 != null ? value2 : 0));
        value3 = pollRepository.findValuesToAnswer4(3);
        model.addAttribute("question43", (value3!= null ? value3 : 0));
        value4 = pollRepository.findValuesToAnswer4(4);
        model.addAttribute("question44", (value4 != null ? value4 : 0));
        value5 = pollRepository.findValuesToAnswer4(5);
        model.addAttribute("question45", (value5 != null ? value5 : 0));

        String template = "polls.ftl";
        model.addAttribute("plantilla", template);
        return "/base";
    }

    // TODO crear los polls
    @PostMapping("/polls/create")
    public String createPoll(@RequestParam int answer1, @RequestParam int answer2,
                             @RequestParam int answer3, @RequestParam int answer4,
                             Principal principal, Model model) {
        User user = userRepository.findByUsername(principal.getName());
        Poll poll = new Poll(0, "¿Las charlas donde usted participó cumplieron con sus expectativas?",
                                           "¿Los expositores mostraron tener dominio del tema?",
                                           "¿Las instalaciones del evento fueron comfortables para usted?",
                                           "¿Las charlas donde usted participó cumplieron con sus expectativas?",
                                            answer1, answer2, answer3, answer4, user);
        pollRepository.save(poll);
        return "redirect:/poll";
    }
}
