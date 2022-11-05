package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropData {
	
	public static Properties getPropData(String filepath) {
		
		Properties prop= new Properties();
		
		try {
			FileInputStream file= new FileInputStream(filepath);
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
