package githubPractice;

import org.testng.annotations.Test;

public class TestClass3
{

	@Test
	public void name()
	{
		
		String str="Y";
		
		if (str.contentEquals("Y"))
		{
			System.out.println("Hello");
		}
		
		else {
			System.out.println("Bye");
		}
		
	}
}
