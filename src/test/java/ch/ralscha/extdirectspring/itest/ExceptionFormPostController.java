/**
 * Copyright 2010-2011 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.ralscha.extdirectspring.itest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectResponse;
import ch.ralscha.extdirectspring.bean.ExtDirectResponseBuilder;

@Controller
@RequestMapping("/exceptionTest")
public class ExceptionFormPostController {

	@ExtDirectMethod(value = ExtDirectMethodType.FORM_POST, group = "itest_upload")
	@RequestMapping(value = "/throwIt", method = RequestMethod.POST)
	@ResponseBody
	public ExtDirectResponse throwAException(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request);

		throw new NullPointerException("a null pointer");


		//return builder.build();
	}

	//todo this only works with the new spring 3.1
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public ExtDirectResponse handleException(HttpServletRequest request) {
//		ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request);
//		builder.unsuccessful();
//	
//		ExtDirectResponse response = builder.build();
//		response.setType("exception");
//		response.setMessage("Server Error");
//		return response;
//	}
	
}