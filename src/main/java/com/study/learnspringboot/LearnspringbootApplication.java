package com.study.learnspringboot;

import com.study.learnspringboot.Dto.Person;
import com.study.learnspringboot.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class LearnspringbootApplication {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    String index(){ return  "Hello Spring Boot";}

    @RequestMapping("/getName")
    public String getBookname(){
        return "book name is :"+bookName+"--book author is:"+bookAuthor;
    }

    @RequestMapping("/getAuthor")
    public String getAuthor(){
        return "author name is :"+authorSettings.getName()
                +" and author age is:"+authorSettings.getAge();
    }

    @RequestMapping("/getPerson")
    public String getPerson(Model model){
        Person single = new Person("小明",11);

        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("张小凡",20);
        Person p2 = new Person("叶小天",22);
        Person p3 = new Person("朱小光",18);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);


        return "getPerson";
    }


    public static void main(String[] args) {
        SpringApplication.run(LearnspringbootApplication.class, args);
    }

}
