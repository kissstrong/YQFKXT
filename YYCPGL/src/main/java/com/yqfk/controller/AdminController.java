package com.yqfk.controller;

import com.github.pagehelper.PageInfo;
import com.yqfk.pojo.Address;
import com.yqfk.pojo.Order;
import com.yqfk.pojo.Product;
import com.yqfk.service.AddressService;
import com.yqfk.service.OrderService;
import com.yqfk.service.ProductService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminController {
    private final String YQSJXXGL_URL="http://localhost:8005";
    private final String XTSZ_URL="http://localhost:80";
    private final String GLYDL_URL="http://localhost:8002";
    @Autowired
    private ProductService productService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 跳转到主界面
     * @return
     */
    @RequestMapping({"/admin","/admin/index"})
    public String index(HttpSession session){
        List admin = redisTemplate.opsForHash().values("admin");
        session.setAttribute("admin",admin.get(0));
        return "admin/index";
    }

    /**
     * 分页查询所有产品，每页显示六个产品
     * @param model
     * @return
     */
    @RequestMapping("/admin/products")
    public String products(Model model){
        PageInfo pageInfo = productService.queryAll(1, 6);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/products";
    }

    /**
     * 分页查询所有产品，每页显示六个产品
     * @param model
     * @return
     */
    @RequestMapping("/admin/query1")
    public String queryForPage(int page,Model model){
        PageInfo pageInfo = productService.queryAll(page, 6);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/products";
    }

    /**
     * 分页模糊查询所有产品，每页显示两个产品
     * @param model
     * @return
     */
    @RequestMapping("/admin/searchProduct")
    public String searchProduct(String keyword,Model model){
        PageInfo pageInfo = productService.queryAllToPage(1, 2, keyword);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("keyword",keyword);
        return "admin/search";
    }

    /**
     * 分页模糊查询所有产品，每页显示两个产品
     * @param model
     * @return
     */
    @RequestMapping("/admin/query2")
    public String queryAllToPage(int page,Model model,String keyword){
        PageInfo pageInfo = productService.queryAllToPage(page,2,keyword);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("keyword",keyword);
        return "admin/search";
    }

    /**
     * 显示购物车页面，查询出购物车内所有的商品
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/admin/toBucket")
    public String toBucket(Model model,HttpSession session){
        List<Product> products = productService.queryBucket(1);
        session.setAttribute("products",products);
        model.addAttribute("products",products);
        return "admin/bucket";
    }

    /**
     * 根据商品的id加入购物车
     * @param pId
     * @return
     */
    @RequestMapping("/admin/joinBucket")
    public String joinBucket(int pId){
        Map<String,Integer> map = new HashMap<>();
        map.put("uId",1);
        map.put("pId",pId);
        productService.joinBucket(map);
        return "redirect:/admin/toBucket";
    }

    /**
     * 根据商品的id从购物车中删除
     * @param pId
     * @return
     */
    @RequestMapping("/admin/removeFromBucket")
    public String removeFromBucket(int pId){
        productService.removeFromBucket(pId);
        return "redirect:/admin/toBucket";
    }

    /**
     * 点击商品进入商品的详细页面
     * @param pId
     * @param model
     * @return
     */
    @RequestMapping("/admin/productDetail")
    public String productDetail(int pId,Model model){
        Product product = productService.queryProductById(pId);
        model.addAttribute("product",product);
        return "admin/productDetail";
    }

    /**
     *检验是否存在收货地址并且是否存在默认地址
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/toCheck")
    public String toCheck(){
        List<Address> addresses = addressService.queryAll();
        if(addresses.size()==0){
            return "error1";
        }else {
            for (Address address : addresses) {
                if (address.getDef() == 1) {
                    return "success";
                }
            }
            return "error2";
        }

    }

    /**
     * 跳转到结算页面
     * @param total
     * @param request
     * @param model
     * @param ids
     * @return
     */
    @RequestMapping("/admin/toCheckOut")
    public String toCheckOut(float total,HttpServletRequest request,Model model,Integer[] ids){
        List<Address> addresses = addressService.queryAll();
        for (Address address : addresses) {
            if(address.getDef()==1){
                model.addAttribute("address",address);
                request.getSession().setAttribute("address",address);
            }
        }
        model.addAttribute("total",total);
        request.getSession().setAttribute("total",total);
        List<Integer> pIds=Arrays.asList(ids);
        request.getSession().setAttribute("pIds",pIds);
        return "admin/checkOut";
    }

    /**
     * 确认支付，跳转到支付宝页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/admin/pay")
    public String pay(HttpSession session,Model model){
        List<Product> products = (List<Product>) session.getAttribute("products");
        List<Integer> pIds = (List<Integer>) session.getAttribute("pIds");
        String str="|";
        for (Product product : products) {
            for (Integer pId : pIds) {
                if(product.getpId()==pId){
                    str+=product.getMsg()+"|";

                }
            }
        }
        model.addAttribute("str",str);
        float total = (float) session.getAttribute("total");
        model.addAttribute("total",total);
        return "admin/AlipayIndex";
    }

    /**
     * 显示所有的订单
     * @param model
     * @return
     */
    @RequestMapping("/admin/toOrder")
    public String toOrder(Model model){
        List<Order> orders = orderService.queryAll();
        model.addAttribute("orders",orders);
        return "admin/order";
    }

    /**
     * 当支付成功后，添加一个订单，同时从购物车中删除该商品
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping("/admin/addOrder")
    public String addOrder(HttpServletRequest request) throws ParseException {
        float total = Float.parseFloat(request.getSession().getAttribute("total").toString());
        Address address = (Address) request.getSession().getAttribute("address");
        Long random = Long.valueOf(RandomStringUtils.random(15,false,true));
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Order o=new Order();
        o.setuId(1);
        o.setoId(random);
        o.setuName(address.getaName());
        o.setAddress(address.getAddress());
        o.setTel(address.getTel());
        o.setMoney(total);
        o.setStatus("正在配送中");
        o.setOrderDate(sdf.parse(sdf.format(date)));
        orderService.addOrder(o);
        List<Integer> pIds = (List<Integer>) request.getSession().getAttribute("pIds");
        for (Integer pId : pIds) {
            productService.removeFromBucket(pId);
        }
        return "redirect:/admin/toOrder";
    }

    /**
     * 删除订单
     * @param oId
     * @return
     */
    @RequestMapping("/admin/deleteOrder")
    public String deleteOrder(long oId){
        orderService.deleteOrder(oId);
        return "redirect:/admin/toOrder";
    }

    /**
     * 更新订单的配送状态
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/updateOrder")
    public String updateOrder(long oId){
        Order order = orderService.queryOrderByOid(oId);
        order.setStatus("已收货");
        orderService.updateOrder(order);
        return "success";
    }

    /**
     * 返回主页面
     * @param response
     * @throws Exception  admin/returnToIndex
     */
    @RequestMapping("/admin/returnToIndex")
    public void returnToIndex(HttpServletResponse response)throws Exception{
        response.sendRedirect(GLYDL_URL);
    }

}