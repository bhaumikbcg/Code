
public class Student {
	public final static int NumOfTests = 2;
	protected String name;
	protected int test[];
	protected String CourseGrade;
	/**Default Constructor*/
	public Student()
	{
		this("No Name");
	}
	public Student(String studentName)
	{
		name = studentName; 
		test = new int[NumOfTests]; 
		CourseGrade = "****"; 
	}
	public void setTestScore(int testNumber, int testScore)
	{
		test[testNumber-1] = testScore; 
	}
	/**Saves the test score in the array*/ 
		/**Parameterized Constructor*/
}
