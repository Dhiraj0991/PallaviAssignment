package lib;

import java.util.ArrayList;

public class TestUtil
{
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcelModule7()
	{
		ArrayList<Object[]> module7Data= new ArrayList<Object[]>();
		
		try
		{
			reader= new Xls_Reader("F:\\JAVA\\Selenium\\PallaviAssignment\\Pallavi_Assignment_Validation_Object_Repository_New.xls");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("Module7"); rowNum++)
		{
			String TestCase=reader.getCellData("Module7", "TestCase", rowNum);
			String Keyword=reader.getCellData("Module7", "Keyword", rowNum);
			String ObjectName=reader.getCellData("Module7", "ObjectName", rowNum);
			String ObjectType=reader.getCellData("Module7", "ObjectType", rowNum);
			String Value=reader.getCellData("Module7", "Value", rowNum);
			
			Object ob[]= {TestCase, Keyword, ObjectName, ObjectType, Value};
			module7Data.add(ob);

		}
		
		return module7Data;
	}

	
	
	public static ArrayList<Object[]> getDataFromExcelModule9_1()
	{
		ArrayList<Object[]> module9_1Data= new ArrayList<Object[]>();
		
		try
		{
			reader= new Xls_Reader("F:\\JAVA\\Selenium\\PallaviAssignment\\Pallavi_Assignment_Validation_Object_Repository_New.xls");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("Module9_1"); rowNum++)
		{
			String TestCase=reader.getCellData("Module9_1", "TestCase", rowNum);
			String Keyword=reader.getCellData("Module9_1", "Keyword", rowNum);
			String ObjectName=reader.getCellData("Module9_1", "ObjectName", rowNum);
			String ObjectType=reader.getCellData("Module9_1", "ObjectType", rowNum);
			String Value=reader.getCellData("Module9_1", "Value", rowNum);
			
			Object ob[]= {TestCase, Keyword, ObjectName, ObjectType, Value};
			module9_1Data.add(ob);

		}
		
		return module9_1Data;
	}
	
	
	
	
	public static ArrayList<Object[]> getDataFromExcelModule9_2()
	{
		ArrayList<Object[]> module9_2Data= new ArrayList<Object[]>();
		
		try
		{
			reader= new Xls_Reader("F:\\JAVA\\Selenium\\PallaviAssignment\\Pallavi_Assignment_Validation_Object_Repository.xls");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("Module9_2"); rowNum++)
		{
			String TestCase=reader.getCellData("Module9_2", "TestCase", rowNum);
			String Keyword=reader.getCellData("Module9_2", "Keyword", rowNum);
			String ObjectName=reader.getCellData("Module9_2", "ObjectName", rowNum);
			String ObjectType=reader.getCellData("Module9_2", "ObjectType", rowNum);
			String Value=reader.getCellData("Module9_2", "Value", rowNum);
			
			Object ob[]= {TestCase, Keyword, ObjectName, ObjectType, Value};
			module9_2Data.add(ob);

		}
		
		return module9_2Data;
	}
	
	public static ArrayList<Object[]> getDataFromExcelModule10()
	{
		ArrayList<Object[]> module10Data= new ArrayList<Object[]>();
		
		try
		{
			reader= new Xls_Reader("F:\\JAVA\\Selenium\\PallaviAssignment\\Pallavi_Assignment_Validation_Object_Repository.xls");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("Module10"); rowNum++)
		{
			String TestCase=reader.getCellData("Module10", "TestCase", rowNum);
			String Keyword=reader.getCellData("Module10", "Keyword", rowNum);
			String ObjectName=reader.getCellData("Module10", "ObjectName", rowNum);
			String ObjectType=reader.getCellData("Module10", "ObjectType", rowNum);
			String Value=reader.getCellData("Module10", "Value", rowNum);
			
			Object ob[]= {TestCase, Keyword, ObjectName, ObjectType, Value};
			module10Data.add(ob);

		}
		
		return module10Data;
	}

}
