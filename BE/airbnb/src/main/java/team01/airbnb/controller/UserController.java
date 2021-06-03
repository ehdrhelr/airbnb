package team01.airbnb.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team01.airbnb.config.auth.dto.SessionUser;
import team01.airbnb.domain.User;
import team01.airbnb.dto.SocialProfile;
import team01.airbnb.service.UserService;

import javax.servlet.http.HttpSession;

@Api(tags = {"유저관련 API"}, description = "현재는 카카오 로그인과 로그아웃")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    @GetMapping("/auth/kakao/callback")
    public String kakaoCallBack(@RequestParam("code") String code) {
        String accessToken = userService.getAccessToken(code);
        SocialProfile kakaoProfile = userService.getKakaoProfile(accessToken);
        User kakaoUser = User.fromSocialProfile(kakaoProfile);
        httpSession.setAttribute("user", new SessionUser(kakaoUser));
        httpSession.setAttribute("access_token", accessToken);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String kakaoLogout() {
        String accessToken = (String) httpSession.getAttribute("access_token");
        userService.kakaoLogout(accessToken);
        return "redirect:/";
    }
}
