package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.model.Todo;
import uz.pdp.service.TodoService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

        @GetMapping("/")
        public String main(
                Model model
        ){
                TodoService todoService=new TodoService();
                model.addAttribute("todoList", todoService.getALLTodo());
                return "todo";
        }
}
