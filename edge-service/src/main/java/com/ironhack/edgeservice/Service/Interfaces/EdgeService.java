package com.ironhack.edgeservice.Service.Interfaces;

import com.ironhack.edgeservice.Classes.Account;
import com.ironhack.edgeservice.Classes.Opportunity;
import com.ironhack.edgeservice.Controller.DTO.AccountDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EdgeService {
    /*
    List<AccountDTO> showAccountsDTO (List<Account> accountList);
     */
    void convertLead(@PathVariable Long id, @RequestBody Opportunity opportunity);
}
