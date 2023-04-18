package studio.hcmc.egov.spring.boot.mvc.controller.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import studio.hcmc.egov.spring.boot.mvc.ErrorResponse;
import studio.hcmc.egov.spring.boot.mvc.domain.user.UserDomain;
import studio.hcmc.egov.spring.boot.mvc.service.user.UserService;
import studio.hcmc.egov.spring.boot.mvc.vo.user.UserVO;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 로그인 View
     */
    @RequestMapping(
            value = "/user/signIn.do",
            method = RequestMethod.GET
    )
    public String signInView(
            Model model,
            HttpSession session
    ) {
        final var user = (UserDomain) session.getAttribute("user");
        if (user != null) {
            // 사용자 정보가 세션에 존재: 이미 로그인함
            return "redirect:/home.do";
        }

        model.addAttribute("userVO", new UserVO());

        return "/user/signIn";
    }

    /**
     * 로그인
     */
    @RequestMapping(
            value = "/user/signIn.do",
            method = RequestMethod.POST
    )
    public String signIn(
            Model model,
            UserVO userVO,
            HttpSession session
    ) {
        final var email = userVO.getEmail();
        if (email == null) {
            // TODO validate: email
            throw new AssertionError("email is null");
        }

        final var password = userVO.getPassword();
        if (password == null) {
            // TODO validate: password
            throw new AssertionError("password is null");
        }

        final var userEntity = userService
                .findByDomain(userVO)
                .orElseThrow(ErrorResponse.User.NotFound::new);

        session.setAttribute("user", userEntity);

        return "redirect:/home.do";
    }

    /**
     * 회원가입 View
     */
    @RequestMapping(
            value = "/user/signUp.do",
            method = RequestMethod.GET
    )
    public String signUpView(
            Model model,
            HttpSession session
    ) {
        final var user = (UserDomain) session.getAttribute("user");
        if (user != null) {
            // 사용자 정보가 세션에 존재: 이미 로그인함
            return "redirect:/home.do";
        }

        model.addAttribute("userVO", new UserVO());

        return "/user/signUp";
    }

    /**
     * 회원가입
     */
    @RequestMapping(
            value = "/user/signUp.do",
            method = RequestMethod.POST
    )
    public String signUp(
            Model model,
            UserVO userVO,
            HttpSession session
    ) {
        final var email = userVO.getEmail();
        if (email == null) {
            // TODO validate: email
            throw new AssertionError("email is null");
        }

        final var password = userVO.getPassword();
        if (password == null) {
            // TODO validate: password
            throw new AssertionError("password is null");
        }

        final var userEntity = userService.save(userVO);
        // 회원가입 후 자동으로 로그인을 적용하려면 세션에 user로 저장

        return "redirect:/user/signIn.do";
    }
}
