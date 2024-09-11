package com.shift4.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FileUploadPurpose {

	DISPUTE_EVIDENCE("dispute_evidence"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	FileUploadPurpose(String value) {
		this.value = value;
	}

	@JsonCreator
	public static FileUploadPurpose fromValue(@JsonProperty("value") String value) {
		if (value == null) {
			return null;
		}
		for (FileUploadPurpose purpose : values()) {
			if (purpose.value.equalsIgnoreCase(value)) {
				return purpose;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
