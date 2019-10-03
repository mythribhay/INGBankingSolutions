package com.hcl.ibs.util;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.ibs.dto.UploadFileResponseDto;
import com.hcl.ibs.entity.Product;
import com.hcl.ibs.entity.ProductCategory;
import com.hcl.ibs.repository.ProductCategoryRepository;
import com.hcl.ibs.repository.ProductRepository;

@Component
public class ExcelImportToDB {

	private static final Logger logger = LogManager.getLogger(ExcelImportToDB.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public UploadFileResponseDto loadDataToDB(MultipartFile file) {

		UploadFileResponseDto response = new UploadFileResponseDto();
		FileInputStream input = null;
		XSSFSheet sheet = null;
		XSSFWorkbook workbook = null;
		try {

			workbook = new XSSFWorkbook(file.getInputStream());

			sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
			//	Iterator<Cell> cellIterator = row.cellIterator();
				String prodDesc = "";
				String productName = "";

				String productCategory = row.getCell(0).getStringCellValue();
				productName = row.getCell(1).getStringCellValue();
				prodDesc = row.getCell(2).getStringCellValue();
				System.out.println(productCategory);
				System.out.println(productName);
				System.out.println(prodDesc);

				Product product = new Product();
				ProductCategory productCategoryRepo = new ProductCategory();


				productCategoryRepo.setProductCategoryName(productCategory);
				ProductCategory productCategory2 = null;
				Optional<List<ProductCategory>> productCategory1 = productCategoryRepository
						.findByProductCategoryName(productCategory);
				if (!productCategory1.isPresent()) {
					productCategory2 = productCategoryRepository.save(productCategoryRepo);
				} else {
					productCategory2 = productCategory1.get().get(0);

				}

				product.setProductDescription(prodDesc);
				product.setProductName(productName);
				product.setCategoryId(productCategory2.getProductCategoryId());

				Optional<List<Product>> product1 = productRepository.findByproductName(productName);
				if (product1.isPresent()) {
					product.setProductId(product1.get().get(0).getProductId());
				}
				productRepository.save(product);

				response.setMessage("success");
				response.setStatusCode(200);

			}

		} catch (Exception e) {
			logger.error(this.getClass().getName() + " loadDataToDB : " + e.getMessage());
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (input != null) {
					input.close();
				}
				sheet = null;
			} catch (Exception e) {
				logger.error(this.getClass().getName() + " loadDataToDB finally block : " + e.getMessage());
			}

		}
		return response;
	}

}
