package com.rentingapp.rentcar.modules.renting;

import com.rentingapp.rentcar.modules.renting.entity.Renting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/renting")
public class RentingController {
    @Autowired
    RentingService rentingService;

    @PostMapping("/add")
    public Renting addRenting(@RequestBody Map<String, String> rent) {
        return rentingService.addRenting(rent);
    }

    @GetMapping("/{id}")
    public Renting getRenting(@PathVariable int id) {
        return rentingService.getRenting(id);
    }
}
