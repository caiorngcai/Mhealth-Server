package com.cai.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cai.domain.Patient;
import com.cai.service.PatientService;
import com.cai.service.PatientServiceImpl;
import com.cai.utils.MD5Utils;

public class PatientRegister extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		PatientService patientService=(PatientService) ac.getBean("patientService");
		WebApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		 PatientService patientService=(PatientService) ac.getBean("patientService");
		request.setCharacterEncoding("UTF-8"); //避免中文乱码 POST方式提交  
		StringBuffer messagebuffer = new StringBuffer();
	  javax.servlet.ServletInputStream in = request.getInputStream();
	  BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
	  String line = ""; 
        StringBuilder sbf = new StringBuilder(); 
        while((line = bufferedReader.readLine())!=null){ 
            sbf.append(line); 
        } 
        String postData = sbf.toString(); 
	  
	  System.out.println(patientService.toString());
	  System.out.println("content...>>>:" + postData);
	  Patient patient=JSON.parseObject(postData, new TypeReference<Patient>(){});
	  patient.setPassword(MD5Utils.md5(patient.getPassword()));
	  //Patient patient = JSON.parseObject(postData,new TypeReference<Patient>(){});
      
	  //	com.cai.domain.Patient patient2=JSON.parseObject(postData,new TypeReference<com.cai.domain.Patient>(){});
	  	System.out.println(patient.getLoginname()+":"+patient.getPassword()+patient.getPhone()
    		+patient.getSex()+patient.getAge()+patient.getHeight());
	  	//System.out.println( patientService.toString());
	  	patientService.save(patient);
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}



}
