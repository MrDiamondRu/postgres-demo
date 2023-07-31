package ru.work.group7.postgresdemo.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.work.group7.postgresdemo.domain.DbData;
import ru.work.group7.postgresdemo.repository.DbDataRepository;

import java.util.HashMap;
import java.util.List;

/**
 * @author rnikonov
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class WebController {

    private final DbDataRepository dbDataRepository;

    @GetMapping("/search")
    public String searchAllDbData() {
        var data = dbDataRepository.findAll();

        var result = new StringBuilder();
        for (var row : data) {
            result.append(row.getData());
        }
        return result.toString();
    }

    @GetMapping("/save")
    public String saveDbData() {
        var row = new DbData();

        var data = new HashMap<String, Object>();
        data.put("key_1", "value_1");
        data.put("key_2", "value_2");
        row.setData(data);

        dbDataRepository.save(row);


        return "OK";
    }
}
