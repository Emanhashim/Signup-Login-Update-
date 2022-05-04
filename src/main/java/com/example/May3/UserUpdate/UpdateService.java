package com.example.May3.UserUpdate;

import com.example.May3.Domain.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {

    @Autowired
    private UpadateRepository upadateRepository;

    public ResponseEntity<?> updatePassword(UpdateRequest request, String newpassword, String onldpass) {
        RegisterUser register = upadateRepository.findByUsername(request.getUsername()).get();

        register.setPassword(newpassword);
        upadateRepository.save(register);

        return ResponseEntity.ok(new UpdateResponse("successfully updated password"));

    }

}
