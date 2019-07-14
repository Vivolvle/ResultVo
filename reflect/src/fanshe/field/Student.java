package fanshe.field;
 
public class Student {
	public Student(){
		
	}
	//**********×Ö¶Î*************//
	public String name;
	protected int age;
	char sex;
	private String phoneNum;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex
				+ ", phoneNum=" + phoneNum + "]";
	}
	
	
}