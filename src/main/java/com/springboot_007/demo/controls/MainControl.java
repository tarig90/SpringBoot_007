package com.springboot_007.demo.controls;


import com.springboot_007.demo.models.TvShow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainControl
{
    @GetMapping("/tvform")
    public String loadTvShow(Model model)
    {
        model.addAttribute("tvshow", new TvShow());
        return "tvform";
    }

    @PostMapping String processTvForm(@Valid @ModelAttribute("tvshow")TvShow tvShow, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "tvform";
        }
        return "tvshowconfirm";
    }

}
