package spring.commento.springbasic.chapter02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import spring.commento.springbasic.global.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class SessionLoginArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("\n SessionLoginArgumentResolver supportsParameter 실행되었어요");

        boolean hasSessionLoginAnnotation = parameter.hasParameterAnnotation(SessionLogin.class);

        boolean isMemberType = Member.class.isAssignableFrom(parameter.getParameterType());

        return hasSessionLoginAnnotation && isMemberType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        log.info("\n SessionLoginArgumentResolver resolveArgument 실행");

        HttpServletRequest httpServletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = httpServletRequest.getSession(false);
        if(session == null)
            return null;

        return session.getAttribute("member");
    }
}
