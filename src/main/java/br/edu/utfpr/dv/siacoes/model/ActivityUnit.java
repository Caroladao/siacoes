package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ActivityUnit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int idActivityUnit;
	private String description;
	private boolean fillAmount;
	private String amountDescription;

	public boolean isFillAmount() {
		return fillAmount;
	}

	@Override
    public boolean equals(final Object object) {
        if (!(object instanceof ActivityUnit)) {
            return false;
        }else if(idActivityUnit == ((ActivityUnit)object).idActivityUnit){
        	return true;
        }else{
        	return false;
        }
    }

}
