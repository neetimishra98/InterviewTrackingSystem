package com.spring.cg.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.InterviewSchedulerRepo;
import com.spring.cg.repo.PanelMemberRepo;
import com.spring.cg.util.InterviewSchedulerUtil;


@Service
public class InterviewSchedulerServiceImpl implements InterviewSchedulerService {
	
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;
	
	@Autowired
	private CandidateRepo candidateRepo;
	

	@Autowired
	private PanelMemberRepo panelMemberRepo;
	
	//for creating interviewscheduler
	
	@Override
	public InterviewScheduler createNewTechInterviewSchedule(int candidateid, int panelid,
			InterviewScheduler interviewscheduler) throws CandidateNotFoundException {

		Optional<PanelMemberEntity> panelMemberEntityOp = Optional.ofNullable(panelMemberRepo.findById(panelid));
		Optional<CandidateEntity> candidateEntityOp = candidateRepo.findById(candidateid);
		
		if(candidateEntityOp.isPresent())
		{
			CandidateEntity candidateEntity = candidateEntityOp.get();
			PanelMemberEntity panelMemberEntity=panelMemberEntityOp.get();
			InterviewSchedulerEntity ise = 
					InterviewSchedulerUtil.convertTechInterviewSchedulerIntoTechInterviewSchedulerEntityForScheduleInterview(interviewscheduler, candidateEntity, panelMemberEntity);
			InterviewSchedulerEntity interviewschedulerEntity =interviewSchedulerRepo.save(ise);
		
			return InterviewSchedulerUtil.convertTechInterviewSchedulerEntityIntoTechInterviewSchedulerForScheduleInterview(interviewschedulerEntity);
		}
		else {
			throw new CandidateNotFoundException("No such candidate with candidateID "+candidateid);
		}
	}
	
 /*	444
	@Override
	public List<InterviewScheduler> getAllInterviewSchedule() {
		
		return InterviewSchedulerUtil.convertInterviewSchedulerEntityListIntoInterviewSchedulerList(interviewschedulerRepo.findAll());
	}
*/
	@Override
	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException {
	
		Optional<InterviewSchedulerEntity> interviewschedulerEntityOp = interviewSchedulerRepo.findById(interviewid);
		
		if(interviewschedulerEntityOp.isPresent())
		{
			InterviewSchedulerEntity interviewschedulerEntity = interviewschedulerEntityOp.get();
			interviewschedulerEntity.setTechrating(interviewscheduler.getTechrating());
			interviewschedulerEntity.setFinalstatus(interviewscheduler.getFinalstatus());
			
			interviewschedulerEntity = interviewSchedulerRepo.save(interviewschedulerEntity);
			return InterviewSchedulerUtil.convertInterviewSchedulerEntityIntoInterviewScheduler(interviewschedulerEntity);
		}
		else
			throw new InterviewSchedulerNotFoundException("No such candidate with InterviewID "+interviewid);
	}
	
	@Override
	public boolean deleteById(int interviewid)throws InterviewSchedulerNotFoundException {
		
		Optional<InterviewSchedulerEntity> opinterviewschedulerEntity = interviewSchedulerRepo.findById(interviewid);
		InterviewScheduler interviewscheduler = null;
		if(opinterviewschedulerEntity.isPresent())
		{	
			interviewSchedulerRepo.deleteById(interviewid);
			return true;
		}
		else
		{
			throw new InterviewSchedulerNotFoundException("No such candidate with InterviewID "+interviewid);
		}
	}
	
	
	
	//to view all interview members for tech
		@Override
		public List<InterviewScheduler> viewAllInterviewMembersForTech() throws InterviewSchedulerNotFoundException{
			List<InterviewSchedulerEntity> interviewSchedulerEntity=interviewSchedulerRepo.findAll();
			List<InterviewScheduler> membersList=new ArrayList<InterviewScheduler>();
			
			for(InterviewSchedulerEntity membersEntity: interviewSchedulerEntity) {
				membersList.add(new InterviewScheduler(membersEntity.getInterviewid(),
						membersEntity.getTechrating(), membersEntity.getLocation(),
						membersEntity.getFinalstatus()));
			}
			return membersList;
		}
	
	
		//to view candidate information using interview id for tech
				@Override
				public CandidateEntity viewInterviewMembersForTech(int interviewid) throws InterviewSchedulerNotFoundException {
					InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(interviewid);
					CandidateEntity candidateEntity=interviewSchedulerEntity.getCandidate();
					return candidateEntity;
					
				}
	
	
	
	//for giving techrating
	@Override
	public InterviewSchedulerEntity giveTechRating(int interviewid) {
		
		double techrating=0;
		int min=0;
		int max=10;
			 techrating=Math.random()*(max-min+1)+min;
		
		InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(interviewid);
		if(interviewSchedulerEntity.getTechrating()==0) {
			interviewSchedulerEntity.setTechrating((int)techrating);
			interviewSchedulerEntity.setFinalstatus("Techcomplete");
		}
		return interviewSchedulerRepo.save(interviewSchedulerEntity);
    }


		

	}

