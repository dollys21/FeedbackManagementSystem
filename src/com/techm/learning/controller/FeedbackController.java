package com.techm.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.techm.learning.exception.LPException;
import com.techm.learning.model.LPFeedback;
import com.techm.learning.service.ApplicationService;

/**
 * @author:DollyShaw
 *
 * @contact:DS00337934@TECHMAHINDRA.COM
 */

@Controller
public class FeedbackController {

	@Autowired
	private ApplicationService applicationService;
	
	

	@RequestMapping(value = "feedback", method = RequestMethod.GET)
	public ModelAndView getFeedbackView(Model model) {
		System.out.println("inside GET method");
		return getFeedbackPage();
	}

	@RequestMapping(value = "/manager/feedback", method = RequestMethod.GET)
	public ModelAndView getManagerFeedbackView() {
		return getFeedbackPage();
	}

	private ModelAndView getFeedbackPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("feedback");
		return mv;
	}

	@RequestMapping(value = "feedback", method = RequestMethod.POST)
	private String captureFeedback(@ModelAttribute("feedbackModel") LPFeedback lPFeedback,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "error";
		}
		
		
		System.out.println("inside POST method");
		System.out.println(lPFeedback.toString());
		
		
		
		model.addAttribute("feedbackModel", lPFeedback);
	
			try {
				applicationService.captureFeedback(lPFeedback);
			} catch (LPException e) {
				System.out.println(e.getErrMsg());
			}
		
	

		return "success";
	}

}
