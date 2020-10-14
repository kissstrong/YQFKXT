package com.yqfk.controller;
import com.yqfk.pojo.Admin;
import com.yqfk.pojo.User;
import com.yqfk.service.AdminService;
import com.yqfk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String XTSZ_URL="http://localhost:80";
    private final String YQSJXXGL_URL="http://localhost:8005";
    private final String YYCPGL_URL="http://localhost:8006";

    /**
     * 检查管理员登录
     * @param name
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkAdminLogin")
    public boolean checkAdminLogin(String name,String password){
        return adminService.checkLogin(name, password);
    }

    /**
     * 检查普通用户登录
     * @param name
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkUserLogin")
    public boolean checkUserLogin(String name,String password){
        return userService.checkUser(name,password);
    }
    /**
     * 跳转到疫情数据信息管理系统
     * @param response
     */
    @RequestMapping("/toYQSJXXGL")
    public void toYQSJXXGL(HttpServletResponse response)throws Exception{
        response.sendRedirect(YQSJXXGL_URL+"/admin");
    }
    /**
     * 跳转到医药厂品管理系统
     * @param response
     */
    @RequestMapping("/toYYCPGL")
    public void toYYCPGL(HttpServletResponse response)throws Exception{
         response.sendRedirect(YYCPGL_URL+"/admin");
    }

    /**
     * 跳转到管理员主页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session){
        Admin admin = (Admin) redisTemplate.opsForHash().values("admin").get(0);
        session.setAttribute("admin",admin);
        List<User> all = userService.findAll();
        model.addAttribute("users",all);
        return "index";
    }

    /**
     * 根据id来删除普通用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/delete")
    public String deleteById(int id,Model model){
        userService.deleteById(id);
        model.addAttribute("users",userService.findAll());
        return "index::users";
    }

    /**
     * 管理员重置普通用户密码为123456
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/resetPassword")
    public String resetPassword(int id,Model model){
        User user = userService.queryById(id);
        user.setPassword("123456");
        userService.update(user);
        model.addAttribute("users",userService.findAll());
        return "index::users";
    }

    /**
     * 普通用户注册
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.save(user);
        return "success";
    }

    /**
     * 管理员和普通用户退出登录
     * @param response
     * @throws Exception
     */
    @RequestMapping("/logout")
    public void logout(HttpServletResponse response,HttpSession session)throws Exception{
        session.removeAttribute("admin");
        response.sendRedirect(XTSZ_URL+"/logout");
    }

    /**
     * 发送验证码
     * @param mobile
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendCode")
    public String sendCode(String mobile){
        userService.sendMsg(mobile);
        return "success";
    }

    /**
     * 修改管理员和普通用户的密码
     * @param password
     * @param phone
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/ResetPassword")
    public String resetPassword(String password,String phone,String role){
        if (role.equals("admin")){
            Admin admin = adminService.queryAdminByPhone(phone);
            if (admin!=null){
                admin.setPassword(password);
                adminService.save(admin);
                return "ok";
            }
            return "false";
        }else {
            User user = userService.queryUserByPhone(phone);
            if (user!=null){
                user.setPassword(password);
                userService.save(user);
                return "ok";
            }
            return "false";
        }
    }

    /**
     * 检查手机号码是否重复
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkPhone")
    public String checkPhone(String phone){
        User user = userService.queryUserByPhone(phone);
        if (user==null){
            return "success";
        }
       return "false";
    }

    /**
     * 错误页面返回登录页面
     * @param response
     * @throws Exception
     */
    @RequestMapping("/BackToLogin")
    public void BackToLogin(HttpServletResponse response)throws Exception{
        response.sendRedirect(XTSZ_URL);
    }

}
