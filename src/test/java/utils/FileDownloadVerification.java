package utils;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class FileDownloadVerification {

	public static boolean isFileDownloaded(String expectedFileName, String fileExtension, int timeOut) throws IOException 
	{
	    // Download Folder Path
	    String folderName = "C:\\Users\\ADMIN\\Downloads";
	    		//System.getProperty("user.dir") + File.separator + "downloads";
	    
			
	    // Array to Store List of Files in Directory
	    File[] listOfFiles;
			
	    // Store File Name
	    String fileName;   
	        
	    //  Consider file is not downloaded
	    boolean fileDownloaded = false;      
	        
	    // capture time before looking for files in directory
	    // last modified time of previous files will always less than start time
	    // this is basically to ignore previous downloaded files
	    long startTime = Instant.now().toEpochMilli();
	        
	    // Time to wait for download to finish
	    long waitTime = startTime + timeOut;
	       
	    
	    System.out.println( "folderName: "+folderName);
	    // while current time is less than wait time
	    while (Instant.now().toEpochMilli() < waitTime) 
	    {			
	        // get all the files of the folder
	        listOfFiles = new File(folderName).listFiles();
	            
	        // iterate through each file
	        for (File file : listOfFiles) 
	        {
	            // get the name of the current file
	            fileName = file.getName().toLowerCase();
	        	//System.out.println("inside if fileName : "+fileName);
	           
	            // condition 1 - Last Modified Time > Start Time
	            // condition 2 - till the time file is completely downloaded extension will be crdownload
	            // Condition 3 - Current File name contains expected Text
	            // Condition 4 - Current File name contains expected extension
	            if (file.lastModified() > startTime && !fileName.contains("crdownload") && 
	            		fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase())) 
	           {
	               // File Found
	               fileDownloaded = true;
	               break;
	           }
	        }
	        // File Found Break While Loop
	         if (fileDownloaded) 
	             break;
	    }
	    // File Not Found
	    return fileDownloaded;
	}
}
