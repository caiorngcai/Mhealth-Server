package com.cai.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cai.domain.HealthInfo;
import com.cai.service.HealthInfoService;

public class HealthInfoList extends HttpServlet {
	private HealthInfo healthInfo=new HealthInfo();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		WebApplicationContext ac=WebApplicationContextUtils.findWebApplicationContext(getServletContext());
		HealthInfoService healthInfoService=(HealthInfoService) ac.getBean("healthInfoService");
		String loginname = new String(request.getParameter("loginname").getBytes("iso8859-1"),"UTF-8");
		System.out.println(loginname);
		if(loginname!=null&&!"".equals(loginname))
		{
			healthInfo.setLoginname(loginname);
		}
		List<HealthInfo> list=healthInfoService.findByLoginname(healthInfo);
		 request.setAttribute("list",list);
		 request.getRequestDispatcher("jsp/patient/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
