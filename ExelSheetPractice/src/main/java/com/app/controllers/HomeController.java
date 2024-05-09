package com.app.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.models.User;
import com.app.services.ExcelService;

@Controller
public class HomeController {

	public static Long count = 0L;

	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	@GetMapping("/two")
	public String secondPage() {
		return "second";
	}

	@GetMapping("/three")
	public String thirdPage() {
		return "third";
	}
	@GetMapping("/four")
	public String forthPage() {
		return "fourth";
	}
	@GetMapping("/five")
	public String fifthPage() {
		return "fifth";
	}
	// C:\Users\adityak\Desktop

	public static final Logger logger = org.slf4j.LoggerFactory.getLogger(HomeController.class);
	@ResponseBody
	@PostMapping("/uploadExcelFile")
	public ModelAndView uploadFile(Model model, @RequestParam("file") CommonsMultipartFile file, HttpSession s)
			throws IOException {
		logger.trace("1. This is the trace message from the home controller");
		logger.debug("2. This is the debug message from the home controller");
		logger.info("1. This is the info message from the home controller");
		logger.warn("1. This is the warn message from the home controller");
		logger.error("1. This is the error message from the home controller");
		System.out.println("----------------------->" + file.getName());
		System.out.println("----------------------->" + file.getOriginalFilename());
		System.out.println("----------------------->" + file.getSize());
		System.out.println("----------------------->" + file.getContentType());
		System.out.println("----------------------->" + file.getStorageDescription());

		byte[] data = file.getBytes();
		String path = s.getServletContext().getRealPath("/Files/") + file.getOriginalFilename();
		System.out.println("----------------------->" + path);
		ExcelService eServ = new ExcelService();
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();

			eServ.readExcelAndSaveInDB(path);
			return new ModelAndView("index");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		} catch (IOException e) {

			e.printStackTrace();
			return new ModelAndView("error");
		}
	}
	
	@SuppressWarnings("finally")
	@ResponseBody
	@PostMapping("/uploadZipFile")
	 public ModelAndView handleFileUpload(Model model, @RequestParam("file") CommonsMultipartFile file, HttpSession s)
				throws IOException  {

	        byte[] data = file.getBytes();
			String path = s.getServletContext().getRealPath("/Files/") + file.getOriginalFilename();
			System.out.println("----------------------->" + path);
			ExcelService eServ = new ExcelService();
			try {
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(data);
				fos.close();

				return new ModelAndView("index");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ModelAndView("error");
			} catch (IOException e) {

				e.printStackTrace();
				return new ModelAndView("error");
			}
	    }
	@ResponseBody
	@GetMapping("/submit")
	public String saveEmployee(@RequestParam("data") String allData, HttpServletResponse response) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data");
		int rowNum = 0;

		// Define cell style for the header row
		CellStyle headerCellStyle = workbook.createCellStyle();
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// Create the header row which merged across three columns
		Row headerRow = sheet.createRow(rowNum++);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("User Information");
		headerCell.setCellStyle(headerCellStyle);
		// (0, 0, 0, 2) specifies the range of cells from A1 to C1
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1)); // (0,0)1st row 1st col top left to (0,2)1st row 2nd
																	// col ie top right

		// Create the column headers
		Row columnHeaderRow = sheet.createRow(rowNum++);
		String[] columnHeaders = { "Name", "Address" };
		int colNum = 0;
		for (String columnHeader : columnHeaders) {
			Cell columnHeaderCell = columnHeaderRow.createCell(colNum++);
			columnHeaderCell.setCellValue(columnHeader);
			columnHeaderCell.setCellStyle(headerCellStyle);
		}

		// Define cell style for data cells
		CellStyle dataCellStyle = workbook.createCellStyle();
		dataCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		dataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		dataCellStyle.setBorderBottom(BorderStyle.MEDIUM);
		dataCellStyle.setBorderLeft(BorderStyle.MEDIUM);
		dataCellStyle.setBorderRight(BorderStyle.MEDIUM);
		dataCellStyle.setBorderTop(BorderStyle.MEDIUM);

		// Add data to the sheet
		String[] text = allData.split(",");
		for (int i = 0; i < text.length; i += 2) {
			Row row = sheet.createRow(rowNum++);
			colNum = 0;
			Cell cell = row.createCell(colNum++);
			cell.setCellValue(text[i]);
			cell.setCellStyle(dataCellStyle);
			cell = row.createCell(colNum++);
			cell.setCellValue(text[i + 1]);
			cell.setCellStyle(dataCellStyle);
			System.out.println(text[i] + "   " + text[i + 1]);
		}

		// Set response headers
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-disposition", "attachment; filename=test.xls");

		// Write workbook to response output stream
		workbook.write(response.getOutputStream());
		System.out.println();
		workbook.close();
		return "index";
	}

	@ResponseBody
	@PostMapping("/form")
	public ResponseEntity<byte[]> register(Model model, @RequestParam("file") CommonsMultipartFile file, HttpSession s) {
		System.out.println("inside Form");
		byte[] data = file.getBytes();
		String path = s.getServletContext().getRealPath("/Files/") + file.getOriginalFilename();
		System.out.println("----------------------->" + path);
		ExcelService eServ = new ExcelService();
		byte[] pdfBytes = generatePDF(eServ.readExcelAndReturnList(path));
		if (pdfBytes != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "information.pdf");
			headers.setContentLength(pdfBytes.length);
			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private byte[] generatePDF(ArrayList<User> users) {
		try (PDDocument document = new PDDocument()) {
			int count=0;
			while(count<users.size()) {
				
			PDPage page = new PDPage();
			document.addPage(page);

			try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
				contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
				contentStream.beginText();
				contentStream.newLineAtOffset(50, 750);
				contentStream.newLine();
				contentStream.showText("Candidate Information:");
				contentStream.newLineAtOffset(0, -20);
				contentStream.newLine();
				while(count<users.size()){
					contentStream.newLine();
				contentStream.showText("Name: " + users.get(count).getName());
				contentStream.newLineAtOffset(0, -20);
				contentStream.showText("City: " + users.get(count).getCity());
				contentStream.newLineAtOffset(0, -20);
				count++;
				if(count%3==0 && count!=0)break;
				}

				contentStream.endText();
			}
			}
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			document.save(byteArrayOutputStream);

			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@PostMapping("/zip")
    public ModelAndView zipAndDownload(@RequestParam("file") MultipartFile file, HttpSession s) {
		System.out.println("inside zip upload controller");
        if (file.isEmpty()) {
            return new ModelAndView("error").addObject("message", "Please select a folder to zip.");
        }

        String folderPath = s.getServletContext().getRealPath("/Files/");
        System.out.println(folderPath);
        File folderToZip = new File(folderPath);

        if (!folderToZip.exists() || !folderToZip.isDirectory()) {
            return new ModelAndView("error").addObject("message", "Invalid folder path.");
        }

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(baos);
            zipFolder(folderToZip, folderToZip.getName(), zos);
            zos.close();

            
            return new ModelAndView("index");
//                    .addObject("fileName", "files.zip")
//                    .addObject("fileData", baos.toByteArray());
        } catch (IOException e) {
            return new ModelAndView("error").addObject("message", "Error zipping folder: " + e.getMessage());
        }
    }

	
	
	   private void zipFolder(File folderToZip, String folderName, ZipOutputStream zos) throws IOException {
	        for (File file : folderToZip.listFiles()) {
	            if (file.isDirectory()) {
	                zipFolder(file, folderName + File.separator + file.getName(), zos);
	            } else {
	                FileInputStream fis = new FileInputStream(file);
	                ZipEntry zipEntry = new ZipEntry(folderName + File.separator + file.getName());
	                zos.putNextEntry(zipEntry);
	                byte[] bytes = new byte[1024];
	                int length;
	                while ((length = fis.read(bytes)) >= 0) {
	                    zos.write(bytes, 0, length);
	                }
	                fis.close();
	            }
	        }
	   }
	   	
	   @GetMapping("/download/{file}")
	   public void downloadFile(@PathVariable String file,HttpServletResponse response) throws IOException {
		   System.out.println(file);
		   Path path = Paths.get("C:\\Users\\adityak\\Desktop\\sts\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ExelSheetPractice\\Files\\"+file);
		   byte[] data = Files.readAllBytes(path);
		   
	        response.setContentType("application/zip");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + file + "\"");
	        response.getOutputStream().write(data);
	        response.getOutputStream().flush();
	        response.getOutputStream().close();
	   }
	   
}
