package org.encuestame.core.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.encuestame.core.exception.EnMeExpcetion;
import org.encuestame.core.mail.MailServiceImpl;
import org.encuestame.core.persistence.dao.CatStateDaoImp;
import org.encuestame.core.persistence.dao.QuestionDaoImp;
import org.encuestame.core.persistence.dao.SurveyDaoImp;
import org.encuestame.core.persistence.pojo.Questions;
import org.encuestame.core.persistence.pojo.QuestionsPatron;
import org.encuestame.web.beans.survey.UnitPatternBean;
import org.encuestame.web.beans.survey.UnitQuestionBean;

/**
 * encuestame: system online surveys Copyright (C) 2005-2008 encuestame
 * Development Team
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of version 3 of the GNU General Public License as published by the
 * Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 * Id: DataSurvey.java Date: 27/04/2009
 * 
 * @author juanpicado package: org.encuestame.core.service
 * @version 1.0
 */
public class SurveyService extends MasterService implements ISurveyService {

	private MailServiceImpl serviceMail;
	private SurveyDaoImp surveyDaoImp;
	private SecurityService securityService;
	private DataService dataService;
	private QuestionDaoImp questionDaoImp;
	private Log log = LogFactory.getLog(this.getClass());

	public MailServiceImpl getServiceMail() {
		return serviceMail;
	}

	public void setServiceMail(MailServiceImpl serviceMail) {
		this.serviceMail = serviceMail;
	}

	/**
	 * @return the surveyDaoImp
	 */
	public SurveyDaoImp getSurveyDaoImp() {
		return surveyDaoImp;
	}

	/**
	 * @param surveyDaoImp
	 *            the surveyDaoImp to set
	 */
	public void setSurveyDaoImp(SurveyDaoImp surveyDaoImp) {
		this.surveyDaoImp = surveyDaoImp;
	}

	/**
	 * @return the securityService
	 */
	private SecurityService getSecurityService() {
		return securityService;
	}

	/**
	 * @param securityService
	 *            the securityService to set
	 */
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	/**
	 * @return the dataService
	 */
	private DataService getDataService() {
		return dataService;
	}

	/**
	 * @param dataService
	 *            the dataService to set
	 */
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	/**
	 * @return the questionDaoImp
	 */
	public QuestionDaoImp getQuestionDaoImp() {
		return questionDaoImp;
	}

	/**
	 * @param questionDaoImp
	 *            the questionDaoImp to set
	 */
	public void setQuestionDaoImp(QuestionDaoImp questionDaoImp) {
		this.questionDaoImp = questionDaoImp;
	}

	/**
	 * load all questions
	 * 
	 * @return
	 * @throws HibernateException
	 * @throws Exception
	 * @throws EnMeExpcetion
	 */
	public List<UnitQuestionBean> loadAllQuestions() throws HibernateException,
			Exception, EnMeExpcetion {

		List<UnitQuestionBean> listQuestionBean = new LinkedList<UnitQuestionBean>();
		try {
			List<Questions> questionsList = getQuestionDaoImp()
					.loadAllQuestions();
			if (questionsList != null && questionsList.size() > 0) {
				Iterator<Questions> i = questionsList.iterator();
				while (i.hasNext()) {
					Questions questions = (Questions) i.next();
					UnitQuestionBean q = new UnitQuestionBean();
					q.setId(questions.getQid());
					q.setQuestionName(questions.getQuestion());
					q.setIdState(questions.getCatState().getIdState());
					listQuestionBean.add(q);
				}
			}
		} catch (HibernateException e) {
			throw new HibernateException(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return listQuestionBean;
	}

	/**
	 * load pattern info
	 * 
	 * @param unit
	 * @return
	 * @throws EnMeExpcetion
	 */
	public UnitPatternBean loadPatternInfo(UnitPatternBean unit)
			throws EnMeExpcetion, HibernateException {
		log.info("loadPatternInfo init ->"+unit.getId());
		if (unit != null && unit.getId() != null) {
			QuestionsPatron q = getQuestionDaoImp().loadPatternInfo(
					unit.getId());
			log.info("loadPatternInfo QuestionsPatron ->"+q);
			unit.setId(q.getIdPatron());
			unit.setDescripcion(q.getDesQid());
			unit.setLabel(q.getLabelQid());
			unit.setPatronType(q.getTypePatron());
			unit.setTemplate(q.getTemplatePatron());
			// pueden agregar mas datos
			return unit;
		} else {
			throw new EnMeExpcetion("unit is null");
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Collection<UnitPatternBean> loadAllPatrons()
			throws HibernateException, Exception {
		List<UnitPatternBean> listPatronBean = new LinkedList<UnitPatternBean>();
		try {
			List<QuestionsPatron> patronList = getQuestionDaoImp()
					.loadAllQuestionPattern();
			if (patronList != null && patronList.size() > 0) {
				Iterator<QuestionsPatron> i = patronList.iterator();
				while (i.hasNext()) {
					QuestionsPatron patron = (QuestionsPatron) i.next();
					UnitPatternBean p = new UnitPatternBean();
					p.setId(patron.getIdPatron());
					p.setPatronType(patron.getTypePatron());
					listPatronBean.add(p);
				}
			}
		} catch (HibernateException e) {
			throw new HibernateException(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return listPatronBean;
	}

}