package mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mvc.mybatis.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.SessionMap;

/**
 * @author PGIDWUY
 */

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@Autowired
	private IUserService service;

	@RequestMapping(value = "log")
	public String toLoginPage() {
		return "login";
	}

	@RequestMapping(value = "index")
	public String toIndexPage() {
		return "index";
	}

	@RequestMapping(value = "login")
	@ResponseBody
	public JSONObject userLogin(HttpServletRequest request, HttpSession session) {
		String userid = request.getParameter("username");
		//String password = request.getParameter("password");
		//String chodb = request.getParameter("chodb");

		JSONObject json = new JSONObject();
		if (userid.equals("admin")) {
			json.put("msg", "success");
			session.setAttribute("userid", userid);
			session.setAttribute("role", userid);
			session.setMaxInactiveInterval(60*5);
			SessionMap.addSession(session);
		} else {
			json.put("msg", "密码错误");
		}
		return json;
	}

	@RequestMapping(value = "logout")
	@ResponseBody
	public JSONObject userLogout(HttpSession session){
		JSONObject json=new JSONObject();
		session.invalidate();
		json.put("msg", "1");
		return json;
	}

}
