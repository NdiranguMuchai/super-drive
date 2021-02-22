package com.ndirangu.superdrive.controller;

import com.ndirangu.superdrive.model.Credential;
import com.ndirangu.superdrive.model.Note;
import com.ndirangu.superdrive.model.User;
import com.ndirangu.superdrive.service.CredentialService;
import com.ndirangu.superdrive.service.FileService;
import com.ndirangu.superdrive.service.NoteService;
import com.ndirangu.superdrive.service.UserService;
import com.ndirangu.superdrive.service.security.EncryptionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final NoteService noteService;
    private final UserService userService;
    private final CredentialService credentialService;
    private final EncryptionService encryptionService;
    private final FileService fileService;

    public HomeController(NoteService noteService,
                          UserService userService,
                          CredentialService credentialService,
                          EncryptionService encryptionService,
                          FileService fileService){

        this.noteService = noteService;
        this.userService = userService;
        this.credentialService  =credentialService;
        this.encryptionService = encryptionService;
        this.fileService = fileService;
    }

    @GetMapping
    public String getHomePage(Model model, Authentication authentication){
        User user = userService.getUser(authentication.getName());

        String emptyString = "";
        Credential credential = new Credential(0, emptyString, emptyString, emptyString, emptyString, user.getUserId());
        Note note = new Note(0, emptyString, emptyString, user.getUserId());

        model.addAttribute("notes",noteService.getNotes(user.getUserId()));
        model.addAttribute("credentialsList", credentialService.listAllCredentials(user.getUserId()));
        model.addAttribute("credentialItem", credential);
        model.addAttribute("encryptionService", encryptionService);
        model.addAttribute("noteItem", note);
        model.addAttribute("filesList", fileService.listAll(user.getUserId()));

        return "home";
    }

}
