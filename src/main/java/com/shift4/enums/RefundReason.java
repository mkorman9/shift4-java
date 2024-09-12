package com.shift4.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RefundReason {

	FRAUDULENT("fraudulent"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	RefundReason(String value) {
		this.value = value;
	}

	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static RefundReason fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (RefundReason interval : values()) {
			if (interval.value.equalsIgnoreCase(value)) {
				return interval;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
