package test.controller;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.ApiParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import test.domain.UserT;
import test.service.IUserService;

@Api(value = "UserController", tags = { "好玩" })
@Controller
public class UserController {
	@Resource
	private IUserService userService;
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@ResponseBody
	@ApiOperation(value = "play1", httpMethod = "GET")
	@RequestMapping(value = "/show",method = RequestMethod.GET)  
	public String toIndex(@ApiParam(required=true,value="用户ID",name="userId")@RequestParam(value="userId")Integer id){
		int userId = id;
		UserT user = this.userService.getUserById(userId);
		logger.info(JSON.toJSONString(user)+"[hello]");

		return JSON.toJSONString(user).replace("\\", "");
	}
	

}
