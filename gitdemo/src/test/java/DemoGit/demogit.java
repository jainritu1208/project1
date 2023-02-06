package DemoGit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

public class demogit {

	@Test
	public static void tsetup() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		System.out.println("this is gti demo Project **************************");
		System.out.println("this is gti demo Project **************************");

		System.out.println("this is gti demo Project **************************");

	}
}
