package com.baxter.idc.service;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baxter.idc.entity.ProductEntity;
import com.baxter.idc.exception.SpringException;
import com.baxter.idc.interfa.MasterDataService;
import com.baxter.idc.masterDataDocument.AttributeType;
import com.baxter.idc.masterDataDocument.EPCISMasterDataBodyType;
import com.baxter.idc.masterDataDocument.EPCISMasterDataDocumentType;
import com.baxter.idc.masterDataDocument.ObjectFactory;
import com.baxter.idc.masterDataDocument.VocabularyElementListType;
import com.baxter.idc.masterDataDocument.VocabularyElementType;
import com.baxter.idc.masterDataDocument.VocabularyListType;
import com.baxter.idc.masterDataDocument.VocabularyType;
import com.baxter.idc.masterDataManager.ImportMasterData;
import com.baxter.idc.masterDataManager.ImportMasterDataResult;

@Service
@Transactional
public class MasterDataServiceImpl implements MasterDataService {

	@Override
	public List<ProductEntity> saveMasterDataProducts(String filePath, String extension) {
		
		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		productList = getDataFromExcel(filePath, extension);
		
		return productList;
		
	}

	private List<ProductEntity> getDataFromExcel(String filePath, String ext) {
		
		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		FileInputStream fis = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/YYYY HH:mm:ss a");
		
		try {
			fis = new FileInputStream(filePath);
	         // Using XSSF for xlsx format, for xls use HSSF
	        Workbook workbook = null;
	        if ( ext.equals("xls")) {
	        	workbook = new HSSFWorkbook(fis);
	        } else if ( ext.equals("xlsx")) {
	        	workbook = new XSSFWorkbook(fis);
	        } else {
	        	throw new SpringException("Invalid Excel Sheet","100");
	        }
	        	        
	        XSSFSheet sheet = (XSSFSheet) workbook.getSheet("ProductMasterData");	        
			Row firstRow=sheet.getRow(0);	       
			System.out.println("sheet.getLastRowNum();      "+sheet.getLastRowNum());

			for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) 
			{				
				Row row=sheet.getRow(rowNum);
				ProductEntity product=new ProductEntity();	        	
				Iterator<Cell> cellIterator=row.iterator();	        	
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();	                
					//String fieldName=firstRow.getCell(cell.getColumnIndex()).getStringCellValue();

					switch (cell.getColumnIndex()) 
					{	                	
					case 1:	                
						product.setProductCode(cell.getStringCellValue());
						//System.out.println(cell.getColumnIndex()+"    "+cell.getStringCellValue());
						break;
					case 4:
						//Drug Name
						product.setDrugName(cell.getStringCellValue());
						//System.out.println(cell.getColumnIndex()+"    "+cell.getStringCellValue());
						break;
					case 5:
						//Manufacture
						product.setManufacturer(cell.getStringCellValue());
						//System.out.println(cell.getColumnIndex()+"    "+cell.getStringCellValue());
						break;
					case 6:
						//Dosage Form
						product.setDosageForm(cell.getStringCellValue());
						//System.out.println(cell.getColumnIndex()+"    "+cell.getStringCellValue());
						break;
					case 7:
						//Dosage Strength
						product.setStrength(cell.getStringCellValue());
						//System.out.println(cell.getColumnIndex()+"    "+cell.getStringCellValue());
						break;
					case 8:
						//Package Type
						product.setPackageType(cell.getStringCellValue());
						//System.out.println(cell.getColumnIndex()+"    "+cell.getStringCellValue());
						break;
					case 9:
						//NDC
						product.setNdc(cell.getStringCellValue());
						//System.out.println(cell.getColumnIndex()+"    "+cell.getStringCellValue());
						break;
					case 10:
						//ShortItemNumber     
						product.setShortItemNumber(((int)cell.getNumericCellValue()));
						break;
					case 11:
						//LongItemNumber
						product.setLongItemNumber(cell.getStringCellValue());
					case 12:
						//Description
						product.setDescription(cell.getStringCellValue());
					case 13:
						//License Number
					case 14:
						//GoverningCountryRegulation
					case 15:
						//Other fields
					case 16:
						//Is it CMO
					case 17:
						//Requesting Site
					}	                
				}
				productList.add(product);	        	
			}

			System.out.println("productList.size()    "+productList.size());

			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		createXMLFile(productList);
		return productList;
		
}

