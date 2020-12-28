package com.spring.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.HRInterviewScheduler;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.HRInterviewSchedulerRepo;
import com.spring.cg.repo.InterviewSchedulerRepo;
import com.spring.cg.repo.PanelMemberRepo;
import com.spring.cg.util.HRInterviewSchedulerUtil;

@Service
public class HRInterviewSchedulerServiceImpl implements HRInterviewSchedulerService {
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;

	@Autowired
	HRInterviewSchedulerRepo hrinterviewSchedulerRepo;

	@Autowired
	private CandidateRepo candidateRepo;

	@Autowired
	private PanelMemberRepo panelMemberRepo;

	@Override
	public HRInterviewScheduler createNewHRInterviewSchedule(int candidateid, int panelid,
			HRInterviewScheduler hrinterviewscheduler) throws PanelMemberNotFoundException {
		Optional<CandidateEntity> candidateEntityOp = candidateRepo.findById(candidateid);

		Optional<PanelMemberEntity> panelMemberEntityOp = Optional.of(panelMemberRepo.findById(panelid));
		List<InterviewSchedulerEntity> interviewschedulerOp = interviewSchedulerRepo.findAll();

		CandidateEntity candidateEntity = candidateEntityOp.get();

		PanelMemberEntity panelMemberEntity = panelMemberEntityOp.get();

		for (InterviewSchedulerEntity ise : interviewschedulerOp) {
			// CandidateEntity id = ise.getCandidateid();
			System.out.println(candidateid ==ise.getCandidate().getCandidateid());
			
			if (candidateid ==ise.getCandidate().getCandidateid()) {
			
				InterviewSchedulerEntity ie = ise;
                System.out.println(ie);
				if (panelMemberEntityOp.isPresent() && ie.getTechrating() > 0) {
					{
						HRInterviewSchedulerEntity ise1 = HRInterviewSchedulerUtil
								.convertHRInterviewSchedulerIntoHRInterviewSchedulerEntityForScheduleInterview(
										hrinterviewscheduler, candidateEntity, panelMemberEntity);
						System.out.println(ise);
						HRInterviewSchedulerEntity hrinterviewschedulerEntity = hrinterviewSchedulerRepo.save(ise1);
						return HRInterviewSchedulerUtil
								.convertHRInterviewSchedulerEntityIntoHRInterviewSchedulerForScheduleInterview(
										hrinterviewschedulerEntity);
					}
				} else {
					System.out.println("Technical interview of candidate is not scheduled!");
					throw new PanelMemberNotFoundException("No such panel member with panelid " + panelid);
				}
			}

		}
		return null;
	}
}
