package com.sfm.thebarn.thebarn;

import com.sfm.thebarn.thebarn.controller.PassEncry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*It is just a simple introduction of Junit under Spring Boot*/

@SpringBootTest
public class PassGenTests {
    @Test
    void passGen_palika() {
        String word_decry = "palika";
        String word_encry = "bc968290cf3f6ca739e9769f8e6a4fb1c4bbecc66c53577f049dc132e1db99c3";
        String result = PassEncry.HashString(word_decry);
        assertTrue(result.equals(word_encry));
    }

    @Test
    void passGen_barn() {
        String word_decry = "The Barn Test";
        String word_encry = "d4b8ce6109bd799e3aa49e9772e19bdf32f02ffd968ab7742b493b03cb8f9f84";
        String result = PassEncry.HashString(word_decry);
        assertTrue(result.equals(word_encry));
    }

    @Test
    void passGen_legjobb() {
        String word_decry = "Ez a legjobb projekt!";
        String word_encry = "1d74e3228297c84185afe5a18c6c91079f36a4a19bf279ebeeb2d3e21f8a9b12";
        String result = PassEncry.HashString(word_decry);
        assertTrue(result.equals(word_encry));
    }

    @Test
    void passGen_doublepass() {
        String word_decry = "password";
        String encry = PassEncry.HashString(word_decry);
        assertTrue(PassEncry.HashString(word_decry).equals(encry));
    }
}
