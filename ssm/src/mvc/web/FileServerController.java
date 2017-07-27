package mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.SessionMap;

/**
 * @author PGIDWUY
 */

@Controller
@RequestMapping(value = "/session")
public class FileServerController {

	@RequestMapping(value = "check")
	@ResponseBody
	public JSONObject checkSession(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int type = 0;
		String sessionid = request.getParameter("sessionid");
		HttpSession session = SessionMap.getSession(sessionid);
		if (session == null) {
			type = 0;
		} else {
			try {
				String userid = (String) session.getAttribute("userid");
				if (userid == null)
					type = 0;
				else
					type = 1;
			} catch (java.lang.IllegalStateException e) {
				type = -1;
			}
		}
		switch (type) {
		case -1:
			json.put("statue", false);
			json.put("msg_cn", "session过期");
			break;
		case 0:
			json.put("statue", false);
			json.put("msg_cn", "session不存在");
			break;
		case 1:
			json.put("statue", true);
			json.put("msg_cn", "session正常");
			break;
		}
		System.out.println(json);
		return json;

	}

}
