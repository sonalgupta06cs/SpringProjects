package com.baxter.idc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baxter.idc.entity.ProductEntity;
import com.baxter.idc.exception.SpringException;
import com.baxter.idc.interfa.MasterDataService;
import com.baxter.idc.model.FileUploadForm;

@Controller
public class MasterDataController {

	private static final Logger logger = LoggerFactory.getLogger(MasterDataController.class);
	
	@Autowired
	MasterDataService masterDataService;
	
	@RequestMapping(value="/")
	public String redirectToHome(HttpServletRequest request, ModelMap map)
	{
		
		/*Log file Entry*/
		logger.info("Entering method : {}", "redirectToHome");
				
		logger.info("Exiting method : {}", "redirectToHome");		
		
		return "redirect:importExcel";
	}
	
	@RequestMapping(value="/importExcel")
	public ModelAndView importExcel(){
		
		/*Log file Entry*/
		logger.info("Entering method : {}", "importExcel");
				
		logger.info("Exiting method : {}", "importExcel");
		
		return new ModelAndView("importExcel", "fileUploadForm", new FileUploadForm());
		
		// logs error message
		//if(== null)
		//{
		      //logger.error("User trying to access unknown server : {}/{}/{}", teamCode, regionCode, environmentCode);
		      //logger.info("Exiting method : {}", "test");
		//}	
		
		// logs exception
		//logger.error("This is Error message", new Exception("Testing"));
	}
	
	@RequestMapping(value="/importExcelContent", method=RequestMethod.POST)
	//@ExceptionHandler(SpringException.class)
	public ModelAndView importExcelContent(@ModelAttribute("fileUploadForm") FileUploadForm fileUploadForm, BindingResult bindingResult, HttpSession session, ModelMap map) throws SpringException
	{
		
		ModelAndView modelAndView = new ModelAndView("displayExcelData");
		/*Log file Entry*/
		logger.info("Entering method : {}", "importExcelContent");				
		
		String filePath = "";
		String extension = "";
		
		System.out.println("fileUploadForm "+fileUploadForm.getFileName()+fileUploadForm.getFile());
		
		if (!fileUploadForm.getFile().isEmpty()) 
		{
            try {
            	String fileName = fileUploadForm.getFile().getOriginalFilename();
            	extension = FilenameUtils.getExtension(fileName);
                byte[] bytes = fileUploadForm.getFile().getBytes();
 
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileUploadForm.getFile().getName());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
               System.out.println(("Server File Location="+ serverFile.getAbsolutePath()));
               filePath = serverFile.getAbsolutePath();
 
               System.out.println("You successfully uploaded file=" + fileUploadForm.getFile().getName()+"on path "+filePath);
               
               //masterDataService = null;
               List<ProductEntity> productList = masterDataService.saveMasterDataProducts(filePath, extension);
               modelAndView.addObject("productList", productList);
                
            } 
            catch (Exception e)
            {
            	System.out.println("Falied uploading file=" + fileUploadForm.getFile().getName());
            	throw new SpringException("100","uploading excel sheet error", e.getStackTrace());        	
            }
            finally
            {      	
            }
        } 
		else
		{
            System.out.println("You failed to upload " + fileUploadForm.getFile().getName()
                    + " because the file was empty.");
        }	
		
		logger.info("Exiting method : {}", "importExcelContent");
		
		return modelAndView;
	}
}
