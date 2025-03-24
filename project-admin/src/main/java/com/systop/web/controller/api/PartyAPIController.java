package com.systop.web.controller.api;

import com.systop.system.domain.Party;
import com.systop.system.service.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class PartyAPIController {
    @Autowired
    private IPartyService partyService;

    @PostMapping("/register")
    public String register(@RequestBody Party party) {
        return partyService.register(party);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return partyService.login(username, password);
    }
}
