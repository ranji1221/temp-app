package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 第一个Controller
 * @author RanJi
 *
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public void hello(){
		System.out.println("haha spring mvc");
	}
	
	@RequestMapping("/aaa/bbb")
	public void testasfafd(){
		System.out.println("hello uek!");
	}
	
	@RequestMapping("/hi")
	public void add(HttpServletRequest request, HttpServletResponse response){
		String value = request.getParameter("uek");
		System.out.println(value);
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "{name:'zhangsan'}";
	}
	
	@GetMapping("/")
	public String toIndex(){
		return "redirect:/index";
	}
	
	
	@RequestMapping("/index")
	public String index(){
		return "html/frontend/index";
	}
	
	@RequestMapping("/u/{id}")		//-- 用户个人中心
	public String personal(@PathVariable("id")int id){
		return "html/frontend/personal";
	}
	
	@RequestMapping("/u/{username}/blog/{id}")
	public String blog(@PathVariable("username")String username,@PathVariable("id")int id){
		return "html/frontend/blog";
	}
	
	@RequestMapping("/blog/edit")
	public String editBlog(){
		return "html/frontend/edit";
	}
	@RequestMapping("/tologin")
	public String tologin(){
		return "html/frontend/login";
	}
	
	@RequestMapping("/admin")
	public String toAdmin(){
		return "html/backend/index";
	}
}
