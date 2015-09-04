package br.com.danese.model;

import java.io.Serializable;

public interface BaseModel<PK extends Serializable> extends Serializable {

	PK getId();
	void setId(PK id);

}