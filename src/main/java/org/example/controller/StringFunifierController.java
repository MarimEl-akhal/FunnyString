package org.example.controller;


import org.example.dto.RequestData;
import org.example.dto.ResponseData;
import org.example.service.StringFunifierService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StringFunifierController {

    private final StringFunifierService stringFunifierService;

    public StringFunifierController(StringFunifierService stringFunifierService) {
        this.stringFunifierService = stringFunifierService;
    }

    @PostMapping("/funies/fun-range-funny-string")
    public ResponseData fun(@RequestBody RequestData requestData) {
        return stringFunifierService.funniesString(requestData);
    }

    @PostMapping("/fun-range")
    public ResponseData getFunRange(@RequestBody RequestData requestData) {
        return stringFunifierService.getFunRanges(requestData);
    }

    @PostMapping("/funny-string")
    public ResponseData getFunnyString(@RequestBody RequestData requestData) {
        return stringFunifierService.getFunnyString(requestData);
    }


}
