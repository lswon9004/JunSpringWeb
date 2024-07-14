package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
   
@Controller
public class SearchController {
   // query=리스트&p=1
   @RequestMapping("/search/internal")
   public ModelAndView searchInternal(@RequestParam("query") String query, @RequestParam("p") int pageNumber) {
      System.out.println("query=" + query + ",pageNumber=" + pageNumber);
      return new ModelAndView("search/internal");
      // ModelAndView("viewname")
      // ModelAndView("viewname", "model이름", model값)
      
   }

   @RequestMapping("/search/external")
   public ModelAndView searchExternal(@RequestParam(value="query", required =false ) String query, @RequestParam(value = "p", defaultValue = "1") int pageNumber) {
      System.out.println("query=" + query + ",pageNumber=" + pageNumber);
      ModelAndView mav = new ModelAndView();
      //mav.setViewName("search/external");
      mav.addObject("query", query);//model 추가
      mav.addObject("pnum",pageNumber);
      return mav;
   }
}
