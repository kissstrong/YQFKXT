package com.yqfk.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyz
 * @date 2020-10-13 10:16
 */
@Configuration
public class MyInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInter()).addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**")
                .excludePathPatterns("/","/toregister","/toreset","/register")
                .excludePathPatterns("/checkLogin","/send","/checkIsSend","/checkcode")
                .excludePathPatterns("/Resetpassworrd","/checkPhoneIsRepeat");
    }
}
class MyInter extends HandlerInterceptorAdapter{
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("admin")!=null||request.getSession().getAttribute("user")!=null){
            return true;
        }
        response.sendRedirect("http://localhost:80");
        return false;
    }
}
