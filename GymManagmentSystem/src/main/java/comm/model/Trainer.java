package comm.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Trainer {

	private int tid;
	private String name;
	private int age;
	private String gender;
	private long mobileNo;
	private int experienceYear;
	private String address;
	private double salary;
	
	public Trainer() {
		
	}
	public Trainer(String name, int age,int tid, String gender, long mobileNo, int experienceYear, String address, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.tid=tid;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.experienceYear = experienceYear;
		this.address = address;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getExperienceYear() {
		return experienceYear;
	}
	public void setExperienceYear(int experienceYear) {
		this.experienceYear = experienceYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "Trainer [tid=" + tid + ", name=" + name + ", age=" + age + ", gender=" + gender + ", mobileNo="
				+ mobileNo + ", experienceYear=" + experienceYear + ", address=" + address + ", salary=" + salary + "]";
	}
	
	
	
}
