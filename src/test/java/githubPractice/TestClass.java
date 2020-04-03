package githubPractice;

import org.testng.annotations.Test;

public class TestClass
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
