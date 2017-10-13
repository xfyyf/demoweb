package demo.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demo.bean.Dept;
import demo.bean.Emp;
import demo.service.BaseService;

@Controller
public class EmpController {
	   @Resource(name="baseservice")
	  private BaseService service;
		
	   @RequestMapping(value="/list")    //   /empdemo/list.sw
	   public ModelAndView  list(HttpServletRequest request){
		   ModelAndView  mv = new ModelAndView();
		   
		   String ename = request.getParameter("ename");
		   String username = request.getParameter("username");
		   String sex = request.getParameter("sex");
		   
		   String str_did = request.getParameter("did");
		   
		  String hql = "select  e  from Emp e  where 1=1";
		   
		  if(ename!=null && !"".equals(ename)){
			  hql += " and e.ename like '%"+ename+"%' ";
		  }
		  if(sex!=null && !"A".equals(sex)){
			  hql += " and e.sex='"+sex+"' ";
		  }
		  
		  if(username!=null && !"".equals(username)){
			  hql += " and e.user.username like '%"+username+"%' ";
		  }
		  
		  if(str_did!=null && !"0".equals(str_did)){
			  hql += " and e.did=" + str_did;
		  }
		   
		  System.out.println(hql);
		  
		   mv.addObject("emplist", service.find(hql));
		   
		   mv.addObject("depts", service.find("from Dept"));
		   
		   mv.setViewName("emp/list"); //   /WEB-INF/view/emp/list.jsp
		   
		   return mv;
	   }
	   
	   @RequestMapping(value="/toadd")
	   public ModelAndView  toadd(){
		   ModelAndView mv = new ModelAndView();
		   
		   mv.addObject("depts", service.find("from Dept"));
		   
		   mv.setViewName("emp/add");
		   return mv;
	   }
	   
	   @RequestMapping(value="/add")
	   public ModelAndView add(Emp emp){
		   ModelAndView mv = new ModelAndView();
		   
		   System.out.println("Request: " + emp);
		   
		   emp.getUser().setEmp(emp);
		   Dept olddept = (Dept)service.load(Dept.class, emp.getDid());
		   emp.setDept(olddept);
		   
		   service.add(emp);
		   
		   
		   
		   mv.setViewName("redirect:/list.sw");
		   
		   return mv;
	   }
	   
	   @RequestMapping(value="/toupdate")
	   public ModelAndView  toupdate( @RequestParam(name="eid") Integer eid){
		   ModelAndView mv = new ModelAndView();
		   mv.addObject("emp", service.load(Emp.class, eid));
		   mv.addObject("depts", service.find("from Dept"));
		   mv.setViewName("emp/update");
		   return mv;
	   }
	   
	   @RequestMapping(value="/update")
	   public ModelAndView  update(Emp emp){
		   ModelAndView mv = new ModelAndView();
		   //...
		   Emp oldemp = (Emp)service.load(Emp.class, emp.getEid());
		   oldemp.setEname(emp.getEname());
		   oldemp.setSex(emp.getSex());
		   oldemp.setSar(emp.getSar());
		   oldemp.setHire(emp.getHire());
		   Dept olddept = (Dept)service.load(Dept.class, emp.getDid());
		   oldemp.setDept(olddept);
		   
		   oldemp.getUser().setUsername(emp.getUser().getUsername());
		   oldemp.getUser().setPwd(emp.getUser().getPwd());
		   
		   service.update(oldemp);
		   
		   
		   
		   mv.setViewName("redirect:/list.sw");
		   return mv;
	   }
	   
	   @RequestMapping(value="/delete")
	   public ModelAndView  delete(@RequestParam(name="eid") Integer eid){
		   ModelAndView mv = new ModelAndView();
		   
		   Emp oldemp = (Emp)service.load(Emp.class, eid);
		   service.delete(oldemp);
		   
		   mv.setViewName("redirect:/list.sw");
		   return mv;
	   }
}
