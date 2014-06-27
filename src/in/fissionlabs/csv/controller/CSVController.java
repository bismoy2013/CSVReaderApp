package in.fissionlabs.csv.controller;

import in.fissionlabs.csv.model.FileUploadForm;
import in.fissionlabs.csv.service.CSVService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CSVController {
	
	@Autowired
	CSVService csvService;
	
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model map) {

		MultipartFile multipartFile = uploadForm.getFile();
		

		String fileName = "";

		if (multipartFile != null) {
			fileName = multipartFile.getOriginalFilename();

		}

		String response = csvService.uploadCSVDetails(multipartFile);
		if(response!=null) {
		map.addAttribute("files", "Uploaded " + fileName + " " +response);
		return "file_upload_success";
		} else {
			map.addAttribute("files", fileName);
			return "file_upload_failure";
		}
	}
}
