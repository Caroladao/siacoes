package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ActivityValidationReport implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int idActivity;
	private String description;
	private int group;
	private int submitted;
	private int validated;

	public float getPercentageValidate() {
		BigDecimal bd = new BigDecimal(((float)validated / submitted) * 100);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.floatValue();
	}

}
