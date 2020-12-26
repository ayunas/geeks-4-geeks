package com.geeks4geeks.springboot.assignments;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

@RestController
public class HWController {

//Create a REST API which takes in a zip file from the client and unzips the content of that zip file. Note : Zip file can be a directory or can be combination of multiple files/directories

	private RestTemplate restTemplate;
	private static final String IMAGE_FOLDER_PATH = "/tmp/path";

	public HWController() {
		this.restTemplate = new RestTemplate(); //if no bean is created, can instantiate one without the IoC container
	}

	//	@PostMapping(value = "/upload-file", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = "/upload-file", produces = "application/media")
	public void uploadFile(HttpServletRequest req) throws IOException, ServletException {
		Part part = req.getPart("my_file");
		System.out.println("name is " + part.getName());
		System.out.println("submitted file name is : " + part.getSubmittedFileName());
		System.out.println("size of file is : " + part.getSize());

		File outputFile = new File("/tmp/");
		ZipInputStream zipInputStream = new ZipInputStream(part.getInputStream());

	}

	@GetMapping(value = "/picsum/{imgNum}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPicsumImage(@PathVariable int imgNum) {
		System.out.println(imgNum);
		RestTemplate template = new RestTemplate();
		byte[] data = template.getForObject("https://picsum.photos/id/" + imgNum + "/200/300", byte[].class);
//		WebSiteInfo data = template.getForObject("https://picsum.photos/id" + imgNum + "/200/300", WebsiteInfo.class);
		return data;
	}

	@GetMapping("/picsum-images")
	public void getPicsumImages(@RequestParam("ids") String ids) throws FileNotFoundException {
		String[] idArr = ids.split(":");
		List<Integer> idList = Arrays.stream(idArr).map(id -> Integer.parseInt(id)).collect(Collectors.toList());

		for(Integer id : idList) {
			byte[] data = this.restTemplate.getForObject("https://picsum.photos/id/" + id + "/200/300", byte[].class);
			FileOutputStream fos = new FileOutputStream(new File(IMAGE_FOLDER_PATH + "/" + id + ".png"));
		}

	}

	@GetMapping("/test")
	public String showTest() {
		return "API is working";
	}

}
