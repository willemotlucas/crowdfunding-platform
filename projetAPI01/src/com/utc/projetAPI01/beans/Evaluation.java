package com.utc.projetAPI01.beans;

import java.sql.Date;
import java.util.Set;

public class Evaluation extends APhase{
	
	private Set<EvaluationScore> evaluations;
	
	public Set<EvaluationScore> getEvaluations() {
		return evaluations;
	}
	
	public void setEvaluations(Set<EvaluationScore> evaluations) {
		this.evaluations = evaluations;
	}
}
