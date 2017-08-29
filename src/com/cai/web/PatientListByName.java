package com.cai.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cai.domain.Patient;
import com.cai.service.PatientService;

public class PatientListByName extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Patient patient=new Patient();
		request.setCharacterEncoding("UTF-8");
		WebApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		 PatientService patientService=(PatientService) ac.getBean("patientService");
			String realname=request.getParameter("realname");
			
			if(realname!=null&&!"".equals(realname))
			{
				patient.setRealname(realname);
			}
			 List<Patient> list=patientService.findByName(patient);
			 request.setAttribute("list",list);
			 request.getRequestDispatcher("jsp/doctor/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
