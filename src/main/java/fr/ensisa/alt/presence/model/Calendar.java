package fr.ensisa.alt.presence.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.*;

@XmlRootElement
public class Calendar {
	@XmlElement(required = true)
	private final TreeMap<String, String> calendars = new TreeMap<>();
	private String SelectedCalendar;

	public void addCalendar(String label, String url) {
		calendars.put(label, url);
	}
	public String getUrl(String label) {
		return calendars.get(label);
	}
	public void rmCalendar(String calToDel) {
		calendars.remove(calToDel);
	}
	public void editCalendar(String selectedItem, String newLabel, String newUrl) {
		this.rmCalendar(selectedItem);
		this.addCalendar(newLabel, newUrl);
	}

	public ListProperty<String> calendarsNameProperty() {
		return new SimpleListProperty<>(FXCollections.observableList(new ArrayList<>(calendars.keySet())));
	}

	private final ListProperty<Integer> months = new SimpleListProperty<>(FXCollections.observableArrayList(List.of(1,2,3,4,5,6,7,8,9,10,11,12)));
	public ListProperty<Integer> monthsProperty() {
		return months;
	}

	private final IntegerProperty currMonth = new SimpleIntegerProperty();
	public IntegerProperty currMonthProperty() {
		return currMonth;
	}
	public Integer getCurrMonthProperty() {
		return currMonth.get();
	}

	public Calendar() {
		this.currMonth.set(java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1);
	}


	public void setSelectedCalendar(String key) {
		this.SelectedCalendar = key;
	}
	public String getSelectedCalendar() {
		return SelectedCalendar;
	}
}
