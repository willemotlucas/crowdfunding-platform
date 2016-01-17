package com.utc.projetAPI01.beans;

import java.util.Date;
import java.util.Set;

public class Evaluation extends APhase{
	
	private Set<EvaluationScore> evaluations;
	
	public Evaluation(Date date, PhaseContext phaseContext) {
		super(date, phaseContext);
	}
	
	public Evaluation()
	{
		super();
	}

	public Set<EvaluationScore> getEvaluations() {
		return evaluations;
	}
	
	public void setEvaluations(Set<EvaluationScore> evaluations) {
		this.evaluations = evaluations;
	}
}
