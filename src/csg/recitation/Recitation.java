package csg.recitation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recitation {
	StringProperty section, instructor, day, location, ta1, ta2;

	public Recitation(String section, String instructor, String day,
	                  String location, String ta1, String ta2) {
		this.section = new SimpleStringProperty(section);
		this.instructor = new SimpleStringProperty(instructor);
		this.day = new SimpleStringProperty(day);
		this.location = new SimpleStringProperty(location);
		this.ta1 = new SimpleStringProperty(ta1);
		this.ta2 = new SimpleStringProperty(ta2);
	}

	public String getSection() {
		return section.get();
	}

	public String getInstructor() {
		return instructor.get();
	}

	public String getDay() {
		return day.get();
	}

	public String getLocation() {
		return location.get();
	}

	public String getTa1() {
		return ta1.get();
	}

	public String getTa2() {
		return ta2.get();
	}

	public void setTa1(String ta1) {
		this.ta1.set(ta1);
	}

	public void setTa2(String ta2) {
		this.ta2.set(ta2);
	}

	public void setAll(Recitation all) {
		section.set(all.getSection());
		instructor.set(all.getInstructor());
		day.set(all.getDay());
		location.set(all.getLocation());
		ta1.set(all.getTa1());
		ta2.set(all.getTa2());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Recitation))
			return false;

		Recitation that = (Recitation) obj;

		return getDay().equals(that.getDay()) && getSection().equals(that.getSection())
				&& getLocation().equals(that.getLocation()) && getTa1().equals(that.getTa1())
				&& getTa2().equals(that.getTa2()) && getInstructor().equals(getInstructor());
	}
}
