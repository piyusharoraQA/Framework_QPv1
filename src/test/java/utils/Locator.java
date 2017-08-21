package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;


public class Locator {

    String filepathcomp;
    String matchingLine = "";
    String line = "";
    BufferedReader br;

    public Locator(String filepathcomp) {
		this.filepathcomp=filepathcomp;
		
	}

	public String[] getElement(String elementName) throws IOException {
        
		br = new BufferedReader(new FileReader(filepathcomp));
        while ((line = br.readLine()) != null) {
            if (line.split(": ", 3)[0].equalsIgnoreCase(elementName)) {
                matchingLine = line;
                break;
            }

        }
        br.close();
        String S[] = new String[2];
        S[0] = matchingLine.split(": ")[1];
        S[1] = matchingLine.split(": ")[2];
        return S;
    }

    public  By Locator_type(String elementname) throws IOException {
        String s[] = getElement(elementname);
        System.out.println("getElement function : " + s[0] + " is - " + s[1]);
        switch (locatorT.valueOf(s[0])) {
            case id:

                return By.id(s[1]);
            case xpath:

                return By.xpath(s[1]);
            case name:

                return By.name(s[1]);
            case classname:

                return By.className(s[1]);
            case css:

                return By.cssSelector(s[1]);
            case linktext:

                return By.linkText(s[1]);
            case tagName:
                
                return By.tagName(s[1]);
            default:

                return By.id(s[0]);

        }
    }

    

}
