
public class bdedhiaUGStudent extends Student{
	String name;
	int age;
	int average;
	bdedhiaUGStudent(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
	public int getAverage()
	{
		average = (test[0]+test[1])/2;
		return average;
	}
	public String getCourseGrade()
	{
		if (average > 80)
			CourseGrade = "PASS";
		else
			CourseGrade = "FAIL";
		return CourseGrade;
	}
}
