package pb;

public class Telephone {
	private long telephoneNum;
	
	public Telephone() {
		
	}

	public long getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(long telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	public static String printPhone(Long phoneNum) {
	    StringBuilder sb = new StringBuilder(15);
	    StringBuilder temp = new StringBuilder(phoneNum.toString());

	    while (temp.length() < 10)
	        temp.insert(0, "0");

	    char[] chars = temp.toString().toCharArray();

	    sb.append("(");
	    for (int i = 0; i < chars.length; i++) {
	        if (i == 3)
	            sb.append(") ");
	        else if (i == 6)
	            sb.append("-");
	        sb.append(chars[i]);
	    }

	    return sb.toString();
	}
	
	@Override
	public String toString() {
		return "Telephone number: " + telephoneNum ;
	}
}
