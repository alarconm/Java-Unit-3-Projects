package org.launchcode.hellospring.Controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;
import java.util.HashMap;

@Controller
public class HelloController {

    Languages dropDown = new Languages();
    HashMap language = dropDown.createMap();

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }
        return "Hello" + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'> " +
                " <option value='" + language.get("English") + "'>" + language.get("English") + "</option>" +
                " <option value='" + language.get("French") + "'>" + language.get("French") + "</option>" +
                " <option value='" + language.get("German") + "'>" + language.get("German") + "</option>" +
                " <option value='" + language.get("Spanish") + "'>" + language.get("Spanish") + "</option>" +
                " <option value='" + language.get("Arabic") + "'>" + language.get("Arabic") + "</option>" + "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

        public static String createMessage(String name, String language){
            String greeting = "";

            if (language.equals( "French")){
                greeting = "Bonjour";
            } else if (language.equals("English")) {
                greeting = "Hello";
            } else if (language.equals("Spanish") ) {
                greeting = "Hola";
            } else if (language.equals("German")) {
                greeting = "Guten Tag";
            } else if (language.equals("Arabic")) {
                greeting = "marhabaan";
            }

            return "<h1>" + greeting + " " + name + "!</h1>";
        }
    static int counter = 0;

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        counter++;
        String greeting = createMessage(request.getParameter("name"), request.getParameter("language"));

        return greeting + "You have visited " + counter + " times";
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {

        return "Hello " + name;

    }

    @RequestMapping(value = "goodbye")
    public String goodBye() {

        return "redirect:/";
    }
}
