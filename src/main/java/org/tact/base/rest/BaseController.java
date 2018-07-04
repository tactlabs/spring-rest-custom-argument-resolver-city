package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.resolver.CityArgument;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/base/
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");       
        
        return (T) map;
    }
    
    /**
     * 
     * @param request
     * @param response
     * @param city
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/city/resolver
     * 		http://localhost:1878/base/city/resolver?city=madras
     */
    @GetMapping(value = "/city/resolver")
	public <T> T testCity(HttpServletRequest request,
			HttpServletResponse response, @CityArgument String city) {

		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		resultMap.put("ok", "ok");
		resultMap.put("ip", city);

        return (T) resultMap;
	}
}
