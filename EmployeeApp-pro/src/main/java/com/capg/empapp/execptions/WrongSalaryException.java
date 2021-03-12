package com.capg.empapp.execptions;

import java.util.Arrays;

public class WrongSalaryException extends Exception {

	@Override
	public String toString() {
		return "WrongSalaryException [getMessage()=" + getMessage() + ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", toString()=" + super.toString() + ", fillInStackTrace()="
				+ fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace()) + ", getSuppressed()="
				+ Arrays.toString(getSuppressed()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
