package com.yqfk.controller;
import com.yqfk.pojo.Admin;
import com.yqfk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author cyz
 * @date 2020-10-12 16:26
 */
@Controller
public class MainController {
    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String YQSJXXGL_URL="http://localhost:8005";
    private final String YYCPGL_URL="http://localhost:8006";
    private final String GLYDL_URL="http://localhost:8002";

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * 去注册页面
     * @return
     */
    @RequestMapping("/toregister")
    public String toRegister(){
        return "register";
    }

    /**
     * 去修改密码页面
     * @return
     */
    @RequestMapping("/toreset")
    public String toreset(){
        return "resetPassword";
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(User user){
        restTemplate.postForEntity(GLYDL_URL + "/register",user, String.class);
        return "index";
    }

    /**
     * 检查登录
     * @param name
     * @param password
     * @param role
     * @param response
     * @param model
     * @return
     */
    @PostMapping("/checkLogin")
    public String checkAdminLogin(String name, String password, String role, HttpServletResponse response, Model model, HttpSession session){
        if (role.equals("admin")){
            Boolean check = restTemplate.getForObject(GLYDL_URL + "/checkAdminLogin?name=" + name + "&password=" + password, boolean.class);
            if (check){
                Admin admin = (Admin) redisTemplate.opsForHash().values("admin").get(0);
                session.setAttribute("admin",admin);
                return "redirect:/admin/index";
            }
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }else {
            Boolean check = restTemplate.getForObject(GLYDL_URL + "/checkUserLogin?name=" + name + "&password=" + password, boolean.class);
            if (check){
                User user = (User) redisTemplate.opsForHash().values("user").get(0);
                session.setAttribute("user",user);
                return "redirect:/index";
            }
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        List<Admin> admin =  redisTemplate.opsForHash().values("admin");
        List<User> user = redisTemplate.opsForHash().values("user");
        if (admin.size()>0){
            session.removeAttribute("admin");
            redisTemplate.opsForHash().delete("admin", "admin");
        }
        if (user.size()>0){
            session.removeAttribute("user");
            redisTemplate.opsForHash().delete("user", "user");
        }
        return "index";
    }

    /**
     * 发送验证码
     * @param mobile
     * @return
     */
    @ResponseBody
    @RequestMapping("/send")
    public String sendMobile(String mobile){
        String forObject = restTemplate.getForObject(GLYDL_URL + "/sendCode?mobile=" + mobile, String.class);
        return "success";
    }

    /**
     * 检查验证码是否发送
     * @param mobile
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkIsSend")
    public String checkIsSend(String mobile){
        String code = (String) redisTemplate.opsForValue().get("checkcode_" + mobile);
        if (code==null){
            return "success";
        }
        return "fail";
    }

    /**
     * 校验验证码
     * @param mobile
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkcode")
    public String checkcode(String mobile,String code){
        String code1 = (String) redisTemplate.opsForValue().get("checkcode_"+mobile);
        System.out.println("验证码:"+code1);
        if (code.equals(code1)){
            return "success";
        }
        return "fail";
    }

    /**
     * 修改密码
     * @param password
     * @param phone
     * @param role
     * @return
     */
    @ResponseBody
    @PostMapping("/Resetpassword")
    public String resetpassworrd(String password,String phone,String role){
        String result = restTemplate.getForObject(GLYDL_URL + "/ResetPassword?password=" + password + "&phone=" + phone + "&role=" + role, String.class);
        if (result.equals("false")){
            return "false";
        }
        return "index";
    }

    /**
     * 检验手机号码是否重复
     * @param phone
     * @return
     */
    @RequestMapping("/checkPhoneIsRepeat")
    @ResponseBody
    public String checkPhoneIsRepeat(String phone){
        String result = restTemplate.getForObject(GLYDL_URL + "/checkPhone?phone=" + phone, String.class);
        if (result.equals("success")){
            return "success";
        }
        return "false";
    }
}
