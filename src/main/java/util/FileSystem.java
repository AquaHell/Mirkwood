package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileSystem {
	public static StringBuilder readFile(Class cs, String file) throws IOException {
		InputStream in = cs.getClassLoader().getResourceAsStream(file); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
//	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append("\n");
	        }

	        return stringBuilder;
	    } finally {
	        reader.close();
	    }
	}

}
