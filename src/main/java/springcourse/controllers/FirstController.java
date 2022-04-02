package springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {   // для приема параметров.Содержит все сведения о HTTP запросе от пользователя.
        String name = request.getParameter("name"); //name - это ключ, для получения параметра
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) { // c помощью спринга

        System.out.println("GoodBye " + name + " " + surname);
        return "first/goodbye";
    }
}
