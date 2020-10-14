package com.yqfk.controller;

import com.yqfk.pojo.Address;
import com.yqfk.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminAddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 查询所有的收货地址
     * @param model
     * @return
     */
    @RequestMapping("/admin/address2")
    public String address2(Model model){
        List<Address> addresses = addressService.queryAll();
        model.addAttribute("addresses",addresses);
        return "admin/address";
    }

    /**
     * 跳转到增加收货地址的页面
     * @return
     */
    @RequestMapping("/admin/toAddAddress")
    public String toAddAddress(){
        return "admin/addAddress";
    }

    /**
     * 增加一个新的收货地址
     * @param name
     * @param address
     * @param tel
     * @param detail
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/addAddress")
    public String addAddress(String name,String address,String tel,String detail){
        Address a=new Address();
        a.setaName(name);
        a.setAddress(address);
        a.setTel(tel);
        a.setDetail(detail);
        List<Address> addresses = addressService.queryAll();
        if(addresses.size()==0){
            addressService.firstAdd(a);
        }else {
            addressService.addAddress(a);
        }
        return "success";
    }

    /**
     * 跳转到更新收货地址的页面
     * @param aId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/admin/toUpdateAddress")
    public String toUpdateAddress(int aId,HttpServletRequest request,Model model){
        Address address = addressService.getAddressByAid(aId);
        model.addAttribute("address",address);
        request.getSession().setAttribute("address",address);
        request.getSession().setAttribute("aId",aId);
        return "admin/updateAddress";
    }

    /**
     * 更新收货地址
     * @param name
     * @param address
     * @param tel
     * @param detail
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/updateAddress")
    public String updateAddress(String name, String address, String tel, String detail, HttpServletRequest request){
        int aId=Integer.parseInt(request.getSession().getAttribute("aId").toString());
        Address a=new Address();
        a.setuId(1);
        a.setaId(aId);
        a.setaName(name);
        a.setAddress(address);
        a.setTel(tel);
        a.setDetail(detail);
        addressService.updateAddress(a);
        return "success";
    }

    /**
     * 删除一个收货地址
     * @param aId
     * @return
     */
    @RequestMapping("/admin/deleteAddress")
    public String deleteAddress(int aId){
        addressService.deleteAddress(aId);
        return "redirect:/admin/address2";
    }

    /**
     * 给收货地址设置是否为默认地址
     * @param aId
     * @return
     */
    @RequestMapping("/admin/setDefault")
    public String setDefault(int aId){
        List<Address> addresses = addressService.queryAll();
        for (Address address : addresses) {
            address.setDef(0);
            addressService.updatedef(address);
        }
        Address address = addressService.getAddressByAid(aId);
        if(address.getDef()==0){
            address.setDef(1);
            addressService.updatedef(address);
            return "redirect:/admin/address2";
        }else if (address.getDef()==1){
            address.setDef(0);
            addressService.updatedef(address);
            return "redirect:/admin/address2";
        }
        return null;
    }



}
