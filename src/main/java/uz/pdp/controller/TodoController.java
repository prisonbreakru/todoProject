package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.model.Todo;
import uz.pdp.service.Base;

@Controller
@RequestMapping("/api/v1/todo")
public class TodoController {
    private Base<Todo> base;

    public TodoController(Base<Todo> base) {
        this.base = base;
    }

    @PostMapping("/add")
    public String addStudent(
            @ModelAttribute Todo todo,
            Model model
    ) {
        base.add(todo);
        model.addAttribute("todoList", base.getALLTodo());
        return "todo";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(
            @ModelAttribute Todo editTodo,
            Model model
    ) {
        base.update(editTodo);

        model.addAttribute("todoList", base.getALLTodo());
        return "todo";
    }


    @GetMapping("/edit/{id}")
    public String getOneTodo(
            @PathVariable long id,
            Model model
    ) {
        Todo todo = base.get(id);

        model.addAttribute("todo", todo);
        return "todoEdit";
    }


    @GetMapping("/delete/{id}")
    public String deleteStudentId(
            @PathVariable long id,
            Model model
    ){
        base.delete(id);
        model.addAttribute("todoList", base.getALLTodo());
        return "todo";
    }

    @GetMapping("/add")
    public String addTodo(
    ) {
        return "todoAdd";
    }

    @GetMapping("/completed/{id}")
    public String completeTodo(
            @PathVariable Long id,
            Model model
    ) {
        base.completed(id);

        model.addAttribute("todoList",base.getALLTodo());
        return "todo";
    }

}
