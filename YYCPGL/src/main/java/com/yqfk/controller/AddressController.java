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
public class AddressController {

    @Autowired
    private AddressService addressService;

   /* @RequestMapping("/address1")
    public String address(Model model){
        List<Address> addresses = addressService.queryAll();
        if(addresses.size()==0) {
            model.addAttribute("addresses",addresses);
            return "address";
        }else {
            Address address = addresses.get(0);
            address.setDef(1);
            addressService.updateAddress(address);
            List<Address> addresses1 = addressService.queryAll();
            model.addAttribute("addresses",addresses1);
            return "address";
        }
    }*/

    @RequestMapping("/address2")
    public String address2(Model model){
        List<Address> addresses = addressService.queryAll();
        model.addAttribute("addresses",addresses);
        return "address";
    }

    @RequestMapping("/toAddAddress")
    public String toAddAddress(){
        return "addAddress";
    }

    @ResponseBody
    @RequestMapping("/addAddress")
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

    @RequestMapping("/toUpdateAddress")
    public String toUpdateAddress(int aId,HttpServletRequest request,Model model){
        Address address = addressService.getAddressByAid(aId);
        model.addAttribute("address",address);
        request.getSession().setAttribute("address",address);
        request.getSession().setAttribute("aId",aId);
        return "updateAddress";
    }

    @ResponseBody
    @RequestMapping("/updateAddress")
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

    @RequestMapping("/deleteAddress")
    public String deleteAddress(int aId){
        addressService.deleteAddress(aId);
        return "redirect:/address2";
    }

    @RequestMapping("/setDefault")
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
            return "redirect:/address2";
        }else if (address.getDef()==1){
            address.setDef(0);
            addressService.updatedef(address);
            return "redirect:/address2";
        }
        return null;
    }



}
