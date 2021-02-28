/**
 * 
 */
package com.demo.survey.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class HelpNowException extends Exception{
    
	private static final long serialVersionUID = 1L;
    
	public HelpNowException()
    {
          super();
    }
    public HelpNowException(String message)
    {
          super(message);
    }
}


