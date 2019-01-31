package com.example.example.contoller;

import com.example.example.security.Encryption;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class MainController {
    private Encryption encryption;
    private Map<String, String> map;

    @Autowired
    public MainController(Encryption encryption) {
        this.encryption = encryption;
    }

    @PostMapping("/")
    public String show() {
        return "hello";
    }

    @PostMapping("/encode")
    public Map showEncryptText(@RequestParam(value = "line", required = false, defaultValue = "Hello anyone") String line) throws NoSuchPaddingException, UnsupportedEncodingException,
            InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException {
        encryption.encode(line);
        map = new HashMap<>();
        map.put("encode", encryption.getCrypt());
        return map;
    }

    @PostMapping("/decode")
    public Map showDecryptText(@RequestParam(value = "line",required = false,defaultValue = "Sa1yCknYUbnHaGknx/Tm0Q==")String line)
            throws NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException,
            NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, Base64DecodingException, InvalidKeyException {
        encryption.decode(line);
        map = new HashMap<>();
        map.put("decode", encryption.getDecrypt());
        return map;
    }

}
