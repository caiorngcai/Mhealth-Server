package com.cai.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cai.domain.Doctor;
import com.cai.service.DoctorService;
import com.cai.utils.MD5Utils;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class DoctorLogin extends HttpServlet {
	private Doctor doctor=new Doctor();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			WebApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			 DoctorService doctorService=(DoctorService) ac.getBean("doctorService");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			BeanUtils.populate(doctor,request.getParameterMap());
			doctor.setPassword(MD5Utils.md5(doctor.getPassword()));
			doctor=doctorService.getDoctorByNamePassword(doctor);
			request.getSession().putValue("doctor",doctor);
			response.getWriter().write("login succeed,back to home page..");
			response.setHeader("Refresh","3;url=http://localhost/Mhealthy/index.jsp");
			System.out.println(doctor.getLoginname());
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
