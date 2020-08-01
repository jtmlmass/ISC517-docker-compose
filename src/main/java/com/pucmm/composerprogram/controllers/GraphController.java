package com.pucmm.composerprogram.controllers;

import com.pucmm.composerprogram.entities.Poll;
import com.pucmm.composerprogram.repositories.PollRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class GraphController {
    private final PollRepository pollRepository;

    public GraphController(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    };

    @GetMapping("/report")
    public String graph(Principal principal, Model model){
        List<Poll> polls = pollRepository.findAll();
        model.addAttribute("polls", polls);
        return "/base";
    };
}
