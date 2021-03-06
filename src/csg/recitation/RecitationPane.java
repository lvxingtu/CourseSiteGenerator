package csg.recitation;

import csg.CSGApp;
import csg.CSGAppProp;
import csg.data.CSGData;
import csg.data.RecitationData;
import csg.ta.TeachingAssistant;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import properties_manager.PropertiesManager;

public class RecitationPane extends VBox {
	CSGApp app;
	RecitationController controller;

	Label header, addEditL, sectionL, instructor, dayTime, location, supervisingLabel1, supervisingLabel2;
	Button remove, addUp, clear;
	TableView<Recitation> table;
	TextField sectionTF, instructorTF, dayTimeTF, locationTF;
	ComboBox<TeachingAssistant> comboBox1, comboBox2;
	VBox inputBox;
	HBox headerBox;
	GridPane inputGrid;
	TableColumn<Recitation, String> sectionCol, instructorCol,
			dayTimeCol, locationCol, ta1Col, ta2Col;


	public RecitationPane(CSGApp initApp) {
		app = initApp;

		PropertiesManager props = PropertiesManager.getPropertiesManager();
		RecitationData data = ((CSGData) app.getDataComponent()).getRecitationData();

		header = new Label(props.getProperty(CSGAppProp.R_HEADER_TEXT));
		headerBox = new HBox();
		headerBox.getChildren().add(header);
		remove = app.getGUI().initChildButton(headerBox, CSGAppProp.REMOVE_ICON.toString(),
				CSGAppProp.REMOVE_TOOLTIP.toString(), false);

		table = new TableView<>(data.getRecitations());
		sectionCol = new TableColumn<>(props.getProperty(CSGAppProp.R_SECTION_TEXT));
		sectionCol.setCellValueFactory(
				new PropertyValueFactory<>("section")
		);
		instructorCol = new TableColumn<>(props.getProperty(CSGAppProp.R_INSTRUCTOR_TEXT));
		instructorCol.setCellValueFactory(
				new PropertyValueFactory<>("instructor")
		);
		dayTimeCol = new TableColumn<>(props.getProperty(CSGAppProp.R_DAY_TIME_TEXT));
		dayTimeCol.setCellValueFactory(
				new PropertyValueFactory<>("day")
		);
		locationCol = new TableColumn<>(props.getProperty(CSGAppProp.R_LOCATION_TEXT));
		locationCol.setCellValueFactory(
				new PropertyValueFactory<>("location")
		);
		ta1Col = new TableColumn<>(props.getProperty(CSGAppProp.R_TA_TEXT));
		ta1Col.setCellValueFactory(
				new PropertyValueFactory<>("ta1")
		);
		ta2Col = new TableColumn<>(props.getProperty(CSGAppProp.R_TA_TEXT));
		ta2Col.setCellValueFactory(
				new PropertyValueFactory<>("ta2")
		);
		table.getColumns().addAll(sectionCol, instructorCol, dayTimeCol, locationCol, ta1Col, ta2Col);

		inputBox = new VBox();
		addEditL = new Label(props.getProperty(CSGAppProp.ADD_EDIT_TEXT));
		sectionL = new Label(props.getProperty(CSGAppProp.R_SECTION_TEXT) + ":");
		sectionTF = new TextField();
		instructor = new Label(props.getProperty(CSGAppProp.R_INSTRUCTOR_TEXT) + ":");
		instructorTF = new TextField();
		dayTime = new Label(props.getProperty(CSGAppProp.R_DAY_TIME_TEXT) + ":");
		dayTimeTF = new TextField();
		location = new Label(props.getProperty(CSGAppProp.R_LOCATION_TEXT) + ":");
		locationTF = new TextField();
		supervisingLabel1 = new Label(props.getProperty(CSGAppProp.R_SUP_TA_TEXT) + ":");
		supervisingLabel2 = new Label(props.getProperty(CSGAppProp.R_SUP_TA_TEXT) + ":");
		comboBox1 = new ComboBox<>(((CSGData) app.getDataComponent()).getTAData().getTeachingAssistants());
		comboBox2 = new ComboBox<>(((CSGData) app.getDataComponent()).getTAData().getTeachingAssistants());
		addUp = new Button(props.getProperty(CSGAppProp.ADD_UP_TEXT));
		clear = new Button(props.getProperty(CSGAppProp.CLEAR_TEXT));

		inputGrid = new GridPane();
		inputGrid.addColumn(0, sectionL, instructor, dayTime, location, supervisingLabel1, supervisingLabel2, addUp);
		inputGrid.addColumn(1, sectionTF, instructorTF, dayTimeTF, locationTF, comboBox1, comboBox2, clear);

		inputBox.getChildren().addAll(addEditL, inputGrid);

		this.getChildren().addAll(headerBox, table, inputBox);

		controller = new RecitationController(initApp);

		clear.setOnAction(e ->{
			dayTimeTF.clear();
			instructorTF.clear();
			sectionTF.clear();
			locationTF.clear();
			comboBox1.getSelectionModel().clearSelection();
			comboBox2.getSelectionModel().clearSelection();
			table.getSelectionModel().clearSelection();
		});

		addUp.setOnAction(e -> controller.handleAddUp());
		remove.setOnAction(e -> controller.handleRemove());
		table.setOnMouseClicked(e -> controller.handleTableClick());
	}

	public Label getHeader() {
		return header;
	}

	public Label getAddEditL() {
		return addEditL;
	}

	public Label getSectionL() {
		return sectionL;
	}

	public Label getInstructor() {
		return instructor;
	}

	public Label getDayTime() {
		return dayTime;
	}

	public Label getLocation() {
		return location;
	}

	public Label getSupervisingLabel1() {
		return supervisingLabel1;
	}

	public Label getSupervisingLabel2() {
		return supervisingLabel2;
	}

	public Button getRemove() {
		return remove;
	}

	public Button getAddUp() {
		return addUp;
	}

	public Button getClear() {
		return clear;
	}

	public TableView<Recitation> getTable() {
		return table;
	}

	public TextField getSectionTF() {
		return sectionTF;
	}

	public TextField getInstructorTF() {
		return instructorTF;
	}

	public TextField getDayTimeTF() {
		return dayTimeTF;
	}

	public TextField getLocationTF() {
		return locationTF;
	}

	public ComboBox<TeachingAssistant> getComboBox1() {
		return comboBox1;
	}

	public ComboBox<TeachingAssistant> getComboBox2() {
		return comboBox2;
	}

	public VBox getInputBox() {
		return inputBox;
	}

	public HBox getHeaderBox() {
		return headerBox;
	}

	public GridPane getInputGrid() {
		return inputGrid;
	}

	public TableColumn<Recitation, String> getSectionCol() {
		return sectionCol;
	}

	public TableColumn<Recitation, String> getInstructorCol() {
		return instructorCol;
	}

	public TableColumn<Recitation, String> getDayTimeCol() {
		return dayTimeCol;
	}

	public TableColumn<Recitation, String> getLocationCol() {
		return locationCol;
	}

	public TableColumn<Recitation, String> getTa1Col() {
		return ta1Col;
	}

	public TableColumn<Recitation, String> getTa2Col() {
		return ta2Col;
	}

	public void resetWorkspace() {
		clear.fire();
	}

	public void reloadWorkspace() {
	}
}
