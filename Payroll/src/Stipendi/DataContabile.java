package Stipendi;

public class DataContabile {
	private int day;
	private int month;
	private int year;

	public DataContabile(int d, int m, int y) {
		if (y < 1900 || m < 0 || m > 11 || d < 0) {
			def();
		}
		year = y - 1900;
		month = m;
		if (m == 10 || m == 3 || m == 5 || m == 8) {
			if (d <= 30) {
				day = d;
			} else {
				def();
			}
		} else if (m == 1) {
			if (d <= 28)
				day = d;
			else
				def();
		} else {
			if (d <= 31) {
				day = d;
			} else {
				def();
			}
		}

	}

	private void def() {
		day = 1;
		month = 1;
		year = 0;
	}

	public DataContabile aggiungiGiorni(int numeroGiorni) {
		int result = day + numeroGiorni;
		if (month == 10 || month == 3 || month == 5 || month == 8) {
			if (result > 30)
				return toggleEndMonth(result, 30);
		} else if (month == 1) {
			if (result > 28)
				return toggleEndMonth(result, 28);
		} else if (month == 11) {
			if (result > 31) {
				DataContabile nuovo = new DataContabile(result - 31, 0,
						year + 1901);
				return nuovo;
			}
		} else if (result > 31)
			return toggleEndMonth(result, 31);

		DataContabile nuovo = new DataContabile(result, month, year+1900);
		return nuovo;
	}

	private DataContabile toggleEndMonth(int resultSum, int end) {
		DataContabile nuovo;

		nuovo = new DataContabile(resultSum - end, month + 1, year+1900);
		return nuovo;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public boolean equals(Object obj) {
		if (obj instanceof DataContabile) {
			DataContabile dc = (DataContabile) obj;
			return dc.getDay() == day && dc.getMonth() == month
					&& dc.getYear() == year;
		}
		return false;
	}
	
	public String toString(){
		return day+" "+(month+1)+" "+(year+1900);
	}
}
