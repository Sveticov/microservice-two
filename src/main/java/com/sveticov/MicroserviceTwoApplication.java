package com.sveticov;

import com.sveticov.model.ThemaEnglish;
import com.sveticov.model.User;
import com.sveticov.model.Vocabulary;
import com.sveticov.repository.UserRepository;
import com.sveticov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class MicroserviceTwoApplication implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTwoApplication.class, args);
    }

    Set<ThemaEnglish> themaEnglishesl1;
    List<User> userList;

    @Override
    public void run(String... strings) throws Exception {
        // userService.test();
        // repository.deleteAll();
//
        long id = repository.count();
        List<Vocabulary> vocabularies = new ArrayList<>();
        vocabularies.add(new Vocabulary("ru" + id, "en" + id));
        vocabularies.add(new Vocabulary("ru" + id + 1, "en" + id + 1));
        List<ThemaEnglish> themaEnglishes = new ArrayList<>();
        themaEnglishes.add(new ThemaEnglish("th" + id, vocabularies));
        themaEnglishes.add(new ThemaEnglish("th" + (id + 1), vocabularies));
        themaEnglishes.add(new ThemaEnglish("th" + (id + 2), vocabularies));

        repository.save(new User(id, "n" + id, "l" + id, "p" + id, themaEnglishes));
        // List<User>
        userList = repository.findAll();

        userList.forEach(System.out::println);


        Map<String, List<ThemaEnglish>> userListMap = userList.stream()
                .collect(Collectors.toMap(u -> u.getNameUser(), p -> p.getThemaEnglishList()));
        userListMap.forEach((k, v) -> System.out.println(k + "  " + v));


        //Set<ThemaEnglish>
        themaEnglishesl1 = userListMap.values().stream()
                .map(themaEnglishes1 -> themaEnglishes1.listIterator())
                .map(themaEnglishListIterator -> themaEnglishListIterator.next())

                .collect(Collectors.toSet());

        themaEnglishesl1.stream().forEach(System.out::println);

        Set<Vocabulary> vocabularies1 = themaEnglishesl1.stream()
                .map(themaEnglish -> themaEnglish.getVocabularies().listIterator().next())

                .collect(Collectors.toSet());

        vocabularies1.forEach(System.out::println);

    }


    @GetMapping("/two")
    public String twoMic(
    ) {
        return "microservice two";
    }

    @GetMapping("/th")
    @ResponseBody
    public Set<ThemaEnglish> themaEnglishes() {
        return themaEnglishesl1;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public Map<String, List<User>> userList(@PathVariable long id, HttpSession session) {
        List<User> users = userList.stream()
                .filter(user -> user.getIdUser() == id)
                .collect(Collectors.toList());
        Map<String, List<User>> map = new HashMap<>();
        map.put("Success id: " + id + " " + session.getId() + "  " + session.toString(), users);
        if (users.isEmpty()) {
            map.clear();
            map.put("Error id: " + id + " " + session.getId() + "  " + session.toString(), users);
            return map;
        }
        return map;
    }
}
