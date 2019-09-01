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
public class ActivityGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int idActivityGroup;
	private String description;
	private int sequence;
	private int minimumScore;
	private int maximumScore;
	
	@Override
    public boolean equals(final Object object) {
        if (!(object instanceof ActivityGroup)) {
            return false;
        }else if(this.getClass() == ((ActivityGroup)object).getClass()){
        	return true;
        }else{
        	return false;
        }
    }

}
