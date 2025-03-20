package com.example.facebooklogin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class controller {

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> user = principal.getAttributes();
        return "Welcome user " + user.get("name");
    }

    @GetMapping("/token")
    public String getToken(@RegisteredOAuth2AuthorizedClient("facebook") OAuth2AuthorizedClient authorizedClient) {
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        return "Access Token: " + accessToken;
    }
}
