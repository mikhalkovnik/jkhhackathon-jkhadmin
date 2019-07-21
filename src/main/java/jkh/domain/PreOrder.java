package jkh.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class PreOrder {
	
	private String            id;
	private String            userphone;
	private String            userid;
	private String            objectid;
	private String            adress;
	private int               priority;
	private int               tipe;
	private String            info;
	private String            status;
	private String            stage;
	private long              time;
	private ArrayList<String> photourls;
}
