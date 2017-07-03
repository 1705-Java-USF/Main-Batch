<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <div class="message-container">
    	<span class="message">
    		<%if(request.getAttribute("message") != null){ %>
    		<%=request.getAttribute("message") %>
    		<%} %>
    	</span>
    </div>