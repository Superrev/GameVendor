package springBootApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springBootApp.entities.Vendor;
import springBootApp.entities.VendorDAO;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springBootApp.entities.*;


/**
 * Created by Superduo on 8/10/16.
 */

    @Controller
    @RequestMapping(value="/vendors/")
    public class VendorController {

        @Autowired
        private VendorDAO vendorDao;

        @RequestMapping(value="viewAllVendors")
        public String viewAllVendors(ModelMap model) {
            model.addAttribute("vendors",vendorDao.findAll());
            return "vendors/viewAllVendors";
        }

        @RequestMapping(value="viewVendor")
        public String viewVendor(Long vendorId, ModelMap model) {
            Vendor vendor = vendorDao.findOne(vendorId);
            model.addAttribute("vendor",vendor);
            return "vendors/viewVendor";
        }

        @RequestMapping(value="addVendor")
        public String addVendor(ModelMap model) {
            Vendor vendor = new Vendor();
            model.addAttribute("vendor",vendor);
            return "vendors/addVendor";
        }


        @RequestMapping(value="saveNewVendor")
        public String saveNewVendor(Vendor vendor) {
            if(vendor != null) {
                vendorDao.save(vendor);
            } else {
                System.out.println("ERROR: did NOT save new vendor, vendor was NULL!");
            }
            return "redirect:/vendors/viewAllVendors";
        }
    }

//    @RequestMapping(value="saveNewCategory")
//    public String saveNewCategory(Category category) {
////    public String saveNewCategory(@ModelAttribute("category") Category category) {
//        if(category != null) {
//            categoryDao.save(category);
//        } else {
//            System.out.println("ERROR: did NOT save new category, category was NULL!");
//        }
//        return "redirect:/categories/viewAllCategories";