package com.ndirangu.superdrive.service;

import com.ndirangu.superdrive.mapper.CredentialMapper;
import com.ndirangu.superdrive.model.Credential;
import com.ndirangu.superdrive.service.security.EncryptionService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialService {
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper,
                             EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    public List<Credential> listAllCredentials(Integer userId){
        return credentialMapper.listAllCredentials(userId);
    }

    public Credential findOne(Integer credentialId){
        return credentialMapper.findOne(credentialId);
    }


    private void encryptPassword(Credential credential) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), encodedKey);

        credential.setKey(encodedKey);
        credential.setPassword(encryptedPassword);
    }

    public int create(Credential credential){
        encryptPassword(credential);
        return credentialMapper.create(credential);
    }

    public void update(Credential credential){
        encryptPassword(credential);
        credentialMapper.update(credential);
    }

    public void deleteCredential(Integer credentialId){
        credentialMapper.delete(credentialId);
    }

}
