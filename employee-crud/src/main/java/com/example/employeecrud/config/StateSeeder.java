package com.example.employeecrud.config;

import com.example.employeecrud.state.State;
import com.example.employeecrud.state.StateRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Fills the states table with Indian states / UTs only when it is empty (existing data is never touched). */
@Component
public class StateSeeder implements CommandLineRunner {

    private final StateRepository repo;

    public StateSeeder(StateRepository repo) { this.repo = repo; }

    @Override
    public void run(String... args) {
        if (repo.count() > 0) return;
        String[][] s = {
            {"AP","Andhra Pradesh"},{"AR","Arunachal Pradesh"},{"AS","Assam"},{"BR","Bihar"},{"CG","Chhattisgarh"},
            {"GA","Goa"},{"GJ","Gujarat"},{"HR","Haryana"},{"HP","Himachal Pradesh"},{"JH","Jharkhand"},
            {"KA","Karnataka"},{"KL","Kerala"},{"MP","Madhya Pradesh"},{"MH","Maharashtra"},{"MN","Manipur"},
            {"ML","Meghalaya"},{"MZ","Mizoram"},{"NL","Nagaland"},{"OD","Odisha"},{"PB","Punjab"},
            {"RJ","Rajasthan"},{"SK","Sikkim"},{"TN","Tamil Nadu"},{"TS","Telangana"},{"TR","Tripura"},
            {"UP","Uttar Pradesh"},{"UK","Uttarakhand"},{"WB","West Bengal"},
            {"AN","Andaman and Nicobar Islands"},{"CH","Chandigarh"},{"DN","Dadra and Nagar Haveli and Daman and Diu"},
            {"DL","Delhi"},{"JK","Jammu and Kashmir"},{"LA","Ladakh"},{"LD","Lakshadweep"},{"PY","Puducherry"}
        };
        repo.saveAll(java.util.Arrays.stream(s).map(x -> new State(x[0], x[1])).toList());
    }
}
