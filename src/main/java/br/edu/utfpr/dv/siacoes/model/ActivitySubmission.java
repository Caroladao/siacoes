package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.util.Date;

import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ActivitySubmission implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum ActivityFeedback{
		NONE(0), APPROVED(1), DISAPPROVED(2);

		private final int value;
		ActivityFeedback(int value){
			this.value = value;
		}

		public int getValue(){
			return value;
		}

		public static ActivityFeedback valueOf(int value){
			for(ActivityFeedback p : ActivityFeedback.values()){
				if(p.getValue() == value){
					return p;
				}
			}

			return null;
		}

	}

	@EqualsAndHashCode.Include
	private int idActivitySubmission;
	private User student;
	private User feedbackUser;
	private Department department;
	private Activity activity;
	private int semester;
	private int year;
	private Date submissionDate;
	private transient byte[] file;
	private double amount;
	private ActivityFeedback feedback;
	private Date feedbackDate;
	private double validatedAmount;
	private String comments;
	private String description;
	private int stage;
	private String feedbackReason;

	public double getScore() {
		double score = 0;

		if(feedback == ActivityFeedback.APPROVED) {
			if(activity.getUnit().isFillAmount()) {
				score = activity.getScore() * validatedAmount;
			} else {
				score = activity.getScore();
			}

			if((activity.getMaximumInSemester() > 0) && (score > activity.getMaximumInSemester())) {
				score = activity.getMaximumInSemester();
			}
		}

		return score;
	}

}
