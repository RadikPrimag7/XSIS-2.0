package com.ngexsis.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ngexsis.model.DokumenModel;
import com.ngexsis.repository.DokumenRepo;
import com.ngexsis.model.UploadFileModel;

@Controller
public class DokumenController {

	@Autowired
	private DokumenRepo repo;
	
	@RequestMapping(value = "/dokumen")
	public String home() {
		
		return "dokumen/index";
	}
	
	//untuk nampilin halaman awal yaitu halaman index,
	//ada button tambah utk diklik,
	//dan ngeliat data string yg udah di store ke database
	@RequestMapping(value = "/dokumen", method = RequestMethod.GET)
	public String homePage(Model model) {
		
		//membuat object list mengenai data project kemudian diisi dari
		//object repo dengan method findAll
		List<DokumenModel> data = repo.findAll();
		
		//mengirim variabel listData, value nya diisi dari object data
		model.addAttribute("listData", data);
		
		return "dokumen/index";
	}
 
	//handling utk view tambah di url localhost:port/tambah
	@RequestMapping(value = "/dokumen/tambah")
	public String tambah() {
		
		//menampilkan view src/resources/templates/project
		return "/dokumen/tambah";
	}
	
	// GET: Show upload form page.
	@RequestMapping(value = "/dokumen/tambah", method = RequestMethod.GET)
	public String uploadOneFileHandler(Model model) {
		
		UploadFileModel myUploadForm = new UploadFileModel();
		model.addAttribute("myUploadForm", myUploadForm);
		
		return "/dokumen/tambah";
	}
	
	// POST: Do Upload
	@RequestMapping(value = "/dokumen/tambah", method = RequestMethod.POST)
	public String uploadOneFileHandlerPOST(HttpServletRequest request, //
		Model model, //
		@ModelAttribute("myUploadForm") UploadFileModel myUploadForm) {
		
		return this.doUpload(request, model, myUploadForm);
	}
	
	//handling utk nyimpen data string ke database
	@RequestMapping(value = "/dokumen/simpan", method = RequestMethod.POST)
	public String simpan(@ModelAttribute DokumenModel item) {
		
		//mengirim item agar disimpan ke database
		repo.save(item);
		
		//redirect kembali ke halaman index dokumen
		return "redirect:/dokumen";
	}
	
	//=================================================================//
	
	// GET: Show upload form page.
	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
	public String uploadMultiFileHandler(Model model) {
		
		UploadFileModel myUploadForm = new UploadFileModel();
		model.addAttribute("myUploadForm", myUploadForm);
		
		return "uploadMultiFile";
	}
 
	// POST: Do Upload
	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	public String uploadMultiFileHandlerPOST(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("myUploadForm") UploadFileModel myUploadForm) {
		
		return this.doUpload(request, model, myUploadForm);
	}
	
	//=================================================================//
	
	private String doUpload(HttpServletRequest request, Model model, //
			UploadFileModel myUploadForm) {
		
		String description = myUploadForm.getDescription();
		System.out.println("Description: " + description);
		
		// Root Directory.
		String uploadRootPath = request.getServletContext().getRealPath("upload");
		System.out.println("uploadRootPath=" + uploadRootPath);
		
		File uploadRootDir = new File(uploadRootPath);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		
		MultipartFile[] fileDatas = myUploadForm.getFileDatas();
		//
		List<File> uploadedFiles = new ArrayList<File>();
		List<String> failedFiles = new ArrayList<String>();
		
		for (MultipartFile fileData : fileDatas) {
			
			// Client File Name
			String name = fileData.getOriginalFilename();
			System.out.println("Client File Name = " + name);
			
			if (name != null && name.length() > 0) {
				try {
					// Create the file at server
					File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
					
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(fileData.getBytes());
					stream.close();
					//
					
					uploadedFiles.add(serverFile);
					System.out.println("Write file: " + serverFile);
				} catch (Exception e) {
					System.out.println("Error Write file: " + name);
					failedFiles.add(name);
				}
			}
		}
	
		model.addAttribute("description", description);
		model.addAttribute("uploadedFiles", uploadedFiles);
		model.addAttribute("failedFiles", failedFiles);
		return "redirect:/dokumen";
	}
	
	
	//request utk mengubah/edit data berdasarkan id spesifik
	@RequestMapping(value = "/dokumen/ubah/{id}", method = RequestMethod.GET)
	public String ubah(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau diubah dalam DokumenModel dgn id spesifik
		DokumenModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari object item
		model.addAttribute("data", item);
		
		return "dokumen/ubah";
	}
	
	//request halaman hapus yg ada di url localhost:port/dokumen/hapus
	//dgn berdasarkan id spesifik, dgn menggunakan method get
	@RequestMapping(value = "/dokumen/hapus/{id}", method = RequestMethod.GET)
	public String hapus(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau dihapus dalam DokumenModel dgn id spesifik
		DokumenModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari dari object item
		model.addAttribute("data", item);
		
		return "dokumen/hapus";
	}
	
	//request delete data
	@RequestMapping(value = "/dokumen/hapus", method = RequestMethod.POST)
	public String hapus(@ModelAttribute DokumenModel item) {
		
		//mengirim item agar dapat di delete dari database
		item.setDelete(true);
		repo.save(item);
		
		return "redirect:/dokumen";
	}
}
