package com.yqfk.controller;

import com.yqfk.pojo.Address;
import com.yqfk.pojo.Order;
import com.yqfk.pojo.Product;
import com.yqfk.service.AddressService;
import com.yqfk.service.OrderService;
import com.yqfk.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private ProductService productService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/products")
    public String products(Model model){
        PageInfo pageInfo = productService.queryAll(1, 6);
        model.addAttribute("pageInfo",pageInfo);
        return "products";
    }

    @RequestMapping("/query1")
    public String queryForPage(int page,Model model){
        PageInfo pageInfo = productService.queryAll(page, 6);
        model.addAttribute("pageInfo",pageInfo);
        return "products";
    }

    @RequestMapping("/searchProduct")
    public String searchProduct(String keyword,Model model){
        PageInfo pageInfo = productService.queryAllToPage(1, 2, keyword);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("keyword",keyword);
        return "search";
    }

    @RequestMapping("/query2")
    public String queryAllToPage(int page,Model model,String keyword){
        PageInfo pageInfo = productService.queryAllToPage(page,2,keyword);
        System.out.println(keyword);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("keyword",keyword);
        return "search";
    }

    @RequestMapping("/toBucket")
    public String toBucket(Model model,HttpSession session){
        List<Product> products = productService.queryBucket(1);
        session.setAttribute("products",products);
        model.addAttribute("products",products);
        return "bucket";
    }

    @RequestMapping("/joinBucket")
    public String joinBucket(int pId){
        Map<String,Integer> map = new HashMap<>();
        map.put("uId",1);
        map.put("pId",pId);
        productService.joinBucket(map);
        return "redirect:/toBucket";
    }

    @RequestMapping("/removeFromBucket")
    public String removeFromBucket(int pId){
        productService.removeFromBucket(pId);
        return "redirect:/toBucket";
    }

    @RequestMapping("/productDetail")
    public String productDetail(int pId,Model model){
        Product product = productService.queryProductById(pId);
        model.addAttribute("product",product);
        return "productDetail";
    }

    @ResponseBody
    @RequestMapping("/toCheck")
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

    @RequestMapping("/toCheckOut")
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
        return "checkOut";
    }

    @RequestMapping("/pay")
    public String pay(HttpSession session,Model model){
        List<Product> products = (List<Product>) session.getAttribute("products");
        List<Integer> pIds = (List<Integer>) session.getAttribute("pIds");
        String str="|";
        System.out.println(products);
        System.out.println(pIds);
        for (Product product : products) {
            for (Integer pId : pIds) {
                if(product.getpId()==pId){
                    str+=product.getMsg()+"|";

                }
            }
        }
        System.out.println(str);
        model.addAttribute("str",str);
        float total = (float) session.getAttribute("total");
        model.addAttribute("total",total);
        return "AlipayIndex";
    }

    @RequestMapping("/toOrder")
    public String toOrder(Model model){
        List<Order> orders = orderService.queryAll();
        model.addAttribute("orders",orders);
        return "order";
    }

    @RequestMapping("/addOrder")
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
        o.setStatus("正在配送中...");
        o.setOrderDate(sdf.parse(sdf.format(date)));
        orderService.addOrder(o);
        List<Integer> pIds = (List<Integer>) request.getSession().getAttribute("pIds");
        for (Integer pId : pIds) {
            productService.removeFromBucket(pId);
        }
        return "redirect:/toOrder";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(long oId){
        orderService.deleteOrder(oId);
        return "redirect:/toOrder";
    }


}
