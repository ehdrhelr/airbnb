package team01.airbnb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import team01.airbnb.config.auth.LoginUser;
import team01.airbnb.config.auth.dto.SessionUser;
import team01.airbnb.utils.KakaoLoginUtils;

@Api(tags = {"관리자페이지"}, description = "ADMIN 페이지로 이동합니다.")
@Controller
public class HomeController {

    private final KakaoLoginUtils kakaoLoginUtils;

    public HomeController(KakaoLoginUtils kakaoLoginUtils) {
        this.kakaoLoginUtils = kakaoLoginUtils;
    }

    @ApiOperation(value = "관리페이지", notes = "카카오 로그인, 숙소목록보기, 숙소등록이 가능한 페이지")
    @GetMapping("/")
    public ModelAndView home(@LoginUser SessionUser user) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("kakao-client-id", kakaoLoginUtils.getClientId());
        mav.addObject("kakao-redirect-uri", kakaoLoginUtils.getRedirectUri());
        if (user != null) {
            mav.addObject("username", user.getUsername());
        }
        return mav;
    }
}