// Create XML File from the List using SOAP Elements	
public void createXMLFile(List<ProductEntity> productList)
{
			
		// ****** Show XML File ******
		
		try {
		
		JAXBContext jc= JAXBContext.newInstance("com.baxter.idc.masterDataDocument");
		ObjectFactory objectFactory =new ObjectFactory();
		
		JAXBContext jc1 = JAXBContext.newInstance("com.baxter.idc.masterDataManager");
		com.baxter.idc.masterDataManager.ObjectFactory factory = new com.baxter.idc.masterDataManager.ObjectFactory();
		
		ImportMasterData importMasterData = factory.createImportMasterData();		
		

		EPCISMasterDataDocumentType epcisMdataDocument = objectFactory.createEPCISMasterDataDocumentType();
		EPCISMasterDataBodyType epcisMasterDataBody=objectFactory.createEPCISMasterDataBodyType();

		VocabularyListType vocabularyList=objectFactory.createVocabularyListType();

		VocabularyType vocabularyType=objectFactory.createVocabularyType();

		vocabularyType.setType("urn:epcglobal:epcis:vtype:PedigreeProduct");

		vocabularyList.getVocabulary().add(vocabularyType);

		VocabularyElementListType vocabularyElementListType =objectFactory.createVocabularyElementListType();

		for (Iterator<ProductEntity> iterator = productList.iterator(); iterator.hasNext();) 
		{
			ProductEntity pe=iterator.next();
			VocabularyElementType vocabularyElementType=objectFactory.createVocabularyElementType();

			// Changed by Sonal Gupta
			String identifierProductCode = pe.getProductCode();
			identifierProductCode = identifierProductCode.substring(1);
						
			vocabularyElementType.setId(identifierProductCode);
            // End
			
			
			AttributeType attributeTypeGTIN=objectFactory.createAttributeType();
			attributeTypeGTIN.setId("urn:epcglobal:product:GTIN");
			attributeTypeGTIN.setValue(pe.getProductCode());
			
			AttributeType attributeTypeDrugName=objectFactory.createAttributeType();
			attributeTypeDrugName.setId("urn:epcglobal:product:drugName");
			attributeTypeDrugName.setValue(pe.getDrugName());
			
			AttributeType attributeTypeManufacturer=objectFactory.createAttributeType();
			attributeTypeManufacturer.setId("urn:epcglobal:product:manufacturer");
			attributeTypeManufacturer.setValue(pe.getManufacturer());
			
			AttributeType attributeTypeDosageForm=objectFactory.createAttributeType();
			attributeTypeDosageForm.setId("urn:epcglobal:product:dosageForm");
			attributeTypeDosageForm.setValue(pe.getDosageForm());
			
			AttributeType attributeTypeStrength=objectFactory.createAttributeType();
			attributeTypeStrength.setId("urn:epcglobal:product:strength");
			attributeTypeStrength.setValue(pe.getStrength());
			
			AttributeType attributeTypeContainerSize=objectFactory.createAttributeType();
			attributeTypeContainerSize.setId("urn:epcglobal:product:containerSize");
			if((pe.getContainerSize()) == null || pe.getContainerSize().isEmpty())
			{
				attributeTypeContainerSize.setValue("N/A");
			}	
			else{
			attributeTypeContainerSize.setValue(pe.getContainerSize());}
			
			//AttributeType attributeType=objectFactory.createAttributeType();

			AttributeType attributeTypePackageType=objectFactory.createAttributeType();
			attributeTypePackageType.setId("urn:epcglobal:product:packageType");
			attributeTypePackageType.setValue(pe.getPackageType());
			
			AttributeType attributeTypeNDC=objectFactory.createAttributeType();
			attributeTypeNDC.setId("urn:epcglobal:product:ndc");
			attributeTypeNDC.setValue(pe.getNdc());
			
			AttributeType attributeTypeShortItemNumber=objectFactory.createAttributeType();
			attributeTypeShortItemNumber.setId("urn:epcglobal:product:shortItemNumber");
			attributeTypeShortItemNumber.setValue(String.valueOf(pe.getShortItemNumber()));
			
			AttributeType attributeTypeLongItemNumber=objectFactory.createAttributeType();
			attributeTypeLongItemNumber.setId("urn:epcglobal:product:longItemNumber");
			attributeTypeLongItemNumber.setValue(pe.getLongItemNumber());
			
			AttributeType attributeTypeDescription=objectFactory.createAttributeType();
			attributeTypeDescription.setId("urn:epcglobal:product:description");
			attributeTypeDescription.setValue(pe.getDescription());
			
			vocabularyElementType.getAttribute().add(attributeTypeGTIN);
			vocabularyElementType.getAttribute().add(attributeTypeDrugName);
			vocabularyElementType.getAttribute().add(attributeTypeContainerSize);
			vocabularyElementType.getAttribute().add(attributeTypeDescription);
			vocabularyElementType.getAttribute().add(attributeTypeDosageForm);
			vocabularyElementType.getAttribute().add(attributeTypeLongItemNumber);
			vocabularyElementType.getAttribute().add(attributeTypeManufacturer);
			vocabularyElementType.getAttribute().add(attributeTypeNDC);
			vocabularyElementType.getAttribute().add(attributeTypePackageType);
			vocabularyElementType.getAttribute().add(attributeTypeShortItemNumber);
			vocabularyElementType.getAttribute().add(attributeTypeStrength);
			
			vocabularyElementListType.getVocabularyElement().add(vocabularyElementType);

		}
		vocabularyType.setVocabularyElementList(vocabularyElementListType);		
		epcisMasterDataBody.setVocabularyList(vocabularyList);

		epcisMdataDocument.setEPCISBody(epcisMasterDataBody);
		
		importMasterData.setData(epcisMdataDocument);
		
		
		//Marshaller importMasterDataMarshaller=jc1.createMarshaller();
		//importMasterDataMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		//ImportMasterData myRootElement1 = factory.createImportMasterData();
		//importMasterDataMarshaller.marshal(importMasterData, System.out);
		
		//importMasterDataMarshaller.marshal(importMasterData, System.out);
		System.out.println("DONE DONE DONE ::::::::");
				

		Marshaller epcisMasterDataDocumentMarshaller=jc.createMarshaller();
		epcisMasterDataDocumentMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		JAXBElement<EPCISMasterDataDocumentType> myRootElement = objectFactory.createEPCISMasterDataDocument(epcisMdataDocument);
		epcisMasterDataDocumentMarshaller.marshal(myRootElement, System.out);
		
		//return null;
		
	} 
	catch (JAXBException e)
	{
		throw new SpringException("Exception while displaying XML File", e.getMessage());	
	}
 }

}	
