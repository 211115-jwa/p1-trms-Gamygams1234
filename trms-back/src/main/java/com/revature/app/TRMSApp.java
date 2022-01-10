package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import io.javalin.plugin.json.JsonMapper;

import static io.javalin.apibuilder.ApiBuilder.*;


import java.io.IOException;
import com.revature.controllers.EmployeesController;
import com.revature.controllers.RequestsController;
import com.revature.controllers.UsersController;
import com.revature.controllers.ReviewsController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TRMSApp {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
		});
		
		app.start();

//		app.before("/requests/*", ctx -> {
//			if (!ctx.method().equals("OPTIONS")) {
//				ctx.header("Access-Control-Allow-Headers", "Token");
//			    ctx.header("Access-Control-Expose-Headers", "Token");
//				
//				String token = ctx.header("Token");
//				if (token==null) ctx.status(HttpCode.UNAUTHORIZED);
//			}
//		});
		
//		
		
		app.routes(() -> {
			path("/employees", () -> {
				get(EmployeesController::viewAllEmployees);

				path("/{empId}", () -> {
					get(EmployeesController::viewEmployeeById);

				});
			});
			path("/requests", () -> {
				get(RequestsController::viewAllRequests);
				post(RequestsController::submitReimbursementRequest);
				path("/requestor/{id}", () -> {
					get(RequestsController::getRequestsByRequestor);
				});
			});
			
			path("/approve/{id}", () -> {// /approve/{id}
				get(ReviewsController::ApproveRequest);
			});
				path("/reject/{id}", () -> {//?
					get(ReviewsController::RejectRequest);

				                  
			});
			
			
			path("/users", () -> {
				post(UsersController::register); // 
				path("/auth", () -> {
					post(UsersController::logIn); 
				});
				path("/{id}", () -> {
					get(UsersController::getUserById); 
					put(UsersController::updateUser); 
					path("/auth", () -> {
						get(UsersController::checkLogin); 
					});
				});
			});
		
		});
	}
//	class JacksonMapper implements JsonMapper {
//	    ObjectMapper om = new ObjectMapper();
//
//	    {
//	        om.findAndRegisterModules();
//	    }
//
//	    @Override
//	    public String toJsonString(Object obj) {
//	        try {
//	            return om.writeValueAsString(obj);
//	        } catch (JsonProcessingException e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }
//	    @Override
//	    public <T> T fromJsonString(String json, Class<T> targetClass) {
//	        try {
//	            return om.readValue(json, targetClass);
//	        } catch (JsonProcessingException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        return null;
//	    }
//
//	}
	}
