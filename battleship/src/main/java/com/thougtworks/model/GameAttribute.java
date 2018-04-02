package com.thougtworks.model;

import com.thougtworks.exception.IllegalValueException;

public interface GameAttribute {

	void validate() throws IllegalValueException;
}
