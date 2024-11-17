package comm.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Member {
	private int mid;
	private String name;
	private long mobileNo;
	private String gender;
	private int age;
	private String membershipType;

	public Member() {

	}

	public Member(String name, long mobileNo, String gender, int age,int mid, String membershipType) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.age = age;
		this.mid=mid;
		this.membershipType = membershipType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 5 && age <=100) {
			this.age = age;
		} else {
			new IllegalArgumentException("Starting Age is 4 and Maximum Age is 100 are Allowed to join");
			System.out.println("We Wish you match the Eligiblity Criteria ");
		}

	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", mobileNo=" + mobileNo + ", gender=" + gender + ", age="
				+ age + ", membershipType=" + membershipType + "]";
	}

	
	
}
