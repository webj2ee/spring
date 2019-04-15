package com.spring.fileupload.controller;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.fileupload.model.File;
import com.spring.fileupload.validation.FileValidator;

@Controller
@RequestMapping("/file.htm")
public class FileController {

	@Autowired
	FileValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(Model model) {
		File fileModel = new File();
		model.addAttribute("file", fileModel);
		return "file";
	}

	@RequestMapping(method = RequestMethod.POST)
	//public String fileUploaded(Model model, @Validated File file,
			//BindingResult result) throws IOException {
	public String fileUploaded(Model model, @RequestParam("file") MultipartFile file) throws IOException {
	
		  Logger log = Logger.getLogger(FileController.class.getName());
	  

		String returnVal = "successFile";
		/*if (result.hasErrors()) {
			returnVal = "file";
		} else {			
			*/
			
			//MultipartFile multipartFile = file.getFile();	
			//log.info(multipartFile.getOriginalFilename());
			//byte[] bytearr = multipartFile.getBytes();
			//System.out.println("byte length: "+ bytearr.length);
			
			//System.out.println("Size : "+ multipartFile.getSize());
			/*BufferedReader br;
			List<String> result1 = new ArrayList<>();
			try {

			     String line;
			     InputStream is = multipartFile.getInputStream();
			     br = new BufferedReader(new InputStreamReader(is));
			     while ((line = br.readLine()) != null) {
			          result1.add(line);
			     }
			     for (Iterator iterator = result1.iterator(); iterator.hasNext();) {
					String string = (String) iterator.next();
					
					System.out.println("result"+string);
				}
			     

			  } catch (IOException e) {
			    System.err.println(e.getMessage());       
			  }*/
		if (!file.isEmpty()) {
			try {
				
				/*ByteArrayInputStream stream = new   ByteArrayInputStream(file.getBytes());
				String myString = IOUtils.toString(stream, "UTF-8");
					//System.out.println(myString);
				byte[] bytes = file.getBytes();
	            String completeData = new String(bytes);
	            String[] rows = completeData.split("");
	            String[] columns = myString.split(",");
	            
	           
	            for (int i = 0; i < columns.length; i++) {
					String string = columns[i];
					System.out.println(i+"----"+string);
					
				}*/
	            
	            BufferedReader buff = null;
	            String  COMMA_DELIMITER=",";
	            List<String> result = new ArrayList<>();
	            try {

	                 String line;
	                 InputStream is = file.getInputStream();
	                 buff = new BufferedReader(new InputStreamReader(is));
	                 while ((line = buff.readLine()) != null) {
	                	 String[] products = line.split(COMMA_DELIMITER);
	                     
	                     if(products.length > 0 )
	                     {
	                    	 System.out.println("0 "+products[0]+" 1 "+products[1]);
	                     }
	                      result.add(line);
	                 }

	              } catch (IOException e) {
	                System.err.println(e.getMessage());       
	              }
	            System.out.println(result);
	            //return returnVal;
			} catch (Exception e) {
				System.out.println(e);
			}
			
			} else {
				return returnVal;
	}
		return returnVal;
	}
}
