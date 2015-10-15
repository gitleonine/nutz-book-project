package net.wendal.nutzbook.module;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.wendal.nutzbook.bean.User;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

@At("/demo")
@IocBean
public class DemoModule {

	@At
	@Ok("json")
	public NutMap list(HttpSession session) throws Exception {
		System.out.println(session.getId());
		return NutMap.NEW();
	}

	@At
	@Ok("json")
	public NutMap login(HttpSession session) {
		System.out.println(session.getId());
		return NutMap.NEW();
	}
	
	/**
	 * 前缀表单嵌套List.<p/>
	 * 页面发送的数据如下:
	 * <p/>
	 * 
	 * <code>user.name=wendal&user.roles[0].id=123</code>
	 */
	@At
	@Ok("json")
	public User test_prefix_list(@Param("::user.")User user, HttpServletRequest req) {
		System.out.println(Json.toJson(req.getParameterMap()));
		System.out.println(Json.toJson(user));
		return user;
	}
}
