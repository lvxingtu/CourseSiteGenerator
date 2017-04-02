package csg;

public enum CSGAppProp {
	// FOR SIMPLE OK/CANCEL DIALOG BOXES
	OK_PROMPT,
	CANCEL_PROMPT,

	// THESE ARE FOR TEXT PARTICULAR TO THE APP'S WORKSPACE CONTROLS
	TAS_HEADER_TEXT,
	NAME_COLUMN_TEXT,
	EMAIL_COLUMN_TEXT,
	NAME_PROMPT_TEXT,
	EMAIL_PROMPT_TEXT,
	ADD_BUTTON_TEXT,
	OFFICE_HOURS_SUBHEADER,
	OFFICE_HOURS_TABLE_HEADERS,
	DAYS_OF_WEEK,

	// ADDED TEXT
	REMOVE_ICON,
	REMOVE_TOOLTIP,

	// THESE ARE FOR ERROR MESSAGES PARTICULAR TO THE APP
	MISSING_TA_NAME_TITLE,
	MISSING_TA_NAME_MESSAGE,
	MISSING_TA_EMAIL_TITLE,
	MISSING_TA_EMAIL_MESSAGE,
	TA_NAME_AND_EMAIL_NOT_UNIQUE_TITLE,
	TA_NAME_AND_EMAIL_NOT_UNIQUE_MESSAGE,
	TA_INVALID_EMAIL_TITLE,
	TA_INVALID_EMAIL_MESSAGE
}