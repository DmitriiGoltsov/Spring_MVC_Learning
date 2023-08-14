package com.goltsov.springcourse.controllers;

import com.goltsov.springcourse.utils.Operation;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        /*if (name != null && surname != null) {
            System.out.println("\n" + "Hello, " + name + " " + surname + "\n");
        }*/

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "operand1", required = false) String operand1,
                            @RequestParam(value = "operand2", required = false) String operand2,
                            @RequestParam(value = "operation") Operation operation,
                            Model model) {

        if (operand1 == null || operand2 == null || operation == null) {
            throw new RuntimeException("Один из операндов или оператор"
                    + " не заполнен(ы). Проверьте входные данные!");
        }

        int firstOperand = Integer.parseInt(operand1);
        System.out.println(firstOperand);
        int secondOperand = Integer.parseInt(operand2);
        System.out.println(secondOperand);

        System.out.println(operation);

        double result;

        switch (operation) {
            case addition:
                result = firstOperand + secondOperand;
                break;
            case multiplication:
                result = firstOperand * secondOperand;
                break;
            case subtraction:
                result = firstOperand - secondOperand;
                break;
            case division:
                result = (double) firstOperand / secondOperand;
                break;
            default:
                throw new RuntimeException("The operation type you have chosen is not supported yet!");
        }

        System.out.println(result);

        model.addAttribute("mathResult", "The result of your operation is: " + result);

        return "first/calculator";
    }
}
