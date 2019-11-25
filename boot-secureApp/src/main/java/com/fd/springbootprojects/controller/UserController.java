package com.fd.springbootprojects.controller;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

	@PostMapping("/postTest")
	public String abc(@RequestBody String str ) {
		System.out.println("post call");
		return "############# HELLO POST ##################" +str;
	}
	@RequestMapping("/getTest")
	public String abc2() {
		System.out.println("get call");
		return "************** HELLO GET ********************";
	}
	
	@RequestMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") int id)
	{
	    if (id <= 3) {
	        Employee employee = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
	        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	    }
	    return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> updateEmployee(@PathVariable("id") int id)
	{
	    System.out.println(id);
	    return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee)
	{
	    System.out.println(id);
	    System.out.println(employee);
	    return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping(value="/") public String home() { System.out.println("home");
	 * return "index.html"; }
	 */
	
	@GetMapping(value="/login")
	public String loginForm() {
		System.out.println("login");
		return "login.";
	}
	@GetMapping(value="/logout")
	public ModelAndView logout() {
		System.out.println("logout");
		ModelAndView obj=new ModelAndView();
		obj.setViewName("logout.html");
		obj.addObject("autoRedirectTime", 10);
		
		return obj;
	}
	
	@GetMapping(value="/generateReport")
	public void generatePdf(ModelAndView a) throws IOException
	{
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		a.setViewName("/index");
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
		contentStream.setFont(PDType1Font.COURIER, 26);
		contentStream.beginText();
		contentStream.showText("Hello World");
		contentStream.endText();
		contentStream.close();
	
		document.save("pdfBoxHelloWorld.pdf");
		
		document.close();
	}
	
	
}
