package springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,   // c помощью спринга
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {

        //System.out.println("GoodBye " + name + " " + surname);

        model.addAttribute("message", "GoodBye " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) int a,
                                 @RequestParam(value = "b", required = false) int b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model) {
        model.addAttribute("action", getResult(a, b, action));
        return "/first/calculator";
    }

    public double getResult(int a, int b, String action) {
        double result = 0.0;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double)b;
                break;
        }
        return result;
    }
}

