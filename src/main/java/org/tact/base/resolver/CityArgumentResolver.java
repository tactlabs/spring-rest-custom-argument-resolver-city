package org.tact.base.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CityArgumentResolver implements HandlerMethodArgumentResolver {
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.getParameterAnnotation(CityArgument.class) != null && String.class == parameter.getParameterType())
			return true;
		else 
			return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		String cityParam = webRequest.getParameter("city");
		if ( cityParam == null || cityParam.isEmpty() ){
			throw new Exception("City Parameter Missing");
		}
		
		return getCityNewName(cityParam);
	}
	
	public static String getCityNewName(String city) throws Exception {
		
		if(city == null || city.isEmpty())
        	throw new Exception("City is Empty");

		if(city.equalsIgnoreCase("madras")){
			return "chennai";
		}
		
		if(city.equalsIgnoreCase("bombay")){
			return "mumbai";
		}
		
		if(city.equalsIgnoreCase("bangalore")){
			return "bengaluru";
		}
         
        return city; 
    }
}

